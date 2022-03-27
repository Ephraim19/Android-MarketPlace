package com.eph.martketplace;

import android.content.Context;
import android.widget.ArrayAdapter;

public class RestaurantArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mPrice;
    private String[] mFood;
    public RestaurantArrayAdapter(Context mContext, int resource,String[] mFood,String[] mPrice){
        super(mContext,resource);
        this.mContext = mContext;
        this.mFood = mFood;
        this.mPrice = mPrice;
    }
    @Override
    public Object getItem(int position){
        String food = mFood[position];
        String price = mPrice[position];
        return String.format("%s ");
    }
}
