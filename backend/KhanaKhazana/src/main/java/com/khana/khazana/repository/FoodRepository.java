package com.khana.khazana.repository;

import com.khana.khazana.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByFoodId(Long foodId);

    boolean existsByFoodId(Long foodId);

    @Query(value = "Select * from food where food_title=?1 and restaurant_id=?2", nativeQuery = true)
    List<Food> findSameFoodTitleAndRestaurantId(String foodTitle, Long foodRestaurantId);

    List<Food> findAllByFoodType(String foodType);


    List<Food> findAllByRestaurantId(Long restaurantId);

//    boolean find
}
