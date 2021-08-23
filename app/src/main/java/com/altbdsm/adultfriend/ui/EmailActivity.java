package com.altbdsm.adultfriend.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.mature.baselib.utils.StatusBarHelper;
import com.altbdsm.adultfriend.Contance;
import com.altbdsm.adultfriend.R;

public class EmailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_email);
        StatusBarHelper.translucent(this);

        EditText edit_email = findViewById(R.id.edit_email);

        findViewById(R.id.btn_next).setOnClickListener(v -> {
            String email = edit_email.getText().toString().trim();
            if (!TextUtils.isEmpty(email)) {
                Intent intent = new Intent(this, LookForActivity.class);
                startActivity(intent);

                spUtils.putString(Contance.USER_EMAIL,email);
                finish();
            }
        });
    }

}
