package com.affcompany.datingapps.unity.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostCode {

    @SerializedName("list")
    public List<PostList> postLists;

    @SerializedName("totalcount")
    public int totalcount;

    @SerializedName("totalpage")
    public int totalpage;

    @SerializedName("currentpage")
    public int currentpage;

    @SerializedName("pagesize")
    public int pagesize;

    public static class PostList {

        @SerializedName("PostNumber")
        public String PostNumber;

        @SerializedName("Province")
        public String Province;

        @SerializedName("City")
        public String City;

        @SerializedName("District")
        public String District;

        @SerializedName("Address")
        public String Address;

    }
}
