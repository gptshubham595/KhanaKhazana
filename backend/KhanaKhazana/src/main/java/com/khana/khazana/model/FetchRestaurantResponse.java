package com.khana.khazana.model;

import java.util.List;

public class FetchRestaurantResponse {

    private List<Restaurant> Entries;
    private String message;

    public List<Restaurant> getEntries() {
        return Entries;
    }

    public void setEntries(List<Restaurant> entries) {
        Entries = entries;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
