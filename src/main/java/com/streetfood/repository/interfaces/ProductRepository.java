package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;
import java.util.Map;


public interface ProductRepository {
    List<Product> getProduct(Map<String, String> params, int page);

    int countProduct();

    boolean addProduct(Product p);
    boolean addNewProduct(Product p);
}
