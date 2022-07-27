package com.khana.khazana.model;

import javax.persistence.*;

@Entity
@Table(name = "Coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Column(nullable = false)
    private String couponString;
    @Column(nullable = false)
    private Double couponAmt;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getCouponString() {
        return couponString;
    }

    public void setCouponString(String couponString) {
        this.couponString = couponString;
    }

    public Double getCouponAmt() {
        return couponAmt;
    }

    public void setCouponAmt(Double couponAmt) {
        this.couponAmt = couponAmt;
    }
}
