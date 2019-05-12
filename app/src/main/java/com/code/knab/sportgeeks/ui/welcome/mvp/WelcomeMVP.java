package com.code.knab.sportgeeks.ui.welcome.mvp;

import com.code.knab.sportgeeks.network.json.SearchSportEvent;
import com.code.knab.sportgeeks.network.json.SportEvent;

import java.util.List;

import io.reactivex.Single;

public interface WelcomeMVP {

    interface View {
        void listLoaded(List<SportEvent> list);
    }

    interface Presenter {
        void getEventsList(Long userId);
    }

    interface Model {
        Single<List<SportEvent>> getEventsList(Long userId);
    }

}
