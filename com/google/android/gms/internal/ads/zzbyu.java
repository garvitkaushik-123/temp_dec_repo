package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbyu implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzbyu(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzbyu zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzbyu(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbyt((Context) this.zza.zzb(), ((zzbyg) this.zzb).zzb());
    }
}
