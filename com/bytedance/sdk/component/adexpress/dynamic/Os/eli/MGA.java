package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes3.dex */
public class MGA implements View.OnTouchListener {
    private static int Os = 10;
    private float DbA;
    private boolean aGH;
    private float eli;
    private com.bytedance.sdk.component.adexpress.dynamic.Os.wC ui;

    public MGA(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar) {
        this.ui = wCVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.eli = motionEvent.getX();
            this.DbA = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.eli) >= Os || Math.abs(y - this.DbA) >= Os) {
                    this.aGH = true;
                }
            } else if (action == 3) {
                this.aGH = false;
            }
        } else {
            if (this.aGH) {
                this.aGH = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.eli) >= Os || Math.abs(y2 - this.DbA) >= Os) {
                this.aGH = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar = this.ui;
                if (wCVar != null) {
                    wCVar.eli();
                }
            }
        }
        return true;
    }
}
