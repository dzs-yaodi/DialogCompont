package com.altbdsm.adultfriend.unity.bean;

import com.google.gson.annotations.SerializedName;

public class BaseResult<T> {

    @SerializedName("resultcode")
    public int resultcode;

    @SerializedName("reason")
    public String reason;

    @SerializedName("error_code")
    public int error_code;

    @SerializedName("result")
    public T result;
}
