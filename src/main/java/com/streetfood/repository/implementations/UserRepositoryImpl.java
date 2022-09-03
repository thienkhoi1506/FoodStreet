package com.streetfood.repository.implementations;

import com.streetfood.pojo.User;
import com.streetfood.repository.interfaces.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public boolean addUser(User user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            user.setDeleted(false);
            session
                    .save(user);
            return true;
        } catch (HibernateException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public User getUsers(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        if (!username.isEmpty()){
            Predicate predicate = b.equal(root.get("username").as(String.class), username.trim());
            q = q.where(predicate);
        }

        Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }

//    @Override
//    public List<User> getListUsers(String username) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<User> q = b.createQuery(User.class);
//        Root root = q.from(User.class);
//        q = q.select(root);
//
//        if (!username.isEmpty()){
//            Predicate predicate = b.equal(root.get("username").as(String.class), username.trim());
//            q = q.where(predicate);
//        }
//
//        Query query = session.createQuery(q);
//        return query.getResultList();
//    }
}
