package com.affcompany.datingapps.unity.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dreams {

    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("des")
    public String des;

    @SerializedName("list")
    public List<String> list;
 }
