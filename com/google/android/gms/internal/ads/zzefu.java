package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzefu implements zzedo {
    private final zzdpz zza;

    public zzefu(zzdpz zzdpzVar) {
        this.zza = zzdpzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzedo
    public final zzedp zza(String str, JSONObject jSONObject) throws zzfdd {
        return new zzedp(this.zza.zzc(str, jSONObject), new zzefd(), str);
    }
}
