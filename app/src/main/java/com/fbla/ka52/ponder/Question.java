package com.fbla.ka52.ponder;

import android.app.Application;

import com.firebase.client.Firebase;

public class Question extends Application {

    @Override
    public  void onCreate()
    {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
