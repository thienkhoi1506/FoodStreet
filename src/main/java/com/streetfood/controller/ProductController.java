package com.streetfood.controller;

import com.cloudinary.Cloudinary;
import com.streetfood.pojo.Product;
import com.streetfood.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }

    @GetMapping("/products/{productId}")
    public String productDetail(Model model, @PathVariable(value = "productId") long id){
        model.addAttribute("products", this.productService.getProductById(id));
        return "details";
    }

    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute(value = "product") @Valid Product product){
        this.productService.addOrUpdateProduct(product);
        return "redirect:/products";

    }
    @GetMapping("/products/edit/")
    public String showUpdateProduct(@RequestParam(value = "productId") long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "products";
    }


    @DeleteMapping("/products/delete/{productId}")
    public void deleteProduct(@RequestParam(value = "productId") long id){
         productService.deleteProduct(id);
    }

}
