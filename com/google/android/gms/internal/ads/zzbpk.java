package com.google.android.gms.internal.ads;

import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbpk {
    public final List zza;

    public zzbpk(JSONObject jSONObject) throws JSONException {
        if (com.google.android.gms.ads.internal.util.zze.zzm(2)) {
            com.google.android.gms.ads.internal.util.zze.zza("Mediation Response JSON: ".concat(String.valueOf(jSONObject.toString(2))));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzbpj zzbpjVar = new zzbpj(jSONArray.getJSONObject(i2));
                "banner".equalsIgnoreCase(zzbpjVar.zzc);
                arrayList.add(zzbpjVar);
                if (i < 0) {
                    Iterator it = zzbpjVar.zza.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((String) it.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                i = i2;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
        jSONArray.length();
        this.zza = Collections.unmodifiableList(arrayList);
        jSONObject.optString("qdata");
        jSONObject.optInt("fs_model_type", -1);
        jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            optJSONObject.optLong("ad_network_timeout_millis", -1L);
            com.google.android.gms.ads.internal.zzv.zzh();
            zzbpl.zza(optJSONObject, "click_urls");
            com.google.android.gms.ads.internal.zzv.zzh();
            zzbpl.zza(optJSONObject, "imp_urls");
            com.google.android.gms.ads.internal.zzv.zzh();
            zzbpl.zza(optJSONObject, "downloaded_imp_urls");
            com.google.android.gms.ads.internal.zzv.zzh();
            zzbpl.zza(optJSONObject, "nofill_urls");
            com.google.android.gms.ads.internal.zzv.zzh();
            zzbpl.zza(optJSONObject, "remote_ping_urls");
            optJSONObject.optBoolean("render_in_browser", false);
            optJSONObject.optLong(ToolBar.REFRESH, -1L);
            zzbwo.zza(optJSONObject.optJSONArray("rewards"));
            optJSONObject.optBoolean("use_displayed_impression", false);
            optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            optJSONObject.optBoolean("allow_custom_click_gesture", false);
        }
    }
}
