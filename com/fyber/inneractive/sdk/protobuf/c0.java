package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f1662a;

    public c0(b0 b0Var) {
        Charset charset = l1.f1684a;
        if (b0Var == null) {
            throw new NullPointerException("output");
        }
        this.f1662a = b0Var;
        b0Var.f1659a = this;
    }

    public final void a(int i, float f) {
        b0 b0Var = this.f1662a;
        b0Var.getClass();
        b0Var.a(i, Float.floatToRawIntBits(f));
    }

    public final void a(int i, double d) {
        b0 b0Var = this.f1662a;
        b0Var.getClass();
        b0Var.a(i, Double.doubleToRawLongBits(d));
    }

    public final void a(int i, int i2) {
        this.f1662a.d(i, b0.d(i2));
    }

    public final void a(int i, long j) {
        this.f1662a.b(i, b0.b(j));
    }

    public final void a(int i, Object obj, t2 t2Var) {
        b0 b0Var = this.f1662a;
        b0Var.c(i, 3);
        t2Var.a(obj, b0Var.f1659a);
        b0Var.c(i, 4);
    }
}
