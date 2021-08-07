package com.afflimitd.datingapp.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.afflimitd.datingapp.R;
import com.afflimitd.datingapp.fragment.MessageFragment;
import com.afflimitd.datingapp.fragment.UsersFragment;

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
                index = 0;
            }
        });

        tvMessage.setOnClickListener(v -> {
            if (index == 0) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new MessageFragment()).commit();
                index = 1;
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new UsersFragment()).commit();
    }
}