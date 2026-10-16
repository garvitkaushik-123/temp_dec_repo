package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzccd implements Runnable {
    private final zzcbp zza;
    private boolean zzb = false;

    zzccd(zzcbp zzcbpVar) {
        this.zza = zzcbpVar;
    }

    private final void zzc() {
        zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzfrwVar.removeCallbacks(this);
        zzfrwVar.postDelayed(this, 250L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb) {
            return;
        }
        this.zza.zzt();
        zzc();
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
