package com.example.csc301a2.repositories;

import com.example.csc301a2.models.Product;

import java.util.ArrayList;

public class ProductRepo implements IProductRepo {
    private ArrayList<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
        products.add(new Product("Calculator", 12.00));
        products.add(new Product("Shelf", 100.00));
        products.add(new Product("Book", 25.00));
        products.add(new Product("Pen", 2.50));
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductByName(String name) {
        for (Product p: products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
