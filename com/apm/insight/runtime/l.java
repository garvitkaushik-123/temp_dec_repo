package com.apm.insight.runtime;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.IOOMCallback;
import com.apm.insight.b.h;
import com.apm.insight.b.i;
import com.apm.insight.nativecrash.NativeImpl;
import java.io.File;
import java.util.Map;

/* compiled from: NpthCore.java */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f334a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static c f = new c();
    private static volatile boolean g = false;
    private static boolean h = false;

    static /* synthetic */ boolean r() {
        g = true;
        return true;
    }

    public static c a() {
        return f;
    }

    public static boolean b() {
        return b;
    }

    public static boolean c() {
        return c;
    }

    public static boolean d() {
        return d;
    }

    public static boolean e() {
        return f334a;
    }

    public static void f() {
        if (!f334a || b) {
            return;
        }
        Context g2 = com.apm.insight.e.g();
        com.apm.insight.g.a a2 = com.apm.insight.g.a.a();
        a2.a(new com.apm.insight.i.b(g2));
        a2.b(new com.apm.insight.g.d(g2));
    }

    public static void g() {
        if (f334a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).c();
            c = true;
        }
    }

    public static boolean h() {
        if (f334a && !d) {
            boolean a2 = NativeImpl.a(com.apm.insight.e.g());
            d = a2;
            if (!a2) {
                e = true;
            }
        }
        return d;
    }

    public static synchronized void a(Context context) {
        Application application;
        synchronized (l.class) {
            if (com.apm.insight.e.h() != null) {
                application = com.apm.insight.e.h();
            } else if (context instanceof Application) {
                application = (Application) context;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("The Application passed in when init has not been attached, please pass a attachBaseContext as param and call Npth.setApplication(Application) before init.");
                }
            } else {
                application = (Application) context.getApplicationContext();
                if (application == null) {
                    throw new IllegalArgumentException("Can not get the Application instance since a baseContext was passed in when init, please call Npth.setApplication(Application) before init.");
                }
                if (application.getBaseContext() != null) {
                    context = application.getBaseContext();
                }
            }
            a(application, context);
        }
    }

    public static synchronized void a(Application application, Context context) {
        synchronized (l.class) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (f334a) {
                return;
            }
            f334a = true;
            if (context == null || application == null) {
                throw new IllegalArgumentException("context or Application must be not null.");
            }
            com.apm.insight.e.a(application, context);
            if (com.apm.insight.e.u() && (b(application) || c(application))) {
                Log.e("apminsight", "Inner npth checked.");
                return;
            }
            com.apm.insight.g.a a2 = com.apm.insight.g.a.a();
            a2.a(new com.apm.insight.i.b(context));
            a2.b(new com.apm.insight.g.d(context));
            b = true;
            NativeImpl.a();
            boolean a3 = NativeImpl.a(context);
            d = a3;
            if (!a3) {
                e = true;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                g = true;
                NativeImpl.i();
            }
            m.a().a(new Runnable() { // from class: com.apm.insight.runtime.l.2

                /* renamed from: a, reason: collision with root package name */
                private /* synthetic */ boolean f336a = true;

                @Override // java.lang.Runnable
                public final void run() {
                    if (!l.g) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.apm.insight.runtime.l.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                l.r();
                                NativeImpl.i();
                            }
                        });
                    }
                    l.e(this.f336a);
                }
            }, 0L);
            com.apm.insight.a.a((Object) ("Npth.init takes " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms."));
        }
    }

    public static void a(final String str, final h.a aVar) {
        m.a().a(new Runnable() { // from class: com.apm.insight.runtime.l.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                    com.apm.insight.b.d.a(str, aVar);
                }
            }
        });
    }

    public static void a(h.a aVar) {
        h.a(aVar);
    }

    public static boolean i() {
        return com.apm.insight.b.c.c();
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, aVar);
    }

    public static void a(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, Map<String, String> map3, h.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.apm.insight.d.a.a(str, map, map2, map3, aVar);
    }

    @Deprecated
    public static void a(Throwable th) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.a(th);
        }
    }

    @Deprecated
    public static void b(String str) {
        if (com.apm.insight.e.i().isReportErrorEnable()) {
            com.apm.insight.g.a.c(str);
        }
    }

    public static void j() {
        if (f334a) {
            com.apm.insight.b.f.a(com.apm.insight.e.g()).d();
            c = false;
        }
    }

    public static void b(h.a aVar) {
        com.apm.insight.k.e.a(aVar);
    }

    public static void a(String str, i.a aVar, i.a aVar2) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return;
        }
        com.apm.insight.a.a.a().a(str, aVar, aVar2);
    }

    public static void k() {
        NativeImpl.c();
    }

    public static void a(long j) {
        NativeImpl.a(j);
    }

    public static void b(long j) {
        NativeImpl.b(j);
    }

    public static boolean l() {
        return com.apm.insight.g.a.b() || NativeImpl.e();
    }

    public static boolean m() {
        return com.apm.insight.g.a.c() || NativeImpl.e();
    }

    public static boolean n() {
        return com.apm.insight.g.a.b();
    }

    public static void c(String str) {
        NativeImpl.b(str);
    }

    public static void a(i.a aVar) {
        com.apm.insight.e.i().setEncryptImpl$22f2d42e(aVar);
    }

    public static boolean o() {
        return h;
    }

    public static void p() {
        h = true;
    }

    public static void a(boolean z) {
        com.apm.insight.e.a(z);
    }

    public static void b(boolean z) {
        com.apm.insight.e.b(z);
    }

    public static void c(boolean z) {
        com.apm.insight.e.c(z);
    }

    public static void d(boolean z) {
        com.apm.insight.e.d(z);
    }

    private static boolean b(Context context) {
        try {
            return new File(com.apm.insight.l.j.j(context), "npth").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(Context context) {
        try {
            return new File(context.getApplicationInfo().nativeLibraryDir, "libapminsighta.so").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(ICrashCallback iCrashCallback, CrashType crashType) {
        f.a(iCrashCallback, crashType);
    }

    public static void a(IOOMCallback iOOMCallback) {
        f.a(iOOMCallback);
    }

    public static void b(ICrashCallback iCrashCallback, CrashType crashType) {
        f.b(iCrashCallback, crashType);
    }

    public static void b(IOOMCallback iOOMCallback) {
        f.b(iOOMCallback);
    }

    static /* synthetic */ void e(boolean z) {
        Context g2 = com.apm.insight.e.g();
        com.apm.insight.runtime.a.f.a();
        j.a();
        int b2 = NativeImpl.b();
        NativeImpl.d();
        if (e) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("NativeLibraryLoad faild");
        } else if (b2 < 0) {
            com.apm.insight.c.a();
            com.apm.insight.b.a.a("createCallbackThread faild");
        }
        com.apm.insight.e.a.a().a(g2);
        com.apm.insight.c.a();
        com.apm.insight.k.h.a(g2);
        if (z) {
            com.apm.insight.b.f.a(g2).c();
            c = z;
        }
        com.apm.insight.k.g.a().b();
        NativeImpl.g();
        com.apm.insight.k.j.d();
        NativeImpl.k();
        n.a("afterNpthInitAsync", "noValue");
    }
}
