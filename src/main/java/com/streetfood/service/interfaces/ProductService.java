package com.streetfood.service.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getProduct(Map<String, String> params, int page);

    int countProduct();
    Product getProductById (int id);
    boolean addProduct(Product p);
    boolean deleteProduct(int id);
}
