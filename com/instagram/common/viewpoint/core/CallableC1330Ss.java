package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.facebook.ads.redexgen.X.Ss, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class CallableC1330Ss implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C1335Sx A01;

    public CallableC1330Ss(C1335Sx c1335Sx, C1331St c1331St) {
        this.A01 = c1335Sx;
        new Handler(Looper.getMainLooper()).post(new C1932gl(this, c1335Sx, c1331St));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C1331St c1331St) {
        T8 t8;
        T8 t82;
        long currentTimeMillis = System.currentTimeMillis();
        t8 = this.A01.A04;
        C1860fb A06 = C1860fb.A06(t8.A02());
        Uri A00 = XB.A00(c1331St.A08);
        long j = c1331St.A00;
        if (j == -1) {
            t82 = this.A01.A04;
            j = C1379Up.A0S(t82);
        }
        A06.A0I(A00, new C1931gk(this, c1331St, j, currentTimeMillis), j);
    }
}
