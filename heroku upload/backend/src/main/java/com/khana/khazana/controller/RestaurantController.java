package com.khana.khazana.controller;

import com.khana.khazana.model.*;
import com.khana.khazana.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/restaurant/list")
    public ResponseEntity<RestaurantListResponse> getAllRestaurants(){
        RestaurantListResponse restaurantListResponse = new RestaurantListResponse();
        restaurantListResponse.setRestaurantList(restaurantService.getRestaurants());
        if(restaurantListResponse.getRestaurantList().size() == 0){
            restaurantListResponse.setMessage("Sorry no restaurant is open now.");
        }else{
            restaurantListResponse.setMessage("We found total " + restaurantListResponse.getRestaurantList().size() + " restaurants");
        }
        return new ResponseEntity<>(restaurantListResponse, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable long restaurantId){
        RestaurantResponse restaurantRequested = restaurantService.getRestaurantsById(restaurantId);
        if(restaurantRequested.getMessage().equals("Success"))
        return new ResponseEntity<>(restaurantRequested,HttpStatus.OK);
        else return new ResponseEntity<>(restaurantRequested,HttpStatus.BAD_REQUEST);

    }

    @GetMapping(value = "/restaurants")
    public ResponseEntity<RestaurantResponse> findRestaurant(@RequestParam(value = "name") String name) {
        RestaurantResponse restaurantRequested = restaurantService.getRestaurantByName(name);
        if(restaurantRequested.getMessage().equals("Success"))
            return new ResponseEntity<>(restaurantRequested,HttpStatus.OK);
        else return new ResponseEntity<>(restaurantRequested,HttpStatus.BAD_REQUEST);
    }

    //List all restaurant with specific menu item
    @GetMapping("/search/{food}")
    public ResponseEntity<RestaurantListResponse> getAllRestaurantsWithSpecificFood(@PathVariable String food){
        RestaurantListResponse restaurantListResponse = new RestaurantListResponse();
        restaurantListResponse.setRestaurantList(restaurantService.getAllRestaurantsWithSpecificFood(food));
        if(restaurantListResponse.getRestaurantList().size() == 0){
            restaurantListResponse.setMessage("Sorry no restaurant is open now that has " + food);
        }else{
            restaurantListResponse.setMessage("We found total " + restaurantListResponse.getRestaurantList().size() + " restaurants with " + food);
        }
        return new ResponseEntity<>(restaurantListResponse, HttpStatus.OK);
    }

    @GetMapping("/food/all")
    public ResponseEntity<FoodListResponse> getAllFoodItems(){
        FoodListResponse foodListResponse = new FoodListResponse();
        foodListResponse.setFoodList(restaurantService.getAllFoodItems());
        if(foodListResponse.getFoodList().size() == 0){
            foodListResponse.setMessage("Sorry we dont have any available food items");
        }else{
            foodListResponse.setMessage("We have total " + foodListResponse.getFoodList().size() + " food items in our menu.");
        }
        return new ResponseEntity<>(foodListResponse,HttpStatus.OK);
    }

}
