package com.eph.martketplace.Interfaces;

import com.eph.martketplace.dataModels.TwitterData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyTweetCall {
    @POST("2/tweets")
    Call<TwitterData> postTweet (@Body TwitterData twitterData);

}
