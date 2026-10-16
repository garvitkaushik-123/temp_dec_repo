package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdul implements zzgdj {
    final /* synthetic */ zzdun zza;

    zzdul(zzdun zzdunVar) {
        Objects.requireNonNull(zzdunVar);
        this.zza = zzdunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        long j;
        zzcak zzcakVar;
        synchronized (this) {
            zzdun zzdunVar = this.zza;
            zzdunVar.zzc = true;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
            j = zzdunVar.zzd;
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (elapsedRealtime - j));
            zzcakVar = zzdunVar.zze;
            zzcakVar.zzd(new Exception());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        long j;
        Executor executor;
        final String str = (String) obj;
        synchronized (this) {
            zzdun zzdunVar = this.zza;
            zzdunVar.zzc = true;
            long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
            j = zzdunVar.zzd;
            zzdunVar.zzv("com.google.android.gms.ads.MobileAds", true, "", (int) (elapsedRealtime - j));
            executor = zzdunVar.zzi;
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduk
                @Override // java.lang.Runnable
                public final void run() {
                    zzdun.zzo(zzdul.this.zza, str);
                }
            });
        }
    }
}
