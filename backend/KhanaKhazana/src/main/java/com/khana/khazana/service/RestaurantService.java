package com.khana.khazana.service;

import com.khana.khazana.model.FoodByRestaurantRequest;
import com.khana.khazana.model.FoodListResponse;
import com.khana.khazana.model.Restaurant;
import com.khana.khazana.model.RestaurantResponse;
import com.khana.khazana.repository.FoodRepository;
import com.khana.khazana.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    FoodRepository foodRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

//    private long restaurantId;
//    private String restaurantName;
//    private String restaurantDescription;
//    private Double restaurantRating;
//    private String restaurantAddress;
//    private String restaurantImage;
//    private long managerId;
//    private String message;

    public RestaurantResponse getRestaurantsById(long restaurantId) {
//        return r
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        Restaurant restaurantFound = restaurantRepository.findRestaurantById(restaurantId);
        if(restaurantFound == null){
            restaurantResponse.setMessage("Sorry, the restaurant with id = " + restaurantId + " does not exist.");
        }else{
            restaurantResponse.setRestaurantId(restaurantFound.getRestaurantId());
            restaurantResponse.setRestaurantName(restaurantFound.getRestaurantName());
            restaurantResponse.setRestaurantDescription(restaurantFound.getRestaurantDescription());
            restaurantResponse.setRestaurantRating(restaurantFound.getRestaurantRating());
            restaurantResponse.setRestaurantAddress(restaurantFound.getRestaurantAddress());
            restaurantResponse.setRestaurantImage(restaurantFound.getRestaurantImage());
            restaurantResponse.setManagerId(restaurantFound.getManagerId());
            restaurantResponse.setMessage("Success");
        }
        return restaurantResponse;
    }

    public RestaurantResponse getRestaurantByName(String name) {
//        return restaurantRepository.findRestaurantByName(name);
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        Restaurant restaurantFound = restaurantRepository.findRestaurantByName(name);
        if(restaurantFound == null){
            restaurantResponse.setMessage("Sorry, the restaurant " + name + " does not exist.");
        }else{
            restaurantResponse.setRestaurantId(restaurantFound.getRestaurantId());
            restaurantResponse.setRestaurantName(restaurantFound.getRestaurantName());
            restaurantResponse.setRestaurantDescription(restaurantFound.getRestaurantDescription());
            restaurantResponse.setRestaurantRating(restaurantFound.getRestaurantRating());
            restaurantResponse.setRestaurantAddress(restaurantFound.getRestaurantAddress());
            restaurantResponse.setRestaurantImage(restaurantFound.getRestaurantImage());
            restaurantResponse.setManagerId(restaurantFound.getManagerId());
            restaurantResponse.setMessage("Success");
        }
        return restaurantResponse;

    }

    public FoodListResponse getAllFoodOfRestaurant(FoodByRestaurantRequest foodByRestaurantRequest) {
        FoodListResponse foodListResponse = new FoodListResponse();
        foodListResponse.setFoodList(foodRepository.getFoodByRestaurant(foodByRestaurantRequest.getRestaurantId()));
        if(foodListResponse.getFoodList().size() <= 0){
            foodListResponse.setMessage("Sorry this restaurant doesn't have any available food items");
        }else{
            foodListResponse.setMessage("This restaurant has total " + foodListResponse.getFoodList().size() + " items available in its menu.");
        }
        return foodListResponse;
    }
}
