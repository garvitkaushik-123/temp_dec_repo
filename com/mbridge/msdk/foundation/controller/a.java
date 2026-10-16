package com.mbridge.msdk.foundation.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.x0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseMBSDKContext.java */
/* loaded from: classes6.dex */
public abstract class a {
    public static final String q = "c";
    public static HashMap<String, String> r = new HashMap<>();
    protected String b;
    protected Context c;
    protected String d;
    private WeakReference<Activity> e;
    private String f;
    private int g;
    private String j;
    private String k;
    private int l;
    private WeakReference<Context> n;
    private JSONObject o;

    /* renamed from: a, reason: collision with root package name */
    private final r f4197a = new r();
    private JSONObject h = new JSONObject();
    private boolean i = false;
    private ConcurrentHashMap<String, String> m = new ConcurrentHashMap<>();
    private int p = 0;

    /* compiled from: BaseMBSDKContext.java */
    /* renamed from: com.mbridge.msdk.foundation.controller.a$a, reason: collision with other inner class name */
    class RunnableC0328a implements Runnable {
        RunnableC0328a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.report.crashreport.e.a(a.this.c).a();
        }
    }

    /* compiled from: BaseMBSDKContext.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.same.report.crashreport.d.c();
        }
    }

    /* compiled from: BaseMBSDKContext.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.b = (String) x0.a(aVar.c, "sp_appId", "");
            } catch (Throwable th) {
                p0.b(a.q, th.getMessage());
            }
        }
    }

    /* compiled from: BaseMBSDKContext.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a aVar = a.this;
                aVar.j = (String) x0.a(aVar.c, "sp_appKey", "");
            } catch (Throwable th) {
                p0.b(a.q, th.getMessage());
            }
        }
    }

    /* compiled from: BaseMBSDKContext.java */
    public interface e {
    }

    private void l() {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.b.i() && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                Object a2 = x0.a(this.c, MBridgeConstans.SP_GA_ID, "");
                Object a3 = x0.a(this.c, MBridgeConstans.SP_GA_ID_LIMIT, 0);
                if (a2 instanceof String) {
                    String str = (String) a2;
                    if (TextUtils.isEmpty(str)) {
                        f.d();
                    } else {
                        f.a(str);
                    }
                    if (a3 instanceof Integer) {
                        f.a(((Integer) a3).intValue());
                    }
                }
            }
        } catch (Exception e2) {
            p0.b(q, e2.getMessage());
        }
    }

    protected abstract void a(e eVar);

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.p = i;
    }

    public Context d() {
        return this.c;
    }

    public r e() {
        return this.f4197a;
    }

    public Context f() {
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int g() {
        return this.g;
    }

    public String h() {
        try {
            if (!TextUtils.isEmpty(this.d)) {
                return this.d;
            }
            Context context = this.c;
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            this.d = packageName;
            return packageName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String i() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        Context context = this.c;
        if (context != null) {
            return (String) x0.a(context, "sp_wx_appKey", "");
        }
        return null;
    }

    public JSONObject j() {
        return this.o;
    }

    public int k() {
        return this.p;
    }

    public WeakReference<Activity> a() {
        return this.e;
    }

    public void b(e eVar) {
        try {
            l0.C(this.c);
            a(eVar);
            h.a(this.c, this.b);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                try {
                    try {
                        l0.d(this.c.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled ? 1 : 2);
                    } catch (Throwable th) {
                        p0.b(q, th.getMessage());
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    l0.d(0);
                }
            }
            try {
                g d2 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d2 == null) {
                    d2 = h.b().a();
                }
                r e2 = com.mbridge.msdk.foundation.controller.c.m().e();
                if (e2 != null && e2.b() && d2 != null && d2.E() == 1) {
                    com.mbridge.msdk.foundation.same.threadpool.a.c().post(new RunnableC0328a());
                }
                if (e2 == null || !e2.a()) {
                    return;
                }
                com.mbridge.msdk.foundation.same.threadpool.a.c().post(new b());
            } catch (Throwable th2) {
                p0.b(q, th2.getMessage());
            }
        } catch (Exception e3) {
            p0.b(q, e3.getMessage());
        }
    }

    public void c(e eVar) {
        if (this.i) {
            return;
        }
        l();
        try {
            JSONObject jSONObject = new JSONObject();
            this.o = jSONObject;
            jSONObject.put("webgl", 0);
        } catch (JSONException e2) {
            p0.b(q, e2.getMessage());
        }
        b(eVar);
    }

    public void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.k = str;
            Context context = this.c;
            if (context != null) {
                x0.b(context, "sp_wx_appKey", str);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str) {
        Context context;
        try {
            this.b = str;
            if (TextUtils.isEmpty(str) || (context = this.c) == null) {
                return;
            }
            x0.b(context, "sp_appId", str);
        } catch (Exception e2) {
            p0.b(q, e2.getMessage());
        }
    }

    public void f(String str) {
        Context context;
        try {
            this.j = str;
            if (TextUtils.isEmpty(str) || (context = this.c) == null) {
                return;
            }
            x0.b(context, "sp_appKey", str);
        } catch (Exception e2) {
            p0.b(q, e2.getMessage());
        }
    }

    public void a(WeakReference<Activity> weakReference) {
        this.e = weakReference;
    }

    public void a(Context context) {
        if (context instanceof Activity) {
            this.n = new WeakReference<>(context);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public BitmapDrawable a(String str, int i) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        int i2;
        String str2;
        int i3;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.m) == null || !concurrentHashMap.containsKey(str) || !r0.a().a("w_m_r_l", true)) {
            return null;
        }
        String str3 = this.m.get(str);
        BitmapDrawable n = u0.n(str3);
        int i4 = TextUtils.isEmpty(str3) ? 2 : 1;
        String str4 = TextUtils.isEmpty(str3) ? "get watermark failed" : n != null ? "" : "str to bitmap failed";
        if (n == null) {
            i2 = 2;
            i3 = i;
            str2 = str;
        } else {
            i2 = 1;
            str2 = str;
            i3 = i;
        }
        j.a(str2, i3, i4, str4, i2, str3);
        return n;
    }

    public void a(JSONObject jSONObject) {
        this.o = jSONObject;
    }

    public void a(String str) {
        try {
            if (this.m != null && !TextUtils.isEmpty(str) && this.m.containsKey(str)) {
                this.m.remove(str);
            }
        } catch (Exception e2) {
            p0.b(q, e2.getMessage());
        }
    }

    public String c() {
        try {
            if (!TextUtils.isEmpty(this.j)) {
                return this.j;
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new d());
            return "";
        } catch (Throwable th) {
            p0.b(q, th.getMessage());
            return "";
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (r0.a().a("w_m_r_l", true)) {
            try {
                if (this.h == null) {
                    this.h = jSONObject;
                } else if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.h.put(next, jSONObject.get(next));
                    }
                }
                if (this.h.has(MBridgeConstans.EXTRA_KEY_WM)) {
                    if (this.m == null) {
                        this.m = new ConcurrentHashMap<>();
                    }
                    this.m.put(str, this.h.getString(MBridgeConstans.EXTRA_KEY_WM));
                }
            } catch (Exception e2) {
                p0.b(q, e2.getMessage());
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
    }

    public String b() {
        try {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new c());
            return "";
        } catch (Exception e2) {
            p0.b(q, e2.getMessage());
            return "";
        }
    }

    public void b(String str) {
        Context context;
        try {
            this.f = str;
            if (TextUtils.isEmpty(str) || (context = this.c) == null) {
                return;
            }
            x0.b(context, "applicationIds", str);
        } catch (Exception e2) {
            p0.b(q, e2.getMessage());
        }
    }

    public void b(Context context) {
        this.c = context;
    }
}
