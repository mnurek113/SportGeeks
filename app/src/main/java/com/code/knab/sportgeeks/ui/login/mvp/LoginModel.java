package com.code.knab.sportgeeks.ui.login.mvp;

import com.code.knab.sportgeeks.network.api.NetworkApiProvider;
import com.code.knab.sportgeeks.network.api.SignInApi;
import com.code.knab.sportgeeks.network.json.User;

import io.reactivex.Single;

public class LoginModel implements LoginMVP.Model{

    private NetworkApiProvider networkApiProvider = new NetworkApiProvider();
    private SignInApi api = networkApiProvider.createSignInApi();

    @Override
    public Single<User> getUser(String userUID) {
        return api.getUser(userUID);
    }
}
