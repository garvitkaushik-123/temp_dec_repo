package com.bytedance.sdk.openadsdk.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class Os extends FrameLayout {
    private void init() {
    }

    public Os(Context context) {
        super(context);
        init();
    }

    public Os(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public Os(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(FC.eli(this, layoutParams));
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
