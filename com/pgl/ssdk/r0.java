package com.pgl.ssdk;

import android.os.Handler;

/* loaded from: classes6.dex */
public class r0 {
    public static Handler a() {
        return a1.a().b();
    }

    public static Handler b() {
        return a1.a().c();
    }

    public static void a(Runnable runnable) {
        Handler a2;
        if (runnable == null || (a2 = a()) == null) {
            return;
        }
        a2.post(runnable);
    }

    public static void b(Runnable runnable) {
        Handler b;
        if (runnable == null || (b = b()) == null) {
            return;
        }
        b.post(runnable);
    }
}
