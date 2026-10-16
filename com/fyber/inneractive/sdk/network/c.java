package com.fyber.inneractive.sdk.network;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1314a;
    public final /* synthetic */ long b;
    public final /* synthetic */ f c;

    public c(f fVar, int i, long j) {
        this.c = fVar;
        this.f1314a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.d.sendEmptyMessageDelayed(this.f1314a, this.b);
    }
}
