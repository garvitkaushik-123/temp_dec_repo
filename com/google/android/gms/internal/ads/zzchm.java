package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzchm implements zzhgr {
    private final zzchh zza;

    private zzchm(zzchh zzchhVar) {
        this.zza = zzchhVar;
    }

    public static zzchm zza(zzchh zzchhVar) {
        return new zzchm(zzchhVar);
    }

    public static WeakReference zzd(zzchh zzchhVar) {
        WeakReference zzg = zzchhVar.zzg();
        zzhgz.zzb(zzg);
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final WeakReference zzc() {
        return zzd(this.zza);
    }
}
