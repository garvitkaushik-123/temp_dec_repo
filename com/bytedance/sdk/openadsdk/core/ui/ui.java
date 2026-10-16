package com.bytedance.sdk.openadsdk.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class ui extends LinearLayout {
    public ui(Context context) {
        super(context);
        init();
    }

    public ui(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ui(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setLayoutDirection(3);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(FC.eli(this, layoutParams));
    }

    @Override // android.widget.LinearLayout
    public void setGravity(int i) {
        super.setGravity(FC.eli(i));
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
