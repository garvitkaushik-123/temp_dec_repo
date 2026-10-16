package com.mbridge.msdk.foundation.same.net.utils;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.e;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: RequestControlUtil.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f4298a;
    private int b;
    private ConcurrentHashMap<String, b> c;
    private ArrayList<Integer> d;

    /* compiled from: RequestControlUtil.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f4299a;
        public String b;
        public long c;

        public b(long j, int i, String str) {
            this.c = j;
            this.f4299a = i;
            this.b = str;
        }
    }

    /* compiled from: RequestControlUtil.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.utils.c$c, reason: collision with other inner class name */
    private static class C0338c {

        /* renamed from: a, reason: collision with root package name */
        private static final c f4300a = new c();
    }

    private List<Integer> a() {
        return Arrays.asList(-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616);
    }

    public static c b() {
        return C0338c.f4300a;
    }

    private c() {
        this.f4298a = "IDErrorUtil";
        this.c = new ConcurrentHashMap<>();
        this.d = new ArrayList<>();
        g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        d = d == null ? h.b().a() : d;
        this.b = d.t() * 1000;
        if (d.x() == null || d.x().size() <= 0) {
            p0.b("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
            this.d.addAll(a());
        } else {
            p0.b("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
            this.d.addAll(d.x());
        }
    }

    public synchronized void a(String str, int i, String str2, long j) {
        if (this.c.containsKey(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.d.contains(Integer.valueOf(i))) {
            p0.b("IDErrorUtil", "addErrorInfo : " + str + " " + str2);
            this.c.put(str, new b(j, i, str2));
        }
    }

    public e a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar) {
        String str = eVar.a().get(MBridgeConstans.APP_ID);
        String str2 = eVar.a().get(AndroidBridgeConstants.PLACEMENT_ID);
        String str3 = TextUtils.isEmpty(str2) ? "" : str2;
        String str4 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (TextUtils.isEmpty(str4)) {
            str4 = eVar.a().get("unit_ids");
            if (!TextUtils.isEmpty(str4)) {
                str4 = str4.replace(C3040d4.i.d, "").replace(C3040d4.i.e, "");
            }
        }
        String str5 = str4;
        String str6 = eVar.a().get("ad_type");
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        return a(str, str5, str3, eVar.a().get("token"), str6);
    }

    private e a(String str, String str2, String str3, String str4, String str5) {
        int parseInt;
        String str6 = str + "_" + str3 + "_" + str2 + "_" + str5;
        b a2 = a(str6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mbridge.msdk.tracker.network.g("data_res_type", "1"));
        if (a2 != null && !TextUtils.isEmpty(a2.b)) {
            try {
                if (a2.f4299a != -1) {
                    return e.a(new JSONObject(a2.b), new com.mbridge.msdk.foundation.same.net.toolbox.a(200, a2.b.getBytes(), arrayList));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (str5 != null && !TextUtils.isEmpty(str5) && (parseInt = Integer.parseInt(str5)) != 287 && parseInt != 94) {
                    if (System.currentTimeMillis() < (h.b().c(str, str2).u() * 1000) + a2.c) {
                        return e.a(new JSONObject(a2.b), new com.mbridge.msdk.foundation.same.net.toolbox.a(200, a2.b.getBytes(), arrayList));
                    }
                    this.c.remove(str6);
                    return null;
                }
            } catch (Exception e) {
                p0.b("IDErrorUtil", e.getMessage());
            }
        }
        p0.b("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }

    private synchronized b a(String str) {
        b bVar;
        p0.b("IDErrorUtil", "getErrorInfo : " + str);
        if (!this.c.containsKey(str) || (bVar = this.c.get(str)) == null) {
            return null;
        }
        if (bVar.f4299a == -1) {
            return bVar;
        }
        if (System.currentTimeMillis() > bVar.c + this.b) {
            this.c.remove(str);
            if (this.c.size() > 0) {
                for (Map.Entry<String, b> entry : this.c.entrySet()) {
                    p0.b("IDErrorUtil", "getErrorInfo : delete timeout entry");
                    if (System.currentTimeMillis() - entry.getValue().c > this.b) {
                        this.c.remove(entry.getKey());
                    }
                }
            }
            return null;
        }
        p0.b("IDErrorUtil", "getErrorInfo : " + bVar.b);
        return bVar;
    }
}
