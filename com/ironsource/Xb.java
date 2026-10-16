package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Xb {
    private final InterfaceC3381x7 b = C3334ub.U().i();

    /* renamed from: a, reason: collision with root package name */
    R6 f3131a = new R6();

    public void a(Context context) {
        if (context instanceof Activity) {
            this.f3131a.a(N6.n, Boolean.valueOf(this.b.a((Activity) context)));
        }
    }

    public void b() {
        String controllerConfig = SDKUtils.getControllerConfig();
        if (TextUtils.isEmpty(controllerConfig)) {
            return;
        }
        try {
            this.f3131a.a(N6.i, new JSONObject(controllerConfig).opt(C3040d4.a.q));
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public void c() {
        this.f3131a.a("uxt", Boolean.valueOf(IronSourceStorageUtils.isUxt()));
    }

    public void d() {
        this.f3131a.a(N6.V, "8.11.1");
    }

    public void e() {
        HashMap hashMap = new HashMap();
        hashMap.put(N6.E, C3251pc.f);
        hashMap.put(N6.D, C3251pc.e);
        this.f3131a.a(hashMap);
    }

    public void a() {
        JSONObject jSONObject = new JSONObject(IronSourceQaProperties.getInstance().getParameters());
        if (jSONObject.length() > 0) {
            this.f3131a.a("debug", jSONObject);
        }
    }

    public void a(JSONObject jSONObject) {
        this.f3131a.a(N6.l, jSONObject);
    }

    public void b(Context context) {
        this.f3131a.a("gpi", Boolean.valueOf(Lc.d(context)));
    }

    public void a(C3230o8.c cVar) {
        this.f3131a.a(N6.x1, Integer.valueOf(cVar.ordinal()));
    }

    public void a(Map<String, JSONObject> map) {
        for (Map.Entry<String, JSONObject> entry : map.entrySet()) {
            this.f3131a.a(entry.getKey(), (Object) entry.getValue());
        }
    }

    public void a(List<String> list) {
        this.f3131a.a(N6.A1, list);
    }

    public void a(boolean z) {
        this.f3131a.a(N6.R0, Boolean.valueOf(z));
    }
}
