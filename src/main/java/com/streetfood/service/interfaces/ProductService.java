package com.streetfood.service.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getProducts(Map<String, String> params, int page);

    int countProduct();

    boolean addProduct(Product p);
}
