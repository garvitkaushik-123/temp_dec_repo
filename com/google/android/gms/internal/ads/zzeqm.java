package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeqm implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzeqm(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
    }

    public static zzeqm zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzeqm(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzeso zzesoVar;
        zzerz zzc = zzesb.zzc();
        zzeou zzeouVar = (zzeou) this.zza.zzb();
        List list = (List) this.zzb.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzc.zzb();
        if (list.contains("24")) {
            zzesoVar = new zzeso(zzeouVar, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmE)).intValue(), scheduledExecutorService);
        } else {
            zzesoVar = new zzeso(zzc, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmE)).intValue(), scheduledExecutorService);
        }
        return zzesoVar;
    }
}
