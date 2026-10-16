package com.mbridge.msdk.setting;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.f0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingRequestController.java */
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4706a = "j";

    /* compiled from: SettingRequestController.java */
    class a extends com.mbridge.msdk.foundation.same.net.wrapper.d {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(String str) {
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.has(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I)) {
                return;
            }
            try {
                f0.a().a(jSONObject.getString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I));
            } catch (Exception e) {
                p0.b(j.f4706a, e.getMessage());
            }
        }
    }

    /* compiled from: SettingRequestController.java */
    class c extends com.mbridge.msdk.foundation.same.net.handler.a {
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        c(Context context, String str, String str2) {
            this.b = context;
            this.c = str;
            this.d = str2;
        }

        @Override // com.mbridge.msdk.foundation.same.net.handler.a
        public void a(String str) {
            com.mbridge.msdk.foundation.same.net.utils.d.h().r = false;
            p0.a(j.f4706a, "fetch CNDSettingHost failed, errorCode = " + str);
        }

        @Override // com.mbridge.msdk.foundation.same.net.handler.a
        public void b(String str) {
            p0.a(j.f4706a, "fetch CNDSettingHost success, content = " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("mkey_spare_host_ts", System.currentTimeMillis());
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("mkey_spare_host", str);
            for (String str2 : str.split("\n")) {
                if (!TextUtils.isEmpty(str2.trim()) && !com.mbridge.msdk.foundation.same.net.utils.d.h().u.contains(str2.trim())) {
                    com.mbridge.msdk.foundation.same.net.utils.d.h().u.add(str2.trim());
                    com.mbridge.msdk.foundation.same.net.utils.d.h().x.add(str2.trim());
                }
            }
            j.this.a(this.b, this.c, this.d);
        }
    }

    private String b() {
        String str = com.mbridge.msdk.foundation.same.net.utils.d.h().s ? com.mbridge.msdk.foundation.same.net.utils.d.h().R : com.mbridge.msdk.foundation.same.net.utils.d.h().Q;
        try {
            if (com.mbridge.msdk.foundation.same.net.utils.d.h().s && com.mbridge.msdk.foundation.same.net.utils.d.h().r && com.mbridge.msdk.foundation.same.net.utils.d.h().w < com.mbridge.msdk.foundation.same.net.utils.d.h().x.size()) {
                String str2 = com.mbridge.msdk.foundation.same.net.utils.d.h().x.get(com.mbridge.msdk.foundation.same.net.utils.d.h().w);
                if (!TextUtils.isEmpty(str2) && (str2.startsWith("http") || str2.startsWith("https"))) {
                    return str2 + "/setting";
                }
            }
        } catch (Throwable th) {
            p0.b(f4706a, th.getMessage());
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            new com.mbridge.msdk.foundation.same.report.h(com.mbridge.msdk.foundation.controller.c.m().d()).a();
        } catch (Throwable th) {
            p0.b(f4706a, th.getMessage());
        }
    }

    public void d(Context context, String str, String str2) {
        try {
            if (com.mbridge.msdk.foundation.same.net.utils.d.h().r) {
                return;
            }
            com.mbridge.msdk.foundation.same.net.utils.d.h().r = true;
            if (System.currentTimeMillis() >= com.mbridge.msdk.foundation.buffer.sharedperference.a.b().b("mkey_spare_host_ts").longValue() + 86400000) {
                String a2 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("mkey_spare_host");
                if (!TextUtils.isEmpty(a2)) {
                    for (String str3 : a2.split("\n")) {
                        if (!TextUtils.isEmpty(str3.trim()) && !com.mbridge.msdk.foundation.same.net.utils.d.h().u.contains(str3.trim())) {
                            com.mbridge.msdk.foundation.same.net.utils.d.h().u.add(str3.trim());
                            com.mbridge.msdk.foundation.same.net.utils.d.h().x.add(str3.trim());
                        }
                    }
                    a(context, str, str2);
                    return;
                }
            }
            new com.mbridge.msdk.foundation.same.net.wrapper.c(context.getApplicationContext()).get(0, com.mbridge.msdk.foundation.same.net.utils.d.h().c, new com.mbridge.msdk.foundation.same.net.wrapper.e(), new c(context, str, str2), "setting", 60000L);
        } catch (Throwable th) {
            com.mbridge.msdk.foundation.same.net.utils.d.h().r = false;
            p0.b(f4706a, th.getMessage());
        }
    }

    public void c(Context context, String str, String str2) {
        a(context, str, str2, "1", new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) {
        if (!com.mbridge.msdk.foundation.same.net.utils.d.h().g()) {
            d(context, str, str2);
        } else {
            b(context, str, str2);
        }
    }

    public void a(Context context, String str, String str2, String str3, com.mbridge.msdk.foundation.same.net.wrapper.d dVar) {
        if (context == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        eVar.a(MBridgeConstans.APP_ID, str);
        eVar.a("sign", SameMD5.getMD5(str + str2));
        try {
            String v0 = h.b().b(str).v0();
            if (TextUtils.isEmpty(v0)) {
                v0 = "";
            }
            eVar.a("vtag", v0);
        } catch (Throwable th) {
            p0.b(f4706a, th.getMessage());
        }
        if (com.mbridge.msdk.foundation.same.net.utils.d.h().r) {
            eVar.a("st_net", com.mbridge.msdk.foundation.same.net.utils.d.h().t + "");
        }
        eVar.a("only_p_info", str3);
        com.mbridge.msdk.setting.net.c cVar = new com.mbridge.msdk.setting.net.c(context);
        String str4 = com.mbridge.msdk.foundation.same.net.utils.d.h().Q;
        try {
            if (com.mbridge.msdk.foundation.same.net.utils.d.h().s && com.mbridge.msdk.foundation.same.net.utils.d.h().r && com.mbridge.msdk.foundation.same.net.utils.d.h().w < com.mbridge.msdk.foundation.same.net.utils.d.h().x.size()) {
                String str5 = com.mbridge.msdk.foundation.same.net.utils.d.h().x.get(com.mbridge.msdk.foundation.same.net.utils.d.h().w);
                if (!TextUtils.isEmpty(str5) && (str5.startsWith("http") || str5.startsWith("https"))) {
                    str4 = str5 + "/setting";
                }
            }
        } catch (Throwable th2) {
            p0.b(f4706a, th2.getMessage());
        }
        cVar.get(1, str4, eVar, dVar, "setting", 60000L);
    }

    public void b(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        a(context, str, str2, "0", new b(str, context, str2));
        a(3, 0, "");
    }

    /* compiled from: SettingRequestController.java */
    class d extends com.mbridge.msdk.foundation.same.net.wrapper.d {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        d(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(JSONObject jSONObject) {
            try {
                if (u0.a(jSONObject)) {
                    String optString = jSONObject.optString("vtag", "");
                    String optString2 = jSONObject.optString("rid", "");
                    JSONArray optJSONArray = jSONObject.optJSONArray("unitSetting");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                        if (jSONObject.optInt("vtag_status", 0) == 1) {
                            String f = h.b().f(this.b, this.c);
                            if (!TextUtils.isEmpty(f)) {
                                try {
                                    optJSONObject = h.b().a(new JSONObject(f), optJSONObject);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        optJSONObject.put("current_time", System.currentTimeMillis());
                        optJSONObject.put("vtag", optString);
                        optJSONObject.put("rid", optString2);
                        h.b().a(this.b, this.c, optJSONObject.toString());
                    }
                } else {
                    h.b().j(this.b, this.c);
                }
                j.this.a(1, 1, "");
            } catch (Exception e2) {
                p0.b(j.f4706a, e2.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(String str) {
            j.this.a(2, 1, "");
        }
    }

    public void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = com.mbridge.msdk.foundation.controller.c.m().b();
            str2 = com.mbridge.msdk.foundation.controller.c.m().c();
        }
        if (h.b().g(str3, str) && h.b().a(str, 2, str3)) {
            com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
            String str4 = C3040d4.i.d + str3 + C3040d4.i.e;
            eVar.a("unit_ids", str4);
            eVar.a(MBridgeConstans.APP_ID, str);
            eVar.a("sign", SameMD5.getMD5(str + str2));
            try {
                String J = h.b().d(str, str4).J();
                if (TextUtils.isEmpty(J)) {
                    J = "";
                }
                eVar.a("vtag", J);
            } catch (Throwable th) {
                p0.b(f4706a, th.getMessage());
            }
            d dVar = new d(str, str3);
            dVar.setUnitId(str3);
            new com.mbridge.msdk.setting.net.c(context).get(1, com.mbridge.msdk.foundation.same.net.utils.d.h().Q, eVar, dVar, "setting", 60000L);
            a(3, 1, "");
        }
    }

    /* compiled from: SettingRequestController.java */
    class b extends com.mbridge.msdk.foundation.same.net.wrapper.d {
        final /* synthetic */ String b;
        final /* synthetic */ Context c;
        final /* synthetic */ String d;

        b(String str, Context context, String str2) {
            this.b = str;
            this.c = context;
            this.d = str2;
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(JSONObject jSONObject) {
            try {
                j.this.a(1, 0, "");
            } catch (Throwable th) {
                p0.b(j.f4706a, th.getMessage());
            }
            try {
                if (u0.a(jSONObject)) {
                    if (jSONObject.optInt("vtag_status", 0) == 1) {
                        String e = h.b().e(this.b);
                        if (!TextUtils.isEmpty(e)) {
                            try {
                                jSONObject = h.b().a(new JSONObject(e), jSONObject);
                            } catch (Exception e2) {
                                p0.b(j.f4706a, e2.getMessage());
                            }
                        }
                    }
                    k.a(jSONObject);
                    jSONObject.put("current_time", System.currentTimeMillis());
                    if (com.mbridge.msdk.foundation.same.net.utils.d.h().s) {
                        if (TextUtils.isEmpty(jSONObject.optString("hst_st_t"))) {
                            jSONObject.put("hst_st_t", com.mbridge.msdk.foundation.same.net.utils.d.h().m);
                        }
                    } else if (TextUtils.isEmpty(jSONObject.optString("hst_st"))) {
                        jSONObject.put("hst_st", com.mbridge.msdk.foundation.same.net.utils.d.h().i);
                    }
                    h.b().h(this.b, jSONObject.toString());
                    com.mbridge.msdk.foundation.same.net.utils.d.h().j();
                    k.a();
                    try {
                        if (!TextUtils.isEmpty(jSONObject.optString("mraid_js"))) {
                            com.mbridge.msdk.setting.util.a.a().a(this.c, jSONObject.optString("mraid_js"));
                        }
                    } catch (Exception e3) {
                        p0.b(j.f4706a, e3.getMessage());
                    }
                    if (!TextUtils.isEmpty(jSONObject.optString("web_env_url"))) {
                        com.mbridge.msdk.setting.util.b.c().a(this.c, jSONObject.optString("web_env_url"));
                    }
                    j.this.a(this.c, this.b);
                } else {
                    h.b().h(this.b);
                }
                j.this.c();
            } catch (Exception e4) {
                p0.b(j.f4706a, e4.getMessage());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.net.wrapper.d
        public void a(String str) {
            try {
                j.this.a(2, 0, str);
            } catch (Throwable th) {
                p0.b(j.f4706a, th.getMessage());
            }
            if (!com.mbridge.msdk.foundation.same.net.utils.d.h().s) {
                com.mbridge.msdk.foundation.same.net.utils.d.h().v++;
            } else {
                com.mbridge.msdk.foundation.same.net.utils.d.h().w++;
            }
            j.this.a(this.c, this.b, this.d);
            j.this.c();
            p0.b(j.f4706a, "get app setting error" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        g d2;
        h b2 = h.b();
        if (b2 != null && (d2 = b2.d(str)) != null) {
            MBridgeConstans.OMID_JS_SERVICE_URL = d2.U();
            MBridgeConstans.OMID_JS_H5_URL = d2.T();
        }
        com.mbridge.msdk.omsdk.b.b(context);
        com.mbridge.msdk.omsdk.b.c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        String str2;
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(C3040d4.h.W, "2000112");
            eVar.a("st_net", Integer.valueOf(com.mbridge.msdk.foundation.same.net.utils.d.h().t));
            eVar.a("result", Integer.valueOf(i));
            eVar.a("type", Integer.valueOf(i2));
            if (i2 == 0) {
                str2 = b();
            } else {
                str2 = com.mbridge.msdk.foundation.same.net.utils.d.h().s ? com.mbridge.msdk.foundation.same.net.utils.d.h().R : com.mbridge.msdk.foundation.same.net.utils.d.h().Q;
            }
            eVar.a("url", str2);
            eVar.a("reason", str);
            cVar.a("2000112", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000112", cVar);
        } catch (Throwable th) {
            p0.b(f4706a, th.getMessage());
        }
    }
}
