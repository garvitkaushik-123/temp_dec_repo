package com.google.android.gms.internal.ads;

import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdzz implements zzbop {
    zzdzz() {
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeaa zzeaaVar = (zzeaa) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjI)).booleanValue()) {
            zzbvs zzbvsVar = zzeaaVar.zzd;
            jSONObject2.put("ad_request_url", zzbvsVar.zzg());
            jSONObject2.put("ad_request_post_body", zzbvsVar.zzf());
        }
        zzbvs zzbvsVar2 = zzeaaVar.zzd;
        jSONObject2.put("base_url", zzbvsVar2.zzd());
        jSONObject2.put("signals", zzeaaVar.zzc);
        zzeae zzeaeVar = zzeaaVar.zzb;
        jSONObject3.put("body", zzeaeVar.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzbb.zzb().zzo(zzeaeVar.zzb));
        jSONObject3.put("response_code", zzeaeVar.zza);
        jSONObject3.put("latency", zzeaeVar.zzd);
        jSONObject.put(AdActivity.REQUEST_KEY_EXTRA, jSONObject2);
        jSONObject.put(C3337ue.n, jSONObject3);
        jSONObject.put("flags", zzbvsVar2.zzi());
        return jSONObject;
    }
}
