package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1623a;

    public c(p pVar) {
        this.f1623a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("%sCannot wait for video size anymore", this.f1623a.b());
        p pVar = this.f1623a;
        if (pVar.r == 0) {
            IAlog.a("%sCannot wait for video size anymore. duration is still 0 - aborting", pVar.b());
            p pVar2 = this.f1623a;
            pVar2.onError(pVar2, 0, 0);
        } else {
            IAlog.a("%sCannot wait for video size anymore. moving into ready", pVar.b());
            p pVar3 = this.f1623a;
            pVar3.f = true;
            pVar3.c();
        }
    }
}
