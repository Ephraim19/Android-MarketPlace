package com.eph.martketplace.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.MainActivity;
import com.eph.martketplace.R;
import com.eph.martketplace.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //logging in a user
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        //Starting sign up activity
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"register",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, Sign_Up.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loginUser() {
        final String email = binding.emailText.getText().toString().trim();
        final String password = binding.passwordText.getText().toString().trim();

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

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,task -> {
                    if(task.isSuccessful()) {
                        Toast.makeText(Login.this, "Logging in...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    // Check if user is signed in
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null){
            Toast.makeText(getApplicationContext(),"Logged in",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
























