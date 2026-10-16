package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzbjd implements zzbkf {
    public final /* synthetic */ zzded zza;
    public final /* synthetic */ zzcmq zzb;

    public /* synthetic */ zzbjd(zzded zzdedVar, zzcmq zzcmqVar) {
        this.zza = zzdedVar;
        this.zzb = zzcmqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        zzbke.zzc(map, this.zza);
        final String str = (String) map.get("u");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from click GMSG.");
            return;
        }
        final zzcmq zzcmqVar = this.zzb;
        zzgde zzw = zzgde.zzw(zzbke.zza(zzcfgVar, str));
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzbjg
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj2) {
                zzcmq zzcmqVar2;
                String str2 = (String) obj2;
                zzbkf zzbkfVar = zzbke.zza;
                return (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkx)).booleanValue() && (zzcmqVar2 = zzcmq.this) != null && zzcmq.zzj(str)) ? zzcmqVar2.zze(str2, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgdn.zzh(str2);
            }
        };
        zzgdy zzgdyVar = zzcaf.zza;
        zzgdn.zzr((zzgde) zzgdn.zzn(zzw, zzgcuVar, zzgdyVar), new zzbjt(zzcfgVar), zzgdyVar);
    }
}
