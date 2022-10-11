package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;

public interface ICartRepo {
    Cart getCart();
    void addProduct(Product product);
    void changeQuantityForProduct(Product product, int newQuantity);
}
