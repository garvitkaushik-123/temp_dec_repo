package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhan {
    zzhan() {
    }

    public static final boolean zza(Object obj) {
        return !((zzham) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzham zzhamVar = (zzham) obj;
        zzham zzhamVar2 = (zzham) obj2;
        if (!zzhamVar2.isEmpty()) {
            if (!zzhamVar.zze()) {
                zzhamVar = zzhamVar.zzb();
            }
            zzhamVar.zzd(zzhamVar2);
        }
        return zzhamVar;
    }
}
