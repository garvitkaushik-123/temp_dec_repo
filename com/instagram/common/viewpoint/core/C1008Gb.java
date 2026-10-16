package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Gb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1008Gb implements InterfaceC1585b8 {
    public final /* synthetic */ C07384x A00;

    public C1008Gb(C07384x c07384x) {
        this.A00 = c07384x;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1585b8
    public final void AE7(C1584b7 c1584b7) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A05;
        atomicBoolean.set(c1584b7.A00() != null);
        this.A00.A06();
    }
}
