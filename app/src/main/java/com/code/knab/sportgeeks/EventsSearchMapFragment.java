package com.code.knab.sportgeeks;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.code.knab.sportgeeks.network.json.Localisation;
import com.code.knab.sportgeeks.network.json.LocalisationPoint;
import com.code.knab.sportgeeks.network.json.SearchLocalisation;
import com.code.knab.sportgeeks.network.json.SearchLocalisationPoint;
import com.code.knab.sportgeeks.network.json.SearchSportEvent;
import com.code.knab.sportgeeks.network.model.SportType;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsSearchMapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsSearchMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsSearchMapFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private ImageButton eventsSearchMapNextButton;
    private ImageButton eventsSearchMapPrvsButton;

    private List<SearchSportEvent> sportEvents = new ArrayList<>();


    SupportMapFragment mapFragment;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EventsSearchMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsSearchMapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsSearchMapFragment newInstance(String param1, String param2) {
        EventsSearchMapFragment fragment = new EventsSearchMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        List<LatLng> polygonPoints = new ArrayList<>();
        polygonPoints.add(new LatLng(52.215143, 20.996392));
        polygonPoints.add(new LatLng(52.215296, 20.996403));
        polygonPoints.add(new LatLng(52.215279, 20.996852));
        polygonPoints.add(new LatLng(52.215127, 20.996838));

        LatLng center = new LatLng(52.215211, 20.996617);
        List<SportType> sportTypes = new ArrayList<>();
        sportTypes.add(SportType.BASKETBALL);
        SearchLocalisation localisation = new SearchLocalisation(1L, "Boisko jndkj", "    ",
                center,
                polygonPoints,
                sportTypes
        );

        sportEvents.add(
                new SearchSportEvent(1L, "21.4   23:41", null,
                        localisation, SportType.BASKETBALL, "krzysiek",
                        5L));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_search_map, container, false);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        eventsSearchMapNextButton = (ImageButton) view.findViewById(R.id.eventsSearchMapNextScrBtn);
        eventsSearchMapPrvsButton = (ImageButton) view.findViewById(R.id.eventsSearchMapPrvsScrBtn);
        eventsSearchMapNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to eventsSearchInfoScreen", Toast.LENGTH_SHORT).show();
                ((EventsSearchActivity) getActivity()).setEventsSearchViewPager(1);
            }
        });
        eventsSearchMapPrvsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to eventsSearchSurveyScreen", Toast.LENGTH_SHORT).show();
                ((EventsSearchActivity) getActivity()).setEventsSearchViewPager(2);
            }
        });

        if (mapFragment == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = new SupportMapFragment();
            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sportEvents.get(0).localisation.center, 15F));

        for(int i = 0; i < sportEvents.size(); i++) {
            SearchSportEvent sportEvent = sportEvents.get(i);
            googleMap.addPolygon(new PolygonOptions()
                .clickable(false)
                    .addAll(sportEvent.localisation.polygonPoints));
            googleMap.addMarker(new MarkerOptions().position(sportEvent.localisation.center).title(sportEvent.localisation.name));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
