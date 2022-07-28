package com.khana.khazana.service;

import com.khana.khazana.model.Food;
import com.khana.khazana.model.Restaurant;
import com.khana.khazana.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantsById(long restaurantId) {
        return restaurantRepository.findRestaurantById(restaurantId);
    }

    public Restaurant getRestaurantByName(String name) {
        return restaurantRepository.findRestaurantByName(name);
    }
    public List<Restaurant> getAllRestaurantsWithSpecificFood(String food) {
        return restaurantRepository.findRestaurantByFood(food);
    }

    public List<Food> getAllFoodItems() {
        return restaurantRepository.findAllFoodItems();
    }
}
