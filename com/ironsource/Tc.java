package com.ironsource;

/* loaded from: classes6.dex */
public class Tc {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3061a;
    private boolean b;
    private boolean c;
    private Xc d;
    private int e;
    private int f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3062a = true;
        private boolean b = false;
        private boolean c = false;
        private Xc d = null;
        private int e = 0;
        private int f = 0;

        public a a(boolean z) {
            this.f3062a = z;
            return this;
        }

        public a a(boolean z, Xc xc, int i) {
            this.b = z;
            if (xc == null) {
                xc = Xc.PER_DAY;
            }
            this.d = xc;
            this.e = i;
            return this;
        }

        public a a(boolean z, int i) {
            this.c = z;
            this.f = i;
            return this;
        }

        public Tc a() {
            return new Tc(this.f3062a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    private Tc(boolean z, boolean z2, boolean z3, Xc xc, int i, int i2) {
        this.f3061a = z;
        this.b = z2;
        this.c = z3;
        this.d = xc;
        this.e = i;
        this.f = i2;
    }

    public Xc a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.f3061a;
    }

    public boolean f() {
        return this.c;
    }
}
