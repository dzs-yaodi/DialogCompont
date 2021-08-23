package com.altbdsm.adultfriend.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.mature.baselib.utils.SharePerferenceUtils;

public class BaseActivity extends AppCompatActivity {

    private String[] permission = {Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    protected SharePerferenceUtils spUtils;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int checkCallPhonePermission0 = ContextCompat.checkSelfPermission(this, permission[0]);
            int checkCallPhonePermission1 = ContextCompat.checkSelfPermission(this, permission[1]);
            int checkCallPhonePermission3 = ContextCompat.checkSelfPermission(this, permission[2]);
            if (checkCallPhonePermission0 != PackageManager.PERMISSION_GRANTED || checkCallPhonePermission1 != PackageManager.PERMISSION_GRANTED || checkCallPhonePermission3 != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 1024);
            }
        }
        spUtils = new SharePerferenceUtils(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1024) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

            } else {
                // Permission Denied
                Toast.makeText(this, "Please enable the necessary permissions", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
