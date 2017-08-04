package com.eightleaves.rxjavasample;


import android.util.Log;

import com.eightleaves.rxjavasample.adapter.WorkoutRecyclerViewAdapter;
import com.eightleaves.rxjavasample.api.WorkoutService;
import com.eightleaves.rxjavasample.entity.WorkoutEntity;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import retrofit2.Call;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel {
    WorkoutService service;
    WorkoutRecyclerViewAdapter workoutAdapter;
    public MainViewModel(WorkoutService service, WorkoutRecyclerViewAdapter workoutAdapter) {
        this.service = service;
        this.workoutAdapter = workoutAdapter;
    }

    public Subscription subscribeForData() {
        Observable<List<WorkoutEntity>> workoutObservable =
                Observable.fromCallable(new Callable<List<WorkoutEntity>>() {
                    @Override
                    public List<WorkoutEntity> call() {
                        return getWorkoutData();
                    }
                });
        Subscription workoutSubscription = workoutObservable
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
                        workoutAdapter.setWorkoutList(workoutList);
                    }
                });
        return workoutSubscription;
    }

    private List<WorkoutEntity> getWorkoutData() {
        Call<List<WorkoutEntity>> call =  service.getWorkouts();
        List<WorkoutEntity> workoutEntities = null;
        try {
            workoutEntities = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workoutEntities;
    }


}
