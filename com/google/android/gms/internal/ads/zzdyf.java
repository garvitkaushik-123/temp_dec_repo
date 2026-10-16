package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdyf implements zzgdj {
    final /* synthetic */ Context zza;

    zzdyf(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) zzbew.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzba)) {
            zzbco.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbew.zzj.zze()).booleanValue()) {
            zzbco.zze(this.zza);
        }
    }
}
