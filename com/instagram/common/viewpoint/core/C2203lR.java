package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.lR, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2203lR implements H9 {
    public static byte[] A0C;
    public static String[] A0D = {"Jp9jYTsvX0byW8PsTh8WCsi4kS5THTDZ", "u9JmQf2RUpXkbwKGcH1ldYLO1OaAnoG0", "zVRI5h7vLNN08I5W1BFePAuDidXDjkLB", "GupX0AjjIH906l5opBlPCY0Mrv7mkKOY", "YLyM9aD6SKjNKerJ1EloHyT", "oAaNr5RuznTKLecZmpLN", "Q5WjYzMQ2NaCiwYPtyRn68zXUmvTXGHf", "bi8dQH0GL9bk2fQxVP7KQMQdOg6RbrhP"};
    public static final HD A0E;
    public int A00;
    public long A01;
    public long A02;
    public HA A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public final int A07;
    public final C07354u A08;
    public final C07364v A09;
    public final C07364v A0A;
    public final C2202lQ A0B;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 50);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{39, Ascii.VT, 6, Ascii.FF, 5, Ascii.CAN, 7, Ascii.SI, Ascii.SO, 74, 43, 46, 62, 57, 74, Ascii.EM, Ascii.RS, Ascii.CAN, Ascii.SI, Ascii.VT, 7};
    }

    static {
        A04();
        A0E = new HD() { // from class: com.facebook.ads.redexgen.X.lS
            @Override // com.instagram.common.viewpoint.core.HD
            public final H9[] A5N() {
                return C2203lR.A07();
            }

            @Override // com.instagram.common.viewpoint.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    public C2203lR() {
        this(0);
    }

    public C2203lR(int i) {
        this.A07 = (i & 2) != 0 ? i | 1 : i;
        this.A0B = new C2202lQ(true);
        this.A09 = new C07364v(2048);
        this.A00 = -1;
        this.A01 = -1L;
        this.A0A = new C07364v(10);
        this.A08 = new C07354u(this.A0A.A0l());
    }

    public static int A00(int i, long j) {
        return (int) (((i * 8) * 1000000) / j);
    }

    private int A01(InterfaceC2280ms interfaceC2280ms) throws IOException {
        int i = 0;
        while (true) {
            interfaceC2280ms.AGt(this.A0A.A0l(), 0, 10);
            this.A0A.A0f(0);
            if (this.A0A.A0K() != 4801587) {
                break;
            }
            this.A0A.A0g(3);
            int length = this.A0A.A0H();
            int firstFramePosition = length + 10;
            i += firstFramePosition;
            interfaceC2280ms.A47(length);
        }
        interfaceC2280ms.AIl();
        interfaceC2280ms.A47(i);
        if (this.A01 == -1) {
            this.A01 = i;
        }
        return i;
    }

    private C2284mx A02(long j, boolean z) {
        return new C2284mx(j, this.A01, A00(this.A00, this.A0B.A0J()), this.A00, z);
    }

    @RequiresNonNull({"extractorOutput"})
    private void A05(long j, boolean z) {
        if (this.A05) {
            return;
        }
        boolean z2 = (this.A07 & 1) != 0 && this.A00 > 0;
        String[] strArr = A0D;
        if (strArr[2].charAt(14) != strArr[3].charAt(14)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[0] = "wRCLGMQDqXZHrYOEljE7cvu367IJP6qz";
        strArr2[1] = "FofxBB8LpAk5nYyyotl0uMBanfu6Lq1A";
        if (z2 && this.A0B.A0J() == -9223372036854775807L && !z) {
            return;
        }
        if (!z2 || this.A0B.A0J() == -9223372036854775807L) {
            this.A03.AJ7(new C2275mn(-9223372036854775807L));
        } else {
            this.A03.AJ7(A02(j, (this.A07 & 2) != 0));
        }
        this.A05 = true;
    }

    private void A06(InterfaceC2280ms interfaceC2280ms) throws IOException {
        if (this.A04) {
            return;
        }
        this.A00 = -1;
        interfaceC2280ms.AIl();
        if (interfaceC2280ms.A8n() == 0) {
            A01(interfaceC2280ms);
        }
        int currentFrameSize = 0;
        long j = 0;
        while (true) {
            try {
                if (!interfaceC2280ms.AGu(this.A0A.A0l(), 0, 2, true)) {
                    break;
                }
                this.A0A.A0f(0);
                if (C2202lQ.A0F(this.A0A.A0M())) {
                    if (!interfaceC2280ms.AGu(this.A0A.A0l(), 0, 4, true)) {
                        break;
                    }
                    this.A08.A08(14);
                    int A04 = this.A08.A04(13);
                    int numValidFrames = A0D[7].charAt(7);
                    if (numValidFrames != 114) {
                        A0D[4] = "EiGF";
                        if (A04 > 6) {
                            j += A04;
                            currentFrameSize++;
                            if (currentFrameSize == 1000 || !interfaceC2280ms.A48(A04 - 6, true)) {
                                break;
                            }
                        } else {
                            this.A04 = true;
                            throw C3K.A01(A03(0, 21, 88), null);
                        }
                    } else {
                        throw new RuntimeException();
                    }
                } else {
                    currentFrameSize = 0;
                    break;
                }
            } catch (EOFException unused) {
            }
        }
        interfaceC2280ms.AIl();
        if (currentFrameSize > 0) {
            this.A00 = (int) (j / currentFrameSize);
        } else {
            this.A00 = -1;
        }
        this.A04 = true;
    }

    public static /* synthetic */ H9[] A07() {
        return new H9[]{new C2203lR()};
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AAC(HA ha) {
        this.A03 = ha;
        this.A0B.A5c(ha, new LG(0, 1));
        ha.A6O();
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final int AHL(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        AbstractC07133y.A02(this.A03);
        long A8O = interfaceC2280ms.A8O();
        if (((this.A07 & 2) == 0 && ((this.A07 & 1) == 0 || A8O == -1)) ? false : true) {
            A06(interfaceC2280ms);
        }
        int bytesRead = interfaceC2280ms.read(this.A09.A0l(), 0, 2048);
        boolean z = bytesRead == -1;
        A05(A8O, z);
        if (z) {
            return -1;
        }
        this.A09.A0f(0);
        this.A09.A0e(bytesRead);
        if (!this.A06) {
            this.A0B.AGq(this.A02, 4);
            this.A06 = true;
        }
        this.A0B.A5A(this.A09);
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AHb() {
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AJ6(long j, long j2) {
        this.A06 = false;
        this.A0B.AJ5();
        this.A02 = j2;
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final boolean AK5(InterfaceC2280ms interfaceC2280ms) throws IOException {
        int headerPosition;
        int A01 = A01(interfaceC2280ms);
        int i = A01;
        int frameSize = 0;
        int syncBytes = 0;
        do {
            interfaceC2280ms.AGt(this.A0A.A0l(), 0, 2);
            this.A0A.A0f(0);
            int startPosition = this.A0A.A0M();
            if (!C2202lQ.A0F(startPosition)) {
                syncBytes = 0;
                frameSize = 0;
                i++;
                interfaceC2280ms.AIl();
                interfaceC2280ms.A47(i);
            } else {
                syncBytes++;
                String[] strArr = A0D;
                String str = strArr[2];
                String str2 = strArr[3];
                int headerPosition2 = str.charAt(14);
                int startPosition2 = str2.charAt(14);
                if (headerPosition2 != startPosition2) {
                    throw new RuntimeException();
                }
                A0D[7] = "vlF0iwwjiK26GT4HTqGcAOiXXpcsHbpg";
                if (syncBytes >= 4 && frameSize > 188) {
                    return true;
                }
                interfaceC2280ms.AGt(this.A0A.A0l(), 0, 4);
                this.A08.A08(14);
                C07354u c07354u = this.A08;
                int headerPosition3 = A0D[5].length();
                if (headerPosition3 == 4) {
                    throw new RuntimeException();
                }
                A0D[4] = "LrBCAcAc8FKB1NeW";
                int headerPosition4 = c07354u.A04(13);
                if (headerPosition4 <= 6) {
                    syncBytes = 0;
                    frameSize = 0;
                    i++;
                    interfaceC2280ms.AIl();
                    interfaceC2280ms.A47(i);
                } else {
                    int startPosition3 = headerPosition4 - 6;
                    interfaceC2280ms.A47(startPosition3);
                    frameSize += headerPosition4;
                }
            }
            headerPosition = i - A01;
        } while (headerPosition < 8192);
        return false;
    }
}
