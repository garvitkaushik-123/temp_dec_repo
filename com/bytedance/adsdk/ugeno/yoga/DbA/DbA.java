package com.bytedance.adsdk.ugeno.yoga.DbA;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.DbA.Os;
import com.bytedance.adsdk.ugeno.yoga.aAs;
import com.bytedance.adsdk.ugeno.yoga.du;
import com.bytedance.adsdk.ugeno.yoga.kb;

/* loaded from: classes3.dex */
public class DbA extends ViewGroup {
    public aAs getYogaNode() {
        throw null;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof DbA) {
            throw null;
        }
        aAs eli = du.eli();
        Os.eli(new Os.eli(layoutParams), eli, view);
        eli.eli(view);
        eli.eli((kb) new Os.DbA());
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new Os.eli(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new Os.eli(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof Os.eli;
    }
}
