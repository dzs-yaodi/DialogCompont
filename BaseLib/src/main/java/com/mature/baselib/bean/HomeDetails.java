package com.mature.baselib.bean;

import com.google.gson.annotations.SerializedName;

public class HomeDetails {

    @SerializedName("img")
    public String img;

    @SerializedName("content")
    public String content;

    @SerializedName("title")
    public String title;

    @SerializedName("weburl")
    public String weburl;

    @SerializedName("downurl")
    public String downurl;

    @SerializedName("description")
    public String description;
}
