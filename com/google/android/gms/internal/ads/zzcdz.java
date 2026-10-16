package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.dash.DashMediaSource;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdz implements zzkx {
    private final zzzm zza = new zzzm(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US;
    private int zzf;
    private boolean zzg;

    zzcdz() {
    }

    final void zza(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final long zzb(zzph zzphVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zzc(zzph zzphVar) {
        zza(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zzd(zzph zzphVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zze(zzph zzphVar) {
        zza(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final void zzf(zzkw zzkwVar, zzxk zzxkVar, zzyw[] zzywVarArr) {
        int i;
        this.zzf = 0;
        for (zzyw zzywVar : zzywVarArr) {
            if (zzywVar != null) {
                int i2 = this.zzf;
                int i3 = zzywVar.zzc().zzc;
                if (i3 == 0) {
                    i = 144310272;
                } else if (i3 == 1) {
                    i = 13107200;
                } else if (i3 != 2) {
                    i = 131072;
                    if (i3 != 3 && i3 != 5 && i3 != 6) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i = 131072000;
                }
                this.zzf = i2 + i;
            }
        }
        this.zza.zzf(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzg(zzph zzphVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzh(zzkw zzkwVar) {
        long j = zzkwVar.zzb;
        boolean z = true;
        char c = j > this.zzc ? (char) 0 : j < this.zzb ? (char) 2 : (char) 1;
        int zza = this.zza.zza();
        int i = this.zzf;
        if (c != 2 && (c != 1 || !this.zzg || zza >= i)) {
            z = false;
        }
        this.zzg = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final /* synthetic */ boolean zzi(zzbl zzblVar, zzvh zzvhVar, long j) {
        zzea.zzf("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final boolean zzj(zzkw zzkwVar) {
        long j = zzkwVar.zzd ? this.zze : this.zzd;
        return j <= 0 || zzkwVar.zzb >= j;
    }

    @Override // com.google.android.gms.internal.ads.zzkx
    public final zzzm zzk() {
        return this.zza;
    }

    public final synchronized void zzl(int i) {
        this.zzd = i * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zze = i * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzc = i * 1000;
    }

    public final synchronized void zzo(int i) {
        this.zzb = i * 1000;
    }
}
