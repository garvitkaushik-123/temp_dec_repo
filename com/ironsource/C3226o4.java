package com.ironsource;

import java.lang.Thread;

/* renamed from: com.ironsource.o4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3226o4 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f3611a;

    C3226o4(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3611a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        C3243p4 c3243p4 = new C3243p4(th);
        if (c3243p4.d()) {
            new M5(c3243p4.b(), "" + System.currentTimeMillis(), "Crash").a();
        }
        this.f3611a.uncaughtException(thread, th);
    }
}
