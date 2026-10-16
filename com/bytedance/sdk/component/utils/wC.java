package com.bytedance.sdk.component.utils;

import android.os.HandlerThread;

/* loaded from: classes3.dex */
public class wC {
    private static HandlerThread eli;

    public static void eli(HandlerThread handlerThread) {
        eli = handlerThread;
    }

    public static HandlerThread eli(String str) {
        return eli(str, 0);
    }

    public static HandlerThread eli(String str, int i) {
        if (com.bytedance.sdk.component.wC.FC.sCrashHappened) {
            return eli;
        }
        try {
            HandlerThread handlerThread = new HandlerThread(str, i) { // from class: com.bytedance.sdk.component.utils.wC.1
                boolean eli = false;

                @Override // java.lang.Thread
                public synchronized void start() {
                    if (this.eli) {
                        return;
                    }
                    this.eli = true;
                    super.start();
                }
            };
            handlerThread.start();
            return handlerThread;
        } catch (Throwable th) {
            Xb.eli("HandlerThreadUtils", "new handlerThread error", th);
            return eli;
        }
    }
}
