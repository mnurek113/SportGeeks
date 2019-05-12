package com.code.knab.sportgeeks.network.api;

import com.code.knab.sportgeeks.network.json.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpApi {

    @POST("user")
    Single<User> postUser(@Body User user);

}
