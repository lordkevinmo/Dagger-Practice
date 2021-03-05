package com.example.daggersample.di.auth;

import com.example.daggersample.network.auth.AuthAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AuthModule {

    @AuthScope
    @Provides
    static AuthAPI provideAuthApi(Retrofit retrofit) {
        return retrofit.create(AuthAPI.class);
    }
}
