package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfkn implements zzazw {
    final /* synthetic */ zzfkp zza;

    zzfkn(zzfkp zzfkpVar) {
        Objects.requireNonNull(zzfkpVar);
        this.zza = zzfkpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzx)).booleanValue()) {
            this.zza.zzq(z);
        }
    }
}
