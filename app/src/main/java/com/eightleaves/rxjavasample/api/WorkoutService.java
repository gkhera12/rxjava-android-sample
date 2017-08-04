package com.eightleaves.rxjavasample.api;



import com.eightleaves.rxjavasample.entity.WorkoutEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WorkoutService<ResultType> {
    @GET("fitness-cycling/workouts")
    Call<List<WorkoutEntity>> getWorkouts();
}
