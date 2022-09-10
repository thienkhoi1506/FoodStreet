package com.streetfood.service.implementations;

import com.streetfood.pojo.Restaurant;
import com.streetfood.repository.interfaces.RetaurantRepository;
import com.streetfood.service.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RetaurantRepository restaurantRepository;
    @Override
    public List<Restaurant> getRestaurant(Map<String, String> params, int page) {
        return this.restaurantRepository.getRestaurant( params, page);
    }

    @Override
    public int countRestaurant() {
        return this.restaurantRepository.countRestaurant();
    }
}
