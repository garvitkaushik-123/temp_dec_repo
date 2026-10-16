package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.kZ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2151kZ implements InterfaceC1159Lx {
    public final InterfaceC1156Lu A00;

    public C2151kZ(InterfaceC1156Lu interfaceC1156Lu) {
        this.A00 = interfaceC1156Lu;
    }

    public final InterfaceC1156Lu A00() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1159Lx
    public final C8J ACL() {
        return new C8J(this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1159Lx
    public final C2155kd ACM() {
        return new C2155kd(this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1159Lx
    public final C2155kd ACN(String str) {
        return new C2155kd(this, str);
    }
}
