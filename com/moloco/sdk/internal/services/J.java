package com.moloco.sdk.internal.services;

import android.os.SystemClock;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* loaded from: classes6.dex */
public final class J implements I {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5616a = 0;

    @Override // com.moloco.sdk.internal.services.I
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.moloco.sdk.internal.services.I
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.moloco.sdk.internal.services.I
    @Deprecated(message = "Use currentTime() instead", replaceWith = @ReplaceWith(expression = "currentTime()", imports = {}))
    public long invoke() {
        return System.currentTimeMillis();
    }
}
