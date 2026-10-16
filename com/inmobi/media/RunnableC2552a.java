package com.inmobi.media;

import android.os.Debug;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC2552a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2570b f2511a;

    public RunnableC2552a(C2570b c2570b) {
        this.f2511a = c2570b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2511a.d.get()) {
            if (this.f2511a.f.hasMessages(2023)) {
                this.f2511a.f.removeMessages(2023);
                this.f2511a.getClass();
                if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.f2511a.e.get()) {
                    StackTraceElement[] a2 = C2570b.a(this.f2511a);
                    H3 h3 = this.f2511a.f2290a;
                    Intrinsics.checkNotNull(a2);
                    h3.a(new mf(a2));
                }
            }
            this.f2511a.e.getAndSet(true);
            this.f2511a.f.sendEmptyMessage(2023);
        }
    }
}
