package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.flow.b0;

/* loaded from: classes4.dex */
public final class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f1024a;
    public final /* synthetic */ com.fyber.inneractive.sdk.config.global.r b;
    public final /* synthetic */ y c;

    public t(y yVar, b0 b0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.c = yVar;
        this.f1024a = b0Var;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f1024a, this.b);
    }
}
