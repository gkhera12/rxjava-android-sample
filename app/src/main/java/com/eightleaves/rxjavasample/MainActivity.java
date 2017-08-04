package com.eightleaves.rxjavasample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.eightleaves.rxjavasample.adapter.WorkoutRecyclerViewAdapter;
import com.eightleaves.rxjavasample.api.WorkoutService;
import com.eightleaves.rxjavasample.databinding.ActivityMainBinding;
import com.eightleaves.rxjavasample.entity.WorkoutEntity;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private WorkoutRecyclerViewAdapter mWorkoutAdapter;
    private ActivityMainBinding mBinding;
    private MainViewModel viewModel;

    WorkoutService workoutService;
    private Subscription mWorkoutSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mWorkoutAdapter = new WorkoutRecyclerViewAdapter();
        mBinding.list.setAdapter(mWorkoutAdapter);
        workoutService = ((WorkoutApp)getApplication()).getWorkoutService();
        viewModel = new MainViewModel(workoutService);
        getData();
    }

    private void getData() {
        Observable<List<WorkoutEntity>> workoutObservable =
                Observable.fromCallable(new Callable<List<WorkoutEntity>>() {
            @Override
            public List<WorkoutEntity> call() {
                return viewModel.getWorkouts();
            }
        });

        mWorkoutSubscription = workoutObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<WorkoutEntity>>() {

                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Tag","Error");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<WorkoutEntity> workoutList){
                        mWorkoutAdapter.setWorkoutList(workoutList);
                    }
                });

    }


    @Override
    protected void onDestroy() {
        if (mWorkoutSubscription!= null && !mWorkoutSubscription.isUnsubscribed()) {
            mWorkoutSubscription.unsubscribe();
        }
        super.onDestroy();
    }
}
