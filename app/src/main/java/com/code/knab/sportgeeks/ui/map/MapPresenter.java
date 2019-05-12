package com.code.knab.sportgeeks.ui.map;

import com.code.knab.sportgeeks.network.json.SportEvent;
import com.code.knab.sportgeeks.utils.SchedulerHolders;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;

public class MapPresenter implements MapMVP.Presenter{


    private MapMVP.View view;
    private MapModel model;

    private SchedulerHolders schedulerHolders;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MapPresenter(MapMVP.View view, MapModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getSportEventsList(Double maxLatitude, Double minLatitude, Double maxLongitude, Double minLongitude, String gender, String sportType) {
        compositeDisposable.add(model.getSportEventsList(maxLatitude, minLatitude, maxLongitude, minLongitude, gender, sportType)
        .subscribeOn(schedulerHolders.subscribe())
        .observeOn(schedulerHolders.observ())
        .subscribeWith(new SportEventsObserver()));
    }

    private class SportEventsObserver extends DisposableSingleObserver<List<SportEvent>> {

        @Override
        public void onSuccess(List<SportEvent> sportEventList) {

        }

        @Override
        public void onError(Throwable e) {

        }
    }
}
