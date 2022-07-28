package com.khana.khazana.model;

import java.util.List;

public class InvoiceResponse {
    private List<Invoice> Entries;

    public List<Invoice> getEntries() {
        return Entries;
    }

    public void setEntries(List<Invoice> entries) {
        Entries = entries;
    }
}
