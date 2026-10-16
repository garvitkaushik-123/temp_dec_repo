package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdoy implements com.google.android.gms.ads.internal.zzn {
    final /* synthetic */ zzdpj zza;

    zzdoy(zzdpj zzdpjVar) {
        Objects.requireNonNull(zzdpjVar);
        this.zza = zzdpjVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdg() {
        zzcyv zzcyvVar;
        zzcyvVar = this.zza.zzg;
        zzcyvVar.zzb();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdh() {
        zzcyv zzcyvVar;
        zzcyvVar = this.zza.zzg;
        zzcyvVar.zzc();
    }
}
