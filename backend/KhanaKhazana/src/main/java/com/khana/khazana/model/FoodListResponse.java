package com.khana.khazana.model;

import java.util.List;

public class FoodListResponse {
    private List<Food> foodList;
    private String message;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
