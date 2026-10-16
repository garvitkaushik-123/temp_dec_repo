package com.fyber.inneractive.sdk.network;

/* loaded from: classes4.dex */
public final class r0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1336a;
    public final /* synthetic */ Exception b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ s0 d;

    public r0(s0 s0Var, Object obj, Exception exc, boolean z) {
        this.d = s0Var;
        this.f1336a = obj;
        this.b = exc;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.b.a(this.f1336a, this.b, this.c);
    }
}
