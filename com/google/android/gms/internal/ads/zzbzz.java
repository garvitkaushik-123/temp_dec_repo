package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbzz {
    private zzgdy zza;
    private zzdsj zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);
    private final AtomicBoolean zzd = new AtomicBoolean(false);
    private long zze = -1;
    private long zzf = -1;

    public static /* synthetic */ void zza(zzbzz zzbzzVar) {
        zzdsj zzdsjVar;
        while (zzbzzVar.zzd.get()) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbzx
                @Override // java.lang.Runnable
                public final void run() {
                    atomicBoolean.getAndSet(true);
                }
            });
            try {
                Thread.sleep(zzbzzVar.zze);
                if (!atomicBoolean.get()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznV)).booleanValue() && (zzdsjVar = zzbzzVar.zzb) != null) {
                        zzdsi zza = zzdsjVar.zza();
                        zza.zzb("action", "paa");
                        zza.zzi();
                    }
                }
                do {
                    try {
                        Thread.sleep(zzbzzVar.zzf);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                } while (!atomicBoolean.get());
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public final void zzb(zzgdy zzgdyVar, zzdsj zzdsjVar) {
        if (this.zzc.getAndSet(true)) {
            return;
        }
        this.zza = zzgdyVar;
        this.zzb = zzdsjVar;
        this.zze = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznT)).longValue();
        this.zzf = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznU)).longValue();
    }

    public final void zzc() {
        zzgdy zzgdyVar;
        if (!this.zzc.get() || this.zze < 0 || this.zzf < 0 || !this.zzd.compareAndSet(false, true) || (zzgdyVar = this.zza) == null) {
            return;
        }
        zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbzy
            @Override // java.lang.Runnable
            public final void run() {
                zzbzz.zza(zzbzz.this);
            }
        });
    }
}
