package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerg implements zzeuc {
    private final Context zza;
    private final zzgdy zzb;

    zzerg(zzgdy zzgdyVar, Context context) {
        this.zzb = zzgdyVar;
        this.zza = context;
    }

    public static /* synthetic */ zzerh zzc(zzerg zzergVar) {
        com.google.android.gms.ads.internal.zzv.zzr();
        return new zzerh(com.google.android.gms.ads.internal.util.zzs.zzt(zzergVar.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 57;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerg.zzc(zzerg.this);
            }
        });
    }
}
