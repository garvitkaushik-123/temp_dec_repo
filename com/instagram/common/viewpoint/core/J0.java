package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MdtaMetadataEntry;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.mediationsdk.demandOnly.e;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.io.encoding.Base64;

@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
/* loaded from: assets/audience_network/classes2.dex */
public abstract class J0 {
    public static byte[] A00;
    public static String[] A01 = {"3VpIAtFn", "NjWxo0tcAFilzYXB2gd1dub2S4KYfC0G", "7dc9OwNzjfbA4WDbGdH3UDrd", "kTLJpOKA", "odl5U202HvuloegJiYsgd2o0Bsn6ktlS", "Tqd8q9EAW1nxLdrfn3G624yWy86zlBE3", "GM6CYLF4x47fKf9mrP144TBtf3lMkKEe", "FJhXpGWKImafMZTrlZrsHtUKnb1aBvQ9"};
    public static final byte[] A02;

    @MetaExoPlayerCustomization("Needed for oculus customization")
    public static final int[] A03;

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0170, code lost:
    
        if (r9 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0172, code lost:
    
        r7.A09(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01e2, code lost:
    
        if (r9 == false) goto L51;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorInfo A0B(C07364v c07364v) {
        C06672a c06672a = new C06672a();
        C07354u c07354u = new C07354u(c07364v.A0l());
        c07354u.A08(c07364v.A09() * 8);
        c07354u.A0A(1);
        c07354u.A04(3);
        c07354u.A09(6);
        c07354u.A0H();
        c07354u.A0H();
        c07354u.A09(13);
        c07354u.A07();
        int A04 = c07354u.A04(4);
        String A0M = A0M(178, 11, 68);
        if (A04 != 1) {
            AbstractC07214g.A06(A0M, A0M(593, 22, 87) + A04);
            return c06672a.A03();
        }
        if (c07354u.A0H()) {
            AbstractC07214g.A06(A0M, A0M(563, 30, 42));
            return c06672a.A03();
        }
        boolean A0H = c07354u.A0H();
        c07354u.A07();
        if (A0H && c07354u.A04(8) > 127) {
            AbstractC07214g.A06(A0M, A0M(189, 18, 61));
            return c06672a.A03();
        }
        int A042 = c07354u.A04(3);
        c07354u.A07();
        if (c07354u.A0H()) {
            AbstractC07214g.A06(A0M, A0M(615, 40, 96));
            return c06672a.A03();
        }
        if (c07354u.A0H()) {
            AbstractC07214g.A06(A0M, A0M(655, 36, 7));
            return c06672a.A03();
        }
        if (c07354u.A0H()) {
            AbstractC07214g.A06(A0M, A0M(494, 46, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
            return c06672a.A03();
        }
        int A043 = c07354u.A04(5);
        for (int i = 0; i <= A043; i++) {
            c07354u.A09(12);
            if (c07354u.A04(5) > 7) {
                c07354u.A07();
            }
        }
        int A044 = c07354u.A04(4);
        int A045 = c07354u.A04(4);
        c07354u.A09(A044 + 1);
        c07354u.A09(A045 + 1);
        if (c07354u.A0H()) {
            c07354u.A09(7);
        }
        c07354u.A09(7);
        boolean A0H2 = c07354u.A0H();
        if (A0H2) {
            c07354u.A09(2);
        }
        boolean A0H3 = c07354u.A0H();
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        A01[2] = "spdqEdfVqdQubNKbzHaSCSbA";
        if ((A0H3 ? 2 : c07354u.A04(1)) > 0) {
            boolean A0H4 = c07354u.A0H();
            if (A01[5].charAt(23) != 'W') {
                A01[5] = "fpomjt14ZeQUreCUx8H2Qj9W8NeulNVr";
            } else {
                String[] strArr2 = A01;
                strArr2[7] = "VYuT40g5EEwFWTEBAX27ZdDSMSIcM78J";
                strArr2[4] = "WUQpgtHZDasrpP5hdEQLNs2AngJpMhTI";
            }
        }
        if (A0H2) {
            c07354u.A09(3);
        }
        c07354u.A09(3);
        boolean A0H5 = c07354u.A0H();
        if (A042 == 2 && A0H5) {
            c07354u.A07();
        }
        boolean z = A042 != 1 && c07354u.A0H();
        if (c07354u.A0H()) {
            int A046 = c07354u.A04(8);
            int A047 = c07354u.A04(8);
            c06672a.A01(ColorInfo.A00(A046)).A00(((z || A046 != 1 || A047 != 13 || c07354u.A04(8) != 0) ? c07354u.A04(1) : 1) != 1 ? 2 : 1).A02(ColorInfo.A01(A047));
        }
        return c06672a.A03();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Metadata A0F(C2252mE c2252mE) {
        C2251mD A07 = c2252mE.A07(1751411826);
        C2251mD A072 = c2252mE.A07(1801812339);
        C2251mD A073 = c2252mE.A07(1768715124);
        if (A07 == null || A072 == null || A073 == null || A03(A07.A00) != 1835299937) {
            return null;
        }
        C07364v c07364v = A072.A00;
        c07364v.A0f(12);
        int A0C = c07364v.A0C();
        String[] strArr = new String[A0C];
        for (int i = 0; i < A0C; i++) {
            int A0C2 = c07364v.A0C();
            c07364v.A0g(4);
            strArr[i] = c07364v.A0W(A0C2 - 8);
        }
        C07364v c07364v2 = A073.A00;
        c07364v2.A0f(8);
        ArrayList arrayList = new ArrayList();
        while (c07364v2.A07() > 8) {
            int A09 = c07364v2.A09();
            int A0C3 = c07364v2.A0C();
            int A0C4 = c07364v2.A0C() - 1;
            if (A0C4 < 0 || A0C4 >= strArr.length) {
                AbstractC07214g.A07(A0M(178, 11, 68), A0M(359, 41, 107) + A0C4);
            } else {
                MdtaMetadataEntry A092 = JB.A09(c07364v2, A09 + A0C3, strArr[A0C4]);
                if (A092 != null) {
                    arrayList.add(A092);
                }
            }
            c07364v2.A0f(A09 + A0C3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1080Iw A0G(C07364v c07364v, int i) {
        c07364v.A0f(i + 8 + 4);
        c07364v.A0g(1);
        A02(c07364v);
        c07364v.A0g(2);
        int A0I = c07364v.A0I();
        if ((A0I & 128) != 0) {
            c07364v.A0g(2);
        }
        if ((A0I & 64) != 0) {
            c07364v.A0g(c07364v.A0I());
        }
        if ((A0I & 32) != 0) {
            c07364v.A0g(2);
        }
        c07364v.A0g(1);
        A02(c07364v);
        String A05 = C3J.A05(c07364v.A0I());
        if (A0M(947, 10, 17).equals(A05) || A0M(989, 13, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE).equals(A05) || A0M(1002, 16, 39).equals(A05)) {
            return new C1080Iw(A05, null, -1L, -1L);
        }
        c07364v.A0g(4);
        long A0Q = c07364v.A0Q();
        long A0Q2 = c07364v.A0Q();
        c07364v.A0g(1);
        int A022 = A02(c07364v);
        byte[] bArr = new byte[A022];
        c07364v.A0k(bArr, 0, A022);
        if (A0Q2 <= 0) {
            A0Q2 = -1;
        }
        if (A0Q <= 0) {
            A0Q = -1;
        }
        return new C1080Iw(A05, bArr, A0Q2, A0Q);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1083Iz A0I(C07364v c07364v) {
        long A0Q;
        c07364v.A0f(8);
        int A012 = AbstractC1078Iu.A01(c07364v.A0C());
        c07364v.A0g(A012 == 0 ? 8 : 16);
        int A0C = c07364v.A0C();
        c07364v.A0g(4);
        boolean z = true;
        int A09 = c07364v.A09();
        int i = A012 == 0 ? 4 : 8;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            if (c07364v.A0l()[A09 + i2] != -1) {
                z = false;
                break;
            }
            i2++;
        }
        if (z) {
            c07364v.A0g(i);
            A0Q = -9223372036854775807L;
        } else {
            A0Q = A012 == 0 ? c07364v.A0Q() : c07364v.A0R();
            if (A0Q == 0) {
                A0Q = -9223372036854775807L;
            }
        }
        c07364v.A0g(16);
        int A0C2 = c07364v.A0C();
        int A0C3 = c07364v.A0C();
        c07364v.A0g(4);
        int A0C4 = c07364v.A0C();
        int A0C5 = c07364v.A0C();
        return new C1083Iz(A0C, A0Q, (A0C2 == 0 && A0C3 == 65536 && A0C4 == (-65536) && A0C5 == 0) ? 90 : (A0C2 == 0 && A0C3 == (-65536) && A0C4 == 65536 && A0C5 == 0) ? 270 : (A0C2 == (-65536) && A0C3 == 0 && A0C4 == 0 && A0C5 == (-65536)) ? 180 : 0);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    public static JO A0J(C2252mE c2252mE, C2251mD c2251mD, long j, DrmInitData drmInitData, boolean z, boolean z2) throws C3K {
        int i;
        int i2;
        int i3;
        C2252mE A06;
        long j2 = j;
        C2252mE c2252mE2 = (C2252mE) AbstractC07133y.A01(c2252mE.A06(1835297121));
        int A012 = A01(A03(((C2251mD) AbstractC07133y.A01(c2252mE2.A07(1751411826))).A00));
        if (A012 == -1) {
            return null;
        }
        C1083Iz A0I = A0I(((C2251mD) AbstractC07133y.A01(c2252mE.A07(1953196132))).A00);
        if (j2 == -9223372036854775807L) {
            j2 = A0I.A02;
        }
        long A05 = A05(c2251mD.A00);
        long A0U = j2 == -9223372036854775807L ? -9223372036854775807L : C5C.A0U(j2, 1000000L, A05);
        C2252mE c2252mE3 = (C2252mE) AbstractC07133y.A01(((C2252mE) AbstractC07133y.A01(c2252mE2.A06(1835626086))).A06(1937007212));
        Pair<Long, String> A062 = A06(((C2251mD) AbstractC07133y.A01(c2252mE2.A07(1835296868))).A00);
        C2251mD A07 = c2252mE3.A07(1937011556);
        if (A07 == null) {
            throw C3K.A01(A0M(288, 63, 20), null);
        }
        C07364v c07364v = A07.A00;
        i = A0I.A00;
        i2 = A0I.A01;
        C1082Iy A0H = A0H(c07364v, i, i2, (String) A062.second, drmInitData, z2);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z && (A06 = c2252mE.A06(1701082227)) != null) {
            Pair<long[], long[]> A09 = A09(A06);
            String[] strArr = A01;
            if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "IbqpVMf9BLmnuF5BFBlg7Wi48qFbo4Yh";
            strArr2[4] = "amD11xiy90bj3UvdeHvItss5MLCDKaRi";
            if (A09 != null) {
                jArr = (long[]) A09.first;
                jArr2 = (long[]) A09.second;
            }
        }
        if (A0H.A02 == null) {
            return null;
        }
        i3 = A0I.A00;
        return new JO(i3, A012, ((Long) A062.first).longValue(), A05, A0U, A0H.A02, A0H.A01, A0H.A03, A0H.A00, jArr, jArr2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JP A0K(C07364v c07364v, int i, int i2, String str) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            c07364v.A0f(i3);
            int A0C = c07364v.A0C();
            if (c07364v.A0C() == 1952804451) {
                int A012 = AbstractC1078Iu.A01(c07364v.A0C());
                c07364v.A0g(1);
                int i4 = 0;
                int i5 = 0;
                if (A012 == 0) {
                    c07364v.A0g(1);
                } else {
                    int A0I = c07364v.A0I();
                    i4 = (A0I & 240) >> 4;
                    i5 = A0I & 15;
                }
                boolean z = c07364v.A0I() == 1;
                int A0I2 = c07364v.A0I();
                byte[] bArr = new byte[16];
                c07364v.A0k(bArr, 0, bArr.length);
                byte[] bArr2 = null;
                if (z && A0I2 == 0) {
                    int A0I3 = c07364v.A0I();
                    bArr2 = new byte[A0I3];
                    c07364v.A0k(bArr2, 0, A0I3);
                }
                return new JP(z, str, A0I2, bArr, i4, i5, bArr2);
            }
            i3 += A0C;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x0299, code lost:
    
        r1 = r1 + r19;
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x029e, code lost:
    
        if (r11 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x02a0, code lost:
    
        if (r25 <= 0) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02a6, code lost:
    
        if (r11.A0L() == 0) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0613, code lost:
    
        r11.A0C();
        r25 = r25 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x02a8, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02a9, code lost:
    
        if (r9 != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x02ab, code lost:
    
        if (r12 != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x02ad, code lost:
    
        if (r8 != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02af, code lost:
    
        if (r13 != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x02b1, code lost:
    
        if (r10 != 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02b3, code lost:
    
        if (r14 != false) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x060f, code lost:
    
        r0 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0342, code lost:
    
        r17 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02b5, code lost:
    
        r0 = r34;
        r8 = new java.lang.StringBuilder().append(A0M(207, 32, 24)).append(r0.A00).append(A0M(144, 34, 36)).append(r9).append(A0M(14, 35, 65)).append(r12).append(A0M(85, 26, 14)).append(r8).append(A0M(111, 33, 41)).append(r13).append(A0M(49, 36, 31)).append(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x032a, code lost:
    
        if (r14 != false) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x032c, code lost:
    
        r3 = A0M(0, 14, 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x0335, code lost:
    
        com.instagram.common.viewpoint.core.AbstractC07214g.A07(r16, r8.append(r3).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x05ef, code lost:
    
        if (com.instagram.common.viewpoint.core.J0.A01[5].charAt(23) == 'W') goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x05f1, code lost:
    
        r3 = A0M(0, 0, 93);
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x05fa, code lost:
    
        r6 = com.instagram.common.viewpoint.core.J0.A01;
        r6[7] = "aaylILcGBS6VDtnpev9y5b4BJZBYR2y3";
        r6[4] = "0XgNPN0ZQsO4pNqGOHtpLFxyHM4aJjFv";
        r3 = A0M(0, 0, 93);
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JR A0L(JO jo, C2252mE c2252mE, HK hk) throws C3K {
        InterfaceC1081Ix c2249mB;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        long j;
        JO jo2;
        long[] jArr3;
        int i;
        int[] iArr3;
        C2251mD A07 = c2252mE.A07(1937011578);
        if (A07 != null) {
            c2249mB = new C2250mC(A07, jo.A07);
        } else {
            C2251mD A072 = c2252mE.A07(1937013298);
            if (A072 == null) {
                throw C3K.A01(A0M(400, 42, 111), null);
            }
            c2249mB = new C2249mB(A072);
        }
        int A8v = c2249mB.A8v();
        String[] strArr = A01;
        if (strArr[7].charAt(30) != strArr[4].charAt(30)) {
            A01[5] = "VWWx1kGHZbX2q2PAsWKgJgHWMUDi0u3b";
            if (A8v == 0) {
                return new JR(jo, new long[0], new int[0], 0, new long[0], new int[0], 0L);
            }
            boolean z = false;
            C2251mD A073 = c2252mE.A07(1937007471);
            if (A073 == null) {
                z = true;
                A073 = (C2251mD) AbstractC07133y.A01(c2252mE.A07(1668232756));
            }
            C07364v c07364v = A073.A00;
            C07364v c07364v2 = ((C2251mD) AbstractC07133y.A01(c2252mE.A07(1937011555))).A00;
            C07364v c07364v3 = ((C2251mD) AbstractC07133y.A01(c2252mE.A07(1937011827))).A00;
            C2251mD A074 = c2252mE.A07(1937011571);
            C07364v c07364v4 = A074 != null ? A074.A00 : null;
            C2251mD A075 = c2252mE.A07(1668576371);
            C07364v c07364v5 = A075 != null ? A075.A00 : null;
            C1079Iv c1079Iv = new C1079Iv(c07364v2, c07364v, z);
            c07364v3.A0f(12);
            int A0L = c07364v3.A0L() - 1;
            int A0L2 = c07364v3.A0L();
            int A0L3 = c07364v3.A0L();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            if (c07364v5 != null) {
                c07364v5.A0f(12);
                i3 = c07364v5.A0L();
            }
            int i5 = -1;
            int i6 = 0;
            if (c07364v4 != null) {
                c07364v4.A0f(12);
                i6 = c07364v4.A0L();
                if (i6 > 0) {
                    i5 = c07364v4.A0L() - 1;
                } else {
                    c07364v4 = null;
                }
            }
            int A8A = c2249mB.A8A();
            String str = jo.A07.A0W;
            int i7 = 0;
            long j2 = 0;
            if (!(A8A != -1 && (A0M(967, 9, 94).equals(str) || A0M(897, 15, 77).equals(str) || A0M(882, 15, 96).equals(str)) && A0L == 0 && i3 == 0 && i6 == 0)) {
                jArr = new long[A8v];
                iArr = new int[A8v];
                jArr2 = new long[A8v];
                iArr2 = new int[A8v];
                long j3 = 0;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    String A0M = A0M(178, 11, 68);
                    if (i9 >= A8v) {
                        i9 = A8v;
                        break;
                    }
                    boolean z2 = true;
                    while (i8 == 0) {
                        z2 = c1079Iv.A02();
                        if (!z2) {
                            break;
                        }
                        if (A01[5].charAt(23) != 'W') {
                            throw new RuntimeException();
                        }
                        A01[5] = "M5jbBIfsv36G8eW66Ax72viWGVpCEb4z";
                        j3 = c1079Iv.A02;
                        i8 = c1079Iv.A01;
                    }
                    if (!z2) {
                        AbstractC07214g.A07(A0M, A0M(442, 28, 94));
                        jArr = Arrays.copyOf(jArr, i9);
                        iArr = Arrays.copyOf(iArr, i9);
                        jArr2 = Arrays.copyOf(jArr2, i9);
                        iArr2 = Arrays.copyOf(iArr2, i9);
                        break;
                    }
                    if (c07364v5 != null) {
                        while (i2 == 0 && i3 > 0) {
                            i2 = c07364v5.A0L();
                            i4 = c07364v5.A0C();
                            i3--;
                        }
                        i2--;
                    }
                    jArr[i9] = j3;
                    iArr[i9] = c2249mB.AHS();
                    if (iArr[i9] > i7) {
                        i7 = iArr[i9];
                    }
                    jArr2[i9] = j2 + i4;
                    iArr2[i9] = c07364v4 == null ? 1 : 0;
                    if (i9 == i5) {
                        iArr2[i9] = 1;
                        i6--;
                        if (i6 > 0) {
                            i5 = ((C07364v) AbstractC07133y.A01(c07364v4)).A0L() - 1;
                        }
                    }
                    j2 += A0L3;
                    A0L2--;
                    if (A0L2 == 0 && A0L > 0) {
                        A0L2 = c07364v3.A0L();
                        A0L3 = c07364v3.A0C();
                        A0L--;
                    }
                    j3 += iArr[i9];
                    i8--;
                    i9++;
                }
            } else {
                long[] jArr4 = new long[c1079Iv.A05];
                String[] strArr2 = A01;
                if (strArr2[1].charAt(26) != strArr2[6].charAt(26)) {
                    A01[2] = "it49YraTc1fDpxLwGLRBh0ec";
                    iArr3 = new int[c1079Iv.A05];
                } else {
                    String[] strArr3 = A01;
                    strArr3[0] = "cQxifTbk";
                    strArr3[3] = "kvbBtLxb";
                    iArr3 = new int[c1079Iv.A05];
                }
                while (c1079Iv.A02()) {
                    jArr4[c1079Iv.A00] = c1079Iv.A02;
                    iArr3[c1079Iv.A00] = c1079Iv.A01;
                }
                J3 A002 = J4.A00(A8A, jArr4, iArr3, A0L3);
                jArr = A002.A04;
                iArr = A002.A03;
                i7 = A002.A00;
                jArr2 = A002.A05;
                iArr2 = A002.A02;
                j = A002.A01;
                jo2 = jo;
            }
            long j4 = jo2.A06;
            if (A01[2].length() == 24) {
                String[] strArr4 = A01;
                strArr4[7] = "ipyvZTOv07cYtbuH1DKg84aCsuigBUI1";
                strArr4[4] = "ch7TyunNM6oXEfHdpbs8btnx2NdPJSj4";
                long A0U = C5C.A0U(j, 1000000L, j4);
                if (jo2.A08 == null) {
                    C5C.A13(jArr2, 1000000L, jo2.A06);
                    return new JR(jo, jArr, iArr, i7, jArr2, iArr2, A0U);
                }
                if (jo2.A08.length == 1 && jo2.A03 == 1 && jArr2.length >= 2) {
                    long j5 = ((long[]) AbstractC07133y.A01(jo2.A09))[0];
                    long A0U2 = j5 + C5C.A0U(jo2.A08[0], jo2.A06, jo2.A05);
                    jArr2 = jArr2;
                    if (A0V(jArr2, j, j5, A0U2)) {
                        long A0U3 = C5C.A0U(j5 - jArr2[0], jo2.A07.A0G, jo2.A06);
                        long A0U4 = C5C.A0U(j - A0U2, jo2.A07.A0G, jo2.A06);
                        if ((A0U3 != 0 || A0U4 != 0) && A0U3 <= 2147483647L && A0U4 <= 2147483647L) {
                            hk.A00 = (int) A0U3;
                            hk.A01 = (int) A0U4;
                            C5C.A13(jArr2, 1000000L, jo2.A06);
                            return new JR(jo, jArr, iArr, i7, jArr2, iArr2, C5C.A0U(jo2.A08[0], 1000000L, jo2.A05));
                        }
                    }
                }
                if (jo2.A08.length == 1 && jo2.A08[0] == 0) {
                    long j6 = ((long[]) AbstractC07133y.A01(jo2.A09))[0];
                    for (int i10 = 0; i10 < jArr2.length; i10++) {
                        jArr2[i10] = C5C.A0U(jArr2[i10] - j6, 1000000L, jo2.A06);
                    }
                    return new JR(jo, jArr, iArr, i7, jArr2, iArr2, C5C.A0U(j - j6, 1000000L, jo2.A06));
                }
                boolean z3 = jo2.A03 == 1;
                int i11 = 0;
                int i12 = 0;
                boolean z4 = false;
                int[] iArr4 = new int[jo2.A08.length];
                int[] iArr5 = new int[jo2.A08.length];
                long[] jArr5 = jo2.A09;
                if (A01[5].charAt(23) != 'W') {
                    jArr3 = (long[]) AbstractC07133y.A01(jArr5);
                    i = 0;
                } else {
                    String[] strArr5 = A01;
                    strArr5[0] = "YPXXFbwg";
                    strArr5[3] = "nX0rcUWc";
                    jArr3 = (long[]) AbstractC07133y.A01(jArr5);
                    i = 0;
                }
                while (true) {
                    if (i < jo2.A08.length) {
                        long j7 = jArr3[i];
                        if (j7 != -1) {
                            long A0U5 = C5C.A0U(jo2.A08[i], jo2.A06, jo2.A05);
                            iArr4[i] = C5C.A0L(jArr2, j7, true, true);
                            iArr5[i] = C5C.A0K(jArr2, j7 + A0U5, z3, false);
                            while (iArr4[i] < iArr5[i] && (iArr2[iArr4[i]] & 1) == 0) {
                                iArr4[i] = iArr4[i] + 1;
                            }
                            i11 += iArr5[i] - iArr4[i];
                            String[] strArr6 = A01;
                            if (strArr6[1].charAt(26) == strArr6[6].charAt(26)) {
                                break;
                            }
                            String[] strArr7 = A01;
                            strArr7[0] = "N8MUiUXq";
                            strArr7[3] = "O0bSFd8k";
                            z4 |= i12 != iArr4[i];
                            i12 = iArr5[i];
                        }
                        i++;
                    } else {
                        boolean z5 = z4 | (i11 != A8v);
                        long[] jArr6 = z5 ? new long[i11] : jArr;
                        int[] iArr6 = z5 ? new int[i11] : iArr;
                        if (z5) {
                            i7 = 0;
                        }
                        String[] strArr8 = A01;
                        if (strArr8[7].charAt(30) != strArr8[4].charAt(30)) {
                            A01[5] = "xPfk6NQdScK777382m5CuwBWtM3rjqH6";
                            int[] iArr7 = z5 ? new int[i11] : iArr2;
                            long[] jArr7 = new long[i11];
                            long j8 = 0;
                            int i13 = 0;
                            for (int i14 = 0; i14 < jo2.A08.length; i14++) {
                                long j9 = jo2.A09[i14];
                                int i15 = iArr4[i14];
                                int i16 = iArr5[i14];
                                if (z5) {
                                    int i17 = i16 - i15;
                                    System.arraycopy(jArr, i15, jArr6, i13, i17);
                                    System.arraycopy(iArr, i15, iArr6, i13, i17);
                                    System.arraycopy(iArr2, i15, iArr7, i13, i17);
                                } else if (A01[5].charAt(23) != 'W') {
                                    A01[2] = "bpFLG5yiCjaNBTatiJL832yJ";
                                } else {
                                    String[] strArr9 = A01;
                                    strArr9[0] = "uU6cy1oD";
                                    strArr9[3] = "C1luViVj";
                                }
                                while (i15 < i16) {
                                    jArr7[i13] = C5C.A0U(j8, 1000000L, jo2.A05) + C5C.A0U(Math.max(0L, jArr2[i15] - j9), 1000000L, jo2.A06);
                                    if (z5 && iArr6[i13] > i7) {
                                        i7 = iArr[i15];
                                    }
                                    i13++;
                                    i15++;
                                }
                                j8 += jo2.A08[i14];
                            }
                            return new JR(jo, jArr6, iArr6, i7, jArr7, iArr7, C5C.A0U(j8, 1000000L, jo2.A05));
                        }
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    public static String A0M(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(copyOfRange);
    }

    public static void A0P() {
        A00 = new byte[]{70, 74, 9, Ascii.RS, Ascii.RS, Ascii.EM, 74, 3, 4, Ascii.FS, Ascii.VT, 6, 3, Ascii.SO, Ascii.VT, 7, 85, 66, 74, 70, 78, 73, 78, 73, SignedBytes.MAX_POWER_OF_TWO, 116, 70, 74, 87, 75, 66, 84, 102, 83, 115, 78, 74, 66, 84, 83, 70, 74, 87, 99, 66, 75, 83, 70, 7, 85, 89, Ascii.VT, Ascii.FS, Ascii.DC4, Ascii.CAN, Ascii.DLE, Ascii.ETB, Ascii.DLE, Ascii.ETB, Ascii.RS, 42, Ascii.CAN, Ascii.DC4, 9, Ascii.NAK, Ascii.FS, 10, 56, Ascii.CR, 45, Ascii.DLE, Ascii.DC4, Ascii.FS, 10, Ascii.CR, Ascii.CAN, Ascii.DC4, 9, 54, Ascii.US, Ascii.US, 10, Ascii.FS, Ascii.CR, 89, 68, 72, Ascii.SUB, Ascii.CR, 5, 9, 1, 6, 1, 6, Ascii.SI, 59, 9, 5, Ascii.CAN, 4, Ascii.CR, Ascii.ESC, 33, 6, 43, 0, Ascii.GS, 6, 3, 72, 99, 111, Base64.padSymbol, 42, 34, 46, 38, 33, 38, 33, 40, Ascii.ESC, 38, 34, 42, 60, 59, 46, 34, 63, Ascii.VT, 42, 35, 59, 46, Ascii.FF, 39, 46, 33, 40, 42, 60, 111, 120, 98, 48, 39, 47, 35, 43, 44, 43, 44, 37, 17, 59, 44, 33, 42, 48, 45, 44, 43, 56, 35, 54, 43, 45, 44, 17, 35, 47, 50, 46, 39, 49, 98, 99, 86, 77, 79, 114, 67, 80, 81, 71, 80, 81, Ascii.RS, 35, 56, 62, 40, 40, 50, 45, 62, 123, 52, 57, 46, 4, 40, 50, 33, 62, 55, Ascii.DLE, Ascii.GS, 17, Ascii.DLE, Ascii.CR, Ascii.ETB, Ascii.CR, 10, Ascii.ESC, Ascii.DLE, 10, 94, Ascii.CR, 10, Ascii.FS, Ascii.DC2, 94, Ascii.FS, 17, 6, 94, Ascii.CAN, 17, Ascii.FF, 94, 10, Ascii.FF, Ascii.US, Ascii.GS, Ascii.NAK, 94, 8, 47, 55, 32, 45, 40, 37, 97, 50, 32, 44, 49, 45, 36, 97, 51, 32, 53, 36, 97, 39, 46, 51, 97, 5, 46, 45, 35, 56, 97, Ascii.NAK, 51, 52, 36, 9, 5, 97, Ascii.FF, Ascii.CR, 17, 97, 50, 53, 51, 36, 32, 44, 123, 97, 63, 19, Ascii.RS, Ascii.DC4, Ascii.GS, 0, Ascii.US, Ascii.ETB, Ascii.SYN, 82, 1, 19, Ascii.US, 2, Ascii.RS, Ascii.ETB, 82, 6, 19, Ascii.DLE, Ascii.RS, Ascii.ETB, 82, 90, 1, 6, Ascii.DLE, Ascii.RS, 91, 82, Ascii.US, Ascii.ESC, 1, 1, Ascii.ESC, Ascii.FS, Ascii.NAK, 82, 1, 19, Ascii.US, 2, Ascii.RS, Ascii.ETB, 82, Ascii.SYN, Ascii.ETB, 1, 17, 0, Ascii.ESC, 2, 6, Ascii.ESC, Ascii.GS, Ascii.FS, 82, 90, 1, 6, 1, Ascii.SYN, 91, 33, Ascii.RS, Ascii.ESC, Ascii.GS, 38, Ascii.VT, Ascii.SI, 10, 94, 102, 100, 125, 125, 104, 105, 45, 96, 104, 121, 108, 105, 108, 121, 108, 45, 122, 100, 121, 101, 45, 120, 99, 102, 99, 98, 122, 99, 45, 102, 104, 116, 45, 100, 99, 105, 104, 117, 55, 45, 93, 123, 104, 106, 98, 41, 97, 104, 122, 41, 103, 102, 41, 122, 104, 100, 121, 101, 108, 41, 125, 104, 107, 101, 108, 41, 122, 96, 115, 108, 41, 96, 103, 111, 102, 123, 100, 104, 125, 96, 102, 103, 109, 86, 93, SignedBytes.MAX_POWER_OF_TWO, 72, 93, 91, 76, 93, 92, Ascii.CAN, 93, 86, 92, Ascii.CAN, 87, 94, Ascii.CAN, 91, 80, 77, 86, 83, Ascii.CAN, 92, 89, 76, 89, 90, 97, 124, 122, Byte.MAX_VALUE, Byte.MAX_VALUE, 96, 125, 123, 106, 107, 47, 108, 96, 99, 96, 125, 47, 123, 118, Byte.MAX_VALUE, 106, 53, 47, 72, 115, 110, 104, 109, 109, 114, 111, 105, 120, 121, Base64.padSymbol, 116, 115, 116, 105, 116, 124, 113, 66, 121, 116, 110, 109, 113, 124, 100, 66, 121, 120, 113, 124, 100, 66, 109, 111, 120, 110, 120, 115, 105, 66, 123, 113, 124, 122, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, Ascii.FS, 81, 89, 88, 85, 93, Ascii.FS, 78, 93, 72, 89, Ascii.DC2, Ascii.EM, 34, 63, 57, 60, 60, 35, 62, 56, 41, 40, 108, 35, 46, 57, 19, 41, 52, 56, 41, 34, 63, 37, 35, 34, 19, 42, 32, 45, 43, 100, 95, 66, 68, 65, 65, 94, 67, 69, 84, 85, 17, 94, 83, 68, 110, 69, 72, 65, 84, Ascii.VT, 17, 83, 104, 117, 115, 118, 118, 105, 116, 114, 99, 98, 38, 116, 99, 98, 115, 101, 99, 98, 89, 117, 114, 111, 106, 106, 89, 118, 111, 101, 114, 115, 116, 99, 89, 110, 99, 103, 98, 99, 116, 52, Ascii.SI, Ascii.DC2, Ascii.DC4, 17, 17, Ascii.SO, 19, Ascii.NAK, 4, 5, 65, Ascii.NAK, 8, Ascii.FF, 8, Ascii.SI, 6, 62, 8, Ascii.SI, 7, Ascii.SO, 62, 17, 19, 4, Ascii.DC2, 4, Ascii.SI, Ascii.NAK, 62, 7, Ascii.CR, 0, 6, 96, 113, 113, 109, 104, 98, 96, 117, 104, 110, 111, 46, 117, 117, 108, 109, 42, 121, 108, 109, 33, 48, 48, 44, 41, 35, 33, 52, 41, 47, 46, 111, 56, 109, 35, 33, 45, 37, 50, 33, 109, 45, 47, 52, 41, 47, 46, 78, 95, 95, 67, 70, 76, 78, 91, 70, SignedBytes.MAX_POWER_OF_TWO, 65, 0, 87, 2, 66, 95, Ascii.ESC, 2, 76, 74, 78, 2, Ascii.EM, Ascii.US, Ascii.ETB, 95, 78, 78, 82, 87, 93, 95, 74, 87, 81, 80, 17, 70, 19, 83, 78, 10, 19, 72, 74, 74, Base64.padSymbol, 44, 44, 48, 53, 63, Base64.padSymbol, 40, 53, 51, 50, 115, 36, 113, 45, 41, 53, 63, 55, 40, 53, 49, 57, 113, 40, 36, 111, 59, 80, 68, 85, 88, 94, Ascii.RS, 2, 86, 65, 65, 58, 46, 63, 50, 52, 116, 58, 56, 104, 42, 62, 47, 34, 36, 100, 42, 40, Byte.MAX_VALUE, 46, 58, 43, 38, 32, 96, 46, 35, 46, 44, 34, 54, 39, 42, 44, 108, 34, 46, 49, 110, 52, 33, 77, 89, 72, 69, 67, 3, 73, 77, 79, Ascii.US, 3, Ascii.ETB, 6, Ascii.VT, Ascii.CR, 77, 4, Ascii.SO, 3, 1, 103, 115, 98, 111, 105, 41, 97, 49, 55, 55, 43, 103, 106, 103, 113, 74, 94, 79, 66, 68, 4, 76, Ascii.FS, Ascii.SUB, Ascii.SUB, 6, 70, 71, 74, 92, 34, 54, 39, 42, 44, 108, 46, 43, 34, 114, Ascii.ETB, 3, Ascii.DC2, Ascii.US, Ascii.EM, 89, Ascii.ESC, Ascii.RS, Ascii.ESC, 71, 96, 116, 101, 104, 110, 46, 108, 113, 53, 96, 44, 109, 96, 117, 108, Ascii.SYN, 2, 19, Ascii.RS, Ascii.CAN, 88, Ascii.SUB, 7, Ascii.DC2, Ascii.DLE, 68, 80, 65, 76, 74, 10, 74, 85, 80, 86, 89, 77, 92, 81, 87, Ascii.ETB, 74, 89, 79, 74, 94, 79, 66, 68, 4, 95, 89, 94, 78, 6, 67, 79, 114, 102, 119, 122, 124, 60, 101, 125, 119, Base64.padSymbol, 119, 
        103, 96, 32, 52, 37, 40, 46, 110, 55, 47, 37, 111, 37, 53, 50, 111, 41, 37, 68, 80, 65, 76, 74, 10, 83, 75, 65, Ascii.VT, 65, 81, 86, Ascii.VT, 77, 65, Ascii.RS, 85, 87, 74, 67, 76, 73, SignedBytes.MAX_POWER_OF_TWO, Ascii.CAN, 73, 71, 87, 88, 76, 93, 80, 86, Ascii.SYN, 79, 87, 93, Ascii.ETB, 93, 77, 74, Ascii.ETB, 76, 81, 93, 2, 73, 75, 86, 95, 80, 85, 92, 4, 73, Ascii.VT, 54, 55, 54, 100, 87, 86, 87, 71, 79, 73, 66, 79, 50, 52, 63, 34, 74, 65, SignedBytes.MAX_POWER_OF_TWO, 69, 77, 104, 93, 70, 68, 122, SignedBytes.MAX_POWER_OF_TWO, 83, 76, 9, 68, 92, 90, 93, 9, 75, 76, 9, 89, 70, 90, SignedBytes.MAX_POWER_OF_TWO, 93, SignedBytes.MAX_POWER_OF_TWO, 95, 76, 49, 37, 58, 54, 119, 54, 35, 56, 58, 119, 62, 36, 119, 58, 54, 57, 51, 54, 35, 56, 37, 46, 59, 43, 32, 33, 104, 41, 60, 39, 37, 104, 33, 59, 104, 37, 41, 38, 44, 41, 60, 39, 58, 49, Ascii.SI, Ascii.RS, Ascii.NAK, Ascii.CAN, 91, Ascii.SUB, Ascii.SI, Ascii.DC4, Ascii.SYN, 91, Ascii.DC2, 8, 91, Ascii.SYN, Ascii.SUB, Ascii.NAK, Ascii.US, Ascii.SUB, Ascii.SI, Ascii.DC4, 9, 2, 5, Ascii.SUB, Ascii.ETB, Ascii.SYN, Ascii.FS, 92, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 3, 3, 67, 92, 81, 80, 90, Ascii.SUB, 84, 67, 5, 4, 35, 60, 49, 48, 58, 122, 52, 35, 54, 72, 87, 90, 91, 81, 17, 90, 81, 82, 92, 71, 19, 72, 87, 77, 87, 81, 80, 68, 91, 86, 87, 93, Ascii.GS, 90, 87, 68, 81, Ascii.SUB, 5, 8, 9, 3, 67, 1, Ascii.FS, 9, Ascii.VT, 95, SignedBytes.MAX_POWER_OF_TWO, 77, 76, 70, 6, 81, 4, 95, 71, 77, 7, 70, 71, Ascii.ESC, 7, 95, 89, 17, 3, Ascii.FS, 17, Ascii.DLE, Ascii.SUB, 90, Ascii.CR, 88, 3, Ascii.ESC, 17, 91, Ascii.SUB, Ascii.ESC, 71, 91, 3, 5, 76};
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02a6, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02ae, code lost:
    
        if (r2 != 1668050025) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02b0, code lost:
    
        if (r4 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02b2, code lost:
    
        r4 = A0N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02b6, code lost:
    
        r4.position(21);
        r4.putShort(r33.A0b());
        r4.putShort(r33.A0b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02d6, code lost:
    
        if (com.instagram.common.viewpoint.core.J0.A01[5].charAt(23) == 'W') goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02d8, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
        r2[7] = "cMBnz4dZXlFeWyM9hfqqzsh9zqwjLPKg";
        r2[4] = "lv8fWd8FNFrcw1jaRvaQVznvgsfH83Rg";
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02e6, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
        r2[0] = "x7EuuBNN";
        r2[3] = "05WogHTT";
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02f7, code lost:
    
        if (r2 != 1835295606) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02f9, code lost:
    
        if (r4 != null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02fb, code lost:
    
        r4 = A0N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02ff, code lost:
    
        r24 = r33.A0b();
        r23 = r33.A0b();
        r22 = r33.A0b();
        r21 = r33.A0b();
        r20 = r33.A0b();
        r19 = r33.A0b();
        r18 = r33.A0b();
        r16 = r33.A0b();
        r2 = r33.A0Q();
        r0 = r33.A0Q();
        r4.position(1);
        r4.putShort(r20);
        r4.putShort(r19);
        r4.putShort(r24);
        r4.putShort(r23);
        r4.putShort(r22);
        r4.putShort(r21);
        r4.putShort(r18);
        r4.putShort(r16);
        r4.putShort((short) (r2 / 10000));
        r4.putShort((short) (r0 / 10000));
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0368, code lost:
    
        if (r2 != 1681012275) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x036a, code lost:
    
        if (r6 != null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x036c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x036d, code lost:
    
        com.instagram.common.viewpoint.core.HB.A01(r1, null);
        r6 = A0M(1186, 10, 21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x037d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0382, code lost:
    
        if (r2 != 1702061171) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0384, code lost:
    
        if (r6 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0386, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0387, code lost:
    
        com.instagram.common.viewpoint.core.HB.A01(r2, null);
        r17 = A0G(r33, r1);
        r6 = r17.A02;
        r0 = r17.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0397, code lost:
    
        if (r0 == null) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0399, code lost:
    
        r12 = com.instagram.common.viewpoint.core.BP.A04(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x039f, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03a4, code lost:
    
        if (r2 != 1885434736) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03a6, code lost:
    
        r27 = A00(r33, r1);
        r30 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03b1, code lost:
    
        if (r2 != 1937126244) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x03b3, code lost:
    
        r26 = A0W(r33, r1, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x03bc, code lost:
    
        if (r2 != 1936995172) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x03be, code lost:
    
        r1 = r33.A0I();
        r33.A0g(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03c6, code lost:
    
        if (r1 != 0) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x03cc, code lost:
    
        switch(r33.A0I()) {
            case 0: goto L150;
            case 1: goto L149;
            case 2: goto L148;
            case 3: goto L147;
            default: goto L143;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x03e7, code lost:
    
        r11 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x03e9, code lost:
    
        r11 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03eb, code lost:
    
        r11 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03ed, code lost:
    
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03cf, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03df, code lost:
    
        if (r2[0].length() == r2[3].length()) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03ef, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
        r2[7] = "0aivzU98O0ZXtjwpHxuX2T7FoukhoekU";
        r2[4] = "nV94P8gaAxhOD3b386SRtcx64PXkWIfI";
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03e6, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0400, code lost:
    
        if (r2 != 1668246642) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0403, code lost:
    
        if (r8 != (-1)) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0405, code lost:
    
        if (r5 != (-1)) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0407, code lost:
    
        if (r7 != (-1)) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0409, code lost:
    
        r2 = r33.A0C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0410, code lost:
    
        if (r2 == 1852009592) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0415, code lost:
    
        if (r2 != 1852009571) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x043f, code lost:
    
        com.instagram.common.viewpoint.core.AbstractC07214g.A07(A0M(178, 11, 68), A0M(470, 24, 105) + com.instagram.common.viewpoint.core.AbstractC1078Iu.A02(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0417, code lost:
    
        r2 = r33.A0M();
        r1 = r33.A0M();
        r5 = 2;
        r33.A0g(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0425, code lost:
    
        if (r14 != 19) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x042d, code lost:
    
        if ((r33.A0I() & 128) == 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x042f, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0430, code lost:
    
        r8 = com.facebook.ads.androidx.media3.common.ColorInfo.A00(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0434, code lost:
    
        if (r0 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0436, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0437, code lost:
    
        r7 = com.facebook.ads.androidx.media3.common.ColorInfo.A01(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x043d, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x046b, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x047d, code lost:
    
        if (r2[7].charAt(30) == r2[4].charAt(30)) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x047f, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
        r2[0] = "ZXEhGysO";
        r2[3] = "dMfXFnuv";
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x048d, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
        r2[0] = "PjY9iWjn";
        r2[3] = "RXgmgrZF";
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x02a8, code lost:
    
        if (r2 != 1635135811) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x01f8, code lost:
    
        r0 = com.instagram.common.viewpoint.core.H6.A00(r33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x01fc, code lost:
    
        if (r0 == null) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x01fe, code lost:
    
        r13 = r0.A02;
        r6 = A0M(1215, 18, 88);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x01b3, code lost:
    
        if (r2 == 1635148611) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ad, code lost:
    
        if (r6 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
    
        r3 = new com.instagram.common.viewpoint.core.C06802p().A0g(r37).A11(r6).A0w(r13).A0r(r29).A0f(r28).A0Y(r27).A0l(r38).A13(r26).A0o(r11).A12(r12).A0u(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
    
        if (r8 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f2, code lost:
    
        if (r5 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f4, code lost:
    
        if (r7 != (-1)) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f6, code lost:
    
        if (r4 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0127, code lost:
    
        if (r17 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0129, code lost:
    
        r0 = r17.A00;
        r2 = r3.A0a(com.instagram.common.viewpoint.core.AbstractC0873As.A03(r0));
        r0 = r17.A01;
        r2.A0j(com.instagram.common.viewpoint.core.AbstractC0873As.A03(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0140, code lost:
    
        r40.A02 = r3.A14();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0148, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f9, code lost:
    
        if (r4 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fb, code lost:
    
        r4 = r4.array();
        r2 = com.instagram.common.viewpoint.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0111, code lost:
    
        if (r2[7].charAt(30) == r2[4].charAt(30)) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0113, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
        r2[1] = "iNSGYMD2WjZqNKpCGRiE11Ag0KcZMJ4O";
        r2[6] = "kUdBVFFCHZ7OFsLW60c88KXDOWnZQcPh";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x011f, code lost:
    
        r3.A0t(new com.facebook.ads.androidx.media3.common.ColorInfo(r8, r5, r7, r4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0149, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0171, code lost:
    
        if (r2 == 1635148611) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0173, code lost:
    
        if (r6 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0175, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0176, code lost:
    
        com.instagram.common.viewpoint.core.HB.A01(r2, null);
        r6 = A0M(com.ironsource.Hd.a.e, 9, 51);
        r33.A0f(r1 + 8);
        r2 = com.instagram.common.viewpoint.core.C1028Gv.A00(r33);
        r12 = r2.A05;
        r40.A00 = r2.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0195, code lost:
    
        if (r30 != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0197, code lost:
    
        r27 = r2.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x019b, code lost:
    
        r13 = r2.A04;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a0, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01b9, code lost:
    
        if (r2 != 1752589123) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01bb, code lost:
    
        if (r6 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01bd, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01be, code lost:
    
        com.instagram.common.viewpoint.core.HB.A01(r2, null);
        r6 = A0M(1233, 10, 84);
        r33.A0f(r1 + 8);
        r2 = com.instagram.common.viewpoint.core.HL.A00(r33);
        r12 = r2.A08;
        r40.A00 = r2.A05;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01dd, code lost:
    
        if (r30 != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01df, code lost:
    
        r27 = r2.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01e3, code lost:
    
        r13 = r2.A07;
        r8 = r2.A02;
        r5 = r2.A01;
        r7 = r2.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01ec, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f1, code lost:
    
        if (r2 == 1685480259) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f6, code lost:
    
        if (r2 != 1685485123) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x020e, code lost:
    
        if (r2 != 1987076931) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0210, code lost:
    
        if (r6 != null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0212, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0213, code lost:
    
        com.instagram.common.viewpoint.core.HB.A01(r2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x021c, code lost:
    
        if (r32 != 1987063864) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x021e, code lost:
    
        r6 = A0M(1253, 19, 79);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0228, code lost:
    
        r33.A0f(r1 + 12);
        r33.A0g(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0237, code lost:
    
        if ((r33.A0I() & 1) == 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0239, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x023a, code lost:
    
        r1 = r33.A0I();
        r0 = r33.A0I();
        r8 = com.facebook.ads.androidx.media3.common.ColorInfo.A00(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0246, code lost:
    
        if (r2 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0248, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0249, code lost:
    
        r7 = com.facebook.ads.androidx.media3.common.ColorInfo.A01(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x024f, code lost:
    
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0251, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0253, code lost:
    
        r6 = A0M(1272, 19, 19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x025e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0260, code lost:
    
        r16 = com.instagram.common.viewpoint.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0279, code lost:
    
        if (r16[7].charAt(30) == r16[4].charAt(30)) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x027b, code lost:
    
        com.instagram.common.viewpoint.core.J0.A01[5] = "obOtuNmXmw3Srs7TxB3R2veWOWOW6QJb";
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0282, code lost:
    
        if (r2 != 1635135811) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0284, code lost:
    
        if (r6 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0286, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0287, code lost:
    
        com.instagram.common.viewpoint.core.HB.A01(r2, null);
        r6 = A0M(1196, 10, 83);
        r33.A0f(r1 + 8);
        r0 = A0B(r33);
        r8 = r0.A02;
        r5 = r0.A01;
        r7 = r0.A03;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Adding Colorspace support for AV1")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0R(C07364v c07364v, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, C1082Iy c1082Iy, int i6) throws C3K {
        int A0C;
        DrmInitData drmInitData2 = drmInitData;
        int i7 = i;
        c07364v.A0f(i2 + 8 + 8);
        c07364v.A0g(16);
        int A0M = c07364v.A0M();
        int A0M2 = c07364v.A0M();
        boolean z = false;
        float f = 1.0f;
        c07364v.A0g(50);
        int A09 = c07364v.A09();
        if (i7 == 1701733238) {
            Pair<Integer, JP> A08 = A08(c07364v, i2, i3);
            if (A08 != null) {
                i7 = ((Integer) A08.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.A01(((JP) A08.second).A02);
                c1082Iy.A03[i6] = (JP) A08.second;
            }
            c07364v.A0f(A09);
        }
        String str = null;
        if (i7 == 1831958048) {
            str = A0M(1243, 10, 10);
        } else if (i7 == 1211250227) {
            str = A0M(1186, 10, 21);
        }
        List<byte[]> list = null;
        String str2 = null;
        byte[] bArr = null;
        int i8 = -1;
        C1080Iw c1080Iw = null;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        ByteBuffer byteBuffer = null;
        while (true) {
            int i12 = A09 - i2;
            if (A01[5].charAt(23) == 'W') {
                A01[5] = "UV8763Z4eJ1eqclMrzFGVnLWDHgV5Y7v";
                if (i12 < i3) {
                    c07364v.A0f(A09);
                    int A092 = c07364v.A09();
                    int A0C2 = c07364v.A0C();
                    if (A0C2 != 0 || c07364v.A09() - i2 != i3) {
                        boolean z2 = A0C2 > 0;
                        String A0M3 = A0M(1090, 30, 79);
                        if (A01[5].charAt(23) != 'W') {
                            HB.A01(z2, A0M3);
                            A0C = c07364v.A0C();
                        } else {
                            A01[2] = "a7F234D58gsc4SWrdwKeU3Lp";
                            HB.A01(z2, A0M3);
                            A0C = c07364v.A0C();
                        }
                        A09 += A0C2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0200, code lost:
    
        if (r0 == 1684892784) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x034e, code lost:
    
        if (r3 != 1685353320) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0353, code lost:
    
        if (r3 != 1685353324) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0373, code lost:
    
        if (r3 != 1685353317) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0375, code lost:
    
        r7 = A0M(1018, 28, 67);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0384, code lost:
    
        if (r3 != 1685353336) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0386, code lost:
    
        r7 = A0M(1046, 28, 95);
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0392, code lost:
    
        r6 = com.instagram.common.viewpoint.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03a5, code lost:
    
        if (r6[0].length() == r6[3].length()) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03a7, code lost:
    
        r6 = com.instagram.common.viewpoint.core.J0.A01;
        r6[0] = "UBbPjz2J";
        r6[3] = "vZen3GMl";
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03b3, code lost:
    
        if (r3 != 1935764850) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03b5, code lost:
    
        r7 = A0M(812, 10, 87);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03ce, code lost:
    
        if (r3 != 1935767394) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03d0, code lost:
    
        r7 = A0M(850, 12, 37);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x03df, code lost:
    
        if (r3 == 1819304813) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x03e4, code lost:
    
        if (r3 != 1936684916) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03f6, code lost:
    
        if (r3 != 1953984371) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03f8, code lost:
    
        r7 = A0M(967, 9, 94);
        r10 = 268435456;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0409, code lost:
    
        if (r3 == 778924082) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x040e, code lost:
    
        if (r3 != 778924083) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x041f, code lost:
    
        if (r3 != 1835557169) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0421, code lost:
    
        r7 = A0M(912, 10, 37);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0430, code lost:
    
        if (r3 != 1835560241) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0432, code lost:
    
        r7 = A0M(922, 10, 16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x043e, code lost:
    
        if (r3 != 1634492771) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x044d, code lost:
    
        if (com.instagram.common.viewpoint.core.J0.A01[2].length() == 24) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x044f, code lost:
    
        r3 = com.instagram.common.viewpoint.core.J0.A01;
        r3[7] = "Tx0aPYhLQcdbhycZDJ63DJlxAHLYnZiL";
        r3[4] = "3h5vNAL3r5q44mC2VqL1y1SAaDe1rbn7";
        r7 = A0M(840, 1, 31);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0464, code lost:
    
        com.instagram.common.viewpoint.core.J0.A01[5] = "qx3Rs2jX7JB6Nuy9TisbRByWp1zn9Qj8";
        r7 = A0M(840, 10, 41);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0478, code lost:
    
        if (r3 != 1634492791) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x047a, code lost:
    
        r7 = A0M(882, 15, 96);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0489, code lost:
    
        if (r3 != 1970037111) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x048b, code lost:
    
        r7 = A0M(897, 15, 77);
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x049a, code lost:
    
        if (r3 != 1332770163) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x049c, code lost:
    
        r7 = A0M(957, 10, 67);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x04ab, code lost:
    
        if (r3 != 1716281667) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x04ad, code lost:
    
        r7 = A0M(872, 10, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04bb, code lost:
    
        if (r3 != 1835823201) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04bd, code lost:
    
        r7 = A0M(976, 13, 77);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0410, code lost:
    
        r7 = A0M(947, 10, 17);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x03e6, code lost:
    
        r7 = A0M(967, 9, 94);
        r10 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x03c1, code lost:
    
        com.instagram.common.viewpoint.core.J0.A01[2] = "gBDk9Jrqoo24V0L1mHSTaoLt";
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x03c8, code lost:
    
        if (r3 != 1935764850) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0355, code lost:
    
        r7 = A0M(1002, 16, 39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x036d, code lost:
    
        if (r3 != 1685353320) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0148, code lost:
    
        if (r0 == 2002876005) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0190, code lost:
    
        if (r0 == 2002876005) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01f7, code lost:
    
        if (r0 == 1684892784) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f9, code lost:
    
        if (r18 <= 0) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01fb, code lost:
    
        r12 = 2;
        r9 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x055a, code lost:
    
        throw com.instagram.common.viewpoint.core.C3K.A01(A0M(239, 49, 39) + r18, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0206, code lost:
    
        if (r0 == 1684305011) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x020b, code lost:
    
        if (r0 != 1969517683) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0237, code lost:
    
        if (r0 != 1682927731) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0239, code lost:
    
        r3 = r5 - 8;
        r1 = java.util.Arrays.copyOf(com.instagram.common.viewpoint.core.J0.A02, com.instagram.common.viewpoint.core.J0.A02.length + r3);
        r19.A0f(r8 + 8);
        r19.A0k(r1, com.instagram.common.viewpoint.core.J0.A02.length, r3);
        r6 = com.instagram.common.viewpoint.core.HT.A06(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0259, code lost:
    
        if (r0 != 1684425825) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x025b, code lost:
    
        r3 = r5 - 12;
        r1 = new byte[r3 + 4];
        r1[0] = 102;
        r1[1] = 76;
        r1[2] = 97;
        r1[3] = 67;
        r19.A0f(r8 + 12);
        r19.A0k(r1, 4, r3);
        r6 = com.instagram.common.viewpoint.core.BP.A04(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0287, code lost:
    
        if (r0 != 1634492771) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0289, code lost:
    
        r3 = r5 - 12;
        r1 = new byte[r3];
        r19.A0f(r8 + 12);
        r19.A0k(r1, 0, r3);
        r3 = com.instagram.common.viewpoint.core.AnonymousClass46.A00(r1);
        r9 = ((java.lang.Integer) r3.first).intValue();
        r12 = ((java.lang.Integer) r3.second).intValue();
        r6 = com.instagram.common.viewpoint.core.BP.A04(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x020d, code lost:
    
        r27.A02 = new com.instagram.common.viewpoint.core.C06802p().A0g(r23).A11(r7).A0b(r12).A0m(r9).A0u(r2).A10(r24).A14();
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0T(C07364v c07364v, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, C1082Iy c1082Iy, int i5) throws C3K {
        int A0M;
        int A0J;
        long j;
        long j2;
        byte[] bArr;
        int i6 = i;
        DrmInitData drmInitData2 = drmInitData;
        c07364v.A0f(i2 + 8 + 8);
        int i7 = 0;
        if (z) {
            i7 = c07364v.A0M();
            c07364v.A0g(6);
        } else {
            c07364v.A0g(8);
        }
        int i8 = 0;
        int i9 = -1;
        String str2 = null;
        C1080Iw c1080Iw = null;
        if (A01[2].length() == 24) {
            String[] strArr = A01;
            strArr[0] = "6JAwliLs";
            strArr[3] = "MHNM5nZH";
            if (i7 == 0 || i7 == 1) {
                A0M = c07364v.A0M();
                c07364v.A0g(6);
                A0J = c07364v.A0J();
                c07364v.A0f(c07364v.A09() - 4);
                i8 = c07364v.A0C();
                if (i7 == 1) {
                    c07364v.A0g(16);
                }
            } else {
                if (i7 != 2) {
                    return;
                }
                c07364v.A0g(16);
                A0J = (int) Math.round(c07364v.A06());
                A0M = c07364v.A0L();
                c07364v.A0g(20);
            }
            int A09 = c07364v.A09();
            if (i6 == 1701733217) {
                Pair<Integer, JP> A08 = A08(c07364v, i2, i3);
                if (A08 != null) {
                    i6 = ((Integer) A08.first).intValue();
                    if (drmInitData2 != null) {
                        drmInitData2 = drmInitData2.A01(((JP) A08.second).A02);
                    } else if (A01[2].length() != 24) {
                        drmInitData2 = null;
                    } else {
                        String[] strArr2 = A01;
                        strArr2[0] = "GRTMmxkT";
                        strArr2[3] = "8R10f2wp";
                        drmInitData2 = null;
                    }
                    JP[] jpArr = c1082Iy.A03;
                    JP jp = (JP) A08.second;
                    String[] strArr3 = A01;
                    if (strArr3[1].charAt(26) != strArr3[6].charAt(26)) {
                        String[] strArr4 = A01;
                        strArr4[7] = "lvh8KGFHktoLjastkJ82cPetj14Rk4EU";
                        strArr4[4] = "lCZg4scnRLhDwR3AaCs1YjGUJehF9RDz";
                        jpArr[i5] = jp;
                    } else {
                        String[] strArr5 = A01;
                        strArr5[0] = "dju2geGd";
                        strArr5[3] = "bzT2ebja";
                        jpArr[i5] = jp;
                    }
                } else {
                    String[] strArr6 = A01;
                    if (strArr6[0].length() != strArr6[3].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr7 = A01;
                    strArr7[7] = "gPFMLbY3dC1lU3feUmGywMAQlXFn4oyw";
                    strArr7[4] = "p7gqQJ524nkvgJLmUWGAgmNX9hqHunnJ";
                }
                c07364v.A0f(A09);
            }
            String str3 = null;
            if (i6 == 1633889587) {
                str3 = A0M(822, 9, 61);
            } else if (i6 == 1700998451) {
                str3 = A0M(862, 10, 74);
            } else if (i6 == 1633889588) {
                String[] strArr8 = A01;
                if (strArr8[7].charAt(30) != strArr8[4].charAt(30)) {
                    String[] strArr9 = A01;
                    strArr9[0] = "ajRR6yPd";
                    strArr9[3] = "wapOpR6f";
                    str3 = A0M(831, 9, 45);
                } else {
                    str3 = A0M(831, 9, 45);
                }
            } else if (i6 == 1685353315) {
                String[] strArr10 = A01;
                if (strArr10[1].charAt(26) != strArr10[6].charAt(26)) {
                    A01[2] = "KJpCB4t3K52AuUO24XLWBqo9";
                    str3 = A0M(989, 13, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE);
                }
            } else {
                String[] strArr11 = A01;
                if (strArr11[7].charAt(30) != strArr11[4].charAt(30)) {
                    String[] strArr12 = A01;
                    strArr12[1] = "E8vPAuGqR2xNMC3W8Z6piDguEQA0iYD6";
                    strArr12[6] = "JqGyLM9U6ZTAdL5rS6oZcwJBCNvZXK39";
                } else {
                    String[] strArr13 = A01;
                    strArr13[0] = "jXw0aAnX";
                    strArr13[3] = "tHH1zIUY";
                }
            }
            List<byte[]> list = null;
            while (A09 - i2 < i3) {
                c07364v.A0f(A09);
                int A0C = c07364v.A0C();
                boolean z2 = A0C > 0;
                String A0M2 = A0M(1090, 30, 79);
                String[] strArr14 = A01;
                if (strArr14[7].charAt(30) != strArr14[4].charAt(30)) {
                    A01[2] = "1WqyRoRGMALZfYpxNfh8k5AQ";
                    HB.A01(z2, A0M2);
                    int A0C2 = c07364v.A0C();
                    if (A0C2 == 1835557187) {
                        int i10 = A0C - 13;
                        byte[] bArr2 = new byte[i10];
                        c07364v.A0f(13 + A09);
                        c07364v.A0k(bArr2, 0, i10);
                        list = BP.A04(bArr2);
                    } else {
                        if (A0C2 != 1702061171) {
                            if (z) {
                                if (A01[5].charAt(23) == 'W') {
                                    String[] strArr15 = A01;
                                    strArr15[0] = "uRIbW45A";
                                    strArr15[3] = "EDIb1o31";
                                }
                            }
                            if (A0C2 == 1684103987) {
                                c07364v.A0f(A09 + 8);
                                c1082Iy.A02 = AbstractC1024Gr.A07(c07364v, Integer.toString(i4), str, drmInitData2);
                            } else if (A0C2 == 1684366131) {
                                c07364v.A0f(A09 + 8);
                                c1082Iy.A02 = AbstractC1024Gr.A08(c07364v, Integer.toString(i4), str, drmInitData2);
                            } else if (A0C2 == 1684103988) {
                                c07364v.A0f(A09 + 8);
                                c1082Iy.A02 = AbstractC1027Gu.A03(c07364v, Integer.toString(i4), str, drmInitData2);
                            } else {
                                String[] strArr16 = A01;
                                if (strArr16[7].charAt(30) != strArr16[4].charAt(30)) {
                                    String[] strArr17 = A01;
                                    strArr17[7] = "XWUeG0Lj6KL9JW7Z7jfQ0rtemNqiryGw";
                                    strArr17[4] = "DGFAmtAGFYrNnmS6p9Hy3BCjcLzUjlt2";
                                }
                            }
                        }
                        int A04 = A0C2 == 1702061171 ? A09 : A04(c07364v, 1702061171, A09, A0C);
                        if (A04 != -1) {
                            c1080Iw = A0G(c07364v, A04);
                            str3 = c1080Iw.A02;
                            bArr = c1080Iw.A03;
                            if (bArr != null) {
                                if (A0M(932, 15, 103).equals(str3)) {
                                    C1019Gm A032 = AbstractC1020Gn.A03(bArr);
                                    A0J = A032.A01;
                                    A0M = A032.A00;
                                    str2 = A032.A02;
                                }
                                list = BP.A04(bArr);
                            }
                        }
                    }
                    A09 += A0C;
                }
            }
            if (c1082Iy.A02 != null || str3 == null) {
                return;
            }
            C06802p A10 = new C06802p().A0g(i4).A11(str3).A0w(str2).A0b(A0M).A0m(A0J).A0i(i9).A12(list).A0u(drmInitData2).A10(str);
            if (c1080Iw != null) {
                j = c1080Iw.A00;
                C06802p A0a = A10.A0a(AbstractC0873As.A03(j));
                j2 = c1080Iw.A01;
                A0a.A0j(AbstractC0873As.A03(j2));
            }
            c1082Iy.A02 = A10.A14();
            return;
        }
        throw new RuntimeException();
    }

    static {
        A0P();
        A03 = new int[]{-3374493, -128628077, -2011932550, 38936541};
        A02 = C5C.A1G(A0M(351, 8, 8));
    }

    public static float A00(C07364v c07364v, int i) {
        c07364v.A0f(i + 8);
        int vSpacing = c07364v.A0L();
        int hSpacing = c07364v.A0L();
        return vSpacing / hSpacing;
    }

    public static int A01(int i) {
        if (i == 1936684398) {
            return 1;
        }
        if (i == 1986618469) {
            return 2;
        }
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "Iy7m3jJh";
        strArr2[3] = "9tkcHcc8";
        if (i == 1952807028 || i == 1935832172 || i == 1937072756 || i == 1668047728) {
            return 3;
        }
        if (i == 1835365473) {
            return 5;
        }
        return -1;
    }

    public static int A02(C07364v c07364v) {
        int A0I = c07364v.A0I();
        int i = A0I & 127;
        while (true) {
            int i2 = A0I & 128;
            String[] strArr = A01;
            String str = strArr[7];
            String str2 = strArr[4];
            int size = str.charAt(30);
            int currentByte = str2.charAt(30);
            if (size == currentByte) {
                throw new RuntimeException();
            }
            A01[5] = "pSNibJ1kKp1RE21akOqiyNuWX3n84SWQ";
            if (i2 == 128) {
                A0I = c07364v.A0I();
                int i3 = i << 7;
                String[] strArr2 = A01;
                String str3 = strArr2[0];
                String str4 = strArr2[3];
                int size2 = str3.length();
                int currentByte2 = str4.length();
                if (size2 != currentByte2) {
                    String[] strArr3 = A01;
                    strArr3[0] = "dUXzi2Ex";
                    strArr3[3] = "FqHw8aws";
                    int currentByte3 = A0I & 127;
                    i = i3 | currentByte3;
                } else {
                    A01[2] = "53iEjHDa99dBpQfClHLnj3Lr";
                    int currentByte4 = A0I & 127;
                    i = i3 | currentByte4;
                }
            } else {
                return i;
            }
        }
    }

    public static int A03(C07364v c07364v) {
        c07364v.A0f(16);
        return c07364v.A0C();
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A04(C07364v c07364v, int i, int i2, int i3) throws C3K {
        int childAtomSize = c07364v.A09();
        HB.A01(childAtomSize >= i2, null);
        while (childAtomPosition < i3) {
            c07364v.A0f(childAtomSize);
            int A0C = c07364v.A0C();
            boolean z = A0C > 0;
            if (A01[5].charAt(23) != 'W') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "6gtDIh58mAlo0zqgdjwPUqi1ndJRBK82";
            strArr[4] = "DRBAnAjKoyJp6qnYv3HHxzBKoLLYYD5q";
            HB.A01(z, A0M(1090, 30, 79));
            int childAtomPosition = c07364v.A0C();
            if (childAtomPosition == i) {
                return childAtomSize;
            }
            childAtomSize += A0C;
        }
        return -1;
    }

    public static long A05(C07364v c07364v) {
        int fullAtom = 8;
        c07364v.A0f(8);
        if (AbstractC1078Iu.A01(c07364v.A0C()) != 0) {
            fullAtom = 16;
        }
        c07364v.A0g(fullAtom);
        return c07364v.A0Q();
    }

    public static Pair<Long, String> A06(C07364v c07364v) {
        c07364v.A0f(8);
        int fullAtom = AbstractC1078Iu.A01(c07364v.A0C());
        int languageCode = fullAtom == 0 ? 8 : 16;
        c07364v.A0g(languageCode);
        long A0Q = c07364v.A0Q();
        int version = fullAtom == 0 ? 4 : 8;
        c07364v.A0g(version);
        int A0M = c07364v.A0M();
        int languageCode2 = A0M >> 10;
        StringBuilder append = new StringBuilder().append(A0M(0, 0, 93)).append((char) ((languageCode2 & 31) + 96));
        int languageCode3 = A0M >> 5;
        StringBuilder append2 = append.append((char) ((languageCode3 & 31) + 96));
        int languageCode4 = A0M & 31;
        return Pair.create(Long.valueOf(A0Q), append2.append((char) (languageCode4 + 96)).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002a, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, JP> A07(C07364v c07364v, int i, int i2) throws C3K {
        int i3 = i + 8;
        int childAtomType = -1;
        int childAtomSize = 0;
        String str = null;
        Integer num = null;
        while (true) {
            int childPosition = i3 - i;
            if (childPosition < i2) {
                c07364v.A0f(i3);
                int A0C = c07364v.A0C();
                int A0C2 = c07364v.A0C();
                int schemeInformationBoxPosition = A01[2].length();
                if (schemeInformationBoxPosition != 24) {
                    break;
                }
                String[] strArr = A01;
                strArr[0] = "312zVnav";
                strArr[3] = "fwhHyPzp";
                if (A0C2 == 1718775137) {
                    int childPosition2 = c07364v.A0C();
                    num = Integer.valueOf(childPosition2);
                } else if (A0C2 == 1935894637) {
                    c07364v.A0g(4);
                    str = c07364v.A0W(4);
                } else if (A0C2 == 1935894633) {
                    childAtomType = i3;
                    childAtomSize = A0C;
                }
                i3 += A0C;
            } else {
                int schemeInformationBoxPosition2 = A01[2].length();
                if (schemeInformationBoxPosition2 == 24) {
                    A01[5] = "Q2dt9svTwucQVjxlQtJloRQWafbIItZ7";
                    if (A0M(1082, 4, 74).equals(str) || A0M(1074, 4, 51).equals(str) || A0M(1086, 4, 55).equals(str) || A0M(1078, 4, 82).equals(str)) {
                        boolean z = true;
                        HB.A01(num != null, A0M(1120, 22, 49));
                        HB.A01(childAtomType != -1, A0M(1142, 22, 46));
                        JP A0K = A0K(c07364v, childAtomType, childAtomSize, str);
                        if (A0K == null) {
                            z = false;
                        }
                        HB.A01(z, A0M(e.a.j, 22, 29));
                        return Pair.create(num, (JP) C5C.A0f(A0K));
                    }
                    return null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0050, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (r0 > 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (r0 > 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, JP> A08(C07364v c07364v, int i, int i2) throws C3K {
        int childPosition;
        boolean z;
        Pair<Integer, JP> A07;
        int A09 = c07364v.A09();
        while (true) {
            int i3 = A09 - i;
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[3];
            int length = str.length();
            int childPosition2 = str2.length();
            if (length != childPosition2) {
                throw new RuntimeException();
            }
            A01[2] = "alPn9WvAmZr8sIghV9sZ4SJG";
            if (i3 < i2) {
                c07364v.A0f(A09);
                String[] strArr2 = A01;
                String str3 = strArr2[1];
                String str4 = strArr2[6];
                int charAt = str3.charAt(26);
                int childPosition3 = str4.charAt(26);
                if (charAt != childPosition3) {
                    String[] strArr3 = A01;
                    strArr3[0] = "bSC6gQO3";
                    strArr3[3] = "sEisHoVo";
                    childPosition = c07364v.A0C();
                } else {
                    String[] strArr4 = A01;
                    strArr4[1] = "sCQufaVXehZdAx160HDrkvqq2FYTSg6V";
                    strArr4[6] = "xgFgm7GbjtAXUGsxujgneuzUGgVoDuJS";
                    childPosition = c07364v.A0C();
                }
                HB.A01(z, A0M(1090, 30, 79));
                int childAtomType = c07364v.A0C();
                if (childAtomType == 1936289382 && (A07 = A07(c07364v, A09, childPosition)) != null) {
                    return A07;
                }
                A09 += childPosition;
            } else {
                return null;
            }
        }
    }

    public static Pair<long[], long[]> A09(C2252mE c2252mE) {
        long j;
        C2251mD elstAtom = c2252mE.A07(1701606260);
        if (elstAtom == null) {
            return null;
        }
        C07364v c07364v = elstAtom.A00;
        String[] strArr = A01;
        if (strArr[1].charAt(26) == strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "nlx0JEXKjNTNdSyjBy8qhdzuridSUNe7";
        strArr2[4] = "QPF9oPdHODxNb0EXvgymvar5stnTE0Tg";
        c07364v.A0f(8);
        int version = AbstractC1078Iu.A01(c07364v.A0C());
        int fullAtom = c07364v.A0L();
        long[] jArr = new long[fullAtom];
        long[] jArr2 = new long[fullAtom];
        for (int i = 0; i < fullAtom; i++) {
            jArr[i] = version == 1 ? c07364v.A0R() : c07364v.A0Q();
            if (version == 1) {
                j = c07364v.A0P();
            } else {
                int entryCount = c07364v.A0C();
                j = entryCount;
            }
            jArr2[i] = j;
            int entryCount2 = c07364v.A0b();
            if (entryCount2 == 1) {
                c07364v.A0g(2);
            } else {
                throw new IllegalArgumentException(A0M(540, 23, 90));
            }
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair<Metadata, Metadata> A0A(C2251mD c2251mD) {
        C07364v c07364v = c2251mD.A00;
        c07364v.A0f(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (true) {
            int A07 = c07364v.A07();
            String[] strArr = A01;
            if (strArr[7].charAt(30) == strArr[4].charAt(30)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "ATF6ss1I";
            strArr2[3] = "jntry4xS";
            if (A07 >= 8) {
                int A09 = c07364v.A09();
                int A0C = c07364v.A0C();
                int A0C2 = c07364v.A0C();
                if (A0C2 == 1835365473) {
                    c07364v.A0f(A09);
                    metadata = A0E(c07364v, A09 + A0C);
                } else if (A0C2 == 1936553057) {
                    c07364v.A0f(A09);
                    metadata2 = A0D(c07364v, A09 + A0C);
                }
                c07364v.A0f(A09 + A0C);
            } else {
                return Pair.create(metadata, metadata2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return new com.facebook.ads.androidx.media3.common.Metadata(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r4 != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Metadata A0C(C07364v c07364v, int i) {
        c07364v.A0g(8);
        ArrayList arrayList = new ArrayList();
        while (c07364v.A09() < i) {
            Id3Frame A04 = JB.A04(c07364v);
            if (A01[2].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[7] = "lHUs7TBcARFSvdLvQvihflkVmEpZ1MYm";
            strArr[4] = "ww6ZL200nHcHREaExV9g08P8Dpl3Z1fQ";
            if (A04 != null) {
                arrayList.add(A04);
            }
        }
        boolean isEmpty = arrayList.isEmpty();
        String[] strArr2 = A01;
        if (strArr2[1].charAt(26) != strArr2[6].charAt(26)) {
            String[] strArr3 = A01;
            strArr3[7] = "WnDUA4AhIDsAjF22CXXz4OtQUCX0JoWn";
            strArr3[4] = "j7UA12dewj7emLVLNadXlb6UYVuvbHls";
        }
    }

    public static Metadata A0D(C07364v c07364v, int i) {
        c07364v.A0g(12);
        while (true) {
            int A09 = c07364v.A09();
            if (A01[5].charAt(23) != 'W') {
                throw new RuntimeException();
            }
            A01[2] = "yKVAIw0tCkGB7M4Cua27Coqh";
            if (A09 >= i) {
                return null;
            }
            int atomSize = c07364v.A09();
            int A0C = c07364v.A0C();
            int atomPosition = c07364v.A0C();
            if (atomPosition == 1935766900) {
                if (A0C < 14) {
                    return null;
                }
                c07364v.A0g(5);
                int A0I = c07364v.A0I();
                if (A0I != 12 && A0I != 13) {
                    return null;
                }
                float f = A0I == 12 ? 240.0f : 120.0f;
                c07364v.A0g(1);
                return new Metadata(new SmtaMetadataEntry(f, c07364v.A0I()));
            }
            c07364v.A0f(atomSize + A0C);
        }
    }

    public static Metadata A0E(C07364v c07364v, int i) {
        c07364v.A0g(8);
        A0Q(c07364v);
        while (c07364v.A09() < i) {
            int A09 = c07364v.A09();
            int atomType = c07364v.A0C();
            int atomSize = c07364v.A0C();
            if (atomSize == 1768715124) {
                c07364v.A0f(A09);
                return A0C(c07364v, A09 + atomType);
            }
            c07364v.A0f(A09 + atomType);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b0, code lost:
    
        if (r7 == 2004251764) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b5, code lost:
    
        if (r7 == 1937010800) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01ba, code lost:
    
        if (r7 != 1664495672) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01cb, code lost:
    
        if (r7 != 1835365492) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01cd, code lost:
    
        A0U(r24, r7, r8, r25, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d5, code lost:
    
        if (r7 != 1667329389) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01d7, code lost:
    
        r14.A02 = new com.instagram.common.viewpoint.core.C06802p().A0g(r25).A11(A0M(com.ironsource.mediationsdk.logger.IronSourceError.ERROR_NT_INSTANCE_LOAD_EMPTY_ADAPTER, 27, 38)).A14();
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01a3, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01bc, code lost:
    
        r8 = r8;
        r9 = r9;
        A0S(r24, r7, r8, r9, r25, r27, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0169, code lost:
    
        if (r7 != 1835823201) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f8, code lost:
    
        if (r7 != 1835823201) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fd, code lost:
    
        if (r7 == 1685353315) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0102, code lost:
    
        if (r7 == 1685353317) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0107, code lost:
    
        if (r7 == 1685353320) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010c, code lost:
    
        if (r7 == 1685353324) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0111, code lost:
    
        if (r7 == 1685353336) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0116, code lost:
    
        if (r7 == 1935764850) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011b, code lost:
    
        if (r7 == 1935767394) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0120, code lost:
    
        if (r7 == 1819304813) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0125, code lost:
    
        if (r7 == 1936684916) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012a, code lost:
    
        if (r7 == 1953984371) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012f, code lost:
    
        if (r7 == 778924082) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0134, code lost:
    
        if (r7 == 778924083) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0139, code lost:
    
        if (r7 == 1835557169) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013e, code lost:
    
        if (r7 == 1835560241) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0143, code lost:
    
        if (r7 == 1634492771) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0148, code lost:
    
        if (r7 == 1634492791) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x014d, code lost:
    
        if (r7 == 1970037111) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0152, code lost:
    
        if (r7 == 1332770163) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0157, code lost:
    
        if (r7 != 1716281667) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x016c, code lost:
    
        r2 = com.instagram.common.viewpoint.core.J0.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x017f, code lost:
    
        if (r2[0].length() == r2[3].length()) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0183, code lost:
    
        com.instagram.common.viewpoint.core.J0.A01[5] = "mlJGx5h1gegl7007OPiYCkGWkqECmimV";
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x018a, code lost:
    
        if (r7 == 1414810956) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019c, code lost:
    
        if (com.instagram.common.viewpoint.core.J0.A01[5].charAt(23) == 'W') goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01a4, code lost:
    
        com.instagram.common.viewpoint.core.J0.A01[2] = "522w9jUs1Cdec5FzFXJEv7rx";
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ab, code lost:
    
        if (r7 == 1954034535) goto L118;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1082Iy A0H(C07364v c07364v, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws C3K {
        c07364v.A0f(12);
        int A0C = c07364v.A0C();
        C1082Iy c1082Iy = new C1082Iy(A0C);
        for (int childStartPosition = 0; childStartPosition < A0C; childStartPosition++) {
            int A09 = c07364v.A09();
            int A0C2 = c07364v.A0C();
            HB.A01(A0C2 > 0, A0M(1090, 30, 79));
            int A0C3 = c07364v.A0C();
            if (A0C3 != 1635148593 && A0C3 != 1635148595 && A0C3 != 1701733238 && A0C3 != 1831958048 && A0C3 != 1836070006 && A0C3 != 1752589105 && A0C3 != 1751479857 && A0C3 != 1932670515 && A0C3 != 1211250227 && A0C3 != 1987063864 && A0C3 != 1987063865 && A0C3 != 1635135537 && A0C3 != 1685479798 && A0C3 != 1685479729 && A0C3 != 1685481573 && A0C3 != 1685481521) {
                if (A01[5].charAt(23) == 'W') {
                    String[] strArr = A01;
                    strArr[0] = "Lno9V07i";
                    strArr[3] = "YEniY2O3";
                    if (A0C3 != 1836069985 && A0C3 != 1701733217 && A0C3 != 1633889587 && A0C3 != 1700998451 && A0C3 != 1633889588) {
                        if (A01[2].length() != 24) {
                            String[] strArr2 = A01;
                            strArr2[1] = "oNdMvJKT47PBcE7ne9hrfWimoE8yMs3Y";
                            strArr2[6] = "E91ArCAwNKvmlCTKVUGyb2erGBttgGv0";
                        } else {
                            A01[2] = "3e9ArAGLRrjfeL1rnoEKSVyw";
                        }
                    }
                    A0T(c07364v, A0C3, A09, A0C2, i, str, z, drmInitData, c1082Iy, childStartPosition);
                }
                throw new RuntimeException();
            }
            A0R(c07364v, A0C3, A09, A0C2, i, i2, drmInitData, c1082Iy, childStartPosition);
            c07364v.A0f(A09 + A0C2);
        }
        return c1082Iy;
    }

    public static ByteBuffer A0N() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kO != com.google.common.base.Function<com.facebook.ads.androidx.media3.extractor.mp4.Track, com.facebook.ads.androidx.media3.extractor.mp4.Track> */
    public static List<JR> A0O(C2252mE c2252mE, HK hk, long j, DrmInitData drmInitData, boolean z, boolean z2, InterfaceC2140kO<JO, JO> interfaceC2140kO) throws C3K {
        JO A4B;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c2252mE.A01.size(); i++) {
            C2252mE c2252mE2 = c2252mE.A01.get(i);
            if (((AbstractC1078Iu) c2252mE2).A00 == 1953653099 && (A4B = interfaceC2140kO.A4B(A0J(c2252mE2, (C2251mD) AbstractC07133y.A01(c2252mE.A07(1836476516)), j, drmInitData, z, z2))) != null) {
                C2252mE c2252mE3 = (C2252mE) AbstractC07133y.A01(c2252mE2.A06(1835297121));
                if (A01[2].length() != 24) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "jveTcVJC";
                strArr[3] = "kDhQUkZe";
                arrayList.add(A0L(A4B, (C2252mE) AbstractC07133y.A01(((C2252mE) AbstractC07133y.A01(c2252mE3.A06(1835626086))).A06(1937007212)), hk));
            }
        }
        return arrayList;
    }

    public static void A0Q(C07364v c07364v) {
        int A09 = c07364v.A09();
        c07364v.A0g(4);
        if (c07364v.A0C() != 1751411826) {
            A09 += 4;
        }
        c07364v.A0f(A09);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<byte[]> */
    public static void A0S(C07364v c07364v, int i, int i2, int i3, int i4, String str, C1082Iy c1082Iy) {
        String A0M;
        c07364v.A0f(i2 + 8 + 8);
        BP bp = null;
        long j = Long.MAX_VALUE;
        if (i == 1414810956) {
            A0M = A0M(691, 20, 103);
        } else if (i == 1954034535) {
            A0M = A0M(784, 28, 58);
            int sampleDescriptionLength = (i3 - 8) - 8;
            byte[] bArr = new byte[sampleDescriptionLength];
            c07364v.A0k(bArr, 0, sampleDescriptionLength);
            bp = BP.A04(bArr);
        } else if (i == 2004251764) {
            A0M = A0M(763, 21, 88);
        } else if (i == 1937010800) {
            A0M = A0M(691, 20, 103);
            j = 0;
        } else if (i == 1664495672) {
            A0M = A0M(738, 25, 73);
            c1082Iy.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        c1082Iy.A02 = new C06802p().A0g(i4).A11(A0M).A10(str).A0s(j).A12(bp).A14();
    }

    public static void A0U(C07364v c07364v, int i, int i2, int i3, C1082Iy c1082Iy) {
        c07364v.A0f(i2 + 8 + 8);
        if (i == 1835365492) {
            c07364v.A0U();
            String A0U = c07364v.A0U();
            if (A0U != null) {
                c1082Iy.A02 = new C06802p().A0g(i3).A11(A0U).A14();
            }
        }
    }

    public static boolean A0V(long[] jArr, long j, long j2, long j3) {
        int latestDelayIndex = jArr.length - 1;
        int A07 = C5C.A07(4, 0, latestDelayIndex);
        int lastIndex = jArr.length;
        int latestDelayIndex2 = C5C.A07(lastIndex - 4, 0, latestDelayIndex);
        if (jArr[0] <= j2) {
            long j4 = jArr[A07];
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[3];
            int length = str.length();
            int lastIndex2 = str2.length();
            if (length != lastIndex2) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "4d2838LB6zuHL2SDSRFgaAe0bfX5eWcN";
            strArr2[4] = "2DmC9sheXkti4jYQDflGydtNBiOhlXlc";
            if (j2 < j4 && jArr[latestDelayIndex2] < j3 && j3 <= j) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] A0W(C07364v c07364v, int i, int i2) {
        int i3 = i + 8;
        while (childPosition < i2) {
            c07364v.A0f(i3);
            int A0C = c07364v.A0C();
            int A0C2 = c07364v.A0C();
            String[] strArr = A01;
            String str = strArr[7];
            String str2 = strArr[4];
            int childAtomSize = str.charAt(30);
            int childPosition = str2.charAt(30);
            if (childAtomSize == childPosition) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[0] = "QfAHDCYR";
            strArr2[3] = "If6V2JqI";
            if (A0C2 == 1886547818) {
                int childPosition2 = i3 + A0C;
                return Arrays.copyOfRange(c07364v.A0l(), i3, childPosition2);
            }
            i3 += A0C;
        }
        return null;
    }
}
