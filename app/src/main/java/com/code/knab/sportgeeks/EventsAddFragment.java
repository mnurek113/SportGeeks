package com.code.knab.sportgeeks;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class EventsAddFragment extends Fragment {

    private MaterialButton add_event_final_button;
    private MaterialButton add_timePicker_button, add_datePicker_button;
    private MaterialButton add_timePicker_end_button, add_datePicker_end_button;
    private TextInputEditText add_in_start_date, add_in_end_date, add_in_start_time, add_in_end_rime;
    private int mYear, mMonth, mDay, mHour, mMinute;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_add,container,false);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        MaterialButton add_datePicker_button = (MaterialButton) getView().findViewById(R.id.add_datePicker_button);
        MaterialButton add_timePicker_button = (MaterialButton) getView().findViewById(R.id.add_timePicker_button);
        MaterialButton add_datePicker_end_button = (MaterialButton) getView().findViewById(R.id.add_datePicker_end_button);
        MaterialButton add_timePicker_end_button = (MaterialButton) getView().findViewById(R.id.add_timePicker_end_button);
        final TextInputEditText add_in_start_date = (TextInputEditText) getView().findViewById(R.id.add_in_start_date);
        TextInputEditText add_in_end_date = (TextInputEditText) getView().findViewById(R.id.add_in_end_date);
        TextInputEditText add_in_start_time = (TextInputEditText) getView().findViewById(R.id.add_in_start_time);
        TextInputEditText add_in_end_time = (TextInputEditText) getView().findViewById(R.id.add_in_end_time);



        add_datePicker_button.setOnClickListener( v -> {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    (view1, year, monthOfYear, dayOfMonth) -> add_in_start_date
                            .setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), mYear, mMonth, mDay);
            datePickerDialog.show();

        });

        add_datePicker_end_button.setOnClickListener( v -> {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    (view1, year, monthOfYear, dayOfMonth) -> add_in_end_date
                            .setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year), mYear, mMonth, mDay);
            datePickerDialog.show();

        });

        add_timePicker_button.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                    (view13, hourOfDay, minute) -> add_in_start_time.
                            setText(hourOfDay + ":" + minute), mHour, mMinute, true);
            timePickerDialog.show();
        });

        add_timePicker_end_button.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                    (view12, hourOfDay, minute) -> add_in_end_time.
                            setText(hourOfDay + ":" + minute), mHour, mMinute, true);
            timePickerDialog.show();
        });

    }
}