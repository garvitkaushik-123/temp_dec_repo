package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.b0;

/* loaded from: classes4.dex */
public final class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f1028a;

    public x(b0 b0Var) {
        this.f1028a = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var = this.f1028a;
        if (b0Var != null) {
            b0Var.a(new Exception("adm payload must contain ad url"), InneractiveErrorCode.INVALID_INPUT, new com.fyber.inneractive.sdk.response.e[0]);
        }
    }
}
