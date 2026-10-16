package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.aGH.eli.nn;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.du;
import com.bytedance.sdk.openadsdk.core.settings.nlS;
import com.bytedance.sdk.openadsdk.core.settings.ui;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.C3207n2;
import com.pgl.ssdk.ces.out.PglSSConfig;
import io.bidmachine.rendering.model.EventTaskParams;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU implements MGA, du.eli {
    private static String KM;
    private final BroadcastReceiver CMM;
    private final AtomicBoolean Dfc;
    private final com.bytedance.sdk.openadsdk.core.settings.eli NU;
    private boolean QX;
    private ui.DbA<JSONObject> Ue;
    private final ui.DbA<Map<String, Integer>> Vy;
    private Set<String> aAs;
    private volatile boolean aqO;
    private int dV;
    private final Runnable ev;
    private final Set<String> gG;
    final ui.DbA<ConcurrentHashMap<String, Integer>> kb;
    private int nGm;
    private final aAs nn;
    private final ui.DbA<Set<String>> ujq;
    ui.DbA<nn> wC;
    public static final String eli = String.join("_", "bus_con_collect", dZ.VM());
    public static final String DbA = String.join("_", "bus_con", dZ.VM(), dZ.KM(), "timeout");
    public static final String Os = String.join("_", "bus_con", dZ.VM(), dZ.KM(), "alpha");
    private static final String FC = dZ.CMM();
    private static final com.bytedance.sdk.component.wC.wC du = new com.bytedance.sdk.component.wC.wC("TemplateReInitTask") { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.adexpress.eli.DbA.ui.DbA().FC();
            com.bytedance.sdk.component.adexpress.eli.DbA.ui.DbA().DbA(false);
            com.bytedance.sdk.component.adexpress.eli.DbA.DbA.DbA();
            com.bytedance.sdk.component.adexpress.eli.DbA.ui.DbA().Os();
        }
    };
    public static String aGH = "";
    public static String ui = "IABTCF_TCString";
    private static boolean nlS = false;
    private static final ConcurrentLinkedQueue<nlS.eli> Xb = new ConcurrentLinkedQueue<>();
    private static final wC bf = new wC();
    static final ConcurrentHashMap<String, Integer> MGA = new ConcurrentHashMap<>();

    private static final class eli {
        static final NU eli = new NU();
    }

    private static int Os(boolean z) {
        return z ? 20 : 5;
    }

    private NU() {
        this.aAs = Collections.synchronizedSet(new HashSet());
        this.NU = new com.bytedance.sdk.openadsdk.core.settings.eli();
        this.nn = new aAs(new nlS.eli() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.5
            @Override // com.bytedance.sdk.openadsdk.core.settings.nlS.eli
            public void eli() {
                nlS.eli[] eliVarArr;
                boolean unused = NU.nlS = true;
                if (NU.Xb == null || NU.Xb.size() == 0 || (eliVarArr = (nlS.eli[]) NU.Xb.toArray()) == null) {
                    return;
                }
                for (nlS.eli eliVar : eliVarArr) {
                    eliVar.eli();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.nlS.eli
            public void DbA() {
                if (NU.Xb == null || NU.Xb.isEmpty()) {
                    return;
                }
                Iterator it = NU.Xb.iterator();
                while (it.hasNext()) {
                    ((nlS.eli) it.next()).DbA();
                }
            }
        });
        this.Dfc = new AtomicBoolean(false);
        this.aqO = false;
        this.dV = 5000;
        this.nGm = 10;
        AnonymousClass9 anonymousClass9 = new AnonymousClass9();
        this.CMM = anonymousClass9;
        this.ev = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.10
            @Override // java.lang.Runnable
            public void run() {
                NU.this.aGH(2);
                NU.this.yw();
            }
        };
        this.kb = new ui.DbA<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.11
            @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public ConcurrentHashMap<String, Integer> DbA(String str) {
                if (TextUtils.isEmpty(str)) {
                    return NU.MGA;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        int optInt = jSONObject.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && optInt >= 0 && optInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(optInt));
                        }
                    }
                } catch (JSONException e) {
                    Log.i("TTAD.SdkSettings", e.getMessage());
                }
                return concurrentHashMap;
            }
        };
        this.Vy = new ui.DbA<Map<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.12
            @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public Map<String, Integer> DbA(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    HashMap hashMap = new HashMap(jSONObject.length());
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            int optInt = jSONObject.optInt(next, 100);
                            if (optInt >= 0 && optInt <= 100) {
                                hashMap.put(next, Integer.valueOf(optInt));
                            } else {
                                hashMap.put(next, 100);
                            }
                        }
                    }
                    return hashMap;
                } catch (Exception e) {
                    Xb.Os("get applog rate from sp failed:" + e.getMessage(), new Object[0]);
                    return null;
                }
            }
        };
        this.gG = new HashSet();
        this.ujq = new ui.DbA<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.2
            @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public Set<String> DbA(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int optInt = jSONObject.optInt("applog_count");
                        if (optInt >= 2 && optInt <= 100) {
                            NU.this.nGm = optInt;
                        }
                        int optInt2 = jSONObject.optInt("applog_interval");
                        if (optInt2 >= 100 && optInt2 <= 30000) {
                            NU.this.dV = optInt2;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                String string = jSONArray.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        Log.i("TTAD.SdkSettings", e.getMessage());
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList("click", C3207n2.v, "insight_log", "mrc_show")) : hashSet;
            }
        };
        this.Ue = new ui.DbA<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.3
            @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public JSONObject DbA(String str) {
                JSONObject jSONObject;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Throwable th) {
                    Xb.Os("TTAD.SdkSettings", th.getMessage());
                    jSONObject = null;
                }
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        };
        this.wC = new ui.DbA<nn>() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.4
            @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public nn DbA(String str) {
                nn nnVar = new nn();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    nnVar.eli(jSONObject.optInt("enable_strategy", 0) == 1);
                    nnVar.eli(eli(jSONObject.optJSONObject(EventTaskParams.STATE_GROUP_DEFAULT)));
                    JSONObject optJSONObject = jSONObject.optJSONObject("adid_configs");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            nnVar.eli(next, eli(optJSONObject.getJSONObject(next)));
                        }
                    }
                } catch (Exception unused) {
                }
                return nnVar;
            }

            private nn.eli eli(JSONObject jSONObject) {
                if (jSONObject != null) {
                    return new nn.eli(jSONObject.optInt("retry_times", -1), jSONObject.optInt("time_interval", -1));
                }
                return null;
            }
        };
        try {
            Context eli2 = dV.eli();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                eli2.registerReceiver(anonymousClass9, intentFilter, 4);
            } else {
                eli2.registerReceiver(anonymousClass9, intentFilter);
            }
        } catch (Exception e) {
            Xb.eli("TTAD.SdkSettings", "", e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void eli() {
        try {
            Os.eli();
            this.nn.Os();
            this.NU.Os();
            Context eli2 = dV.eli();
            File file = new File(new File(eli2.getDataDir(), "shared_prefs"), "tt_sdk_settings.xml");
            if (file.exists() && file.isFile()) {
                eli2.deleteSharedPreferences(file.getName().replace(".xml", ""));
            }
        } catch (Throwable unused) {
        }
    }

    private static void DbA(int i, boolean z) {
        Context eli2 = dV.eli();
        if (eli2 != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(eli2.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z);
                intent.putExtra("_source", i);
                eli2.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static void QW() {
        Context eli2;
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os() && (eli2 = dV.eli()) != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(eli2.getPackageName());
                intent.setAction("_dataChanged");
                eli2.sendBroadcast(intent);
            } catch (Throwable th) {
                Xb.eli("TTAD.SdkSettings", "", th);
            }
        }
    }

    public static int DbA(Context context) {
        SharedPreferences aGH2;
        if (context == null || (aGH2 = aGH(context)) == null) {
            return -2;
        }
        int i = aGH2.getInt("IABTCF_CmpSdkID", Integer.MIN_VALUE);
        int i2 = aGH2.getInt("IABTCF_CmpSdkVersion", Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
            return -2;
        }
        return aGH2.getInt("IABTCF_gdprApplies", -1);
    }

    public static String Os(Context context) {
        SharedPreferences aGH2;
        return (context == null || (aGH2 = aGH(context)) == null) ? "" : aGH2.getString(ui, "");
    }

    private static SharedPreferences aGH(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public static MGA nY() {
        if (dV.eli() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("context is null");
            Log.e("TTAD.SdkSettings", "context is null", illegalStateException);
            ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
            return bf;
        }
        return eli.eli;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public synchronized void DbA() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = this.aqO;
        this.NU.eli(this.aqO);
        this.nn.eli(this.aqO);
        Os.eli(!z);
        this.aqO = true;
        new Object[]{"loadLocalData: finished, used", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), "ms"};
        if (!z) {
            com.bytedance.sdk.openadsdk.core.nn.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.6
                @Override // java.lang.Runnable
                public void run() {
                    if (du.eli()) {
                        NU.this.aGH(1);
                        NU.this.yw();
                    } else {
                        com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().DbA();
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String Os() {
        return this.nn.eli("aes_key", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int aGH() {
        return this.nn.eli("max_tpl_cnts", 100);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public JSONObject ui() {
        return (JSONObject) this.nn.eli("digest", null, ui.eli);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public long MGA() {
        return this.nn.eli("data_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void kb() {
        this.nn.eli().eli("tt_sdk_settings").eli("ab_test_param").eli();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void eli(JSONObject jSONObject, ui.eli eliVar) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        aAs aas = this.nn;
        String str = FC;
        String eli2 = aas.eli("dyn_draw_engine_url", str);
        final String optString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(eli2) && !TextUtils.isEmpty(optString) && !optString.equals(eli2)) {
            com.bytedance.sdk.openadsdk.core.nn.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.equals(NU.this.nn.eli("dyn_draw_engine_url", NU.FC), optString)) {
                        com.bytedance.sdk.component.adexpress.eli.DbA.ui.DbA().Os();
                    }
                }
            }, 5000L);
        }
        eliVar.eli("dyn_draw_engine_url", optString);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int eli(String str) {
        if (str == null) {
            return 0;
        }
        return dV.aGH().gG(str).QX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void DbA(JSONObject jSONObject, ui.eli eliVar) {
        if (jSONObject.has("is_gdpr_user")) {
            int optInt = jSONObject.optInt("is_gdpr_user", -1);
            eliVar.eli("isGdprUser", (optInt == -1 || optInt == 1 || optInt == 0) ? optInt : -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean wC() {
        return this.nn.eli("if_both_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String FC() {
        return this.nn.eli("ab_test_version", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int aAs() {
        return this.nn.eli("splash_video_load_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int eli(String str, int i) {
        Integer num;
        Map map = (Map) this.nn.eli("perf_con_stats_rate", MGA, this.kb);
        return (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) ? i : num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Ue(String str) {
        Integer num;
        Map map = (Map) this.nn.eli("perf_con_applog_rate", null, this.Vy);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int rn() {
        return this.nn.eli("perf_con_drawable_code", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public Set<String> du() {
        return SjY();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int nlS() {
        SjY();
        return this.nGm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int NU() {
        SjY();
        return this.dV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean nn() {
        return this.nn.eli("allow_blind_mode_request_ad", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Dfc() {
        return this.nn.eli("support_gzip", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean aqO() {
        return this.nn.eli("ad_revenue_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean BDs() {
        return this.nn.eli("bus_con_adshow_check_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int DE() {
        int eli2 = this.nn.eli("bus_con_token_thread_count", 4);
        if (eli2 <= 0 || eli2 > 30) {
            return 4;
        }
        return eli2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String GMY() {
        return this.nn.eli("bus_con_express_host", "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int rH() {
        return this.nn.eli("bus_con_behavior_count", 300);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String gAc() {
        return this.nn.eli("bus_con_check_clz", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean iuv() {
        return this.nn.eli("bus_con_url_check", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean XU() {
        return this.nn.eli(eli, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Kp() {
        return this.nn.eli(DbA, 10000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public float MQ() {
        return this.nn.eli(Os, 1.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int dV() {
        return this.nn.eli("loadedCallbackOpportunity", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String nGm() {
        return this.nn.eli("ab_test_param", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean QX() {
        return this.nn.eli("landingpage_new_style", -1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public long Xb() {
        return this.nn.eli("duration", 10000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int bf() {
        return this.nn.eli("max", 50);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public kb CMM() {
        return (kb) this.nn.eli("insert_js_config", kb.eli, new ui.DbA<kb>() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.8
            @Override // com.bytedance.sdk.openadsdk.core.settings.ui.DbA
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public kb DbA(String str) {
                return new kb(str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String ev() {
        return this.nn.eli("playableLoadH5Url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Vy() {
        int eli2 = this.nn.eli("fetch_tpl_timeout_ctrl", 3000);
        if (eli2 <= 0) {
            return 3000;
        }
        return eli2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int gG() {
        int eli2 = this.nn.eli("fetch_tpl_second", 0);
        if (eli2 <= 0) {
            return 0;
        }
        return eli2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void ujq() {
        String XlF = XlF();
        if (TextUtils.isEmpty(XlF)) {
            return;
        }
        if (XlF.equals("zh-Hant")) {
            com.bytedance.sdk.component.utils.nlS.eli(dV.eli(), "zh", "tw");
        } else {
            com.bytedance.sdk.component.utils.nlS.eli(dV.eli(), XlF, null);
        }
        try {
            TTAdDislikeToast.onResourceUpdated();
        } catch (Throwable th) {
            Xb.Os("TTAD.SdkSettings", th.getMessage());
        }
    }

    private String XlF() {
        return this.nn.eli("force_language", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean DbA(String str) {
        return gG(str).Os == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Os(String str) {
        return gG(str).VM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean aGH(String str) {
        int i = gG(str).ui;
        if (i != 1) {
            return i == 2 && nGm.Os(dV.eli()) != 0;
        }
        return nGm.aGH(dV.eli());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean ui(String str) {
        return gG(str).kb == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int MGA(String str) {
        return gG(str).nGm;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean kb(String str) {
        return str == null || gG(str).nn == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int wC(String str) {
        if (str == null) {
            return 1500;
        }
        return gG(str).aqO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int FC(String str) {
        return gG(str).du;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int aAs(String str) {
        return gG(str).nlS;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean du(String str) {
        try {
            return gG(str).ev != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Ue() {
        return this.nn.DbA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int nlS(String str) {
        return gG(String.valueOf(str)).wC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean NU(String str) {
        return nlS(str) != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int nn(String str) {
        return gG(str).aAs;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int eli(String str, boolean z) {
        if (str == null) {
            return Os(z);
        }
        DbA gG = gG(str);
        return gG.gG != -1 ? gG.gG : Os(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Dfc(String str) {
        return gG(str).CMM == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean aqO(String str) {
        return str == null || DeviceUtils.aAs(dV.eli()) == 0 || gG(str).NU == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String KM() {
        return this.nn.eli("ads_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String VM() {
        return this.nn.eli("settings_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String GB() {
        return this.nn.eli("app_log_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String oWW() {
        return this.nn.eli("policy_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int qj() {
        return this.nn.eli("ivrv_downward", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String nro() {
        return this.nn.eli("dyn_draw_engine_url", FC);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String Cp() {
        return this.nn.eli("dc", "TX");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int cyF() {
        return this.nn.eli("isGdprUser", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int eli(int i) {
        return gG(String.valueOf(i)).qj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int DbA(int i) {
        return gG(String.valueOf(i)).DbA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Os(int i) {
        return gG(String.valueOf(i)).FC;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int eU() {
        return this.nn.eli("vbtt", 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public JSONObject dV(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(this.nn.eli("core_settings", ""));
            try {
                jSONObject2.put("ad_slot_setting", gG(str).nro);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                Xb.Os("TTAD.SdkSettings", "getCoreSettingJsonObj", e.getMessage());
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int nGm(String str) {
        return gG(str).Xb;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean QX(String str) {
        return gG(str).bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Xb(String str) {
        return gG(str).ujq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int bf(String str) {
        return gG(str).Ue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int CMM(String str) {
        return gG(str).KM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean ev(String str) {
        return gG(str).oWW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Vy(String str) {
        return dV.aGH().gG(str).Dfc == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public DbA gG(String str) {
        return Os.eli(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean dZ() {
        int eli2 = this.nn.eli("privacy_ad_enable", Integer.MAX_VALUE);
        if (eli2 == 1) {
            return true;
        }
        if (eli2 == 0) {
            return false;
        }
        int Vy = dZ.Vy();
        return Vy == 1 || Vy == 2 || Vy == 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int SSo() {
        int eli2 = this.nn.eli("privacy_personalized_ad", Integer.MAX_VALUE);
        if (eli2 != Integer.MAX_VALUE) {
            return eli2;
        }
        int Vy = dZ.Vy();
        if (Vy == 1 || Vy == 2) {
            return 2;
        }
        return Vy != 3 ? 0 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean qyC() {
        return this.nn.eli("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean FS() {
        boolean z = this.nn.eli("bus_con_sec_type", Integer.MAX_VALUE) != 0;
        new Object[]{"secSdk type: ", Boolean.valueOf(z)};
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean jh() {
        return this.nn.eli("bus_con_dislike_report_raw", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Za() {
        return this.nn.eli("privacy_debug_unlock", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean ujq(String str) {
        Set set = (Set) this.nn.eli("privacy_fields_allowed", Collections.emptySet(), ui.DbA);
        if (set.isEmpty()) {
            int Vy = dZ.Vy();
            if (Vy != 1) {
                if (Vy != 2 && Vy != 3) {
                    return false;
                }
                if (!"mcc".equals(str) && !"mnc".equals(str)) {
                    return false;
                }
            }
            return true;
        }
        return set.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean vb() {
        return this.nn.eli("privacy_app_reg", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean ikX() {
        return this.aqO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean tGZ() {
        return this.nn.eli("global_rate", 1.0f) == 1.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean WfR() {
        return this.nn.eli("read_video_from_cache", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int ow() {
        int eli2 = this.nn.eli("perf_con_webview_cache_count", 0);
        if (eli2 < 0) {
            return 0;
        }
        return eli2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int TfR() {
        int eli2 = this.nn.eli("perf_con_webview_cache_count_v3", 0);
        if (eli2 < 0) {
            return 0;
        }
        return eli2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String[] QI() {
        Set<String> set;
        try {
            set = this.aAs;
        } catch (Throwable unused) {
        }
        if (set == null || set.size() == 0) {
            JSONArray jSONArray = new JSONArray(this.nn.eli("gecko_hosts", (String) null));
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.aAs.add(jSONArray.getString(i));
                }
            }
            Set<String> eli2 = aAs.eli(this.aAs);
            this.aAs = eli2;
            if (eli2 != null) {
                if (eli2.size() == 0) {
                }
            }
            return null;
        }
        return (String[]) this.aAs.toArray(new String[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int mm() {
        return this.nn.eli("blank_detect_rate", 30);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public JSONObject oc() {
        return (JSONObject) this.nn.eli("video_cache_config", null, ui.eli);
    }

    public long kEI() {
        long eli2 = this.nn.eli("req_inter_min", TTAdConstant.AD_MAX_EVENT_TIME);
        return (eli2 < 0 || eli2 > 86400000) ? TTAdConstant.AD_MAX_EVENT_TIME : eli2;
    }

    public long Tju() {
        return this.nn.eli("last_req_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void eli(long j) {
        this.nn.eli().eli("last_req_time", j).eli();
    }

    void yw() {
        if (du.eli()) {
            com.bytedance.sdk.openadsdk.core.nn.DbA().removeCallbacks(this.ev);
            com.bytedance.sdk.openadsdk.core.nn.DbA().postDelayed(this.ev, kEI());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void aGH(int i) {
        eli(i, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void eli(int i, boolean z) {
        if (!com.bytedance.sdk.openadsdk.core.nn.ui() && i != 1 && i != 2) {
            if (z) {
                this.QX = true;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.FC.DbA().aGH())) {
                return;
            }
            if (this.QX) {
                this.QX = false;
                if (!z) {
                    z = true;
                }
            }
            long Tju = Tju();
            long currentTimeMillis = System.currentTimeMillis();
            long kEI = kEI();
            long j = currentTimeMillis - Tju;
            if (z || j >= kEI) {
                if (!du.eli()) {
                    DbA(i, z);
                } else if (this.Dfc.compareAndSet(false, true)) {
                    cyF.DbA((com.bytedance.sdk.component.wC.wC) new du(this, this.nn, this.NU));
                    com.bytedance.sdk.openadsdk.core.nn.DbA().removeCallbacks(this.ev);
                }
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("settings request error", "settings", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.du.eli
    public void eli(boolean z) {
        this.Dfc.set(false);
        yw();
        if (z) {
            HashMap hashMap = new HashMap();
            Set<String> qWy = qWy();
            if (qWy != null && !qWy.isEmpty()) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, qWy);
            }
            String nGm = dZ.nGm();
            if (!TextUtils.isEmpty(nGm)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, nGm);
            }
            hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, Bnk());
            com.bytedance.sdk.openadsdk.core.FC.DbA.DbA().eli(hashMap);
            QW();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void eli(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.CMM, intentFilter, 4);
            } else {
                context.registerReceiver(this.CMM, intentFilter);
            }
        } catch (Exception e) {
            Xb.eli("TTAD.SdkSettings", "", e);
        }
        if (ikX()) {
            aGH(1);
            yw();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.settings.NU$9, reason: invalid class name */
    class AnonymousClass9 extends BroadcastReceiver {
        private final Runnable DbA = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.9.1
            @Override // java.lang.Runnable
            public void run() {
                cyF.DbA(new com.bytedance.sdk.component.wC.wC("LoadLocalData") { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.9.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            NU.this.DbA();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        };

        AnonymousClass9() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            cyF.DbA(new com.bytedance.sdk.component.wC.wC("setting_receiver") { // from class: com.bytedance.sdk.openadsdk.core.settings.NU.9.2
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if ("_tryFetRemoDat".equals(action)) {
                        NU.this.eli(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                    } else if ("_dataChanged".equals(action)) {
                        com.bytedance.sdk.component.utils.FC.eli().removeCallbacks(AnonymousClass9.this.DbA);
                        com.bytedance.sdk.component.utils.FC.eli().postDelayed(AnonymousClass9.this.DbA, 10000L);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean rQ() {
        if (com.bytedance.sdk.component.adexpress.aGH.DbA.eli(dV.eli())) {
            return this.nn.eli("support_rtl", false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Yw() {
        return this.nn.eli("bus_con_send_log_type", 1);
    }

    private Set<String> SjY() {
        return (Set) this.nn.eli("perf_con_applog_send", this.gG, this.ujq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int BH() {
        return this.nn.eli("perf_con_thread_stack_size", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Uv() {
        int eli2 = this.NU.eli("perf_con_apm", 100);
        if (eli2 == 0) {
            return false;
        }
        return eli2 < 0 || eli2 >= 100 || eli2 > ((int) (Math.random() * 100.0d));
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public long tLO() {
        return this.nn.eli("perf_con_adlog_expire_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean eEH() {
        return this.nn.eli("perf_con_use_new_thread_pool", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Hm() {
        return this.nn.eli("perf_con_is_new_net_thread", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean eli(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.GET_ADS || cryptDataScene == PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN) {
            return this.nn.eli("perf_con_crypt_V4_get_ad", false);
        }
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.APP_LOG) {
            return this.nn.eli("perf_con_crypt_V4_applog", false);
        }
        return this.nn.eli("perf_con_crypt_V4", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public JSONObject Gjg() {
        return (JSONObject) this.nn.eli("perf_con_thread_pool_config", new JSONObject(), this.Ue);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean gHb() {
        return this.nn.eli("perf_con_adlog_turn_off_retry_ad", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean Mc() {
        return this.nn.eli("perf_con_adlog_turn_off_retry_stats", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String PfW() {
        return this.nn.eli("dual_event_url", (String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int Ca() {
        int eli2 = this.nn.eli("bus_con_auto_click_delay", 3000);
        if (eli2 <= 0) {
            return 3000;
        }
        return eli2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public nn yKf() {
        return (nn) this.nn.eli("perf_con_track_url_strategy", nn.eli, this.wC);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public int HN() {
        return this.nn.eli("perf_con_close_button_delay_check_time", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public Set<String> ND() {
        return (Set) this.nn.eli("perf_con_drop2rt_skip_label_list", Collections.emptySet(), ui.DbA);
    }

    public static boolean CH() {
        return nlS;
    }

    public static void eli(nlS.eli eliVar) {
        ConcurrentLinkedQueue<nlS.eli> concurrentLinkedQueue = Xb;
        if (concurrentLinkedQueue.contains(eliVar)) {
            return;
        }
        concurrentLinkedQueue.add(eliVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean XxP() {
        return this.nn.eli("bus_con_video_keep_screen_on", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public void RY() {
        ui.eli eli2 = this.nn.eli();
        eli2.eli("settings_url", "");
        eli2.eli();
        VM("");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public Set<String> qWy() {
        return (Set) this.nn.eli("privacy_fields_allowed", Collections.emptySet(), ui.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean hg() {
        return this.nn.eli("token_enable", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public boolean KM(String str) {
        Set set;
        if (TextUtils.isEmpty(str) || (set = (Set) this.nn.eli("token_adx_ids", Collections.emptySet(), ui.DbA)) == null || set.size() == 0) {
            return false;
        }
        return set.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.MGA
    public String Bnk() {
        return this.nn.eli("target_region", "");
    }

    public static String QMZ() {
        if (KM == null) {
            String DbA2 = com.bytedance.sdk.openadsdk.core.Os.eli().DbA("settings_host_from_meta", "");
            KM = DbA2;
            if (DbA2 == null) {
                KM = "";
            }
        }
        return KM;
    }

    public static void VM(String str) {
        if (str == null) {
            str = "";
        }
        String QMZ = QMZ();
        if (QMZ == null || !QMZ.equals(str)) {
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("settings_host_from_meta", str);
            KM = str;
            nY().eli(8, true);
        }
    }
}
