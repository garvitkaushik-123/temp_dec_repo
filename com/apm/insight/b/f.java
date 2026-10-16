package com.apm.insight.b;

import android.content.Context;

/* compiled from: CrashANRHandler.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f217a;
    private static g c;
    private final b b;

    public static f a(Context context) {
        if (f217a == null) {
            synchronized (f.class) {
                if (f217a == null) {
                    f217a = new f(context);
                }
            }
        }
        return f217a;
    }

    private f(Context context) {
        this.b = new b(context);
        g gVar = new g();
        c = gVar;
        gVar.a();
    }

    public final b a() {
        return this.b;
    }

    public static g b() {
        return c;
    }

    public final void c() {
        this.b.a();
    }

    public final void d() {
        this.b.b();
    }
}
