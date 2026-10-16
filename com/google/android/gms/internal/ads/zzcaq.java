package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcaq implements zzgdj {
    final /* synthetic */ zzcao zza;
    final /* synthetic */ zzcam zzb;

    zzcaq(zzcar zzcarVar, zzcao zzcaoVar, zzcam zzcamVar) {
        this.zza = zzcaoVar;
        this.zzb = zzcamVar;
        Objects.requireNonNull(zzcarVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }
}
