package com.example.csc301a2.ui.home;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.csc301a2.repositories.CartRepo;
import com.example.csc301a2.repositories.ICartRepo;
import com.example.csc301a2.repositories.IProductRepo;
import com.example.csc301a2.repositories.ProductRepo;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IProductRepo productRepo = new ProductRepo();
        ICartRepo cartRepo = new CartRepo();
        return (T) new HomeViewModel(productRepo, cartRepo);
    }
}

    // If a ViewModel class receives dependencies in its constructor,
// provide a factory that implements the ViewModelProvider.Factory interface.
// Override the create(Class<T>, CreationExtras) function to provide a new instance of the ViewModel.