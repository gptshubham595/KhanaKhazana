package com.khana.khazana.controller;

import com.khana.khazana.model.Food;
import com.khana.khazana.model.Restaurant;
import com.khana.khazana.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping(value = "/home")
    public String HeartBeat(){
        return "Rest Home";
    }

    @GetMapping("/restaurant/list")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable long restaurantId){
        return restaurantService.getRestaurantsById(restaurantId);
    }

    @GetMapping(value = "/restaurants")
    public Restaurant findRestaurant(@RequestParam(value = "name") String name) {
        return restaurantService.getRestaurantByName(name);
    }
    //List all restaurant with specific menu item
    @GetMapping("/search/{food}")
    public List<Restaurant> getAllRestaurantsWithSpecificFood(@PathVariable String food){
        return restaurantService.getAllRestaurantsWithSpecificFood(food);
    }

    @GetMapping("/food/all")
    public List<Food> getAllFoodItems(){
        return restaurantService.getAllFoodItems();
    }

}
