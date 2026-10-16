package com.mbridge.msdk.tracker.network;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery.java */
/* loaded from: classes6.dex */
public class f implements w {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f4940a;

    /* compiled from: ExecutorDelivery.java */
    class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f4941a;

        a(Handler handler) {
            this.f4941a = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f4941a.post(runnable);
        }
    }

    /* compiled from: ExecutorDelivery.java */
    private static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final t f4942a;
        private final v b;
        private final Runnable c;

        public b(t tVar, v vVar, Runnable runnable) {
            this.f4942a = tVar;
            this.b = vVar;
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4942a.v()) {
                this.f4942a.c("canceled-at-delivery");
                return;
            }
            if (this.b.a()) {
                this.f4942a.a((t) this.b.f4963a);
            } else {
                this.f4942a.b(this.b.c);
            }
            if (this.b.d) {
                this.f4942a.a("intermediate-response");
            } else {
                this.f4942a.c("done");
            }
            Runnable runnable = this.c;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.f4940a = new a(handler);
    }

    @Override // com.mbridge.msdk.tracker.network.w
    public void a(t<?> tVar, v<?> vVar) {
        a(tVar, vVar, null);
    }

    public void a(t<?> tVar, v<?> vVar, Runnable runnable) {
        tVar.w();
        tVar.a("post-response");
        this.f4940a.execute(new b(tVar, vVar, runnable));
    }

    public f(Executor executor) {
        this.f4940a = executor;
    }

    @Override // com.mbridge.msdk.tracker.network.w
    public void a(t<?> tVar, b0 b0Var) {
        tVar.a("post-error");
        this.f4940a.execute(new b(tVar, v.a(b0Var), null));
    }
}
