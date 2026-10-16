package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class V2 {
    private static final int p = 0;

    /* renamed from: a, reason: collision with root package name */
    private H1 f3086a;
    private int b;
    private long c;
    private boolean d;
    private ArrayList<C3124i3> e;
    private C3124i3 f;
    private int g;
    private int h;
    private C3241p2 i;
    private boolean j;
    private long k;
    private boolean l;
    private boolean m;
    private boolean n;
    private long o;

    public V2() {
        this.f3086a = new H1();
        this.e = new ArrayList<>();
    }

    public int a() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public C3241p2 d() {
        return this.i;
    }

    public long e() {
        return this.k;
    }

    public int f() {
        return this.h;
    }

    public H1 g() {
        return this.f3086a;
    }

    public int h() {
        return this.g;
    }

    public C3124i3 i() {
        Iterator<C3124i3> it = this.e.iterator();
        while (it.hasNext()) {
            C3124i3 next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        C3124i3 c3124i3 = this.f;
        return c3124i3 != null ? c3124i3 : new C3176l5();
    }

    public long j() {
        return this.o;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.n;
    }

    public boolean n() {
        return this.m;
    }

    public String toString() {
        return "BannerConfigurations{parallelLoad=" + this.b + ", bidderExclusive=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }

    public void a(C3124i3 c3124i3) {
        if (c3124i3 != null) {
            this.e.add(c3124i3);
            if (this.f == null) {
                this.f = c3124i3;
            } else if (c3124i3.isPlacementId(0)) {
                this.f = c3124i3;
            }
        }
    }

    public V2(int i, long j, boolean z, H1 h1, int i2, C3241p2 c3241p2, int i3, boolean z2, long j2, boolean z3, boolean z4, boolean z5, long j3) {
        this.e = new ArrayList<>();
        this.b = i;
        this.c = j;
        this.d = z;
        this.f3086a = h1;
        this.g = i2;
        this.h = i3;
        this.i = c3241p2;
        this.j = z2;
        this.k = j2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = j3;
    }

    public C3124i3 a(String str) {
        Iterator<C3124i3> it = this.e.iterator();
        while (it.hasNext()) {
            C3124i3 next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }
}
