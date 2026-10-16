package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* renamed from: com.ironsource.b1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3000b1 {

    /* renamed from: a, reason: collision with root package name */
    private NetworkSettings f3189a;
    private JSONObject b;
    private IronSource.AD_UNIT c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;

    public C3000b1(NetworkSettings networkSettings, JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        this.f3189a = networkSettings;
        this.b = jSONObject;
        int optInt = jSONObject.optInt("instanceType");
        this.f = optInt;
        this.d = optInt == 2;
        this.e = jSONObject.optBoolean(IronSourceConstants.EARLY_INIT_FIELD);
        this.g = jSONObject.optInt("maxAdsPerSession", 99);
        this.c = ad_unit;
    }

    public String a() {
        return this.f3189a.getAdSourceNameForEvents();
    }

    public IronSource.AD_UNIT b() {
        return this.c;
    }

    public JSONObject c() {
        return this.b;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.g;
    }

    public String f() {
        return this.f3189a.getProviderName();
    }

    public String g() {
        return this.f3189a.getProviderTypeForReflection();
    }

    public NetworkSettings h() {
        return this.f3189a;
    }

    public String i() {
        return this.f3189a.getSubProviderId();
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return this.e;
    }
}
