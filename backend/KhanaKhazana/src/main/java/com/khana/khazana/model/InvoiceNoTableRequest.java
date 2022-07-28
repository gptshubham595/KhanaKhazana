package com.khana.khazana.model;

import java.util.List;

public class InvoiceNoTableRequest {
    private List<InvoiceNoTable> invoiceNoTables;
    private String coupon;

    public List<InvoiceNoTable> getInvoiceNoTables() {
        return invoiceNoTables;
    }

    public void setInvoiceNoTables(List<InvoiceNoTable> invoiceNoTables) {
        this.invoiceNoTables = invoiceNoTables;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}
