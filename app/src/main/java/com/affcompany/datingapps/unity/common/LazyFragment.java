package com.affcompany.datingapps.unity.common;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 懒加载fragment
 */
public abstract class LazyFragment extends Fragment {

    //Fragment对用户可见的标记
    protected boolean isUIVisible;

    //是否执行了onActivityCreated
    private boolean isActivityCreated;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isActivityCreated = true;
        lazyInit();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyInit();
        } else {
            isUIVisible = false;
        }
    }

    /**
     * 延迟加载
     */
    private void lazyInit() {
        if (isActivityCreated && isUIVisible) {
            loadLazyData();
            //数据加载完毕,恢复标记,防止重复加载
            isActivityCreated = false;
            isUIVisible = false;
        }
    }

    /**
     * 延迟加载数据，这里应该加载第一版数据
     */
    protected abstract void loadLazyData();

}
