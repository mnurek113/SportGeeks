package com.code.knab.sportgeeks.ui.sign_up.mvp;

import com.code.knab.sportgeeks.network.json.User;

import io.reactivex.Single;

public interface SignUpMVP {

    interface View {
        void onSignUpSuccessful(Long userId);
    }

    interface Presenter {
        void signUp(String email, String password, String repeatPassword, String name, String sex);
    }

    interface Model {
        Single<User> signUp(User user);
    }

}
