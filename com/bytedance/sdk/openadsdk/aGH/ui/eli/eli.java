package com.bytedance.sdk.openadsdk.aGH.ui.eli;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.eli.eli.eli.Os.DbA;
import com.bykv.vk.openvk.eli.eli.eli.Os.Os;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.aGH.kb;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.FC;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.MGA;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.NU;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.aAs;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.aGH;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.nn;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.ui;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.wC;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.gG;
import com.google.firebase.messaging.Constants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private static final Map<com.bykv.vk.openvk.eli.eli.eli.DbA.eli, Dfc> eli = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject eli(ev evVar, String str, int i, Os os) {
        return eli(evVar, str, i, os, null);
    }

    public static JSONObject eli(ev evVar, String str, int i, Os os, Dfc.eli eliVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (evVar != null) {
                DbA nY = evVar.nY();
                if (nY != null) {
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, nY.FC());
                    jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, Long.valueOf(nY.ui()));
                    jSONObject.put("video_url", nY.du());
                    jSONObject.put("player_type", os.nGm());
                    jSONObject.put("video_encode_type", os.nn() ? 1 : 0);
                }
                JSONObject jSONObject2 = os.eli() ? new JSONObject(os.Os().toString()) : null;
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if (eliVar != null) {
                    jSONObject2.put("surface_texture_updated", eliVar.Dfc() ? 1 : 0);
                }
                jSONObject.put("pag_json_data", jSONObject2.toString());
                jSONObject.put("dp_creative_type", evVar.MKR());
                return jSONObject;
            }
        } catch (JSONException e) {
            Xb.eli("TTAD.VideoEventManager", "", e);
        }
        return jSONObject;
    }

    public static void eli(com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli<aAs> eliVar) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("load_video_error", eliVar);
    }

    public static void DbA(com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli<FC> eliVar) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("load_video_cancel", eliVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:4|(1:6)(2:23|(10:25|8|9|10|(1:12)|13|14|(1:16)|17|18)(1:26))|7|8|9|10|(0)|13|14|(0)|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        com.bytedance.sdk.component.utils.Xb.eli("TTAD.VideoEventManager", "", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[Catch: JSONException -> 0x0056, TryCatch #0 {JSONException -> 0x0056, blocks: (B:10:0x0041, B:12:0x0045, B:13:0x004c), top: B:9:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void eli(ev evVar, com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Os os) {
        int i;
        int i2;
        if (evVar == null || eliVar == null || os == null) {
            return;
        }
        String eli2 = gG.eli();
        if (os.gG()) {
            i = 3;
        } else {
            if (CacheDirFactory.getICacheDir(evVar.Sz()).eli(os)) {
                i2 = 1;
                eli.put(eliVar, new Dfc(SystemClock.elapsedRealtime(), eli2, i2, os, evVar));
                JSONObject eli3 = eli(evVar, eli2, i2, os);
                String eli4 = dZ.eli(evVar);
                if (os.ui > 0) {
                    eli3.put("play_time", os.ui);
                }
                eli3.put("is_mute", os.du() ? 1 : 0);
                com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(evVar, eli4, eli3, null);
                eliVar2.eli(os.nGm() == -1);
                eli(eliVar2, "play_start");
            }
            i = 2;
        }
        i2 = i;
        eli.put(eliVar, new Dfc(SystemClock.elapsedRealtime(), eli2, i2, os, evVar));
        JSONObject eli32 = eli(evVar, eli2, i2, os);
        String eli42 = dZ.eli(evVar);
        if (os.ui > 0) {
        }
        eli32.put("is_mute", os.du() ? 1 : 0);
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar22 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(evVar, eli42, eli32, null);
        eliVar22.eli(os.nGm() == -1);
        eli(eliVar22, "play_start");
    }

    public static void eli(Context context, com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2, kb kbVar) {
        Dfc dfc;
        if (context == null || eliVar == null || eliVar2 == null || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        if (!eliVar2.du()) {
            eli(ui, aGH, eliVar2);
        }
        wC wCVar = new wC();
        wCVar.eli(eliVar2.nlS() ? 1 : 0);
        wCVar.DbA(CacheDirFactory.getICacheDir(ui.Sz()).DbA(aGH));
        wCVar.eli(SystemClock.elapsedRealtime() - dfc.eli());
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (JSONException e) {
                Xb.eli("TTAD.VideoEventManager", "", e);
            }
        }
        JSONObject jSONObject = null;
        jSONObject = null;
        String optString = eli2.optString("pag_json_data", null);
        if (!TextUtils.isEmpty(optString)) {
            try {
                jSONObject = new JSONObject(optString);
            } catch (JSONException e2) {
                Xb.eli("TTAD.VideoEventManager", "", e2);
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("is_received_video_not_playing_info", eliVar2.nn() ? 1 : 0);
            eli2.put("pag_json_data", jSONObject.toString());
        } catch (JSONException e3) {
            Xb.eli("TTAD.VideoEventManager", "", e3);
        }
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, wCVar);
        eliVar3.eli(eliVar2.du());
        eli(eliVar3, "feed_play", kbVar);
    }

    public static void eli(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2) {
        Dfc dfc;
        if (eliVar == null || eliVar2 == null || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long DbA = eliVar2.DbA();
        long aGH2 = eliVar2.aGH();
        if (aGH2 <= 0 || DbA <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.kb kbVar = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.kb();
        kbVar.eli(eliVar2.Os());
        kbVar.DbA(aGH2);
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (Throwable th) {
                Xb.eli("TTAD.VideoEventManager", "", th);
            }
        }
        eli(eliVar2, ui, eli2);
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, kbVar);
        eliVar3.eli(eliVar2.du());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", DbA);
            jSONObject.put("percent", eliVar2.kb());
            eli(eliVar3, "feed_pause", jSONObject);
        } catch (JSONException e) {
            Xb.eli("TTAD.VideoEventManager", "", e);
        }
    }

    private static void eli(Dfc.eli eliVar, ev evVar, JSONObject jSONObject) {
        if (evVar != null) {
            try {
                if (evVar.CI() != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("speed_type", evVar.CI().DbA());
                    jSONObject2.put("speed", evVar.CI().eli());
                    jSONObject2.put("speed_duration", eliVar.eli());
                    jSONObject.put("pag_json_data", jSONObject2.toString());
                }
            } catch (Throwable th) {
                Xb.eli("TTAD.VideoEventManager", "", th);
            }
        }
    }

    public static void DbA(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2) {
        Dfc dfc;
        if (eliVar == null || eliVar2 == null || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long DbA = eliVar2.DbA();
        long aGH2 = eliVar2.aGH();
        if (aGH2 <= 0 || DbA <= 0) {
            return;
        }
        ui uiVar = new ui();
        uiVar.eli(eliVar2.Os());
        uiVar.DbA(aGH2);
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (JSONException e) {
                Xb.eli("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, uiVar);
        eliVar3.eli(eliVar2.du());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", DbA);
            jSONObject.put("percent", eliVar2.kb());
            eli(eliVar3, "feed_continue", jSONObject);
        } catch (JSONException e2) {
            Xb.eli("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void Os(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2) {
        Dfc dfc;
        if (eliVar == null || eliVar2 == null || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long DbA = eliVar2.DbA();
        long aGH2 = eliVar2.aGH();
        nn nnVar = new nn(eliVar2.NU());
        nnVar.eli(eliVar2.Os());
        nnVar.DbA(aGH2);
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (JSONException e) {
                Xb.eli("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, nnVar);
        eliVar3.eli(eliVar2.du());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", DbA);
            jSONObject.put("percent", eliVar2.kb());
            eli(eliVar3, "play_error", jSONObject);
        } catch (JSONException e2) {
            Xb.eli("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void aGH(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2) {
        Dfc dfc;
        if (eliVar == null || eliVar2 == null || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long DbA = eliVar2.DbA();
        long aGH2 = eliVar2.aGH();
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.DbA dbA = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.DbA();
        dbA.eli(eliVar2.Os());
        dbA.DbA(aGH2);
        dbA.eli(eliVar2.ui());
        dbA.DbA(eliVar2.MGA());
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2), dbA);
        eliVar3.eli(eliVar2.du());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", DbA);
            jSONObject.put("percent", eliVar2.kb());
            eli(eliVar3, "endcard_skip", jSONObject);
        } catch (JSONException e) {
            Xb.eli("TTAD.VideoEventManager", "", e);
        }
        eli.remove(eliVar);
    }

    public static void eli(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2, kb kbVar) {
        if (eliVar == null || eliVar2 == null) {
            return;
        }
        ui(eliVar, eliVar2);
        Dfc dfc = eli.get(eliVar);
        if (dfc == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long DbA = eliVar2.DbA();
        long aGH2 = eliVar2.aGH();
        aGH agh = new aGH();
        agh.DbA(eliVar2.Os());
        agh.eli(aGH2);
        agh.eli(eliVar2.wC());
        agh.DbA(eliVar2.FC());
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (JSONException e) {
                Xb.eli("TTAD.VideoEventManager", "", e);
            }
        }
        eli(eliVar2, ui, eli2);
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, agh);
        eliVar3.eli(eliVar2.du());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", DbA);
            jSONObject.put("percent", eliVar2.kb());
            eli(eliVar3, "feed_break", jSONObject, kbVar);
        } catch (JSONException e2) {
            Xb.eli("TTAD.VideoEventManager", "", e2);
        }
    }

    public static void DbA(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2, kb kbVar) {
        if (eliVar == null || eliVar2 == null) {
            return;
        }
        ui(eliVar, eliVar2);
        Dfc dfc = eli.get(eliVar);
        if (dfc == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long DbA = eliVar2.DbA();
        long aGH2 = eliVar2.aGH();
        MGA mga = new MGA();
        mga.DbA(eliVar2.Os());
        mga.eli(aGH2);
        mga.eli(eliVar2.FC());
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (JSONException e) {
                Xb.eli("TTAD.VideoEventManager", "", e);
            }
        }
        eli(eliVar2, ui, eli2);
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, mga);
        eliVar3.eli(eliVar2.du());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("duration", DbA);
            jSONObject.put("percent", eliVar2.kb());
            eli(eliVar3, "feed_over", jSONObject, kbVar);
        } catch (JSONException e2) {
            Xb.eli("TTAD.VideoEventManager", "", e2);
        }
        eli.remove(eliVar);
    }

    public static void eli(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, boolean z, String str) {
        Dfc dfc;
        if (eliVar == null || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, null);
        try {
            if (aGH.ui > 0) {
                eli2.put("play_time", aGH.ui);
            }
            eli2.put("is_mute", z ? 1 : 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.MessagePayloadKeys.FROM, str);
            eli2.put("pag_json_data", jSONObject);
        } catch (JSONException e) {
            Xb.eli("TTAD.VideoEventManager", "", e);
        }
        eli(new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, null), "mute_state_change");
    }

    public static void ui(com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, Dfc.eli eliVar2) {
        Dfc dfc;
        if (eliVar == null || eliVar2 == null || eliVar2.aAs() <= 0 || (dfc = eli.get(eliVar)) == null) {
            return;
        }
        Os aGH = dfc.aGH();
        ev ui = dfc.ui();
        if (aGH == null || ui == null) {
            return;
        }
        long aGH2 = eliVar2.aGH();
        NU nu = new NU();
        nu.eli(eliVar2.Os());
        nu.DbA(aGH2);
        nu.eli(eliVar2.aAs());
        JSONObject eli2 = eli(ui, dfc.DbA(), dfc.Os(), aGH, eliVar2);
        if (aGH.ui > 0) {
            try {
                eli2.put("play_time", aGH.ui);
            } catch (JSONException e) {
                Xb.eli("TTAD.VideoEventManager", "", e);
            }
        }
        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli(ui, dZ.eli(ui), eli2, nu);
        eliVar3.eli(eliVar2.du());
        eli(eliVar3, "play_buffer");
    }

    private static void eli(com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar, String str) {
        eli(eliVar, str, (JSONObject) null, (kb) null);
    }

    private static void eli(com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar, String str, JSONObject jSONObject) {
        eli(eliVar, str, jSONObject, (kb) null);
    }

    private static void eli(com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar, String str, kb kbVar) {
        eli(eliVar, str, (JSONObject) null, kbVar);
    }

    private static void eli(final com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli eliVar, String str, final JSONObject jSONObject, final kb kbVar) {
        if (eliVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (eliVar.ui() && !TextUtils.isEmpty(eliVar.DbA())) {
            String DbA = eliVar.DbA();
            DbA.hashCode();
            if (DbA.equals("stream") || DbA.equals("embeded_ad")) {
                str = "customer_".concat(String.valueOf(str));
            }
        }
        final String str2 = str;
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), eliVar.eli(), eliVar.DbA(), str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                kb kbVar2;
                try {
                    JSONObject Os = com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli.this.Os();
                    if (com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli.this.aGH() != null) {
                        com.bytedance.sdk.openadsdk.aGH.ui.DbA.eli.this.aGH().eli(Os);
                    }
                    if (("feed_play".equals(str2) || "feed_over".equals(str2) || "feed_break".equals(str2)) && (kbVar2 = kbVar) != null) {
                        kbVar2.eli(Os);
                    }
                    jSONObject.put("ad_extra_data", Os.toString());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    private static void eli(final ev evVar, final Os os, final Dfc.eli eliVar) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli();
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("pangle_video_play_state", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", eli.Os(Os.this));
                jSONObject.put("player_duration", eliVar.aGH());
                jSONObject.put("cache_path_type", CacheDirFactory.getCacheType());
                jSONObject.put("url", Os.this.aqO());
                jSONObject.put("path", eli.aGH(Os.this));
                jSONObject.put("player_type", Os.this.nGm());
                com.bytedance.sdk.openadsdk.Dfc.eli.aGH eli2 = com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("pangle_video_play_state");
                ev evVar2 = evVar;
                return eli2.eli(evVar2 != null ? evVar2.cK() : 0).DbA(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long Os(Os os) {
        if (os == null) {
            return 0L;
        }
        DbA Vy = os.nn() ? os.Vy() : os.ev();
        if (Vy != null) {
            return Double.valueOf(Vy.MGA() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String aGH(Os os) {
        return new File(os.ui(), os.dV()).getAbsolutePath();
    }
}
