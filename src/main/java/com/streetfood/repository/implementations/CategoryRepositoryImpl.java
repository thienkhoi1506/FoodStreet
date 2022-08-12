package com.streetfood.repository.implementations;

import com.streetfood.pojo.Category;
import com.streetfood.repository.interfaces.CategoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Category> getCategories() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("from Category ");

        return q.getResultList();
    }

}
