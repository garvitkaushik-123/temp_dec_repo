package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeqd implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzeqd(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzeqd zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqd(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeso(((zzeoq) this.zza).zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmI)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
