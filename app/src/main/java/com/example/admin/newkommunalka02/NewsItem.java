package com.example.admin.newkommunalka02;

import android.graphics.Bitmap;

/**
 * Created by Admin on 15.01.2016.
 */
public class NewsItem {
    private String headline;
    private String valute;
    private String penny;
    private String date;
    private Bitmap image;
    private int imageUrl;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getValute() {
        return valute;
    }

    public void setValute(String valute) {
        this.valute = valute;
    }

    public String getPenny() {
        return penny;
    }

    public void setPenny(String penny) {
        this.penny = penny;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl (int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
