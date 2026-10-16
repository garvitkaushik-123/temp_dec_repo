package com.google.android.gms.internal.ads;

import com.ironsource.C3057e4;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdix extends zzdiy {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdix(zzfca zzfcaVar, JSONObject jSONObject) {
        super(zzfcaVar);
        this.zzb = com.google.android.gms.ads.internal.util.zzbs.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzc = com.google.android.gms.ads.internal.util.zzbs.zzl(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = com.google.android.gms.ads.internal.util.zzbs.zzl(false, jSONObject, C3057e4.c, "allow_pub_rendering");
        this.zze = com.google.android.gms.ads.internal.util.zzbs.zzl(false, jSONObject, "enable_omid");
        this.zzg = com.google.android.gms.ads.internal.util.zzbs.zzb("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null;
        this.zzh = jSONObject.optJSONObject("omid_settings");
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final zzfcz zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzfcz(jSONObject) : this.zza.zzV;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final String zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdiy
    public final boolean zzg() {
        return this.zzf;
    }
}
