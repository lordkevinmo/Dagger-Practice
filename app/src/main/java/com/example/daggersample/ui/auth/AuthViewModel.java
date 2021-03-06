package com.example.daggersample.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.daggersample.SessionManager;
import com.example.daggersample.models.User;
import com.example.daggersample.network.auth.AuthAPI;

import javax.inject.Inject;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthAPI authApi;

    private SessionManager sessionManager;

    @Inject
    public AuthViewModel(AuthAPI authApi, SessionManager sessionManager) {
        Log.d(TAG, "AuthViewModel: is working...");
        this.authApi = authApi;
        this.sessionManager = sessionManager;
    }

    public void authenticateWithId(int userId) {
        Log.d(TAG, "authenticateWithId: attempting to login");
        sessionManager.authenticateWithId(queryUserId(userId));
    }

    private LiveData<AuthResource<User>> queryUserId(int userId) {
        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                    // instead of
                    .onErrorReturn(new Function<Throwable, User>() {
                        @Override
                        public User apply(Throwable throwable) throws Throwable {
                            User errorUser = new User();
                            errorUser.setId(-1);
                            return errorUser;
                        }
                    })

                    .map(new Function<User, AuthResource<User>>() {
                        @Override
                        public AuthResource<User> apply(User user) throws Throwable {
                            if (user.getId() == -1) {
                                return AuthResource.error(
                                        "Couldn't authenticate", (User)null);
                            }
                            return AuthResource.authenticated(user);
                        }
                    })
                .subscribeOn(Schedulers.io()));
    }

    public LiveData<AuthResource<User>> observeAuthState() {
        return sessionManager.getAuthUser();
    }
}
