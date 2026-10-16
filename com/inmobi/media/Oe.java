package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Oe {
    public static final int d;
    public static final int e;
    public static final Ne f;
    public static final LinkedBlockingQueue g;
    public static ThreadPoolExecutor h;

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f2388a;
    public final N9 b;
    public final WeakReference c;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        d = Math.max(2, Math.min(availableProcessors - 1, 4));
        e = (availableProcessors * 2) + 1;
        f = new Ne();
        g = new LinkedBlockingQueue(128);
    }

    public Oe(Me vastMediaFile, int i, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(vastMediaFile, "vastMediaFile");
        N9 n9 = new N9(vastMediaFile.f2366a, null);
        this.b = n9;
        n9.t = false;
        n9.u = false;
        n9.x = false;
        n9.p = i;
        n9.s = true;
        this.c = new WeakReference(vastMediaFile);
        this.f2388a = countDownLatch;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 30L, TimeUnit.SECONDS, g, f);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        h = threadPoolExecutor;
    }

    public final void a() {
        ThreadPoolExecutor threadPoolExecutor = h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.inmobi.media.Oe$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Oe.a(Oe.this);
                }
            });
        }
    }

    public static final void a(Oe this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            P9 b = this$0.b.b();
            if (!b.b()) {
                this$0.a(b);
                return;
            }
            CountDownLatch countDownLatch = this$0.f2388a;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("Oe", "TAG");
            EnumC2790o4 errorCode = EnumC2790o4.e;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            this$0.getClass();
            CountDownLatch countDownLatch2 = this$0.f2388a;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
        }
    }

    public final void a(P9 p9) {
        CountDownLatch countDownLatch;
        try {
            try {
                Me me = (Me) this.c.get();
                if (me != null) {
                    me.c = (p9.e * 1.0d) / 1048576;
                }
                countDownLatch = this.f2388a;
                if (countDownLatch == null) {
                    return;
                }
            } catch (Exception e2) {
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e2);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
                countDownLatch = this.f2388a;
                if (countDownLatch == null) {
                    return;
                }
            }
            countDownLatch.countDown();
        } catch (Throwable th) {
            CountDownLatch countDownLatch2 = this.f2388a;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            throw th;
        }
    }
}
