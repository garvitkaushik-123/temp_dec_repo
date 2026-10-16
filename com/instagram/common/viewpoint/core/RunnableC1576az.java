package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.az, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1576az implements Runnable {
    public final /* synthetic */ C1577b0 A00;
    public final /* synthetic */ InterfaceC1578b1 A01;

    public RunnableC1576az(C1577b0 c1577b0, InterfaceC1578b1 interfaceC1578b1) {
        this.A00 = c1577b0;
        this.A01 = interfaceC1578b1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A01.ACz();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
