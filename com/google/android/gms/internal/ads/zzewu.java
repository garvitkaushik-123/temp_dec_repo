package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzewu implements zzeub {
    private final String zza;

    public zzewu(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        try {
            String str = this.zza;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.google.android.gms.ads.internal.util.zzbs.zzg(jSONObject, "pii").put("adsid", str);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed putting trustless token.", e);
        }
    }
}
