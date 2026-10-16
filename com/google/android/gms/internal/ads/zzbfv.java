package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbfv {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    static zzbft zza() {
        return (zzbft) zza.get();
    }

    static zzbfu zzb() {
        return (zzbfu) zzb.get();
    }

    public static void zzc(zzbft zzbftVar) {
        zza.set(zzbftVar);
    }
}
