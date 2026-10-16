package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeou implements zzeuc {
    private final AtomicReference zza = new AtomicReference();
    private final AtomicReference zzb = new AtomicReference(false);
    private final Clock zzc;
    private final Executor zzd;
    private final zzeuc zze;
    private final long zzf;
    private final zzdsj zzg;

    public zzeou(zzeuc zzeucVar, long j, Clock clock, Executor executor, zzdsj zzdsjVar) {
        this.zzc = clock;
        this.zze = zzeucVar;
        this.zzf = j;
        this.zzd = executor;
        this.zzg = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return this.zze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzeot zzeotVar;
        zzeot zzeotVar2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmj)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmi)).booleanValue() && !((Boolean) this.zzb.getAndSet(true)).booleanValue()) {
                ScheduledExecutorService scheduledExecutorService = zzcaf.zzd;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzeor
                    @Override // java.lang.Runnable
                    public final void run() {
                        r0.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeos
                            @Override // java.lang.Runnable
                            public final void run() {
                                r0.zza.set(new zzeot(r0.zze.zzb(), r0.zzf, zzeou.this.zzc));
                            }
                        });
                    }
                };
                long j = this.zzf;
                scheduledExecutorService.scheduleWithFixedDelay(runnable, j, j, TimeUnit.MILLISECONDS);
            }
            synchronized (this) {
                AtomicReference atomicReference = this.zza;
                zzeotVar = (zzeot) atomicReference.get();
                if (zzeotVar == null) {
                    zzeot zzeotVar3 = new zzeot(this.zze.zzb(), this.zzf, this.zzc);
                    atomicReference.set(zzeotVar3);
                    return zzeotVar3.zza;
                }
                if (!((Boolean) this.zzb.get()).booleanValue() && zzeotVar.zza()) {
                    ListenableFuture listenableFuture = zzeotVar.zza;
                    zzeuc zzeucVar = this.zze;
                    zzeotVar2 = new zzeot(zzeucVar.zzb(), this.zzf, this.zzc);
                    this.zza.set(zzeotVar2);
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmk)).booleanValue()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzml)).booleanValue()) {
                            zzdsi zza = this.zzg.zza();
                            zza.zzb("action", "scs");
                            zza.zzb("sid", String.valueOf(zzeucVar.zza()));
                            zza.zzj();
                        }
                        return listenableFuture;
                    }
                    zzeotVar = zzeotVar2;
                }
            }
        } else {
            AtomicReference atomicReference2 = this.zza;
            zzeotVar = (zzeot) atomicReference2.get();
            if (zzeotVar == null || zzeotVar.zza()) {
                zzeuc zzeucVar2 = this.zze;
                zzeotVar2 = new zzeot(zzeucVar2.zzb(), this.zzf, this.zzc);
                atomicReference2.set(zzeotVar2);
                zzeotVar = zzeotVar2;
            }
        }
        return zzeotVar.zza;
    }
}
