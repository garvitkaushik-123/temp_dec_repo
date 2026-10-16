package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class N5 {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f2961a;

    public N5(JSONObject jSONObject) {
        this.f2961a = jSONObject;
    }

    public final Boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject jSONObject = this.f2961a;
        Object opt = jSONObject != null ? jSONObject.opt(key) : null;
        if (opt instanceof Boolean) {
            return (Boolean) opt;
        }
        return null;
    }

    public final Integer b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject jSONObject = this.f2961a;
        Object opt = jSONObject != null ? jSONObject.opt(key) : null;
        if (opt instanceof Integer) {
            return (Integer) opt;
        }
        return null;
    }

    public final String c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject jSONObject = this.f2961a;
        Object opt = jSONObject != null ? jSONObject.opt(key) : null;
        if (opt instanceof String) {
            return (String) opt;
        }
        return null;
    }
}
