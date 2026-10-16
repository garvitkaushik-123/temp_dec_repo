package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1649a;

    public c(d dVar) {
        this.f1649a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("%s : remote UI failed task executed", "RemoteUIWebviewController");
        d dVar = this.f1649a;
        if (dVar.h) {
            return;
        }
        dVar.a(com.fyber.inneractive.sdk.network.events.b.TEMPLATE_LOAD_TIMEOUT, "Loading remote UI timed out", true, null);
    }
}
