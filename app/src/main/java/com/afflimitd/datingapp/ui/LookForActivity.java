package com.afflimitd.datingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.afflimitd.datingapp.Contance;
import com.afflimitd.datingapp.R;

public class LookForActivity extends BaseActivity {

    private String[] ageItems = {"men","woman"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_for);

        TextView tv_lookfor = findViewById(R.id.tv_lookfor);

        tv_lookfor.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setItems(ageItems, (dialog, which) -> {
                String items = ageItems[which];
                tv_lookfor.setText(items);
                dialog.dismiss();
            });
            builder.create().show();
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            String lookfor = tv_lookfor.getText().toString().trim();
            if (!TextUtils.isEmpty(lookfor)) {
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                spUtils.putString(Contance.USER_LOOKING_FOR,lookfor);
                finish();
            }
        });
    }
}