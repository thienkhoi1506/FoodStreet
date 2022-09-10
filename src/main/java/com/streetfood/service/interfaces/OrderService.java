package com.streetfood.service.interfaces;

import com.streetfood.pojo.Cart;

import java.util.Map;

public interface OrderService {
    boolean addBill(Map<Integer, Cart> cart);
}
