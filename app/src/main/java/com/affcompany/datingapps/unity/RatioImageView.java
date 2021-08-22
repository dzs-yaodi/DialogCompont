package com.affcompany.datingapps.unity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;

import com.affcompany.datingapps.BuildConfig;
import com.affcompany.datingapps.R;

public class RatioImageView extends AppCompatImageView {

    //ratio = 宽/高
    private float ratio = 0f;
    private Paint paint;

    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        ratio = a.getFloat(R.styleable.RatioImageView_utility_ratio, 0f);
        a.recycle();

        if (BuildConfig.DEBUG) {
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setTextSize(24);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (ratio > 0) {
            setMeasuredDimension(View.getDefaultSize(0, widthMeasureSpec), View.getDefaultSize(0, heightMeasureSpec));
            int widthSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY);
            //通过宽度设置高度
            int heightSpec = MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() / ratio), MeasureSpec.EXACTLY);
            super.onMeasure(widthSpec, heightSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /**
     * 设置一个宽高（值 = 宽/高）,当调用这种时，height一定要设置成wrap_content
     * 在调用了该方法后，需要调用可以重新测量的方法，例如设置图片等方法，或者requestLayout();
     *
     * @param ratio ratio
     */
    public void setRatio(float ratio) {
        if (this.ratio == ratio || ratio <= 0) {
            return;
        }
        this.ratio = ratio;
    }

    public void setRatioRequest(float ratio) {
        if (this.ratio == ratio || ratio <= 0) {
            return;
        }
        this.ratio = ratio;
        ViewGroup.LayoutParams lp = getLayoutParams();
        int w = lp.width;
        int h = (int) (w/ratio);
        lp.width = w;
        lp.height = h;
        setLayoutParams(lp);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (paint != null) {
            int height = getHeight();
            int width = getWidth();
            canvas.drawText(width + "x" + height, 0, 30, paint);
        }
    }
}
