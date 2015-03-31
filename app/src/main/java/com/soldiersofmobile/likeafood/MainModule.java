package com.soldiersofmobile.likeafood;

import android.content.Context;

import com.soldiersofmobile.likeafood.api.ParseService;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;

/**
 * Created by madejs on 31.03.15.
 */
@Module(injects = {
        MainActivity.class,
        LoginActivity.class,

        UserManager.class
} )
public class MainModule {

    private final Context context;

    public MainModule(Context context) {

        this.context = context;
    }



    @Provides
    public ParseService provideParseService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("https://api.parse.com")
                .build();

        return restAdapter.create(ParseService.class);
    }

    @Singleton
    @Provides
    public Bus provideBus() {
        return new Bus();
    }

//    @Provides
//    public Context provideContext() {
//        return context;
//    }
}
