package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Hu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1053Hu {
    public final InterfaceC1036Hd A00;

    public abstract boolean A0B(C07364v c07364v) throws C3K;

    public abstract boolean A0C(C07364v c07364v, long j) throws C3K;

    public AbstractC1053Hu(InterfaceC1036Hd interfaceC1036Hd) {
        this.A00 = interfaceC1036Hd;
    }

    public final boolean A00(C07364v c07364v, long j) throws C3K {
        return A0B(c07364v) && A0C(c07364v, j);
    }
}
