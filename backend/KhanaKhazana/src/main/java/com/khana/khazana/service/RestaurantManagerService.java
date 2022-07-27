package com.khana.khazana.service;

import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.model.Food;
import com.khana.khazana.model.Restaurant;
import com.khana.khazana.model.Users;
import com.khana.khazana.repository.FoodRepository;
import com.khana.khazana.repository.RestaurantRepository;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantManagerService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodRepository foodRepository;

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
        } else {
            response.setStatus(false);
            response.setMessage("ERR!");
        }

        return response;
    }

    public DefaultResponse addFood(Food addFoodRequest) {
        DefaultResponse defaultResponse = new DefaultResponse();
        List<Food> currFoodList = foodRepository.findSameFoodTitleAndRestaurantId(addFoodRequest.getFoodTitle(), addFoodRequest.getRestaurantId());
        if (currFoodList.size() > 0) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Food \"" + addFoodRequest.getFoodTitle() + "\" already exists for " + addFoodRequest.getRestaurantId());
        } else {
            foodRepository.save(addFoodRequest);
            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Food \"" + addFoodRequest.getFoodTitle() + "\" saved successfully for " + addFoodRequest.getRestaurantId());
        }
        return defaultResponse;
    }
}
