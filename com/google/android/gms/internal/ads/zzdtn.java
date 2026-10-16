package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdtn {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzdtn(String str, zzdto zzdtoVar) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdtn zzdtnVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzku);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdtnVar.zza);
            jSONObject.put("eventCategory", zzdtnVar.zzb);
            jSONObject.putOpt("event", zzdtnVar.zzc);
            jSONObject.putOpt(IronSourceConstants.EVENTS_ERROR_CODE, zzdtnVar.zzd);
            jSONObject.putOpt("rewardType", zzdtnVar.zze);
            jSONObject.putOpt(IronSourceConstants.EVENTS_REWARD_AMOUNT, zzdtnVar.zzf);
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
