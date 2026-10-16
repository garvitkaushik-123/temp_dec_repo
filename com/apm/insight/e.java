package com.apm.insight;

import android.app.Application;
import android.content.Context;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.g;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: NpthBus.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static Context f235a = null;
    private static Application b = null;
    private static long c = 0;
    private static String d = "default";
    private static boolean e = false;
    private static com.apm.insight.nativecrash.b f;
    private static volatile ConcurrentHashMap<Integer, String> i;
    private static volatile String n;
    private static ConfigManager g = new ConfigManager();
    private static a h = new a();
    private static g j = null;
    private static volatile String k = null;
    private static Object l = new Object();
    private static volatile int m = 0;
    private static int o = 0;
    private static boolean p = true;
    private static boolean q = true;
    private static boolean r = false;
    private static boolean s = true;
    private static boolean t = true;
    private static boolean u = true;

    public static com.apm.insight.nativecrash.b a() {
        if (f == null) {
            f = g.a(f235a);
        }
        return f;
    }

    public static void a(com.apm.insight.nativecrash.b bVar) {
        f = bVar;
    }

    public static a b() {
        return h;
    }

    public static g c() {
        if (j == null) {
            synchronized (e.class) {
                j = new g();
            }
        }
        return j;
    }

    public static void a(Application application) {
        if (application != null) {
            b = application;
        }
    }

    public static void a(Application application, Context context) {
        if (b == null) {
            c = System.currentTimeMillis();
            f235a = context;
            b = application;
            k = Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
        }
    }

    static void a(Application application, Context context, ICommonParams iCommonParams) {
        a(application, context);
        f = new com.apm.insight.nativecrash.b(f235a, iCommonParams, a());
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
    }

    public static String a(long j2, CrashType crashType, boolean z, boolean z2) {
        return j2 + "_" + crashType.getName() + '_' + f() + '_' + (z ? "oom_" : "normal_") + c + '_' + (z2 ? "ignore_" : "normal_") + Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
    }

    public static String f() {
        if (k == null) {
            synchronized (l) {
                if (k == null) {
                    k = Long.toHexString(new Random().nextLong()) + "U";
                }
            }
        }
        return k;
    }

    public static Context g() {
        return f235a;
    }

    public static Application h() {
        return b;
    }

    public static ConfigManager i() {
        return g;
    }

    public static long j() {
        return c;
    }

    public static String k() {
        return d;
    }

    static void a(String str) {
        d = str;
    }

    public static void l() {
        o = 1;
    }

    public static int m() {
        return o;
    }

    public static boolean n() {
        return e;
    }

    static void o() {
        e = true;
    }

    static void a(int i2, String str) {
        if (i == null) {
            synchronized (e.class) {
                if (i == null) {
                    i = new ConcurrentHashMap<>();
                }
            }
        }
        i.put(Integer.valueOf(i2), str);
    }

    public static ConcurrentHashMap<Integer, String> p() {
        return i;
    }

    static void b(int i2, String str) {
        m = i2;
        n = str;
    }

    public static int q() {
        return m;
    }

    public static String r() {
        return n;
    }

    public static void a(boolean z) {
        p = z;
    }

    public static void b(boolean z) {
        q = z;
    }

    public static void c(boolean z) {
        r = z;
    }

    public static void d(boolean z) {
        s = z;
    }

    public static boolean s() {
        return p;
    }

    public static boolean t() {
        return q;
    }

    public static boolean u() {
        return r;
    }

    public static boolean v() {
        return s;
    }

    public static boolean w() {
        return u;
    }

    public static void e(boolean z) {
        u = z;
    }

    public static boolean x() {
        return t;
    }

    public static void f(boolean z) {
        t = z;
    }

    public static boolean d() {
        String valueOf;
        if (!g.isDebugMode()) {
            return false;
        }
        Object obj = a().a().get("channel");
        if (obj == null) {
            valueOf = "unknown";
        } else {
            valueOf = String.valueOf(obj);
        }
        return valueOf.contains("local_test");
    }
}
