package com.google.android.gms.internal.ads;

import android.os.Bundle;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzepb implements zzeub {

    @Nullable
    private final JSONObject zza;

    @Nullable
    private final JSONObject zzb;

    public zzepb(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        this.zza = jSONObject;
        this.zzb = jSONObject2;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONObject jSONObject = this.zzb;
        zzcva zzcvaVar = (zzcva) obj;
        if (jSONObject != null) {
            zzcvaVar.zzb.putString("fwd_common_cld", jSONObject.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        JSONObject jSONObject = this.zza;
        if (jSONObject != null) {
            bundle.putString("fwd_cld", jSONObject.toString());
        }
        JSONObject jSONObject2 = this.zzb;
        if (jSONObject2 != null) {
            bundle.putString("fwd_common_cld", jSONObject2.toString());
        }
    }
}
