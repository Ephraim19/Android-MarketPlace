package com.eph.martketplace.dataModels;

public class FashionData {
    private String price;
    private int images;
    private int id;
    private String pushId;

    public FashionData(String price, int images, int id) {
        this.price = price;
        this.images = images;
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
