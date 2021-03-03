package com.example.daggersample.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.daggersample.SessionManager;
import com.example.daggersample.network.main.MainAPI;

import javax.inject.Inject;

public class PostsViewModel extends ViewModel {

    private static final String TAG = "PostsViewModel";
    
    // inject
    private final SessionManager sessionManager;
    private final MainAPI mainAPI;
    
    @Inject
    public PostsViewModel(SessionManager sessionManager, MainAPI mainAPI) {
        this.sessionManager = sessionManager;
        this.mainAPI = mainAPI;
        Log.d(TAG, "PostsViewModel: Is working");
    }
}
