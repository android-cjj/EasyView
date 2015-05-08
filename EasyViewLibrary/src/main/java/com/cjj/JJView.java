package com.cjj;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


public class JJView extends View {
    private Rect rect;
    private Paint paint;
    private boolean isRect = true;

    protected JJView(Context context) {
        this(context, null);
        init();
    }

    protected JJView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    protected JJView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        //使ondraw执行
        setWillNotDraw(false);
        //如果当前版本号大小于3.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        paint = new Paint();
        paint.setColor(Color.argb(100, 0, 0, 0));
        rect = new Rect();
        this.setClickable(true);
    }


    protected void isRect(boolean shape) {
        isRect = shape;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);

        int w_model = MeasureSpec.getMode(widthMeasureSpec);
        int h_model = MeasureSpec.getMode(heightMeasureSpec);

        if (w_model == MeasureSpec.AT_MOST || w_model == MeasureSpec.UNSPECIFIED) {
            w = 0;
        }

        if (h_model == MeasureSpec.AT_MOST || h_model == MeasureSpec.UNSPECIFIED) {
            h = 0;
        }

        super.onMeasure(
                MeasureSpec.makeMeasureSpec(w, w_model),
                MeasureSpec.makeMeasureSpec(h, h_model));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int parentWidth = (right - left);
        int parentHeight = (bottom - top);
        rect.left = 10;
        rect.top = (10 + 2);
        rect.right = parentWidth - 10;
        rect.bottom = (parentHeight + 2 - 10);
        paint.setMaskFilter(new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(isRect)
        {
            canvas.drawRect(rect, paint);
        }else
        {
            canvas.drawOval(new RectF(rect),paint);
        }
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                paint.setAlpha(0);
//                invalidate();
//                break;
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_UP:
//                paint.setAlpha(100);
//                invalidate();
//                break;
//        }
//        return super.onTouchEvent(event);
//    }


}
