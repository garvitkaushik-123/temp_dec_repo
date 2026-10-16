package com.instagram.common.viewpoint.core;

import android.os.Handler;

/* renamed from: com.facebook.ads.redexgen.X.eX, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1794eX implements Runnable {
    public final /* synthetic */ FO A00;

    public RunnableC1794eX(FO fo) {
        this.A00 = fo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C7M c7m;
        int i;
        Handler handler;
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A00.A0B() != 0) {
                c7m = this.A00.A04;
                i = this.A00.A00;
                c7m.scrollBy(i, 0);
                handler = this.A00.A03;
                handler.postDelayed(this, 16L);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
