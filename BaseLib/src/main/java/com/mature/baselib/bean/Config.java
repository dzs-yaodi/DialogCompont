package com.mature.baselib.bean;

import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("webUrl")
    public String webUrl;

    @SerializedName("updateUrl")
    public String updateUrl;

    @SerializedName("bug")
    public int bug;
}
