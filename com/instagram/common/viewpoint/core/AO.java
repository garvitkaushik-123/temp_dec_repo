package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public final class AO implements C5Y {
    public InterfaceC07605t A02;
    public InterfaceC2160kj<String> A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final C07555o A07 = new C07555o();
    public int A00 = 8000;
    public int A01 = 8000;

    public final AO A00(InterfaceC07605t interfaceC07605t) {
        this.A02 = interfaceC07605t;
        return this;
    }

    public final AO A01(String str) {
        this.A04 = str;
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.C5Y
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final C06511k A5I() {
        C06511k c06511k = new C06511k(this.A04, this.A00, this.A01, this.A05, this.A07, this.A03, this.A06);
        if (this.A02 != null) {
            c06511k.A43(this.A02);
        }
        return c06511k;
    }
}
