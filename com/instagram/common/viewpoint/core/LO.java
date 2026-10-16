package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* loaded from: assets/audience_network/classes2.dex */
public final class LO {
    public final int A00;
    public final long A01;

    public LO(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static LO A00(InterfaceC2280ms interfaceC2280ms, C07364v c07364v) throws IOException {
        interfaceC2280ms.AGt(c07364v.A0l(), 0, 8);
        c07364v.A0f(0);
        int A0C = c07364v.A0C();
        long size = c07364v.A0O();
        return new LO(A0C, size);
    }
}
