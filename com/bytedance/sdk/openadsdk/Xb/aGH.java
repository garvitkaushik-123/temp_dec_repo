package com.bytedance.sdk.openadsdk.Xb;

import com.ironsource.Z3;

/* loaded from: classes3.dex */
public enum aGH {
    TYPE_2G("2g"),
    TYPE_3G(Z3.f3155a),
    TYPE_4G("4g"),
    TYPE_5G("5g"),
    TYPE_WIFI(Z3.b),
    TYPE_MOBILE("mobile"),
    TYPE_UNKNOWN("unknown");

    private String wC;

    aGH(String str) {
        this.wC = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.wC;
    }
}
