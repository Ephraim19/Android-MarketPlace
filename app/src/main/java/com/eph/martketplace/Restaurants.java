package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.eph.martketplace.databinding.ActivityRestaurantsBinding;

public class Restaurants extends AppCompatActivity {
    private final String[] food = new String[] {"Large pizza @ Ksh 1200","Small pizza @ Ksh 1200","Meat steak @ Ksh 700","Chicken wings @ Ksh 500"
            ,"A glass of wine @ Ksh 350", "Apples @ Ksh 100","Avocados @ Ksh 100", "Bananas @ Ksh 120", "Blueberries @ Ksh 200","Strawberries @ Ksh 250"
    };
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









