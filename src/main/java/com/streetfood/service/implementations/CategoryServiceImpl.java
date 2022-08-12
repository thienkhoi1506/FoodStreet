package com.streetfood.service.implementations;

import com.streetfood.pojo.Category;
import com.streetfood.repository.interfaces.CategoryRepository;
import com.streetfood.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }
}
