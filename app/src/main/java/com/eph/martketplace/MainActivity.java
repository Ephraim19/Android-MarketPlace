package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.auth.Login;
import com.eph.martketplace.constant.Constants;
import com.eph.martketplace.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "marketplace home";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.FashionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Fashion",Toast.LENGTH_LONG).show();
                Intent FashionScreen = new Intent(MainActivity.this,MainActivity2.class);
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
        binding.ElectronicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Coming soon",Toast.LENGTH_LONG).show();
            }
        });
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(),"Logged out",Toast.LENGTH_LONG).show();
                Intent loginScreen = new Intent(MainActivity.this, Login.class);
                startActivity(loginScreen);

            }
        });
        binding.imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Listings",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,Listings.class);
                startActivity(intent);
            }
        });
    }
}










