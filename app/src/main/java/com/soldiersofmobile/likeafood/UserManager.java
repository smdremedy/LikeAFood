package com.soldiersofmobile.likeafood;

import android.text.TextUtils;

import com.soldiersofmobile.events.UserStateChangedEvent;
import com.soldiersofmobile.likeafood.api.ParseService;
import com.soldiersofmobile.likeafood.api.User;
import com.soldiersofmobile.likeafood.api.UserResponse;
import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static timber.log.Timber.d;

@Singleton
public class UserManager {

    private final ParseService parseService;
    private final Bus bus;

    private String sessionToken;

    @Inject
    public UserManager(ParseService parseService, Bus bus) {

        this.parseService = parseService;
        this.bus = bus;
    }

    public boolean isUserNotLogged() {
        return TextUtils.isEmpty(sessionToken);
    }

    public void signUp(String user, String password) {

        User userObject = new User();
        userObject.username = user;
        userObject.password = password;


        parseService.signUp(userObject, new Callback<UserResponse>() {
            @Override
            public void success(UserResponse userResponse, Response response) {

                d("User response" + response);
                sessionToken = userResponse.sessionToken;

                bus.post(new UserStateChangedEvent());
            }

            @Override
            public void failure(RetrofitError error) {
                d("Error:" + error);

            }
        });

    }
}
