package com.instagram.common.viewpoint.core;

import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.facebook.ads.redexgen.X.Wq, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1429Wq extends AbstractRunnableC1416Wc {
    public final /* synthetic */ Wm A00;

    public C1429Wq(Wm wm) {
        this.A00 = wm;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        Runnable runnable;
        this.A00.A0C = false;
        threadPoolExecutor = this.A00.A0B;
        if (threadPoolExecutor.getQueue().isEmpty()) {
            threadPoolExecutor2 = this.A00.A0B;
            runnable = this.A00.A0A;
            threadPoolExecutor2.execute(runnable);
        }
    }
}
