package com.khana.khazana.service;

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
}
