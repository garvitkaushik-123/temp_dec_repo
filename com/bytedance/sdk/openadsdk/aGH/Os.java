package com.bytedance.sdk.openadsdk.aGH;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.aGH.eli;
import com.bytedance.sdk.openadsdk.core.du.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.oWW;
import com.bytedance.sdk.openadsdk.core.ujq;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.eU;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    public static void eli() {
        try {
            Class.forName(Os.class.getName());
        } catch (ClassNotFoundException unused) {
        }
    }

    public static void eli(ev evVar, String str, final int i) {
        eli(System.currentTimeMillis(), evVar, str, "open_url_h5", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("preload_status", Integer.valueOf(i));
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(final ev evVar, String str) {
        eli(System.currentTimeMillis(), evVar, str, "endcard_load_start", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.12
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (ev.Os(ev.this)) {
                        if (ev.this.KM() != null) {
                            jSONObject2.putOpt("url", ev.this.KM().Os());
                            jSONObject2.putOpt("id", ev.this.KM().eli());
                            jSONObject2.putOpt("md5", ev.this.KM().DbA());
                        }
                        if (ev.this.nY() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", ev.this.nY().nlS());
                        jSONObject2.putOpt("style_id", ev.this.ujq());
                        if (ev.this.nY() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                } catch (Exception e) {
                    Xb.Os(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void eli(final ev evVar, String str, final long j) {
        eli(System.currentTimeMillis(), evVar, str, "endcard_load_finish", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.22
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (ev.Os(ev.this)) {
                        if (ev.this.KM() != null) {
                            jSONObject2.putOpt("url", ev.this.KM().Os());
                            jSONObject2.putOpt("id", ev.this.KM().eli());
                            jSONObject2.putOpt("md5", ev.this.KM().DbA());
                        }
                        if (ev.this.nY() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", ev.this.nY().nlS());
                        jSONObject2.putOpt("style_id", ev.this.ujq());
                        if (ev.this.nY() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    return jSONObject;
                } catch (Exception e) {
                    Xb.Os(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void eli(final ev evVar, String str, final long j, final int i, final String str2, final String str3) {
        eli(System.currentTimeMillis(), evVar, str, "endcard_load_fail", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.33
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    if (ev.Os(ev.this)) {
                        if (ev.this.KM() != null) {
                            jSONObject2.putOpt("url", ev.this.KM().Os());
                            jSONObject2.putOpt("id", ev.this.KM().eli());
                            jSONObject2.putOpt("md5", ev.this.KM().DbA());
                        }
                        if (ev.this.nY() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.putOpt("url", ev.this.nY().nlS());
                        jSONObject2.putOpt("style_id", ev.this.ujq());
                        if (!TextUtils.isEmpty(str3)) {
                            jSONObject2.putOpt("error_url", str3);
                        }
                        if (ev.this.nY() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, i);
                    jSONObject2.put("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    return jSONObject;
                } catch (Exception e) {
                    Xb.Os(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void eli(final ev evVar, String str, final long j, final int i, final int i2) {
        eli(System.currentTimeMillis(), evVar, str, "load", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.44
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.putOpt("interaction_method", Integer.valueOf(ev.this.oc()));
                    jSONObject2.put("first_page", i2);
                    jSONObject2.put("preload_h5_type", ev.this.GB());
                    int i3 = i;
                    if (i3 >= 0) {
                        jSONObject2.putOpt("preload_status", Integer.valueOf(i3));
                    }
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", Math.min(j, TTAdConstant.AD_MAX_EVENT_TIME));
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(String str, ev evVar, String str2, final Map<String, Object> map) {
        eli(System.currentTimeMillis(), evVar, str2, str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.49
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (map != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry entry : map.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(long j, ev evVar, String str, String str2, final JSONObject jSONObject, kb kbVar, com.bytedance.sdk.openadsdk.aGH.DbA.eli eliVar) {
        eli(j, evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.50
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                return jSONObject;
            }
        });
    }

    @DungeonFlag
    public static void eli(ev evVar, String str, JSONObject jSONObject) {
        aGH(evVar, C3207n2.v, str, jSONObject);
    }

    @DungeonFlag
    private static void aGH(final ev evVar, final String str, final String str2, final JSONObject jSONObject) {
        if (evVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (evVar.eU() && C3207n2.v.equals(str)) {
            return;
        }
        if (C3207n2.v.equals(str)) {
            evVar.kb(true);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        eli(new com.bytedance.sdk.component.wC.wC("onShow") { // from class: com.bytedance.sdk.openadsdk.aGH.Os.51
            @Override // java.lang.Runnable
            public void run() {
                final String str3;
                if (!com.bytedance.sdk.openadsdk.core.dV.aGH().BDs()) {
                    str3 = "none";
                } else {
                    str3 = com.bytedance.sdk.openadsdk.core.FC.eli.eli.eli((Application) com.bytedance.sdk.openadsdk.core.dV.eli()).eli(str2, DeviceUtils.eli(), evVar.RTg());
                }
                Os.eli(currentTimeMillis, evVar, str2, str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.51.1
                    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                    public JSONObject eli() {
                        Object obj;
                        try {
                            ujq.DbA(evVar);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                if (jSONObject != null) {
                                    jSONObject.put("interaction_method", evVar.oc());
                                    jSONObject.put("real_interaction_method", evVar.mm());
                                    jSONObject.put("video_skip_result", com.bytedance.sdk.openadsdk.core.dV.aGH().nlS(String.valueOf(evVar.RTg())));
                                    jSONObject.put("au_show", str3);
                                    Os.DbA(evVar, jSONObject);
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                } else {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put("interaction_method", evVar.oc());
                                    jSONObject3.put("real_interaction_method", evVar.mm());
                                    jSONObject3.put("video_skip_result", com.bytedance.sdk.openadsdk.core.dV.aGH().nlS(String.valueOf(evVar.RTg())));
                                    jSONObject3.put("au_show", str3);
                                    Os.DbA(evVar, jSONObject);
                                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                                }
                                jSONObject2.putOpt("log_extra", evVar.eu());
                                float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - evVar.QP()).floatValue();
                                if (floatValue <= 0.0f) {
                                    floatValue = 0.0f;
                                }
                                jSONObject2.putOpt("show_time", Float.valueOf(floatValue));
                                jSONObject2.putOpt("ua_policy", Integer.valueOf(evVar.ND()));
                                String PfW = evVar.PfW();
                                if (!TextUtils.isEmpty(PfW) && !TextUtils.isEmpty(PfW)) {
                                    try {
                                        jSONObject2.put("ttdsp_price", Math.round(Float.parseFloat(PfW) * 100000.0f));
                                    } catch (Throwable th) {
                                        jSONObject2.put("ttdsp_price", 0);
                                        Xb.Os("TTAD.AdEvent", th.getMessage());
                                    }
                                }
                                if (evVar.FYe() == null) {
                                    return jSONObject2;
                                }
                                try {
                                    Object obj2 = evVar.FYe().get(TTAdConstant.SDK_BIDDING_TYPE);
                                    if (obj2 == null || Integer.parseInt(obj2.toString()) != 2 || (obj = evVar.FYe().get("price")) == null) {
                                        return jSONObject2;
                                    }
                                    jSONObject2.put("ttdsp_price", Math.round(Double.parseDouble(obj.toString()) * 100000.0d));
                                    return jSONObject2;
                                } catch (Throwable th2) {
                                    Xb.eli("TTAD.AdEvent", "client bidding price error: ", th2);
                                    return jSONObject2;
                                }
                            } catch (Exception unused) {
                                return jSONObject2;
                            }
                        } catch (Exception unused2) {
                            return null;
                        }
                    }
                });
                if (C3207n2.v.equals(str)) {
                    if (!evVar.fa()) {
                        if (evVar.nie()) {
                            com.bytedance.sdk.openadsdk.core.du.DbA.Os.eli(evVar.tpZ(), new Os.DbA("show_urls", evVar));
                        } else {
                            Os.eli(evVar);
                        }
                    }
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        int optInt = jSONObject2.optInt("dynamic_show_type");
                        if (evVar.cyF() == 1 && (optInt == 7 || optInt == 10)) {
                            com.bytedance.sdk.component.utils.FC.eli().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.51.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONObject jSONObject3 = new JSONObject();
                                    try {
                                        jSONObject3.put("auto_click", true);
                                        Os.DbA(evVar, str2, "click", jSONObject3);
                                    } catch (Exception unused) {
                                        Xb.Os("TTAD.AdEvent", "ugen click exception");
                                    }
                                }
                            }, com.bytedance.sdk.openadsdk.core.settings.NU.nY().Ca());
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.FC.Os.eli(evVar, str3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(ev evVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (KM.DbA(evVar) && evVar.CQP()) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("is_new_playable", 1);
                eli(jSONObject2);
                jSONObject.put("pag_json_data", jSONObject2.toString());
                return;
            } catch (Throwable th) {
                Xb.Os(th.getMessage(), new Object[0]);
                return;
            }
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            eli(jSONObject3);
            jSONObject.put("pag_json_data", jSONObject3.toString());
        } catch (Throwable th2) {
            Xb.Os(th2.getMessage(), new Object[0]);
        }
    }

    private static void eli(JSONObject jSONObject) {
        try {
            JSONObject eli2 = wC.eli();
            if (eli2 != null) {
                Iterator<String> keys = eli2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, eli2.get(next));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli(ev evVar) {
        if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.nlS.eli(com.bytedance.sdk.openadsdk.core.dV.eli()))) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.Vy.eli.eli(evVar.tpZ(), true), 1, evVar.umh());
    }

    @DungeonFlag
    public static void eli(final String str, final ev evVar, final String str2, final kb kbVar) {
        if (evVar == null || kbVar == null || !kbVar.eli()) {
            return;
        }
        eli(System.currentTimeMillis(), evVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.52
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", str);
                    kb kbVar2 = kbVar;
                    if (kbVar2 != null && kbVar2.DbA() != null) {
                        JSONObject DbA = kbVar.DbA();
                        if (str2.equals("open_ad")) {
                            DbA.put("is_icon_only", evVar.gG() ? 1 : 0);
                        }
                        jSONObject.put("ad_extra_data", DbA.toString());
                    }
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(final ev evVar, final String str, final eU eUVar) {
        if (evVar == null) {
            return;
        }
        final long aGH = eUVar.aGH();
        eli(System.currentTimeMillis(), evVar, str, "stay_duration", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("click_stay_time", aGH);
                    jSONObject.put("click_time", eUVar.eli);
                    if (str.equals("open_ad")) {
                        jSONObject.put("is_icon_only", evVar.gG() ? 1 : 0);
                    }
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void DbA(ev evVar, String str, final long j) {
        if (evVar != null && j > 0 && j < 200000) {
            eli(System.currentTimeMillis(), evVar, str, "video_click_duration", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.3
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put("video_click_duration_time", j);
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    public static void eli(ev evVar, final String str, final int i, final String str2, final long j, final boolean z, final int i2, final long j2) {
        eli(System.currentTimeMillis(), evVar, str, DbA.aGH, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.4
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("invisible_scene", i);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("loading_visible_time", j);
                    jSONObject.put("arbi_trigger_start", z);
                    jSONObject.put("arbi_convert_count", i2);
                    jSONObject.put("loading_start_timestamp", j2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                }
                new Object[]{"-->onArbitrageLoading", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void eli(ev evVar, String str, final long j, final boolean z) {
        eli(System.currentTimeMillis(), evVar, str, "lp_loading", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.5
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("if_lp_loading_success", z ? 1 : 2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j);
                    return jSONObject2;
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    public static void Os(ev evVar, String str, final long j) {
        eli(System.currentTimeMillis(), evVar, str, "load_feeling_duration", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.6
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("duration", j);
                } catch (Throwable th) {
                    Xb.Os("TTAD.AdEvent", th.getMessage());
                }
                new Object[]{"onLpFeelingDuration -->", jSONObject.toString()};
                return jSONObject;
            }
        });
    }

    public static void DbA(ev evVar, String str, final int i) {
        eli(System.currentTimeMillis(), evVar, str, "check_meta", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.7
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.NU.nY().iuv());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    public static void Os(ev evVar, String str, final int i) {
        eli(System.currentTimeMillis(), evVar, str, "check_meta_more", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.8
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                    jSONObject.put("check_url", com.bytedance.sdk.openadsdk.core.settings.NU.nY().iuv());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    public static void eli(ev evVar, final String str, final int i, final String str2, final int i2) {
        eli(System.currentTimeMillis(), evVar, str, DbA.eli, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.9
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
                    jSONObject.put("arbi_current_url", str2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("new_index", i2);
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                }
                new Object[]{"-->onArbitrageLoadStart", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void eli(ev evVar, final String str, final int i, final String str2, final float f) {
        eli(System.currentTimeMillis(), evVar, str, DbA.DbA, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.10
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put("arbi_load_duration", f);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                }
                new Object[]{"-->onArbitrageLoadFinish", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void eli(ev evVar, final String str, final int i, final String str2, final String str3, final int i2) {
        eli(System.currentTimeMillis(), evVar, str, DbA.Os, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.11
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
                    jSONObject.put("arbi_current_url", str2);
                    jSONObject.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, str3);
                    jSONObject.put("url_flag", i2);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                }
                new Object[]{"-->onArbitrageLoadUrl", jSONObject, str};
                return jSONObject2;
            }
        });
    }

    public static void aGH(final ev evVar, final String str, final int i) {
        eli(System.currentTimeMillis(), evVar, str, "material_status", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.13
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("trigger_type", i);
                    jSONObject3.put("image_mode", evVar.GR());
                    jSONObject.put("pag_json_data", jSONObject3.toString());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    new Object[]{"report onMaterialStatus, ad_extra_data is:", jSONObject.toString(), str};
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void DbA(final ev evVar, String str) {
        eli(System.currentTimeMillis(), evVar, str, "picture_click", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.14
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("ad_slot_type", ev.this.cK());
                    jSONObject.put("interaction_method", ev.this.oc());
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Throwable th) {
                    Xb.Os(th.toString(), new Object[0]);
                    return jSONObject2;
                }
            }
        });
    }

    @DungeonFlag
    public static void eli(final String str, final ev evVar, final com.bytedance.sdk.openadsdk.core.model.nlS nls, final String str2, final boolean z, final Map<String, Object> map, final int i) {
        final long currentTimeMillis = System.currentTimeMillis();
        eli(new com.bytedance.sdk.component.wC.wC("onClick") { // from class: com.bytedance.sdk.openadsdk.aGH.Os.15
            @Override // java.lang.Runnable
            public void run() {
                ev evVar2 = evVar;
                if (evVar2 == null) {
                    return;
                }
                Os.eli(currentTimeMillis, evVar2, str2, str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.15.1
                    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                    public JSONObject eli() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (nls != null) {
                                JSONObject eli2 = nls.eli();
                                eli2.put("is_valid", z);
                                if (i > 0 && i <= 2) {
                                    eli2.put("user_behavior_type", i);
                                }
                                if (map != null) {
                                    if (map.containsKey("duration")) {
                                        jSONObject.put("duration", map.get("duration"));
                                    }
                                    for (Map.Entry entry : map.entrySet()) {
                                        if (!"duration".equals(entry.getKey())) {
                                            eli2.put((String) entry.getKey(), entry.getValue());
                                        }
                                    }
                                }
                                eli2.put("interaction_method", evVar.oc());
                                if (str2.equals("open_ad")) {
                                    eli2.put("is_icon_only", evVar.gG() ? 1 : 0);
                                }
                                jSONObject.put("ad_extra_data", eli2.toString());
                            }
                            jSONObject.putOpt("log_extra", evVar.eu());
                            float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - evVar.QP()).floatValue();
                            if (floatValue <= 0.0f) {
                                floatValue = 0.0f;
                            }
                            jSONObject.putOpt("show_time", Float.valueOf(floatValue));
                            jSONObject.putOpt("ua_policy", Integer.valueOf(evVar.ND()));
                        } catch (Exception unused) {
                        }
                        return jSONObject;
                    }
                });
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.nlS.eli(com.bytedance.sdk.openadsdk.core.dV.eli())) && "click".equals(str)) {
                    com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.Vy.eli.eli(evVar.ZLD(), true), 2, evVar.umh());
                }
                if ("click".equals(str)) {
                    ujq.Os(evVar);
                }
            }
        });
    }

    public static void eli(ev evVar, String str, String str2, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.16
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                if (jSONObject == null) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    if (jSONObject.has("duration")) {
                        jSONObject2.put("duration", jSONObject.get("duration"));
                        return jSONObject2;
                    }
                } catch (Exception e) {
                    Xb.Os("TTAD.AdEvent", e.getMessage());
                }
                return jSONObject2;
            }
        });
        if ("click".equals(str2)) {
            ujq.Os(evVar);
        }
    }

    public static void eli(ev evVar, String str, final String str2, final long j, final int i, JSONObject jSONObject, final kb kbVar) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        final JSONObject jSONObject2 = jSONObject;
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.17
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                kb kbVar2;
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("duration", j);
                    jSONObject3.put("percent", i);
                    if (("feed_break".equals(str2) || "feed_over".equals(str2)) && (kbVar2 = kbVar) != null) {
                        kbVar2.eli(jSONObject2);
                    }
                    jSONObject3.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject3;
            }
        });
    }

    public static void DbA(ev evVar, String str, String str2, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.18
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void eli(ev evVar, String str, String str2, final JSONObject jSONObject, final long j) {
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.19
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    }
                    jSONObject2.put("duration", j);
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void eli(final ev evVar, String str, String str2, final Map<String, Object> map) {
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.20
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                        Object obj = map.get("duration");
                        if (obj instanceof Long) {
                            jSONObject.put("duration", obj);
                        }
                    }
                    jSONObject2.put("dp_creative_type", evVar.MKR());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    @DungeonFlag
    public static void eli(long j, ev evVar, String str, String str2) {
        eli(j, evVar, str, str2, (com.bytedance.sdk.openadsdk.Dfc.Os.eli) null);
    }

    @DungeonFlag
    public static void eli(final long j, final ev evVar, final String str, final String str2, final com.bytedance.sdk.openadsdk.Dfc.Os.eli eliVar) {
        if (evVar == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || eli(evVar.jh(), str2)) {
            return;
        }
        eli(new com.bytedance.sdk.component.wC.wC(str2) { // from class: com.bytedance.sdk.openadsdk.aGH.Os.21
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject;
                try {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli eliVar2 = eliVar;
                    if (eliVar2 != null) {
                        jSONObject = eliVar2.eli();
                        if (jSONObject == null) {
                            try {
                                jSONObject = new JSONObject();
                            } catch (Exception unused) {
                            }
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.putOpt("log_extra", evVar.eu());
                    jSONObject.putOpt("ua_policy", Integer.valueOf(evVar.ND()));
                } catch (Exception unused2) {
                    jSONObject = null;
                }
                new eli.C0165eli(j, evVar).DbA(str).Os(str2).ui(evVar.umh()).wC(evVar.Uv()).eli(evVar.cvo()).eli(jSONObject).kb(evVar.fO()).eli((com.bytedance.sdk.openadsdk.aGH.DbA.eli) null);
            }
        });
    }

    public static void eli(ev evVar, String str, final String str2, final com.bytedance.sdk.openadsdk.Dfc.Os.eli eliVar) {
        eli(System.currentTimeMillis(), evVar, str, "playable_track", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.23
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli eliVar2 = com.bytedance.sdk.openadsdk.Dfc.Os.eli.this;
                    if (eliVar2 != null) {
                        jSONObject = eliVar2.eli();
                        if (jSONObject == null) {
                            jSONObject = new JSONObject();
                        }
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("is_new_playable", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("pag_json_data", jSONObject.toString());
                    jSONObject3.put("playable_event", str2);
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                } catch (Exception unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void DbA(final long j, final ev evVar, String str, final String str2) {
        eli(System.currentTimeMillis(), evVar, str, "endcard_feeling_duraion", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.24
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("duration", j);
                    if (ev.Os(evVar)) {
                        if (evVar.KM() != null) {
                            jSONObject2.putOpt("url", evVar.KM().Os());
                            jSONObject2.putOpt("id", evVar.KM().eli());
                            jSONObject2.putOpt("md5", evVar.KM().DbA());
                        }
                        jSONObject2.putOpt(Constants.MessagePayloadKeys.FROM, str2);
                        if (evVar.nY() != null) {
                            jSONObject2.putOpt("render_type", 7);
                        }
                    } else {
                        jSONObject2.put("url", evVar.nY().nlS());
                        jSONObject2.put("style_id", evVar.ujq());
                        if (evVar.nY() != null) {
                            jSONObject2.putOpt("render_type", 0);
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                } catch (Exception e) {
                    Xb.Os(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void Os(final ev evVar, String str) {
        if (evVar == null || !ev.Os(evVar) || evVar.KM() == null) {
            return;
        }
        eli(System.currentTimeMillis(), evVar, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.25
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", ev.this.KM().Os());
                    jSONObject2.putOpt("id", ev.this.KM().eli());
                    jSONObject2.putOpt("md5", ev.this.KM().DbA());
                    if (ev.this.nY() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(ev.this.nY().aGH()));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(ev evVar, final com.bytedance.sdk.openadsdk.Dfc.eli.eli eliVar, final String str) {
        eli(System.currentTimeMillis(), evVar, str, "web_behavior_keyword", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.26
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.Os());
                    jSONObject2.put("keyword", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.dV());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    Xb.Os("TTAD.AdEvent", "onWebBehaviorKeyword", th.getMessage());
                }
                new Object[]{"onWebBehaviorKeyword-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void DbA(ev evVar, final com.bytedance.sdk.openadsdk.Dfc.eli.eli eliVar, final String str) {
        eli(System.currentTimeMillis(), evVar, str, "web_behavior_load", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.27
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.Os());
                    jSONObject2.put("current_url_index", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.aGH());
                    jSONObject2.put("arbi_load_duration", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.nGm());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    Xb.Os("TTAD.AdEvent", "onWebBehaviorLoad", th.getMessage());
                }
                new Object[]{"onWebBehaviorLoad-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void Os(ev evVar, final com.bytedance.sdk.openadsdk.Dfc.eli.eli eliVar, final String str) {
        eli(System.currentTimeMillis(), evVar, str, "web_behavior_stay", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.28
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.Os());
                    jSONObject2.put("current_url_index", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.aGH());
                    jSONObject2.put("arbi_stay_duration", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.nn());
                    jSONObject2.put("browsing_percentage", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.Dfc());
                    jSONObject2.put("out_focus_scene", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.aqO());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    Xb.Os("TTAD.AdEvent", "onWebBehaviorStay", th.getMessage());
                }
                new Object[]{"onWebBehaviorStay-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void aGH(ev evVar, final com.bytedance.sdk.openadsdk.Dfc.eli.eli eliVar, final String str) {
        eli(System.currentTimeMillis(), evVar, str, "web_behavior_scroll", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.29
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.Os());
                    jSONObject2.put("current_url_index", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.aGH());
                    jSONObject2.put("trigger_scroll_x", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.FC());
                    jSONObject2.put("trigger_scroll_y", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.aAs());
                    jSONObject2.put("arbi_offset_y", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.du());
                    jSONObject2.put("scroll_type", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.nlS());
                    jSONObject2.put("scroll_duration", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.NU());
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    Xb.Os("TTAD.AdEvent", "onWebBehaviorScroll", th.getMessage());
                }
                new Object[]{"onWebBehaviorScroll-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void ui(ev evVar, final com.bytedance.sdk.openadsdk.Dfc.eli.eli eliVar, final String str) {
        eli(System.currentTimeMillis(), evVar, str, "web_behavior_click", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.30
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("arbi_current_url", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.Os());
                    jSONObject2.put("current_url_index", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.aGH());
                    jSONObject2.put("arbi_start_x", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.ui());
                    jSONObject2.put("arbi_start_y", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.MGA());
                    jSONObject2.put("click_duration", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.kb());
                    jSONObject2.put("is_trigger_jump", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.wC());
                    jSONObject2.put("click_type", String.valueOf(com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.QX()));
                    if (com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.eli() != -1) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("hit_type", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.eli());
                        jSONObject3.put("hit_extra", com.bytedance.sdk.openadsdk.Dfc.eli.eli.this.DbA());
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable th) {
                    Xb.Os("TTAD.AdEvent", "onWebBehaviorClick", th.getMessage());
                }
                new Object[]{"onWebBehaviorClick-->", jSONObject, str};
                return jSONObject;
            }
        });
    }

    public static void eli(final long j, final ev evVar, String str) {
        if (evVar == null || !ev.Os(evVar) || evVar.KM() == null) {
            return;
        }
        eli(System.currentTimeMillis(), evVar, str, "endcard_close", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.31
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", ev.this.KM().Os());
                    jSONObject2.putOpt("id", ev.this.KM().eli());
                    jSONObject2.putOpt("md5", ev.this.KM().DbA());
                    if (ev.this.nY() != null) {
                        jSONObject2.putOpt("render_type", Integer.valueOf(ev.this.nY().aGH()));
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    jSONObject.put("duration", j);
                    return jSONObject;
                } catch (Exception e) {
                    Xb.Os(e.getMessage(), new Object[0]);
                    return jSONObject;
                }
            }
        });
    }

    public static void eli(ev evVar, String str, final String str2) {
        eli(System.currentTimeMillis(), evVar, str, "show_error", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.32
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("error_msg", str2);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(ev evVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (evVar == null || jSONObject == null) {
            return;
        }
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.34
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("duration", j);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    return jSONObject2;
                } catch (Exception e) {
                    Xb.Os("TTAD.AdEvent", e.getMessage());
                    return jSONObject2;
                }
            }
        });
    }

    public static void DbA(ev evVar, String str, String str2, final JSONObject jSONObject, final long j) {
        if (evVar == null || jSONObject == null) {
            return;
        }
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.35
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                    jSONObject2.put("duration", j);
                } catch (Throwable unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void Os(ev evVar, final String str, final String str2, final JSONObject jSONObject) {
        if (evVar == null || jSONObject == null) {
            return;
        }
        eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.36
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException unused) {
                }
                new Object[]{"extJson: ", jSONObject2, "tag: ", str, "label: ", str2};
                return jSONObject2;
            }
        });
    }

    public static void DbA(ev evVar, final String str, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, DbA.ui, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.37
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                new Object[]{"extJson: ", jSONObject2, "tag: ", str, "label: ", DbA.ui};
                return jSONObject2;
            }
        });
    }

    public static void Os(ev evVar, final String str, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, DbA.MGA, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.38
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("pag_json_data", jSONObject);
                    jSONObject2.put("ad_extra_data", jSONObject3);
                } catch (JSONException unused) {
                }
                new Object[]{"extJson: ", jSONObject2, "tag: ", str, "label: ", DbA.MGA};
                return jSONObject2;
            }
        });
    }

    public static void eli(String str, long j) {
        com.bytedance.sdk.openadsdk.core.kb.Os.eli(str, j);
    }

    @DungeonFlag
    public static void eli(final ev evVar, final String str, final String str2, final String str3, final long j, final long j2, final JSONObject jSONObject, final boolean z) {
        if (evVar == null || eli(evVar.jh(), str3)) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        eli(new com.bytedance.sdk.component.wC.wC("sendJsAdEvent") { // from class: com.bytedance.sdk.openadsdk.aGH.Os.39
            @Override // java.lang.Runnable
            public void run() {
                JSONArray optJSONArray;
                String cvo = evVar.cvo();
                if (jSONObject != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        String optString = jSONObject.optString("ad_extra_data");
                        if (!TextUtils.isEmpty(optString)) {
                            jSONObject2 = new JSONObject(optString);
                        }
                        if (!"click".equals(str3)) {
                            jSONObject2.put(C3040d4.h.G, DeviceUtils.kb(com.bytedance.sdk.openadsdk.core.dV.eli()).toString());
                        }
                        if ("click".equals(str3)) {
                            if (z) {
                                jSONObject2.put("click_scence", 1);
                            } else if (KM.DbA(evVar)) {
                                jSONObject2.put("click_scence", 3);
                            }
                        }
                        if (evVar.CQP()) {
                            try {
                                JSONObject optJSONObject = jSONObject2.optJSONObject("pag_json_data");
                                if (optJSONObject == null) {
                                    optJSONObject = new JSONObject();
                                }
                                optJSONObject.put("is_new_playable", 1);
                                if (evVar.UUL()) {
                                    optJSONObject.put("is_pre_render", 1);
                                }
                                jSONObject2.put("pag_json_data", optJSONObject.toString());
                            } catch (Throwable unused) {
                            }
                        }
                        int i = 0;
                        if (com.bytedance.sdk.openadsdk.NU.eli.Os(evVar)) {
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("pag_json_data");
                            if (optJSONObject2 == null) {
                                optJSONObject2 = new JSONObject();
                            }
                            optJSONObject2.put("is_lp_pre_render", evVar.SE() ? 1 : 0);
                            jSONObject2.put("pag_json_data", optJSONObject2.toString());
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("tag", str2);
                        int optInt = jSONObject2.optInt("agg_request_type", -1);
                        if (z && optInt == 2) {
                            cvo = jSONObject2.optString("app_log_url");
                        }
                        if ("click".equals(str3)) {
                            ujq.Os(evVar);
                            float floatValue = Double.valueOf((System.currentTimeMillis() / 1000) - ev.DbA(jSONObject.optString("log_extra"))).floatValue();
                            JSONObject jSONObject3 = jSONObject;
                            if (floatValue <= 0.0f) {
                                floatValue = 0.0f;
                            }
                            jSONObject3.putOpt("show_time", Float.valueOf(floatValue));
                            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.nlS.eli(com.bytedance.sdk.openadsdk.core.dV.eli()))) {
                                if (z && optInt == 2) {
                                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("click_tracking_url");
                                    if (optJSONArray2 != null) {
                                        ArrayList arrayList = new ArrayList();
                                        while (i < optJSONArray2.length()) {
                                            arrayList.add(optJSONArray2.optString(i));
                                            i++;
                                        }
                                        com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.Vy.eli.eli(arrayList, true), 2, String.valueOf(j));
                                    }
                                } else {
                                    ev evVar2 = evVar;
                                    if (evVar2 != null) {
                                        com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.Vy.eli.eli(evVar2.ZLD(), true), 2, evVar.umh());
                                    }
                                }
                            }
                        } else if (C3207n2.v.equals(str3) && !TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.nlS.eli(com.bytedance.sdk.openadsdk.core.dV.eli())) && z && optInt == 2 && (optJSONArray = jSONObject2.optJSONArray("show_tracking_url")) != null) {
                            ArrayList arrayList2 = new ArrayList();
                            while (i < optJSONArray.length()) {
                                arrayList2.add(optJSONArray.optString(i));
                                i++;
                            }
                            com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(com.bytedance.sdk.openadsdk.Vy.eli.eli(arrayList2, true), 1, String.valueOf(j));
                        }
                    } catch (Exception unused2) {
                    }
                }
                new eli.C0165eli(currentTimeMillis, evVar).aGH(str).DbA(str2).Os(str3).ui(String.valueOf(j)).MGA(String.valueOf(j2)).eli(cvo).eli(jSONObject).wC(evVar.Uv()).kb(evVar.fO()).eli((com.bytedance.sdk.openadsdk.aGH.DbA.eli) null);
            }
        });
    }

    public static void aGH(ev evVar, String str, JSONObject jSONObject) {
        if (evVar == null) {
            return;
        }
        eli(evVar, str, -1L, jSONObject);
    }

    public static void eli(ev evVar, String str, final long j, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, "open_ad", str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.40
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    long j2 = j;
                    if (j2 != -1) {
                        jSONObject2.put("duration", j2);
                    }
                    JSONObject jSONObject3 = jSONObject;
                    if (jSONObject3 != null) {
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                        return jSONObject2;
                    }
                    jSONObject2.put("ad_extra_data", new JSONObject().toString());
                    return jSONObject2;
                } catch (Exception e) {
                    Xb.Os("TTAD.AdEvent", e.getMessage());
                    return jSONObject2;
                }
            }
        });
    }

    public static void eli(final com.bytedance.sdk.component.wC.wC wCVar) {
        if (wCVar == null) {
            return;
        }
        if (cyF.MGA()) {
            com.bytedance.sdk.component.utils.FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.41
                @Override // java.lang.Runnable
                public void run() {
                    cyF.DbA(com.bytedance.sdk.component.wC.wC.this, 10);
                }
            });
        } else if (!cyF.kb()) {
            cyF.DbA(wCVar, 10);
        } else {
            wCVar.run();
        }
    }

    public static void eli(final com.bytedance.sdk.openadsdk.Dfc.eli.DbA dbA) {
        if (dbA == null || dbA.DbA() == null) {
            return;
        }
        final ev DbA = dbA.DbA();
        final int yw = DbA.yw();
        if (yw == 2 || yw == 8 || (dZ.aGH(DbA) && DbA.eli.aGH.equals(dbA.eli()))) {
            eli(System.currentTimeMillis(), DbA, dbA.Os(), "open_browser", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.42
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONArray optJSONArray;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int aGH = com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.aGH();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("count", dZ.aAs(com.bytedance.sdk.openadsdk.core.dV.eli()));
                        jSONObject2.put("interceptor", aGH);
                        jSONObject2.put("success", com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.ui());
                        jSONObject2.put("link", com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.eli());
                        jSONObject2.put("interaction_type", yw);
                        jSONObject2.put("real_interaction_type", com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.kb());
                        if (com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.aGH() == 9) {
                            jSONObject2.put("is_act_signals_api_available", com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.wC());
                            jSONObject2.put("is_act_signals_callback", com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.FC());
                        }
                        if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.MGA())) {
                            jSONObject2.put("exception_msg", com.bytedance.sdk.openadsdk.Dfc.eli.DbA.this.MGA());
                        }
                        if (aGH == 2 || aGH == 5) {
                            String eD = DbA.eD();
                            if (!TextUtils.isEmpty(eD) && (optJSONArray = new JSONObject(eD).optJSONArray("creatives")) != null && optJSONArray.length() > 0) {
                                jSONObject2.put(com.adjust.sdk.Constants.REFERRER_API_META, optJSONArray.optJSONObject(DbA.DbA()));
                            }
                        }
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    } catch (Throwable th) {
                        Xb.Os("TTAD.AdEvent", th.getMessage());
                        return jSONObject;
                    }
                }
            });
        }
    }

    public static void ui(ev evVar, String str, JSONObject jSONObject) {
        aGH(evVar, "activity_recreate", str, jSONObject);
    }

    public static void eli(JSONObject jSONObject, int i, int i2) {
        try {
            jSONObject.put("skip_show_time", i);
            jSONObject.put("skip_time", i2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("skip_after_time", i2 - (i * 1000));
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (JSONException unused) {
        }
    }

    public static class eli {
        public static void eli(String str, final JSONObject jSONObject, ev evVar) {
            String eli = dZ.eli(evVar);
            if (eli == null) {
                return;
            }
            Os.eli(System.currentTimeMillis(), evVar, eli + "_landingpage", str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.eli.1
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        return jSONObject2;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.loadEvent error", th);
                        return jSONObject2;
                    }
                }
            });
        }

        public static void eli(final int i, final int i2, ev evVar) {
            String eli = dZ.eli(evVar);
            if (eli == null) {
                return;
            }
            Os.eli(System.currentTimeMillis(), evVar, eli + "_landingpage", "local_res_hit_rate", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.eli.2
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("all_times", i2);
                        jSONObject2.put("hit_times", i);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                        return jSONObject;
                    }
                }
            });
        }

        public static void eli(final long j, final ev evVar, String str, final ILoader iLoader, final String str2) {
            if (str == null) {
                return;
            }
            Os.eli(System.currentTimeMillis(), evVar, str, "landingpage_init", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.eli.3
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        int eli = com.bytedance.sdk.openadsdk.kb.DbA.eli().eli(ILoader.this, str2);
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(ev.DbA, evVar.OJ() ? 1 : 0);
                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                        jSONObject2.put("url", evVar.dM());
                        jSONObject2.put("channel_name", evVar.QxD());
                        jSONObject2.put("interceptor_status", (TextUtils.isEmpty(evVar.QxD()) || eli <= 0) ? 0 : 1);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("resource_count", eli);
                        jSONObject2.put("resource_info", jSONObject4);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        jSONObject.put("duration", j);
                        return jSONObject;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                        return jSONObject;
                    }
                }
            });
        }

        public static void eli(final int i, final int i2, final int i3, final int i4, final ev evVar, String str, final int i5) {
            if (str == null || TextUtils.isEmpty(evVar.QxD())) {
                return;
            }
            Os.eli(System.currentTimeMillis(), evVar, str, "landing_page_resource_detail", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.eli.4
                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                public JSONObject eli() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("next_url", ev.this.dM());
                        jSONObject2.put("channel_name", ev.this.QxD());
                        jSONObject2.put("preload_status", i <= 0 ? 0 : 2);
                        jSONObject2.put("first_page", i5);
                        jSONObject2.put("preload_h5_type", ev.this.GB());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("channel_response", i);
                        jSONObject3.put("failResourceCount", i2);
                        jSONObject3.put("successCount", i3);
                        jSONObject3.put("failCount", i4);
                        jSONObject2.put("resource_info", jSONObject3);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    } catch (Throwable th) {
                        Log.d("TTAD.AdEvent", "Gecko.localResHitRate error", th);
                        return jSONObject;
                    }
                }
            });
        }
    }

    public static void eli(ev evVar, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        DbA(evVar, str, "open_ad_land_page_links", jSONObject);
    }

    public static void DbA(ev evVar, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        DbA(evVar, str, "download_app_ad_track", jSONObject);
    }

    public static void eli(ev evVar, String str, final boolean z, final boolean z2, final boolean z3, final boolean z4, final int i, final Map<String, Object> map) {
        eli(System.currentTimeMillis(), evVar, str, "start_show_plb", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.43
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("isSkip", z);
                    jSONObject2.put("force", z2);
                    jSONObject2.put("isFromLandingPage", z3);
                    jSONObject2.put("finishing", z4);
                    jSONObject2.put(Constants.MessagePayloadKeys.FROM, i);
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObject2.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void eli(final ev evVar, final boolean z, String str, final String str2, final long j, final String str3, final String str4, final int i, final String str5) {
        eli(System.currentTimeMillis(), evVar, str, "load_ugen_template", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.45
            /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(1:(2:2|3))|(2:5|(11:7|(9:42|11|(1:(1:(1:17))(2:29|(1:31)))(2:32|(2:34|(1:36))(2:37|(1:39)))|18|(1:20)|21|22|23|24)|10|11|(0)(0)|18|(0)|21|22|23|24)(11:43|(9:45|11|(0)(0)|18|(0)|21|22|23|24)|10|11|(0)(0)|18|(0)|21|22|23|24))(11:46|(9:48|11|(0)(0)|18|(0)|21|22|23|24)|10|11|(0)(0)|18|(0)|21|22|23|24)|49|50|51|52|22|23|24|(1:(1:53))) */
            /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x00ec A[Catch: all -> 0x00fe, TryCatch #2 {all -> 0x00fe, blocks: (B:3:0x000e, B:15:0x0052, B:17:0x005a, B:18:0x00cd, B:20:0x00ec, B:21:0x00f6, B:29:0x0070, B:31:0x0078, B:32:0x008e, B:34:0x0092, B:36:0x009a, B:37:0x00b0, B:39:0x00b8, B:40:0x0025, B:43:0x002f, B:46:0x0039), top: B:2:0x000e }] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x008e A[Catch: all -> 0x00fe, TryCatch #2 {all -> 0x00fe, blocks: (B:3:0x000e, B:15:0x0052, B:17:0x005a, B:18:0x00cd, B:20:0x00ec, B:21:0x00f6, B:29:0x0070, B:31:0x0078, B:32:0x008e, B:34:0x0092, B:36:0x009a, B:37:0x00b0, B:39:0x00b8, B:40:0x0025, B:43:0x002f, B:46:0x0039), top: B:2:0x000e }] */
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public JSONObject eli() {
                String str6;
                int hashCode;
                char c;
                oWW hg;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    try {
                        str6 = str4;
                        hashCode = str6.hashCode();
                    } catch (Throwable th) {
                        jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE);
                        jSONObject2.put("error_msg", "send template error " + th.getMessage());
                    }
                } catch (Throwable unused) {
                }
                if (hashCode == -1606803861) {
                    if (str6.equals("endcard")) {
                        c = 0;
                        if (c == 0) {
                        }
                        jSONObject2.put("ugen_status", str2);
                        jSONObject2.put(Constants.MessagePayloadKeys.FROM, str3);
                        jSONObject2.put("ugen_scene", str4);
                        if (C3040d4.f.e.equals(str2)) {
                        }
                        jSONObject.put("duration", j);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                    jSONObject2.put("ugen_status", str2);
                    jSONObject2.put(Constants.MessagePayloadKeys.FROM, str3);
                    jSONObject2.put("ugen_scene", str4);
                    if (C3040d4.f.e.equals(str2)) {
                    }
                    jSONObject.put("duration", j);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                }
                if (hashCode != 3107) {
                    if (hashCode == 2989536 && str6.equals("adv3")) {
                        c = 2;
                        if (c == 0) {
                            if (c == 1) {
                                ev.eli RY = evVar.RY();
                                if (RY != null) {
                                    jSONObject2.putOpt("url", RY.NU());
                                    jSONObject2.putOpt("id", RY.aGH());
                                    jSONObject2.putOpt("md5", RY.nn());
                                }
                            } else if (c == 2 && (hg = evVar.hg()) != null) {
                                jSONObject2.putOpt("url", hg.Os());
                                jSONObject2.putOpt("id", hg.eli());
                                jSONObject2.putOpt("md5", hg.DbA());
                            }
                        } else if (z) {
                            com.bytedance.sdk.openadsdk.core.aAs.wC.eli VM = evVar.VM();
                            if (VM != null) {
                                jSONObject2.putOpt("url", VM.Os());
                                jSONObject2.putOpt("id", VM.eli());
                                jSONObject2.putOpt("md5", VM.DbA());
                            }
                        } else {
                            com.bytedance.sdk.openadsdk.core.aAs.wC.eli KM = evVar.KM();
                            if (KM != null) {
                                jSONObject2.putOpt("url", KM.Os());
                                jSONObject2.putOpt("id", KM.eli());
                                jSONObject2.putOpt("md5", KM.DbA());
                            }
                        }
                        jSONObject2.put("ugen_status", str2);
                        jSONObject2.put(Constants.MessagePayloadKeys.FROM, str3);
                        jSONObject2.put("ugen_scene", str4);
                        if (C3040d4.f.e.equals(str2)) {
                            jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, i);
                            jSONObject2.put("error_msg", str5);
                        }
                        jSONObject.put("duration", j);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        return jSONObject;
                    }
                    c = 65535;
                    if (c == 0) {
                    }
                    jSONObject2.put("ugen_status", str2);
                    jSONObject2.put(Constants.MessagePayloadKeys.FROM, str3);
                    jSONObject2.put("ugen_scene", str4);
                    if (C3040d4.f.e.equals(str2)) {
                    }
                    jSONObject.put("duration", j);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                }
                if (str6.equals("ad")) {
                    c = 1;
                    if (c == 0) {
                    }
                    jSONObject2.put("ugen_status", str2);
                    jSONObject2.put(Constants.MessagePayloadKeys.FROM, str3);
                    jSONObject2.put("ugen_scene", str4);
                    if (C3040d4.f.e.equals(str2)) {
                    }
                    jSONObject.put("duration", j);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                    return jSONObject;
                }
                c = 65535;
                if (c == 0) {
                }
                jSONObject2.put("ugen_status", str2);
                jSONObject2.put(Constants.MessagePayloadKeys.FROM, str3);
                jSONObject2.put("ugen_scene", str4);
                if (C3040d4.f.e.equals(str2)) {
                }
                jSONObject.put("duration", j);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                return jSONObject;
                jSONObject2.put(AndroidBridgeConstants.ERROR_CODE, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE);
                jSONObject2.put("error_msg", "send template error " + th.getMessage());
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                return jSONObject;
            }
        });
    }

    private static boolean eli(int i, String str) {
        int Ue;
        try {
            Set<String> ND = com.bytedance.sdk.openadsdk.core.settings.NU.nY().ND();
            if ((i == 1 && ND != null && ND.contains(str)) || (Ue = com.bytedance.sdk.openadsdk.core.settings.NU.nY().Ue(str)) == 0) {
                return true;
            }
            if (Ue != 100) {
                if (((int) ((Math.random() * 100.0d) + 1.0d)) > Ue) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Xb.Os("TTAD.AdEvent", th.getMessage());
            return false;
        }
    }

    public static void eli(int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_show_order", i);
            jSONObject.put("pag_json_data", jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }

    public static void MGA(ev evVar, String str, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, "show_next_ad_hint", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.46
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("pag_json_data", jSONObject.toString());
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject2;
            }
        });
    }

    public static void kb(ev evVar, String str, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, "click_next_ad_button", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.47
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("pag_json_data", jSONObject.toString());
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject2;
            }
        });
    }

    public static void wC(ev evVar, String str, final JSONObject jSONObject) {
        eli(System.currentTimeMillis(), evVar, str, "click_playable_button", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.Os.48
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("pag_json_data", jSONObject.toString());
                        jSONObject2.put("ad_extra_data", jSONObject3.toString());
                    } catch (Throwable unused) {
                    }
                }
                return jSONObject2;
            }
        });
    }
}
