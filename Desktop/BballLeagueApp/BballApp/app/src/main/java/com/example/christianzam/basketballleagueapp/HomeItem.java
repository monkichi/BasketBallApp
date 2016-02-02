package com.example.christianzam.basketballleagueapp;

import java.net.URI;
import java.net.URL;

public class HomeItem {
    String caption;
    URL imageUrl;
    URL videoUrl;
    public HomeItem(String cap,URL image,URL vid){
        caption = cap;
        imageUrl = image;
        videoUrl = vid;

    }


    public void setCaption(String cap){ caption = cap;}
    public String getCaption(){ return caption;}
    public void setImageUrl(URL id){ imageUrl = id;}
    public URL getImageUrl(){return imageUrl;}
    public void setVideoUrl(URL url){videoUrl = url;}
    public URL getVideoUrl(){ return videoUrl;}
}
