package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1255a;

    public d(h hVar) {
        this.f1255a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f1255a;
        IAlog.a("onInstallTimeout after %d msec", Long.valueOf(hVar.k));
        Iterator it = hVar.h.iterator();
        while (it.hasNext()) {
            r rVar = (r) it.next();
            if (rVar != null) {
                rVar.a((String) null, j.INSTALL_TIMEOUT.a(), (String) null);
            }
        }
    }
}
