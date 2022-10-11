package com.example.csc301a2.ui.cart;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;
import com.example.csc301a2.repositories.ICartRepo;
import com.example.csc301a2.repositories.IProductRepo;

import java.util.List;
import java.util.Map;

public class CartViewModel extends ViewModel {

    private final MutableLiveData<List<CartItem>> cartInfo;
    private final ICartRepo cartRepo;
    private final IProductRepo productRepo;

    public CartViewModel(IProductRepo productRepo, ICartRepo cartRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
        cartInfo = new MutableLiveData<>();
    }

    public MutableLiveData<List<CartItem>> getCartInfoObserver() {
        return cartInfo;
    }

    public void loadCartInfo() {
        List<CartItem> cart = cartRepo.getCartItems();
        if (cart.size() > 0) {
            cartInfo.setValue(cart);
        }
//        else {
//            cartInfo.setValue(null);
//        }
    }

    public void changeQuantity(String productName, int newQuantity) {
        Product product = productRepo.getProductByName(productName);
        cartRepo.changeQuantityForProduct(product, newQuantity);
        loadCartInfo();
    }
}