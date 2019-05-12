package com.code.knab.sportgeeks.network.json;

import com.code.knab.sportgeeks.network.model.SportType;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class SearchLocalisation {
    public Long id;
    public String name;
    public String description;
    public LatLng center;

    public SearchLocalisation(Long id, String name, String description, LatLng center, List<LatLng> polygonPoints, List<SportType> sportTypes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.center = center;
        this.polygonPoints = polygonPoints;
        this.sportTypes = sportTypes;
    }

    public List<LatLng> polygonPoints;
    public List<SportType> sportTypes;
}
