package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbc {
    public static final /* synthetic */ int zza = 0;
    private static final zzhbc zzb = new zzhbc();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzhbm zzc = new zzhak();

    private zzhbc() {
    }

    public static zzhbc zza() {
        return zzb;
    }

    public final zzhbl zzb(Class cls) {
        zzgzu.zzc(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zzhbl zzhblVar = (zzhbl) concurrentMap.get(cls);
        if (zzhblVar == null) {
            zzhblVar = this.zzc.zza(cls);
            zzgzu.zzc(cls, "messageType");
            zzhbl zzhblVar2 = (zzhbl) concurrentMap.putIfAbsent(cls, zzhblVar);
            if (zzhblVar2 != null) {
                return zzhblVar2;
            }
        }
        return zzhblVar;
    }
}
