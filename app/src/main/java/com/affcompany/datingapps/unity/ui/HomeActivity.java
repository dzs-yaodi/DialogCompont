package com.affcompany.datingapps.unity.ui;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.affcompany.datingapps.R;
import com.xw.utility.adapter.ViewPagerAdapter;
import com.xw.utility.ui.fragment.MenuFragment;
import com.xw.utility.ui.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Fragment> fragmentList;
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private RadioButton radioNews;
    private ViewPagerAdapter viewPagerAdapter;
    private RadioButton radioMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.viewPager);
        radioGroup = findViewById(R.id.radioGroup);
        radioNews = findViewById(R.id.radio_news);
        radioMenu = findViewById(R.id.radio_menu);

        fragmentList = new ArrayList<>();
        fragmentList.add(new NewsFragment());
        fragmentList.add(new MenuFragment());

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),this,fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    radioNews.setChecked(true);
                } else {
                    radioMenu.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener((radioGroup, id) -> {
            if (id == R.id.radio_menu) {
                viewPager.setCurrentItem(1);
            } else {
                viewPager.setCurrentItem(0);
            }
        });

        viewPager.setCurrentItem(0);
    }

}