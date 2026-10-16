package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class aGH implements View.OnTouchListener {
    private float DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.Os.wC FC;
    private float MGA;
    private float Os;
    private int aAs;
    private float aGH;
    private boolean du;
    private float eli;
    private float kb;
    private boolean ui = true;
    private boolean wC;

    public aGH(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar, int i, boolean z) {
        this.FC = wCVar;
        this.aAs = i;
        this.du = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar;
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar2;
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.eli = motionEvent.getX();
            this.DbA = motionEvent.getY();
            this.MGA = motionEvent.getY();
            this.ui = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.kb = y;
                if (Math.abs(y - this.MGA) > 10.0f) {
                    this.wC = true;
                }
                this.aGH = motionEvent.getX();
                this.Os = motionEvent.getY();
                if (Math.abs(this.aGH - this.eli) > 8.0f || Math.abs(this.Os - this.DbA) > 8.0f) {
                    this.ui = false;
                }
            }
        } else {
            if (!this.wC && !this.ui) {
                return false;
            }
            if (!this.du && (wCVar3 = this.FC) != null) {
                wCVar3.eli();
            } else {
                int DbA = com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), Math.abs(this.kb - this.MGA));
                if (this.kb - this.MGA < 0.0f && DbA > this.aAs && (wCVar2 = this.FC) != null) {
                    wCVar2.eli();
                } else if (this.ui && (wCVar = this.FC) != null) {
                    wCVar.eli();
                }
            }
        }
        return true;
    }
}
