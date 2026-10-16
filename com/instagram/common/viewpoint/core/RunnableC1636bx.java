package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.bx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1636bx implements Runnable {
    public final /* synthetic */ C1112Kc A00;

    public RunnableC1636bx(C1112Kc c1112Kc) {
        this.A00 = c1112Kc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A03 = true;
            if (((AbstractC1642c3) this.A00).A07.A0D() != null) {
                ((AbstractC1642c3) this.A00).A07.A0D().AFw(true);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
