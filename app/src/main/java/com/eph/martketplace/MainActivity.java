package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "marketplace home";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(binding.getRoot());

        binding.FashionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Fashion",Toast.LENGTH_LONG).show();
                Intent FashionScreen = new Intent(MainActivity.this,FashionActivity.class);
                startActivity(FashionScreen);
            }
        });

        binding.RestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Restaurants",Toast.LENGTH_LONG).show();
                Intent RestaurantScreen = new Intent(MainActivity.this,Restaurants.class);
                startActivity(RestaurantScreen);
            }
        });
    }
}










