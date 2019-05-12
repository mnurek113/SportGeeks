package com.code.knab.sportgeeks.network.api;

import com.code.knab.sportgeeks.network.json.User;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SignInApi {

    @GET("user")
    Single<User> getUser(@Query("uid") String userUID);
}
