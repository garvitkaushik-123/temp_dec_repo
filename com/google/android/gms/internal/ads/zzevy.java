package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzevy implements zzeuc {
    public zzevy(zzbzg zzbzgVar, zzgdy zzgdyVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        final ListenableFuture zzh = zzgdn.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgd)).booleanValue()) {
            zzh = zzgdn.zzh(null);
        }
        final ListenableFuture zzh2 = zzgdn.zzh(null);
        return zzgdn.zzc(zzh, zzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzevx
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzevz((String) ListenableFuture.this.get(), (String) zzh2.get());
            }
        }, zzcaf.zza);
    }
}
