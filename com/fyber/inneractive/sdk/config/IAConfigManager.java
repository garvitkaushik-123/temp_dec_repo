package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q1;
import com.fyber.inneractive.sdk.web.a1;
import com.fyber.inneractive.sdk.web.b1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class IAConfigManager {
    public static long P;
    public final com.fyber.inneractive.sdk.util.w0 A;
    public com.fyber.inneractive.sdk.network.t0 B;
    public com.fyber.inneractive.sdk.network.t0 C;
    public g D;
    public final com.fyber.inneractive.sdk.ignite.h E;
    public final com.fyber.inneractive.sdk.topics.b F;
    public final com.fyber.inneractive.sdk.dv.handler.a G;
    public final com.fyber.inneractive.sdk.cache.j H;
    public final com.fyber.inneractive.sdk.network.f I;
    public final HashMap J;
    public com.fyber.inneractive.sdk.measurement.e K;
    public WebView L;
    public final com.fyber.inneractive.sdk.config.global.r M;
    public com.fyber.inneractive.sdk.config.cellular.a N;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1068a = new HashMap();
    public HashMap b = new HashMap();
    public String c;
    public String d;
    public String e;
    public Context f;
    public final CopyOnWriteArrayList g;
    public boolean h;
    public final k0 i;
    public InneractiveUserConfig j;
    public boolean k;
    public String l;
    public InneractiveMediationName m;
    public String n;
    public String o;
    public ArrayList p;
    public boolean q;
    public final AtomicBoolean r;
    public final com.fyber.inneractive.sdk.network.k0 s;
    public String t;
    public s u;
    public i v;
    public t w;
    public final x0 x;
    public q1 y;
    public com.fyber.inneractive.sdk.config.global.a z;
    public static final IAConfigManager O = new IAConfigManager();
    public static final g0 Q = new g0();

    public interface OnConfigurationReadyAndValidListener {
        void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc);
    }

    public IAConfigManager() {
        com.fyber.inneractive.sdk.dv.handler.a eVar;
        new HashSet();
        this.h = false;
        this.i = new k0();
        this.k = false;
        this.q = false;
        this.r = new AtomicBoolean(false);
        this.s = new com.fyber.inneractive.sdk.network.k0();
        this.t = "";
        this.x = new x0();
        this.A = new com.fyber.inneractive.sdk.util.w0();
        this.E = new com.fyber.inneractive.sdk.ignite.h();
        this.F = new com.fyber.inneractive.sdk.topics.b();
        String[] strArr = {"com.google.android.gms.ads.MobileAds", "com.google.android.gms.ads.query.QueryInfoGenerationCallback"};
        for (int i = 0; i < 2; i++) {
            try {
                Class.forName(strArr[i]);
            } catch (ClassNotFoundException unused) {
                eVar = new com.fyber.inneractive.sdk.dv.handler.f();
            }
        }
        eVar = new com.fyber.inneractive.sdk.dv.handler.e();
        this.G = eVar;
        this.H = new com.fyber.inneractive.sdk.cache.j();
        this.I = new com.fyber.inneractive.sdk.network.f();
        this.J = new HashMap();
        this.M = com.fyber.inneractive.sdk.config.global.r.a();
        this.g = new CopyOnWriteArrayList();
    }

    public static void addListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        O.g.add(onConfigurationReadyAndValidListener);
    }

    public static void b() {
        s sVar;
        com.fyber.inneractive.sdk.topics.b bVar;
        IAConfigManager iAConfigManager = O;
        iAConfigManager.getClass();
        if (iAConfigManager.F.i.get() || (sVar = iAConfigManager.u) == null || sVar.b == null) {
            return;
        }
        if (iAConfigManager.r.compareAndSet(false, true)) {
            int a2 = iAConfigManager.u.b.a("topics_enabled", 0, 0);
            int a3 = iAConfigManager.u.b.a("e_topics_enabled", 0, 0);
            if (a2 == 0 && a3 == 0) {
                IAlog.a("Topics API feature disabled - topics_enabled & e_topics_enabled flags are 0", new Object[0]);
                return;
            }
            boolean z = a2 != 0;
            boolean z2 = a3 != 0;
            try {
                if (!f() || (bVar = iAConfigManager.F) == null) {
                    return;
                }
                bVar.a(z, z2);
                iAConfigManager.F.c();
            } catch (Throwable th) {
                IAlog.a("error while trying to init topics ", th, new Object[0]);
            }
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(1000000) >= 11 && com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_ADSERVICES_TOPICS");
    }

    public static boolean d() {
        g gVar = O.D;
        return gVar != null && gVar.e();
    }

    public static boolean e() {
        IAConfigManager iAConfigManager = O;
        boolean z = iAConfigManager.e != null;
        int i = k.f1102a;
        boolean booleanValue = Boolean.valueOf(System.getProperty("ia.testEnvironmentConfiguration.forceConfigRefresh", Boolean.toString(false))).booleanValue();
        if ((z && System.currentTimeMillis() - P > 3600000) || booleanValue) {
            if (booleanValue) {
                s sVar = iAConfigManager.u;
                sVar.d = false;
                com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.util.l(sVar.e));
            }
            a();
            b1 b1Var = b1.c;
            b1Var.getClass();
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new a1(b1Var));
        }
        return z;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 31 && SdkExtensions.getExtensionVersion(1000000) >= 4 && com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_ADSERVICES_TOPICS");
    }

    public static void g() {
        SharedPreferences sharedPreferences = com.fyber.inneractive.sdk.util.o.f1770a.getSharedPreferences("IAConfigurationPreferences", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("IAConfigFQE", true).apply();
        }
    }

    public static void removeListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        O.g.remove(onConfigurationReadyAndValidListener);
    }

    public final void a(Exception exc) {
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener = (OnConfigurationReadyAndValidListener) it.next();
            if (onConfigurationReadyAndValidListener != null) {
                boolean z = O.e != null;
                IAlog.e("notifying listener configuration state has been resolved", new Object[0]);
                onConfigurationReadyAndValidListener.onConfigurationReadyAndValid(this, z, !z ? exc : null);
            }
        }
    }

    public static void a() {
        IAConfigManager iAConfigManager = O;
        com.fyber.inneractive.sdk.network.t0 t0Var = iAConfigManager.B;
        if (t0Var != null) {
            iAConfigManager.s.b(t0Var);
        }
        s sVar = iAConfigManager.u;
        if (sVar.d) {
            return;
        }
        iAConfigManager.s.b(new com.fyber.inneractive.sdk.network.t0(new p(sVar), sVar.f1124a, sVar.e));
    }
}
