package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzbey;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public class CsiUrlBuilder {
    private final String zza = (String) zzbey.zza.zze();

    public String generateUrl(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zza).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return buildUpon.build().toString();
    }
}
