package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.DbA;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity;
import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageLink2Activity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.multipro.DbA.eli;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Cp {
    private static boolean eli = false;

    public static void eli(boolean z) {
        eli = z;
    }

    private static com.bytedance.sdk.openadsdk.Dfc.eli.DbA eli(int i, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        com.bytedance.sdk.openadsdk.Dfc.eli.DbA dbA = new com.bytedance.sdk.openadsdk.Dfc.eli.DbA();
        dbA.eli(DbA.eli.eli);
        dbA.eli(evVar);
        dbA.DbA(dZ.eli(evVar));
        dbA.eli(i);
        dbA.eli(false);
        dbA.DbA(evVar.yw());
        return dbA;
    }

    public static boolean eli(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.Os.eli eliVar, String str, com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga, boolean z, int i2) {
        String eli2;
        com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(-1, evVar));
        if (context == null || evVar == null || i == -1) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(1, evVar));
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.NU Eh = evVar.Eh();
        HashMap hashMap = new HashMap();
        if (evVar.MKR() == 0) {
            hashMap.put("dpl_probability_jump", Boolean.valueOf(i2 >= 11));
        }
        if (i2 != 0 && evVar.Kv()) {
            hashMap.put("dsp_click_type", Integer.valueOf(i2));
        }
        if (Eh != null && !TextUtils.isEmpty(Eh.eli())) {
            if (eli(context, evVar, i, str, z, hashMap)) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(2, evVar));
                com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
                return true;
            }
            if (Eh.Os() != 2 || evVar.GR() == 5 || evVar.GR() == 15) {
                if (Eh.Os() == 1 && !TextUtils.isEmpty(Eh.DbA())) {
                    eli2 = Eh.DbA();
                } else {
                    eli2 = eli(evVar);
                }
            } else if (mga != null) {
                if (!mga.eli(evVar)) {
                    if (mga.aGH(evVar)) {
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "open_fallback_url", hashMap);
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(3, evVar));
                        com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
                        return true;
                    }
                    eli2 = eli(Eh, evVar);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(3, evVar));
                } else {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "open_fallback_url", hashMap);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(3, evVar));
                    com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
                    return true;
                }
            } else {
                eli2 = eli(Eh, evVar);
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "open_fallback_url", hashMap);
        } else {
            eli2 = eli(evVar);
        }
        String str2 = eli2;
        new Object[]{"url is：", str2};
        if (evVar.MKR() == 0 && !TextUtils.isEmpty(str2) && str2.contains("play.google.com/store")) {
            String substring = str2.substring(str2.indexOf("?id=") + 4);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(4, evVar));
            boolean eli3 = com.bytedance.sdk.openadsdk.QX.eli.eli.aGH.eli(context, str2, substring, str, evVar);
            if (eli3) {
                com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
            }
            return eli3;
        }
        boolean eli4 = eli(context, evVar, i, pAGNativeAd, eliVar, str, z, str2);
        if (eli4) {
            com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
        }
        return eli4;
    }

    private static String eli(com.bytedance.sdk.openadsdk.core.model.NU nu, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (!TextUtils.isEmpty(nu.DbA())) {
            return nu.DbA();
        }
        return eli(evVar);
    }

    private static String eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (!evVar.Kv() || evVar.io() == null) {
            return evVar.dM();
        }
        return evVar.io().FC();
    }

    public static boolean eli(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, String str, boolean z, Map<String, Object> map) {
        if (evVar == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.NU Eh = evVar.Eh();
        if (Eh == null || TextUtils.isEmpty(Eh.eli())) {
            aGH.eli(evVar, str, Eh == null ? -1 : -2, Eh != null ? Eh.aGH() : null);
            return false;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, Object> map2 = map;
        String eli2 = Eh.eli();
        if (com.bytedance.sdk.openadsdk.QX.eli.eli.Os.eli()) {
            return com.bytedance.sdk.openadsdk.QX.eli.eli.Os.eli(context, eli2, evVar, i, map2, z);
        }
        Uri parse = Uri.parse(eli2);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        if (dZ.aGH(context)) {
            dZ.DbA eli3 = dZ.eli(context, intent);
            if (eli3.DbA > 0) {
                if (dV.aGH().wC()) {
                    dZ.eli(evVar, str);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                map2.put("can_query_install", 1);
                map2.put("matched_count", Integer.valueOf(eli3.DbA));
                map2.put("url", eli2);
                if (eli3.eli != null) {
                    intent.setComponent(eli3.eli);
                }
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "open_url_app", map2);
                try {
                    context.startActivity(intent);
                    com.bytedance.sdk.openadsdk.aGH.NU.eli().eli(map2).eli(evVar, str);
                    com.bytedance.sdk.openadsdk.aGH.Os.eli("dp_start_act_success", evVar, str, map2);
                    return true;
                } catch (Exception e) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception", e.getMessage());
                        jSONObject.put("intent", intent.toString());
                        jSONObject.put("can_query_install", 1);
                    } catch (Exception unused) {
                    }
                    aGH.eli(evVar, str, -4, jSONObject);
                    if (!dV.aGH().wC()) {
                        eli(context, evVar.dM(), evVar, i, str, z);
                    }
                    return false;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("intent", intent.toString());
                jSONObject2.put("can_query_install", 1);
            } catch (Exception unused2) {
            }
            aGH.eli(evVar, str, -3, jSONObject2);
        } else {
            try {
                if (dV.aGH().wC()) {
                    dZ.eli(evVar, str);
                }
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                map2.put("can_query_install", 0);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "open_url_app", map2);
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.aGH.NU.eli().eli(map2).eli(evVar, str);
                return true;
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static boolean eli(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.Os.eli eliVar, String str, boolean z, String str2) {
        if (!TextUtils.isEmpty(str2) || com.bytedance.sdk.openadsdk.core.model.KM.DbA(evVar)) {
            int yw = evVar.yw();
            if (yw == 2 || yw == 8) {
                return com.bytedance.sdk.openadsdk.utils.CMM.eli(context, str2, evVar, DbA.eli.eli);
            }
            com.bytedance.sdk.component.utils.DbA.eli(context, eli(context, str2, evVar, i, pAGNativeAd, eliVar, str, z), null);
            eli = false;
            return true;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(5, evVar));
        return false;
    }

    public static void eli(Context context, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, String str2, boolean z) {
        com.bytedance.sdk.component.utils.DbA.eli(context, eli(context, str, evVar, i, (PAGNativeAd) null, (com.bytedance.sdk.openadsdk.core.Os.eli) null, str2, z), null);
    }

    public static void eli(Context context, String str, final com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, final String str2, boolean z, QX qx) {
        com.bytedance.sdk.component.utils.DbA.eli(context, eli(context, str, evVar, i, null, null, str2, z, true, qx), new DbA.InterfaceC0150DbA() { // from class: com.bytedance.sdk.openadsdk.core.Cp.1
            @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
            public void eli() {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(com.bytedance.sdk.openadsdk.core.model.ev.this, str2, 3, (JSONObject) null);
            }

            @Override // com.bytedance.sdk.component.utils.DbA.InterfaceC0150DbA
            public void eli(Throwable th) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(com.bytedance.sdk.openadsdk.core.model.ev.this, str2, -2, (JSONObject) null);
            }
        });
    }

    private static Intent eli(Context context, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.Os.eli eliVar, String str2, boolean z) {
        return eli(context, str, evVar, i, pAGNativeAd, eliVar, str2, z, false, null);
    }

    public static boolean eli(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("click_countdown_remaining", i2);
            com.bytedance.sdk.openadsdk.aGH.Os.wC(evVar, str, jSONObject);
            Intent eli2 = eli(context, evVar, str, i);
            if (eli2 == null) {
                return false;
            }
            return com.bytedance.sdk.component.utils.DbA.eli(context, eli2, null, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Intent eli(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, int i) {
        if (context == null || evVar == null || !com.bytedance.sdk.openadsdk.core.model.KM.DbA(evVar)) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
        intent.putExtra("ad_pending_download", false);
        String nlS = com.bytedance.sdk.openadsdk.core.model.KM.nlS(evVar);
        if (!TextUtils.isEmpty(nlS)) {
            if (nlS.contains("?")) {
                nlS = nlS + "&orientation=portrait";
            } else {
                nlS = nlS + "?orientation=portrait";
            }
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            intent.putExtra("url", nlS);
            intent.putExtra("event_tag", str);
            intent.putExtra("source", i);
            intent.putExtra("gecko_id", evVar.QxD());
            intent.putExtra("web_title", evVar.Pf());
            intent.putExtra("adid", evVar.umh());
            intent.putExtra("log_extra", evVar.eu());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, evVar.iOb().toString());
            return intent;
        }
        evVar.ui(nlS);
        evVar.MGA(str);
        evVar.DbA(i);
        intent.putExtra("meta_index", Ue.eli().eli(evVar));
        return intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent eli(Context context, String str, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i, PAGNativeAd pAGNativeAd, com.bytedance.sdk.openadsdk.core.Os.eli eliVar, String str2, boolean z, boolean z2, QX qx) {
        Intent intent;
        if (!z2 && com.bytedance.sdk.openadsdk.core.model.KM.DbA(evVar) && (pAGNativeAd != 0 || eliVar != null)) {
            intent = new Intent(context, (Class<?>) TTPlayableLandingPageActivity.class);
            boolean eli2 = eli(evVar, z);
            intent.putExtra("ad_pending_download", eli2);
            String nlS = com.bytedance.sdk.openadsdk.core.model.KM.nlS(evVar);
            if (!TextUtils.isEmpty(nlS)) {
                if (nlS.contains("?")) {
                    str = nlS + "&orientation=portrait";
                } else {
                    str = nlS + "?orientation=portrait";
                }
            }
            evVar.DbA(eli2);
        } else if (!z2 && evVar.yw() == 3 && ((evVar.mm() == 2 || (evVar.mm() == 1 && eli)) && !evVar.tEU())) {
            intent = new Intent(context, (Class<?>) TTVideoLandingPageLink2Activity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTLandingPageActivity.class);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            intent.putExtra("url", str);
            intent.putExtra("event_tag", str2);
            intent.putExtra("source", i);
            intent.putExtra("gecko_id", evVar.QxD());
            if (!z2 || qx == null) {
                intent.putExtra("web_title", evVar.Pf());
            } else {
                intent.putExtra("web_title", qx.DbA());
                intent.putExtra("only_loading", qx.eli());
            }
            intent.putExtra("adid", evVar.umh());
            intent.putExtra("log_extra", evVar.eu());
            intent.putExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA, evVar.iOb().toString());
        } else {
            if (z2 && qx != null) {
                evVar.Xb(qx.DbA());
                evVar.eli(qx.eli());
            }
            evVar.ui(str);
            evVar.MGA(str2);
            evVar.DbA(i);
            intent.putExtra("meta_index", Ue.eli().eli(evVar));
        }
        if (evVar.GR() == 5 || evVar.GR() == 15 || evVar.GR() == 50) {
            com.bytedance.sdk.openadsdk.multipro.DbA.eli eliVar2 = null;
            if (pAGNativeAd != 0) {
                if (pAGNativeAd instanceof eli.InterfaceC0210eli) {
                    eliVar2 = ((eli.InterfaceC0210eli) pAGNativeAd).MGA();
                } else if (pAGNativeAd instanceof com.bytedance.sdk.openadsdk.eli.DbA.eli.DbA) {
                    eliVar2 = ((com.bytedance.sdk.openadsdk.eli.DbA.eli.DbA) pAGNativeAd).DbA();
                }
                if (eliVar2 != null) {
                    intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, eliVar2.eli().toString());
                }
            }
            if (eliVar != null && eliVar.DbA() && (eliVar2 = eliVar.Os()) != null) {
                intent.putExtra(TTAdConstant.MULTI_PROCESS_DATA, eliVar2.eli().toString());
            }
            if (eliVar2 != null) {
                intent.putExtra("video_is_auto_play", eliVar2.aGH);
                if (com.bytedance.sdk.component.utils.Dfc.aGH()) {
                    eliVar2.eli().toString();
                }
            }
        }
        return intent;
    }

    private static boolean eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, boolean z) {
        if (z && evVar != null && evVar.yw() == 4) {
            return com.bytedance.sdk.openadsdk.core.model.KM.DbA(evVar);
        }
        return false;
    }
}
