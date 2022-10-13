package com.example.csc301a2.ui.home;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;
import com.example.csc301a2.repositories.CartRepo;
import com.example.csc301a2.repositories.ICartRepo;
import com.example.csc301a2.repositories.IProductRepo;
import com.example.csc301a2.repositories.ProductRepo;
import com.example.csc301a2.usecases.CheckoutPage;

import java.text.DecimalFormat;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Product>> currentProducts;
    private MutableLiveData<List<CartItem>> cartItems;
    private final IProductRepo productRepo;
    private final ICartRepo cartRepo;
    private final CheckoutPage checkoutPage;

    public HomeViewModel(IProductRepo productRepo, ICartRepo cartRepo) {
        this.productRepo = productRepo;
        this.cartRepo = cartRepo;
        this.checkoutPage = new CheckoutPage();
    }

    public LiveData<List<Product>> getProductListObserver() {
        if (currentProducts == null) {
            currentProducts = new MutableLiveData<>();
        }
        loadProducts();
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

    public LiveData<List<CartItem>> getCartItemsObserver() {
        if (cartItems == null) {
            cartItems = new MutableLiveData<>();
        }
        loadCartItems();
        return cartItems;
    }

    public void loadCartItems() {
        List<CartItem> cart = cartRepo.getCartItems();
        if (cartItems.getValue() == null) {
            cartItems.setValue(cart);
        }
        cartItems.getValue().clear();
        cartItems.getValue().addAll(cart);
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

    public String getTotalPrice() {
        return new DecimalFormat("#.##")
                .format(checkoutPage.calculatePrice(cartRepo.getCart()));
    }

    public String getTotalPriceWithTax() {
        return new DecimalFormat("#.##")
                .format(checkoutPage.calculatePriceWithTax(cartRepo.getCart()));
    }

    public void clearCart() {
        cartRepo.clearCart();
        loadCartItems();
    }

    public static class HomeViewModelFactory implements ViewModelProvider.Factory {

        private static final String TAG = "HomeViewModelFactory";

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            IProductRepo productRepo = new ProductRepo();
            ICartRepo cartRepo = new CartRepo();
            Log.v(TAG, "new model created");
            return (T) new HomeViewModel(productRepo, cartRepo);
        }
    }
}