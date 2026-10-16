package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhgv extends zzhgn {
    static {
        zzhgs.zza(Collections.emptyMap());
    }

    /* synthetic */ zzhgv(Map map, zzhgt zzhgtVar) {
        super(map);
    }

    public static zzhgu zzc(int i) {
        return new zzhgu(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final Map zzb() {
        LinkedHashMap zzb = zzhgo.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzb.put(entry.getKey(), ((zzhha) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzb);
    }
}
