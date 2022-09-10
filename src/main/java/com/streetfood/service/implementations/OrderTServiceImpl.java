package com.streetfood.service.implementations;

import com.streetfood.pojo.Order;
import com.streetfood.repository.interfaces.OrderRepository;
import com.streetfood.repository.interfaces.OrderTRepository;
import com.streetfood.service.interfaces.OrderTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderTServiceImpl implements OrderTService {
    @Autowired
    private OrderTRepository orderTRepository;
    @Override
    public List<Order> getOrder() {
        return this.orderTRepository.getOrder();
    }
}
