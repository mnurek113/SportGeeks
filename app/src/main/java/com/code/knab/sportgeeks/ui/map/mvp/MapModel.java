package com.code.knab.sportgeeks.ui.map.mvp;

import com.code.knab.sportgeeks.network.api.EventsOnMapApi;
import com.code.knab.sportgeeks.network.api.NetworkApiProvider;
import com.code.knab.sportgeeks.network.json.SportEvent;

import java.util.List;

import io.reactivex.Single;

public class MapModel implements MapMVP.Model {

    private NetworkApiProvider networkApiProvider = new NetworkApiProvider();
    private EventsOnMapApi api = networkApiProvider.createEventsOnMapApi();


    @Override
    public Single<List<SportEvent>> getSportEventsList(Double maxLatitude, Double minLatitude, Double maxLongitude, Double minLongitude) {
        return api.getSportEventsList(maxLatitude, minLatitude, maxLongitude, minLongitude);
    }
}
