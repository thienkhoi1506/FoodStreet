package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Cart;

import java.util.Map;

public interface OrderRepository {
    boolean addBill(Map<Integer, Cart> cart);
}
