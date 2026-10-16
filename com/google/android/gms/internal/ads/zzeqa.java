package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeqa implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzeqa(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
    }

    public static zzeqa zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzeqa(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeso zzesoVar;
        zzeoa zzb = ((zzeoc) this.zza).zzb();
        zzeou zzeouVar = (zzeou) this.zzb.zzb();
        List list = (List) this.zzc.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzd.zzb();
        if (list.contains("54")) {
            zzesoVar = new zzeso(zzeouVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmL)).intValue(), scheduledExecutorService);
        } else {
            zzesoVar = new zzeso(zzb, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmL)).intValue(), scheduledExecutorService);
        }
        return zzesoVar;
    }
}
