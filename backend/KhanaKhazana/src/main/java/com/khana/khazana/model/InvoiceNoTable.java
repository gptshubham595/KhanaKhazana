package com.khana.khazana.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceNoTable {
    private long userId;
    private String timestamp;
    // Needs to process single item only in the cart, for multiple items we need list
    private long foodId; // Single item
    private int foodQty;

    private long restaurantId;
    private String deliveryAddress;

}
