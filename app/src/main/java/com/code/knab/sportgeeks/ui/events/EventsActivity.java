package com.code.knab.sportgeeks.ui.events;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;

import com.code.knab.sportgeeks.EventsActiveFragment;
import com.code.knab.sportgeeks.EventsAddFragment;
import com.code.knab.sportgeeks.EventsSearchFragment;
import com.code.knab.sportgeeks.EventsSearchPagerAdapter;
import com.code.knab.sportgeeks.R;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;

import java.util.Calendar;


public class EventsActivity extends AppCompatActivity {

    private EventsSearchPagerAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        mViewPager = (ViewPager) findViewById(R.id.eventsPager);
        setupViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager mViewPager) {
        mSectionsPageAdapter = new EventsSearchPagerAdapter(getSupportFragmentManager());
        mSectionsPageAdapter.addFragment(new EventsActiveFragment(), "EventsActiveFragment");
        mSectionsPageAdapter.addFragment(new EventsSearchFragment(), "EventsSearchFragment");
        mSectionsPageAdapter.addFragment(new EventsAddFragment(), "EventsAddFragment");
        mViewPager.setAdapter(mSectionsPageAdapter);

    }


}
