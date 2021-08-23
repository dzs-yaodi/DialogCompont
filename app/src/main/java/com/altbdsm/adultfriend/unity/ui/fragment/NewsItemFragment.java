package com.altbdsm.adultfriend.unity.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.altbdsm.adultfriend.R;
import com.altbdsm.adultfriend.unity.common.BinderUtils;
import com.altbdsm.adultfriend.unity.common.LazyFragment;
import com.mature.baselib.http.Disposables;

import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class NewsItemFragment extends LazyFragment {

//    private SmartRefreshLayout refreshLayout;
    private RecyclerView mRecycler;
    private Disposables disposables = new Disposables();
    private MultiTypeAdapter adapter;

    //利用FragmentPagerAdapter notify change 会保存Fragment内部状态的特性避免重复初始化
    private View rootView;
    //false表示该Fragment已经实例化过了，不需重复初始化
    private boolean needBuild;
    private String type;

    private int mPage = 1;
    private int pageSize = 10;

    public static NewsItemFragment newInstance(String itemType) {

        Bundle args = new Bundle();
        args.putString("type",itemType);
        NewsItemFragment fragment = new NewsItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void loadLazyData() {
        //触发刷新加载首屏数据
        if (needBuild || (adapter != null && adapter.getItemCount() <= 0)) {
//            refreshLayout.autoRefresh();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        needBuild = rootView == null;
        if (needBuild) {
            rootView = inflater.inflate(R.layout.fragment_news_item_layout,container,false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (!needBuild) {
            return;
        }
//        refreshLayout = view.findViewById(R.id.refreshLayout);
        mRecycler = view.findViewById(R.id.recyclerView);

        initRefreshLayout(view.getContext());
        initrecyclerView();

        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getString("type");
        }
    }

    private void initrecyclerView() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MultiTypeAdapter();
        Items items = new Items();
        adapter.setItems(items);
        BinderUtils.registerTT(adapter);
        mRecycler.setAdapter(adapter);
    }

    private void initRefreshLayout(Context context) {
//        refreshLayout.setRefreshHeader(new ClassicsHeader(context));
//        refreshLayout.setRefreshFooter(new ClassicsFooter(context));
//        refreshLayout.setFooterHeight(80);
//        refreshLayout.setEnableAutoLoadMore(true);
//        refreshLayout.setEnableScrollContentWhenLoaded(true);
//        //刷新的时候禁止列表的操作
//        refreshLayout.setDisableContentWhenRefresh(false);
//        //加载的时候禁止列表的操作
//        refreshLayout.setDisableContentWhenLoading(false);
//        refreshLayout.setOnRefreshListener(refreshLayout1 -> {
//            mPage = 1;
//            loadData();
//        });
//
//        refreshLayout.setOnLoadMoreListener(refreshLayout1 -> {
//            loadData();
//        });
    }

    private void loadData() {
//        Disposable d = VApi.getInstance().apiService
//                .getTouTiao(type,mPage,pageSize,1, AppConfig.NEWS_LIST_KET)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(touTiaoBaseResult -> {
//                    if (touTiaoBaseResult.result == null || touTiaoBaseResult.result.data.isEmpty()) {
//                        if (mPage == 1) {
//                            refreshLayout.finishRefresh();
//                        } else {
//                            refreshLayout.finishLoadMoreWithNoMoreData();
//                        }
//                        return;
//                    }
//
//                    Items items = (Items) adapter.getItems();
//                    if (mPage == 1) {
//                        items.clear();
//                        refreshLayout.finishRefresh();
//                    } else {
//                        refreshLayout.finishLoadMore();
//                    }
//                    items.addAll(touTiaoBaseResult.result.data);
//                    adapter.notifyDataSetChanged();
//                    mPage++;
//                },throwable -> {
//                    if (mPage == 1) {
//                        refreshLayout.finishRefresh();
//                    } else {
//                        refreshLayout.finishLoadMore();
//                    }
//                    throwable.printStackTrace();
//                });
//        disposables.add(d);
    }

    @Override
    public void onDestroyView() {
        disposables.clear();
        super.onDestroyView();
    }
}
