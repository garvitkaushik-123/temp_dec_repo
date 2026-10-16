package com.instagram.common.viewpoint.core;

import android.content.SharedPreferences;

/* renamed from: com.facebook.ads.redexgen.X.iB, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2017iB implements InterfaceC1225Om {
    public final SharedPreferences A00;

    public C2017iB(SharedPreferences sharedPreferences) {
        this.A00 = sharedPreferences;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1225Om
    public final C2018iC A6I() {
        return new C2018iC(this.A00.edit());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1225Om
    public final long A8Q(String str, long j) {
        return this.A00.getLong(str, j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1225Om
    public final String A9E(String str, String str2) {
        return this.A00.getString(str, str2);
    }
}
