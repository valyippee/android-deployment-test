package com.example.csc301a2.ui.home;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csc301a2.R;
import com.example.csc301a2.adaptors.ProductListAdaptor;
import com.example.csc301a2.databinding.FragmentHomeBinding;
import com.example.csc301a2.models.Product;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment implements View.OnClickListener, ProductListAdaptor.ProductInterface{

    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private Button b;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
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

        ListView productListView = (ListView) Objects.requireNonNull(getView()).findViewById(R.id.productListView);

         homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory())
                 .get(HomeViewModel.class);
        ProductListAdaptor adaptor = new ProductListAdaptor(Objects.requireNonNull(getContext()), R.layout.shop_row, homeViewModel.getProductListObserver().getValue(), this);
         homeViewModel.getProductListObserver().observe(this, p -> {
             adaptor.notifyDataSetChanged();
         });
        productListView.setAdapter(adaptor);

//        ProductListAdaptor adaptor = new ProductListAdaptor(Objects.requireNonNull(getContext()), R.layout.shop_row, products);


//        ListView productListView = (ListView) Objects.requireNonNull(getView()).findViewById(R.id.productListView);
//        productListView.setAdapter(adaptor);

    }

    @Override
    public void onDestroyView() {
        Log.v(TAG, "view destroyed");
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addToCartButton:
                System.out.println("123");
                break;
            default:
                System.out.print("321");
        }
    }

    @Override
    public void addProduct(String name, double price) {
        homeViewModel.addProduct();
    }

    @Override
    public void addProductToCart(String productName) {
        homeViewModel.addToCart(productName);
    }
}