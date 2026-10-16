package com.digitalturbine.ignite.authenticator.events;

import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes3.dex */
public final class b {
    public static final b b = new b();

    /* renamed from: a, reason: collision with root package name */
    public a f996a;

    public static void a(d dVar, Exception exc) {
        a(dVar, com.digitalturbine.ignite.authenticator.utils.events.a.a(exc, null));
    }

    public static void a(d dVar, Object... objArr) {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : dispatching event", "IgniteEventDispatcher");
        if (b.f996a != null) {
            t a2 = t.a(dVar);
            if (a2 == null) {
                IAlog.f("%s : One DT Error: %s is missing in IAReportError map", "IgniteEventDispatcherWrapper", dVar);
            } else {
                new w(a2).a(objArr).a((String) null);
            }
        }
    }
}
