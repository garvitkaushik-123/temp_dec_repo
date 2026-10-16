package com.mbridge.msdk.setting;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.f0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.x0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SettingManager.java */
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4705a = "h";
    private static volatile h b;
    private static volatile g c;
    private static HashMap<String, l> d = new HashMap<>();

    private h() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str) {
        FastKV build;
        Map<String, Object> map = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            try {
                build = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
            }
            if (build != null) {
                try {
                    Map<String, ?> all = context.getSharedPreferences("mbridge", 0).getAll();
                    for (String str2 : all.keySet()) {
                        if (str2.startsWith(str + "_")) {
                            d.put(str2, l.l((String) all.get(str2)));
                        }
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                map = build.getAll();
            } catch (Exception unused2) {
            }
            if (map != null) {
                try {
                    for (String str3 : map.keySet()) {
                        if (str3.startsWith(str + "_")) {
                            d.put(str3, l.l((String) map.get(str3)));
                        }
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            return;
        }
        build = null;
        if (build != null) {
        }
    }

    public static h b() {
        if (b == null) {
            synchronized (h.class) {
                if (b == null) {
                    b = new h();
                }
            }
        }
        return b;
    }

    public g c() {
        return c != null ? c : a();
    }

    public g d(String str) {
        if (c == null) {
            try {
                String a2 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str);
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.has(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                        jSONObject.remove(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    }
                    if (jSONObject.has("c")) {
                        jSONObject.remove("c");
                    }
                    c = g.C(jSONObject.toString());
                    if (c != null) {
                        c.K0();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
    }

    public l e(String str, String str2) {
        l b2 = b(str, str2);
        if (b2 != null && b2.L() == 0) {
            b2.d(1);
        }
        return b2;
    }

    public String f(String str, String str2) {
        return com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str + "_" + str2);
    }

    public boolean g(String str, String str2) {
        g d2 = d(str2);
        if (f(str2) && a(str2, 1, str)) {
            new j().b(com.mbridge.msdk.foundation.controller.c.m().d(), str2, com.mbridge.msdk.foundation.controller.c.m().c());
        }
        l e = e(str2, str);
        if (d2 != null && e != null) {
            long q0 = d2.q0() * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            long o = e.o() + q0;
            if (o > currentTimeMillis) {
                p0.c(f4705a, "unit setting  nexttime is not ready  [settingNextRequestTime= " + o + " currentTime = " + currentTimeMillis + C3040d4.i.e);
                return false;
            }
        }
        p0.c(f4705a, "unit setting timeout or not exists");
        return true;
    }

    public void h(String str) {
        try {
            String e = e(str);
            if (TextUtils.isEmpty(e)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(e);
            jSONObject.put("current_time", System.currentTimeMillis());
            h(str, jSONObject.toString());
        } catch (Throwable th) {
            p0.b(f4705a, th.getMessage());
        }
    }

    public void i(String str, String str2) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("ivreward_" + str, str2);
    }

    public void j(String str, String str2) {
        try {
            String a2 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str + "_" + str2);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(a2);
            jSONObject.put("current_time", System.currentTimeMillis());
            a(str, str2, jSONObject.toString());
        } catch (Throwable th) {
            p0.b(f4705a, th.getMessage());
        }
    }

    public boolean f(String str) {
        g d2 = d(str);
        if (d2 != null) {
            long A = d2.A() * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            long w = d2.w() + A;
            if (w > currentTimeMillis) {
                p0.c(f4705a, "app setting nexttime is not ready  [settingNextRequestTime= " + w + " currentTime = " + currentTimeMillis + C3040d4.i.e);
                return false;
            }
        }
        p0.c(f4705a, "app setting timeout or not exists");
        return true;
    }

    public String c(String str) {
        return com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("ivreward_" + str);
    }

    public l c(String str, String str2) {
        l a2 = a(str, str2);
        return a2 == null ? l.N() : a2;
    }

    public String e(String str) {
        if (str == null) {
            return "";
        }
        try {
            String a2 = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str);
            return a2 == null ? "" : a2;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }

    public g b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return a();
            }
            g d2 = d(str);
            return d2 == null ? a() : d2;
        } catch (Exception unused) {
            return a();
        }
    }

    public void h(String str, String str2) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str, str2);
        c = g.C(str2);
        if (c != null) {
            c.K0();
        }
        i.a(c);
        f0.a().a(c.Q());
    }

    private l b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = com.mbridge.msdk.foundation.controller.c.m().b();
        }
        String str3 = str + "_" + str2;
        if (d.containsKey(str3)) {
            return d.get(str3);
        }
        l lVar = null;
        try {
            lVar = l.l(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str3));
            d.put(str3, lVar);
            return lVar;
        } catch (Exception e) {
            e.printStackTrace();
            return lVar;
        }
    }

    public void g(String str) {
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().c("ivreward_" + str);
    }

    public l d(String str, String str2) {
        l e = e(str, str2);
        return e == null ? l.N() : e;
    }

    public void a(String str) {
        i.a(str, this);
    }

    public g a() {
        return i.a();
    }

    public l a(String str, String str2) {
        return b(str, str2);
    }

    public boolean a(String str, int i, String str2) {
        try {
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            String str3 = str + "_" + i + "_" + str2;
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            long longValue = ((Long) x0.a(d2, str3, 0L)).longValue();
            g d3 = d(str);
            if (d3 == null) {
                d3 = b().a();
            } else {
                j = longValue;
            }
            if (j + (d3.l0() * 1000) > currentTimeMillis) {
                return false;
            }
            x0.b(d2, str3, Long.valueOf(currentTimeMillis));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return jSONObject2;
        }
        if (jSONObject2 != null && jSONObject2.length() != 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if ("unitSetting".equals(next) && jSONObject.has("unitSetting")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("unitSetting");
                        jSONArray.put(0, a((JSONObject) jSONArray.get(0), (JSONObject) jSONObject2.getJSONArray("unitSetting").get(0)));
                        jSONObject.put(next, jSONArray);
                    } else {
                        jSONObject.put(next, jSONObject2.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject;
    }

    public void a(String str, String str2, String str3) {
        String str4 = str + "_" + str2;
        com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(str4, str3);
        d.put(str4, l.l(str3));
    }
}
