package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzenj implements zzeuc {
    private final zzgdy zza;
    private final zzfcw zzb;
    private final zzbzw zzc;

    public zzenj(zzgdy zzgdyVar, zzfcw zzfcwVar, zzbzw zzbzwVar) {
        this.zza = zzgdyVar;
        this.zzb = zzfcwVar;
        this.zzc = zzbzwVar;
    }

    public static /* synthetic */ zzenk zzc(zzenj zzenjVar) {
        return new zzenk(zzenjVar.zzb.zzj, zzenjVar.zzc.zzm());
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 9;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeni
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzenj.zzc(zzenj.this);
            }
        });
    }
}
