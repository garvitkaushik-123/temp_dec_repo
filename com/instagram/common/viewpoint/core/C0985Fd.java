package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Fd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0985Fd implements InterfaceC1297Rk {
    public final /* synthetic */ C1291Re A00;
    public final /* synthetic */ C4T A01;

    public C0985Fd(C4T c4t, C1291Re c1291Re) {
        this.A01 = c4t;
        this.A00 = c1291Re;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1297Rk
    public final boolean AAI() {
        boolean A0j;
        boolean A0k;
        if (!this.A01.A0i()) {
            A0j = this.A01.A0j();
            if (A0j) {
                return true;
            }
            A0k = this.A01.A0k();
            return A0k;
        }
        this.A01.A0h(this.A00);
        return true;
    }
}
