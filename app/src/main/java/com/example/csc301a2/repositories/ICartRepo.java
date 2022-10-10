package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Cart;
import com.example.csc301a2.models.Product;

public interface ICartRepo {
    Cart getCart();
    int addProduct(Product product);
    void changeQuantityForProduct(Product product, int newQuantity);
}
