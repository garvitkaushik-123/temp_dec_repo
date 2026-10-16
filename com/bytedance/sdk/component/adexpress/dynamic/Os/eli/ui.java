package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class ui implements View.OnTouchListener {
    private float DbA;
    private boolean Os;
    private com.bytedance.sdk.component.adexpress.dynamic.Os.wC aGH;
    private float eli;
    private int ui;

    public ui(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar, int i) {
        this.aGH = wCVar;
        this.ui = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.eli = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.DbA = y;
                if (Math.abs(y - this.eli) > 10.0f) {
                    this.Os = true;
                }
            }
        } else {
            if (!this.Os) {
                return false;
            }
            int DbA = com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), Math.abs(this.DbA - this.eli));
            if (this.DbA - this.eli < 0.0f && DbA > this.ui && (wCVar = this.aGH) != null) {
                wCVar.eli();
                this.eli = 0.0f;
                this.DbA = 0.0f;
                this.Os = false;
            }
        }
        return true;
    }
}
