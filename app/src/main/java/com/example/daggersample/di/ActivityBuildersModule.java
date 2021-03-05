package com.example.daggersample.di;

import com.example.daggersample.di.auth.AuthModule;
import com.example.daggersample.di.auth.AuthScope;
import com.example.daggersample.di.auth.AuthViewModelsModule;
import com.example.daggersample.di.main.MainFragmentBuildersModule;
import com.example.daggersample.di.main.MainModule;
import com.example.daggersample.di.main.MainScope;
import com.example.daggersample.di.main.MainViewModelsModule;
import com.example.daggersample.ui.auth.AuthActivity;
import com.example.daggersample.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelsModule.class,
                    AuthModule.class,
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuildersModule.class,
                    MainViewModelsModule.class,
                    MainModule.class
            }
    )
    abstract MainActivity contributeMainActivity();
}
