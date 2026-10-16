package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.hn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1995hn implements RR {
    public final /* synthetic */ C7M A00;

    public C1995hn(C7M c7m) {
        this.A00 = c7m;
    }

    @Override // com.instagram.common.viewpoint.core.RR
    public final void AH9(RK rk, C1284Qx c1284Qx, C1284Qx c1284Qx2) {
        this.A00.A1l(rk, c1284Qx, c1284Qx2);
    }

    @Override // com.instagram.common.viewpoint.core.RR
    public final void AHB(RK rk, C1284Qx c1284Qx, C1284Qx c1284Qx2) {
        this.A00.A0r.A0Y(rk);
        this.A00.A1m(rk, c1284Qx, c1284Qx2);
    }

    @Override // com.instagram.common.viewpoint.core.RR
    public final void AHD(RK rk, C1284Qx c1284Qx, C1284Qx c1284Qx2) {
        rk.A0d(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0R(rk, rk, c1284Qx, c1284Qx2)) {
                this.A00.A1O();
            }
        } else {
            if (!this.A00.A05.A0Q(rk, c1284Qx, c1284Qx2)) {
                return;
            }
            this.A00.A1O();
        }
    }

    @Override // com.instagram.common.viewpoint.core.RR
    public final void AKZ(RK rk) {
        this.A00.A06.A1F(rk.A0H, this.A00.A0r);
    }
}
