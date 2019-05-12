package com.code.knab.sportgeeks.network.api;

import com.code.knab.sportgeeks.network.json.SearchSportEvent;
import com.code.knab.sportgeeks.network.json.SportEvent;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyEventsApi {

    @GET("event/user/list/{id}")
    Single<List<SportEvent>> getEventsList(@Path("id") Long id);
}
