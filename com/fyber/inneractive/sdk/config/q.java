package com.fyber.inneractive.sdk.config;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1112a;

    public q(s sVar) {
        this.f1112a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f1112a;
        Iterator it = sVar.c.iterator();
        while (it.hasNext()) {
            ((r) it.next()).onGlobalConfigChanged(sVar, sVar.b);
        }
    }
}
