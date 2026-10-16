package com.fyber.inneractive.sdk.config;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1104a = new HashMap();

    public final boolean a() {
        try {
            if (this.f1104a.containsKey("dsos")) {
                return Boolean.parseBoolean((String) this.f1104a.get("dsos"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
