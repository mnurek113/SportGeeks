package com.code.knab.sportgeeks.ui.login.mvp;

import com.code.knab.sportgeeks.network.json.User;
import com.code.knab.sportgeeks.utils.SchedulerHolders;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements LoginMVP.Presenter{

    private static final boolean SIGN_IN_BYPASS = false;
    private FirebaseAuth firebaseAuth;

    private LoginMVP.View view;
    private LoginModel model;

    private SchedulerHolders schedulerHolders;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LoginPresenter(LoginMVP.View view, LoginModel model) {
        this.view = view;
        this.model = model;
        firebaseAuth = FirebaseAuth.getInstance();
        this.schedulerHolders = new SchedulerHolders(AndroidSchedulers.mainThread(), Schedulers.from(Executors.newFixedThreadPool(4)));
    }

    @Override
    public void login(String login, String password) {

        if(SIGN_IN_BYPASS) {
            view.onLoginSuccessful(1L);
        } else
        firebaseAuth.signInWithEmailAndPassword(login, password).addOnCompleteListener(task -> {
           if(task.isSuccessful()) {
               compositeDisposable.add(model.getUser(task.getResult().getUser().getUid())
               .subscribeOn(schedulerHolders.subscribe())
               .observeOn(schedulerHolders.observ())
               .subscribeWith(new SignInObserver()));
           } else {
               view.onLoginFailed();
           }
        });

    }

    private class SignInObserver extends DisposableSingleObserver<User> {
        @Override
        public void onSuccess(User user) {
            view.onLoginSuccessful(user.getId());
        }

        @Override
        public void onError(Throwable e) {
            view.onLoginFailed();
        }
    }
}
