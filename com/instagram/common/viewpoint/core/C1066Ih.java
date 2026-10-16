package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Ih, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1066Ih implements InterfaceC1585b8 {
    public final /* synthetic */ C07485h A00;

    public C1066Ih(C07485h c07485h) {
        this.A00 = c07485h;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1585b8
    public final void AE7(C1584b7 c1584b7) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = this.A00.A08;
        atomicBoolean.set(c1584b7.A00() != null);
        this.A00.A07();
    }
}
