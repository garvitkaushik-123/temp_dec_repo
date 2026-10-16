package com.applovin.impl;

import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class c7 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f422a;
    private boolean b;
    private List c;

    public c7(com.applovin.impl.sdk.k kVar) {
        this.f422a = kVar;
        x4 x4Var = x4.H;
        this.b = ((Boolean) kVar.a(x4Var, Boolean.FALSE)).booleanValue() || y.a(com.applovin.impl.sdk.k.o()).a("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator() || kVar.B().R();
        kVar.c(x4Var);
    }

    private void e() {
        com.applovin.impl.sdk.j u = this.f422a.u();
        if (this.b) {
            u.b(this.c);
        } else {
            u.a(this.c);
        }
    }

    public void a(String str) {
        if (StringUtils.isValidString(str)) {
            a(Collections.singletonList(str));
        } else {
            a((List) null);
        }
    }

    public List b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        List list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void a(List list) {
        if (list == null && this.c == null) {
            return;
        }
        if (list == null || !list.equals(this.c)) {
            this.c = list;
            e();
        }
    }

    public void a() {
        this.f422a.b(x4.H, Boolean.TRUE);
    }

    public void a(JSONObject jSONObject) {
        if (this.b) {
            return;
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
        com.applovin.impl.sdk.l B = this.f422a.B();
        boolean R = B.R();
        String a2 = B.f().a();
        l.b F = B.F();
        this.b = R || JsonUtils.containsCaseInsensitiveString(a2, jSONArray) || JsonUtils.containsCaseInsensitiveString(F != null ? F.f702a : null, jSONArray);
    }
}
