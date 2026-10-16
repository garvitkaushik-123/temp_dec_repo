package com.google.android.gms.ads.internal.util.client;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public abstract class zzw {
    public static zzw zzd(JSONObject jSONObject) {
        return new zzm(jSONObject.optInt("impression_prerequisite", 0), jSONObject.optInt("click_prerequisite", 0), jSONObject.optBoolean("notification_flow_enabled", false));
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract boolean zzc();
}
