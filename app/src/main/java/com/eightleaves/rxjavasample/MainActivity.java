package com.eightleaves.rxjavasample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eightleaves.rxjavasample.adapter.WorkoutRecyclerViewAdapter;
import com.eightleaves.rxjavasample.api.WorkoutService;
import com.eightleaves.rxjavasample.databinding.ActivityMainBinding;
import rx.Subscription;

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

        viewModel = new MainViewModel(workoutService, mWorkoutAdapter);
        mWorkoutSubscription = viewModel.subscribeForData();
    }

    @Override
    protected void onDestroy() {
        if (mWorkoutSubscription!= null && !mWorkoutSubscription.isUnsubscribed()) {
            mWorkoutSubscription.unsubscribe();
        }
        super.onDestroy();
    }
}
