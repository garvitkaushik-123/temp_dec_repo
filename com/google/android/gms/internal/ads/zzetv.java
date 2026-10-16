package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzetv implements zzeuc {
    private final boolean zza;

    zzetv(zzezv zzezvVar) {
        this.zza = zzezvVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 36;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzh(new zzett(this.zza, null));
    }
}
