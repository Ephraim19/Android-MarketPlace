package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.databinding.ActivityLocationBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LocationActivity extends AppCompatActivity {
    private ActivityLocationBinding binding;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.LocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = binding.editTextTextPersonName.getText().toString();
                Toast.makeText(getApplicationContext(),"Submitting Location",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LocationActivity.this,DeliveryActivity.class);
                intent.putExtra("location", location);

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://martketplace-5cda7-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("location");
                myRef.push().setValue(location);

                Log.v(TAG,location);
                startActivity(intent);
            }
        });
    }
}














