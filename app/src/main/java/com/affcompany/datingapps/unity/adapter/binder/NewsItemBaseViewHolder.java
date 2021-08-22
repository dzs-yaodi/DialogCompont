package com.affcompany.datingapps.unity.adapter.binder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.affcompany.datingapps.R;
import com.affcompany.datingapps.unity.bean.TouTiao;
import com.affcompany.datingapps.unity.ui.H5Activity;

public class NewsItemBaseViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private TextView tvSource;
    private TextView tvCreateTime;
    public TouTiao.Datas datas;

    public NewsItemBaseViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_title);
        tvSource = itemView.findViewById(R.id.tv_source);
        tvCreateTime = itemView.findViewById(R.id.tv_create_time);

        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(itemView.getContext(), H5Activity.class);
            intent.putExtra("title",datas.title);
            intent.putExtra("load_url",datas.url);
            itemView.getContext().startActivity(intent);
        });
    }

    public void setView() {
        tvTitle.setText(datas.title);
        tvSource.setText(datas.author_name);
        tvCreateTime.setText(datas.date);
    }
}
