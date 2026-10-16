package com.fyber.inneractive.sdk.network;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f1329a;
    public final WeakReference b;
    public final int c;
    public final k1 d = new k1(this);

    public l1(s0 s0Var, Thread thread, int i) {
        this.b = new WeakReference(s0Var);
        this.f1329a = new WeakReference(thread);
        this.c = i;
    }
}
