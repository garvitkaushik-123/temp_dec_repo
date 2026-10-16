package com.bytedance.adsdk.ugeno.core.DbA;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class eli {
    public String eli = "GesThrough_";
    private List<MotionEvent> DbA = new ArrayList();
    private Set<String> Os = Collections.synchronizedSet(new HashSet());

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, MotionEvent motionEvent) {
        if (os == null || motionEvent == null || this.DbA == null) {
            return;
        }
        this.eli = "GesThrough_" + os.nro();
        int[] iArr = new int[2];
        os.du().getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.DbA.clear();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(i, i2);
        this.DbA.add(obtain);
    }

    public boolean eli(MotionEvent motionEvent) {
        if (motionEvent == null || this.Os == null) {
            return false;
        }
        return this.Os.contains(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
    }

    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (this.DbA.isEmpty() || this.Os == null || os == null || os.du() == null || os.du().getRootView() == null) {
            return;
        }
        final View rootView = os.du().getRootView();
        Log.d(this.eli, "Re-dispatch motionEvents.size(): " + this.DbA.size());
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.DbA.eli.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : eli.this.DbA) {
                    if (motionEvent != null) {
                        eli.this.Os.add(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                eli.this.DbA.clear();
            }
        }, 300L);
    }
}
