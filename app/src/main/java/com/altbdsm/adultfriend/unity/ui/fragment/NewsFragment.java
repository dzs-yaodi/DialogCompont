package com.altbdsm.adultfriend.unity.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.altbdsm.adultfriend.R;
import com.altbdsm.adultfriend.unity.UITools;
import com.altbdsm.adultfriend.unity.adapter.PagerNavigator;
import com.altbdsm.adultfriend.unity.adapter.ViewPagerAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsFragment extends Fragment {


    private MagicIndicator magicIndicator;
    private ViewPager viewPager;
    private List<String> itemName;
    private List<String> itemType;
    private List<Fragment> fragmentList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UITools.initTitleBar(getActivity(),view.findViewById(R.id.frame_container),"#F1B70B");
        view.findViewById(R.id.image_back).setVisibility(View.GONE);
        ImageView logo = view.findViewById(R.id.logo);
        logo.setVisibility(View.VISIBLE);

        magicIndicator = view.findViewById(R.id.magicIndicator);
        viewPager = view.findViewById(R.id.viewPager);

        itemName = new ArrayList<>();
        itemType = new ArrayList<>();
        fragmentList = new ArrayList<>();

        itemName = Arrays.asList(getResources().getStringArray(R.array.toutiao_name).clone());
        itemType = Arrays.asList(getResources().getStringArray(R.array.toutiao_type).clone());

        for (String s :itemType) {
            fragmentList.add(NewsItemFragment.newInstance(s));
        }

        initIndicator();
    }

    private void initIndicator() {
        //指示器
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setSkimOver(true);
        //setAdjustMode 设置为true 表示均分标题栏，使用与少量固定标题数量的
        commonNavigator.setAdjustMode(false);
        commonNavigator.setAdapter(new PagerNavigator(itemName,viewPager));

        ViewPagerAdapter adapter;
        if (viewPager.getAdapter() instanceof ViewPagerAdapter) {
            adapter = (ViewPagerAdapter) viewPager.getAdapter();
            adapter.resetData(fragmentList);
            viewPager.setCurrentItem(0);
        } else {
            //初次加载
            adapter = new ViewPagerAdapter(getChildFragmentManager(), getContext(), fragmentList);
            viewPager.setOffscreenPageLimit(8);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(0);
        }

        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }


}
