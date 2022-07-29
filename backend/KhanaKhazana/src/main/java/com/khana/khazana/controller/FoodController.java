package com.khana.khazana.controller;

import com.khana.khazana.model.FoodListResponse;
import com.khana.khazana.model.RestaurantListResponse;
import com.khana.khazana.service.FoodService;
import com.khana.khazana.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    FoodService foodService;

    //List all restaurant with specific menu item
    @GetMapping("/search/{food}")
    public ResponseEntity<RestaurantListResponse> getAllRestaurantsWithSpecificFood(@PathVariable String food){
        RestaurantListResponse restaurantListResponse = new RestaurantListResponse();
        restaurantListResponse.setRestaurantList(foodService.getAllRestaurantsWithSpecificFood(food));
        if(restaurantListResponse.getRestaurantList().size() == 0){
            restaurantListResponse.setMessage("Sorry no restaurant is open now that has " + food);
        }else{
            restaurantListResponse.setMessage("We found total " + restaurantListResponse.getRestaurantList().size() + " restaurants with " + food);
        }
        return new ResponseEntity<>(restaurantListResponse, HttpStatus.OK);
    }

    @GetMapping("/restaurant/food/all")
    public ResponseEntity<FoodListResponse> getAllFoodItems(){
        FoodListResponse foodListResponse = new FoodListResponse();
        foodListResponse.setFoodList(foodService.getAllFoodItems());
        if(foodListResponse.getFoodList().size() == 0){
            foodListResponse.setMessage("Sorry we dont have any available food items");
        }else{
            foodListResponse.setMessage("We have total " + foodListResponse.getFoodList().size() + " food items in our menu.");
        }
        return new ResponseEntity<>(foodListResponse,HttpStatus.OK);
    }


}
