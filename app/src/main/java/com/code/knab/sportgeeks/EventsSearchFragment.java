package com.code.knab.sportgeeks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EventsSearchFragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button btnTEST;
    private Spinner materialDesignSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_search,container,false);
        btnTEST = (Button) view.findViewById(R.id.btnTEST);

        String[] SPORTSTYPES = {"Siatkówka", "Piłka nożna", "Koszykówka"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, SPORTSTYPES);

        materialDesignSpinner = (Spinner)
                materialDesignSpinner.findViewById(R.id.search_sport_type_choice);
        materialDesignSpinner.setAdapter(arrayAdapter);


        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK search",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}