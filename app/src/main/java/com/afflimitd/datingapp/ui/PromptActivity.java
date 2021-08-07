package com.afflimitd.datingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.mature.baselib.utils.StatusBarHelper;
import com.afflimitd.datingapp.Contance;
import com.afflimitd.datingapp.R;

public class PromptActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);
        StatusBarHelper.translucent(this);

        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_content = findViewById(R.id.tv_content);

        String name = getIntent().getStringExtra("name");
        if (!TextUtils.isEmpty(name)) {
            tv_name.setText("Hello " + name);
        } else {
            tv_name.setText(getResources().getString(R.string.app_dialog_logo_name));
            String userName = spUtils.getString(Contance.USER_NAME);
            tv_content.setText(userName + "thanks for register!");
        }

        findViewById(R.id.btn_continue).setOnClickListener(v -> {
            if (!TextUtils.isEmpty(name)) {
                startActivity(new Intent(this, AgeActivity.class));
            } else {
                startActivity(new Intent(this, HomeActivity.class));
            }
            finish();
        });
    }

}