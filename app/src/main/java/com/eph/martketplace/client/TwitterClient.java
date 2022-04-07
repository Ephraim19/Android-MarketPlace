package com.eph.martketplace.client;

import com.eph.martketplace.Interfaces.MyTweetCall;
import com.eph.martketplace.constant.Constants;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TwitterClient {
    private static Retrofit retrofit = null;

    public static MyTweetCall getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest  = chain.request().newBuilder()
                                    .addHeader("Authorization","FFOJQBOPKNkhMEO5HvDPK0tPk")
                                    .addHeader("Authorization", "mom4DoZFuJjyo4CIRvWzuhHfjowfykF4fkE08dRI5TDqoi5wKs")
                                    .addHeader("Authorization","1264537056186900481-DBLxE28G6G60st6pPOBM65KN9sULf2")
                                    //.addHeader("Authorization",Constants.TWITTER_API_KEY)
                                    .addHeader("Authorization","IP03QZmdE6G7cylTeruKM1JgTfThYxATbmKQKAzV3bF19")
                                    .build();
                            return chain.proceed(newRequest);
                        }
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.TWITTER_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(MyTweetCall.class);
    }


}






