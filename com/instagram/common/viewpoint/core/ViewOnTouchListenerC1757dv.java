package com.instagram.common.viewpoint.core;

import android.view.MotionEvent;
import android.view.View;

/* renamed from: com.facebook.ads.redexgen.X.dv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class ViewOnTouchListenerC1757dv implements View.OnTouchListener {
    public final /* synthetic */ C4V A00;

    public ViewOnTouchListenerC1757dv(C4V c4v) {
        this.A00 = c4v;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        AbstractC1642c3 abstractC1642c3;
        AbstractC1642c3 abstractC1642c32;
        float x = motionEvent.getX();
        view2 = this.A00.A0H;
        if (x >= view2.getX()) {
            float x2 = motionEvent.getX();
            view3 = this.A00.A0H;
            float x3 = view3.getX();
            view4 = this.A00.A0H;
            if (x2 <= x3 + view4.getWidth()) {
                float y = motionEvent.getY();
                view5 = this.A00.A0H;
                if (y >= view5.getY()) {
                    float y2 = motionEvent.getY();
                    view6 = this.A00.A0H;
                    float y3 = view6.getY();
                    view7 = this.A00.A0H;
                    if (y2 <= y3 + view7.getHeight()) {
                        abstractC1642c3 = this.A00.A02;
                        if (abstractC1642c3 != null) {
                            abstractC1642c32 = this.A00.A02;
                            abstractC1642c32.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
