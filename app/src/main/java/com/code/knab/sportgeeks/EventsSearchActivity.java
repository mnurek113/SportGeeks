package com.code.knab.sportgeeks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventsSearchActivity extends AppCompatActivity {

    private EventsSearchPagerAdapter mEventsSearchPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_events);

        mEventsSearchPagerAdapter = new EventsSearchPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.eventsSearchViewPager);

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


}
