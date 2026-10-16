package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.GB;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.VM;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.inmobi.sdk.InMobiSdk;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.mbridge.msdk.MBridgeConstans;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du extends com.bytedance.sdk.component.wC.wC {
    private final aAs DbA;
    private final Set<ui> Os;
    private final eli eli;

    public interface eli {
        void eli(boolean z);
    }

    public du(eli eliVar, aAs aas, ui... uiVarArr) {
        super("SetF");
        HashSet hashSet = new HashSet();
        this.Os = hashSet;
        this.eli = eliVar;
        this.DbA = aas;
        hashSet.addAll(Arrays.asList(uiVarArr));
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d("TTAD.SdkSettingsFetch", "Start Try");
        int eli2 = ujq.eli(dV.eli(), 0L);
        if (eli2 == 0) {
            Log.d("TTAD.SdkSettingsFetch", "No net");
            this.eli.eli(false);
            return;
        }
        JSONObject eli3 = eli(eli2);
        com.bytedance.sdk.component.kb.DbA.aGH DbA = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
        try {
            DbA.DbA(com.bytedance.sdk.openadsdk.wC.aGH.eli(DbA, dZ.eli("/api/ad/union/sdk/settings/", false, true)));
            DbA.DbA("User-Agent", dZ.aGH());
        } catch (Exception unused) {
        }
        String jSONObject = DbA(eli3).toString();
        if (dV.aGH().Za() && GB.eli().aGH() == 1) {
            dZ.eli("Pangle_Debug_Mode", jSONObject, dV.eli());
        }
        DbA.eli(jSONObject, dV.aGH().Dfc());
        DbA.eli(6);
        DbA.eli("setting");
        com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.settings.du.1
            @Override // com.bytedance.sdk.openadsdk.dV.aGH
            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                eliVar.DbA("settings_fetch");
                return eliVar;
            }
        });
        DbA.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.settings.du.2
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                JSONObject jSONObject2;
                int optInt;
                int eli4 = dbA.eli();
                String aGH = dbA.aGH();
                if (dV.aGH().Za() && GB.eli().aGH() == 1) {
                    dZ.eli("Pangle_Debug_Mode", aGH, dV.eli());
                }
                if (dbA.MGA() && !TextUtils.isEmpty(aGH)) {
                    String str = null;
                    try {
                        jSONObject2 = new JSONObject(aGH);
                    } catch (JSONException unused2) {
                        jSONObject2 = null;
                    }
                    if (jSONObject2 != null && (optInt = jSONObject2.optInt("cypher", -1)) != -1) {
                        if (optInt == 3) {
                            str = com.bytedance.sdk.component.utils.eli.Os(jSONObject2.optString(PglCryptUtils.KEY_MESSAGE));
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    jSONObject2 = new JSONObject(str);
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                        try {
                            du.this.eli(str, dbA.Os());
                        } catch (Throwable unused4) {
                        }
                        try {
                            du.this.eli(jSONObject2);
                            dV.aGH().eli(System.currentTimeMillis());
                            com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.settings.du.2.1
                                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                    eliVar.DbA("settings_fetch");
                                    return eliVar;
                                }
                            });
                            bf.DbA();
                        } catch (Throwable unused5) {
                        }
                        du.this.eli.eli(true);
                        return;
                    }
                } else {
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.settings.du.2.2
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            eliVar.DbA("settings_fetch");
                            return eliVar;
                        }
                    });
                    if (os != null) {
                        bf.eli(os.aGH());
                    }
                }
                if (!dbA.MGA()) {
                    com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("settings_fetch", os.aGH(), eli4, dbA.DbA());
                }
                du.this.eli.eli(false);
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                du.this.eli.eli(false);
                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.settings.du.2.3
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar.DbA("settings_fetch");
                        return eliVar;
                    }
                });
                if (os != null) {
                    bf.eli(os.aGH());
                    com.bytedance.sdk.openadsdk.Dfc.eli.ui.eli("settings_fetch", os.aGH(), -1, iOException != null ? iOException.getMessage() : null);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.du.DbA(com.bytedance.sdk.openadsdk.core.nlS.eli(dV.eli()));
        DeviceUtils.nlS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap hashMap = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        hashMap.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                String str2 = (String) hashMap.get("active-control");
                if (str2 != null) {
                    int parseInt = Integer.parseInt(str2);
                    String str3 = (String) hashMap.get("ts");
                    if (str3 != null) {
                        long parseLong = Long.parseLong(str3);
                        String str4 = (String) hashMap.get("pst");
                        String eli2 = com.bykv.vk.openvk.eli.eli.eli.kb.DbA.eli(str + parseInt + parseLong);
                        if (eli2 != null) {
                            if (eli2.equalsIgnoreCase(str4)) {
                                i = parseInt;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        FC.eli(i);
    }

    public static JSONObject eli(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            MGA aGH = dV.aGH();
            jSONObject.put(N6.B, Build.MODEL);
            jSONObject.put("device_city", dZ.ev());
            com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(jSONObject);
            jSONObject.put(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, com.bytedance.sdk.openadsdk.core.FC.DbA().aAs());
            jSONObject.put("pa_consent", com.bytedance.sdk.openadsdk.core.FC.DbA().du());
            if (aGH.ujq("mcc")) {
                jSONObject.put("mcc", VM.DbA());
            }
            Context eli2 = dV.eli();
            jSONObject.put("conn_type", dZ.kb(i));
            jSONObject.put(N6.F, 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("aos_api_level", Build.VERSION.SDK_INT);
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, BuildConfig.VERSION_NAME);
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.nlS.DbA());
            jSONObject.put("time_zone", dZ.ujq());
            jSONObject.put("package_name", dZ.MGA());
            jSONObject.put(C3040d4.h.L, dZ.eli() ? 1 : 2);
            jSONObject.put(BidTokenRepositoryKt.APP_VERSION, dZ.wC());
            jSONObject.put(VastAttributes.VENDOR, Build.MANUFACTURER);
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.nlS.Os(eli2));
            String aGH2 = com.bytedance.sdk.openadsdk.core.FC.DbA().aGH();
            if (aGH2 != null) {
                jSONObject.put(MBridgeConstans.APP_ID, aGH2);
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", currentTimeMillis);
            String str = "";
            if (aGH2 != null) {
                str = aGH2.concat(String.valueOf(currentTimeMillis)).concat(BuildConfig.VERSION_NAME);
            }
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ui.eli(str));
            jSONObject.put("tcstring", NU.Os(eli2));
            jSONObject.put("tcf_gdpr", NU.DbA(eli2));
            jSONObject.put("lmt", DeviceUtils.Os());
            jSONObject.put("locale_language", DeviceUtils.aGH());
            jSONObject.put("channel", C3040d4.h.Z);
            JSONObject ui = aGH.ui();
            if (ui != null) {
                jSONObject.put("digest", ui);
            }
            jSONObject.put("data_time", aGH.MGA());
            jSONObject.put("app_set_id_scope", aGH.DbA());
            jSONObject.put("app_set_id", aGH.Os());
            jSONObject.put("installed_source", aGH.aGH());
            if (aGH.ujq("gaid")) {
                jSONObject.put("did", com.bytedance.sdk.openadsdk.core.nlS.eli(dV.eli()));
            }
            jSONObject.put("gaid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
            String kb = com.bytedance.sdk.openadsdk.core.FC.DbA().kb();
            if (!TextUtils.isEmpty(kb)) {
                jSONObject.put("mediation", kb);
            }
            jSONObject.put(C3040d4.h.G, DeviceUtils.eli(eli2, true));
            jSONObject.put("adx_id", com.bytedance.sdk.openadsdk.core.FC.DbA().Vy());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject DbA(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.eli.eli(jSONObject);
    }

    public boolean eli(JSONObject jSONObject) {
        this.DbA.eli(jSONObject);
        for (ui uiVar : this.Os) {
            if (uiVar != null) {
                uiVar.eli(jSONObject);
            }
        }
        return this.DbA.Os;
    }

    public static boolean eli() {
        return BinderPoolService.eli;
    }
}
