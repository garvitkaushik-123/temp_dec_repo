package com.instagram.common.viewpoint.core;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: assets/audience_network/classes2.dex */
public class W2 implements InterfaceC1585b8 {
    public final /* synthetic */ C1413Vz A00;

    public W2(C1413Vz c1413Vz) {
        this.A00 = c1413Vz;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1585b8
    public final void AE7(C1584b7 c1584b7) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        VV vv;
        VV vv2;
        atomicBoolean = this.A00.A0G;
        atomicBoolean.set(c1584b7.A00() != null);
        atomicBoolean2 = this.A00.A0H;
        if (atomicBoolean2.get()) {
            vv = this.A00.A05;
            if (vv != null) {
                vv2 = this.A00.A05;
                vv2.AFB(c1584b7.A00() != null);
            }
        }
    }
}
