package com.fyber.inneractive.sdk.cache.session;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class a extends HashMap {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1046a = 25;

    public a() {
        for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
            if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE) {
                put(cVar, new k(this.f1046a));
            }
        }
    }
}
