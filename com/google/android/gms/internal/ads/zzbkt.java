package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbkt implements zzbku {
    final /* synthetic */ zzcak zza;

    zzbkt(zzbkv zzbkvVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzbkvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zza(String str) {
        this.zza.zzd(new zzbol(str));
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zzb(JSONObject jSONObject) {
        this.zza.zzc(jSONObject);
    }
}
