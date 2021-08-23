package com.altbdsm.adultfriend;

import android.app.Application;

import com.mature.baselib.http.HttpManager;
import com.mature.baselib.utils.ServerConfig;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ServerConfig.BASR_UEL = "https://std-friends.web.app";
        HttpManager.getInstance().init(ServerConfig.BASR_UEL);
    }
}