package com.khana.khazana.model;

import java.util.List;

public class InvoiceResponse {
    private List<Invoice> Entries;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Invoice> getEntries() {
        return Entries;
    }

    public void setEntries(List<Invoice> entries) {
        Entries = entries;
    }
}
