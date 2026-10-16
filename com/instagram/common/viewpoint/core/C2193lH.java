package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.lH, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2193lH implements InterfaceC1131Kv {
    public static byte[] A0L;
    public static String[] A0M = {"j9JFF3HN4WHOogTAo3Zp2vJcrDXalLKC", "xTu", "o", "YpEMu", "L", "xqkbJV3NP5tWtCpR6dlW7fuQWbu0Okpq", "9ZwPJyvjhOXD2", "3pAsgJTRE4XOqhE7"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public long A09;
    public long A0A;
    public C2489qI A0C;
    public InterfaceC1036Hd A0D;
    public String A0E;
    public String A0F;
    public boolean A0G;
    public boolean A0H;
    public final String A0K;
    public final C07364v A0J = new C07364v(1024);
    public final C07354u A0I = new C07354u(this.A0J.A0l());
    public long A0B = -9223372036854775807L;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0M;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            A0M[5] = "ZyB29Ut14cj6jISqnQaPpNUB2bA7E60q";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 57);
            i4++;
        }
    }

    public static void A04() {
        A0L = new byte[]{3, Ascii.ETB, 6, Ascii.VT, Ascii.CR, 77, Ascii.SI, Ascii.DC2, 86, 3, 79, Ascii.SO, 3, Ascii.SYN, Ascii.SI};
    }

    static {
        A04();
    }

    public C2193lH(String str) {
        this.A0K = str;
    }

    private int A00(C07354u c07354u) throws C3K {
        int A01 = c07354u.A01();
        C1019Gm config = AbstractC1020Gn.A02(c07354u, true);
        this.A0E = config.A02;
        int bitsLeft = config.A01;
        this.A05 = bitsLeft;
        int bitsLeft2 = config.A00;
        this.A02 = bitsLeft2;
        int bitsLeft3 = c07354u.A01();
        return A01 - bitsLeft3;
    }

    private int A01(C07354u c07354u) throws C3K {
        int tmp;
        int i = 0;
        int muxSlotLengthBytes = this.A03;
        if (muxSlotLengthBytes == 0) {
            do {
                tmp = c07354u.A04(8);
                i += tmp;
            } while (tmp == 255);
            return i;
        }
        throw C3K.A01(null, null);
    }

    public static long A02(C07354u c07354u) {
        int bytesForValue = c07354u.A04(2);
        return c07354u.A04((bytesForValue + 1) * 8);
    }

    private void A05(int i) {
        this.A0J.A0d(i);
        this.A0I.A0D(this.A0J.A0l());
    }

    @RequiresNonNull({"output"})
    private void A06(C07354u c07354u) throws C3K {
        boolean useSameStreamMux = c07354u.A0H();
        if (!useSameStreamMux) {
            this.A0H = true;
            A08(c07354u);
        } else {
            boolean useSameStreamMux2 = this.A0H;
            if (!useSameStreamMux2) {
                return;
            }
        }
        if (this.A00 == 0) {
            if (this.A04 == 0) {
                A09(c07354u, A01(c07354u));
                boolean useSameStreamMux3 = this.A0G;
                if (useSameStreamMux3) {
                    c07354u.A09((int) this.A09);
                    return;
                }
                return;
            }
            throw C3K.A01(null, null);
        }
        throw C3K.A01(null, null);
    }

    private void A07(C07354u c07354u) {
        this.A03 = c07354u.A04(3);
        switch (this.A03) {
            case 0:
                c07354u.A09(8);
                return;
            case 1:
                c07354u.A09(9);
                return;
            case 2:
            default:
                throw new IllegalStateException();
            case 3:
            case 4:
            case 5:
                c07354u.A09(6);
                return;
            case 6:
            case 7:
                c07354u.A09(1);
                return;
        }
    }

    @RequiresNonNull({"output"})
    private void A08(C07354u c07354u) throws C3K {
        int i;
        boolean A0H;
        int A04 = c07354u.A04(1);
        if (A04 == 1) {
            i = c07354u.A04(1);
        } else {
            i = 0;
        }
        this.A00 = i;
        if (this.A00 == 0) {
            if (A04 == 1) {
                A02(c07354u);
            }
            if (c07354u.A0H()) {
                this.A04 = c07354u.A04(6);
                int A042 = c07354u.A04(4);
                int audioMuxVersion = A0M[5].charAt(25);
                if (audioMuxVersion != 98) {
                    throw new RuntimeException();
                }
                A0M[5] = "b1jqAFGEyfNrz2WgotNy1OFmmbCQivCc";
                int A043 = c07354u.A04(3);
                if (A042 == 0 && A043 == 0) {
                    if (A04 == 0) {
                        int A03 = c07354u.A03();
                        int audioMuxVersion2 = A00(c07354u);
                        c07354u.A08(A03);
                        byte[] bArr = new byte[(audioMuxVersion2 + 7) / 8];
                        c07354u.A0F(bArr, 0, audioMuxVersion2);
                        C2489qI A14 = new C06802p().A0y(this.A0F).A11(A03(0, 15, 91)).A0w(this.A0E).A0b(this.A02).A0m(this.A05).A12(Collections.singletonList(bArr)).A10(this.A0K).A14();
                        if (!A14.equals(this.A0C)) {
                            this.A0C = A14;
                            this.A0A = 1024000000 / A14.A0G;
                            this.A0D.A6e(A14);
                        }
                    } else {
                        int audioMuxVersion3 = (int) A02(c07354u);
                        c07354u.A09(audioMuxVersion3 - A00(c07354u));
                    }
                    A07(c07354u);
                    this.A0G = c07354u.A0H();
                    this.A09 = 0L;
                    if (this.A0G) {
                        if (A04 == 1) {
                            this.A09 = A02(c07354u);
                        } else {
                            do {
                                A0H = c07354u.A0H();
                                this.A09 = (this.A09 << 8) + c07354u.A04(8);
                            } while (A0H);
                        }
                    }
                    boolean crcCheckPresent = c07354u.A0H();
                    if (crcCheckPresent) {
                        c07354u.A09(8);
                        return;
                    }
                    return;
                }
                throw C3K.A01(null, null);
            }
            throw C3K.A01(null, null);
        }
        throw C3K.A01(null, null);
    }

    @RequiresNonNull({"output"})
    private void A09(C07354u c07354u, int i) {
        int A03 = c07354u.A03();
        int bitPosition = A03 & 7;
        if (bitPosition == 0) {
            int bitPosition2 = A03 >> 3;
            this.A0J.A0f(bitPosition2);
        } else {
            int bitPosition3 = i * 8;
            c07354u.A0F(this.A0J.A0l(), 0, bitPosition3);
            this.A0J.A0f(0);
        }
        this.A0D.AIr(this.A0J, i);
        if (this.A0B != -9223372036854775807L) {
            this.A0D.AIu(this.A0B, 1, i, 0, null);
            this.A0B += this.A0A;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5A(C07364v c07364v) throws C3K {
        AbstractC07133y.A02(this.A0D);
        while (c07364v.A07() > 0) {
            switch (this.A08) {
                case 0:
                    int secondByte = c07364v.A0I();
                    if (secondByte != 86) {
                        break;
                    } else {
                        this.A08 = 1;
                        break;
                    }
                case 1:
                    int A0I = c07364v.A0I();
                    if ((A0I & 224) == 224) {
                        this.A07 = A0I;
                        this.A08 = 2;
                        break;
                    } else if (A0I == 86) {
                        break;
                    } else {
                        this.A08 = 0;
                        break;
                    }
                case 2:
                    int bytesToRead = this.A07;
                    this.A06 = ((bytesToRead & (-225)) << 8) | c07364v.A0I();
                    if (this.A06 > this.A0J.A0l().length) {
                        A05(this.A06);
                    }
                    this.A01 = 0;
                    this.A08 = 3;
                    break;
                case 3:
                    int min = Math.min(c07364v.A07(), this.A06 - this.A01);
                    byte[] bArr = this.A0I.A00;
                    int bytesToRead2 = this.A01;
                    c07364v.A0k(bArr, bytesToRead2, min);
                    int bytesToRead3 = this.A01;
                    this.A01 = bytesToRead3 + min;
                    int i = this.A01;
                    int bytesToRead4 = this.A06;
                    if (i != bytesToRead4) {
                        break;
                    } else {
                        this.A0I.A08(0);
                        A06(this.A0I);
                        this.A08 = 0;
                        break;
                    }
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A0D = ha.AKS(lg.A03(), 1);
        this.A0F = lg.A04();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGp() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGq(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A0B = j;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AJ5() {
        this.A08 = 0;
        this.A0B = -9223372036854775807L;
        this.A0H = false;
    }
}
