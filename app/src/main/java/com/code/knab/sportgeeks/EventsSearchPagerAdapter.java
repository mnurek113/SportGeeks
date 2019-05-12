package com.code.knab.sportgeeks;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventsSearchPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> eventsSearchFragmentList = new ArrayList<>();
    private final List<String> eventsSearchFragmentTitleList = new ArrayList<>();


    public EventsSearchPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        eventsSearchFragmentList.add(fragment);
        eventsSearchFragmentTitleList.add(title);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return eventsSearchFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return eventsSearchFragmentList.size();
    }
}
