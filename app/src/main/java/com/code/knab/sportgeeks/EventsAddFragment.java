package com.code.knab.sportgeeks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;


public class EventsAddFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_add,container,false);


        String[] SPORTS = new String[] {"Koszykówka", "Siatkówka", "Piłka nożna"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        getContext(),
                        R.layout.dropdown_menu_popup_item,
                        SPORTS);

        AutoCompleteTextView editTextFilledExposedDropdown =
                view.findViewById(R.id.add_event_type_menu);
        editTextFilledExposedDropdown.setAdapter(adapter);

        return view;
    }
}