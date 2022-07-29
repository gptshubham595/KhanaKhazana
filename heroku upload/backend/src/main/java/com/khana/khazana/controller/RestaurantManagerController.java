package com.khana.khazana.controller;

import com.khana.khazana.model.*;
import com.khana.khazana.service.RestaurantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantManagerController {
    @Autowired
    RestaurantManagerService restaurantManagerService;

    @PostMapping(value = "/addRestaurant", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> addRestaurant(@RequestBody RestaurantUtility addRestaurantRequest) {
        DefaultResponse response = restaurantManagerService.addRestaurant(addRestaurantRequest);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/addFoodItem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> addFoodItem(@RequestBody Food addFoodRequest) {
        DefaultResponse response = restaurantManagerService.addFood(addFoodRequest);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/deleteFoodItem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> deleteFoodItem(@RequestBody DeleteFoodRequest deleteFoodRequest) {
        DefaultResponse response = restaurantManagerService.deleteFood(deleteFoodRequest);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/updateFoodItem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DefaultResponse> updateFoodItem(@RequestBody UpdateFoodRequest updateFoodRequest) {
        DefaultResponse response = restaurantManagerService.updateFood(updateFoodRequest);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
