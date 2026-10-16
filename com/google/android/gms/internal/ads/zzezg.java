package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzezg implements zzezr {
    private zzcve zza;

    @Override // com.google.android.gms.internal.ads.zzezr
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcve zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzb(zzezsVar, zzezqVar, null);
    }

    public final synchronized ListenableFuture zzb(zzezs zzezsVar, zzezq zzezqVar, zzcve zzcveVar) {
        zzcse zzb;
        if (zzcveVar != null) {
            this.zza = zzcveVar;
        } else {
            this.zza = (zzcve) zzezqVar.zza(zzezsVar.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzh(zzb.zzi());
    }
}
