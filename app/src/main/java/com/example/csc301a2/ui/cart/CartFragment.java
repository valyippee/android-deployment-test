package com.example.csc301a2.ui.cart;

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
import com.example.csc301a2.adaptors.CartListAdaptor;
import com.example.csc301a2.databinding.FragmentCartBinding;
import com.example.csc301a2.models.CartItem;

import com.example.csc301a2.ui.home.HomeViewModel;
import com.example.csc301a2.ui.home.HomeViewModelFactory;

import java.util.List;
import java.util.Objects;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";

    private FragmentCartBinding binding;
    private HomeViewModel homeViewModel;
    private CartListAdaptor adaptor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "on view created");

        CartItem item1 = new CartItem("Clean Architecture!!!!!!", 150.00, 1);
        CartItem item2 = new CartItem("book2", 50.00, 1);
        CartItem item3 = new CartItem("book3", 50.00, 5);
//        List<CartItem> cartItems = new ArrayList<>();
//        cartItems.add(item1);
//        cartItems.add(item2);
//        cartItems.add(item3);


        ListView cartListView = (ListView) Objects.requireNonNull(getView()).findViewById(R.id.cartListView);
        homeViewModel = new ViewModelProvider(this, new HomeViewModelFactory())
                .get(HomeViewModel.class);
        List<CartItem> cartItems = homeViewModel.getCartItemsObserver().getValue();

        adaptor = new CartListAdaptor(Objects.requireNonNull(getContext()), R.layout.cart_row, cartItems);
        homeViewModel.getProductListObserver().observe(this, p -> {
            adaptor.notifyDataSetChanged();
        });

        cartListView.setAdapter(adaptor);
    }
    
    @Override
    public void onDestroyView() {
        Log.v(TAG, "view destroyed");
        super.onDestroyView();
        binding = null;
    }
}