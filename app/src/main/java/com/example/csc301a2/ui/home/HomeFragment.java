package com.example.csc301a2.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.csc301a2.R;
import com.example.csc301a2.adaptors.ProductListAdaptor;
import com.example.csc301a2.databinding.FragmentHomeBinding;
import com.example.csc301a2.models.Product;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "on view created");
        Product product1 = new Product("Clean Architecture!!!!!!", 150.00);
        Product product2 = new Product("Book2", 50.00);
        Product product3 = new Product("Book3", 50.00);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        ProductListAdaptor adaptor = new ProductListAdaptor(Objects.requireNonNull(getContext()), R.layout.shop_row, products);

        ListView productListView = (ListView) Objects.requireNonNull(getView()).findViewById(R.id.productListView);
        productListView.setAdapter(adaptor);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}