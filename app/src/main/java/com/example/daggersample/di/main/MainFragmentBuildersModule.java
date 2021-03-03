package com.example.daggersample.di.main;

import com.example.daggersample.ui.main.posts.PostsFragments;
import com.example.daggersample.ui.main.profile.ProfileFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract ProfileFragment contributeProfileFragment();

    @ContributesAndroidInjector
    abstract PostsFragments contributePostsFragment();
}
