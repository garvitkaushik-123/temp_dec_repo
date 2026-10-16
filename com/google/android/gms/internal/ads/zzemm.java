package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzemm implements zzeuc {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    zzemm(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 6;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzemk
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(new zzemn((String) obj));
            }
        };
        ListenableFuture listenableFuture = this.zza;
        Executor executor = this.zzb;
        ListenableFuture zzn = zzgdn.zzn(listenableFuture, zzgcuVar, executor);
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmS)).intValue() > 0) {
            zzn = zzgdn.zzo(zzn, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(r1)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgdn.zzf(zzn, Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeml
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return ((Throwable) obj) instanceof TimeoutException ? zzgdn.zzh(new zzemn(Integer.toString(17))) : zzgdn.zzh(new zzemn(null));
            }
        }, executor);
    }
}
