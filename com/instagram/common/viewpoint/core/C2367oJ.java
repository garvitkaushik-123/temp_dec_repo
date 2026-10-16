package com.instagram.common.viewpoint.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* renamed from: com.facebook.ads.redexgen.X.oJ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2367oJ implements InterfaceC06993k {
    public long A03;
    public long A04;
    public C9Y A09;
    public boolean A0D;
    public boolean A0E;
    public float A01 = 1.0f;
    public float A00 = 1.0f;
    public C06973i A07 = C06973i.A05;
    public C06973i A08 = C06973i.A05;
    public C06973i A05 = C06973i.A05;
    public C06973i A06 = C06973i.A05;
    public ByteBuffer A0A = InterfaceC06993k.A00;
    public ShortBuffer A0C = this.A0A.asShortBuffer();
    public ByteBuffer A0B = InterfaceC06993k.A00;
    public int A02 = -1;

    public final long A00(long j) {
        if (this.A04 >= 1024) {
            long A0I = this.A03 - ((C9Y) AbstractC07133y.A01(this.A09)).A0I();
            if (this.A06.A03 == this.A05.A03) {
                long processedInputBytes = C5C.A0U(j, A0I, this.A04);
                return processedInputBytes;
            }
            long processedInputBytes2 = this.A06.A03;
            long j2 = A0I * processedInputBytes2;
            long j3 = this.A04;
            long processedInputBytes3 = this.A05.A03;
            return C5C.A0U(j, j2, j3 * processedInputBytes3);
        }
        return (long) (this.A01 * j);
    }

    public final void A01(float f) {
        if (this.A00 != f) {
            this.A00 = f;
            this.A0E = true;
        }
    }

    public final void A02(float f) {
        if (this.A01 != f) {
            this.A01 = f;
            this.A0E = true;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final C06973i A57(C06973i c06973i) throws C06983j {
        int i;
        if (c06973i.A02 == 2) {
            if (this.A02 == -1) {
                i = c06973i.A03;
            } else {
                i = this.A02;
            }
            this.A07 = c06973i;
            this.A08 = new C06973i(i, c06973i.A01, 2);
            this.A0E = true;
            return this.A08;
        }
        throw new C06983j(c06973i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final ByteBuffer A8d() {
        int A0H;
        C9Y c9y = this.A09;
        if (c9y != null && (A0H = c9y.A0H()) > 0) {
            if (this.A0A.capacity() < A0H) {
                this.A0A = ByteBuffer.allocateDirect(A0H).order(ByteOrder.nativeOrder());
                this.A0C = this.A0A.asShortBuffer();
            } else {
                this.A0A.clear();
                this.A0C.clear();
            }
            c9y.A0L(this.A0C);
            this.A04 += A0H;
            this.A0A.limit(A0H);
            this.A0B = this.A0A;
        }
        ByteBuffer outputBuffer = this.A0B;
        this.A0B = InterfaceC06993k.A00;
        return outputBuffer;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final boolean AAL() {
        return this.A08.A03 != -1 && (Math.abs(this.A01 - 1.0f) >= 1.0E-4f || Math.abs(this.A00 - 1.0f) >= 1.0E-4f || this.A08.A03 != this.A07.A03);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final boolean AAP() {
        return this.A0D && (this.A09 == null || this.A09.A0H() == 0);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void AHG() {
        if (this.A09 != null) {
            this.A09.A0K();
        }
        this.A0D = true;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void AHH(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        C9Y c9y = (C9Y) AbstractC07133y.A01(this.A09);
        ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
        int remaining = byteBuffer.remaining();
        this.A03 += remaining;
        c9y.A0M(asShortBuffer);
        byteBuffer.position(byteBuffer.position() + remaining);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void flush() {
        if (AAL()) {
            this.A05 = this.A07;
            this.A06 = this.A08;
            if (this.A0E) {
                this.A09 = new C9Y(this.A05.A03, this.A05.A01, this.A01, this.A00, this.A06.A03);
            } else if (this.A09 != null) {
                this.A09.A0J();
            }
        }
        this.A0B = InterfaceC06993k.A00;
        this.A03 = 0L;
        this.A04 = 0L;
        this.A0D = false;
    }
}
