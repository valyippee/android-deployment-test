package com.example.csc301a2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
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

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);


        Product product = new Product("Clean Architecture!!!!!!", 150.00);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        ProductListAdaptor adaptor = new ProductListAdaptor(Objects.requireNonNull(getContext()), R.layout.fragment_home, products);

//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        ListView productListView = (ListView) view.findViewById(R.id.productListView);
//        productListView.setAdapter(adaptor);
//        return view;


        LayoutInflater factory = getLayoutInflater();
        View productPageView = factory.inflate(R.layout.fragment_home, null);
        ListView productListView = (ListView) productPageView.findViewById(R.id.productListView);
        productListView.setAdapter(adaptor);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}