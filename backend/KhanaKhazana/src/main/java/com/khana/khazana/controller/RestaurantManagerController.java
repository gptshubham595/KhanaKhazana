package com.khana.khazana.controller;

import com.khana.khazana.model.DefaultResponse;
import com.khana.khazana.model.Restaurant;
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
    public ResponseEntity<DefaultResponse> login(@RequestBody Restaurant addRestaurantRequest) {
        DefaultResponse response = restaurantManagerService.addRestaurant(addRestaurantRequest);
        if (response.isStatus()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
