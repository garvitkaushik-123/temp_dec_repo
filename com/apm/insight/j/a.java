package com.apm.insight.j;

import android.os.Handler;

/* compiled from: BaseTask.java */
/* loaded from: classes2.dex */
public abstract class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Handler f261a;
    private final long b = 0;
    private final long c;

    a(Handler handler, long j) {
        this.f261a = handler;
        this.c = j;
    }

    final void a() {
        this.f261a.post(this);
    }

    final void a(long j) {
        if (j > 0) {
            this.f261a.postDelayed(this, j);
        } else {
            this.f261a.post(this);
        }
    }

    final long b() {
        return this.c;
    }
}
