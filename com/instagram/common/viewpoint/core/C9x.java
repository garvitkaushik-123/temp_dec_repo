package com.instagram.common.viewpoint.core;

import java.nio.ByteBuffer;

/* renamed from: com.facebook.ads.redexgen.X.9x, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C9x extends AbstractC2374oQ {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public byte[] A06 = C5C.A07;

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ
    public final C06973i A09(C06973i c06973i) throws C06983j {
        if (c06973i.A02 == 2) {
            this.A05 = true;
            return (this.A03 == 0 && this.A02 == 0) ? C06973i.A05 : c06973i;
        }
        throw new C06983j(c06973i);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ
    public final void A0A() {
        if (this.A05) {
            this.A05 = false;
            this.A06 = new byte[this.A02 * super.A05.A00];
            this.A01 = this.A03 * super.A05.A00;
        }
        this.A00 = 0;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ
    public final void A0B() {
        if (this.A05) {
            if (this.A00 > 0) {
                this.A04 += this.A00 / super.A05.A00;
            }
            this.A00 = 0;
        }
    }

    public final long A0C() {
        return this.A04;
    }

    public final void A0D() {
        this.A04 = 0L;
    }

    public final void A0E(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ, com.instagram.common.viewpoint.core.InterfaceC06993k
    public final ByteBuffer A8d() {
        if (super.AAP() && this.A00 > 0) {
            A00(this.A00).put(this.A06, 0, this.A00).flip();
            this.A00 = 0;
        }
        return super.A8d();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ, com.instagram.common.viewpoint.core.InterfaceC06993k
    public final boolean AAP() {
        return super.AAP() && this.A00 == 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void AHH(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int remaining = byteBuffer.limit();
        int i = remaining - position;
        if (i == 0) {
            return;
        }
        int position2 = this.A01;
        int min = Math.min(i, position2);
        long j = this.A04;
        int position3 = super.A05.A00;
        this.A04 = j + (min / position3);
        int position4 = this.A01;
        this.A01 = position4 - min;
        byteBuffer.position(position + min);
        int position5 = this.A01;
        if (position5 > 0) {
            return;
        }
        int endBufferBytesToOutput = i - min;
        int limit = this.A00;
        int position6 = this.A06.length;
        int limit2 = (limit + endBufferBytesToOutput) - position6;
        ByteBuffer buffer = A00(limit2);
        int position7 = this.A00;
        int trimBytes = C5C.A07(limit2, 0, position7);
        buffer.put(this.A06, 0, trimBytes);
        int limit3 = C5C.A07(limit2 - trimBytes, 0, endBufferBytesToOutput);
        int position8 = byteBuffer.position();
        byteBuffer.limit(position8 + limit3);
        buffer.put(byteBuffer);
        byteBuffer.limit(remaining);
        int endBufferBytesToOutput2 = endBufferBytesToOutput - limit3;
        int position9 = this.A00;
        this.A00 = position9 - trimBytes;
        byte[] bArr = this.A06;
        byte[] bArr2 = this.A06;
        int position10 = this.A00;
        System.arraycopy(bArr, trimBytes, bArr2, 0, position10);
        byte[] bArr3 = this.A06;
        int position11 = this.A00;
        byteBuffer.get(bArr3, position11, endBufferBytesToOutput2);
        int position12 = this.A00;
        this.A00 = position12 + endBufferBytesToOutput2;
        buffer.flip();
    }
}
