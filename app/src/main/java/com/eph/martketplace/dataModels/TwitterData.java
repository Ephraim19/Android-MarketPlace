package com.eph.martketplace.dataModels;

public class TwitterData {
    private Integer id;
    private String tweet;

    public TwitterData( String tweet) {
        this.id = id;
        this.tweet = tweet;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Integer getId() {
        return id;
    }

    public String getTweet() {
        return tweet;
    }
}
