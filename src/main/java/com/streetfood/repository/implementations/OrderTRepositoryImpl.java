package com.streetfood.repository.implementations;

import com.streetfood.pojo.Order;
import com.streetfood.repository.interfaces.OrderTRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class OrderTRepositoryImpl implements OrderTRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Order> getOrder() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Order ");

        return q.getResultList();
    }
}
