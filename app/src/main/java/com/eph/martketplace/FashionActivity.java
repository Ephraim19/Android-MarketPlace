package com.eph.martketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eph.martketplace.Interfaces.MyTweetCall;
import com.eph.martketplace.client.TwitterClient;
import com.eph.martketplace.constant.Constants;
import com.eph.martketplace.dataModels.TwitterData;
import com.eph.martketplace.databinding.ActivityFashion2Binding;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FashionActivity extends AppCompatActivity {
    private ActivityFashion2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFashion2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(binding.getRoot());



        binding.SuitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTweetCall client = TwitterClient.getClient();
                TwitterData modal = new TwitterData("Men suits");
                Call<TwitterData> call = client.postTweet(modal);
                call.enqueue(new Callback<TwitterData>() {
                    @Override
                    public void onResponse(Call<TwitterData> call, Response<TwitterData> response) {
                        if(response.code() != 201){
                            Log.v("error",response.message());
                        }
                        Log.v("responsee", String.valueOf(response.body()));
                    }

                    @Override
                    public void onFailure(Call<TwitterData> call, Throwable t) {
                        Log.v("Error","Error");
                    }
                });


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







