package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzevz implements zzeub {
    private final String zza;
    private final String zzb;

    public zzevz(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            JSONObject zzg = com.google.android.gms.ads.internal.util.zzbs.zzg((JSONObject) obj, "pii");
            zzg.put("doritos", this.zza);
            zzg.put("doritos_v2", this.zzb);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed putting doritos string.");
        }
    }
}
