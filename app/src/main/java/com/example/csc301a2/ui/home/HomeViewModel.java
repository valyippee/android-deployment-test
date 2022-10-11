package com.example.csc301a2.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.csc301a2.models.Product;
import com.example.csc301a2.repositories.ICartRepo;
import com.example.csc301a2.repositories.IProductRepo;
import com.example.csc301a2.repositories.ProductRepo;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Product>> currentProducts;
    private final IProductRepo productRepo;
    private final ICartRepo cartRepo;

    public HomeViewModel(IProductRepo productRepo, ICartRepo cartRepo) {
        this.productRepo = productRepo;
        this.cartRepo = cartRepo;
    }

    public MutableLiveData<List<Product>> getProductListObserver() {
        if (currentProducts == null) {
            currentProducts = new MutableLiveData<>();
            loadProducts();
        }
        return currentProducts;
    }

    public void loadProducts() {
        List<Product> products = productRepo.getAllProducts();
        if (products.size() > 0) {
            currentProducts.setValue(products);
        } else {
            currentProducts.setValue(null);
        }
    }

    public void addToCart(String productName) {
        Product product = productRepo.getProductByName(productName);
        cartRepo.addProduct(product);
    }


}