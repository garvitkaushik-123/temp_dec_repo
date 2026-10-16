package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdwu {
    private final zzgdy zza;
    private final zzgdy zzb;
    private final zzdye zzc;
    private final zzhgl zzd;

    public zzdwu(zzgdy zzgdyVar, zzgdy zzgdyVar2, zzdye zzdyeVar, zzhgl zzhglVar) {
        this.zza = zzgdyVar;
        this.zzb = zzgdyVar2;
        this.zzc = zzdyeVar;
        this.zzd = zzhglVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzdyy zza(zzdwu zzdwuVar, zzbvq zzbvqVar) {
        return (zzdyy) zzdwuVar.zzc.zza(zzbvqVar).get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfS)).intValue(), TimeUnit.SECONDS);
    }

    public static /* synthetic */ ListenableFuture zzb(zzdwu zzdwuVar, final zzbvq zzbvqVar, int i, zzdyx zzdyxVar) {
        Bundle bundle;
        if (zzbvqVar != null && (bundle = zzbvqVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgdn.zzn(((zzeab) zzdwuVar.zzd.zzb()).zzc(zzbvqVar, i), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdwq
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzgdn.zzh(new zzdyy((InputStream) obj, zzbvq.this));
            }
        }, zzdwuVar.zzb);
    }

    public final ListenableFuture zzc(final zzbvq zzbvqVar) {
        String str = zzbvqVar.zzd;
        com.google.android.gms.ads.internal.zzv.zzr();
        ListenableFuture zzg = com.google.android.gms.ads.internal.util.zzs.zzD(str) ? zzgdn.zzg(new zzdyx(1)) : zzgdn.zzf(this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdwu.zza(zzdwu.this, zzbvqVar);
            }
        }), ExecutionException.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdws
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                ExecutionException executionException = (ExecutionException) obj;
                Throwable cause = executionException.getCause();
                Throwable th = executionException;
                if (cause != null) {
                    th = executionException.getCause();
                }
                return zzgdn.zzg(th);
            }
        }, this.zzb);
        final int callingUid = Binder.getCallingUid();
        return zzgdn.zzf(zzg, zzdyx.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdwt
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdwu.zzb(zzdwu.this, zzbvqVar, callingUid, (zzdyx) obj);
            }
        }, this.zzb);
    }
}
