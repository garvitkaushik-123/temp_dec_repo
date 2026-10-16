package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaci {
    private final Handler zza;
    private final zzacj zzb;

    public zzaci(Handler handler, zzacj zzacjVar) {
        if (zzacjVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzacjVar;
    }

    public static /* synthetic */ void zza(zzaci zzaciVar, Exception exc) {
        String str = zzex.zza;
        zzaciVar.zzb.zzp(exc);
    }

    public static /* synthetic */ void zzb(zzaci zzaciVar, String str) {
        String str2 = zzex.zza;
        zzaciVar.zzb.zzr(str);
    }

    public static /* synthetic */ void zzc(zzaci zzaciVar, long j, int i) {
        String str = zzex.zza;
        zzaciVar.zzb.zzu(j, i);
    }

    public static /* synthetic */ void zzd(zzaci zzaciVar, int i, long j) {
        String str = zzex.zza;
        zzaciVar.zzb.zzm(i, j);
    }

    public static /* synthetic */ void zze(zzaci zzaciVar, zzcd zzcdVar) {
        String str = zzex.zza;
        zzaciVar.zzb.zzw(zzcdVar);
    }

    public static /* synthetic */ void zzf(zzaci zzaciVar, zzid zzidVar) {
        zzidVar.zza();
        String str = zzex.zza;
        zzaciVar.zzb.zzs(zzidVar);
    }

    public static /* synthetic */ void zzg(zzaci zzaciVar, zzz zzzVar, zzie zzieVar) {
        String str = zzex.zza;
        zzaciVar.zzb.zzv(zzzVar, zzieVar);
    }

    public static /* synthetic */ void zzh(zzaci zzaciVar, Object obj, long j) {
        String str = zzex.zza;
        zzaciVar.zzb.zzn(obj, j);
    }

    public static /* synthetic */ void zzi(zzaci zzaciVar, zzid zzidVar) {
        String str = zzex.zza;
        zzaciVar.zzb.zzt(zzidVar);
    }

    public static /* synthetic */ void zzj(zzaci zzaciVar, String str, long j, long j2) {
        String str2 = zzex.zza;
        zzaciVar.zzb.zzq(str, j, j2);
    }

    public final void zzk(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaby
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzj(zzaci.this, str, j, j2);
                }
            });
        }
    }

    public final void zzl(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzach
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzb(zzaci.this, str);
                }
            });
        }
    }

    public final void zzm(final zzid zzidVar) {
        zzidVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacg
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzf(zzaci.this, zzidVar);
                }
            });
        }
    }

    public final void zzn(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaca
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzd(zzaci.this, i, j);
                }
            });
        }
    }

    public final void zzo(final zzid zzidVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzace
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzi(zzaci.this, zzidVar);
                }
            });
        }
    }

    public final void zzp(final zzz zzzVar, final zzie zzieVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacf
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzg(zzaci.this, zzzVar, zzieVar);
                }
            });
        }
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacb
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzh(zzaci.this, obj, elapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacc
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zzc(zzaci.this, j, i);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzacd
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zza(zzaci.this, exc);
                }
            });
        }
    }

    public final void zzt(final zzcd zzcdVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabz
                @Override // java.lang.Runnable
                public final void run() {
                    zzaci.zze(zzaci.this, zzcdVar);
                }
            });
        }
    }
}
