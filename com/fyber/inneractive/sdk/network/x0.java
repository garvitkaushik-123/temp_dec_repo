package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class x0 extends s0 {
    public final String p;
    public final AtomicInteger q;

    public x0(e0 e0Var, String str) {
        super(e0Var, f0.c.a(), null);
        this.q = new AtomicInteger();
        this.p = str;
    }

    public static void b(String str) {
        IAConfigManager.O.s.b(new x0(new w0(str, System.currentTimeMillis()), str));
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        try {
            n0 n0Var = new n0();
            n0Var.f1331a = String.valueOf(i);
            InputStream inputStream = lVar.c;
            if (inputStream != null) {
                n0Var.b = com.fyber.inneractive.sdk.util.t.a(inputStream).toString();
            }
            return n0Var;
        } catch (Exception e) {
            IAlog.a("failed parse hit network request", e, new Object[0]);
            throw new m0(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return ((int) Math.pow(2.0d, this.q.get())) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return this.q.getAndIncrement() < 4;
    }
}
