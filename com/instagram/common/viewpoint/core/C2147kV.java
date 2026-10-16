package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.kV, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2147kV implements C5V {
    public MP A02;
    public long A01 = 5242880;
    public int A00 = 20480;

    public final C2147kV A00(MP mp) {
        this.A02 = mp;
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.C5V
    public final C2146kU A5H() {
        return new C2146kU((MP) AbstractC07133y.A01(this.A02), this.A01, this.A00);
    }
}
