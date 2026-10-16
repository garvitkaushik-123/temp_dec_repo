package com.instagram.common.viewpoint.core;

import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class O8 {
    public final long A00;
    public final C1361Tx A01;
    public final String A02;
    public final JSONObject A03;

    public O8(JSONObject jSONObject, C1361Tx c1361Tx, String str, long j) {
        this.A03 = jSONObject;
        this.A01 = c1361Tx;
        this.A02 = str;
        this.A00 = j;
    }

    public final long A00() {
        return this.A00;
    }

    public final C1361Tx A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }

    public final JSONObject A03() {
        return this.A03;
    }
}
