package com.fyber.inneractive.sdk.protobuf;

/* loaded from: classes4.dex */
public final class w0 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final e1 f1704a;
    public final int b;
    public final j4 c;
    public final boolean d;
    public final boolean e;

    public w0(e1 e1Var, int i, j4 j4Var, boolean z, boolean z2) {
        this.f1704a = e1Var;
        this.b = i;
        this.c = j4Var;
        this.d = z;
        this.e = z2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b - ((w0) obj).b;
    }
}
