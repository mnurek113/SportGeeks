package com.code.knab.sportgeeks.ui.sign_up.mvp;

import com.code.knab.sportgeeks.network.api.NetworkApiProvider;
import com.code.knab.sportgeeks.network.api.SignUpApi;
import com.code.knab.sportgeeks.network.json.User;

import io.reactivex.Single;

public class SignUpModel implements SignUpMVP.Model {

    private NetworkApiProvider networkApiProvider;
    private SignUpApi api;

    public SignUpModel() {
        networkApiProvider = new NetworkApiProvider();
        api = networkApiProvider.createSignUpApi();
    }

    @Override
    public Single<User> signUp(User user) {
        return api.postUser(user);
    }
}
