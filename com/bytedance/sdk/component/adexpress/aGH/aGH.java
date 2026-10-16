package com.bytedance.sdk.component.adexpress.aGH;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class aGH {
    public static void eli(com.bytedance.sdk.component.wC.wC wCVar, int i) {
        if (wCVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.eli.eli.Os Os = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os();
        ExecutorService nn = Os != null ? Os.nn() : null;
        if (nn != null) {
            wCVar.setPriority(i);
            nn.execute(wCVar);
        } else {
            com.bytedance.sdk.component.wC.MGA.eli(wCVar, i);
        }
    }

    public static void DbA(com.bytedance.sdk.component.wC.wC wCVar, int i) {
        if (wCVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.eli.eli.Os Os = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os();
        ExecutorService NU = Os != null ? Os.NU() : null;
        if (NU != null) {
            wCVar.setPriority(i);
            NU.execute(wCVar);
        } else {
            com.bytedance.sdk.component.wC.MGA.eli(wCVar);
        }
    }

    public static ScheduledFuture eli(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.wC.MGA.MGA().schedule(runnable, j, timeUnit);
    }
}
