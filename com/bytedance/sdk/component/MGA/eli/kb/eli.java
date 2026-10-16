package com.bytedance.sdk.component.MGA.eli.kb;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.MGA.eli.ui;
import com.bytedance.sdk.component.MGA.eli.wC;

/* loaded from: classes3.dex */
public class eli {
    private static volatile Handler DbA = null;
    private static int Os = 3000;
    private static volatile HandlerThread eli;

    static {
        Os();
    }

    private static void Os() {
        HandlerThread eli2;
        ui aqO = wC.kb().aqO();
        if (aqO != null && (eli2 = aqO.eli("csj_ad_log", 10)) != null) {
            eli = eli2;
            return;
        }
        HandlerThread handlerThread = new HandlerThread("csj_ad_log", 10);
        eli = handlerThread;
        handlerThread.start();
    }

    public static Handler eli() {
        if (eli == null || !eli.isAlive()) {
            synchronized (eli.class) {
                if (eli == null || !eli.isAlive()) {
                    Os();
                    DbA = new Handler(eli.getLooper());
                }
            }
        } else if (DbA == null) {
            synchronized (eli.class) {
                if (DbA == null) {
                    DbA = new Handler(eli.getLooper());
                }
            }
        }
        return DbA;
    }

    public static int DbA() {
        if (Os <= 0) {
            Os = 3000;
        }
        return Os;
    }
}
