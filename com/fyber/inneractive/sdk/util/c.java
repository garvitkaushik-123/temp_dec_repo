package com.fyber.inneractive.sdk.util;

import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object[] f1753a;
    public final /* synthetic */ com.fyber.inneractive.sdk.web.e b;

    public c(com.fyber.inneractive.sdk.web.e eVar) {
        this.b = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.getClass();
        com.fyber.inneractive.sdk.web.e eVar = this.b;
        boolean z = eVar.f;
        if (z) {
            return;
        }
        d dVar = new d(eVar);
        eVar.d = dVar;
        if (z) {
            return;
        }
        try {
            eVar.f1796a.execute(dVar);
        } catch (NullPointerException e) {
            IAlog.f("AsyncTaskExecutor : execute(): Unable to execute the null task: %s", e.getMessage());
        } catch (RejectedExecutionException e2) {
            IAlog.f("AsyncTaskExecutor : execute(): Unable to execute the task: %s", e2.getMessage());
        }
    }
}
