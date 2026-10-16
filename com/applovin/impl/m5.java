package com.applovin.impl;

import com.applovin.impl.v;

/* loaded from: classes2.dex */
public class m5 extends g5 {
    private final a g;

    public interface a {
        void a(v.a aVar);
    }

    public m5(com.applovin.impl.sdk.k kVar, a aVar) {
        super("TaskCollectAdvertisingId", kVar, true);
        this.g = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.g.a(this.f464a.B().f());
    }
}
