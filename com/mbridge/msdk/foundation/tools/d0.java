package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* compiled from: LimitExecutor.java */
/* loaded from: classes6.dex */
public class d0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f4358a;
    private Runnable b;

    /* compiled from: LimitExecutor.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f4359a;

        a(Runnable runnable) {
            this.f4359a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f4359a.run();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("LimitExecutor", e.getMessage());
                }
            } finally {
                d0.this.a();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        if (this.f4358a == null) {
            this.f4358a = a(runnable);
            b0.a().execute(this.f4358a);
        } else if (this.b == null) {
            this.b = a(runnable);
        }
    }

    private Runnable a(Runnable runnable) {
        return new a(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.b;
        this.f4358a = runnable;
        this.b = null;
        if (runnable != null) {
            b0.a().execute(this.f4358a);
        }
    }
}
