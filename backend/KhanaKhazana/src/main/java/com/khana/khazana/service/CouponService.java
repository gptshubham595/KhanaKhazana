package com.khana.khazana.service;

import com.khana.khazana.model.Coupon;
import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    @Autowired
    CouponRepository couponRepository;

    public DefaultResponse addCoupon(Coupon coupon) {
        DefaultResponse response = new DefaultResponse();
        boolean couponExistsByString = couponRepository.existsByCouponString(coupon.getCouponString());
        if (couponExistsByString) {
            response.setStatus(false);
            response.setMessage("Coupon already exists");
            return response;
        }
        couponRepository.save(coupon);
        response.setStatus(true);
        response.setMessage("Coupon Added!");

        return response;
    }
}
