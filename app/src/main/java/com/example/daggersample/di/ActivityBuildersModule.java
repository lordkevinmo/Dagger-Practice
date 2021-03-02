package com.example.daggersample.di;

import com.example.daggersample.di.auth.AuthModule;
import com.example.daggersample.di.auth.AuthViewModelsModule;
import com.example.daggersample.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class,
            }
    )
    abstract AuthActivity contributeAuthActivity();


}
