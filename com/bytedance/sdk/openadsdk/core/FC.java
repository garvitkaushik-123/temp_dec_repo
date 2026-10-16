package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.openadsdk.core.Os.kb;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC {
    public static final Set<String> DbA = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.FC.1
        {
            add("8025677");
            add("5001121");
        }
    };
    private static boolean NU = false;
    public static NU eli;
    private boolean Dfc;
    private int FC;
    private String MGA;
    private boolean Os;
    private Bitmap aAs;
    private String aGH;
    private String aqO;
    private com.bytedance.sdk.openadsdk.core.nlS.Os.Os dV;
    private Integer du;
    private int kb;
    private volatile ConcurrentHashMap<String, kb.eli> nGm;
    private int nlS;
    private String nn;
    private String ui;
    private String wC;

    public static void ev() {
    }

    public boolean Dfc() {
        return true;
    }

    public static void eli(NU nu) {
        eli = nu;
    }

    public boolean eli() {
        return this.Dfc;
    }

    public void eli(boolean z) {
        this.Dfc = z;
    }

    private FC() {
        this.Os = false;
        this.FC = 0;
        this.aAs = null;
        this.du = null;
        this.nlS = -1;
        this.nGm = null;
    }

    public static FC DbA() {
        return eli.eli;
    }

    private static class eli {
        private static final FC eli = new FC();
    }

    public boolean Os() {
        return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", "sdk_activate_init", true);
    }

    public void DbA(boolean z) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", "sdk_activate_init", Boolean.valueOf(z));
    }

    public String aGH() {
        if (TextUtils.isEmpty(this.aGH)) {
            String eli2 = eli(MBridgeConstans.APP_ID, Long.MAX_VALUE);
            if (!TextUtils.isEmpty(eli2)) {
                this.aGH = eli2;
            }
        }
        return this.aGH;
    }

    public static void eli(int i) {
        if (i >= 0) {
            eli("domain_index", String.valueOf(i));
        }
    }

    public static int ui() {
        try {
            String eli2 = eli("domain_index", Long.MAX_VALUE);
            if (TextUtils.isEmpty(eli2)) {
                return 0;
            }
            return Integer.valueOf(eli2).intValue();
        } catch (Throwable th) {
            new Object[]{"getDomainIndex", th.getMessage()};
            return 0;
        }
    }

    public static void DbA(int i) {
        if (i >= 0) {
            eli("config_fail_times", String.valueOf(i));
        }
    }

    public static int MGA() {
        try {
            String eli2 = eli("config_fail_times", Long.MAX_VALUE);
            if (TextUtils.isEmpty(eli2)) {
                return 0;
            }
            return Integer.valueOf(eli2).intValue();
        } catch (Throwable th) {
            new Object[]{"getConfigFailTimes", th.getMessage()};
            return 0;
        }
    }

    public void eli(String str) {
        aAs(str);
        this.aGH = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        eli(MBridgeConstans.APP_ID, str);
        com.bytedance.sdk.openadsdk.core.settings.NU.nY().aGH(7);
    }

    public String kb() {
        String str = this.ui;
        if (str != null) {
            return str;
        }
        String eli2 = eli("mediation_info", Long.MAX_VALUE);
        this.ui = eli2;
        if (eli2 == null) {
            this.ui = "";
        }
        return this.ui;
    }

    public void DbA(String str) {
        this.ui = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        eli("mediation_info", str);
    }

    public String wC() {
        if (TextUtils.isEmpty(this.MGA)) {
            this.MGA = eli(dV.eli());
        }
        return this.MGA;
    }

    private String eli(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (Throwable unused) {
            return "";
        }
    }

    public void Os(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_icon_id", "icon_id", Integer.valueOf(i));
        }
        this.kb = i;
    }

    public int FC() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_icon_id", "icon_id", 0);
        }
        return this.kb;
    }

    public int aAs() {
        Integer num = this.du;
        if (num != null) {
            return num.intValue();
        }
        return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_privacy", "tt_gdpr", -1);
    }

    public void aGH(final int i) {
        if (i == 1) {
            i = 0;
        } else if (i == 0) {
            i = 1;
        }
        if (i == 0 || i == 1 || i == -1) {
            final Integer num = this.du;
            if (num == null || num.intValue() != i) {
                this.du = Integer.valueOf(i);
                if (!com.bytedance.sdk.openadsdk.utils.cyF.MGA()) {
                    eli(num, i);
                } else {
                    nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.FC.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FC.this.eli(num, i);
                        }
                    });
                }
            }
        }
    }

    public void ui(int i) {
        this.nlS = i;
    }

    public int du() {
        return this.nlS;
    }

    public boolean nlS() {
        int i = this.nlS;
        return i < -1 || i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(Integer num, int i) {
        if (num != null) {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(4, true);
        } else if (com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_privacy", "tt_gdpr", -1) != i) {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_privacy", "tt_gdpr", Integer.valueOf(i));
            com.bytedance.sdk.openadsdk.core.settings.NU.nY().eli(4, true);
        }
    }

    public String NU() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("sp_global_file", "extra_data", null);
        }
        return this.wC;
    }

    public void Os(final String str) {
        du(str);
        if (com.bytedance.sdk.openadsdk.utils.cyF.MGA()) {
            nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.FC.3
                @Override // java.lang.Runnable
                public void run() {
                    FC.this.FC(str);
                }
            });
        } else {
            FC(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FC(String str) {
        if (!TextUtils.isEmpty(this.wC)) {
            try {
                HashMap hashMap = new HashMap();
                JSONArray jSONArray = new JSONArray(this.wC);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("name");
                        if (!TextUtils.isEmpty(optString)) {
                            hashMap.put(optString, optJSONObject);
                        }
                    }
                }
                JSONArray jSONArray2 = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject optJSONObject2 = jSONArray2.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        String optString2 = optJSONObject2.optString("name");
                        String optString3 = optJSONObject2.optString("value");
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                            hashMap.put(optString2, optJSONObject2);
                        }
                    }
                }
                Collection values = hashMap.values();
                JSONArray jSONArray3 = new JSONArray();
                Iterator it = values.iterator();
                while (it.hasNext()) {
                    jSONArray3.put((JSONObject) it.next());
                }
                this.wC = jSONArray3.toString();
            } catch (Throwable th) {
                th.getMessage();
            }
        } else {
            this.wC = str;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", "extra_data", this.wC);
        }
    }

    public void MGA(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", "title_bar_theme", Integer.valueOf(i));
        }
        this.FC = i;
    }

    private static void aAs(String str) {
        NU nu;
        if (TextUtils.isEmpty(str) && (nu = eli) != null) {
            nu.fail(4000, "appid cannot be empty");
        }
        com.bytedance.sdk.component.utils.Xb.Os("TTAD.GlobalInfo", "appid cannot be empty");
    }

    private static void du(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 1000) {
            return;
        }
        NU nu = eli;
        if (nu != null) {
            nu.fail(4000, "Data is very long, the longest is 1000");
        }
        com.bytedance.sdk.component.utils.Xb.Os("TTAD.GlobalInfo", "Data is very long, the longest is 1000");
    }

    public com.bytedance.sdk.openadsdk.core.nlS.Os.Os nn() {
        if (this.dV == null) {
            this.dV = new com.bytedance.sdk.openadsdk.core.nlS.Os.Os(10, 8);
        }
        return this.dV;
    }

    public Bitmap aqO() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return com.bytedance.sdk.component.utils.aGH.eli(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("sp_global_file", "pause_icon", null));
        }
        return this.aAs;
    }

    public boolean dV() {
        return DbA.contains(this.aGH);
    }

    public boolean nGm() {
        return "5001121".contains(this.aGH);
    }

    public boolean QX() {
        return "com.union_test.internationad".equals(dZ.MGA());
    }

    public String Xb() {
        if (!TextUtils.isEmpty(this.aqO)) {
            return this.aqO;
        }
        String eli2 = com.bytedance.sdk.openadsdk.utils.nlS.eli();
        this.aqO = eli2;
        if (!TextUtils.isEmpty(eli2)) {
            return this.aqO;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.nlS.eli(valueOf);
        this.aqO = valueOf;
        return valueOf;
    }

    private static JSONObject nlS(String str) {
        String DbA2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("sp_global_file", str, null);
        if (TextUtils.isEmpty(DbA2)) {
            return null;
        }
        try {
            return new JSONObject(DbA2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public static void eli(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", str, jSONObject.toString());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.GlobalInfo", e.getMessage());
        }
    }

    public static String eli(String str, long j) {
        JSONObject nlS;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            nlS = nlS(str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.GlobalInfo", e.getMessage());
        }
        if (nlS == null) {
            return null;
        }
        if (System.currentTimeMillis() - nlS.getLong("time") <= j) {
            return nlS.getString("value");
        }
        return null;
    }

    public static Pair<String, Long> aGH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject nlS = nlS(str);
            if (nlS == null) {
                return null;
            }
            return new Pair<>(nlS.getString("value"), Long.valueOf(nlS.getLong("time")));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.GlobalInfo", e.getMessage());
            return null;
        }
    }

    public kb.eli ui(String str) {
        try {
            if (this.nGm == null || str == null) {
                return null;
            }
            return this.nGm.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void eli(String str, kb.eli eliVar) {
        try {
            if (TextUtils.isEmpty(str) || eliVar == null) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                com.bytedance.sdk.openadsdk.Os.aAs.eli(6, str, eliVar);
                return;
            }
            if (this.nGm == null) {
                synchronized (FC.class) {
                    if (this.nGm == null) {
                        this.nGm = new ConcurrentHashMap<>();
                    }
                }
            }
            if (this.nGm != null) {
                this.nGm.put(str, eliVar);
            }
        } catch (Throwable unused) {
        }
    }

    public void MGA(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                com.bytedance.sdk.openadsdk.Os.aAs.eli(6, str);
            } else if (this.nGm != null) {
                this.nGm.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void bf() {
        try {
            if (this.nGm == null || this.nGm.size() != 0) {
                return;
            }
            this.nGm = null;
        } catch (Throwable th) {
            new Object[]{"removeClickCloseListenerObj()", th.getMessage()};
        }
    }

    public void Os(boolean z) {
        this.Os = z;
    }

    public static boolean CMM() {
        return NU;
    }

    public static boolean kb(String str) {
        return (TextUtils.isEmpty(str) || !com.bytedance.sdk.openadsdk.utils.ujq.eli || str.contains("sp_full_screen_video") || str.contains("sp_reward_video") || str.contains("tt_openad") || str.contains("pag_sp_bad_par")) ? false : true;
    }

    public void wC(String str) {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("sp_global_file", "adx_id", str);
        }
        this.nn = str;
    }

    public String Vy() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("sp_global_file", "adx_id", "");
        }
        return this.nn;
    }
}
