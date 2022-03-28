package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.eph.martketplace.databinding.ActivityDeliveryBinding;

public class DeliveryActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private ActivityDeliveryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_delivery);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        Log.v(TAG,location);
        binding.MyLocation.setText(location);
    }
}