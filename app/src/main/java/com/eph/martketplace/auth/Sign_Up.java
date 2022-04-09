package com.eph.martketplace.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.eph.martketplace.R;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_Up extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //initializing firebase auth
        mAuth = FirebaseAuth.getInstance();
    }

    //Checking to see if user is signed in
}