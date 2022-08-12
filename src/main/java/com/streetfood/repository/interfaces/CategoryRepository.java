package com.streetfood.repository.interfaces;

import com.streetfood.pojo.Category;

import java.util.List;


public interface CategoryRepository {
    List<Category> getCategories();
}
