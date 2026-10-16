package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class wC implements View.OnTouchListener {
    private final boolean DbA;
    private float MGA;
    private final int Os = 10;
    private float aGH;
    private final com.bytedance.sdk.component.adexpress.dynamic.Os.wC eli;
    private float kb;
    private float ui;

    public wC(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar, boolean z) {
        this.eli = wCVar;
        this.DbA = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar;
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.aGH = motionEvent.getX();
            this.ui = motionEvent.getY();
            new Object[]{"mStartX: ", Float.valueOf(this.aGH), ", mStartY: " + this.ui};
        } else if (action == 1) {
            this.MGA = motionEvent.getX();
            this.kb = motionEvent.getY();
            new Object[]{"mEndX: ", Float.valueOf(this.MGA), ", mEndY: " + this.kb};
            if (!this.DbA && (wCVar2 = this.eli) != null) {
                wCVar2.eli();
            } else {
                float f = this.MGA - this.aGH;
                float f2 = this.kb - this.ui;
                float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                new Object[]{"slideDistancePx: ", Float.valueOf(sqrt)};
                float DbA = com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), Math.abs(sqrt));
                new Object[]{"slideDistanceDp:", Float.valueOf(DbA), " and ", "mSlideThreshold:", 10};
                if (DbA > 10.0f && (wCVar = this.eli) != null) {
                    wCVar.eli();
                }
            }
        }
        return true;
    }
}
