package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzayk implements Callable {
    protected final zzawx zza;
    protected final String zzb;
    protected final String zzc;
    protected final zzast zzd;
    protected Method zze;
    protected final int zzf;
    protected final int zzg;

    public zzayk(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        getClass().getSimpleName();
        this.zza = zzawxVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzastVar;
        this.zzf = i;
        this.zzg = i2;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        int i;
        try {
            long nanoTime = System.nanoTime();
            zzawx zzawxVar = this.zza;
            Method zzi = zzawxVar.zzi(this.zzb, this.zzc);
            this.zze = zzi;
            if (zzi == null) {
                return null;
            }
            zza();
            zzavo zzd = zzawxVar.zzd();
            if (zzd == null || (i = this.zzf) == Integer.MIN_VALUE) {
                return null;
            }
            zzd.zzc(this.zzg, i, (System.nanoTime() - nanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected abstract void zza() throws IllegalAccessException, InvocationTargetException;
}
