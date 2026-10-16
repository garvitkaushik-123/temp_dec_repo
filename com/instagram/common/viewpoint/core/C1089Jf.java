package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.redexgen.X.Jf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1089Jf implements InterfaceC1585b8 {
    public final WeakReference<AnonymousClass67> A00;

    public C1089Jf(AnonymousClass67 anonymousClass67) {
        this.A00 = new WeakReference<>(anonymousClass67);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1585b8
    public final void AE7(C1584b7 c1584b7) {
        AnonymousClass67 anonymousClass67 = this.A00.get();
        if (anonymousClass67 != null) {
            anonymousClass67.A06 = c1584b7.A00() != null;
            anonymousClass67.A02();
        }
    }
}
