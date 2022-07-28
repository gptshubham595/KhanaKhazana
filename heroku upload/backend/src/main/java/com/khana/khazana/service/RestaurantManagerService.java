package com.khana.khazana.service;

import com.khana.khazana.model.*;
import com.khana.khazana.repository.FoodRepository;
import com.khana.khazana.repository.RestaurantRepository;
import com.khana.khazana.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.khana.khazana.service.UserService.isLoggedIn;

@Service
public class RestaurantManagerService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodRepository foodRepository;

    public void AddRestaurantEntries(RestaurantUtility restaurantUtility){
        Restaurant restaurant = new Restaurant();
        restaurant.setManagerId(restaurantUtility.getManagerId());
        restaurant.setRestaurantId(restaurantUtility.getRestaurantId());
        restaurant.setRestaurantRating(restaurantUtility.getRestaurantRating());
        restaurant.setRestaurantAddress(restaurantUtility.getRestaurantAddress());
        restaurant.setRestaurantDescription(restaurantUtility.getRestaurantDescription());
        restaurant.setRestaurantImage(restaurantUtility.getRestaurantImage());
        restaurant.setRestaurantName(restaurantUtility.getRestaurantName());

        restaurantRepository.save(restaurant);
    }
    public DefaultResponse addRestaurant(RestaurantUtility addRestaurantRequest) {
        boolean currRestaurant = restaurantRepository.existsByRestaurantId(addRestaurantRequest.getRestaurantId());
        Users user = userRepository.findByUserId(addRestaurantRequest.getManagerId());
        DefaultResponse response = new DefaultResponse();
        WhichUserRequest whichUserRequest = new WhichUserRequest();
        whichUserRequest.setUserId(addRestaurantRequest.getManagerId());
        whichUserRequest.setToken(addRestaurantRequest.getToken());
        WhichUserResponse whichUserResponse = isLoggedIn(whichUserRequest);

        if (currRestaurant) {
            response.setStatus(false);
            response.setMessage("Restaurants already exists");
        } else if (user == null) {
            response.setStatus(false);
            response.setMessage("Manager doesn't exists");
        } else if (user.getRole().equals("manager") && whichUserResponse.isStatus()) {
            addRestaurantRequest.setRestaurantRating(1.0);
            addRestaurantRequest.setManagerId(user.getUserId());

            AddRestaurantEntries(addRestaurantRequest);
            response.setStatus(true);
            response.setMessage("Restaurants added successfully");
        } else {
            response.setStatus(false);
            response.setMessage("ERR!");
        }

        return response;
    }

    public DefaultResponse addFood(Food addFoodRequest) {
        DefaultResponse defaultResponse = new DefaultResponse();
        List<Food> currFoodList = foodRepository.findSameFoodTitleAndRestaurantId(addFoodRequest.getFoodTitle(), addFoodRequest.getRestaurantId());
//        Food food=foodRepository.findByFoodId(addFoodRequest.getFoodId());
        Restaurant restaurant = restaurantRepository.findByRestaurantId(addFoodRequest.getRestaurantId());
        if (currFoodList.size() > 0) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Food \"" + addFoodRequest.getFoodTitle() + "\" already exists for " + restaurant.getRestaurantName());
        } else {
            foodRepository.save(addFoodRequest);
            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Food \"" + addFoodRequest.getFoodTitle() + "\" saved successfully for " + restaurant.getRestaurantName());
        }
        return defaultResponse;
    }

    public DefaultResponse deleteFood(DeleteFoodRequest deleteFoodRequest) {

        DefaultResponse defaultResponse = new DefaultResponse();
        Food food = foodRepository.findByFoodId(deleteFoodRequest.getFoodId());
        if (food == null) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("INVALID FOOD ID!");
            return defaultResponse;
        }
        if (food.getRestaurantId()!=deleteFoodRequest.getRestaurantId() ) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("RESTAURANT ID MATCH FAILED!");
            return defaultResponse;
        }
        Restaurant restaurant = restaurantRepository.findByRestaurantId(deleteFoodRequest.getRestaurantId());
        if (restaurant == null) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("INVALID RESTAURANT ID!");
            return defaultResponse;
        }
        Long deleteFoodStatus = foodRepository.deleteByFoodId(deleteFoodRequest.getFoodId());
        if (deleteFoodStatus>0) {
            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Food \"" + food.getFoodTitle() + "\" removed successfully from " + restaurant.getRestaurantName());
        } else {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("DELETE FAILED!");
            return defaultResponse;
        }
        return defaultResponse;
    }

    public DefaultResponse updateFood(UpdateFoodRequest updateFoodRequest) {
        DefaultResponse defaultResponse = new DefaultResponse();
        Food food = foodRepository.findByFoodId(updateFoodRequest.getFoodId());
        if (food == null) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Food Does Not Exist!");
            return defaultResponse;
        }
        boolean foodList = foodRepository.existsByFoodIdAndRestaurantId(updateFoodRequest.getFoodId(), updateFoodRequest.getRestaurantId());
        if (!foodList) {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Food AND Restraunt ID MATCH FAILED!");
            return defaultResponse;
        }
        String foodTitle = updateFoodRequest.getFoodTitle() != null ? updateFoodRequest.getFoodTitle() : food.getFoodTitle();
        String foodDesc = updateFoodRequest.getFoodDesc() != null ? updateFoodRequest.getFoodDesc() : food.getFoodDesc();
        Double foodCost = updateFoodRequest.getFoodCost() != null ? updateFoodRequest.getFoodCost() : food.getFoodCost();
        String foodPic = updateFoodRequest.getFoodPic() != null ? updateFoodRequest.getFoodPic() : food.getFoodPic();
        String foodType = updateFoodRequest.getFoodType() != null ? updateFoodRequest.getFoodType() : food.getFoodType();

        int updateStatus = foodRepository.updateFoodTableByFoodId(foodTitle,
                foodDesc,
                foodCost,
                foodPic,
                foodType,
                updateFoodRequest.getFoodId(),
                updateFoodRequest.getRestaurantId()
        );
        if (updateStatus>0) {
            defaultResponse.setStatus(true);
            defaultResponse.setMessage("Updated Successfully!");
        } else {
            defaultResponse.setStatus(false);
            defaultResponse.setMessage("Update failed!");
        }
        return defaultResponse;
    }
}
