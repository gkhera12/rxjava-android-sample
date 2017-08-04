package com.eightleaves.rxjavasample;


import com.eightleaves.rxjavasample.api.WorkoutService;
import com.eightleaves.rxjavasample.entity.WorkoutEntity;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class MainViewModel {
    WorkoutService service;

    public MainViewModel(WorkoutService service) {
        this.service = service;
    }

    public List<WorkoutEntity> getWorkouts() {
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
