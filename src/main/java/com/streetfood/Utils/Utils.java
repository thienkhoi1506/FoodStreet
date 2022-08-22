package com.streetfood.Utils;

import com.streetfood.pojo.Cart;

import java.util.Map;

public class Utils {
    public static int countCart(Map<Integer, Cart> cart){
        int c=0;
        for (Cart ca: cart.values())
            c += ca.getCount();
        return c;
    }
}
