package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.9f, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08449f implements InterfaceC2280ms {
    public static String[] A07 = {"YlHQuKLayYbpqzx9FSV6CQrLdQj96AeM", "S4RZcb4lBSGk97kEvSl91HaEV0P4", "uVSfNf", "Coq", "aQ2CxhcvUBulJYKynnVyQo", "flTysjHMhLtcJrzUbSTnFz15x2mZl", "8oFgaOvQgeQ1BxQlutu1jILF1QVjJ1FW", "wjWZdP"};
    public int A00;
    public int A01;
    public long A02;
    public byte[] A03;
    public final long A04;
    public final InterfaceC2425pF A05;
    public final byte[] A06;

    public C08449f(InterfaceC2425pF interfaceC2425pF, long j, long j2) {
        this(interfaceC2425pF, j, j2, false);
    }

    public C08449f(InterfaceC2425pF interfaceC2425pF, long j, long j2, boolean z) {
        this.A05 = interfaceC2425pF;
        this.A02 = j;
        this.A04 = j2;
        this.A03 = new byte[65536];
        this.A06 = new byte[4096];
    }

    private int A00(int i) {
        int bytesSkipped = Math.min(this.A00, i);
        A05(bytesSkipped);
        return bytesSkipped;
    }

    private int A01(byte[] bArr, int i, int i2) {
        if (this.A00 == 0) {
            return 0;
        }
        int min = Math.min(this.A00, i2);
        System.arraycopy(this.A03, 0, bArr, i, min);
        A05(min);
        return min;
    }

    private int A02(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.A05.read(bArr, i + i3, i2 - i3);
            if (read == -1) {
                if (i3 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i3 + read;
        }
        throw new InterruptedIOException();
    }

    private void A03(int i) {
        if (i != -1) {
            this.A02 += i;
        }
    }

    private void A04(int i) {
        int i2 = this.A01 + i;
        int requiredLength = this.A03.length;
        if (i2 > requiredLength) {
            int requiredLength2 = this.A03.length;
            int requiredLength3 = 524288 + i2;
            int newPeekCapacity = C5C.A07(requiredLength2 * 2, 65536 + i2, requiredLength3);
            this.A03 = Arrays.copyOf(this.A03, newPeekCapacity);
        }
    }

    private void A05(int i) {
        this.A00 -= i;
        this.A01 = 0;
        byte[] bArr = this.A03;
        if (this.A00 < this.A03.length - 524288) {
            bArr = new byte[this.A00 + 65536];
        }
        byte[] bArr2 = this.A03;
        int i2 = this.A00;
        if (A07[3].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[7] = "U6HOVF";
        strArr[2] = "FLrwJS";
        System.arraycopy(bArr2, i, bArr, 0, i2);
        this.A03 = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        if (r4 == (-1)) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        A03(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A06(int i, boolean z) throws IOException {
        int A00 = A00(i);
        while (true) {
            String[] strArr = A07;
            String str = strArr[1];
            String str2 = strArr[5];
            int length = str.length();
            int bytesSkipped = str2.length();
            if (length == bytesSkipped) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "VT2oIT";
            strArr2[2] = "AHKvNZ";
            if (A00 >= i || A00 == -1) {
                break;
            }
            int bytesSkipped2 = this.A06.length;
            A00 = A02(this.A06, -A00, Math.min(i, bytesSkipped2 + A00), A00, z);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final void A47(int i) throws IOException {
        A48(i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        throw new java.lang.RuntimeException();
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A48(int i, boolean z) throws IOException {
        A04(i);
        int i2 = this.A00 - this.A01;
        while (true) {
            if (i2 < i) {
                i2 = A02(this.A03, this.A01, i, i2, z);
                if (i2 == -1) {
                    String[] strArr = A07;
                    String str = strArr[6];
                    String str2 = strArr[0];
                    int charAt = str.charAt(25);
                    int bytesPeeked = str2.charAt(25);
                    if (charAt == bytesPeeked) {
                        String[] strArr2 = A07;
                        strArr2[1] = "U9yRyStfgEDvt0OpJggQJXPRXL9S";
                        strArr2[5] = "yvkfr8ZSlHssIeYh6rwGG04GsxspU";
                        return false;
                    }
                } else {
                    int bytesPeeked2 = this.A01;
                    this.A00 = bytesPeeked2 + i2;
                }
            } else {
                int bytesPeeked3 = this.A01;
                this.A01 = bytesPeeked3 + i;
                String[] strArr3 = A07;
                String str3 = strArr3[1];
                String str4 = strArr3[5];
                int length = str3.length();
                int bytesPeeked4 = str4.length();
                if (length != bytesPeeked4) {
                    A07[3] = "05c";
                    return true;
                }
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final long A8O() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final long A8i() {
        return this.A02 + this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final long A8n() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final Uri A9P() {
        return this.A05.A9P();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final int AGs(byte[] bArr, int i, int i2) throws IOException {
        int min;
        A04(i2);
        int bytesPeeked = this.A00 - this.A01;
        if (bytesPeeked == 0) {
            min = A02(this.A03, this.A01, i2, 0, true);
            if (min == -1) {
                return -1;
            }
            int peekBufferRemainingBytes = this.A00;
            this.A00 = peekBufferRemainingBytes + min;
        } else {
            min = Math.min(i2, bytesPeeked);
        }
        byte[] bArr2 = this.A03;
        int peekBufferRemainingBytes2 = this.A01;
        System.arraycopy(bArr2, peekBufferRemainingBytes2, bArr, i, min);
        int peekBufferRemainingBytes3 = this.A01;
        this.A01 = peekBufferRemainingBytes3 + min;
        return min;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final void AGt(byte[] bArr, int i, int i2) throws IOException {
        AGu(bArr, i, i2, false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final boolean AGu(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!A48(i2, z)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i2, bArr, i, i2);
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final boolean AHR(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int A01 = A01(bArr, i, i2);
        while (A01 < i2 && A01 != -1) {
            A01 = A02(bArr, i, i2, A01, z);
        }
        A03(A01);
        return A01 != -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final void AIl() {
        this.A01 = 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final int AK0(int i) throws IOException {
        int A00 = A00(i);
        if (A00 == 0) {
            byte[] bArr = this.A06;
            int bytesSkipped = this.A06.length;
            A00 = A02(bArr, 0, Math.min(i, bytesSkipped), 0, true);
        }
        A03(A00);
        String[] strArr = A07;
        String str = strArr[7];
        String str2 = strArr[2];
        int length = str.length();
        int bytesSkipped2 = str2.length();
        if (length != bytesSkipped2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "4muWdj2u5Q3eId9F7O7O9kyn7QS9F70y";
        strArr2[0] = "MQBZi4ACHP4vbg8D4iuKjBQaYQ9ASuUs";
        return A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final void AK3(int i) throws IOException {
        A06(i, false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms, com.instagram.common.viewpoint.core.InterfaceC06692c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int bytesRead = A01(bArr, i, i2);
        if (bytesRead == 0) {
            bytesRead = A02(bArr, i, i2, 0, true);
        }
        A03(bytesRead);
        return bytesRead;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2280ms
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        AHR(bArr, i, i2, false);
    }
}
