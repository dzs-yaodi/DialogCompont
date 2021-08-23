package com.altbdsm.adultfriend.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.altbdsm.adultfriend.R;
import com.altbdsm.adultfriend.fragment.MessageFragment;
import com.altbdsm.adultfriend.fragment.UsersFragment;
import com.mature.baselib.utils.UITools;

public class HomeActivity extends BaseActivity {

    private TextView tvUser;
    private TextView tvMessage;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UITools.initTitleColorBar(this,findViewById(R.id.frame_contaner),"#E14C1D");

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