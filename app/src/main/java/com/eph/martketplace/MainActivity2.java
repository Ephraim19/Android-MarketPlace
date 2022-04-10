package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.Interfaces.MyTweetCall;
import com.eph.martketplace.adapters.FashionAdapters;
import com.eph.martketplace.client.TwitterClient;
import com.eph.martketplace.dataModels.TwitterData;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private MainActivity2 binding;
    RecyclerView recyclerView;
    //recycle view data
    String[] price = {"Men tuxedo suits that fit you perfectly - Ksh 6000","Red rubber shoes perfect for workouts - Ksh 5500","Nike Airforce 1 shoes, improve your shoe game - Ksh 1700","Grey men shorts for relaxing on hot days - Ksh 1300","Yellow T-shirts, shine from far - Ksh 3200","Blue men jeans that fir perfectly - Ksh 900"};
    int[] id = {1,2,3,4,5,6};
    int[] images = {R.drawable.fashion,R.drawable.shoes,R.drawable.nikes1,R.drawable.greyshorts,R.drawable.tshirt,R.drawable.jeans1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);
        FashionAdapters adapter = new FashionAdapters(this,price,images,id);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}