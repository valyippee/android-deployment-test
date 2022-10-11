package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CartRepo implements ICartRepo {

    private final Cart cart;

    public CartRepo() {
        cart = new Cart();
        cart.addProduct(new Product("123", 2));
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public List<CartItem> getCartItems() {
        List<CartItem> items = new ArrayList<>();
        items.addAll(cart.getCart().values());
        return items;
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
