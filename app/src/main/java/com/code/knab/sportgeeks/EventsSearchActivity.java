package com.code.knab.sportgeeks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import com.code.knab.sportgeeks.network.json.SportEvent;
import com.code.knab.sportgeeks.ui.map.mvp.MapMVP;
import com.code.knab.sportgeeks.ui.map.mvp.MapModel;
import com.code.knab.sportgeeks.ui.map.mvp.MapPresenter;
import com.code.knab.sportgeeks.ui.welcome.MyEventsListAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class EventsSearchActivity extends AppCompatActivity
        implements EventsSearchMapFragment.OnFragmentInteractionListener, MapMVP.View,
EventsSearchInfoFragment.OnFragmentInteractionListener,
EventsSearchSurveyFragment.OnFragmentInteractionListener {

    private List<SportEvent> sportEventsList;
    private MapPresenter presenter;

    private MyEventsListAdapter myEventsListAdapter;
    private ListView myEventsListView;


    private EventsSearchPagerAdapter mEventsSearchPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);

        mEventsSearchPagerAdapter = new EventsSearchPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.eventsSearchViewPager);

        presenter = new MapPresenter(this, new MapModel());

        presenter.getSportEventsList(100.00, 0.00, 100.00, 0.00 );
        myEventsListView = findViewById(R.id.myEventsListView);

        setupEventsSearchViewPager(mViewPager);


    }

    private void setupEventsSearchViewPager(ViewPager viewPager) {
        EventsSearchPagerAdapter adapter = new EventsSearchPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EventsSearchMapFragment(), "EventsSearchMapFragment");
        adapter.addFragment(new EventsSearchInfoFragment(), "EventsSearchInfoFragment");
        adapter.addFragment(new EventsSearchSurveyFragment(), "EventsSearchSurveyFragment");
        viewPager.setAdapter(adapter);
    };

    public void setEventsSearchViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void listLoaded(List<SportEvent> list) {
        this.sportEventsList = list;
        myEventsListAdapter = new MyEventsListAdapter(this, R.layout.my_events_adapter_view, (ArrayList<SportEvent>) list);
        myEventsListView.setAdapter(myEventsListAdapter);
    }

    public List<SportEvent> getList() {
        return this.sportEventsList;
    }


}
