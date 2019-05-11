package com.code.knab.sportgeeks.ui.sign_up.mvp;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpPresenter implements SignUpMVP.Presenter {

    private FirebaseAuth firebaseAuth;

    public SignUpPresenter() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signUp(String email, String password, String repeatPassword) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            model.signUp(email,password);
        });
    }
}