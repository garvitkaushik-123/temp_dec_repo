package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: NpthHandlerThread.java */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static volatile p f338a;
    private static volatile Handler b;

    private static HandlerThread b() {
        if (f338a == null) {
            synchronized (m.class) {
                if (f338a == null) {
                    p pVar = new p("default_npth_thread");
                    f338a = pVar;
                    pVar.b();
                }
            }
        }
        return f338a.c();
    }

    public static p a() {
        if (f338a == null) {
            b();
        }
        return f338a;
    }
}
