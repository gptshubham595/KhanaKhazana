package com.khana.khazana.service;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.AdminRespository;
import com.khana.khazana.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRespository adminRespository;
    @Autowired
    RestaurantRepository restaurantRepository;

    public ShowAllCustomerResponse AllCustomer(){
        ShowAllCustomerResponse showAllCustomerResponse = new ShowAllCustomerResponse();
        List<Users> listOfUsers = adminRespository.findAllByRole("customer");
        showAllCustomerResponse.setEntries(listOfUsers);

        return showAllCustomerResponse;
    }

    public ShowAllCustomerResponse AllManager(){
        ShowAllCustomerResponse showAllCustomerResponse = new ShowAllCustomerResponse();
        List<Users> listOfManagers = adminRespository.findAllByRole("manager");
        showAllCustomerResponse.setEntries(listOfManagers);

        return showAllCustomerResponse;
    }

    public FetchRestaurantResponse AllRestaurant(){

        FetchRestaurantResponse fetchRestaurantResponse = new FetchRestaurantResponse();
        List<Restaurant> listOfRestaurant = restaurantRepository.findAll();
        fetchRestaurantResponse.setEntries(listOfRestaurant);

        return fetchRestaurantResponse;
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
