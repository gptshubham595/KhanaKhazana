package com.khana.khazana.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invoice")
@Getter
@Setter
public class Invoice {
    @Column(nullable=false)
    private String username;
    @Column(nullable=false)
    private long userId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceTableId;

    @Column(nullable = false)
    private String invoiceId;
    @Column(nullable = false)
    private String transactionId;
    @Column(nullable = false)
    private String timestamp;
    // Needs to process single item only in the cart, for multiple items we need list
    @Column(nullable = false)
    private String foodTitle; // Single item
    @Column(nullable = false)
    private int foodQty;
    @Column(nullable = false)
    private double foodCost;
    @Column(nullable = false)
    private String restaurantAddress;
    @Column(nullable = false)
    private String deliveryAddress;

    private String coupon;


}
