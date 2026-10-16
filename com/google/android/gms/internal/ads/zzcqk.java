package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcqk implements zzazd {
    private final zzcfg zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    zzcqk(zzcfg zzcfgVar, Executor executor) {
        this.zza = zzcfgVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final synchronized void zzdr(zzazc zzazcVar) {
        final zzcfg zzcfgVar = this.zza;
        if (zzcfgVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmY)).booleanValue()) {
                if (zzazcVar.zzj) {
                    if (!Boolean.TRUE.equals(this.zzc.getAndSet(true))) {
                        Executor executor = this.zzb;
                        Objects.requireNonNull(zzcfgVar);
                        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqi
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzcfg.this.onResume();
                            }
                        });
                    }
                } else {
                    if (!Boolean.FALSE.equals(this.zzc.getAndSet(false))) {
                        Executor executor2 = this.zzb;
                        Objects.requireNonNull(zzcfgVar);
                        executor2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqj
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzcfg.this.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
