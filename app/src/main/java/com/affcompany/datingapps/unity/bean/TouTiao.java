package com.affcompany.datingapps.unity.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TouTiao {

    @SerializedName("stat")
    public String stat;

    @SerializedName("page")
    public String page;

    @SerializedName("pageSize")
    public String pageSize;

    @SerializedName("data")
    public List<Datas> data;

    public static class Datas {

        @SerializedName("uniquekey")
        public String uniquekey;

        @SerializedName("title")
        public String title;

        @SerializedName("date")
        public String date;

        @SerializedName("category")
        public String category;

        @SerializedName("author_name")
        public String author_name;

        @SerializedName("url")
        public String url;

        @SerializedName("thumbnail_pic_s")
        public String thumbnail_pic_s;

        @SerializedName("thumbnail_pic_s02")
        public String thumbnail_pic_s02;

        @SerializedName("thumbnail_pic_s03")
        public String thumbnail_pic_s03;

        @SerializedName("is_content")
        public String is_content;

    }
 }
