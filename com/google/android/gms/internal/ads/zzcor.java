package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcor implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzcor(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
    }

    public static zzcor zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzcor(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    public static zzcyv zzd(ScheduledExecutorService scheduledExecutorService, Clock clock, zzdsj zzdsjVar) {
        return new zzcyv(scheduledExecutorService, clock, zzdsjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzcyv zzb() {
        return zzd((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb(), (zzdsj) this.zzc.zzb());
    }
}
