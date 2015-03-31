package com.soldiersofmobile.likeafood;

import android.app.Application;

import dagger.ObjectGraph;

public class App extends Application {

    private static ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new MainModule(getApplicationContext()));
    }

    public static void doDaggerInject(Object injectInto) {
        objectGraph.inject(injectInto);
    }
}
