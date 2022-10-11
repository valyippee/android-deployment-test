package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.Product;

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
    public void addProduct(Product product) {
        cart.addProduct(product);
    }

    @Override
    public void changeQuantityForProduct(Product product, int newQuantity) {
        cart.changeQuantityForProduct(product, newQuantity);
    }

}
