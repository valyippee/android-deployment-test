package com.example.csc301a2.usecases;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;

import java.util.Map;

public class CheckoutPage {
    public double calculatePrice(Cart cart) {
        double totalPrice = 0.0;
        Map<Product, CartItem> m = cart.getCart();
        for (Map.Entry<Product, CartItem> entry : m.entrySet()) {
            double price = entry.getKey().getPrice();
            int count = entry.getValue().getQuantity();
            totalPrice += price * count;
        }
        return totalPrice;
    }

    public double calculatePriceWithTax(Cart cart) {
        return calculatePrice(cart) * 1.13;
    }
}
