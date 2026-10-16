package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcbw implements Runnable {
    zzcbw(zzcby zzcbyVar) {
        Objects.requireNonNull(zzcbyVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
