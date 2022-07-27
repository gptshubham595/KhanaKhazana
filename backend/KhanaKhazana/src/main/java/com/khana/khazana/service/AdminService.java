package com.khana.khazana.service;

import com.khana.khazana.model.BanUserResponse;
import com.khana.khazana.model.ShowAllCustomerResponse;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.AdminRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRespository adminRespository;

    public ShowAllCustomerResponse AllCustomer(){
        ShowAllCustomerResponse showAllCustomerResponse = new ShowAllCustomerResponse();
        List<Users> listOfUsers = adminRespository.findAllByRole("customer");
        showAllCustomerResponse.setEntries(listOfUsers);

        return showAllCustomerResponse;
    }

    public ShowAllCustomerResponse AllRestaurant(){
        ShowAllCustomerResponse showAllCustomerResponse = new ShowAllCustomerResponse();
        List<Users> listOfUsers = adminRespository.findAllByRole("restaurant");
        showAllCustomerResponse.setEntries(listOfUsers);

        return showAllCustomerResponse;
    }

//    public Users singleuser(long id){
//        return adminRespository.findById(id);
//    }

    public BanUserResponse banUser(long userId){
        BanUserResponse banUserResponse = new BanUserResponse();
        adminRespository.deleteById(userId);
        banUserResponse.setStatus(true);
        banUserResponse.setMessage("User Banned");
        return banUserResponse;
    }
}
