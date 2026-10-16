package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzagf {
    protected final zzafb zza;

    protected zzagf(zzafb zzafbVar) {
        this.zza = zzafbVar;
    }

    protected abstract boolean zza(zzen zzenVar) throws zzaz;

    protected abstract boolean zzb(zzen zzenVar, long j) throws zzaz;

    public final boolean zzf(zzen zzenVar, long j) throws zzaz {
        return zza(zzenVar) && zzb(zzenVar, j);
    }
}
