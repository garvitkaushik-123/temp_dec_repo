package com.bytedance.sdk.openadsdk.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Xb;

/* loaded from: classes3.dex */
public class wC extends TextView {
    public wC(Context context) {
        super(context);
        eli();
    }

    public wC(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eli();
    }

    private void eli() {
        setTextDirection(5);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        super.setGravity(FC.eli(i));
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(FC.eli(this, layoutParams));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            Xb.Os("PAGTextView", th.toString());
        }
    }
}
