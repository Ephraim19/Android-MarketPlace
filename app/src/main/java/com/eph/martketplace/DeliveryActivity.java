package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eph.martketplace.databinding.ActivityDeliveryBinding;
import com.eph.martketplace.databinding.ActivityLocationBinding;

public class DeliveryActivity extends AppCompatActivity {
    private ActivityDeliveryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        //binding.textView4.setText("yooh");
        //Intent intent = getIntent();
        //String location = intent.getStringExtra("location");
        //binding.textView4.setText("Ephraim");
    }
}