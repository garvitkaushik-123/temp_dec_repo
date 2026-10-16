package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.ci, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1683ci implements Runnable {
    public final /* synthetic */ C1092Ji A00;

    public RunnableC1683ci(C1092Ji c1092Ji) {
        this.A00 = c1092Ji;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (WU.A02(this)) {
            return;
        }
        try {
            z = this.A00.A0D;
            if (z) {
                this.A00.A0M();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
