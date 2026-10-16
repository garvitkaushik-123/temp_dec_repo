package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbod implements zzcao {
    final /* synthetic */ zzboc zza;

    zzbod(zzboh zzbohVar, zzboc zzbocVar) {
        this.zza = zzbocVar;
        Objects.requireNonNull(zzbohVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcao
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("Getting a new session for JS Engine.");
        this.zza.zzi(((zzbnd) obj).zzj());
    }
}
