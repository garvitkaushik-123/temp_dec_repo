package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1176a;

    public b(d dVar) {
        this.f1176a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("%s : ContentLoadTimeoutHandler Executing timeout task", IAlog.a(this.f1176a));
        this.f1176a.b.a();
    }
}
