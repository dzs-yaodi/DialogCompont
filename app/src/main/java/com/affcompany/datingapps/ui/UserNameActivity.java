package com.affcompany.datingapps.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.mature.baselib.utils.StatusBarHelper;
import com.affcompany.datingapps.Contance;
import com.affcompany.datingapps.R;

public class UserNameActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_username);
        StatusBarHelper.translucent(this);
        EditText edit_user = findViewById(R.id.edit_user);

        findViewById(R.id.btn_continue).setOnClickListener(v -> {
            String name = edit_user.getText().toString().trim();
            Intent intent = new Intent(this,PromptActivity.class);
            intent.putExtra("name",name);
            startActivity(intent);

            spUtils.putString(Contance.USER_NAME,name);
            finish();
        });
    }
}
