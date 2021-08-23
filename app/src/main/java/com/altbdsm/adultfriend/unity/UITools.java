package com.altbdsm.adultfriend.unity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.ViewCompat;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class UITools {

    /**
     * dp转px单位
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private static Toast strLongtoast;

    public static void toastShowLong(Context context, String mes) {
        if (TextUtils.isEmpty(mes)) {
            return;
        }
        if (strLongtoast != null) {
            strLongtoast.setText(mes);
            strLongtoast.setDuration(Toast.LENGTH_SHORT);
        } else {
            strLongtoast = Toast.makeText(context, mes, Toast.LENGTH_SHORT);
        }

        strLongtoast.show();
    }


    /**
     * 初始化状态栏，适配沉浸式
     */
    public static void initTitleBar(Activity activity, View bgView,String color) {
        //设置沉浸式状态栏
        translucentStatusBar(activity, true);
        //计算出状态栏高度，并设置view留出对应位置
        int height = (int) getStatusBarHeight(activity);
        bgView.setPadding(0, height, 0, 0);
        bgView.setBackgroundColor(Color.parseColor(color));
    }


    public static void translucentStatusBar(Activity activity, boolean hideStatusBarBackground) {
        Window window = activity.getWindow();
        //添加Flag把状态栏设为可绘制模式
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (hideStatusBarBackground) {
            //如果为全透明模式，取消设置Window半透明的Flag
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置状态栏为透明
            window.setStatusBarColor(Color.TRANSPARENT);
            //设置window的状态栏不可见
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        } else {
            //如果为半透明模式，添加设置Window半透明的Flag
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置系统状态栏处于可见状态
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }
        //view不根据系统窗口来调整自己的布局
        ViewGroup mContentView = window.findViewById(Window.ID_ANDROID_CONTENT);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            ViewCompat.requestApplyInsets(mChildView);
        }
    }

    /**
     * 获取状态栏高度。
     */
    public static float getStatusBarHeight(Context context) {
        float result = 0;
        try {
            int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = context.getResources().getDimension(resourceId);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    /**
     * 显示键盘
     *
     * @param et 输入焦点
     */
    public static void showInput(final EditText et) {
        et.requestFocus();
        InputMethodManager imm = (InputMethodManager) et.getContext().getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(et, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * 隐藏键盘
     */
    public static void hideInput(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
        View v = activity.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }
}
