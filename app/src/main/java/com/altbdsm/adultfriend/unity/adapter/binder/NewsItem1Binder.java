package com.altbdsm.adultfriend.unity.adapter.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.altbdsm.adultfriend.unity.UITools;
import com.altbdsm.adultfriend.unity.bean.TouTiao;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.altbdsm.adultfriend.R;
import com.mature.baselib.utils.GlideRoundTransform;

import me.drakeet.multitype.ItemViewBinder;

public class NewsItem1Binder extends ItemViewBinder<TouTiao.Datas, NewsItem1Binder.ItemOneViewHolder> {

    @NonNull
    @Override
    protected ItemOneViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ItemOneViewHolder(inflater.inflate(R.layout.item_news_one_layout,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ItemOneViewHolder holder, @NonNull TouTiao.Datas items) {
        holder.datas = items;
        holder.setView();

        Glide.with(holder.itemView)
                .load(items.thumbnail_pic_s)
                .apply(holder.requestOptions)
                .into(holder.imageThumb);
    }

    class ItemOneViewHolder extends NewsItemBaseViewHolder {

        private ImageView imageThumb;
        private RequestOptions requestOptions;

        public ItemOneViewHolder(@NonNull View itemView) {
            super(itemView);

            imageThumb = itemView.findViewById(R.id.image_thumb);
            requestOptions = new RequestOptions().
                    transform(new GlideRoundTransform(itemView.getContext(),
                            UITools.dip2px(itemView.getContext(),2)));
        }
    }
}
