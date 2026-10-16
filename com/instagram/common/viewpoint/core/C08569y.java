package com.instagram.common.viewpoint.core;

import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;

/* renamed from: com.facebook.ads.redexgen.X.9y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08569y extends AbstractC2374oQ {
    public static String[] A0C = {"kTOKNBh1Wp6avXYwKxrfNqHQCe6IowZb", "fsh7jTNUZTGCSew0VT63IO4tkQUYppyQ", "CGsUWOpaOXfE7pNtsFBesiWCOQ75lYHg", "3QzqyUj5HYGt0uXrFXWs5fdma44AOfyL", "C3DxIlHWWAPwLuHgY8W8WEDh6NP", "cCeo7h1kMT8v6dcJbz1RM5PEEOyjnS1I", "8Ip3ivaO", "u5WK46JzMVMnhOVxX0VDjJ353j7WObAc"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public byte[] A07;
    public byte[] A08;
    public final long A09;
    public final long A0A;
    public final short A0B;

    public C08569y() {
        this(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 20000L, (short) 1024);
    }

    public C08569y(long j, long j2, short s) {
        AbstractC07133y.A07(j2 <= j);
        this.A09 = j;
        this.A0A = j2;
        this.A0B = s;
        this.A07 = C5C.A07;
        this.A08 = C5C.A07;
    }

    private int A00(long j) {
        return (int) ((super.A05.A03 * j) / 1000000);
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A01(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 2; limit >= i; limit -= 2) {
            int i = byteBuffer.getShort(limit);
            int abs = Math.abs(i);
            int i2 = this.A0B;
            if (abs > i2) {
                int i3 = this.A00;
                int i4 = this.A00;
                int i5 = i3 * (limit / i4);
                int i6 = this.A00;
                return i5 + i6;
            }
        }
        int i7 = byteBuffer.position();
        return i7;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A02(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < i; position += 2) {
            int i = byteBuffer.getShort(position);
            int abs = Math.abs(i);
            int i2 = this.A0B;
            if (abs > i2) {
                int i3 = this.A00;
                int i4 = this.A00;
                return i3 * (position / i4);
            }
        }
        int i5 = byteBuffer.limit();
        return i5;
    }

    private void A03(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        A00(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.A06 = true;
        }
    }

    private void A04(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int maybeSilenceBufferRemaining = A02(byteBuffer);
        int limit2 = byteBuffer.position();
        int maybeSilenceInputSize = maybeSilenceBufferRemaining - limit2;
        int noisePosition = this.A07.length;
        int limit3 = this.A01;
        int noisePosition2 = noisePosition - limit3;
        if (maybeSilenceBufferRemaining < limit && maybeSilenceInputSize < noisePosition2) {
            byte[] bArr = this.A07;
            int maybeSilenceBufferRemaining2 = this.A01;
            int noisePosition3 = A0C[4].length();
            if (noisePosition3 == 0) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[2] = "id1mOky4Zsioh8kkFhZ0Iqg9uH7l7sht";
            strArr[7] = "uHcgX8Q5LBy4SketH3HUZ8MVXP73GzFI";
            A08(bArr, maybeSilenceBufferRemaining2);
            this.A01 = 0;
            this.A03 = 0;
            return;
        }
        int maybeSilenceInputSize2 = Math.min(maybeSilenceInputSize, noisePosition2);
        int limit4 = byteBuffer.position();
        byteBuffer.limit(limit4 + maybeSilenceInputSize2);
        byte[] bArr2 = this.A07;
        int limit5 = this.A01;
        byteBuffer.get(bArr2, limit5, maybeSilenceInputSize2);
        int limit6 = this.A01;
        this.A01 = limit6 + maybeSilenceInputSize2;
        int noisePosition4 = this.A01;
        int limit7 = this.A07.length;
        if (noisePosition4 == limit7) {
            if (this.A06) {
                byte[] bArr3 = this.A07;
                int limit8 = this.A02;
                A08(bArr3, limit8);
                long j = this.A04;
                int noisePosition5 = this.A01;
                int limit9 = this.A02;
                int noisePosition6 = noisePosition5 - (limit9 * 2);
                int limit10 = this.A00;
                this.A04 = j + (noisePosition6 / limit10);
            } else {
                long j2 = this.A04;
                int noisePosition7 = this.A01;
                int limit11 = this.A02;
                int noisePosition8 = noisePosition7 - limit11;
                int limit12 = this.A00;
                this.A04 = j2 + (noisePosition8 / limit12);
            }
            byte[] bArr4 = this.A07;
            int limit13 = this.A01;
            A07(byteBuffer, bArr4, limit13);
            this.A01 = 0;
            this.A03 = 2;
        }
        byteBuffer.limit(limit);
    }

    private void A05(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int limit2 = this.A07.length;
        byteBuffer.limit(Math.min(limit, position + limit2));
        int noiseLimit = A01(byteBuffer);
        int limit3 = byteBuffer.position();
        if (noiseLimit == limit3) {
            this.A03 = 1;
        } else {
            byteBuffer.limit(noiseLimit);
            A03(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void A06(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int A02 = A02(byteBuffer);
        byteBuffer.limit(A02);
        long j = this.A04;
        int noisyPosition = byteBuffer.remaining();
        int limit2 = this.A00;
        this.A04 = j + (noisyPosition / limit2);
        byte[] bArr = this.A08;
        int limit3 = this.A02;
        A07(byteBuffer, bArr, limit3);
        if (A02 < limit) {
            byte[] bArr2 = this.A08;
            int limit4 = this.A02;
            A08(bArr2, limit4);
            this.A03 = 0;
            byteBuffer.limit(limit);
        }
    }

    private void A07(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.A02);
        int i2 = this.A02 - min;
        System.arraycopy(bArr, i - i2, this.A08, 0, i2);
        int fromInputSize = byteBuffer.limit();
        byteBuffer.position(fromInputSize - min);
        byteBuffer.get(this.A08, i2, min);
    }

    private void A08(byte[] bArr, int i) {
        A00(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.A06 = true;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ
    public final C06973i A09(C06973i c06973i) throws C06983j {
        if (c06973i.A02 == 2) {
            return this.A05 ? c06973i : C06973i.A05;
        }
        throw new C06983j(c06973i);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ
    public final void A0A() {
        if (this.A05) {
            this.A00 = super.A05.A00;
            int A00 = A00(this.A09) * this.A00;
            int maybeSilenceBufferSize = this.A07.length;
            if (maybeSilenceBufferSize != A00) {
                this.A07 = new byte[A00];
            }
            int A002 = A00(this.A0A);
            int maybeSilenceBufferSize2 = this.A00;
            this.A02 = A002 * maybeSilenceBufferSize2;
            int length = this.A08.length;
            int maybeSilenceBufferSize3 = this.A02;
            if (length != maybeSilenceBufferSize3) {
                int maybeSilenceBufferSize4 = this.A02;
                this.A08 = new byte[maybeSilenceBufferSize4];
            }
        }
        this.A03 = 0;
        this.A04 = 0L;
        this.A01 = 0;
        this.A06 = false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ
    public final void A0B() {
        if (this.A01 > 0) {
            A08(this.A07, this.A01);
        }
        boolean z = this.A06;
        if (A0C[0].charAt(10) == 'o') {
            throw new RuntimeException();
        }
        A0C[3] = "3PybTV2kdzhjV0AdFBUr0i874h0Ge15Q";
        if (!z) {
            this.A04 += this.A02 / this.A00;
        }
    }

    public final long A0C() {
        return this.A04;
    }

    public final void A0D(boolean z) {
        this.A05 = z;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2374oQ, com.instagram.common.viewpoint.core.InterfaceC06993k
    public final boolean AAL() {
        return this.A05;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06993k
    public final void AHH(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !A01()) {
            switch (this.A03) {
                case 0:
                    A05(byteBuffer);
                    break;
                case 1:
                    A04(byteBuffer);
                    break;
                case 2:
                    A06(byteBuffer);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }
}
