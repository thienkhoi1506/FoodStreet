package com.streetfood.controller;

import com.streetfood.Utils.Utils;
import com.streetfood.pojo.Cart;
import com.streetfood.service.interfaces.CategoryService;
import com.streetfood.service.interfaces.ProductService;
import com.streetfood.service.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@ControllerAdvice
@PropertySource("classpath:page.properties")
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RestaurantService restaurantService;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession sesion){
        //model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("cartCouter", Utils.countCart((Map<Integer, Cart>) sesion.getAttribute("cart")));


    }
    @RequestMapping("/")
    public ModelAndView index(@RequestParam Map<String, String> params, Model model) {
        ModelAndView  modelAndView = new ModelAndView("home");

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getProducts(params, page));

        model.addAttribute("restaurant",this.restaurantService.getRestaurant(params,page));
        return modelAndView;
    }
}
