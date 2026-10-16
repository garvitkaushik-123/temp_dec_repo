package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbjk implements zzbkf {
    zzbjk() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcfg zzcfgVar = (zzcfg) obj;
        zzbgd zzK = zzcfgVar.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzcfgVar.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcfgVar.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
