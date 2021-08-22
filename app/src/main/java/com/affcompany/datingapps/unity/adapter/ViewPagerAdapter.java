package com.affcompany.datingapps.unity.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private Context context;

    public ViewPagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
    }

    /**
     * 重设数据
     */
    public void resetData(List<Fragment> fragmentList) {
        if (this.fragmentList != null && fragmentList != null) {
            this.fragmentList.clear();
            this.fragmentList.addAll(fragmentList);
            notifyDataSetChanged();
        }
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public long getItemId(int position) {
        //内部复用机制通过 container.getId() + position 作为id，导致在刷新时得到错误的fragment
        //这里用业务id进行fragment标记
        return position;
    }
}
