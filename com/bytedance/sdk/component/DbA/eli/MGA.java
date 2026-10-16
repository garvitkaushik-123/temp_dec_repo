package com.bytedance.sdk.component.DbA.eli;

/* loaded from: classes3.dex */
public final class MGA {
    private final String[] eli;

    public MGA(String[] strArr) {
        this.eli = strArr;
    }

    public int eli() {
        return this.eli.length / 2;
    }

    public String eli(int i) {
        return this.eli[i * 2];
    }

    public String DbA(int i) {
        return this.eli[(i * 2) + 1];
    }
}
