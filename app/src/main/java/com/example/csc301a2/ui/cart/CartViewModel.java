package com.example.csc301a2.ui.cart;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class CartViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cart fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}