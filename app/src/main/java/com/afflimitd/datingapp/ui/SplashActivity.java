package com.afflimitd.datingapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mature.baselib.bean.Config;
import com.mature.baselib.http.Api;
import com.mature.baselib.http.Disposables;
import com.mature.baselib.utils.StatusBarHelper;
import com.mature.baselib.view.CountDownTextView;
import com.afflimitd.datingapp.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashActivity extends AppCompatActivity {

    private Disposables disposables = new Disposables();
    private Config config;
    private CountDownTextView countDownTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StatusBarHelper.translucent(this);

        countDownTextView = findViewById(R.id.countDown);
        loadConfig();
        setListener();
    }

    private void loadConfig() {
        Disposable d = Api.getInstance().apiService.getConfig()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(config -> {
                    if (config != null) {
                        this.config = config;
                        startShow();
                    }
                }, throwable -> {
                    throwable.printStackTrace();
                });
        disposables.add(d);
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

        if (config.bug == 1) {
            Intent intent = new Intent(this,UserNameActivity.class);
            startActivity(intent);
            finish();
        } else if (config.bug == 2) {
            Intent intent = new Intent(this,WebViewActivity.class);
            intent.putExtra("load_url", config.webUrl);
            startActivity(intent);
            finish();
        } else {
            showUpdateDialog();
        }
    }

    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("prompt")
                .setMessage("Are you upgrade the app");
        builder.setPositiveButton("yes", (dialog, which) -> {
            Uri uri = Uri.parse(config.updateUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        builder.setNegativeButton("no", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.create().show();
    }

    private void startShow() {
        countDownTextView.setVisibility(View.VISIBLE);
        countDownTextView.start();
    }

    @Override
    protected void onDestroy() {
        disposables.clear();
        super.onDestroy();
    }
}