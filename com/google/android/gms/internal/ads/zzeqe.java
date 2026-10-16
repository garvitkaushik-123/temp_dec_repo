package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeqe implements zzhgr {
    private final zzhha zza;

    private zzeqe(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzeqe zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzeqe(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfyv zzn;
        zzeow zzc = zzeoy.zzc();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzet)).booleanValue()) {
            zzn = zzfyv.zzo(new zzeso(zzc, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeu)).intValue(), scheduledExecutorService));
        } else {
            zzn = zzfyv.zzn();
        }
        zzhgz.zzb(zzn);
        return zzn;
    }
}
