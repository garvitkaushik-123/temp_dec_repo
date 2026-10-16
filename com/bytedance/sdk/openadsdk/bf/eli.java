package com.bytedance.sdk.openadsdk.bf;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.component.utils.wC;
import com.bytedance.sdk.openadsdk.CMM.Os;
import com.bytedance.sdk.openadsdk.CMM.aGH;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.FC.DbA;
import com.bytedance.sdk.openadsdk.core.Vy;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.core.settings.du;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.mediationsdk.metadata.a;
import com.mbridge.msdk.MBridgeConstans;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public static String DbA;
    private static volatile Os Os;
    public static final ConcurrentHashMap<String, Object> eli = new ConcurrentHashMap<>();

    public static Os eli(final Context context, final String str) {
        if (Os == null) {
            synchronized (eli.class) {
                if (Os == null) {
                    try {
                        Os os = new Os(new aGH() { // from class: com.bytedance.sdk.openadsdk.bf.eli.1
                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public ExecutorService eli() {
                                return cyF.ui();
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public Context DbA() {
                                Context context2 = context;
                                return context2 != null ? context2 : dV.eli();
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public String Os() {
                                return "pag_adn_strategy_center";
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public Handler aGH() {
                                return nn.DbA();
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public String ui() {
                                String eli2 = dZ.eli("/api/ad/union/sdk/strategies/adn", false, true);
                                eli.DbA = eli2;
                                return eli2;
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public JSONObject MGA() {
                                try {
                                    JSONObject eli2 = du.eli(ujq.eli(dV.eli(), 0L));
                                    if (!eli2.has(MBridgeConstans.APP_ID)) {
                                        if (!TextUtils.isEmpty(str)) {
                                            eli2.put(MBridgeConstans.APP_ID, str);
                                        } else {
                                            if (TextUtils.isEmpty(FC.DbA().aGH())) {
                                                return null;
                                            }
                                            eli2.put(MBridgeConstans.APP_ID, FC.DbA().aGH());
                                        }
                                    }
                                    return com.bytedance.sdk.component.utils.eli.eli(eli2);
                                } catch (Throwable th) {
                                    Xb.Os("StrategyUtils", th.getMessage());
                                    return null;
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public Map<String, String> kb() {
                                HashMap hashMap = new HashMap();
                                hashMap.put("User-Agent", dZ.aGH());
                                String DbA2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
                                if (!DbA2.isEmpty()) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("ipv6", DbA2);
                                    } catch (JSONException unused) {
                                    }
                                    JSONObject encryptType4 = PangleEncryptManager.encryptType4(jSONObject, new Vy(PangleEncryptConstant.CryptDataScene.UNKNOWN));
                                    if (encryptType4 != null) {
                                        hashMap.put("transfer-param", encryptType4.optString(PglCryptUtils.KEY_MESSAGE));
                                        if (encryptType4.optInt("cypher") == 4) {
                                            hashMap.put("cypher", "4");
                                        } else {
                                            hashMap.put("cypher", "3");
                                        }
                                    }
                                }
                                try {
                                    hashMap.put("x-pangle-target-idc", NU.nY().Bnk());
                                } catch (Throwable unused2) {
                                }
                                return hashMap;
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public JSONObject eli(JSONObject jSONObject) {
                                int optInt = jSONObject.optInt("cypher", -1);
                                if (optInt != -1 && optInt == 3) {
                                    String Os2 = com.bytedance.sdk.component.utils.eli.Os(jSONObject.optString(PglCryptUtils.KEY_MESSAGE));
                                    if (!TextUtils.isEmpty(Os2)) {
                                        try {
                                            return new JSONObject(Os2);
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                                return jSONObject;
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.aGH
                            public HandlerThread eli(String str2, int i) {
                                return wC.eli(str2, i);
                            }
                        });
                        Os = os;
                        os.eli(new com.bytedance.sdk.openadsdk.CMM.eli() { // from class: com.bytedance.sdk.openadsdk.bf.eli.2
                            @Override // com.bytedance.sdk.openadsdk.CMM.eli
                            public void eli() {
                                com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.bf.eli.2.1
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA("strategy_fetch");
                                        return eliVar;
                                    }
                                });
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.eli
                            public void DbA() {
                                com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.bf.eli.2.2
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA("strategy_fetch");
                                        return eliVar;
                                    }
                                });
                                com.bytedance.sdk.openadsdk.MGA.eli.eli().DbA();
                                com.bytedance.sdk.openadsdk.Xb.eli.Os.eli().DbA();
                                bf.DbA();
                                HashMap hashMap = new HashMap();
                                String eli2 = eli.eli(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, "");
                                if (!TextUtils.isEmpty(eli2)) {
                                    hashMap.put(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, eli2);
                                }
                                DbA.DbA().eli(hashMap);
                            }

                            @Override // com.bytedance.sdk.openadsdk.CMM.eli
                            public void eli(int i, String str2) {
                                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.bf.eli.2.3
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar.DbA("strategy_fetch");
                                        return eliVar;
                                    }
                                });
                                bf.eli(eli.DbA);
                            }
                        });
                    } catch (Throwable th) {
                        th.getMessage();
                    }
                }
            }
        }
        return Os;
    }

    private static Os kb() {
        return eli(dV.eli(), FC.DbA().aGH());
    }

    public static int eli(String str, int i) {
        Os kb = kb();
        return kb != null ? kb.eli(str, i) : i;
    }

    public static boolean eli(String str, boolean z) {
        Os kb = kb();
        return kb != null ? kb.eli(str, z) : z;
    }

    public static String eli(String str, String str2) {
        Os kb = kb();
        return kb != null ? kb.eli(str, str2) : str2;
    }

    public static int eli(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = eli;
            Object obj = concurrentHashMap.get(str3);
            if (obj != null && (obj instanceof Integer)) {
                return ((Integer) obj).intValue();
            }
            try {
                String eli2 = kb().eli(str, "");
                if (!TextUtils.isEmpty(eli2)) {
                    int optInt = new JSONObject(eli2).optInt(str2, i);
                    concurrentHashMap.put(str3, Integer.valueOf(optInt));
                    return optInt;
                }
            } catch (Throwable th) {
                Xb.Os("StrategyUtils", th.getMessage());
            }
        }
        return i;
    }

    public static String eli(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str4 = str + "_" + str2;
            ConcurrentHashMap<String, Object> concurrentHashMap = eli;
            Object obj = concurrentHashMap.get(str4);
            if (obj != null && (obj instanceof String)) {
                return (String) obj;
            }
            try {
                String eli2 = kb().eli(str, "");
                if (!TextUtils.isEmpty(eli2)) {
                    String optString = new JSONObject(eli2).optString(str2, str3);
                    concurrentHashMap.put(str4, optString);
                    return optString;
                }
            } catch (Throwable th) {
                Xb.Os("StrategyUtils", th.getMessage());
            }
        }
        return str3;
    }

    public static void eli() {
        Os kb = kb();
        if (kb != null) {
            kb.eli();
        }
    }

    public static boolean DbA() {
        return eli("ad_load_and_render_opt", a.j, 0) == 1;
    }

    public static boolean Os() {
        return DbA() && eli("ad_load_and_render_opt", "thread_switch_opt", 0) == 1;
    }

    public static boolean aGH() {
        return DbA() && eli("ad_load_and_render_opt", "sync_barrier_switch_opt", 0) == 1;
    }

    public static int ui() {
        if (DbA()) {
            return eli("ad_load_and_render_opt", "webview_preload_cache", 0);
        }
        return 0;
    }

    public static int MGA() {
        if (DbA()) {
            return eli("ad_load_and_render_opt", "webview_preload_cache_v3", 0);
        }
        return 0;
    }
}
