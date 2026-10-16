package com.ironsource;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.WaterfallConfiguration;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class J9 {

    /* renamed from: a, reason: collision with root package name */
    R6 f2917a = new R6();

    class a extends Pd {
        final /* synthetic */ Zd b;

        a(Zd zd) {
            this.b = zd;
        }

        @Override // com.ironsource.Pd
        public void a() {
            J9.this.f2917a.a(N6.g0, new JSONArray().put(this.b.b()));
        }
    }

    public void a(JSONObject jSONObject) {
        this.f2917a.a(N6.u, (Object) jSONObject);
    }

    public void b(JSONObject jSONObject) {
        this.f2917a.a(N6.e1, (Object) jSONObject);
    }

    public void c(String str) {
        this.f2917a.a(N6.J0, str);
    }

    public void d(String str) {
        this.f2917a.a(N6.L0, str);
    }

    public void e(String str) {
        this.f2917a.a(com.ironsource.mediationsdk.metadata.a.i, str);
    }

    public void f(String str) {
        this.f2917a.a(N6.Z0, str);
    }

    public void g(String str) {
        this.f2917a.a(N6.A, str);
    }

    public void h(String str) {
        this.f2917a.a("sid", str);
    }

    public void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2917a.a(N6.e0, str);
    }

    public void a(boolean z) {
        this.f2917a.a(N6.Q0, Boolean.valueOf(z));
    }

    public void b(boolean z) {
        this.f2917a.a("gpi", Boolean.valueOf(z));
    }

    public void c(int i) {
        this.f2917a.a(N6.f0, Integer.valueOf(i));
    }

    public void a(Context context) {
        this.f2917a.a(context);
    }

    public void b(int i) {
        if (i >= 0) {
            this.f2917a.a(N6.S0, Integer.valueOf(i));
        }
    }

    public void a(Boolean bool) {
        this.f2917a.a(N6.T0, bool);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2917a.a(N6.C1, str);
    }

    public void a(Zd zd) {
        new Thread(new a(zd)).start();
    }

    public void b(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        ActivityManager.MemoryInfo n = i.n(context);
        this.f2917a.a(N6.w, i.c(n));
        this.f2917a.a(N6.x, i.b(n));
    }

    public void a(Q7 q7) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(N6.E, q7.a());
            hashMap.put(N6.D, q7.b());
            hashMap.put(N6.V, q7.c());
            this.f2917a.a(hashMap);
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
    }

    public void a(IronSource.AD_UNIT ad_unit, WaterfallConfiguration waterfallConfiguration) {
        JSONObject jSONObject = new JSONObject();
        if (waterfallConfiguration != null) {
            try {
                jSONObject.put(N6.t1, waterfallConfiguration.getFloor());
                jSONObject.put(N6.u1, waterfallConfiguration.getCeiling());
            } catch (JSONException e) {
                C3260q4.d().a(e);
            }
        }
        if (jSONObject.length() == 0) {
            this.f2917a.a(N6.s1, W0.a(ad_unit));
        } else {
            this.f2917a.a(N6.s1, jSONObject, W0.a(ad_unit));
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2917a.a("abt", str);
    }

    public void a(int i) {
        this.f2917a.a(N6.i0, Integer.valueOf(i));
    }
}
