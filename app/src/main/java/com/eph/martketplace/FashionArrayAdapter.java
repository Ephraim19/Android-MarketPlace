package com.eph.martketplace;

import android.content.Context;
import android.widget.ArrayAdapter;

public class FashionArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mFashion;

    public FashionArrayAdapter(Context mContext, int resource,String[] mFashion){
        super(mContext,resource);
        this.mContext = mContext;
        this.mFashion = mFashion;
    }
    @Override
    public Object getItem(int position){
        String fashion = mFashion[position];
        return fashion;
    }
    @Override
    public int getCount() {
        return mFashion.length;
    }
}











