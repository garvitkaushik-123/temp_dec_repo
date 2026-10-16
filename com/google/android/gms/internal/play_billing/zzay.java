package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzay extends zzbl {
    zzay() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzbl
    public final long zza() {
        return SystemClock.elapsedRealtime() * 1000000;
    }
}
