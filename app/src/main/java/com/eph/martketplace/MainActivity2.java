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
    String[] price = {"Men suits - Ksh 6000","Red shoes - Ksh 5500","Nike Airforce shoes - Ksh 1700","Grey men shorts - Ksh 1300","Yellow T-shirts - Ksh 3200","Blue men jeans - Ksh 900"};
    String[] description = {"Men suits","Red shoes","Nike Airforce shoes","Grey men shorts","Yellow T-shirts","Blue men jeans"};
    int[] images = {R.drawable.fashion,R.drawable.shoes,R.drawable.nikes1,R.drawable.shoes,R.drawable.tshirt,R.drawable.jeans1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);
        FashionAdapters adapter = new FashionAdapters(this,price,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //binding = MainActivity2.inflate(getLayoutInflater());
        //View view = binding.getRoot();

//        binding.tweet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                binding.progressBar.setVisibility(view.VISIBLE);
//                MyTweetCall client = TwitterClient.getClient();
//                TwitterData modal = new TwitterData("Men suits");
//                Call<TwitterData> call = client.postTweet(modal);
//
//                call.enqueue(new Callback<TwitterData>() {
//                    @Override
//                    public void onResponse(Call<TwitterData> call, Response<TwitterData> response) {
//                        binding.progressBar.setVisibility(view.INVISIBLE);
//                        Toast.makeText(getApplicationContext(),"Tweet posted",Toast.LENGTH_LONG).show();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<TwitterData> call, Throwable t) {
//                        binding.progressBar.setVisibility(view.INVISIBLE);
//                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
//                    }
//                });
//
//                binding.SuitsButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        //Toast.makeText(getApplicationContext(),"Men Suits",Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(MainActivity2.this,LocationActivity.class);
//                        startActivity(intent);
//                    }
//                });

//            }
//        });

    }
}