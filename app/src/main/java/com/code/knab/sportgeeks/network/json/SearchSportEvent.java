package com.code.knab.sportgeeks.network.json;

import com.code.knab.sportgeeks.network.model.SportType;

public class SearchSportEvent {
    public Long id;
    public String startTime;
    public Double price;
    public SearchLocalisation localisation;
    public SportType sportType;
    public String orgarnisatorName;

    public SearchSportEvent(Long id, String startTime, Double price, SearchLocalisation localisation, SportType sportType, String orgarnisatorName, Long participationsNumber) {
        this.id = id;
        this.startTime = startTime;
        this.price = price;
        this.localisation = localisation;
        this.sportType = sportType;
        this.orgarnisatorName = orgarnisatorName;
        this.participationsNumber = participationsNumber;
    }

    public Long participationsNumber;
}
