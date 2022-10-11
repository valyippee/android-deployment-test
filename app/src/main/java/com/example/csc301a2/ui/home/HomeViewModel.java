package com.example.csc301a2.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;
import com.example.csc301a2.repositories.ICartRepo;
import com.example.csc301a2.repositories.IProductRepo;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Product>> currentProducts;
    private MutableLiveData<List<CartItem>> cartItems;
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

    public MutableLiveData<List<CartItem>> getCartItemsObserver() {
        if (cartItems == null) {
            cartItems = new MutableLiveData<>();
        }
        loadCartItems();
        System.out.println(cartItems.getValue());
        return cartItems;
    }

    public void loadCartItems() {
        List<CartItem> cart = cartRepo.getCartItems();
//        if (cart.size() > 0) {

            cartItems.setValue(cart);
//        }
//        else {
//            cartItems.setValue(null);
//        }
    }

    public void changeQuantity(String productName, int newQuantity) {
        Product product = productRepo.getProductByName(productName);
        cartRepo.changeQuantityForProduct(product, newQuantity);
        loadCartItems();
    }


    public void addToCart(String productName) {
        Product product = productRepo.getProductByName(productName);
        cartRepo.addProduct(product);
    }

    public void addProduct() {
        productRepo.addProduct();
        loadProducts();
    }

}