package com.bytedance.adsdk.ugeno.MGA;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* loaded from: classes3.dex */
public class DbA extends eli<com.bytedance.adsdk.ugeno.DbA.Os> {
    private com.bytedance.adsdk.ugeno.aGH aGH;

    public DbA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.MGA.eli
    public View aAs(int i) {
        return ((com.bytedance.adsdk.ugeno.DbA.Os) this.eli.get(i)).du();
    }

    public void eli(com.bytedance.adsdk.ugeno.aGH agh) {
        this.aGH = agh;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.aGH agh = this.aGH;
        if (agh != null) {
            int[] eli = agh.eli(i, i2);
            super.onMeasure(eli[0], eli[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.aGH agh2 = this.aGH;
        if (agh2 != null) {
            agh2.ui();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.aGH agh = this.aGH;
        if (agh != null) {
            agh.MGA();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.aGH agh2 = this.aGH;
        if (agh2 != null) {
            agh2.eli(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.aGH agh = this.aGH;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.aGH agh = this.aGH;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.aGH agh = this.aGH;
        if (agh != null) {
            agh.DbA(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }
}
