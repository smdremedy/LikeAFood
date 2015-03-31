package com.soldiersofmobile.likeafood;

import javax.inject.Inject;

public class UserManager {

    @Inject
    public UserManager() {

    }

    public boolean isUserNotLogged() {
        return true;
    }
}
