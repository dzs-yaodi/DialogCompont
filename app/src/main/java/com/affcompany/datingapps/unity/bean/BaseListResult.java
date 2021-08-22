package com.affcompany.datingapps.unity.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseListResult<T> {

    @SerializedName("resultcode")
    public int resultcode;

    @SerializedName("reason")
    public String reason;

    @SerializedName("error_code")
    public int error_code;

    @SerializedName("result")
    public List<T> result;
}
