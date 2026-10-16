package com.bytedance.sdk.component.adexpress.dynamic.Os.eli;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* loaded from: classes3.dex */
public class eli implements View.OnTouchListener {
    private static int Os = 10;
    private float DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.Os.wC aGH;
    private float eli;
    private int ui;
    private RectF MGA = new RectF();
    private long kb = 0;
    private final int wC = 200;
    private final int FC = 3;
    private SoftReference<ViewGroup> aAs = new SoftReference<>(null);

    public eli(com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar, int i, final ViewGroup viewGroup) {
        this.ui = Os;
        this.aGH = wCVar;
        if (i > 0) {
            this.ui = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.Os.eli.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.aAs = new SoftReference(viewGroup);
                }
            });
        }
    }

    private RectF eli(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], r2 + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.MGA = eli(this.aAs.get());
            this.eli = motionEvent.getRawX();
            this.DbA = motionEvent.getRawY();
            this.kb = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.MGA;
            if (rectF != null && !rectF.contains(this.eli, this.DbA)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.eli);
            float abs2 = Math.abs(rawY - this.DbA);
            int i = this.ui;
            if (abs >= i && abs2 >= i) {
                com.bytedance.sdk.component.adexpress.dynamic.Os.wC wCVar2 = this.aGH;
                if (wCVar2 != null) {
                    wCVar2.eli();
                }
            } else if ((System.currentTimeMillis() - this.kb < 200 || (abs < 3.0f && abs2 < 3.0f)) && (wCVar = this.aGH) != null) {
                wCVar.eli();
            }
        }
        return true;
    }
}
