package com.eightleaves.rxjavasample.di.components;

import com.eightleaves.rxjavasample.api.WorkoutService;
import com.eightleaves.rxjavasample.di.modules.WorkoutServiceModule;
import com.eightleaves.rxjavasample.di.scopes.UserScope;

import dagger.Component;

@UserScope
@Component (modules = {WorkoutServiceModule.class})
public interface WorkoutComponent {
        WorkoutService getWorkoutService();
}
