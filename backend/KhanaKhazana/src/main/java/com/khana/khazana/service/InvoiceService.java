package com.khana.khazana.service;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.CouponRepository;
import com.khana.khazana.repository.InvoiceRepository;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.khana.khazana.service.UserService.isLoggedIn;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;
    UserRepository userRepository;
    CouponRepository couponRepository;
    public boolean UserExistsInDB(long userId){
        Users user = userRepository.findByUserId(userId);
        if(user==null || !user.getRole().equals("admin")){
            return false;
        }

        return true;
    }

    public DefaultResponse SaveOrderInfo(Invoice invoice){
        DefaultResponse defaultResponse = new DefaultResponse();

        try{
            Coupon coupon = couponRepository.findByCouponString(invoice.getCoupon());
            double amount = invoice.getFoodQty()*invoice.getFoodCost() - coupon.getCouponAmt()>0?(invoice.getFoodQty()*invoice.getFoodCost() - coupon.getCouponAmt()):0;
            invoice.setFoodCost(amount);

            invoiceRepository.save(invoice);

            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Order info saved");
        }catch (Exception e){
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Error occurred while saving order info. \n"+e.toString());
        }

        return defaultResponse;
    }

    public InvoiceResponse GenerateInvoice(WhichUserRequest whichUserRequest) {
        WhichUserResponse whichUserResponse = isLoggedIn(whichUserRequest);
        boolean userExistsInDB = UserExistsInDB(whichUserRequest.getUserId());
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        if(whichUserResponse.isStatus() && userExistsInDB){
            List<Invoice> OrderHistory =  invoiceRepository.findAllByuserIdOrderBytimestampDesc(whichUserRequest.getUserId());
            invoiceResponse.setEntries(OrderHistory);
            invoiceResponse.setStatus(true);
        }
        else{
            invoiceResponse.setEntries(null);
            invoiceResponse.setStatus(false);
        }

        return invoiceResponse;
    }
}
