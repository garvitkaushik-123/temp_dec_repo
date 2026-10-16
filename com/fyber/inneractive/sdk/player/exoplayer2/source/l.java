package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.b0;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOException f1537a;
    public final /* synthetic */ p b;

    public l(p pVar, IOException iOException) {
        this.b = pVar;
        this.f1537a = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var = this.b.e;
        IOException iOException = this.f1537a;
        if (((com.fyber.inneractive.sdk.player.controller.f) b0Var.f1356a.get()) != null) {
            iOException.getCause();
        }
    }
}
