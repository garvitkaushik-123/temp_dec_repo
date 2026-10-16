package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeso implements zzeuc {
    private final zzeuc zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzeso(zzeuc zzeucVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeucVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeso zzesoVar, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcz)).booleanValue()) {
            zzeuc zzeucVar = zzesoVar.zza;
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "OptionalSignalTimeout:" + zzeucVar.zza());
        }
        return zzgdn.zzh(null);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        ListenableFuture zzb = this.zza.zzb();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcA)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            zzb = zzgdn.zzo(zzb, j, timeUnit, this.zzc);
        }
        return zzgdn.zzf(zzb, Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzesn
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeso.zzc(zzeso.this, (Throwable) obj);
            }
        }, zzcaf.zzg);
    }
}
