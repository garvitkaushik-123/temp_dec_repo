package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class Os implements View.OnTouchListener {
    private float DbA;
    private boolean FC;
    private com.bytedance.sdk.component.adexpress.dynamic.Os.wC MGA;
    private float Os;
    private float aGH;
    private float eli;
    private int kb;
    private boolean ui;
    private boolean wC;

    public Os(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar) {
        this(wCVar, 5);
    }

    public Os(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar, int i) {
        this.kb = 5;
        this.wC = true;
        this.MGA = wCVar;
        if (i > 0) {
            this.kb = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar;
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar2;
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar3;
        if (this.FC) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.eli = motionEvent.getX();
            this.DbA = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.aGH = motionEvent.getX();
                this.Os = motionEvent.getY();
                if (Math.abs(this.aGH - this.eli) > 10.0f) {
                    this.ui = true;
                }
                if (Math.abs(this.aGH - this.eli) > 8.0f || Math.abs(this.Os - this.DbA) > 8.0f) {
                    this.wC = false;
                }
                int DbA = com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), Math.abs(this.aGH - this.eli));
                if (this.aGH > this.eli && DbA > this.kb && (wCVar3 = this.MGA) != null) {
                    wCVar3.eli();
                    this.FC = true;
                }
            }
        } else {
            if (!this.ui && !this.wC) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int DbA2 = com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), Math.abs(this.aGH - this.eli));
            if (this.aGH > this.eli && DbA2 > this.kb && (wCVar2 = this.MGA) != null) {
                wCVar2.eli();
                this.FC = true;
            }
            float abs = Math.abs(x - this.eli);
            float abs2 = Math.abs(y - this.DbA);
            if ((abs < 8.0f || abs2 < 8.0f) && (wCVar = this.MGA) != null) {
                wCVar.DbA();
                this.FC = true;
            }
        }
        return true;
    }
}
