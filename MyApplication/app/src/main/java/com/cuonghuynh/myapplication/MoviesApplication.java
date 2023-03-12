package com.cuonghuynh.myapplication;

import android.app.Application;

import com.cuonghuynh.myapplication.data.remote.api.BuildConfig;

import timber.log.Timber;

public class MoviesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.Tree() {
            });
        }
    }
}
