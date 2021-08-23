package com.altbdsm.adultfriend.unity.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather{

    @SerializedName("city")
    public String city;

    @SerializedName("realtime")
    public Realtime realtime;

    @SerializedName("future")
    public List<Future> futureList;

    public static class Realtime {

        @SerializedName("temperature")
        public String temperature;

        @SerializedName("humidity")
        public String humidity;

        @SerializedName("info")
        public String info;

        @SerializedName("wid")
        public String wid;

        @SerializedName("direct")
        public String direct;

        @SerializedName("power")
        public String power;

        @SerializedName("aqi")
        public String aqi;
    }

    public static class Future {

        @SerializedName("date")
        public String date;

        @SerializedName("temperature")
        public String temperature;

        @SerializedName("weather")
        public String weather;

        @SerializedName("direct")
        public String direct;

    }

}
