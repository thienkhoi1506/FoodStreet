package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;
import java.util.Map;


public interface ProductRepository {
    List<Product> getProduct(Map<String, String> params, int page);

    int countProduct();
    Product getProductById (long id);
    void addOrUpdateProduct(Product p);
    void deleteProduct(long id);
}
