package com.bytedance.sdk.component.DbA.eli;

import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class FC {
    private String DbA;
    private String eli;

    private FC(String str) {
        this.eli = str;
    }

    public static FC eli(String str) {
        return new FC(str);
    }

    public String eli() {
        return this.eli;
    }

    public Charset eli(Charset charset) {
        try {
            String str = this.DbA;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
