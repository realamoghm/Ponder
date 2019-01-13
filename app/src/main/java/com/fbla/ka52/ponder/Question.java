/*
 * Copyright (c) 2019
 * All rights reserved Kevin Antony, Amogh Mehta, Amit Ashok
 */

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
