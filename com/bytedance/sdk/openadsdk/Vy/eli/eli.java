package com.bytedance.sdk.openadsdk.Vy.eli;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.wC;

/* loaded from: classes3.dex */
public class eli {
    private static HandlerThread DbA;
    private static Handler eli;

    public static Handler eli() {
        HandlerThread handlerThread;
        try {
            handlerThread = DbA;
        } catch (Throwable unused) {
        }
        if (handlerThread != null && handlerThread.isAlive()) {
            if (eli == null) {
                synchronized (eli.class) {
                    if (eli == null) {
                        eli = new Handler(DbA.getLooper());
                    }
                }
            }
            return eli;
        }
        synchronized (eli.class) {
            HandlerThread handlerThread2 = DbA;
            if (handlerThread2 == null || !handlerThread2.isAlive()) {
                DbA = wC.eli("csj_ev");
                eli = new Handler(DbA.getLooper());
            }
        }
        return eli;
    }
}
