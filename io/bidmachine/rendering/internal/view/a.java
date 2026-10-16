package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes8.dex */
public class a extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    private float f7101a;

    public a(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.f7101a <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = this.f7101a;
        if ((f3 / (f / f2)) - 1.0f > 0.0f) {
            measuredHeight = (int) (f / f3);
        } else {
            measuredWidth = (int) (f2 * f3);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setVideoAspectRatio(float videoAspectRatio) {
        if (videoAspectRatio == 0.0f || this.f7101a == videoAspectRatio) {
            return;
        }
        this.f7101a = videoAspectRatio;
        requestLayout();
    }
}
