package com.soldiersofmobile.likeafood;

import android.app.Application;

import dagger.ObjectGraph;
import timber.log.Timber;

public class App extends Application {

    private static ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        objectGraph = ObjectGraph.create(new MainModule(getApplicationContext()));

    }

    public static void doDaggerInject(Object injectInto) {
        objectGraph.inject(injectInto);
    }
}
