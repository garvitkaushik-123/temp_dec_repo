package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.ch, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1682ch implements Runnable {
    public final /* synthetic */ C1092Ji A00;

    public RunnableC1682ch(C1092Ji c1092Ji) {
        this.A00 = c1092Ji;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1606bT c1606bT;
        C1606bT c1606bT2;
        if (WU.A02(this)) {
            return;
        }
        try {
            c1606bT = this.A00.A09;
            if (c1606bT != null && this.A00.getResources().getConfiguration().orientation == 1) {
                c1606bT2 = this.A00.A09;
                c1606bT2.A0A();
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
