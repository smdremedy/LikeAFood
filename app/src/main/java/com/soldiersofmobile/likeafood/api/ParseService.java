package com.soldiersofmobile.likeafood.api;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface ParseService {


    @Headers({
            "X-Parse-Application-Id: C2TBuKKsSnynfindEQiCAYbzGG9LmcApXjYPbAPC" ,
            "X-Parse-REST-API-Key: AGQyjo05XwjHL9gWLRvjswvy2sZdZpMs1v6vgzCM" ,

            "Content-Type: application/json"
    })
    @POST("/1/users")
    void signUp(@Body User user, Callback<UserResponse> callback);
}
