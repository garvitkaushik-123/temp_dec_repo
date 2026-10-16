package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.Os.FC;

/* loaded from: classes3.dex */
public class DbA implements View.OnTouchListener {
    private float DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.Os.wC MGA;
    private long Os;
    private boolean aGH;
    private float eli;
    private FC ui;

    public DbA(FC fc, com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar) {
        this.ui = fc;
        this.MGA = wCVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Os = System.currentTimeMillis();
            this.eli = motionEvent.getX();
            this.DbA = motionEvent.getY();
            this.ui.ui();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.eli) >= com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), 10.0f) || Math.abs(y - this.DbA) >= com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli(), 10.0f)) {
                    this.aGH = true;
                    this.ui.MGA();
                }
            }
        } else {
            if (this.aGH) {
                return false;
            }
            if (System.currentTimeMillis() - this.Os >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar = this.MGA;
                if (wCVar != null) {
                    wCVar.eli();
                }
            }
            this.ui.MGA();
        }
        return true;
    }
}
