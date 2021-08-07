package com.xw.dialogcompont.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mature.baselib.bean.AppConfig;
import com.mature.baselib.http.Api;
import com.mature.baselib.http.Disposables;
import com.mature.baselib.utils.ACache;
import com.mature.baselib.utils.ServerConfig;
import com.mature.baselib.utils.StatusBarHelper;
import com.mature.baselib.view.CountDownTextView;
import com.xw.dialogcompont.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {

    private Disposables disposables = new Disposables();
    private AppConfig config;
    private ImageView imageLoading;
    private CountDownTextView countDownTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarHelper.translucent(this);

        imageLoading = findViewById(R.id.image_loading);
        countDownTextView = findViewById(R.id.countDown);

        loadConfig();
        setListener();
    }

    private void loadConfig() {
        startShow();
//        Disposable d = Api.getInstance().apiService.getAppConfig()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(appConfig -> {
//                    if (appConfig != null) {
//                        this.config = appConfig;
//                        ACache.get(SplashActivity.this).put("appconfig",appConfig);
//                        startShow();
//                    }
//                }, throwable -> {
//                    throwable.printStackTrace();
//                });
//        disposables.add(d);
    }

    private void setListener() {
        countDownTextView.setOnClickListener(view -> {
            countDownTextView.stop();
            jump();
        });

        countDownTextView.setCountDownListener(this::jump);
    }

    private void jump() {
        if (config == null)return;
        countDownTextView.setVisibility(View.GONE);
        Intent intent = new Intent();
        intent.setClass(this,UserNameActivity.class);
//        if (config.bug == 1) {
//            intent.setClass(this,HomeActivity.class);
//        } else if (config.bug == 2) {
//            intent.setClass(this,WebView2Activity.class);
//            intent.putExtra("load_url", ServerConfig.IN_WEB_URL);
//        } else {
//            intent.setClass(this,UbarOutActivity.class);
//            intent.putExtra("config",config);
//        }

        startActivity(intent);
        finish();
    }

    private void startShow() {
//        Glide.with(this).load(config.splash).into(imageLoading);
        countDownTextView.setVisibility(View.VISIBLE);
        countDownTextView.start();
    }

    @Override
    protected void onDestroy() {
        disposables.clear();
        super.onDestroy();
    }
}