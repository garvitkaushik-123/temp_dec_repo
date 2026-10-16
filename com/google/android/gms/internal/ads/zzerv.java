package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerv implements zzeuc {
    private final zzgdy zza;
    private final zzdvi zzb;

    zzerv(zzgdy zzgdyVar, zzdvi zzdviVar) {
        this.zza = zzgdyVar;
        this.zzb = zzdviVar;
    }

    public static /* synthetic */ zzerw zzc(zzerv zzervVar) {
        zzdvi zzdviVar = zzervVar.zzb;
        return new zzerw(zzdviVar.zzc(), zzdviVar.zzr(), com.google.android.gms.ads.internal.zzv.zzu().zzl(), zzdviVar.zzp(), zzdviVar.zzs());
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeru
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerv.zzc(zzerv.this);
            }
        });
    }
}
