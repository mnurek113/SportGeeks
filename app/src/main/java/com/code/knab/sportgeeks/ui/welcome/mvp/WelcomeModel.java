package com.code.knab.sportgeeks.ui.welcome.mvp;

import com.code.knab.sportgeeks.network.api.MyEventsApi;
import com.code.knab.sportgeeks.network.api.NetworkApiProvider;
import com.code.knab.sportgeeks.network.json.SearchSportEvent;

import java.util.List;

import io.reactivex.Single;

public class WelcomeModel implements WelcomeMVP.Model {
    private NetworkApiProvider networkApiProvider = new NetworkApiProvider();
    private MyEventsApi api = networkApiProvider.createMyEventsApi();

    @Override
    public Single<List<SearchSportEvent>> getEventsList(Long userId) {
        return api.getEventsList(userId);
    }
}
