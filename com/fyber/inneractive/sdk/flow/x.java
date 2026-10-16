package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.web.v0;

/* loaded from: classes4.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1249a;
    public com.fyber.inneractive.sdk.response.e b;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final com.fyber.inneractive.sdk.config.s0 d;
    public boolean e = false;
    public boolean f = false;

    public x(com.fyber.inneractive.sdk.config.s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.d = s0Var;
        this.c = rVar;
    }

    public abstract void a();

    public void a(String str) {
    }

    public boolean a(boolean z, com.fyber.inneractive.sdk.util.g gVar) {
        return false;
    }

    public v0 b() {
        return null;
    }

    public com.fyber.inneractive.sdk.response.e c() {
        return this.b;
    }

    public abstract boolean d();

    public boolean e() {
        return false;
    }

    public abstract boolean f();

    public void g() {
    }

    public abstract boolean isVideoAd();
}
