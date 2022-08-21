package com.streetfood.repository.implementations;

import com.streetfood.pojo.Product;
import com.streetfood.repository.interfaces.ProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public List<Product> getProduct(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%%", kw));
                predicates.add(p);
            }

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }
        }

        q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size"));
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    public int countProduct() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("select count (*) FROM Product ");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addProduct(Product p) {
        try (Session session = this.sessionFactory.getObject().getCurrentSession()){
                session.beginTransaction();
                Query query = session.createQuery("insert into Product (name)" + "select name from Product ");
                int result = query.executeUpdate();
                System.out.println("Test: " + result);
                session.getTransaction().commit();
        } catch (Exception e){
            System.err.println("Add Product Fail" + e.getMessage());
            e.printStackTrace();
        }
        return false;
//        try {
//            session.save(p);
//            return true;
//        } catch (Exception exception) {
//            System.err.println("Add Product Fail" + exception.getMessage());
//            exception.printStackTrace();
//        }
//        return false;
    }

    @Override
    public boolean addNewProduct(Product p) {
        if(p != null) {
            Session session = sessionFactory.getObject().getCurrentSession();
            //session.save(p);
        }
        return false;
    }
}
