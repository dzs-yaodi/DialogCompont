package com.affcompany.datingapps.unity.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JokeData {

    @SerializedName("data")
    public List<Datas> datasList;

    public static class Datas {

        @SerializedName("content")
        public String content;

        @SerializedName("hashId")
        public String hashId;

        @SerializedName("unixtime")
        public String unixtime;

        @SerializedName("updatetime")
        public String updatetime;

    }
}
