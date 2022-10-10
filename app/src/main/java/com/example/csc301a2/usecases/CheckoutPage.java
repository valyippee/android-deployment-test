package com.example.csc301a2.usecases;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.Product;

import java.util.Map;

public class CheckoutPage {
    public double calculatePrice(Cart cart) {
        double totalPrice = 0.0;
        Map<Product, Integer> m = cart.getInventory();
        for (Map.Entry<Product, Integer> entry : m.entrySet()) {
            double price = entry.getKey().getPrice();
            int count = entry.getValue();
            totalPrice += price * count;
        }
        return calculateTax(totalPrice);
    }

    private double calculateTax(double price) {
        return price * 1.13;
    }
}
