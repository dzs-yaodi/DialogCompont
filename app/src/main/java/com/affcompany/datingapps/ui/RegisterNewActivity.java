package com.affcompany.datingapps.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.affcompany.datingapps.Contance;
import com.affcompany.datingapps.R;
import com.mature.baselib.utils.StatusBarHelper;

public class RegisterNewActivity extends AppCompatActivity {

    private String[] ageItems = {"18-25","26-35","36-45","46-55","55-60","60+"};
    private TextView tvAge;
    private String[] genderItems = {"male","women"};
    private TextView tvGender;
    private String[] lookforItems = {"men","woman"};
    private TextView tv_lookfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new);

        StatusBarHelper.translucent(this);
        tvAge = findViewById(R.id.tv_age);
        tvGender = findViewById(R.id.tv_gender);
        tv_lookfor = findViewById(R.id.tv_lookfor);

        tvAge.setOnClickListener(v -> showDialogs(0,ageItems));
        tvGender.setOnClickListener(v -> showDialogs(1,genderItems));
        tv_lookfor.setOnClickListener(v -> showDialogs(2,lookforItems));

        findViewById(R.id.btn_next).setOnClickListener(v -> {
//            String lookfor = tv_lookfor.getText().toString().trim();
//            String age = tvAge.getText().toString().trim();
//            String gender = tvGender.getText().toString().trim();
//            if (!TextUtils.isDigitsOnly(lookfor) && !TextUtils.isDigitsOnly(gender) && !TextUtils.isDigitsOnly(age) ) {
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);

                finish();
//            }
        });
    }

    private void showDialogs(int type,String[] array) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(array, (dialog, which) -> {
            String items = array[which];
            if (type == 0) {
                tvAge.setText(items);
            } else if (type == 1) {
                tvGender.setText(items);
            } else {
                tv_lookfor.setText(items);
            }
            dialog.dismiss();
        });
        builder.create().show();
    }
}