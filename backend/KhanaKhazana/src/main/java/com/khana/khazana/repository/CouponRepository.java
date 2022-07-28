package com.khana.khazana.repository;

import com.khana.khazana.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {

    boolean existsByCouponId(Long couponId);
    boolean existsByCouponString(String couponString);

    Coupon findByCouponString(String couponString);
    @Query(value = "Select * from coupon where coupon_id=?1 or coupon_string=?2", nativeQuery = true)
    List<Coupon> findByCouponByCouponStringOrId(long couponId,String couponString);
}
