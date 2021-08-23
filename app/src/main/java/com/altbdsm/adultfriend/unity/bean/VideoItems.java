package com.altbdsm.adultfriend.unity.bean;

import com.google.gson.annotations.SerializedName;

public class VideoItems {

    @SerializedName("title")
    public String title;

    @SerializedName("share_url")
    public String share_url;

    @SerializedName("author")
    public String author;
    
    @SerializedName("item_cover")
    public String item_cover;
    
    @SerializedName("hot_value")
    public Integer hot_value;
    
    @SerializedName("hot_words")
    public String hot_words;
    
    @SerializedName("play_count")
    public Integer play_count;
    
    @SerializedName("digg_count")
    public Integer digg_count;
    
    @SerializedName("comment_count")
    public Integer comment_count;
}
