package com.bykv.vk.openvk.eli.eli.DbA.DbA;

import android.os.Looper;

/* loaded from: classes3.dex */
public final class eli {
    public static boolean eli() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
