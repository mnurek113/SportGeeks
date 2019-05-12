package com.code.knab.sportgeeks.network.api;

import com.code.knab.sportgeeks.network.json.SportEvent;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsOnMapApi {

    @GET("event")
    Single<List<SportEvent>> getSportEventsList(@Query("maxLat") Double maxLatitude,
                                                @Query("minLat") Double minLatitude,
                                                @Query("maxLong") Double maxLongitude,
                                                @Query("minLong") Double minLongitude);
}
