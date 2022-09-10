package com.streetfood.service.implementations;

import com.streetfood.pojo.Cart;
import com.streetfood.repository.interfaces.OrderRepository;
import com.streetfood.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class OrderServiceIpml implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public boolean addBill(Map<Integer, Cart> cart) {
        if(cart !=null)
             return this.orderRepository.addBill(cart);
        return false;
    }
}
