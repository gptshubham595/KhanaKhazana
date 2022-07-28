package com.khana.khazana.controller;

import com.khana.khazana.model.Coupon;
import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping(value = "/addCoupon", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> addCoupon(@RequestBody Coupon coupon){
        DefaultResponse response = couponService.addCoupon(coupon);
        if(response.isStatus()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
