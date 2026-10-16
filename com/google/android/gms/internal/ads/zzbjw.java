package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbjw implements zzbkf {
    zzbjw() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (zzcfgVar.zzJ() != null) {
            zzcfgVar.zzJ().zza();
        }
        com.google.android.gms.ads.internal.overlay.zzm zzL = zzcfgVar.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzM = zzcfgVar.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
