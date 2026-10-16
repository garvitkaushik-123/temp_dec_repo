package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.rL, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2536rL {
    public InterfaceC2537rM A00;

    public final void A00() {
        if (this.A00 != null) {
            this.A00.onStart();
        }
    }

    public final void A02() {
        if (this.A00 != null) {
            this.A00.onStop();
        }
    }

    public final void A03(InterfaceC2537rM interfaceC2537rM) {
        this.A00 = interfaceC2537rM;
    }
}
