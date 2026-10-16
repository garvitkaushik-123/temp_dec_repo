package com.apm.insight.b;

import android.os.SystemClock;
import com.apm.insight.runtime.m;

/* compiled from: ANRThread.java */
/* loaded from: classes2.dex */
public final class c {
    private static long b;

    /* renamed from: a, reason: collision with root package name */
    private final b f212a;
    private boolean c = false;
    private final Runnable d;

    c(b bVar) {
        Runnable runnable = new Runnable() { // from class: com.apm.insight.b.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.c) {
                    return;
                }
                c.this.f212a.d();
                long unused = c.b = SystemClock.uptimeMillis();
                if (com.apm.insight.runtime.i.a().b()) {
                    m.a().a(c.this.d, 500L);
                } else {
                    m.a().a(c.this.d, 500L);
                }
                com.apm.insight.runtime.b.a(c.b);
            }
        };
        this.d = runnable;
        this.f212a = bVar;
        m.a().a(runnable, 5000L);
    }

    public final void a() {
        if (this.c) {
            return;
        }
        m.a().a(this.d, 5000L);
    }

    public final void b() {
        this.c = true;
    }

    public static boolean c() {
        return SystemClock.uptimeMillis() - b <= 15000;
    }
}
