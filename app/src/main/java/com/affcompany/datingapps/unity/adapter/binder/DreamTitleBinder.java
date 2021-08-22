package com.affcompany.datingapps.unity.adapter.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.affcompany.datingapps.R;
import com.affcompany.datingapps.unity.bean.DreamTitle;

import me.drakeet.multitype.ItemViewBinder;

public class DreamTitleBinder extends ItemViewBinder<DreamTitle, DreamTitleBinder.TitleViewHolder> {

    @NonNull
    @Override
    protected TitleViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new TitleViewHolder(inflater.inflate(R.layout.item_dream_title_layout,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull TitleViewHolder holder, @NonNull DreamTitle items) {
        holder.tvTitle.setText(items.title);
        holder.tvDes.setText(items.des);
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvDes;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDes = itemView.findViewById(R.id.tv_des);
        }
    }
}
