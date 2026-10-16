package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzctu implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzctu(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzctu zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzctu(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddv((zzdam) this.zza.zzb(), (Executor) this.zzb.zzb());
    }
}
