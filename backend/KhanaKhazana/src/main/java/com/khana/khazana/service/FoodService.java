package com.khana.khazana.service;

import com.khana.khazana.model.Food;
import com.khana.khazana.model.Restaurant;
import com.khana.khazana.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public List<Restaurant> getAllRestaurantsWithSpecificFood(String food) {
        return foodRepository.findRestaurantByFood(food);
    }

    public List<Food> getAllFoodItems() {
        return foodRepository.findAll();
    }
}
