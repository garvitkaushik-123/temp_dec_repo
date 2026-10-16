package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbjl implements zzbkf {
    zzbjl() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcfg zzcfgVar = (zzcfg) obj;
        zzbgd zzK = zzcfgVar.zzK();
        if (zzK == null || (zzb = zzK.zzb()) == null) {
            zzcfgVar.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcfgVar.zze("nativeClickMetaReady", zzb);
        }
    }
}
