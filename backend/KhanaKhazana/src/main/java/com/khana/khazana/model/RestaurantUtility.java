package com.khana.khazana.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantUtility {
    private long restaurantId;
    private String restaurantName;
    private String restaurantDescription;
    private Double restaurantRating;
    private String restaurantAddress;
    private String restaurantImage;
    private long managerId;
    private String token;
}
