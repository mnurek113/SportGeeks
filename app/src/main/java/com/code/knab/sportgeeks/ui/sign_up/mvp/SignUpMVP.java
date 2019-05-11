package com.code.knab.sportgeeks.ui.sign_up.mvp;

public interface SignUpMVP {

    interface View {

    }

    interface Presenter {
        void signUp(String email, String password, String repeatPassword);
    }

    interface Model {

    }

}
