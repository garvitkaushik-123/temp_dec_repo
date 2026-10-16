package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdi {
    private final zzdt zza;
    private final zzdt zzb;
    private Object zzc;
    private Object zzd;
    private int zze;
    private final zzjk zzf;

    public zzdi(Object obj, Looper looper, Looper looper2, zzdj zzdjVar, zzjk zzjkVar) {
        this.zza = zzdjVar.zzd(looper, null);
        this.zzb = zzdjVar.zzd(looper2, null);
        this.zzc = obj;
        this.zzd = obj;
        this.zzf = zzjkVar;
    }

    public static /* synthetic */ void zza(zzdi zzdiVar, Object obj) {
        if (zzdiVar.zze == 0) {
            zzdiVar.zzg(obj);
        }
    }

    public static /* synthetic */ void zzb(zzdi zzdiVar, Object obj) {
        int i = zzdiVar.zze - 1;
        zzdiVar.zze = i;
        if (i == 0) {
            zzdiVar.zzg(obj);
        }
    }

    public static /* synthetic */ void zzc(final zzdi zzdiVar, zzfve zzfveVar) {
        final Object apply = zzfveVar.apply(zzdiVar.zzd);
        zzdiVar.zzd = apply;
        zzdiVar.zzb.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdh
            @Override // java.lang.Runnable
            public final void run() {
                zzdi.zzb(zzdi.this, apply);
            }
        });
    }

    private final void zzg(Object obj) {
        Object obj2 = this.zzc;
        this.zzc = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.zzf.zza(obj2, obj);
    }

    public final void zzd(Runnable runnable) {
        this.zza.zzi(runnable);
    }

    public final void zze(final Object obj) {
        this.zzd = obj;
        this.zzb.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdg
            @Override // java.lang.Runnable
            public final void run() {
                zzdi.zza(zzdi.this, obj);
            }
        });
    }

    public final void zzf(zzfve zzfveVar, final zzfve zzfveVar2) {
        zzdd.zzf(Looper.myLooper() == this.zzb.zza());
        this.zze++;
        this.zza.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdf
            @Override // java.lang.Runnable
            public final void run() {
                zzdi.zzc(zzdi.this, zzfveVar2);
            }
        });
        zzg(zzfveVar.apply(this.zzc));
    }
}
