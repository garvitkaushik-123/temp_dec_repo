package com.bytedance.sdk.openadsdk.core.FC;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ui;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.ironsource.C3251pc;
import com.ironsource.Y1;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    private static boolean eli = false;

    public static void eli() {
        if (!eli && dV.aGH().FS()) {
            DbA.DbA();
            eli = DbA.DbA().Os();
        }
    }

    public static void eli(String str) {
        if (dV.aGH().FS()) {
            DbA.DbA().eli(str);
        }
    }

    public static void DbA(String str) {
        if (TextUtils.isEmpty(str) || !dV.aGH().FS()) {
            return;
        }
        DbA.DbA().DbA(str);
    }

    public static void DbA() {
        if (dV.aGH().FS()) {
            DbA.DbA().eli();
        }
    }

    public static void eli(ev evVar, String str) {
        long j;
        long j2;
        long j3;
        Object obj;
        if (dV.aGH().FS()) {
            HashMap hashMap = new HashMap();
            hashMap.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            hashMap.put("au_show", str);
            if (evVar != null) {
                String fO = evVar.fO();
                boolean isEmpty = TextUtils.isEmpty(fO);
                String str2 = Y1.f;
                if (!isEmpty) {
                    hashMap.put("request_id", fO);
                } else {
                    hashMap.put("request_id", Y1.f);
                }
                try {
                    long j4 = -1;
                    if (evVar.sIY() != null) {
                        j = evVar.sIY().optLong("ad_id", -1L);
                        j2 = evVar.sIY().optLong("rit", -1L);
                        j3 = evVar.sIY().optLong("ad_slot_type", -1L);
                        str2 = evVar.sIY().optString("ad_type", Y1.f);
                    } else {
                        j = -1;
                        j2 = -1;
                        j3 = -1;
                    }
                    hashMap.put("ad_id", Long.valueOf(j));
                    hashMap.put("rit", Long.valueOf(j2));
                    hashMap.put("ad_slot_type", Long.valueOf(j3));
                    hashMap.put("ad_type", str2);
                    Map<String, Object> FYe = evVar.FYe();
                    if (FYe != null && (obj = FYe.get(TTAdConstant.SDK_BIDDING_TYPE)) != null) {
                        j4 = Long.parseLong(obj.toString());
                    }
                    hashMap.put(TTAdConstant.SDK_BIDDING_TYPE, Long.valueOf(j4));
                    DbA.DbA().eli(PglSSManager.REPORT_SCENE_ADSHOW, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static Map<String, String> eli(String str, String str2) {
        if (dV.aGH().FS()) {
            return DbA.DbA().eli(str, str2 != null ? str2.getBytes() : new byte[0]);
        }
        return new HashMap();
    }

    public static String Os() {
        if (dV.aGH().FS()) {
            return DbA.DbA().ui();
        }
        return "";
    }

    public static long aGH() {
        if (dV.aGH().FS()) {
            return DbA.DbA().MGA();
        }
        return 0L;
    }

    public static int ui() {
        if (dV.aGH().FS()) {
            return DbA.DbA().kb();
        }
        return 6;
    }

    public static void eli(MotionEvent motionEvent) {
        if (dV.aGH().FS()) {
            DbA.DbA().eli(motionEvent);
        }
    }

    public static void eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (dV.aGH().FS()) {
                eli();
                if (ui() == 0) {
                    jSONObject.put("sec_did", DbA.DbA().aGH());
                    String eli2 = ui.eli(jSONObject.toString());
                    Map<String, String> eli3 = DbA.DbA().eli("https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250", eli2 != null ? eli2.getBytes() : new byte[0]);
                    if (eli3 != null && eli3.size() > 0) {
                        for (String str : eli3.keySet()) {
                            jSONObject.put(str, eli3.get(str));
                        }
                        jSONObject.put("url", "https://api16-access-sg.pangle.io/api/ad/union/sdk/get_ads/?aid=1371&device_platform=android&version_code=4250");
                        jSONObject.put("pangle_m", eli2);
                    } else {
                        jSONObject.put("pglx", "8");
                    }
                    jSONObject.put("ec", DbA.DbA().MGA());
                    return;
                }
                jSONObject.put("pglx", String.valueOf(ui()));
                return;
            }
            jSONObject.put("pglx", "6");
        } catch (Throwable th) {
            Xb.Os("SecSdkHelperUtil", th.getMessage());
            try {
                jSONObject.put("pglx", C3251pc.e);
            } catch (JSONException unused) {
            }
        }
    }

    public static String MGA() {
        if (dV.aGH().FS()) {
            return DbA.DbA().aGH();
        }
        return null;
    }
}
