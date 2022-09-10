package com.streetfood.service.interfaces;

import com.streetfood.pojo.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {
    List<Restaurant> getRestaurant(Map<String, String> params, int page);
    int countRestaurant();
}
