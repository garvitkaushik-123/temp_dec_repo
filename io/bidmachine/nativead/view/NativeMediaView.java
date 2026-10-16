package io.bidmachine.nativead.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes6.dex */
public class NativeMediaView extends RelativeLayout {
    private static final float ASPECT_MULTIPLIER_HEIGHT_TO_WIDTH = 1.7777778f;
    private static final float ASPECT_MULTIPLIER_WIDTH_TO_HEIGHT = 0.5625f;

    public NativeMediaView(Context context) {
        super(context);
    }

    public NativeMediaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NativeMediaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NativeMediaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, measuredWidth) : measuredWidth;
        }
        int i = (int) (size * ASPECT_MULTIPLIER_WIDTH_TO_HEIGHT);
        if (mode2 != 1073741824 || size2 >= i) {
            size2 = i;
        } else {
            size = (int) (size2 * ASPECT_MULTIPLIER_HEIGHT_TO_WIDTH);
        }
        if (Math.abs(size2 - measuredHeight) >= 2 || Math.abs(size - measuredWidth) >= 2) {
            getLayoutParams().width = size;
            getLayoutParams().height = size2;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
