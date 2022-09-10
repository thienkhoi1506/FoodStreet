package com.streetfood.repository.implementations;

import com.streetfood.Utils.Utils;
import com.streetfood.pojo.Cart;
import com.streetfood.pojo.OrderDetail;
import com.streetfood.repository.interfaces.OrderRepository;
import com.streetfood.repository.interfaces.OrderTRepository;
import com.streetfood.repository.interfaces.ProductRepository;
import com.streetfood.repository.interfaces.RetaurantRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
@Repository

public class OrderRepositoryImpl implements OrderRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RetaurantRepository retaurantRepository;
    @Autowired
    private OrderTRepository ordertRepository;

    @Override
    @Transactional( propagation = Propagation.REQUIRED)
    public boolean addBill(Map<Integer, Cart> cart) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
                OrderDetail d = new OrderDetail();
                //chưa luư vào database được nha
                d.setTest(1);

                return true;
        }catch (HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }
}
