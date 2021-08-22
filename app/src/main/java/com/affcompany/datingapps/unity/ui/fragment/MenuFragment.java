package com.affcompany.datingapps.unity.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xw.baselib.utils.UITools;
import com.affcompany.datingapps.R;
import com.xw.utility.adapter.MenuGridAdapter;

public class MenuFragment extends Fragment {

    private MenuGridAdapter menuGridAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UITools.initTitleBar(getActivity(),view.findViewById(R.id.frame_container),"#F1B70B");

        view.findViewById(R.id.image_back).setVisibility(View.GONE);
        TextView tvTitle = view.findViewById(R.id.title);
        tvTitle.setText("工具箱");
        RecyclerView mRecycler = view.findViewById(R.id.recyclerView);

        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(),4);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);

        menuGridAdapter = new MenuGridAdapter(view.getContext());
        mRecycler.setAdapter(menuGridAdapter);
    }
}
