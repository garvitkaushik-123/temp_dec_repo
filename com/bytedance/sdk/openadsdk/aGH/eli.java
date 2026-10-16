package com.bytedance.sdk.openadsdk.aGH;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.gG;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements com.bytedance.sdk.component.MGA.eli.aGH.eli.DbA {
    private static final Set<String> aAs = new HashSet(Arrays.asList("insight_log"));
    private static final Map<String, String> du = new HashMap<String, String>() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.1
        {
            put("id", "extra_id");
            put("source", "extra_source");
            put("url", InneractiveInternalBrowserActivity.URL_EXTRA);
            put("toolType", "extra_tool_type");
            put("storeOpenType", "store_open_type");
            put(IronSourceConstants.EVENTS_ERROR_CODE, AndroidBridgeConstants.ERROR_CODE);
            put("md5", "extra_md5");
            put("areaType", "area_type");
            put("rectInfo", "rect_info");
        }
    };
    private String CMM;
    protected final JSONObject DbA;
    private String Dfc;
    private int FC;
    private final String MGA;
    private JSONObject NU;
    private boolean Os;
    private String QX;
    private String Vy;
    private com.bytedance.sdk.openadsdk.aGH.DbA.eli Xb;
    private long aGH;
    private String aqO;
    private String bf;
    private String dV;
    public final String eli;
    private int ev;
    private int kb;
    private String nGm;
    private final AtomicBoolean nlS;
    private String nn;
    private long ui;
    private int wC;

    public eli(String str, JSONObject jSONObject) {
        this.MGA = "adiff";
        this.nlS = new AtomicBoolean(false);
        this.NU = new JSONObject();
        this.eli = str;
        this.DbA = jSONObject;
    }

    private void MGA() {
        JSONObject jSONObject = this.NU;
        if (jSONObject == null) {
            if (!eli(this.dV, this.aqO, this.CMM)) {
                return;
            }
        } else {
            String optString = jSONObject.optString("value");
            String optString2 = this.NU.optString("category");
            String optString3 = this.NU.optString("log_extra");
            if (eli(this.dV, this.aqO, this.CMM)) {
                if (!TextUtils.isEmpty(optString) && TextUtils.equals(optString, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(optString2) && !DbA(optString2)) {
                    return;
                }
            } else {
                if ((TextUtils.isEmpty(optString) || TextUtils.equals(optString, "0")) && (TextUtils.isEmpty(this.dV) || TextUtils.equals(this.dV, "0"))) {
                    return;
                }
                if ((TextUtils.isEmpty(this.aqO) || !DbA(this.aqO)) && (TextUtils.isEmpty(optString2) || !DbA(optString2))) {
                    return;
                }
                if (TextUtils.isEmpty(this.CMM) && TextUtils.isEmpty(optString3)) {
                    return;
                }
            }
        }
        this.aGH = com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli.incrementAndGet();
    }

    private boolean DbA(String str) {
        str.hashCode();
        switch (str) {
            case "umeng":
            case "event_v1":
            case "event_v3":
            case "app_union":
                return true;
            default:
                return false;
        }
    }

    private boolean eli(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.hashCode();
        switch (str2) {
        }
        return false;
    }

    private JSONObject eli(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("adiff")) {
                jSONObject.put("adiff", this.eli);
            }
            if (this.Os) {
                if (!jSONObject.has("interaction_method")) {
                    jSONObject.put("interaction_method", this.kb);
                }
                if (!jSONObject.has("real_interaction_method")) {
                    jSONObject.put("real_interaction_method", this.wC);
                }
                if (!jSONObject.has("image_mode")) {
                    jSONObject.put("image_mode", this.FC);
                }
            }
            if (com.bytedance.sdk.openadsdk.bf.eli.eli("replace_log_extra_key", false)) {
                DbA(jSONObject);
            }
            jSONObject.put("pangle_client_unique_id", "pangle-" + this.eli + "-" + System.currentTimeMillis());
            return jSONObject;
        } catch (Throwable th) {
            Xb.Os("AdEvent", th.getMessage() == null ? "error " : th.getMessage());
            return jSONObject;
        }
    }

    private void DbA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : du.keySet()) {
            try {
                if (jSONObject.has(str)) {
                    Object opt = jSONObject.opt(str);
                    jSONObject.remove(str);
                    jSONObject.put(du.get(str), opt);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject Os() {
        if (this.nlS.get()) {
            return this.DbA;
        }
        try {
            kb();
        } catch (Throwable th) {
            new Object[]{th};
        }
        if (this.DbA.has("ad_extra_data")) {
            Object opt = this.DbA.opt("ad_extra_data");
            if (opt != null) {
                try {
                    if (opt instanceof JSONObject) {
                        this.DbA.put("ad_extra_data", eli((JSONObject) opt).toString());
                    } else if (opt instanceof String) {
                        this.DbA.put("ad_extra_data", eli(new JSONObject((String) opt)).toString());
                    }
                } catch (JSONException e) {
                    Xb.Os("AdEvent", "json error", e.getMessage());
                }
            }
            this.nlS.set(true);
            return this.DbA;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adiff", this.eli);
            if (this.Os) {
                jSONObject.put("interaction_method", this.kb);
                jSONObject.put("real_interaction_method", this.wC);
                jSONObject.put("image_mode", this.FC);
            }
            this.DbA.put("ad_extra_data", jSONObject.toString());
        } catch (JSONException e2) {
            Xb.Os("AdEvent", "json error", e2.getMessage());
        }
        this.nlS.set(true);
        return this.DbA;
        new Object[]{th};
        return this.DbA;
    }

    public JSONObject eli(boolean z) {
        JSONObject Os = Os();
        try {
            if (z) {
                JSONObject jSONObject = new JSONObject(Os.toString());
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (optJSONObject != null) {
                    optJSONObject.remove("app_log_url");
                }
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(Os.toString());
            jSONObject2.remove("app_log_url");
            return jSONObject2;
        } catch (JSONException e) {
            Xb.Os("AdEvent", e.getMessage());
            return Os;
        }
    }

    private void kb() throws JSONException {
        this.DbA.putOpt("app_log_url", this.Vy);
        this.DbA.putOpt("tag", this.nn);
        this.DbA.putOpt("label", this.Dfc);
        this.DbA.putOpt("category", this.aqO);
        if (!TextUtils.isEmpty(this.dV)) {
            try {
                this.DbA.putOpt("value", Long.valueOf(Long.parseLong(this.dV)));
            } catch (NumberFormatException unused) {
                this.DbA.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.QX)) {
            try {
                this.DbA.putOpt("ext_value", Long.valueOf(Long.parseLong(this.QX)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.CMM)) {
            this.DbA.putOpt("log_extra", this.CMM);
        }
        if (!TextUtils.isEmpty(this.bf)) {
            try {
                this.DbA.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.bf)));
            } catch (NumberFormatException unused3) {
            }
        }
        eli(this.DbA, this.Dfc);
        try {
            this.DbA.putOpt("nt", Integer.valueOf(this.ev));
        } catch (Exception unused4) {
        }
        Iterator<String> keys = this.NU.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.DbA.putOpt(next, this.NU.opt(next));
        }
    }

    public String aGH() {
        return this.eli;
    }

    eli(C0165eli c0165eli) {
        this.MGA = "adiff";
        this.nlS = new AtomicBoolean(false);
        this.NU = new JSONObject();
        if (TextUtils.isEmpty(c0165eli.DbA)) {
            this.eli = gG.eli();
        } else {
            this.eli = c0165eli.DbA;
        }
        this.Xb = c0165eli.Dfc;
        this.CMM = c0165eli.MGA;
        this.nn = c0165eli.Os;
        this.Dfc = c0165eli.aGH;
        if (TextUtils.isEmpty(c0165eli.ui)) {
            this.aqO = "app_union";
        } else {
            this.aqO = c0165eli.ui;
        }
        this.bf = c0165eli.du;
        this.dV = c0165eli.wC;
        this.QX = c0165eli.FC;
        this.nGm = c0165eli.kb;
        this.ev = c0165eli.nlS;
        this.Vy = c0165eli.NU;
        this.NU = c0165eli.aAs = c0165eli.aAs != null ? c0165eli.aAs : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.DbA = jSONObject;
        if (!TextUtils.isEmpty(c0165eli.NU)) {
            try {
                jSONObject.put("app_log_url", c0165eli.NU);
            } catch (JSONException e) {
                Xb.Os("AdEvent", e.getMessage());
            }
        }
        this.kb = c0165eli.dV;
        this.wC = c0165eli.nGm;
        this.FC = c0165eli.eli;
        this.Os = c0165eli.QX;
        this.ui = System.currentTimeMillis();
        MGA();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli.DbA
    public JSONObject eli(String str) {
        return Os();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli.DbA
    public long eli() {
        return this.ui;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.aGH.eli.DbA
    public long DbA() {
        return this.aGH;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.aGH.eli$eli, reason: collision with other inner class name */
    public static final class C0165eli {
        private String DbA;
        private com.bytedance.sdk.openadsdk.aGH.DbA.eli Dfc;
        private String FC;
        private String MGA;
        private String NU;
        private String Os;
        private boolean QX;
        private String Xb;
        private JSONObject aAs;
        private String aGH;
        private final long aqO;
        private int dV;
        private String du;
        public int eli;
        private String kb;
        private int nGm;
        private final int nlS;
        private com.bytedance.sdk.openadsdk.aGH.DbA.DbA nn;
        private String ui;
        private String wC;

        public C0165eli(long j, ev evVar) {
            this.dV = -1;
            this.nGm = -1;
            this.eli = -1;
            if (evVar != null) {
                this.QX = KM.DbA(evVar);
                this.dV = evVar.oc();
                this.nGm = evVar.mm();
                this.eli = evVar.GR();
            }
            this.aqO = j;
            this.nlS = com.bytedance.sdk.component.utils.nGm.Os(com.bytedance.sdk.openadsdk.core.dV.eli());
        }

        public C0165eli eli(String str) {
            this.NU = str;
            return this;
        }

        public C0165eli DbA(String str) {
            this.Os = str;
            return this;
        }

        public C0165eli Os(String str) {
            this.aGH = str;
            return this;
        }

        public C0165eli aGH(String str) {
            this.ui = str;
            return this;
        }

        public C0165eli ui(String str) {
            this.wC = str;
            return this;
        }

        public C0165eli MGA(String str) {
            this.FC = str;
            return this;
        }

        public C0165eli eli(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.aAs = jSONObject;
            return this;
        }

        public C0165eli kb(String str) {
            this.kb = str;
            return this;
        }

        public void eli(com.bytedance.sdk.openadsdk.aGH.DbA.eli eliVar) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli(this.aGH, this.Xb, this.kb, this.Os);
            this.Dfc = eliVar;
            final eli eliVar2 = new eli(this);
            try {
                com.bytedance.sdk.openadsdk.aGH.DbA.DbA dbA = this.nn;
                if (dbA != null) {
                    dbA.eli(eliVar2.DbA, this.aqO);
                } else {
                    new com.bytedance.sdk.openadsdk.aGH.DbA.Os().eli(eliVar2.DbA, this.aqO);
                }
            } catch (Throwable th) {
                new Object[]{th};
            }
            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                cyF.Os(new com.bytedance.sdk.component.wC.wC("dispatchEvent") { // from class: com.bytedance.sdk.openadsdk.aGH.eli.eli.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(eliVar2);
                    }
                });
            } else {
                com.bytedance.sdk.openadsdk.aGH.eli.aGH.eli(eliVar2);
            }
        }

        public C0165eli wC(String str) {
            this.Xb = str;
            return this;
        }
    }

    public boolean ui() {
        Set<String> du2;
        if (this.DbA == null || (du2 = com.bytedance.sdk.openadsdk.core.dV.aGH().du()) == null) {
            return false;
        }
        String optString = this.DbA.optString("label");
        if (TextUtils.isEmpty(optString)) {
            if (TextUtils.isEmpty(this.Dfc)) {
                return false;
            }
            return du2.contains(this.Dfc);
        }
        return du2.contains(optString);
    }

    private static void eli(JSONObject jSONObject, String str) {
        try {
            Set<String> set = aAs;
            if (!set.contains(str) && !set.contains(jSONObject.get("label"))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th) {
            Xb.Os("AdEvent", th);
        }
    }
}
