package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.b0;

/* loaded from: classes4.dex */
public final class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f1025a;
    public final /* synthetic */ Exception b;

    public u(b0 b0Var, Exception exc) {
        this.f1025a = b0Var;
        this.b = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var = this.f1025a;
        if (b0Var != null) {
            b0Var.a(this.b, InneractiveErrorCode.INVALID_INPUT, new com.fyber.inneractive.sdk.response.e[0]);
        }
    }
}
