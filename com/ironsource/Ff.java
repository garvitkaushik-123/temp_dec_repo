package com.ironsource;

/* loaded from: classes6.dex */
public class Ff {

    /* renamed from: a, reason: collision with root package name */
    protected long f2874a;
    protected long b;
    protected long c;

    public long a() {
        return Math.max(0L, this.f2874a - System.currentTimeMillis());
    }

    public void b(long j) {
        this.c = j;
        this.f2874a += j - this.b;
    }

    public void c(long j) {
        this.b = j;
        this.c = 0L;
    }

    public void a(long j) {
        this.f2874a = System.currentTimeMillis() + j;
    }

    public void b() {
        this.f2874a = 0L;
        this.b = 0L;
        this.c = 0L;
    }
}
