package com.instagram.common.viewpoint.core;

import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.la, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2212la implements InterfaceC1093Jj {
    public final List<C2439pT> A00;

    public C2212la(List<C2439pT> list) {
        this.A00 = Collections.unmodifiableList(list);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final List<C2439pT> A7X(long j) {
        return j >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final long A83(int i) {
        AbstractC07133y.A07(i == 0);
        return 0L;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final int A84() {
        return 1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1093Jj
    public final int A8a(long j) {
        return j < 0 ? 0 : -1;
    }
}
