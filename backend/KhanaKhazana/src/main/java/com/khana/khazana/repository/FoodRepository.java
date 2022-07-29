package com.khana.khazana.repository;

import com.khana.khazana.model.Food;
import com.khana.khazana.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByFoodId(Long foodId);

    @Query(value="Select * from restaurant where restaurant_id = (select restaurant_id from food where food_title LIKE '%?1%' or food_desc like '%?1') or restaurant_name LIKE '%?1%'",nativeQuery = true)
    List<Restaurant> findRestaurantByFood(String food);

    List<Food> findAll();

    boolean existsByFoodId(Long foodId);

    @Query(value = "Select * from food where food_title=?1 and restaurant_id=?2", nativeQuery = true)
    List<Food> findSameFoodTitleAndRestaurantId(String foodTitle, Long foodRestaurantId);

    List<Food> findAllByFoodType(String foodType);

    boolean existsByFoodIdAndRestaurantId(Long foodId, Long foodRestaurantId);

    @Modifying(clearAutomatically = true)
    @Transactional
    Long deleteByFoodId(Long foodId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "update  food set food_title=?1,food_desc=?2,food_cost=?3,food_pic=?4,food_type=?5 where food_id=?6 and restaurant_id=?7", nativeQuery = true)
    int updateFoodTableByFoodId(String foodTitle, String FoodDesc, Double FoodCost, String Foodpic, String FoodType, Long FoodId, Long RestaurantId);

    List<Food> findAllByRestaurantId(Long restaurantId);

//    boolean find
}
