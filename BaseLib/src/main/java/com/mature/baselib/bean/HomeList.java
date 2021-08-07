package com.mature.baselib.bean;

import com.google.gson.annotations.SerializedName;

public class HomeList {

    @SerializedName("id")
    public int id;

    @SerializedName("img")
    public String img;

    @SerializedName("weburl")
    public String weburl;

    @SerializedName("start")
    public String start;

    @SerializedName("title")
    public String title;

    @SerializedName("score")
    public String score;

    @SerializedName("content")
    public String content;

    @SerializedName("description")
    public String description;
}
