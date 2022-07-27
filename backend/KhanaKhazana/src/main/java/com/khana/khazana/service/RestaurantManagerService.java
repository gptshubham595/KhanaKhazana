package com.khana.khazana.service;

import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.model.Restaurant;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.RestaurantRepository;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantManagerService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    public DefaultResponse addRestaurant(Restaurant addRestaurantRequest) {
        boolean currRestaurant = restaurantRepository.existsByRestaurantId(addRestaurantRequest.getRestaurantId());
        Users user = userRepository.findByUserId(addRestaurantRequest.getManagerId());

        DefaultResponse response = new DefaultResponse();

        if (currRestaurant) {
            response.setStatus(false);
            response.setMessage("Restaurants already exists");
        } else if (user == null) {
            response.setStatus(false);
            response.setMessage("Manager doesn't exists");
        } else if (user.getRole().equals("manager")) {
            addRestaurantRequest.setRestaurantRating(1.0);
            addRestaurantRequest.setManagerId(user.getUserId());
            restaurantRepository.save(addRestaurantRequest);
            response.setStatus(true);
            response.setMessage("Restaurants added successfully");
        }else{
            response.setStatus(false);
            response.setMessage("ERR!");
        }

        return response;
    }
}
