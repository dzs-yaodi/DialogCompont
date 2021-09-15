package com.bdcompany.bdapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.mature.baselib.utils.StatusBarHelper;
import com.bdcompany.bdapp.Contance;
import com.bdcompany.bdapp.R;

public class AgeActivity extends BaseActivity {

    private String[] ageItems = {"18-25","26-35","36-45","46-55","55-60","60+"};
    private TextView tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_age);
        StatusBarHelper.translucent(this);
        tvAge = findViewById(R.id.tv_age);

        tvAge.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setItems(ageItems, (dialog, which) -> {
                String items = ageItems[which];
                tvAge.setText(items);
                dialog.dismiss();
            });
            builder.create().show();
        });
        findViewById(R.id.btn_next).setOnClickListener(v -> {
            String age = tvAge.getText().toString().trim();
            if (!TextUtils.isEmpty(age)) {
                Intent intent = new Intent(this, GenderActivity.class);
                startActivity(intent);

                spUtils.putString(Contance.USER_AGE,age);
                finish();
            }
        });
    }
}
