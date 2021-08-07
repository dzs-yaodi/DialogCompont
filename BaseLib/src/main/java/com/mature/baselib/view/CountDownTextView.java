package com.mature.baselib.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

public class CountDownTextView extends TextView {

    private int duration = 2000;
    // 动画扫过的角度
    private int mSweepAngle = 360;
    // 属性动画
    private ValueAnimator animator;
    // 矩形用来保存位置大小信息
    private final RectF mRect = new RectF();
    // 圆弧的画笔
    private Paint mBackgroundPaint;

    public CountDownTextView(Context context) {
        this(context, null);
    }

    public CountDownTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CountDownTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int padding = 5;
        mRect.top = padding;
        mRect.left = padding;
        mRect.right = getWidth() - padding;
        mRect.bottom = getHeight() - padding;

        // 画倒计时线内圆
        canvas.drawArc(mRect, //弧线所使用的矩形区域大小
                -90,  //开始角度
                mSweepAngle, //扫过的角度
                false, //是否使用中心
                mBackgroundPaint); // 设置画笔

        start();

        super.onDraw(canvas);
    }

    private void init() {
        // 设置画笔平滑
        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 设置画笔颜色
        mBackgroundPaint.setColor(Color.WHITE);
        // 设置画笔边框宽度
        mBackgroundPaint.setStrokeWidth(5);
        // 设置画笔样式为边框类型
        mBackgroundPaint.setStyle(Paint.Style.STROKE);
    }
    /**
     * 开始倒计时
     */
    public void start() {
        // 在动画中
        if (mSweepAngle != 360) return;
        //  初始化属性动画
        animator = ValueAnimator.ofInt(mSweepAngle).setDuration(duration);
        // 设置插值
        animator.setInterpolator(new LinearInterpolator());
        // 设置动画监听
        animator.addUpdateListener(animation -> {
            // 获取属性动画返回的动画值
            mSweepAngle = (int) animation.getAnimatedValue();

            if (mSweepAngle == 360) {
                if (countDownListener != null) {
                    countDownListener.onComplete();
                }

                if (animator != null) {
                    animation.cancel();
                }
            } else {
                // 重绘自己
                invalidate();
            }
        });

        // 开始动画
        animator.start();
    }

    public void stop() {
        if (animator != null) {
            animator.cancel();
        }
    }

    public interface OnCountDownListener{
        void onComplete();
    }

    private OnCountDownListener countDownListener;

    public void setCountDownListener(OnCountDownListener countDownListener) {
        this.countDownListener = countDownListener;
    }
}
