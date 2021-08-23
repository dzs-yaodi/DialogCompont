package com.altbdsm.adultfriend.unity.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.altbdsm.adultfriend.R;
import com.altbdsm.adultfriend.unity.adapter.binder.DreamBinder;
import com.altbdsm.adultfriend.unity.adapter.binder.DreamTitleBinder;
import com.altbdsm.adultfriend.unity.bean.DreamTitle;
import com.mature.baselib.http.Disposables;

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

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }
}
