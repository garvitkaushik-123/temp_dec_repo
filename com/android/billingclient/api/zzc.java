package com.android.billingclient.api;

import com.ironsource.C3040d4;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
public final class zzc {
    private final String zza;
    private final String zzb;
    private final String zzc;

    /* synthetic */ zzc(JSONObject jSONObject, zzd zzdVar) {
        this.zza = jSONObject.optString(InAppPurchaseMetaData.KEY_PRODUCT_ID);
        this.zzb = jSONObject.optString(C3040d4.h.m);
        String optString = jSONObject.optString("offerToken");
        this.zzc = true == optString.isEmpty() ? null : optString;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return this.zza.equals(zzcVar.zza) && this.zzb.equals(zzcVar.zzb) && Objects.equals(this.zzc, zzcVar.zzc);
    }

    public final int hashCode() {
        return Objects.hash(this.zza, this.zzb, this.zzc);
    }

    public final String toString() {
        return String.format("{id: %s, type: %s, offer token: %s}", this.zza, this.zzb, this.zzc);
    }
}
