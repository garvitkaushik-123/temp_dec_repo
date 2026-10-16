package com.bytedance.sdk.openadsdk.component.aGH;

import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.Dfc.DbA;
import com.bytedance.sdk.openadsdk.Dfc.Os;
import com.bytedance.sdk.openadsdk.Dfc.eli.aGH;
import com.bytedance.sdk.openadsdk.core.model.GB;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.ironsource.C3207n2;
import io.ktor.http.ContentDisposition;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public static void eli(final int i, final int i2) {
        Os.eli("openad_load_ad_timeout", false, new DbA() { // from class: com.bytedance.sdk.openadsdk.component.aGH.eli.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout_type", i);
                jSONObject.put("user_timeout_time", i2);
                return aGH.DbA().eli("openad_load_ad_timeout").DbA(jSONObject.toString());
            }
        });
    }

    public static void eli(ev evVar, int i, int i2, float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            eli(jSONObject, evVar);
            jSONObject.put("openad_creative_type", ev.ui(evVar) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("total_time", f);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(jSONObject, i2, i);
        } catch (JSONException e) {
            Xb.eli("TTAppOpenAdReport", "reportSkip json error", e);
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "skip", i, jSONObject);
    }

    public static void eli(ev evVar, long j, float f, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            eli(jSONObject, evVar);
            jSONObject.put("openad_creative_type", ev.ui(evVar) ? "video_normal_ad" : "image_normal_ad");
            if (z) {
                double d = f;
                jSONObject.put("video_duration", d);
                jSONObject.put("video_percent", (int) (((j * 1.0d) / 10.0d) / d));
            } else {
                jSONObject.put("image_duration", f);
            }
        } catch (JSONException e) {
            Xb.eli("TTAppOpenAdReport", "reportDestroy json error", e);
        }
        com.bytedance.sdk.openadsdk.aGH.Os.aGH(evVar, "destroy", jSONObject);
    }

    public static void eli(ev evVar) {
        com.bytedance.sdk.openadsdk.aGH.Os.aGH(evVar, "cache_expire", (JSONObject) null);
    }

    public static void DbA(ev evVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", ev.ui(evVar) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException e) {
            Xb.eli("TTAppOpenAdReport", "reportCacheLoss json error", e);
        }
        com.bytedance.sdk.openadsdk.aGH.Os.aGH(evVar, "cache_loss", jSONObject);
    }

    public static void eli(ev evVar, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C3207n2.u, z ? 1 : 2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "download_image_duration", j, jSONObject);
    }

    public static void DbA(ev evVar, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ContentDisposition.Parameters.Size, evVar.nY().ui());
            jSONObject.put("video_duration", evVar.nY().MGA());
            jSONObject.put(C3207n2.u, z ? 1 : 2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "download_video_duration", j, jSONObject);
    }

    public static void eli(ev evVar, int i, GB gb) {
        JSONObject jSONObject = new JSONObject();
        long j = 0;
        try {
            jSONObject.put("openad_creative_type", ev.ui(evVar) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("open_ad_cache_type", i);
            if (gb != null) {
                gb.DbA(eU.DbA());
                eli(jSONObject, evVar);
                jSONObject.put("client_start_time", gb.DbA());
                jSONObject.put("sever_time", gb.aGH());
                jSONObject.put("network_time", gb.Os());
                jSONObject.put("client_end_time", gb.ui());
                jSONObject.put("download_resource_duration", gb.kb());
                jSONObject.put("resource_source", gb.wC());
                jSONObject.put("is_bidding", gb.eli ? 1 : 0);
                if (gb.eli) {
                    jSONObject.put("load_wait_time", gb.DbA);
                }
                j = gb.MGA();
            }
        } catch (JSONException e) {
            Xb.eli("TTAppOpenAdReport", "reportLoadNetDuration json error", e);
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "load_net_duration", j, jSONObject);
    }

    public static void eli(ev evVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            eli(jSONObject, evVar);
            jSONObject.put("openad_creative_type", ev.ui(evVar) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException unused) {
            Xb.Os("TTAppOpenAdReport", "reportLoadCacheDuration json error");
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "load_cache_duration", j, jSONObject);
    }

    private static void eli(JSONObject jSONObject, ev evVar) {
        int i;
        if (evVar != null) {
            try {
                if (evVar.gG()) {
                    i = 1;
                    jSONObject.put("is_icon_only", i);
                }
            } catch (JSONException e) {
                Xb.Os("TTAppOpenAdReport", e.getMessage());
                return;
            }
        }
        i = 0;
        jSONObject.put("is_icon_only", i);
    }
}
