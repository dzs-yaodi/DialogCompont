package com.altbdsm.adultfriend.unity.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.altbdsm.adultfriend.R;
import com.altbdsm.adultfriend.unity.UITools;
import com.altbdsm.adultfriend.unity.ui.fragment.ConfuseDreamFragment;

public class SearchActivity extends AppCompatActivity {

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        UITools.initTitleBar(this,findViewById(R.id.frame_container),"#F1B70B");

        ImageView imageBack = findViewById(R.id.image_back);
        EditText editSearch = findViewById(R.id.edit_search);
        TextView tvSearch = findViewById(R.id.tv_search);

        imageBack.setOnClickListener(view -> finish());
        title = getIntent().getStringExtra("title");

        tvSearch.setOnClickListener(view -> {
            String keyWord = editSearch.getText().toString().trim();
            if (!TextUtils.isEmpty(keyWord)) {
                UITools.hideInput(this);
                searchkey(keyWord);
            }
        });
    }

    private void searchkey(String keyWord) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if ("周公解梦".equals(title)) {
            transaction.replace(R.id.frameLayout, ConfuseDreamFragment.newInstance(keyWord));
            transaction.commit();
        }
    }
}