package com.code.knab.sportgeeks.ui.welcome.mvp;

import com.code.knab.sportgeeks.network.json.SearchSportEvent;
import com.code.knab.sportgeeks.network.json.SportEvent;
import com.code.knab.sportgeeks.utils.SchedulerHolders;

import java.util.List;
import java.util.concurrent.Executors;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class WelcomePresenter implements WelcomeMVP.Presenter {

    private WelcomeMVP.View view;
    private WelcomeModel model;

    private SchedulerHolders schedulerHolders = new SchedulerHolders(AndroidSchedulers.mainThread(), Schedulers.from(Executors.newFixedThreadPool(4)));
    ;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public WelcomePresenter(WelcomeMVP.View view, WelcomeModel model) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void getEventsList(Long userId) {
        compositeDisposable.add(model.getEventsList(userId)
                .subscribeOn(schedulerHolders.subscribe())
                .observeOn(schedulerHolders.observ())
                .subscribeWith(new MyEventsListObserver()));
    }

    private class MyEventsListObserver extends DisposableSingleObserver<List<SportEvent>> {

        @Override
        public void onSuccess(List<SportEvent> sportEventList) {
            view.listLoaded(sportEventList);
        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
