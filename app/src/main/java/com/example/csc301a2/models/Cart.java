package com.example.csc301a2.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<Product, CartItem> inventory;

    public Cart() {
        inventory = new LinkedHashMap<>();
    }

    public void addProduct(Product product) {
        if (inventory.containsKey(product)) {
            CartItem item = inventory.get(product);
            assert item != null;
            item.setQuantity(item.getQuantity() + 1);
        } else {
            inventory.put(product, new CartItem(product.getName(), product.getPrice(), 1));
        }
    }

    public Map<Product, CartItem> getCart() {
        return inventory;
    }

    public void changeQuantityForProduct(Product product, int newQuantity) {
        if (newQuantity == 0) {
            inventory.remove(product);
        } else {
            CartItem item = inventory.get(product);
            assert item != null;
            item.setQuantity(newQuantity);
        }
    }

    public void clearCart() {
        inventory.clear();
    }
}
