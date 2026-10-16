package com.ironsource;

import android.content.Context;

/* loaded from: classes6.dex */
public class Z4 {
    private static Z4 h;

    /* renamed from: a, reason: collision with root package name */
    private String f3156a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private final InterfaceC3381x7 g;

    private Z4(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        this.g = i;
        this.f3156a = i.q();
        this.b = i.l();
        this.c = i.f();
        this.d = i.i();
        this.e = i.e();
        this.f = i.u(context);
    }

    public static Z4 b(Context context) {
        if (h == null) {
            h = new Z4(context);
        }
        return h;
    }

    public static void g() {
        h = null;
    }

    public int a() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f3156a;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public float a(Context context) {
        return this.g.E(context);
    }

    public String b() {
        return this.f;
    }
}
