package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class C9 {

    /* renamed from: a, reason: collision with root package name */
    private String f2814a;
    private String e;
    private Map<String, String> f;
    private final InterfaceC3268qc g;
    private boolean h;
    private boolean b = false;
    private boolean c = false;
    private C3044d8 d = null;
    protected boolean i = false;
    protected String j = null;

    public C9(String str, InterfaceC3268qc interfaceC3268qc) throws NullPointerException {
        this.f2814a = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.g = (InterfaceC3268qc) SDKUtils.requireNonNull(interfaceC3268qc, "AdListener name can't be null");
    }

    public C9 a(boolean z) {
        this.c = z;
        return this;
    }

    public C9 b(boolean z) {
        this.i = z;
        return this;
    }

    public C9 c() {
        this.b = true;
        return this;
    }

    public C9 a(C3044d8 c3044d8) {
        this.d = c3044d8;
        return this;
    }

    public C9 b(String str) {
        this.j = str;
        return this;
    }

    public C9 c(boolean z) {
        this.h = z;
        return this;
    }

    public C9 a(String str) {
        this.e = str;
        return this;
    }

    public String b() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f2814a);
            jSONObject.put("rewarded", this.b);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return (this.c || this.h) ? L9.a() : L9.a(jSONObject);
    }

    public C9 a(Map<String, String> map) {
        this.f = map;
        return this;
    }

    public B9 a() {
        return new B9(b(), this.f2814a, this.b, this.c, this.h, this.i, this.j, this.f, this.g, this.d);
    }
}
