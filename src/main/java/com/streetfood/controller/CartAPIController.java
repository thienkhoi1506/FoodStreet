package com.streetfood.controller;

import com.streetfood.Utils.Utils;
import com.streetfood.pojo.Cart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CartAPIController  {
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){
        Map<Integer,Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if(cart ==null)
            cart = new HashMap<>();
        int productId=params.getProductId();
        if(cart.containsKey(productId)){
            Cart c= cart.get(productId);
            c.setCount(c.getCount()+1);
        }
        else{
            cart.put(productId,params);
        }
        session.setAttribute("cart",cart);
        return Utils.countCart(cart);
    }
}
