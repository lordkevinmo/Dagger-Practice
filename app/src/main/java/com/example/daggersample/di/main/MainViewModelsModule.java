package com.example.daggersample.di.main;

import androidx.lifecycle.ViewModel;

import com.example.daggersample.di.ViewModelKey;
import com.example.daggersample.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);
}
