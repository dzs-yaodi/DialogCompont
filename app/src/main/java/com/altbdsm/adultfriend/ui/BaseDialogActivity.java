package com.altbdsm.adultfriend.ui;

import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class BaseDialogActivity extends BaseActivity{

    @Override
    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//设置横向全屏
    }
}
