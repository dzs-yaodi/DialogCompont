package com.affcompany.datingapps.unity.adapter.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.affcompany.datingapps.R;
import com.affcompany.datingapps.unity.bean.TouTiao;

import me.drakeet.multitype.ItemViewBinder;

public class NewsItem0Binder extends ItemViewBinder<TouTiao.Datas, NewsItem0Binder.Item0ViewHolder> {

    @NonNull
    @Override
    protected Item0ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new Item0ViewHolder(inflater.inflate(R.layout.item_news_zero_layout,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull Item0ViewHolder holder, @NonNull TouTiao.Datas items) {
        holder.datas = items;
        holder.setView();
    }

    class Item0ViewHolder extends NewsItemBaseViewHolder {
        public Item0ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
