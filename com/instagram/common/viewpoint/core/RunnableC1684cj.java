package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.cj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1684cj implements Runnable {
    public final /* synthetic */ C1092Ji A00;

    public RunnableC1684cj(C1092Ji c1092Ji) {
        this.A00 = c1092Ji;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1646c7 c1646c7;
        C1646c7 c1646c72;
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0C = true;
            c1646c7 = this.A00.A0b;
            if (c1646c7.A0D() != null) {
                c1646c72 = this.A00.A0b;
                c1646c72.A0D().AFw(true);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
