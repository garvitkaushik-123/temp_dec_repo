package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcto implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcto(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcto zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcto(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddv((zzdam) this.zza.zzb(), (Executor) this.zzb.zzb());
    }
}
