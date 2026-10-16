package com.google.android.gms.internal.play_billing;

import com.ironsource.C3040d4;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzbu {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    zzbu(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    final IllegalArgumentException zza() {
        Object obj = this.zzc;
        Object obj2 = this.zzb;
        Object obj3 = this.zza;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + C3040d4.i.b + String.valueOf(obj2) + " and " + String.valueOf(obj3) + C3040d4.i.b + String.valueOf(obj));
    }
}
