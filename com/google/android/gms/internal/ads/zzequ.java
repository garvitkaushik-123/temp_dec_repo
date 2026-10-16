package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzequ implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzequ(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzequ zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzequ(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeso((zzeou) this.zza.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmx)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
