package com.example.csc301a2.ui.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProvider;

import com.example.csc301a2.R;
import com.example.csc301a2.adaptors.CartListAdaptor;
import com.example.csc301a2.adaptors.ProductListAdaptor;
import com.example.csc301a2.databinding.FragmentCartBinding;
import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;

import java.util.ArrayList;
import java.util.Objects;

public class CartFragment extends Fragment {

    private static final String TAG = "CartFragment";

    private FragmentCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        CartViewModel dashboardViewModel =
//                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(CartViewModel.class);

        binding = FragmentCartBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "on view created");

        CartItem item1 = new CartItem("Clean Architecture!!!!!!", 150.00, 1);
        CartItem item2 = new CartItem("book2", 50.00, 1);
        CartItem item3 = new CartItem("book3", 50.00, 5);
        ArrayList<CartItem> cartItems = new ArrayList<>();
        cartItems.add(item1);
        cartItems.add(item2);
        cartItems.add(item3);

        CartListAdaptor adaptor = new CartListAdaptor(Objects.requireNonNull(getContext()), R.layout.cart_row, cartItems);

        ListView cartListView = (ListView) Objects.requireNonNull(getView()).findViewById(R.id.cartListView);
        cartListView.setAdapter(adaptor);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}