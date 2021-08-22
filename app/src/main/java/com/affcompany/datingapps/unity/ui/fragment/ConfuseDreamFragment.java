package com.affcompany.datingapps.unity.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xw.baselib.network.Disposables;
import com.affcompany.datingapps.R;
import com.xw.utility.adapter.binder.DreamBinder;
import com.xw.utility.adapter.binder.DreamTitleBinder;
import com.xw.utility.bean.DreamTitle;
import com.xw.utility.bean.Dreams;
import com.xw.utility.common.AppConfig;
import com.xw.utility.network.VApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class ConfuseDreamFragment extends Fragment {

    private MultiTypeAdapter adapter;
    private Disposables disposables = new Disposables();
    private String keyWord;

    public static Fragment newInstance(String keyWord) {
        ConfuseDreamFragment dreamFragment = new ConfuseDreamFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key_word",keyWord);
        dreamFragment.setArguments(bundle);
        return dreamFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dream_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mRecycler = view.findViewById(R.id.recyclerView);
        mRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));

        Bundle bundle = getArguments();
        if (bundle != null) {
            keyWord = bundle.getString("key_word");
        }
        adapter = new MultiTypeAdapter();
        adapter.register(DreamTitle.class,new DreamTitleBinder());
        adapter.register(String.class,new DreamBinder());
        mRecycler.setAdapter(adapter);

        loadData();
    }

    private void loadData() {
        Disposable d = VApi.getInstance().apiService
                .dreamsList(keyWord,1, AppConfig.INTERPRETATION_OF_DREAMS_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dreamsBaseListResult -> {
                    if (dreamsBaseListResult != null && !dreamsBaseListResult.result.isEmpty()) {
                        Items items = new Items();
                        for (Dreams dream :dreamsBaseListResult.result) {
                            items.add(new DreamTitle(dream.title,dream.des));
                            items.addAll(dream.list);
                        }

                        adapter.setItems(items);
                        adapter.notifyDataSetChanged();
                    }
                },throwable -> {
                    throwable.printStackTrace();
                });
        disposables.add(d);
    }

    @Override
    public void onDestroyView() {
        disposables.clear();
        super.onDestroyView();
    }
}
