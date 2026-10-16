package com.fyber.inneractive.sdk.util;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class t1 {

    /* renamed from: a, reason: collision with root package name */
    public final TimeUnit f1782a;
    public final long b;
    public r1 c;
    public boolean d;
    public s1 e;
    public long f;

    public t1(TimeUnit timeUnit, long j) {
        this.d = false;
        this.f = 0L;
        this.b = j;
        this.f1782a = timeUnit;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }

    public final void a(long j) {
        long uptimeMillis = (SystemClock.uptimeMillis() - j) + 50 + this.f;
        this.f = uptimeMillis;
        if (this.e != null && uptimeMillis > this.f1782a.toMillis(this.b)) {
            this.e.a();
            return;
        }
        r1 r1Var = this.c;
        if (r1Var == null || this.e == null) {
            return;
        }
        r1Var.removeMessages(1932593528);
        this.c.sendEmptyMessageDelayed(1932593528, 50L);
    }

    public t1(TimeUnit timeUnit, long j, long j2) {
        this.d = false;
        this.b = j;
        this.f1782a = timeUnit;
        this.f = j2;
        IAlog.a("Visible time counter init - time %d", Long.valueOf(j));
    }
}
