package com.bytedance.sdk.component.MGA.eli.Os;

import com.bytedance.sdk.component.MGA.eli.ui;
import com.bytedance.sdk.component.MGA.eli.wC;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class DbA {
    public static void eli(AtomicLong atomicLong, int i) {
        ui aqO = wC.kb().aqO();
        if (aqO == null || !aqO.kb() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
