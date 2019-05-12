package com.code.knab.sportgeeks.network.model;

public enum SportType {
    BASKETBALL("Koszykowka"),
    VOLLEYBALL("Siatkowka"),
    FOOTBALL("Pilka nozna");
    public String polishText;
    SportType(String text) {
        polishText = text;
    }
}
