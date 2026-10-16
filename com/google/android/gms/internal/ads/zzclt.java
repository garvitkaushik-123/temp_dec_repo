package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzclt implements zzclg {
    zzclt() {
    }

    @Override // com.google.android.gms.internal.ads.zzclg
    public final void zza(Map map) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkQ)).booleanValue() || map.isEmpty()) {
            return;
        }
        String str = (String) map.get("is_topics_ad_personalization_allowed");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzE(Boolean.parseBoolean(str));
    }
}
