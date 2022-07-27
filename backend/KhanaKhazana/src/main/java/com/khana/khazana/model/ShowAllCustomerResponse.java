package com.khana.khazana.model;

import java.util.List;

public class ShowAllCustomerResponse {

    private List<Users> entries;
    private String message;

    public List<Users> getEntries() {
        return entries;
    }

    public void setEntries(List<Users> entries) {
        this.entries = entries;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
