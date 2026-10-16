package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adquality.AdQualityBridge;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class O6 {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3381x7 f2978a;
    private final ConcurrentHashMap<String, Object> b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2979a;

        a(Context context) {
            this.f2979a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                O6.this.e(this.f2979a);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            O6.this.c.set(false);
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static volatile O6 f2980a = new O6();

        private b() {
        }
    }

    private O6() {
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.f2978a = C3334ub.U().i();
        this.b = new ConcurrentHashMap<>();
    }

    static O6 b() {
        return b.f2980a;
    }

    private void d(Context context) {
        if (context == null || this.d.getAndSet(true)) {
            return;
        }
        a("auid", this.f2978a.d(context));
        a(N6.B, this.f2978a.l());
        a(N6.t, this.f2978a.q());
        a(N6.F, this.f2978a.f());
        a(N6.p, this.f2978a.L(context));
        String adQualitySdkVersion = AdQualityBridge.getAdQualitySdkVersion();
        if (!TextUtils.isEmpty(adQualitySdkVersion)) {
            a(N6.B1, adQualitySdkVersion);
        }
        String i = this.f2978a.i();
        if (i != null) {
            a("osv", i.replaceAll("[^0-9/.]", ""));
            a(N6.J, i);
        }
        a(N6.f2962a, String.valueOf(this.f2978a.e()));
        String u = this.f2978a.u(context);
        if (!TextUtils.isEmpty(u)) {
            a(N6.P0, u);
        }
        String e = C1.e(context);
        if (!TextUtils.isEmpty(e)) {
            a(N6.o, e);
        }
        String r = this.f2978a.r(context);
        if (!TextUtils.isEmpty(r)) {
            a(N6.v0, r);
        }
        a("bid", context.getPackageName());
        a("mem", String.valueOf(this.f2978a.q(context)));
        a(N6.b0, "2.0");
        a(N6.c0, Long.valueOf(C1.f(context)));
        a(N6.a0, Long.valueOf(C1.d(context)));
        a(N6.d, C1.b(context));
        a(N6.O, Integer.valueOf(Z3.f(context)));
        a(N6.Y, Z3.g(context));
        a("stid", Lc.c(context));
        a(N6.H, "android");
        a(N6.z, this.f2978a.t());
        a("mThreshold", this.f2978a.a(this.f2978a.n(context)));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (context == null) {
            return;
        }
        try {
            String I = this.f2978a.I(context);
            if (!TextUtils.isEmpty(I)) {
                a("gaid", I);
            }
            String b2 = this.f2978a.b(context);
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            a(N6.s, Boolean.valueOf(Boolean.parseBoolean(b2)));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void f(Context context) {
        if (context == null) {
            return;
        }
        a(context);
        String y = this.f2978a.y(context);
        if (!TextUtils.isEmpty(y)) {
            a(N6.K0, y);
        } else if (a(N6.K0)) {
            b(N6.K0);
        }
        a("idfi", this.f2978a.i(context));
        String c = this.f2978a.c(context);
        if (!TextUtils.isEmpty(c)) {
            a(N6.q, c.toUpperCase(Locale.getDefault()));
        }
        a(N6.r, this.f2978a.A(context));
        String d = this.f2978a.d();
        if (!TextUtils.isEmpty(d)) {
            a("tz", d);
        }
        String b2 = C2986a4.b(context);
        if (!TextUtils.isEmpty(b2) && !b2.equals("none")) {
            a(N6.j, b2);
        }
        String d2 = C2986a4.d(context);
        if (!TextUtils.isEmpty(d2)) {
            a(N6.k, d2);
        }
        a("vpn", Boolean.valueOf(C2986a4.e(context)));
        String G = this.f2978a.G(context);
        if (!TextUtils.isEmpty(G)) {
            a("icc", G);
        }
        int s = this.f2978a.s(context);
        if (s >= 0) {
            a(N6.j1, Integer.valueOf(s));
        }
        a(N6.k1, this.f2978a.v(context));
        a(N6.l1, this.f2978a.F(context));
        a(N6.h0, Float.valueOf(this.f2978a.E(context)));
        a(N6.m, String.valueOf(this.f2978a.h()));
        a(N6.R, Integer.valueOf(this.f2978a.k()));
        a(N6.Q, Integer.valueOf(this.f2978a.c()));
        a(N6.X0, String.valueOf(this.f2978a.a()));
        a(N6.g1, String.valueOf(this.f2978a.m()));
        a("mcc", Integer.valueOf(Z3.b(context)));
        a("mnc", Integer.valueOf(Z3.c(context)));
        a(N6.T, Boolean.valueOf(this.f2978a.j()));
        a(N6.g, Boolean.valueOf(this.f2978a.C(context)));
        a(N6.h, Integer.valueOf(this.f2978a.D(context)));
        a(N6.b, Boolean.valueOf(this.f2978a.e(context)));
        a(N6.K, Boolean.valueOf(this.f2978a.h(context)));
        a("rt", Boolean.valueOf(this.f2978a.p()));
        a(N6.Z, String.valueOf(this.f2978a.r()));
        a(N6.e, Integer.valueOf(this.f2978a.k(context)));
        a(N6.Y0, Boolean.valueOf(this.f2978a.J(context)));
        a(N6.c, this.f2978a.m(context));
        a(N6.d0, this.f2978a.s());
        C3390y c3390y = new C3390y(C3334ub.U().s());
        HashMap hashMap = new HashMap();
        c3390y.a(hashMap);
        a(N6.D0, hashMap);
        a(N6.L, ConfigFile.getConfigFile().getPluginType());
        a(N6.M, ConfigFile.getConfigFile().getPluginVersion());
        a(N6.N, ConfigFile.getConfigFile().getPluginFrameworkVersion());
    }

    protected void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                if (map.containsKey(str)) {
                    a(str, map.get(str));
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected void c(Context context) {
        try {
            d(context);
            f(context);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected void b(String str, Object obj) {
        a(str, obj);
    }

    protected void b(String str) {
        if (str == null) {
            return;
        }
        try {
            this.b.remove(str);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected JSONObject b(Context context) throws JSONException {
        f(context);
        return new JSONObject(Q6.a(this.b));
    }

    protected void a(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            Object obj = this.b.get(str);
            if (!(obj instanceof JSONArray)) {
                a(str, (Object) jSONArray);
                return;
            }
            JSONArray jSONArray2 = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                jSONArray2.put(jSONArray.get(i));
            }
            a(str, (Object) jSONArray2);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    protected void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Object obj = this.b.get(str);
            if (!(obj instanceof JSONObject)) {
                a(str, (Object) jSONObject);
                return;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
            }
            a(str, (Object) jSONObject2);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof Boolean) {
                obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            }
            this.b.put(str, obj);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean a(String str) {
        return str != null && this.b.containsKey(str);
    }

    private void a(Context context) {
        if (this.c.get()) {
            return;
        }
        try {
            this.c.set(true);
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(context));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            this.c.set(false);
        }
    }

    private void a() {
        String a2 = Pf.f2998a.a();
        if (a2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sdk", a2);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(N6.G1, hashMap);
            Map<String, Object> hashMap3 = new HashMap<>();
            hashMap3.put(N6.D1, hashMap2);
            a(hashMap3);
        }
    }
}
