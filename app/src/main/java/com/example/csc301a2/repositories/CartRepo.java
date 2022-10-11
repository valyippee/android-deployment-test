package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.Product;

import java.util.ArrayList;
import java.util.Map;

public class CartRepo implements ICartRepo {

    private final Cart cart;

    public CartRepo() {
        this.cart = new Cart();
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public int addProduct(Product product) {
        return cart.addProduct(product);
    }

    @Override
    public void changeQuantityForProduct(Product product, int newQuantity) {
        cart.changeQuantityForProduct(product, newQuantity);
    }

}
