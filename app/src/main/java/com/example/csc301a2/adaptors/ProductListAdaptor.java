package com.example.csc301a2.adaptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.csc301a2.R;
import com.example.csc301a2.models.Product;

import java.util.ArrayList;

public class ProductListAdaptor extends ArrayAdapter<Product> {
    private Context mContext;
    private int mResource;

    public ProductListAdaptor(@NonNull Context context, int resource, ArrayList<Product> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    private static class ViewHolder {
        TextView name;
        TextView price;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getName();
        double price = getItem(position).getPrice();

        final View result;

        //ViewHolder object
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.productNameTextView);
            holder.price = (TextView) convertView.findViewById(R.id.productPriceTextView);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(name);
        holder.price.setText((int) price);

        return convertView;

    }


}
