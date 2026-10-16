package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.bI, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1595bI implements Runnable {
    public final /* synthetic */ LK A00;

    public RunnableC1595bI(LK lk) {
        this.A00 = lk;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0r();
            this.A00.A0v(1000L);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
