package com.google.android.gms.internal.ads;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbkb implements zzbkf {
    zzbkb() {
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        String str = (String) map.get("action");
        if (CampaignEx.JSON_NATIVE_VIDEO_PAUSE.equals(str)) {
            zzcfgVar.zzdg();
        } else if (CampaignEx.JSON_NATIVE_VIDEO_RESUME.equals(str)) {
            zzcfgVar.zzdh();
        }
    }
}
