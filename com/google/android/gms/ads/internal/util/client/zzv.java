package com.google.android.gms.ads.internal.util.client;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzv {
    private final zzx zza;

    public zzv() {
        this.zza = new zzn(1, 0, 1.0d, false);
    }

    private zzv(zzx zzxVar) {
        this.zza = zzxVar;
    }

    public static zzv zza(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("ping_strategy");
        return new zzv(optJSONObject == null ? new zzn(1, 0, 1.0d, false) : new zzn(optJSONObject.optInt("max_attempts", 1), optJSONObject.optInt("initial_backoff_ms", 0), optJSONObject.optDouble("backoff_multiplier", 1.0d), optJSONObject.optBoolean("buffer_after_max_attempts", false)));
    }

    public final zzx zzb() {
        return this.zza;
    }
}
