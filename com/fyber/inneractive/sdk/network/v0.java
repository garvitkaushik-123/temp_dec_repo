package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class v0 extends s0 {
    public final String p;
    public final String q;
    public final AtomicInteger r;

    public v0(e eVar, String str, String str2) {
        super(eVar, f0.c.a(), null);
        this.r = new AtomicInteger();
        this.q = str;
        this.p = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        try {
            n0 n0Var = new n0();
            n0Var.f1331a = String.valueOf(i);
            return n0Var;
        } catch (Exception e) {
            IAlog.a("failed parse event network request", e, new Object[0]);
            throw new m0(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final byte[] d() {
        byte[] bArr = new byte[0];
        try {
            IAlog.a("NetworkRequestEvent: network request body %s", this.p);
            return this.p.getBytes(StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return bArr;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return ((int) Math.pow(2.0d, this.r.get())) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.q;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return this.r.getAndIncrement() < 4;
    }
}
