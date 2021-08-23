package com.altbdsm.adultfriend.unity.adapter.binder;

import android.text.TextUtils;
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

public class NewsItem3Binder extends ItemViewBinder<TouTiao.Datas,NewsItem3Binder.Item3ViewHolder> {

    @NonNull
    @Override
    protected Item3ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new Item3ViewHolder(inflater.inflate(R.layout.item_news_three_layout,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull Item3ViewHolder holder, @NonNull TouTiao.Datas items) {
        holder.datas = items;
        holder.setView();

        Glide.with(holder.itemView)
                .load(items.thumbnail_pic_s)
                .apply(holder.requestOptions)
                .into(holder.imageThumb1);

        Glide.with(holder.itemView)
                .load(items.thumbnail_pic_s02)
                .apply(holder.requestOptions)
                .into(holder.imageThumb2);

        if (!TextUtils.isEmpty(items.thumbnail_pic_s03)) {
            Glide.with(holder.itemView)
                    .load(items.thumbnail_pic_s03)
                    .apply(holder.requestOptions)
                    .into(holder.imageThumb3);
        }
    }

    class Item3ViewHolder extends NewsItemBaseViewHolder {

        private ImageView imageThumb1;
        private ImageView imageThumb2;
        private ImageView imageThumb3;
        private RequestOptions requestOptions;

        public Item3ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageThumb1 = itemView.findViewById(R.id.image_thumb1);
            imageThumb2 = itemView.findViewById(R.id.image_thumb2);
            imageThumb3 = itemView.findViewById(R.id.image_thumb3);

            requestOptions = new RequestOptions().
                    transform(new GlideRoundTransform(itemView.getContext(),
                            UITools.dip2px(itemView.getContext(),2)));
        }
    }
}
