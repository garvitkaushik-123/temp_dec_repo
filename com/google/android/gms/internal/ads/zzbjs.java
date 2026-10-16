package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbjs implements zzbkf {
    zzbjs() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        try {
            String str = (String) map.get("enabled");
            zzbkf zzbkfVar = zzbke.zza;
            if (!zzfuv.zzc("true", str) && !zzfuv.zzc("false", str)) {
                return;
            }
            zzfsb.zza(zzcfgVar.getContext()).zzb(Boolean.parseBoolean(str));
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
