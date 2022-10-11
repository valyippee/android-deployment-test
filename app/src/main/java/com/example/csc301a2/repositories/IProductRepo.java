package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Product;

import java.util.ArrayList;

public interface IProductRepo {
    ArrayList<Product> getAllProducts();
    Product getProductByName(String name);
    void addProduct();
}
