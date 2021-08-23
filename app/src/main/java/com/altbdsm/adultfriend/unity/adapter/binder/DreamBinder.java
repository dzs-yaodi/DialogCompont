package com.altbdsm.adultfriend.unity.adapter.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.altbdsm.adultfriend.R;

import me.drakeet.multitype.ItemViewBinder;

public class DreamBinder extends ItemViewBinder<String, DreamBinder.DreamItemViewHolder>{

    @NonNull
    @Override
    protected DreamItemViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new DreamItemViewHolder(inflater.inflate(R.layout.item_dream_string_layout,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull DreamItemViewHolder holder, @NonNull String s) {
        holder.tvContent.setText(s);
    }

    class DreamItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvContent;

        public DreamItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }
}
