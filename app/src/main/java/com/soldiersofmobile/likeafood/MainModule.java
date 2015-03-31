package com.soldiersofmobile.likeafood;

import android.content.Context;

import dagger.Module;

/**
 * Created by madejs on 31.03.15.
 */
@Module(injects = MainActivity.class)
public class MainModule {

    private final Context context;

    public MainModule(Context context) {

        this.context = context;
    }

//    @Provides
//    public Context provideContext() {
//        return context;
//    }
}
