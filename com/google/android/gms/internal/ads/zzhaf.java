package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhaf {
    zzhaf() {
    }

    public static final List zza(Object obj, long j) {
        zzgzt zzgztVar = (zzgzt) zzhce.zzh(obj, j);
        if (zzgztVar.zzc()) {
            return zzgztVar;
        }
        int size = zzgztVar.size();
        zzgzt zzf = zzgztVar.zzf(size == 0 ? 10 : size + size);
        zzhce.zzv(obj, j, zzf);
        return zzf;
    }
}
