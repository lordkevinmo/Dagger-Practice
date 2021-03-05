package com.example.daggersample.di.main;

import com.example.daggersample.network.main.MainAPI;
import com.example.daggersample.ui.main.posts.PostsRecyclerAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @MainScope
    @Provides
    static PostsRecyclerAdapter providePostsAdapter() {
        return new PostsRecyclerAdapter();
    }

    @MainScope
    @Provides
    static MainAPI provideMainAPI(Retrofit retrofit) {
        return retrofit.create(MainAPI.class);
    }
}
