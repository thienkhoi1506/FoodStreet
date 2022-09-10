package com.streetfood.service.interfaces;

import com.streetfood.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> getProduct(Map<String, String> params, int page);

    int countProduct();
    Product getProductById (long id);
    void addOrUpdateProduct(Product p);
    void deleteProduct(long id);
}
