package com.fyber.inneractive.sdk.util;

import com.ironsource.N6;

/* loaded from: classes4.dex */
public final class o1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1771a;
    public final /* synthetic */ q1 b;

    public o1(q1 q1Var, String str) {
        this.b = q1Var;
        this.f1771a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.getSharedPreferences("fyber.ua", 0).edit().putString(N6.d0, this.f1771a).apply();
    }
}
