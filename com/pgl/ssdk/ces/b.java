package com.pgl.ssdk.ces;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.pgl.ssdk.a0;
import com.pgl.ssdk.b0;
import com.pgl.ssdk.c0;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.d0;
import com.pgl.ssdk.e0;
import com.pgl.ssdk.f;
import com.pgl.ssdk.f0;
import com.pgl.ssdk.f1;
import com.pgl.ssdk.g0;
import com.pgl.ssdk.h0;
import com.pgl.ssdk.i0;
import com.pgl.ssdk.j0;
import com.pgl.ssdk.k0;
import com.pgl.ssdk.l0;
import com.pgl.ssdk.m0;
import com.pgl.ssdk.n0;
import com.pgl.ssdk.o0;
import com.pgl.ssdk.r0;
import com.pgl.ssdk.u;
import com.pgl.ssdk.v;
import com.pgl.ssdk.w;
import com.pgl.ssdk.w0;
import com.pgl.ssdk.x;
import com.pgl.ssdk.x0;
import com.pgl.ssdk.y;
import com.pgl.ssdk.y0;
import com.pgl.ssdk.z;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f6380a = null;
    private static boolean b = false;
    private static Map<String, Object> c = null;
    private static int d = 1;
    private static w0.a e;
    public Context g;
    private String h;
    private int i;
    private String j;
    private String n;
    public boolean f = false;
    private String k = null;
    private String l = null;
    private boolean m = false;
    private boolean o = false;
    public int p = 2;
    public boolean q = true;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            z.b(z.b());
        }
    }

    /* renamed from: com.pgl.ssdk.ces.b$b, reason: collision with other inner class name */
    class RunnableC0576b implements Runnable {
        RunnableC0576b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.c();
            } catch (Throwable unused) {
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.a(b.this.g).a();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.b(b.this.g);
        }
    }

    private b(Context context, String str) {
        this.g = context;
        this.h = str;
    }

    public static b a(Context context, String str, int i, int i2, String str2) {
        if (f6380a == null) {
            synchronized (b.class) {
                if (f6380a == null) {
                    if (context == null) {
                        context = b0.a().getApplicationContext();
                    }
                    if (context == null) {
                        d = 4;
                        return null;
                    }
                    a(i);
                    w0.a b2 = w0.b(context, "nms");
                    if (b2 != null) {
                        d = b2.f6414a;
                        e = b2;
                        return null;
                    }
                    b bVar = new b(context, str);
                    f6380a = bVar;
                    bVar.i = i2;
                    f6380a.j = str2;
                    f6380a.b(context);
                    f6380a.d(a(context));
                    z.c(context);
                    d = 0;
                    r0.b(new a());
                }
            }
        }
        return f6380a;
    }

    private void b(Context context) {
        if (context == null || b) {
            return;
        }
        try {
            com.pgl.ssdk.ces.a.meta(101, null, "1");
            com.pgl.ssdk.ces.a.meta(102, null, this.h);
            com.pgl.ssdk.ces.a.meta(114, null, Integer.valueOf(this.i));
            com.pgl.ssdk.ces.a.meta(105, null, new StringBuilder().append(b0.h(context)).toString());
            com.pgl.ssdk.ces.a.meta(152, null, b0.i(context));
            com.pgl.ssdk.ces.a.meta(153, null, b0.d(context));
            com.pgl.ssdk.ces.a.meta(106, null, b0.f(context));
            com.pgl.ssdk.ces.a.meta(107, null, b0.e(context));
            com.pgl.ssdk.ces.a.meta(108, null, b0.c(context));
            com.pgl.ssdk.ces.a.meta(109, null, b0.d());
            com.pgl.ssdk.ces.a.meta(110, null, b0.c());
            com.pgl.ssdk.ces.a.meta(115, null, this.j);
            b = true;
        } catch (Throwable unused) {
        }
    }

    public static String c() {
        if (h() != null) {
            return h().h;
        }
        return null;
    }

    public static String d() {
        if (h() != null) {
            return h().k;
        }
        return null;
    }

    public static String f() {
        b h = h();
        if (h == null || !h.m || TextUtils.isEmpty(h.l)) {
            return null;
        }
        return h.l;
    }

    public static int g() {
        return d;
    }

    public static b h() {
        return f6380a;
    }

    public static w0.a i() {
        return e;
    }

    public long e() {
        return z.a(this.g);
    }

    public String j() {
        return z.c();
    }

    public String k() {
        return f1.a();
    }

    public void l() {
        this.o = true;
        f1.a(this.g, this.h);
        a("Start", (Map<String, Object>) null);
    }

    private void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n = str;
        com.pgl.ssdk.ces.a.meta(104, null, str);
    }

    public synchronized void c(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.l)) {
            com.pgl.ssdk.ces.a.meta(111, null, str);
            this.l = str;
            f1.b();
        }
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.k)) {
            this.k = str;
            com.pgl.ssdk.ces.a.meta(103, null, str);
            f1.b();
        }
    }

    public void b() {
        r0.b(new d());
    }

    private static String a(Context context) {
        String a2 = x0.a(context, "iid");
        if (!TextUtils.isEmpty(a2)) {
            return a2;
        }
        String uuid = UUID.randomUUID().toString();
        x0.b(context, "iid", uuid);
        return uuid;
    }

    public static void a(int i) {
        n0.a(i);
    }

    public void a(String str, String str2, String str3, String str4) {
        b(str2);
        c(str4);
        try {
            l();
        } catch (Throwable unused) {
        }
    }

    public Map<String, String> a(String str, byte[] bArr) {
        HashMap hashMap = new HashMap();
        if (str == null) {
            str = "";
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        String str2 = (String) com.pgl.ssdk.ces.a.meta(224, this.g, new Object[]{str, bArr});
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("X-Armors", str2);
        }
        return hashMap;
    }

    public void a(String str, Map<String, Object> map) {
        try {
            long j = "Start".equals(str) ? 10000L : 0L;
            Handler b2 = r0.b();
            if (b2 != null) {
                b2.postDelayed(new o0(this.g, Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, new Object[]{str, map}), j);
                if (this.q && "Start".equals(str)) {
                    b2.postDelayed(new RunnableC0576b(), j * 2);
                }
            }
            a();
            z.a();
        } catch (Throwable unused) {
        }
    }

    public Object a(int i, Object obj) {
        if (i == 123) {
            return f0.a(this.g);
        }
        if (i == 121) {
            return d0.a();
        }
        if (i == 122) {
            return d0.b();
        }
        if (i == 126) {
            return d0.b(this.g);
        }
        if (i == 128) {
            return d0.c(this.g);
        }
        if (i == 120) {
            return c0.c();
        }
        if (i == 124) {
            return g0.c(this.g);
        }
        if (i == 130) {
            return g0.a(this.g);
        }
        if (i == 145) {
            return h0.c(this.g);
        }
        if (i == 125) {
            return g0.b(this.g);
        }
        if (i == 129) {
            return e0.f(this.g);
        }
        if (i == 141) {
            return e0.e(this.g);
        }
        if (i == 134) {
            return k0.a(this.g).b();
        }
        if (i == 140) {
            return l0.a(this.g).e();
        }
        if (i == 144) {
            return l0.a(this.g).d();
        }
        if (i == 133) {
            return a(obj);
        }
        if (i == 135) {
            return v.f();
        }
        if (i == 201) {
            return d0.a(this.g);
        }
        if (i == 202) {
            return d0.c();
        }
        if (i == 236) {
            return y0.a((String) obj);
        }
        if (i == 142) {
            return b0.g(this.g);
        }
        if (i == 143) {
            return h0.a(this.g);
        }
        if (i == 146) {
            try {
                return v.b();
            } catch (Throwable unused) {
                return null;
            }
        }
        if (i == 147) {
            return Boolean.valueOf(b0.j(this.g));
        }
        if (i == 148) {
            return u.b(this.g);
        }
        if (i == 149) {
            return w.a(this.g);
        }
        if (i == 150) {
            return Integer.valueOf(x.a());
        }
        if (i == 151) {
            return w.c();
        }
        if (i == 161) {
            return Boolean.valueOf(v.g());
        }
        if (i == 163) {
            return j0.a();
        }
        if (i == 169) {
            return Boolean.valueOf(a0.a(this.g));
        }
        if (i == 170) {
            return Integer.valueOf(y.b((String) obj));
        }
        if (i == 203) {
            return b0.b();
        }
        if (i == 205) {
            return Integer.valueOf(b0.k(this.g));
        }
        if (i == 204) {
            return Integer.valueOf(e0.a(this.g));
        }
        if (i == 206) {
            return h0.b(this.g);
        }
        return null;
    }

    public void a(MotionEvent motionEvent) {
        y.a(motionEvent, this.g);
    }

    public synchronized void a(Map<String, Object> map) {
        char c2;
        if (map != null) {
            if (!map.isEmpty()) {
                try {
                    for (String str : map.keySet()) {
                        Object obj = map.get(str);
                        if (obj != null) {
                            switch (str.hashCode()) {
                                case -2021683300:
                                    if (str.equals(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST)) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -1195280656:
                                    if (str.equals(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR)) {
                                        c2 = 5;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 156851746:
                                    if (str.equals(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS)) {
                                        c2 = 3;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 398905722:
                                    if (str.equals(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ)) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 485444716:
                                    if (str.equals(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC)) {
                                        c2 = 4;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 500804551:
                                    if (str.equals(PglSSConfig.CUSTOMINFO_KEY_IPV6)) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            if (c2 != 0) {
                                if (c2 != 1) {
                                    if (c2 != 2) {
                                        if (c2 != 3) {
                                            if (c2 != 4) {
                                                if (c2 != 5) {
                                                    continue;
                                                } else if (obj instanceof String) {
                                                    a((String) obj);
                                                }
                                            } else if (obj instanceof String) {
                                                n0.b((String) obj);
                                            }
                                        } else if (obj instanceof Set) {
                                            try {
                                                Set set = (Set) obj;
                                                com.pgl.ssdk.ces.a.meta(165, null, Boolean.valueOf(set.contains("boot")));
                                                com.pgl.ssdk.ces.a.meta(166, null, Boolean.valueOf(set.contains("mnc")));
                                                com.pgl.ssdk.ces.a.meta(167, null, Boolean.valueOf(set.contains("mcc")));
                                                com.pgl.ssdk.ces.a.meta(168, null, Boolean.valueOf(set.contains("gaid")));
                                                this.m = set.contains("gaid");
                                            } catch (Throwable unused) {
                                            }
                                        }
                                    } else if (obj instanceof String) {
                                        n0.a((String) obj);
                                    }
                                } else if (obj instanceof String) {
                                    String str2 = (String) obj;
                                    if (!TextUtils.isEmpty(str2)) {
                                        m0.a(str2);
                                    }
                                }
                            } else if (obj instanceof String) {
                                String a2 = i0.a((String) obj);
                                if (!TextUtils.isEmpty(a2)) {
                                    com.pgl.ssdk.ces.a.meta(159, null, a2);
                                }
                            }
                        }
                    }
                    if (c == null) {
                        c = new HashMap();
                    }
                    c.putAll(map);
                } catch (Throwable unused2) {
                }
            }
        }
    }

    private void a(String str) {
        char c2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                switch (next.hashCode()) {
                    case -417749689:
                        if (next.equals("touch_trace_enabled")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -93508180:
                        if (next.equals("autoctl_detect_enable")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 449342513:
                        if (next.equals("craw_ratio")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 944591168:
                        if (next.equals("report_ratio")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1286849298:
                        if (next.equals("app_switch")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                if (c2 == 4 && (obj instanceof Boolean)) {
                                    y.g = ((Boolean) obj).booleanValue();
                                }
                            } else if ((obj instanceof Integer) && ((Integer) obj).intValue() > 0) {
                                f.b = ((Integer) obj).intValue();
                            }
                        } else if (obj instanceof Boolean) {
                            this.q = ((Boolean) obj).booleanValue();
                        }
                    } else if ((obj instanceof Integer) && ((Integer) obj).intValue() > 0) {
                        this.p = ((Integer) obj).intValue();
                    }
                } else if (obj instanceof Boolean) {
                    k0.b = ((Boolean) obj).booleanValue();
                }
            }
        } catch (JSONException unused) {
        }
    }

    private String a(Object obj) {
        Map<String, Object> map;
        if (!(obj instanceof String) || !"Start".equals((String) obj) || (map = c) == null || map.isEmpty()) {
            return "{}";
        }
        try {
            return new JSONObject(c).toString();
        } catch (Exception unused) {
            return "{}";
        }
    }

    public void a() {
        r0.b(new c());
    }
}
