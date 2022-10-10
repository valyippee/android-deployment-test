package com.example.csc301a2.models;

import android.os.Build;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> inventory;

    public Cart() {
        inventory = new LinkedHashMap<>();
    }

    public int addProduct(Product product) {
        if (inventory.containsKey(product)) {
            inventory.put(product, inventory.get(product) + 1);
        } else {
            inventory.put(product, 0);
        }
        return inventory.get(product);
    }

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public void changeQuantityForProduct(Product product, int newQuantity) {
        if (newQuantity == 0) {
            inventory.remove(product);
        } else {
            inventory.put(product, newQuantity);
        }
    }
}
