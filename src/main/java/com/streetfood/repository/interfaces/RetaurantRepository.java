package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Restaurant;

import java.util.List;
import java.util.Map;

public interface RetaurantRepository {
    List<Restaurant> getRestaurant(Map<String, String> params, int page);
    int countRestaurant();
}
