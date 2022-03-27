package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.databinding.ActivityLocationBinding;

import java.util.IntSummaryStatistics;

public class LocationActivity extends AppCompatActivity {
    private ActivityLocationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.LocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Submitting Location",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LocationActivity.this,DeliveryActivity.class);
                startActivity(intent);
            }
        });
    }
}