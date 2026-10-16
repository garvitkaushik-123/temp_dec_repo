package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzezh implements zzezr {
    private final zzezr zza;
    private zzcve zzb;

    public zzezh(zzezr zzezrVar) {
        this.zza = zzezrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcve zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzezr
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzezs zzezsVar, zzezq zzezqVar, Object obj) {
        return zzb(zzezsVar, zzezqVar, null);
    }

    public final synchronized ListenableFuture zzb(zzezs zzezsVar, zzezq zzezqVar, zzcve zzcveVar) {
        zzbvq zzbvqVar;
        this.zzb = zzcveVar;
        if (zzcveVar == null || (zzbvqVar = zzezsVar.zza) == null) {
            zzcve zzcveVar2 = zzcveVar;
            return ((zzezg) this.zza).zzb(zzezsVar, zzezqVar, zzcveVar);
        }
        zzcse zzb = zzcveVar.zzb();
        return zzb.zzh(zzb.zzj(zzgdn.zzh(zzbvqVar)));
    }
}
