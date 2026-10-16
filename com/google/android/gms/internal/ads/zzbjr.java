package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbjr implements zzbkf {
    zzbjr() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        try {
            zzfse.zzj(zzcfgVar.getContext()).zzk();
            zzfsf.zzi(zzcfgVar.getContext()).zzj();
            zzfsg.zza(zzcfgVar.getContext()).zzb(null);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
