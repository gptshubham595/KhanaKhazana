package com.khana.khazana.repository;

import com.khana.khazana.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByFoodId(Long foodId);
//    boolean find
}
