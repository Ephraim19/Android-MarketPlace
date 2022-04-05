package com.eph.martketplace.adapters;

import android.content.Context;
import android.icu.text.StringPrepParseException;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FashionAdapters extends RecyclerView.Adapter<FashionAdapters.MyViewHolder> {
    public String[] price;
    public  String[] description;
    public int[] images;
    Context context;

    public FashionAdapters(Context context,String[] price, String[] description, int[] images) {
        this.context = context;
        this.price = price;
        this.description = description;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
