package com.streetfood.controller;

import com.streetfood.service.interfaces.CategoryService;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute
    public void commonAttr(Model model){
        model.addAttribute("categories", this.categoryService.getCategories());
    }
    @RequestMapping("/")
    public ModelAndView index(@RequestParam Map<String, String> params, Model model) {
        ModelAndView  modelAndView = new ModelAndView("home");
        return modelAndView;
    }
}
