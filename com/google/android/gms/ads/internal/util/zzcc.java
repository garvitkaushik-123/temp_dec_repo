package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzcc implements zzhgr {
    private final zzhha zza;

    private zzcc(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcc zza(zzhha zzhhaVar) {
        return new zzcc(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcb(((zzchl) this.zza).zza());
    }
}
