package com.instagram.common.viewpoint.core;

/* loaded from: assets/audience_network/classes2.dex */
public class A4 implements InterfaceC07003l {
    public final C08569y A00;
    public final C2367oJ A01;
    public final InterfaceC06993k[] A02;

    public A4(InterfaceC06993k... interfaceC06993kArr) {
        this(interfaceC06993kArr, new C08569y(), new C2367oJ());
    }

    public A4(InterfaceC06993k[] interfaceC06993kArr, C08569y c08569y, C2367oJ c2367oJ) {
        this.A02 = new InterfaceC06993k[interfaceC06993kArr.length + 2];
        System.arraycopy(interfaceC06993kArr, 0, this.A02, 0, interfaceC06993kArr.length);
        this.A00 = c08569y;
        this.A01 = c2367oJ;
        this.A02[interfaceC06993kArr.length] = c08569y;
        this.A02[interfaceC06993kArr.length + 1] = c2367oJ;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07003l
    public final C2468px A4F(C2468px c2468px) {
        this.A01.A02(c2468px.A01);
        this.A01.A01(c2468px.A00);
        return c2468px;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07003l
    public final boolean A4G(boolean z) {
        this.A00.A0D(z);
        return z;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07003l
    public final InterfaceC06993k[] A6z() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07003l
    public final long A8U(long j) {
        return this.A01.A00(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC07003l
    public final long A98() {
        return this.A00.A0C();
    }
}
