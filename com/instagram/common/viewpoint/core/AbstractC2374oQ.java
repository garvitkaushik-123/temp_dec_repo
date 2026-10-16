package com.instagram.common.viewpoint.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.facebook.ads.redexgen.X.oQ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2374oQ implements InterfaceC06993k {
    public boolean A04;
    public ByteBuffer A02 = InterfaceC06993k.A00;
    public ByteBuffer A03 = InterfaceC06993k.A00;
    public C06973i A00 = C06973i.A05;
    public C06973i A01 = C06973i.A05;
    public C06973i A05 = C06973i.A05;
    public C06973i A06 = C06973i.A05;

    public abstract C06973i A09(C06973i c06973i) throws C06983j;

    public final ByteBuffer A00(int i) {
        if (this.A02.capacity() < i) {
            this.A02 = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        this.A03 = this.A02;
        return this.A02;
    }

    public final boolean A01() {
        return this.A03.hasRemaining();
    }

    public void A0A() {
    }

    public void A0B() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final C06973i A57(C06973i c06973i) throws C06983j {
        this.A00 = c06973i;
        this.A01 = A09(c06973i);
        return AAL() ? this.A01 : C06973i.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public ByteBuffer A8d() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = InterfaceC06993k.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public boolean AAL() {
        return this.A01 != C06973i.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public boolean AAP() {
        return this.A04 && this.A03 == InterfaceC06993k.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void AHG() {
        this.A04 = true;
        A0B();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void flush() {
        this.A03 = InterfaceC06993k.A00;
        this.A04 = false;
        this.A05 = this.A00;
        this.A06 = this.A01;
        A0A();
    }
}
