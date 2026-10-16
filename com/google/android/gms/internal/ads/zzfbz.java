package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfbz {
    private final Clock zza;
    private final zzdsj zzb;
    private final Object zzc = new Object();
    private volatile int zze = 1;
    private volatile long zzd = 0;

    public zzfbz(Clock clock, zzdsj zzdsjVar) {
        this.zza = clock;
        this.zzb = zzdsjVar;
    }

    private final void zze() {
        long currentTimeMillis = this.zza.currentTimeMillis();
        synchronized (this.zzc) {
            if (this.zze == 3) {
                if (this.zzd + ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgj)).longValue() <= currentTimeMillis) {
                    this.zze = 1;
                }
            }
        }
    }

    private final void zzf(int i, int i2) {
        zze();
        Object obj = this.zzc;
        long currentTimeMillis = this.zza.currentTimeMillis();
        synchronized (obj) {
            if (this.zze != i) {
                return;
            }
            this.zze = i2;
            if (this.zze == 3) {
                this.zzd = currentTimeMillis;
            }
        }
    }

    public final void zza() {
        zzf(2, 3);
    }

    public final void zzb(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznv)).booleanValue()) {
            zzdsi zza = this.zzb.zza();
            zza.zzb("action", "mbs_state");
            zza.zzb("mbs_state", true != z ? "0" : "1");
            zza.zzj();
        }
        if (z) {
            zzf(1, 2);
        } else {
            zzf(2, 1);
        }
    }

    public final boolean zzc() {
        boolean z;
        synchronized (this.zzc) {
            zze();
            z = this.zze == 3;
        }
        return z;
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzc) {
            zze();
            z = this.zze == 2;
        }
        return z;
    }
}
