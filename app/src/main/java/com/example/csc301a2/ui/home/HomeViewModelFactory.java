package com.example.csc301a2.ui.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.example.csc301a2.repositories.CartRepo;
import com.example.csc301a2.repositories.ICartRepo;
import com.example.csc301a2.repositories.IProductRepo;
import com.example.csc301a2.repositories.ProductRepo;

// TODO: Move this into ViewModelClass. Its good practice
// See https://developer.android.com/topic/libraries/architecture/viewmodel#viewmodel-with-dependencies:~:text=Note%3A%20It%27s%20a%20good%20practice%20to%20place%20ViewModel%20factories%20in%20their%20ViewModel%20file%20for%20better%20context%2C%20readability%2C%20and%20easier%20discovery.%20The%20same%20ViewModel%20factory%20can%20be%20used%20for%20multiple%20ViewModels%20when%20they%20share%20dependencies%2C%20as%20it%27s%20the%20case%20for%20the%20Architecture%20Blueprints%20sample.
public class HomeViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        IProductRepo productRepo = new ProductRepo();
        ICartRepo cartRepo = new CartRepo();
        System.out.println("New model");
        return (T) new HomeViewModel(productRepo, cartRepo);
    }
}

    // If a ViewModel class receives dependencies in its constructor,
// provide a factory that implements the ViewModelProvider.Factory interface.
// Override the create(Class<T>, CreationExtras) function to provide a new instance of the ViewModel.