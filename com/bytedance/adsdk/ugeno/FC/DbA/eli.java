package com.bytedance.adsdk.ugeno.FC.DbA;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.core.NU;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli extends FrameLayout {
    private Map<Integer, NU> DbA;
    private aGH eli;

    public eli(Context context) {
        super(context);
    }

    public void setEventMap(Map<Integer, NU> map) {
        this.DbA = map;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        aGH agh = this.eli;
        if (agh != null) {
            int[] eli = agh.eli(i, i2);
            super.onMeasure(eli[0], eli[1]);
        } else {
            super.onMeasure(i, i2);
        }
        aGH agh2 = this.eli;
        if (agh2 != null) {
            agh2.ui();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        aGH agh = this.eli;
        if (agh != null) {
            agh.MGA();
        }
        super.onLayout(z, i, i2, i3, i4);
        aGH agh2 = this.eli;
        if (agh2 != null) {
            agh2.eli(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, NU> map = this.DbA;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void eli(aGH agh) {
        this.eli = agh;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aGH agh = this.eli;
        if (agh != null) {
            agh.kb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aGH agh = this.eli;
        if (agh != null) {
            agh.wC();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aGH agh = this.eli;
        if (agh != null) {
            agh.DbA(i, i2, i3, i4);
        }
    }
}
