package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s1;

/* loaded from: classes4.dex */
public final class d implements s1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1078a;

    public d(e eVar) {
        this.f1078a = eVar;
    }

    @Override // com.fyber.inneractive.sdk.util.s1
    public final void a() {
        IAlog.a("onVisibleTimeReached: %s", Long.valueOf(System.currentTimeMillis()));
        this.f1078a.b = true;
    }
}
