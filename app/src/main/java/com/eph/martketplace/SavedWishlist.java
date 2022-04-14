package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.eph.martketplace.adapters.FashionAdapters;
import com.eph.martketplace.adapters.FirebaseAdapter;
import com.eph.martketplace.dataModels.FashionData;
import com.eph.martketplace.databinding.ActivityMain2Binding;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SavedWishlist extends AppCompatActivity {
    private ActivityMain2Binding binding;
    private FirebaseRecyclerAdapter<FashionData, FirebaseAdapter> mFirebaseAdapter;
    private SharedPreferences mSharedPreferences;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userId = mSharedPreferences.getString("User", null);
        database = FirebaseDatabase.getInstance("https://martketplace-5cda7-default-rtdb.firebaseio.com/").getReference("Wishlist").child(userId);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}


















