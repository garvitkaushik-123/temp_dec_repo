package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzfvn implements Serializable {
    zzfvn() {
    }

    public static zzfvn zzc() {
        return zzfut.zza;
    }

    public static zzfvn zzd(Object obj) {
        return obj == null ? zzfut.zza : new zzfvu(obj);
    }

    public abstract zzfvn zza(zzfve zzfveVar);

    public abstract Object zzb(Object obj);
}
