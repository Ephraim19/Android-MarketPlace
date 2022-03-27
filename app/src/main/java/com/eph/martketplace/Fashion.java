package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Fashion extends AppCompatActivity {
    private String[] fashion = new String[] {"Suits","Shorts","T-shirts","Shoes","Tops","Skirts"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);
        FashionArrayAdapter adapter = new FashionArrayAdapter(this, android.R.layout.activity_list_item,fashion);
    }
}