package com.instagram.common.viewpoint.core;

import android.content.SharedPreferences;

/* renamed from: com.facebook.ads.redexgen.X.iC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2018iC implements InterfaceC1224Ol {
    public final SharedPreferences.Editor A00;

    public C2018iC(SharedPreferences.Editor editor) {
        this.A00 = editor;
    }

    public final C2018iC A00(String str, long j) {
        this.A00.putLong(str, j);
        return this;
    }

    public final C2018iC A01(String str, String str2) {
        this.A00.putString(str, str2);
        return this;
    }

    public final void A02() {
        this.A00.apply();
    }
}
