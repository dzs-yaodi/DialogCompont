package com.altbdsm.adultfriend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.mature.baselib.utils.StatusBarHelper;
import com.altbdsm.adultfriend.R;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        StatusBarHelper.translucent(this);

        ProgressBar progressbar = findViewById(R.id.progressbar);

        progressbar.postDelayed(() -> {
            Intent intent = new Intent(this,PromptActivity.class);
            startActivity(intent);
        },2000);
    }
}