package com.instagram.common.viewpoint.core;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ApicFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.BinaryFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ChapterFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.MlltFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.PrivFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.UrlLinkFrame;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.9U, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C9U extends AbstractC2261mZ {
    public static byte[] A01;
    public static String[] A02 = {"dfkl9gE5OREu5AXL5lY0ohuUUe3SXBJr", "hKeIXQ7stisHjmNWZz70dNldldiAaQvi", "Ev47ZYJBP4qmoN0JeJrCKxe3cHeEd2Mz", "un9uiXmeOTgIIo", "Wd16eevQjbu9Ian59LTBbcV1NeBW6y6R", "QoAdFFIsNXY7HGA7Qc965AL0CxX7pFDa", "35FvwnlVw7oPAj", "U3kKyqEMJJ2afey5JgaPdqN5tYmvQhts"};
    public static final IE A03;
    public final IE A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ApicFrame A04(C07364v c07364v, int i, int i2) {
        int A022;
        String A012;
        int A0I = c07364v.A0I();
        Charset A0M = A0M(A0I);
        byte[] bArr = new byte[i - 1];
        c07364v.A0k(bArr, 0, i - 1);
        String A0J = A0J(TTAdConstant.AD_ID_IS_NULL_CODE, 6, 90);
        if (i2 == 2) {
            A022 = 2;
            A012 = A0J + AbstractC2124k7.A01(new String(bArr, 0, 3, AbstractC2126k9.A00));
            if (A0J(418, 9, 47).equals(A012)) {
                A012 = A0J(408, 10, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
            }
        } else {
            A022 = A02(bArr, 0);
            A012 = AbstractC2124k7.A01(new String(bArr, 0, A022, AbstractC2126k9.A00));
            if (A012.indexOf(47) == -1) {
                A012 = A0J + A012;
            }
        }
        int i3 = bArr[A022 + 1] & 255;
        int i4 = A022 + 2;
        int A032 = A03(bArr, i4, A0I);
        return new ApicFrame(A012, new String(bArr, i4, A032 - i4, A0M), i3, A0Q(bArr, A00(A0I) + A032, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static ChapterFrame A06(C07364v c07364v, int i, int i2, boolean z, int i3, IE ie) {
        int A09 = c07364v.A09();
        int A022 = A02(c07364v.A0l(), A09);
        String str = new String(c07364v.A0l(), A09, A022 - A09, AbstractC2126k9.A00);
        c07364v.A0f(A022 + 1);
        int A0C = c07364v.A0C();
        int A0C2 = c07364v.A0C();
        long A0Q = c07364v.A0Q();
        if (A0Q == 4294967295L) {
            A0Q = -1;
        }
        long A0Q2 = c07364v.A0Q();
        if (A0Q2 == 4294967295L) {
            A0Q2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = A09 + i;
        while (true) {
            int A092 = c07364v.A09();
            if (A02[5].charAt(22) == 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "yxJytYiELIVuKxluLLGjsQCljTQ6t8ax";
            strArr[0] = "riKuEgzQ5i9bwl4lr9MCLXtR5zTvU4EY";
            if (A092 >= i4) {
                return new ChapterFrame(str, A0C, A0C2, A0Q, A0Q2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
            }
            Id3Frame A0B = A0B(i2, c07364v, z, i3, ie);
            if (A0B != null) {
                arrayList.add(A0B);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static GeobFrame A09(C07364v c07364v, int i) {
        int A0I = c07364v.A0I();
        Charset A0M = A0M(A0I);
        byte[] bArr = new byte[i - 1];
        c07364v.A0k(bArr, 0, i - 1);
        int A022 = A02(bArr, 0);
        String str = new String(bArr, 0, A022, AbstractC2126k9.A00);
        int i2 = A022 + 1;
        int A032 = A03(bArr, i2, A0I);
        String A0L = A0L(bArr, i2, A032, A0M);
        int A00 = A00(A0I) + A032;
        int A033 = A03(bArr, A00, A0I);
        return new GeobFrame(str, A0L, A0L(bArr, A00, A033, A0M), A0Q(bArr, A00(A0I) + A033, bArr.length));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static MlltFrame A0C(C07364v c07364v, int i) {
        int A0M = c07364v.A0M();
        int A0K = c07364v.A0K();
        int A0K2 = c07364v.A0K();
        int A0I = c07364v.A0I();
        int A0I2 = c07364v.A0I();
        C07354u c07354u = new C07354u();
        c07354u.A0C(c07364v);
        int i2 = ((i - 10) * 8) / (A0I + A0I2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int A04 = c07354u.A04(A0I);
            int A042 = c07354u.A04(A0I2);
            iArr[i3] = A04;
            iArr2[i3] = A042;
            if (A02[5].charAt(22) == 'F') {
                throw new RuntimeException();
            }
            A02[4] = "fcLz7frwMRu6ITyb";
        }
        return new MlltFrame(A0M, A0K, A0K2, iArr, iArr2);
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 13);
        }
        return new String(copyOfRange);
    }

    public static void A0N() {
        A01 = new byte[]{Ascii.SUB, Ascii.SI, 9, 103, 109, 43, 109, 43, 109, 43, 41, 111, 41, 111, 41, 111, 41, 111, 6, 10, 76, 88, 75, 71, 79, 121, 67, 80, 79, Ascii.ETB, 37, 0, Ascii.NAK, 0, 65, Ascii.NAK, Ascii.SO, Ascii.SO, 65, Ascii.DC2, 9, Ascii.SO, 19, Ascii.NAK, 65, Ascii.NAK, Ascii.SO, 65, 3, 4, 65, 0, Ascii.SI, 65, 40, 37, 82, 65, Ascii.NAK, 0, 6, 76, 107, 99, 102, 111, 110, 42, 126, 101, 42, 110, 111, 105, 101, 110, 111, 42, 108, 120, 107, 103, 111, 48, 42, 99, 110, 55, 114, 85, 93, 88, 81, 80, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 91, Ascii.DC4, 66, 85, 88, 93, 80, 85, SignedBytes.MAX_POWER_OF_TWO, 81, Ascii.DC4, 125, 112, 7, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 85, 83, Ascii.DC4, 67, 93, SignedBytes.MAX_POWER_OF_TWO, 92, Ascii.DC4, 89, 85, 94, 91, 70, 98, 81, 70, 71, 93, 91, 90, 9, 39, 19, 0, Ascii.FF, 4, 65, Ascii.DC2, 8, Ascii.ESC, 4, 65, 4, Ascii.EM, 2, 4, 4, 5, Ascii.DC2, 65, 19, 4, Ascii.FF, 0, 8, Ascii.SI, 8, Ascii.SI, 6, 65, Ascii.NAK, 0, 6, 65, 5, 0, Ascii.NAK, 0, 74, 103, 48, 71, 102, 96, 108, 103, 102, 113, 85, 109, 111, 118, 118, 99, 98, 38, 79, 66, 53, 38, 114, 103, 97, 38, 113, 111, 114, 110, 38, 107, 103, 108, 105, 116, 80, 99, 116, 117, 111, 105, 104, 59, 52, 38, 103, 104, 98, 38, 115, 104, 98, 99, 96, 111, 104, 99, 98, 38, 101, 105, 107, 118, 116, 99, 117, 117, 111, 105, 104, 38, 117, 101, 110, 99, 107, 99, 104, 80, 82, 75, 75, 94, 95, Ascii.ESC, 114, Byte.MAX_VALUE, 8, Ascii.ESC, 79, 90, 92, Ascii.ESC, 76, 82, 79, 83, Ascii.ESC, 78, 85, 72, 78, 75, 75, 84, 73, 79, 94, 95, Ascii.ESC, 86, 90, 81, 84, 73, 109, 94, 73, 72, 82, 84, 85, 6, 42, Ascii.DC2, Ascii.DLE, 9, 9, Ascii.DLE, Ascii.ETB, Ascii.RS, 89, Ascii.FF, Ascii.ETB, 10, Ascii.FF, 9, 9, Ascii.SYN, Ascii.VT, Ascii.CR, Ascii.FS, Ascii.GS, 89, Ascii.SUB, Ascii.SYN, Ascii.DC4, 9, Ascii.VT, Ascii.FS, 10, 10, Ascii.FS, Ascii.GS, 89, Ascii.SYN, Ascii.VT, 89, Ascii.FS, Ascii.ETB, Ascii.SUB, Ascii.VT, 0, 9, Ascii.CR, Ascii.FS, Ascii.GS, 89, Ascii.US, Ascii.VT, Ascii.CAN, Ascii.DC4, Ascii.FS, 62, 50, 50, 50, 119, 76, 71, 90, 82, 71, 65, 86, 71, 70, 2, 68, 75, 80, 81, 86, 2, 86, 74, 80, 71, 71, 2, SignedBytes.MAX_POWER_OF_TWO, 91, 86, 71, 81, 2, 77, 68, 2, 107, 102, 17, 2, 86, 67, 69, 2, 74, 71, 67, 70, 71, 80, Ascii.CAN, 2, Ascii.DC2, 90, 121, 118, 118, 118, 62, 58, 54, 48, 50, 120, Ascii.RS, Ascii.SUB, Ascii.SYN, Ascii.DLE, Ascii.DC2, 88, Ascii.GS, 7, Ascii.DC2, Ascii.DLE, 75, 79, 67, 69, 71, Ascii.CR, 72, 82, 69};
    }

    static {
        A0N();
        A03 = new IE() { // from class: com.facebook.ads.redexgen.X.mT
            @Override // com.instagram.common.viewpoint.core.IE
            public final boolean A6Q(int i, int i2, int i3, int i4, int i5) {
                return C9U.A0O(i, i2, i3, i4, i5);
            }
        };
    }

    public C9U() {
        this(null);
    }

    public C9U(IE ie) {
        this.A00 = ie;
    }

    public static int A00(int i) {
        if (i == 0 || i == 3) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(C07364v c07364v, int i) {
        byte[] A0l = c07364v.A0l();
        int A09 = c07364v.A09();
        int i2 = A09;
        while (startPosition < A09 + i) {
            int startPosition = A0l[i2];
            if ((startPosition & 255) == 255 && A0l[i2 + 1] == 0) {
                int i3 = i2 + 2;
                int i4 = i2 + 1;
                int relativePosition = (i - (i2 - A09)) - 2;
                String[] strArr = A02;
                String str = strArr[1];
                String str2 = strArr[7];
                int startPosition2 = str.charAt(20);
                if (startPosition2 != str2.charAt(20)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[1] = "XZV6e8MYnWgHLOD3ZLXsdTcFpPsY6V3F";
                strArr2[7] = "PRKMokf209xLCZShYH0Zduqvqdx50TVA";
                System.arraycopy(A0l, i3, A0l, i4, relativePosition);
                i--;
            }
            i2++;
        }
        return i;
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0001 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A02(byte[] bArr, int i) {
        while (i < i) {
            int i2 = bArr[i];
            if (i2 == 0) {
                return i;
            }
            i++;
        }
        int i3 = bArr.length;
        return i3;
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(byte[] bArr, int i, int i2) {
        int A022 = A02(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return A022;
        }
        while (A022 < terminationPos - 1) {
            int terminationPos = A022 - i;
            if (terminationPos % 2 == 0) {
                int terminationPos2 = A022 + 1;
                if (bArr[terminationPos2] == 0) {
                    return A022;
                }
            }
            int terminationPos3 = A022 + 1;
            A022 = A02(bArr, terminationPos3);
        }
        int terminationPos4 = bArr.length;
        return terminationPos4;
    }

    public static BinaryFrame A05(C07364v c07364v, int i, String str) {
        byte[] bArr = new byte[i];
        c07364v.A0k(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterTocFrame A07(C07364v c07364v, int i, int i2, boolean z, int elementIdEndIndex, IE ie) {
        int A09 = c07364v.A09();
        int A022 = A02(c07364v.A0l(), A09);
        String str = new String(c07364v.A0l(), A09, A022 - A09, AbstractC2126k9.A00);
        c07364v.A0f(A022 + 1);
        int framePosition = c07364v.A0I();
        boolean z2 = (framePosition & 2) != 0;
        boolean z3 = (framePosition & 1) != 0;
        int A0I = c07364v.A0I();
        String[] strArr = new String[A0I];
        for (int i3 = 0; i3 < A0I; i3++) {
            int startIndex = c07364v.A09();
            int A023 = A02(c07364v.A0l(), startIndex);
            int elementIdEndIndex2 = A023 - startIndex;
            strArr[i3] = new String(c07364v.A0l(), startIndex, elementIdEndIndex2, AbstractC2126k9.A00);
            c07364v.A0f(A023 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i4 = A09 + i;
        while (c07364v.A09() < i4) {
            Id3Frame A0B = A0B(i2, c07364v, z, elementIdEndIndex, ie);
            if (A0B != null) {
                arrayList.add(A0B);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static CommentFrame A08(C07364v c07364v, int i) {
        if (i < 4) {
            return null;
        }
        int textStartIndex = c07364v.A0I();
        Charset A0M = A0M(textStartIndex);
        byte[] bArr = new byte[3];
        c07364v.A0k(bArr, 0, 3);
        String description = new String(bArr, 0, 3);
        int encoding = i - 4;
        byte[] data = new byte[encoding];
        int encoding2 = i - 4;
        c07364v.A0k(data, 0, encoding2);
        int encoding3 = A03(data, 0, textStartIndex);
        String language = new String(data, 0, encoding3, A0M);
        int A00 = A00(textStartIndex) + encoding3;
        int encoding4 = A03(data, A00, textStartIndex);
        return new CommentFrame(description, language, A0L(data, A00, encoding4, A0M));
    }

    public static IF A0A(C07364v c07364v) {
        int A07 = c07364v.A07();
        String A0J = A0J(170, 10, 14);
        if (A07 < 10) {
            AbstractC07214g.A07(A0J, A0J(30, 31, 108));
            return null;
        }
        int A0K = c07364v.A0K();
        boolean z = false;
        if (A0K != 4801587) {
            AbstractC07214g.A07(A0J, A0J(348, 50, 47) + String.format(A0J(0, 4, 50), Integer.valueOf(A0K)));
            return null;
        }
        int A0I = c07364v.A0I();
        c07364v.A0g(1);
        int flags = c07364v.A0I();
        int A0H = c07364v.A0H();
        if (A0I == 2) {
            int id = flags & 64;
            int id2 = id != 0 ? 1 : 0;
            if (id2 != 0) {
                AbstractC07214g.A07(A0J, A0J(180, 68, 11));
                return null;
            }
        } else if (A0I == 3) {
            int id3 = flags & 64;
            int id4 = id3 != 0 ? 1 : 0;
            if (id4 != 0) {
                int id5 = c07364v.A0C();
                c07364v.A0g(id5);
                A0H -= id5 + 4;
            }
        } else if (A0I == 4) {
            int id6 = flags & 64;
            int id7 = id6 != 0 ? 1 : 0;
            if (id7 != 0) {
                int majorVersion = c07364v.A0H();
                int id8 = majorVersion - 4;
                c07364v.A0g(id8);
                A0H -= majorVersion;
            }
            int id9 = flags & 16;
            int id10 = id9 != 0 ? 1 : 0;
            if (id10 != 0) {
                A0H -= 10;
            }
        } else {
            AbstractC07214g.A07(A0J, A0J(248, 46, 54) + A0I);
            return null;
        }
        if (A0I < 4) {
            int id11 = flags & 128;
            if (id11 != 0) {
                z = true;
            }
        }
        return new IF(A0I, z, A0H);
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x01d9, code lost:
    
        if (r8 == 67) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0122, code lost:
    
        if (r4 != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0124, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x013c, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0139, code lost:
    
        if (r4 != 0) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame A0B(int frameId3, C07364v c07364v, boolean z, int i, IE ie) {
        int i2;
        int A0K;
        int i3;
        Id3Frame A07;
        int frameId2 = c07364v.A0I();
        int frameId1 = c07364v.A0I();
        int frameId0 = c07364v.A0I();
        if (frameId3 >= 3) {
            i2 = c07364v.A0I();
        } else {
            i2 = 0;
        }
        if (frameId3 == 4) {
            int A0L = c07364v.A0L();
            if (!z) {
                int frameSize = A0L >> 8;
                int i4 = (A0L & 255) | ((frameSize & 255) << 7);
                int frameSize2 = A0L >> 16;
                int i5 = i4 | ((frameSize2 & 255) << 14);
                int frameSize3 = A0L >> 24;
                A0K = i5 | ((frameSize3 & 255) << 21);
            } else {
                A0K = A0L;
            }
        } else if (frameId3 == 3) {
            A0K = c07364v.A0L();
        } else {
            A0K = c07364v.A0K();
        }
        if (frameId3 >= 3) {
            i3 = c07364v.A0M();
        } else {
            i3 = 0;
        }
        if (frameId2 == 0 && frameId1 == 0 && frameId0 == 0 && i2 == 0 && A0K == 0 && i3 == 0) {
            c07364v.A0f(c07364v.A0A());
            return null;
        }
        int flags = c07364v.A09() + A0K;
        int A0A = c07364v.A0A();
        String A0J = A0J(170, 10, 14);
        if (flags > A0A) {
            AbstractC07214g.A07(A0J, A0J(Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, 37, 108));
            c07364v.A0f(c07364v.A0A());
            return null;
        }
        if (ie != null && !ie.A6Q(frameId3, frameId2, frameId1, frameId0, i2)) {
            c07364v.A0f(flags);
            String[] strArr = A02;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A02[4] = "e3YBkKHUVMVtsvvPrHCe6nHMIy";
            return null;
        }
        int nextFramePosition = 0;
        boolean hasDataLength = false;
        boolean isEncrypted = false;
        int i6 = 0;
        int frameSize4 = 0;
        if (frameId3 == 3) {
            i6 = (i3 & 128) != 0 ? 1 : 0;
            hasDataLength = (i3 & 64) != 0;
            frameSize4 = (i3 & 32) != 0 ? 1 : 0;
            nextFramePosition = i6;
        } else if (frameId3 == 4) {
            frameSize4 = (i3 & 64) != 0 ? 1 : 0;
            nextFramePosition = (i3 & 8) != 0 ? 1 : 0;
            int i7 = i3 & 4;
            String[] strArr2 = A02;
            if (strArr2[6].length() != strArr2[3].length()) {
                A02[5] = "YrGhE76fNDxr3LSniMVr4VzIG8CV74Mf";
            } else {
                A02[5] = "eLbk71BgL0f2DKr72Qx6greuw57xH3Wk";
            }
            isEncrypted = (i3 & 2) != 0;
            i6 = (i3 & 1) != 0 ? 1 : 0;
        }
        if (nextFramePosition != 0 || hasDataLength) {
            AbstractC07214g.A07(A0J, A0J(294, 50, 116));
            return null;
        }
        if (frameSize4 != 0) {
            A0K--;
            c07364v.A0g(1);
        }
        if (i6 != 0) {
            A0K -= 4;
            c07364v.A0g(4);
        }
        if (isEncrypted) {
            A0K = A01(c07364v, A0K);
        }
        try {
            if (frameId2 == 84 && frameId1 == 88 && frameId0 == 88 && (frameId3 == 2 || i2 == 88)) {
                A07 = A0E(c07364v, A0K);
            } else if (frameId2 == 84) {
                A07 = A0F(c07364v, A0K, A0K(frameId3, frameId2, frameId1, frameId0, i2));
            } else if (frameId2 == 87 && frameId1 == 88 && frameId0 == 88 && (frameId3 == 2 || i2 == 88)) {
                A07 = A0G(c07364v, A0K);
            } else if (frameId2 == 87) {
                A07 = A0H(c07364v, A0K, A0K(frameId3, frameId2, frameId1, frameId0, i2));
            } else if (frameId2 == 80 && frameId1 == 82 && frameId0 == 73 && i2 == 86) {
                A07 = A0D(c07364v, A0K);
            } else if (frameId2 == 71 && frameId1 == 69 && frameId0 == 79 && (i2 == 66 || frameId3 == 2)) {
                A07 = A09(c07364v, A0K);
            } else if (frameId3 != 2) {
                if (frameId2 == 65) {
                    if (frameId1 == 80) {
                        if (frameId0 == 73) {
                        }
                    }
                }
                if (frameId2 == 67) {
                }
                if (frameId2 != 67) {
                }
                if (frameId2 != 67) {
                }
            } else {
                if (frameId2 == 80 && frameId1 == 73 && frameId0 == 67) {
                    A07 = A04(c07364v, A0K, frameId3);
                }
                if (frameId2 == 67 || frameId1 != 79 || frameId0 != 77 || (i2 != 77 && frameId3 != 2)) {
                    if (frameId2 != 67 && frameId1 == 72 && frameId0 == 65 && i2 == 80) {
                        A07 = A06(c07364v, A0K, frameId3, z, i, ie);
                    } else {
                        A07 = (frameId2 != 67 && frameId1 == 84 && frameId0 == 79 && i2 == 67) ? A07(c07364v, A0K, frameId3, z, i, ie) : (frameId2 != 77 && frameId1 == 76 && frameId0 == 76 && i2 == 84) ? A0C(c07364v, A0K) : A05(c07364v, A0K, A0K(frameId3, frameId2, frameId1, frameId0, i2));
                    }
                } else {
                    A07 = A08(c07364v, A0K);
                }
            }
            if (A07 == null) {
                AbstractC07214g.A07(A0J, A0J(61, 27, 7) + A0K(frameId3, frameId2, frameId1, frameId0, i2) + A0J(18, 12, 39) + A0K);
            }
            return A07;
        } finally {
            c07364v.A0f(flags);
        }
    }

    public static PrivFrame A0D(C07364v c07364v, int i) {
        byte[] bArr = new byte[i];
        c07364v.A0k(bArr, 0, i);
        int A022 = A02(bArr, 0);
        return new PrivFrame(new String(bArr, 0, A022, AbstractC2126k9.A00), A0Q(bArr, A022 + 1, bArr.length));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0E(C07364v c07364v, int i) {
        if (i < 1) {
            return null;
        }
        int A0I = c07364v.A0I();
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c07364v.A0k(bArr, 0, encoding2);
        int A032 = A03(bArr, 0, A0I);
        String str = new String(bArr, 0, A032, A0M(A0I));
        int encoding3 = A00(A0I);
        return new TextInformationFrame(A0J(344, 4, 103), str, A0I(bArr, A0I, encoding3 + A032));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static TextInformationFrame A0F(C07364v c07364v, int i, String str) {
        if (i < 1) {
            return null;
        }
        int A0I = c07364v.A0I();
        int encoding = i - 1;
        byte[] data = new byte[encoding];
        c07364v.A0k(data, 0, i - 1);
        return new TextInformationFrame(str, null, A0I(data, A0I, 0));
    }

    public static UrlLinkFrame A0G(C07364v c07364v, int i) {
        if (i < 1) {
            return null;
        }
        int A0I = c07364v.A0I();
        int encoding = i - 1;
        byte[] bArr = new byte[encoding];
        int encoding2 = i - 1;
        c07364v.A0k(bArr, 0, encoding2);
        int A032 = A03(bArr, 0, A0I);
        String str = new String(bArr, 0, A032, A0M(A0I));
        int descriptionEndIndex = A00(A0I) + A032;
        String description = A0L(bArr, descriptionEndIndex, A02(bArr, descriptionEndIndex), AbstractC2126k9.A00);
        return new UrlLinkFrame(A0J(398, 4, 35), str, description);
    }

    public static UrlLinkFrame A0H(C07364v c07364v, int i, String str) {
        byte[] bArr = new byte[i];
        c07364v.A0k(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, A02(bArr, 0), AbstractC2126k9.A00));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<java.lang.String> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BP != com.google.common.collect.ImmutableList<java.lang.String> */
    public static BP<String> A0I(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        String A0J = A0J(0, 0, 108);
        if (i2 >= length) {
            return BP.A04(A0J);
        }
        C2K A012 = BP.A01();
        int valueEndIndex = A03(bArr, i2, i);
        while (i2 < valueEndIndex) {
            int valueStartIndex = valueEndIndex - i2;
            A012.A04(new String(bArr, i2, valueStartIndex, A0M(i)));
            i2 = valueEndIndex + A00(i);
            valueEndIndex = A03(bArr, i2, i);
        }
        BP<String> A05 = A012.A05();
        return A05.isEmpty() ? BP.A04(A0J) : A05;
    }

    public static String A0K(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, A0J(4, 6, 69), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, A0J(10, 8, 1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static String A0L(byte[] bArr, int i, int i2, Charset charset) {
        if (i2 <= i || i2 > bArr.length) {
            return A0J(0, 0, 108);
        }
        return new String(bArr, i, i2 - i, charset);
    }

    public static Charset A0M(int i) {
        switch (i) {
            case 1:
                return AbstractC2126k9.A02;
            case 2:
                return AbstractC2126k9.A03;
            case 3:
                return AbstractC2126k9.A05;
            default:
                Charset charset = AbstractC2126k9.A00;
                if (A02[5].charAt(22) == 'F') {
                    throw new RuntimeException();
                }
                A02[5] = "KvSqsioCKy57forlhJv7i4SYYwwKGyHr";
                return charset;
        }
    }

    public static /* synthetic */ boolean A0O(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0P(C07364v c07364v, int i, int i2, boolean z) {
        int A0C;
        long A0Q;
        int A0M;
        int A09 = c07364v.A09();
        while (true) {
            try {
                if (c07364v.A07() < i2) {
                    c07364v.A0f(A09);
                    return true;
                }
                if (i >= 3) {
                    try {
                        A0C = c07364v.A0C();
                        A0Q = c07364v.A0Q();
                        A0M = c07364v.A0M();
                    } catch (Throwable th) {
                        th = th;
                        c07364v.A0f(A09);
                        throw th;
                    }
                } else {
                    A0C = c07364v.A0K();
                    A0Q = c07364v.A0K();
                    A0M = 0;
                }
                if (A0C == 0 && A0Q == 0 && A0M == 0) {
                    c07364v.A0f(A09);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & A0Q) != 0) {
                        c07364v.A0f(A09);
                        String[] strArr = A02;
                        if (strArr[1].charAt(20) == strArr[7].charAt(20)) {
                            String[] strArr2 = A02;
                            strArr2[1] = "5mCE9WytQNPeLFhBzaYSd2zmXPTMRlgu";
                            strArr2[7] = "AgecK2HA7Twj8m2CWduPdApaKwCpCynb";
                            return false;
                        }
                    } else {
                        A0Q = (((A0Q >> 24) & 255) << 21) | (A0Q & 255) | (((A0Q >> 8) & 255) << 7) | (((A0Q >> 16) & 255) << 14);
                    }
                }
                int id = 0;
                int flags = 0;
                if (i == 4) {
                    id = (A0M & 64) != 0 ? 1 : 0;
                    flags = (A0M & 1) == 0 ? 0 : 1;
                } else if (i == 3) {
                    id = (A0M & 32) != 0 ? 1 : 0;
                    flags = (A0M & 128) == 0 ? 0 : 1;
                }
                int i3 = 0;
                String[] strArr3 = A02;
                if (strArr3[1].charAt(20) != strArr3[7].charAt(20)) {
                    break;
                }
                String[] strArr4 = A02;
                strArr4[1] = "MVZStPJLdDxKiV7nz1H6dv3NOIiLFLEe";
                strArr4[7] = "QTxGzLkjWgw6uSVWxpxBdQfPOh5DKkgy";
                if (id != 0) {
                    i3 = 0 + 1;
                }
                if (flags != 0) {
                    i3 += 4;
                }
                if (A0Q < i3) {
                    c07364v.A0f(A09);
                    return false;
                }
                int minimumFrameSize = c07364v.A07();
                long j = minimumFrameSize;
                String[] strArr5 = A02;
                String str = strArr5[6];
                String str2 = strArr5[3];
                int length = str.length();
                int minimumFrameSize2 = str2.length();
                if (length == minimumFrameSize2) {
                    A02[5] = "edbBlZh6UxoMPnyEc6lG0E5oPDAO53n7";
                    if (j < A0Q) {
                        break;
                    }
                    int minimumFrameSize3 = (int) A0Q;
                    c07364v.A0g(minimumFrameSize3);
                } else {
                    if (j < A0Q) {
                        break;
                    }
                    int minimumFrameSize32 = (int) A0Q;
                    c07364v.A0g(minimumFrameSize32);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        c07364v.A0f(A09);
        return false;
    }

    public static byte[] A0Q(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return C5C.A07;
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2261mZ
    public final Metadata A0R(C08439e c08439e, ByteBuffer byteBuffer) {
        return A0S(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata A0S(byte[] bArr, int i) {
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList = new ArrayList();
        C07364v c07364v = new C07364v(bArr, i);
        IF A0A = A0A(c07364v);
        if (A0A == null) {
            return null;
        }
        int startPosition = c07364v.A09();
        i2 = A0A.A01;
        int frameHeaderSize = i2 == 2 ? 6 : 10;
        i3 = A0A.A00;
        z = A0A.A02;
        if (z) {
            i8 = A0A.A00;
            i3 = A01(c07364v, i8);
        }
        c07364v.A0e(startPosition + i3);
        boolean z2 = false;
        i4 = A0A.A01;
        if (!A0P(c07364v, i4, frameHeaderSize, false)) {
            i6 = A0A.A01;
            if (i6 == 4 && A0P(c07364v, 4, frameHeaderSize, true)) {
                z2 = true;
            } else {
                StringBuilder append = new StringBuilder().append(A0J(88, 45, 57));
                i7 = A0A.A01;
                AbstractC07214g.A07(A0J(170, 10, 14), append.append(i7).toString());
                return null;
            }
        }
        while (c07364v.A07() >= frameHeaderSize) {
            i5 = A0A.A01;
            Id3Frame A0B = A0B(i5, c07364v, z2, frameHeaderSize, this.A00);
            if (A0B != null) {
                arrayList.add(A0B);
            }
        }
        return new Metadata(arrayList);
    }
}
