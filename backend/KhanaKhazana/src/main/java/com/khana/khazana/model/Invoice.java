package com.khana.khazana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private String userId;
    @Id
    private String transactionId;
    private String timestamp;
    // Needs to process single item only in the cart, for multiple items we need list
    private String foodTitle; // Single item
    private String foodQty;
    private String foodCost;    // single item cost
    private String restaurantAddress;
    private String deliveryAddress;
}
