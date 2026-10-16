package com.ironsource;

import com.ironsource.C3040d4;
import com.ironsource.InterfaceC3196m8;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.n8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3213n8 implements InterfaceC3196m8, InterfaceC3196m8.a {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f3600a = new JSONObject();
    private JSONObject b = new JSONObject();
    private JSONObject c = new JSONObject();

    private final Object e(String str) {
        if (this.c.has(str)) {
            return this.c.get(str);
        }
        if (this.b.has(str)) {
            return this.b.get(str);
        }
        if (this.f3600a.has(str)) {
            return this.f3600a.get(str);
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC3196m8
    public JSONObject a(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object e = e(configKey);
        if (e instanceof JSONObject) {
            return (JSONObject) e;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC3196m8
    public Integer b(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object e = e(configKey);
        if (e instanceof Integer) {
            return (Integer) e;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC3196m8
    public Boolean c(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object e = e(configKey);
        if (e instanceof Boolean) {
            return (Boolean) e;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC3196m8
    public String d(String configKey) {
        Intrinsics.checkNotNullParameter(configKey, "configKey");
        Object e = e(configKey);
        if (e instanceof String) {
            return (String) e;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC3196m8.a
    public void a(JSONObject controllerConfig) {
        Intrinsics.checkNotNullParameter(controllerConfig, "controllerConfig");
        this.f3600a = controllerConfig;
        JSONObject optJSONObject = controllerConfig.optJSONObject(C3040d4.a.b);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.b = optJSONObject;
        JSONObject optJSONObject2 = this.f3600a.optJSONObject(C3040d4.a.c);
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        this.c = optJSONObject2;
    }
}
