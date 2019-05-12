package com.code.knab.sportgeeks.ui.welcome.mvp;

import com.code.knab.sportgeeks.network.json.SportEvent;

import java.util.List;

import io.reactivex.Single;

public interface WelcomeMVP {

    interface View {

    }

    interface Presenter {
        void getEventsList(Long userId);
    }

    interface Model {
        Single<List<SportEvent>> getEventsList(Long userId);
    }

}
