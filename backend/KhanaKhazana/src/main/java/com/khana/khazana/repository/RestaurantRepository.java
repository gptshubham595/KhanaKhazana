package com.khana.khazana.repository;

import com.khana.khazana.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    @Query(value="Select * from product_details where pid=?1",nativeQuery = true)
    Restaurant findRestaurantById(long pid);
}
