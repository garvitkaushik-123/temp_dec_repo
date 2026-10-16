package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f1205a;

    public j(k kVar) {
        this.f1205a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar = this.f1205a;
        kVar.getClass();
        IAlog.a("%s : IAAdContentLoaderImpl : retry load ad task started execution", IAlog.a(kVar));
        this.f1205a.b();
    }
}
