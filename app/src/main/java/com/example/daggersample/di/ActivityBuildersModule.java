package com.example.daggersample.di;

import com.example.daggersample.di.auth.AuthModule;
import com.example.daggersample.di.auth.AuthViewModelsModule;
import com.example.daggersample.di.main.MainFragmentBuildersModule;
import com.example.daggersample.di.main.MainViewModelsModule;
import com.example.daggersample.ui.auth.AuthActivity;
import com.example.daggersample.ui.main.MainActivity;

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

    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
            }
    )
    abstract MainActivity contributeMainActivity();
}
