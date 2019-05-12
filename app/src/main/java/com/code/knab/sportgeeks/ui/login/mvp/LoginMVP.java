package com.code.knab.sportgeeks.ui.login.mvp;

import com.code.knab.sportgeeks.network.json.User;

import io.reactivex.Single;

public interface LoginMVP {

    interface View {
        void onLoginSuccessful(Long userId);
        void onLoginFailed();
    }

    interface Presenter {
        void login(String login, String password);
    }

    interface Model {
        Single<User> getUser(String userUID);
    }

}
