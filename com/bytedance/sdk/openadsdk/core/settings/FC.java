package com.bytedance.sdk.openadsdk.core.settings;

import android.util.Log;
import com.bytedance.sdk.component.utils.Xb;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class FC {
    private static final AtomicInteger eli = new AtomicInteger(1);

    public static boolean eli() {
        return eli.get() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void eli(int i) {
        boolean z = true;
        if (i == 1 || i == 2) {
            try {
                AtomicInteger atomicInteger = eli;
                if (atomicInteger.get() != i) {
                    try {
                        atomicInteger.set(i);
                    } catch (Throwable th) {
                        th = th;
                        Xb.Os("SdkSwitch", th.getMessage());
                        if (z) {
                        }
                    }
                } else {
                    z = false;
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            if (z) {
                return;
            }
            Log.e("SdkSwitch", "switch status changed: " + eli());
            if (eli()) {
                com.bytedance.sdk.openadsdk.aGH.eli.aGH.DbA();
            } else {
                com.bytedance.sdk.openadsdk.aGH.eli.aGH.Os();
            }
        }
    }
}
