package com.fyber.inneractive.sdk.factories;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f1172a = new HashMap();

    public final void a(com.fyber.inneractive.sdk.response.a aVar, e eVar) {
        if (this.f1172a.containsKey(aVar)) {
            IAlog.f("Handler already exists for ad type %s! : %s", aVar, this.f1172a.get(aVar));
        } else {
            this.f1172a.put(aVar, eVar);
        }
    }
}
