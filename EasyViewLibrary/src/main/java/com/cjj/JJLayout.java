package com.cjj;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;


public class JJLayout extends FrameLayout {
    private int childLayoutW,childLayoutH;
    private JJView jjView;
    private int share;

    public JJLayout(Context context) {
        this(context, null);
    }

    public JJLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JJLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs,defStyle);
    }

    /**
     * 初始化
     * @param attrs
     * @param defStyle
     */
    protected void init(AttributeSet attrs, int defStyle) {
        if (isInEditMode())
            return;
        /**
         * true：滚动时child不可以绘制到padding区域，即剪裁掉
         * false：滚动时child可以绘制到padding区域
         */
        setClipToPadding(false);
        final TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.JJLayout, defStyle, 0);
        /**
         *  形状 0 代表 矩形 1代表椭圆
         */
        share = t.getInt(R.styleable.JJLayout_shape, 0);
        t.recycle();
    }



    /**
     * ondraw前进行一些初始化
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        jjView = new JJView(getContext());
        switch (share)
        {
            case 0:
                jjView.isRect(true);
                break;
            case 1:
                jjView.isRect(false);
                break;
        }
        addView(jjView, 0);
        setPadding(10, 10, 10, 10);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for(int i = 0; i<count; i++)
        {
            View child = getChildAt(i);
            childLayoutW = (child.getMeasuredWidth()>childLayoutW)?child.getMeasuredWidth():childLayoutW;
            childLayoutH = (child.getMeasuredHeight()>childLayoutH)?child.getMeasuredHeight():childLayoutH;
        }
        jjView.measure(MeasureSpec.makeMeasureSpec(childLayoutW+10,MeasureSpec.EXACTLY),MeasureSpec.makeMeasureSpec(childLayoutH+10,MeasureSpec.EXACTLY));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int width  = right - left;
        int height = bottom - top;
        jjView.layout(0, 0, width, height);
    }



}
