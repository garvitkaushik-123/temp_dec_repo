package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzetz implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;

    zzetz(zzgdy zzgdyVar, Context context) {
        this.zza = zzgdyVar;
        this.zzb = context;
    }

    public static /* synthetic */ zzety zzc(zzetz zzetzVar) {
        return new zzety(com.google.android.gms.ads.internal.util.zzad.zzb(zzetzVar.zzb, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgr)));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzetx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetz.zzc(zzetz.this);
            }
        });
    }
}
