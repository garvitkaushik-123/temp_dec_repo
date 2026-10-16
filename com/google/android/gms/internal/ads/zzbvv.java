package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbvv implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbvx zzb;

    zzbvv(zzbvx zzbvxVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzbvxVar);
        this.zzb = zzbvxVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        WeakHashMap weakHashMap;
        zzbvu zza;
        WeakHashMap weakHashMap2;
        zzbvx zzbvxVar = this.zzb;
        weakHashMap = zzbvxVar.zza;
        Context context = this.zza;
        zzbvw zzbvwVar = (zzbvw) weakHashMap.get(context);
        if (zzbvwVar != null) {
            if (zzbvwVar.zza + ((Long) zzbet.zzd.zze()).longValue() >= com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis()) {
                zza = new zzbvt(context, zzbvwVar.zzb).zza();
                weakHashMap2 = zzbvxVar.zza;
                weakHashMap2.put(context, new zzbvw(zzbvxVar, zza));
                return zza;
            }
        }
        zza = new zzbvt(context).zza();
        weakHashMap2 = zzbvxVar.zza;
        weakHashMap2.put(context, new zzbvw(zzbvxVar, zza));
        return zza;
    }
}
