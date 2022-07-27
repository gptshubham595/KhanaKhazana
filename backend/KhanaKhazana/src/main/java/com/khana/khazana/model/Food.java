package com.khana.khazana.model;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;

    @Column(nullable = false, length = 50)
    private String foodTitle;

    @Column(nullable = false, length = 200)
    private String foodDesc;

    @Column(nullable = false)
    private Double foodCost;

    @Column(nullable = false, length = 255)
    private String foodPic;

    @Column(nullable = false)
    private boolean foodType;
    // False for VEG True for NONVEG

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public Double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(Double foodCost) {
        this.foodCost = foodCost;
    }

    public String getFoodPic() {
        return foodPic;
    }

    public void setFoodPic(String foodPic) {
        this.foodPic = foodPic;
    }

    public boolean isFoodType() {
        return foodType;
    }

    public void setFoodType(boolean foodType) {
        this.foodType = foodType;
    }
}
