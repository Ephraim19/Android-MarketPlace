package com.eph.martketplace.adapters;

import android.content.Context;
import android.icu.text.StringPrepParseException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eph.martketplace.R;
import com.eph.martketplace.databinding.MyRowsBinding;

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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_rows,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.MyText1.setText(price[position]);
        holder.MyText2.setText(description[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MyRowsBinding binding;
        TextView MyText1, MyText2;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = binding.images;
            MyText1 = binding.Text1;
            MyText2 = binding.Text1;
        }
    }
}














