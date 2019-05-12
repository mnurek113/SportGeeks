package com.code.knab.sportgeeks.ui.sign_up.mvp;

import com.code.knab.sportgeeks.network.json.User;
import com.code.knab.sportgeeks.utils.SchedulerHolders;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SignUpPresenter implements SignUpMVP.Presenter {

    private FirebaseAuth firebaseAuth;

    private SignUpMVP.View view;
    private SignUpModel model;
    private SchedulerHolders schedulerHolders;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SignUpPresenter(SignUpModel model, SignUpMVP.View view) {
        this.model = model;
        this.view = view;
        firebaseAuth = FirebaseAuth.getInstance();
        this.schedulerHolders = new SchedulerHolders(AndroidSchedulers.mainThread(), Schedulers.from(Executors.newFixedThreadPool(4)));

    }

    @Override
    public void signUp(String email, String password, String repeatPassword, String name, String sex) {

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful())
                compositeDisposable.add(model.signUp(new User(null,task.getResult().getUser().getUid(),name, sex, email))
                        .subscribeOn(schedulerHolders.subscribe())
                        .observeOn(schedulerHolders.observ())
                        .subscribeWith(new SignUpObserver()));
        });
    }

    private class SignUpObserver extends DisposableSingleObserver<User> {

        @Override
        public void onSuccess(User user) {
            view.onSignUpSuccessful(user.getId());
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}