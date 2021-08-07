package com.xw.dialogcompont.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.mature.baselib.utils.StatusBarHelper;
import com.xw.dialogcompont.Contance;
import com.xw.dialogcompont.R;

public class GenderActivity extends BaseDialogActivity {

    private String[] ageItems = {"male","women"};
    private TextView tvGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        StatusBarHelper.translucent(this);

        tvGender = findViewById(R.id.tv_gender);
        tvGender.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setItems(ageItems, (dialog, which) -> {
                String items = ageItems[which];
                tvGender.setText(items);
                dialog.dismiss();
            });
            builder.create().show();
        });

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            String gender = tvGender.getText().toString();
            if (!TextUtils.isEmpty(gender)) {
                Intent intent = new Intent(this, EmailActivity.class);
                startActivity(intent);

                spUtils.putString(Contance.USER_GENDER,gender);
                finish();
            }
        });
    }
}