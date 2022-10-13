package com.example.csc301a2.ui.home;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.csc301a2.R;
import com.example.csc301a2.adaptors.ProductListAdaptor;
import com.example.csc301a2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements ProductListAdaptor.ProductInterface {

    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "on view created");
        ListView productListView = (ListView) requireView().findViewById(R.id.productListView);
        homeViewModel = new ViewModelProvider(requireActivity(), new HomeViewModelFactory())
                .get(HomeViewModel.class);
        ProductListAdaptor adaptor = new ProductListAdaptor(requireContext(), R.layout.shop_row, homeViewModel.getProductListObserver().getValue(), this);
         homeViewModel.getProductListObserver().observe(requireActivity(), p -> {
             adaptor.notifyDataSetChanged();
         });
        productListView.setAdapter(adaptor);
    }

    @Override
    public void onDestroyView() {
        Log.v(TAG, "view destroyed");
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void addProductToCart(String productName) {
        Log.v(TAG, "adding " + productName);
        homeViewModel.addToCart(productName);
    }

}