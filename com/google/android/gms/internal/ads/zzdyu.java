package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdyu implements zzdyw {
    private final Map zza;
    private final zzgdy zzb;
    private final zzcyy zzc;

    public zzdyu(Map map, zzgdy zzgdyVar, zzcyy zzcyyVar) {
        this.zza = map;
        this.zzb = zzgdyVar;
        this.zzc = zzcyyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyw
    public final ListenableFuture zzc(final zzbvq zzbvqVar) {
        this.zzc.zzdn(zzbvqVar);
        ListenableFuture zzg = zzgdn.zzg(new zzdwm(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziD)).split(",")) {
            final zzhhg zzhhgVar = (zzhhg) this.zza.get(str.trim());
            if (zzhhgVar != null) {
                zzg = zzgdn.zzf(zzg, zzdwm.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdys
                    @Override // com.google.android.gms.internal.ads.zzgcu
                    public final ListenableFuture zza(Object obj) {
                        return ((zzdyw) zzhhg.this.zzb()).zzc(zzbvqVar);
                    }
                }, this.zzb);
            }
        }
        zzgdn.zzr(zzg, new zzdyt(this), zzcaf.zzg);
        return zzg;
    }
}
