package com.code.knab.sportgeeks.ui.map.mvp;

import com.code.knab.sportgeeks.network.json.SportEvent;

import java.util.List;

import io.reactivex.Single;

public interface MapMVP {

    interface Presenter {
        void getSportEventsList(Double maxLatitude,
                                Double minLatitude,
                                Double maxLongitude,
                                Double minLongitude);
    }

    interface Model {
        Single<List<SportEvent>> getSportEventsList(Double maxLatitude,
                                                    Double minLatitude,
                                                    Double maxLongitude,
                                                    Double minLongitude);
    }

    interface View {
        void listLoaded(List<SportEvent> list);
    }
}
