package com.example.daggersample.network.auth;

import com.example.daggersample.models.User;

import io.reactivex.rxjava3.core.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthAPI {

    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}
