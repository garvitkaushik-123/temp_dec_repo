package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzgdh extends zzgdi {
    private final ListenableFuture zza;

    protected zzgdh(ListenableFuture listenableFuture) {
        this.zza = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgdg, com.google.android.gms.internal.ads.zzfyh
    protected final /* synthetic */ Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdi, com.google.android.gms.internal.ads.zzgdg
    protected final /* synthetic */ Future zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdi
    protected final ListenableFuture zzc() {
        return this.zza;
    }
}
