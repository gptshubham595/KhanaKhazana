package com.khana.khazana.service;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.khana.khazana.service.UserService.isLoggedIn;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CouponRepository couponRepository;

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public boolean UserExistsInDB(long userId) {
        Users user = userRepository.findByUserId(userId);
        if (user == null || !user.getRole().equals("customer") ) {
            return false;
        }

        return true;
    }


    public void SaveOrderInfo(InvoiceNoTable invoice, Coupon coupon, String invoiceGeneratedId, String transactionGeneratedId) throws Exception {
//        DefaultResponse defaultResponse = new DefaultResponse();

        try {
            Food food = foodRepository.findByFoodId(invoice.getFoodId());
            if (food != null) {
                double price = invoice.getFoodQty() * food.getFoodCost();
                double percentage = (price - price * coupon.getCouponPercentage() * 0.01);
                double amount = percentage > 0 ? percentage : 0;
                Invoice invoiceData = new Invoice();
                invoiceData.setFoodCost(amount);
                invoiceData.setInvoiceId(invoiceGeneratedId);

                Users user = userRepository.findByUserId(invoice.getUserId());
                if (user != null) {
                    invoiceData.setUsername(user.getUsername());

                    invoiceData.setUserId(invoice.getUserId());
                    invoiceData.setTransactionId(transactionGeneratedId);
                    invoiceData.setTimestamp(invoice.getTimestamp());
                    invoiceData.setFoodTitle(food.getFoodTitle());
                    invoiceData.setFoodQty(invoice.getFoodQty());

                    Restaurant restaurant = restaurantRepository.findByRestaurantId(invoice.getRestaurantId());
                    if (restaurant != null) {
                        invoiceData.setRestaurantAddress(restaurant.getRestaurantAddress());
                        invoiceData.setDeliveryAddress(invoice.getDeliveryAddress());
                        invoiceData.setCoupon(coupon.getCouponString());
                        invoiceRepository.save(invoiceData);
                    } else {
                        throw new Exception("Invalid Restaurant");
                    }
                } else {
                    throw new Exception("Invalid User");
                }
            } else {
                throw new Exception("Invalid Food");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        return defaultResponse;
    }

    public InvoiceResponse GetAllInvoices(WhichUserRequest whichUserRequest) {
        WhichUserResponse whichUserResponse = isLoggedIn(whichUserRequest);
        boolean userExistsInDB = UserExistsInDB(whichUserRequest.getUserId());
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        if (whichUserResponse.isStatus() && userExistsInDB) {
            List<Invoice> OrderHistory = invoiceRepository.findAllByuserIdOrderBytimestampDesc(whichUserRequest.getUserId());
            invoiceResponse.setEntries(OrderHistory);
            invoiceResponse.setStatus(true);
        } else {
            invoiceResponse.setEntries(null);
            invoiceResponse.setStatus(false);
        }

        return invoiceResponse;
    }

    public InvoiceNoTableResponse SaveOrderInfoList(InvoiceNoTableRequest invoiceNoTableRequest) {
        InvoiceNoTableResponse invoiceResponse = new InvoiceNoTableResponse();
        List<InvoiceNoTable> invoiceList = invoiceNoTableRequest.getInvoiceNoTables();
        String CouponString = invoiceNoTableRequest.getCoupon();
        try {
            String invoiceGeneratedId = RandomStringUtils.randomAlphanumeric(8).toString();
            String transactionGeneratedId = RandomStringUtils.randomAlphanumeric(8).toString();
            Coupon coupon = couponRepository.findByCouponString(CouponString);
            if (coupon == null) {
                invoiceResponse.setStatus(false);
                invoiceResponse.setMessage("Coupon Does Not Exist \n");
                return invoiceResponse;
            }
            for (int i = 0; i < invoiceList.size(); i++) {
                InvoiceNoTable eachInvoice = invoiceList.get(i);
                SaveOrderInfo(eachInvoice, coupon, invoiceGeneratedId, transactionGeneratedId);
            }

            invoiceResponse.setStatus(true);
            invoiceResponse.setInvoiceId(invoiceGeneratedId);
            invoiceResponse.setTransactionId(transactionGeneratedId);
            invoiceResponse.setMessage("All Order info saved");
        } catch (Exception e) {

            invoiceResponse.setStatus(false);
            invoiceResponse.setMessage("Error occurred while saving order info. \n" + e.toString());
        }

        return invoiceResponse;

    }
}
