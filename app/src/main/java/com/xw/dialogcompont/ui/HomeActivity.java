package com.xw.dialogcompont.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.xw.dialogcompont.R;
import com.xw.dialogcompont.fragment.MessageFragment;
import com.xw.dialogcompont.fragment.UsersFragment;

public class HomeActivity extends BaseActivity {

    private TextView tvUser;
    private TextView tvMessage;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvUser = findViewById(R.id.tv_user);
        tvMessage = findViewById(R.id.tv_message);

        tvUser.setOnClickListener(v -> {
            if (index == 1) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new UsersFragment()).commit();
            }
        });

        tvMessage.setOnClickListener(v -> {
            if (index == 0) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new MessageFragment()).commit();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new UsersFragment()).commit();
    }
}