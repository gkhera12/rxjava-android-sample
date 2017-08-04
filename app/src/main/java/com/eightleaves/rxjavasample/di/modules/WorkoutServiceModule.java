package com.eightleaves.rxjavasample.di.modules;


import com.eightleaves.rxjavasample.api.WorkoutService;
import com.eightleaves.rxjavasample.di.scopes.UserScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module (includes = NetworkModule.class)
public class WorkoutServiceModule {

    @Provides
    @UserScope
    public WorkoutService workoutService(Retrofit workService){
        return  workService.create(WorkoutService.class);
    }

    @Provides
    @UserScope
    public Retrofit retrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("http://demo9254418.mockable.io/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
