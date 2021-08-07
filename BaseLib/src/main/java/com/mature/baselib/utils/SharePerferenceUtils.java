package com.mature.baselib.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePerferenceUtils {

    private SharedPreferences sp;
    private Context context;

    public SharePerferenceUtils(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
    }

    public void putBoolean(String key,boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return sp.getBoolean(key,false);
    }

    public void putString(String key,String value) {
        sp.edit().putString(key, value).apply();
    }

    public String getString(String key) {
        return sp.getString(key,"");
    }

    public void putInt(String key,int value) {
        sp.edit().putInt(key, value).apply();
    }

    public int getInt(String key) {
        return sp.getInt(key,0);
    }

    public void putFloat(String key,float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public float getFloat(String key) {
        return sp.getFloat(key,0f);
    }

}
