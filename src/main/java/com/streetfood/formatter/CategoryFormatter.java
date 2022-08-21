package com.streetfood.formatter;

import com.streetfood.pojo.Category;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    @Override
    public Category parse(String cateId, Locale locale) throws ParseException {
        Category c = new Category();
        c.setId(Integer.parseInt(cateId));
        return c;
    }

    @Override
    public String print(Category object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
