package com.mature.baselib.bean;

import com.google.gson.annotations.SerializedName;

public class SugarData {

    @SerializedName("id")
    public int id;

    @SerializedName("img")
    public String img;

    @SerializedName("title")
    public String title;

    @SerializedName("score")
    public String score;

    @SerializedName("description")
    public String description;
}
