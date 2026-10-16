package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Mb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1163Mb implements XN {
    public final /* synthetic */ MW A00;

    public C1163Mb(MW mw) {
        this.A00 = mw;
    }

    public /* synthetic */ C1163Mb(MW mw, C1174Mm c1174Mm) {
        this(mw);
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        AtomicBoolean atomicBoolean;
        boolean z;
        C1201No c1201No;
        boolean z2;
        this.A00.A0D();
        atomicBoolean = this.A00.A0R;
        if (!atomicBoolean.get()) {
            z = this.A00.A0T;
            if (!z) {
                z2 = this.A00.A0D;
                if (z2) {
                    this.A00.A0U.setToolbarActionMode(0);
                    return;
                }
            }
            c1201No = this.A00.A0H;
            if (c1201No.A0V()) {
                this.A00.A0U.setToolbarActionMode(1);
            } else {
                this.A00.A0U.setToolbarActionMode(0);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
        C1201No c1201No;
        C1201No c1201No2;
        c1201No = this.A00.A0H;
        if (c1201No.A0A() > 0) {
            c1201No2 = this.A00.A0H;
            if (f == c1201No2.A0A()) {
                this.A00.A0U.setToolbarActionMode(8);
            }
        }
    }
}
