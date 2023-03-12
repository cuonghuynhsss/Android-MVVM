package com.cuonghuynh.myapplication;

import android.app.Application;

import com.cuonghuynh.myapplication.data.remote.api.BuildConfig;

import timber.log.Timber;

/**
 * @author Yassin Ajdi
 * @since 11/10/2018.
 */
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
