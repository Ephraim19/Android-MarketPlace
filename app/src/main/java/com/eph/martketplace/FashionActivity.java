package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.databinding.ActivityFashion2Binding;

public class FashionActivity extends AppCompatActivity {
    private ActivityFashion2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFashion2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(binding.getRoot());

        binding.SuitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Men Suits",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.ShoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Shoes...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.nikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Nike shoes...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.shortsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"shorts...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.tshirtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"T-shirt...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.jeansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"jeans...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });
    }

}






