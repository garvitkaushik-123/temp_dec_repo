package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbkd implements zzbkf {
    zzbkd() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (map.containsKey("start")) {
            zzcfgVar.zzax(true);
        }
        if (map.containsKey("stop")) {
            zzcfgVar.zzax(false);
        }
    }
}
