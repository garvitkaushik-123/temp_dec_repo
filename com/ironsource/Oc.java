package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public abstract class Oc {

    /* renamed from: a, reason: collision with root package name */
    private Pc f2982a;
    private long b;
    private boolean c;

    public Oc() {
        this(false, 1, null);
    }

    public final Pc a() {
        return this.f2982a;
    }

    public abstract String b();

    public final long c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public Oc(boolean z) {
        this.c = z;
    }

    public final void a(Pc pc) {
        this.f2982a = pc;
    }

    public final void a(boolean z) {
        this.c = z;
        if (z) {
            this.b = System.currentTimeMillis();
            Pc pc = this.f2982a;
            if (pc != null) {
                pc.a(this);
                return;
            }
            return;
        }
        Pc pc2 = this.f2982a;
        if (pc2 != null) {
            pc2.b(this);
        }
    }

    public /* synthetic */ Oc(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
