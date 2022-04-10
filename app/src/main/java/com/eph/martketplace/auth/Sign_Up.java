package com.eph.martketplace.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.R;
import com.eph.martketplace.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_Up extends AppCompatActivity {
    private static final String TAG = "Sign up";
    private FirebaseAuth mAuth;
    private ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //initializing firebase auth
        mAuth = FirebaseAuth.getInstance();
        Log.d( TAG, String.valueOf(mAuth));

        //Starting login up activity
        binding.LoginView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Login...",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Sign_Up.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        binding.regiserUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }

    private void createUser() {
        final String email = binding.emailText.getText().toString().trim();
        final String password = binding.passwordText.getText().toString().trim();
        final String confirmPassword = binding.confirmPasswordText.getText().toString().trim();

        if(email.isEmpty()){
            binding.emailText.setError("Email is required");
            binding.emailText.requestFocus();
            return;
        }

        if(password.isEmpty()){
            binding.passwordText.setError("Password is required");
            binding.passwordText.requestFocus();
            return;
        }

        if(confirmPassword.isEmpty()){
            binding.confirmPasswordText.setError("Enter your password again");
            binding.confirmPasswordText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailText.setError("Enter a valid email");
            binding.emailText.requestFocus();
            return;
        }

        if(password.length() < 6){
            binding.passwordText.setError("Your password must have 6 or more characters");
            binding.passwordText.requestFocus();
            return;
        }

        if(!password.equals(confirmPassword)){
            binding.confirmPasswordText.setError("Passwords do not match");
            binding.confirmPasswordText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    binding.progressBar3.setVisibility(View.VISIBLE);
                    if (task.isSuccessful()) {
                        Toast.makeText(Sign_Up.this, "Authentication successful.", Toast.LENGTH_SHORT).show();
                        Log.d( TAG, "Authentication successful");

                        //Opening login intent
                        Toast.makeText(getApplicationContext(),"Login...",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Sign_Up.this, Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        binding.progressBar3.setVisibility(View.INVISIBLE);
                        startActivity(intent);

                    } else{
                        binding.progressBar3.setVisibility(View.INVISIBLE);
                        Log.d( "mail", email);
                        Toast.makeText(Sign_Up.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }
}















