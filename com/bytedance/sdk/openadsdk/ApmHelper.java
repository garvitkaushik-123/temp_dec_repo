package com.bytedance.sdk.openadsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.apm.insight.AttachUserData;
import com.apm.insight.CrashType;
import com.apm.insight.CustomRequestHeader;
import com.apm.insight.MonitorCrash;
import com.apm.insight.Npth;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.core.Vy;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.core.settings.MGA;
import com.bytedance.sdk.openadsdk.multipro.aGH.aGH;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import com.ironsource.Y1;
import com.pgl.ssdk.ces.out.PglSSConfig;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApmHelper {
    private static final AtomicBoolean DbA = new AtomicBoolean(false);
    private static eli MGA = null;
    private static String Os = null;
    private static boolean aGH = false;
    private static volatile boolean eli = false;
    private static DbA ui;

    private interface DbA {
        void eli(String str, String str2, Throwable th);
    }

    public static void initApm(final Context context, final InitConfig initConfig) {
        if (DbA.compareAndSet(false, true) && !eli) {
            cyF.eli(new wC("init-apm") { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!ApmHelper.eli) {
                        MGA aGH2 = dV.aGH();
                        boolean unused = ApmHelper.aGH = aGH2.Uv();
                        String nGm = dZ.nGm();
                        if (ApmHelper.aGH && !TextUtils.isEmpty(nGm)) {
                            String unused2 = ApmHelper.Os = initConfig.getAppId();
                            String[] strArr = {"com.bytedance.sdk.component", "com.bytedance.sdk.mediation", BuildConfig.LIBRARY_PACKAGE_NAME, "com.com.bytedance.overseas.sdk", "com.pgl.ssdk", "com.bykv.vk", "com.iab.omid.library.bytedance2", "com.bytedance.adsdk"};
                            String eli2 = nlS.eli(context);
                            try {
                                Npth.setCrashWaitTime(com.bytedance.sdk.openadsdk.bf.eli.eli("apm_crash_wait_time", 10000));
                                Npth.enableLoopMonitor(false);
                                Npth.enableAnrInfo(false);
                                Npth.enableNativeDump(false);
                                Npth.enableActivityDump(false);
                                Npth.enableMessageDump(false);
                                MonitorCrash.setCustomRequestHeaderCallback(new CustomRequestHeader() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.1
                                    @Override // com.apm.insight.CustomRequestHeader
                                    public void addRequestHeader(HttpURLConnection httpURLConnection) {
                                        Pair<String, String> generateRequestHeader = ApmHelper.generateRequestHeader();
                                        httpURLConnection.setRequestProperty("cypher", (String) generateRequestHeader.first);
                                        httpURLConnection.setRequestProperty("transfer-param", (String) generateRequestHeader.second);
                                        httpURLConnection.setRequestProperty("x-pangle-target-idc", dV.aGH().Bnk());
                                    }
                                });
                                final MonitorCrash initSDK = MonitorCrash.initSDK(context, "10000001", 7503L, BuildConfig.VERSION_NAME, strArr);
                                initSDK.setCustomDataCallback(new AttachUserData() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.2
                                    @Override // com.apm.insight.AttachUserData
                                    public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                                        Map<? extends String, ? extends String> wC = ApmHelper.wC();
                                        if (wC.containsKey("render_type")) {
                                            initSDK.addTags("render_type", wC.get("render_type"));
                                            return wC;
                                        }
                                        initSDK.addTags("render_type", "-2");
                                        return wC;
                                    }
                                });
                                if (aGH2.qyC()) {
                                    initSDK.config().setSoList(new String[]{"libnms.so", "libtobEmbedPagEncrypt.so", "tt_ugen_layout.so"});
                                }
                                initSDK.config().setDeviceId(eli2);
                                initSDK.setReportUrl(nGm);
                                initSDK.addTags("host_appid", ApmHelper.Os);
                                initSDK.addTags(BidTokenRepositoryKt.SDK_VERSION, BuildConfig.VERSION_NAME);
                                DbA unused3 = ApmHelper.ui = new DbA() { // from class: com.bytedance.sdk.openadsdk.ApmHelper.1.3
                                    @Override // com.bytedance.sdk.openadsdk.ApmHelper.DbA
                                    public void eli(String str, String str2, Throwable th) {
                                        initSDK.reportCustomErr(str, str2, th);
                                    }
                                };
                                boolean unused4 = ApmHelper.eli = true;
                                ApmHelper.Os(eli2, nGm);
                                eli eliVar = ApmHelper.MGA;
                                eli unused5 = ApmHelper.MGA = null;
                                if (eliVar != null) {
                                    ApmHelper.ui.eli(eliVar.eli, eliVar.DbA, eliVar.Os);
                                }
                            } catch (Throwable unused6) {
                                boolean unused7 = ApmHelper.eli = false;
                            }
                        }
                    }
                    ApmHelper.DbA.set(false);
                }
            });
        }
    }

    public static void reportCustomError(String str, String str2, Throwable th) {
        DbA dbA = ui;
        if (dbA != null) {
            dbA.eli(str, str2, th);
        } else {
            MGA = new eli(str, str2, th);
        }
    }

    private static class eli {
        public final String DbA;
        public final Throwable Os;
        public final String eli;

        public eli(String str, String str2, Throwable th) {
            this.eli = str;
            this.DbA = str2;
            this.Os = th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, String> wC() {
        HashMap hashMap = new HashMap();
        ev DbA2 = com.bytedance.sdk.openadsdk.utils.DbA.DbA();
        if (DbA2 != null) {
            hashMap.put("adType", String.valueOf(DbA2.bBQ()));
            hashMap.put(C3114ha.b, String.valueOf(DbA2.jSY()));
            hashMap.put("cid", DbA2.umh());
            hashMap.put("reqId", DbA2.fO());
            hashMap.put("rit", DbA2.oWW(Y1.f));
            int rH = DbA2.rH();
            if (DbA2.BDs() != 2) {
                rH = -1;
            }
            hashMap.put("render_type", String.valueOf(rH));
        }
        return hashMap;
    }

    private static void DbA(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        dV.Os().eli(DbA(str), "https://" + str2 + "/monitor/collect/c/session?version_code=7503&device_platform=android&aid=10000001");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os(String str, String str2) {
        DbA(str, str2);
    }

    public static void reportPvFromBackGround() {
        if (aGH) {
            DbA(nlS.eli(dV.eli()), dZ.nGm());
        }
    }

    private static JSONObject DbA(String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(BidTokenRepositoryKt.SDK_VERSION, BuildConfig.VERSION_NAME);
            jSONObject3.put("host_app_id", Os);
            jSONObject2.putOpt("custom", jSONObject3);
            jSONObject2.put(N6.F, C3040d4.d);
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put(BidTokenRepositoryKt.DEVICE_MODEL, Build.MODEL);
            jSONObject2.put("device_brand", Build.BRAND);
            jSONObject2.put("sdk_version_name", "0.0.5");
            jSONObject2.put(C3114ha.b, "10000001");
            jSONObject2.put("update_version_code", BuildConfig.VERSION_CODE);
            jSONObject2.put("bd_did", str);
            jSONObject.putOpt("apm_id", "20000001");
            jSONObject.putOpt("header", jSONObject2);
            jSONObject.putOpt("local_time", Long.valueOf(System.currentTimeMillis()));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject().put("local_time_ms", System.currentTimeMillis()));
            jSONObject.putOpt("launch", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            Xb.Os("ApmHelper", e.getMessage());
            return jSONObject;
        }
    }

    public static boolean isIsInit() {
        return eli;
    }

    public static Pair<String, String> generateRequestHeader() {
        String str = "";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gaid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
            jSONObject.put("ipv6", aGH.DbA("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, ""));
            jSONObject.put("region", dV.aGH().Cp());
        } catch (JSONException unused) {
        }
        JSONObject encryptType4WithNoWrapBase64 = PangleEncryptManager.encryptType4WithNoWrapBase64(jSONObject, new Vy(PangleEncryptConstant.CryptDataScene.UNKNOWN));
        String str2 = "0";
        if (encryptType4WithNoWrapBase64 != null) {
            int optInt = encryptType4WithNoWrapBase64.optInt("cypher");
            if (optInt == 4) {
                str = encryptType4WithNoWrapBase64.optString(PglCryptUtils.KEY_MESSAGE);
                str2 = "4";
            } else if (optInt == 3) {
                str = encryptType4WithNoWrapBase64.optString(PglCryptUtils.KEY_MESSAGE);
                str2 = "3";
            } else {
                str = jSONObject.toString();
            }
        }
        return new Pair<>(str2, str);
    }
}
