package com.altbdsm.adultfriend.unity.adapter;

import android.content.Context;
import android.graphics.Color;

import androidx.viewpager.widget.ViewPager;

import com.altbdsm.adultfriend.unity.UITools;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.List;

public class PagerNavigator extends CommonNavigatorAdapter {

    private List<String> nameList;
    private ViewPager viewPager;

    public PagerNavigator(List<String> nameList,ViewPager viewPager) {
        this.nameList = nameList;
        this.viewPager = viewPager;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, int index) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#C6C4C4"));
        colorTransitionPagerTitleView.setTextSize(16);
        colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#F1B70B"));
        colorTransitionPagerTitleView.setText(nameList.get(index));
        colorTransitionPagerTitleView.setOnClickListener(view ->
                viewPager.setCurrentItem(index));
        return colorTransitionPagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);

//        indicator.setLineWidth(UITools.dip2px(context,80));
        indicator.setLineHeight(UITools.dip2px(context, 3));
        indicator.setRoundRadius(UITools.dip2px(context, 2));
        indicator.setColors(Color.parseColor("#F1B70B"));
        return indicator;
    }
}
