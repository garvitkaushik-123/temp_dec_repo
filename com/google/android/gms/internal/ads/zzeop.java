package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeop implements zzeuc {
    private final zzeyy zza;

    zzeop(zzeyy zzeyyVar) {
        this.zza = zzeyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzeyy zzeyyVar = this.zza;
        if (zzeyyVar == null) {
            return zzgdn.zzh(new zzeoo(null));
        }
        String zza = zzeyyVar.zza();
        return Strings.isEmptyOrWhitespace(zza) ? zzgdn.zzh(new zzeoo(null)) : zzgdn.zzh(new zzeoo(zza));
    }
}
