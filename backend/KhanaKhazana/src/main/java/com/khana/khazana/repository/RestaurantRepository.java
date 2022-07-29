package com.khana.khazana.repository;

import com.khana.khazana.model.Food;
import com.khana.khazana.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "Select * from product_details where restaurant_id=?1", nativeQuery = true)
    Restaurant findRestaurantById(long restaurant_id);

    Restaurant findByRestaurantId(long pid);

    boolean existsByRestaurantId(long pid);

    Restaurant findByManagerId(long managerId);

    List<Restaurant> findAll();

    @Query(value="Select * from restaurant where restaurant_name=?1",nativeQuery = true)
    Restaurant findRestaurantByName(String restaurant_name);

    Restaurant findByRestaurantId(Long restaurantId);

}
