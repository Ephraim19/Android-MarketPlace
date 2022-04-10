package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.constant.Constants;
import com.eph.martketplace.databinding.ActivityLocationBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LocationActivity extends AppCompatActivity {
    private ActivityLocationBinding binding;
    private static final String TAG = "MyActivity";

    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = sharedPreferences.edit();
        //getting the stored location
        String recentLocation = sharedPreferences.getString(Constants.LOCATION_KEY, null);
        //assigning the stored preference as the default value in the location form
        binding.editTextLocation.setText(recentLocation);

        binding.LocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = binding.editTextLocation.getText().toString();
                Toast.makeText(getApplicationContext(),"Submitting Location",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LocationActivity.this,DeliveryActivity.class);

                //Adding shared preference
                if(!(location).equals("")) {
                    addToSharedPreferences(location);
                }
                intent.putExtra("location", location);
                Log.v(TAG,location);
                startActivity(intent);
            }
        });
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.LOCATION_KEY, location).apply();
    }
}














