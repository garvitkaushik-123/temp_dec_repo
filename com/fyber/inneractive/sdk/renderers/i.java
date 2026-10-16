package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public final class i extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final float f1718a;

    public i(Context context, float f) {
        super(context);
        this.f1718a = f;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        View.MeasureSpec.getMode(i);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == 0 || (mode == Integer.MIN_VALUE && View.MeasureSpec.getSize(i2) > 0)) {
            int size = View.MeasureSpec.getSize(i);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            float f = this.f1718a;
            if (f != 0.0f) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) (size * f), 1073741824);
            }
            i3 = makeMeasureSpec;
        } else {
            int size2 = View.MeasureSpec.getSize(i);
            int size3 = View.MeasureSpec.getSize(i2);
            i3 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        }
        super.onMeasure(i3, i2);
    }
}
