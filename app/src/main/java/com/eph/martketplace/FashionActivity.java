package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.Interfaces.MyTweetCall;
import com.eph.martketplace.adapters.FashionAdapters;
import com.eph.martketplace.client.TwitterClient;
import com.eph.martketplace.dataModels.TwitterData;
import com.eph.martketplace.databinding.ActivityFashion2Binding;
import com.eph.martketplace.databinding.FashionRecycleViewBinding;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FashionActivity extends AppCompatActivity {
    private ActivityFashion2Binding binding;
    //recycle view data
    String[] price = {"Ksh 6000","Ksh 5500","Ksh 1700","Ksh 1300","Ksh 3200","Ksh 900"};
    String[] description = {"Men suits","Red shoes","Nike Airforce shoes","Grey men shorts","Yellow T-shirts","Blue men jeans"};
    int[] images = {R.drawable.fashion,R.drawable.shoes,R.drawable.nikes1,R.drawable.shorts,R.drawable.tshirt,R.drawable.jeans1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFashion2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(binding.getRoot());

        FashionAdapters adapters = new FashionAdapters(this,price,images);
        //binding.recycle.setAdapter(adapters);
        //bindings.recycle.setLayoutManager(new LinearLayoutManager(this));

        binding.tweet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressBar.setVisibility(view.VISIBLE);
                MyTweetCall client = TwitterClient.getClient();
                TwitterData modal = new TwitterData("Men suits");
                Call<TwitterData> call = client.postTweet(modal);

                call.enqueue(new Callback<TwitterData>() {
                    @Override
                    public void onResponse(Call<TwitterData> call, Response<TwitterData> response) {
                        binding.progressBar.setVisibility(view.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Tweet posted",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<TwitterData> call, Throwable t) {
                        binding.progressBar.setVisibility(view.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
        binding.tweet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.progressBar.setVisibility(view.VISIBLE);
                MyTweetCall client = TwitterClient.getClient();
                TwitterData modal = new TwitterData("Men suits");
                Call<TwitterData> call = client.postTweet(modal);

                call.enqueue(new Callback<TwitterData>() {
                    @Override
                    public void onResponse(Call<TwitterData> call, Response<TwitterData> response) {
                        binding.progressBar.setVisibility(view.INVISIBLE);
                        Toast.makeText(getApplicationContext(),"Tweet posted",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<TwitterData> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_LONG).show();
                        binding.progressBar.setVisibility(view.INVISIBLE);

                    }
                });


            }
        });
        binding.SuitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Men Suits",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.ShoesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Shoes...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.nikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Nike shoes...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.shortsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"shorts...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.tshirtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"T-shirt...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });

        binding.jeansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"jeans...",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FashionActivity.this,LocationActivity.class);
                startActivity(intent);
            }
        });
    }

}







