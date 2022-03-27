package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.eph.martketplace.databinding.ActivityRestaurantsBinding;

public class Restaurants extends AppCompatActivity {
    private String[] food = new String[] {"Large pizza","Meat steak","Chicken wings"};
    private String[] price = new String[] {"Ksh 1200","Ksh 700","Ksh 500"};
    private ActivityRestaurantsBinding binding;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        mListView = binding.listView;
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,food);
        mListView.setAdapter(adapter);

    }
}









