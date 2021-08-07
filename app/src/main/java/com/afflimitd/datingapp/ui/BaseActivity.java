package com.afflimitd.datingapp.ui;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mature.baselib.utils.SharePerferenceUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.disposables.Disposable;

public class BaseActivity extends AppCompatActivity {

    private String[] permission = {Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private RxPermissions rxPermissions;
    protected SharePerferenceUtils spUtils;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rxPermissions = new RxPermissions(this);
        Disposable d = rxPermissions.request(permission[0],permission[1],permission[2])
                .subscribe(granted -> {
                    if (!granted) {
                        Toast.makeText(this, "Please enable the necessary permissions", Toast.LENGTH_SHORT).show();
                    }
                });
        spUtils = new SharePerferenceUtils(this);
    }
}
