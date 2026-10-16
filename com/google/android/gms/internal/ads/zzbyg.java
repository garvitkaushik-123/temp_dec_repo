package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbyg implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzbyg(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzbyg zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzbyg(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbyf zzb() {
        return new zzbyf((Clock) this.zza.zzb(), (zzbyd) this.zzb.zzb());
    }
}
