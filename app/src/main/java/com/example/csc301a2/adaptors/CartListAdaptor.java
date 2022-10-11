package com.example.csc301a2.adaptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.csc301a2.R;
import com.example.csc301a2.models.CartItem;
import com.example.csc301a2.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartListAdaptor extends ArrayAdapter<CartItem> {
    private final Context mContext;
    private final int mResource;

    public CartListAdaptor(@NonNull Context context, int resource, List<CartItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        String price = "Price: " + String.valueOf(getItem(position).getPrice());
        String quantity = String.valueOf(getItem(position).getQuantity());

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
        }
        ((TextView) convertView.findViewById(R.id.cartNameTextView)).setText(name);
        ((TextView) convertView.findViewById(R.id.cartPriceTextView)).setText(price);
        ((TextView) convertView.findViewById(R.id.cartQuantityTextView)).setText(quantity);

        return convertView;

    }
}
