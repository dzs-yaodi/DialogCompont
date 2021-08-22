package com.affcompany.datingapps.unity.common;


import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.xw.utility.adapter.binder.NewsItem0Binder;
import com.xw.utility.adapter.binder.NewsItem1Binder;
import com.xw.utility.adapter.binder.NewsItem3Binder;
import com.xw.utility.bean.TouTiao;

import me.drakeet.multitype.MultiTypeAdapter;

public class BinderUtils {

    public static void registerTT(@NonNull MultiTypeAdapter adapter) {
        adapter.register(TouTiao.Datas.class)
                .to(
                        new NewsItem0Binder(),
                        new NewsItem1Binder(),
                        new NewsItem3Binder()
                ).withLinker((position, datas) -> {

                    int index = 0;
                    if (!TextUtils.isEmpty(datas.thumbnail_pic_s02)) {
                        index = 2;
                    } else if (!TextUtils.isEmpty(datas.thumbnail_pic_s)) {
                        index = 1;
                    }

                    return index;
        });
    }
}
