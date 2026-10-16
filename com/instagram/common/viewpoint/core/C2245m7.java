package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.extractor.metadata.emsg.EventMessage;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.io.encoding.Base64;

@MetaExoPlayerCustomization("Rename the class for A/B Testing")
/* renamed from: com.facebook.ads.redexgen.X.m7, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2245m7 implements H9 {
    public static byte[] A0Z;
    public static String[] A0a = {"vtb", "vbKonC", "9ohrxt3rIVPnhyMUHrYVmyK7bOK5FZ2r", "2NigTWH0ge82u7sbUdSeL8Wtj6iQtHIS", "zZrcpvCeqeJUqHmK3YGTET67EQVL4Dlr", "FEfAuyU", "TXQt6Bb5wsq1E0rpiydPRGzBJonmO6nW", "L3NiJ083BoYvWzKRwautviQbODBNEwGW"};
    public static final HD A0b;
    public static final C2489qI A0c;
    public static final byte[] A0d;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public long A07;
    public long A08;
    public long A09;

    @MetaExoPlayerCustomization("New field")
    public long A0A;
    public long A0B;
    public long A0C;
    public C07364v A0D;
    public HA A0E;
    public JA A0F;
    public boolean A0G;
    public boolean A0H;
    public InterfaceC1036Hd[] A0I;
    public InterfaceC1036Hd[] A0J;
    public final int A0K;
    public final SparseArray<JA> A0L;
    public final C07364v A0M;
    public final C07364v A0N;
    public final C07364v A0O;
    public final C07364v A0P;
    public final C07364v A0Q;
    public final AnonymousClass53 A0R;
    public final InterfaceC1036Hd A0S;
    public final I0 A0T;
    public final JO A0U;
    public final ArrayDeque<C2252mE> A0V;
    public final ArrayDeque<J9> A0W;
    public final List<C2489qI> A0X;
    public final byte[] A0Y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A01(JA ja, int i, int i2, C07364v c07364v, int i3) throws C3K {
        int i4;
        int i5 = i3;
        c07364v.A0f(8);
        int A00 = AbstractC1078Iu.A00(c07364v.A0C());
        JO jo = ja.A05.A03;
        JQ jq = ja.A09;
        J1 j1 = (J1) C5C.A0f(jq.A06);
        jq.A0C[i] = c07364v.A0L();
        jq.A0E[i] = jq.A04;
        if ((A00 & 1) != 0) {
            long[] jArr = jq.A0E;
            jArr[i] = jArr[i] + c07364v.A0C();
        }
        boolean z = (A00 & 4) != 0;
        int i6 = j1.A01;
        if (z) {
            i6 = c07364v.A0C();
        }
        boolean z2 = (A00 & 256) != 0;
        boolean z3 = (A00 & 512) != 0;
        boolean z4 = (A00 & 1024) != 0;
        boolean z5 = (A00 & 2048) != 0;
        long j = A0a(jo) ? ((long[]) C5C.A0f(jo.A09))[0] : 0L;
        int[] iArr = jq.A0B;
        long[] jArr2 = jq.A0D;
        boolean[] zArr = jq.A0G;
        boolean z6 = jo.A03 == 2 && (i2 & 1) != 0;
        int i7 = i5 + jq.A0C[i];
        long j2 = jo.A06;
        long j3 = jq.A05;
        while (i5 < i7) {
            if (z2) {
                i4 = c07364v.A0C();
                if (A0a[5].length() == 30) {
                    throw new RuntimeException();
                }
                A0a[0] = "Vvd";
            } else {
                i4 = j1.A00;
            }
            int A002 = A00(i4);
            int A003 = A00(z3 ? c07364v.A0C() : j1.A03);
            int A0C = z4 ? c07364v.A0C() : (i5 == 0 && z) ? i6 : j1.A01;
            jArr2[i5] = C5C.A0U(((z5 ? c07364v.A0C() : 0) + j3) - j, 1000000L, j2);
            if (!jq.A09) {
                jArr2[i5] = jArr2[i5] + ja.A05.A02;
            }
            iArr[i5] = A003;
            zArr[i5] = ((A0C >> 16) & 1) == 0 && (!z6 || i5 == 0);
            j3 += A002;
            i5++;
        }
        jq.A05 = j3;
        return i7;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<Long, C2285my> A05(C07364v c07364v, long j) throws C3K {
        long A0R;
        long A0R2;
        c07364v.A0f(8);
        int A01 = AbstractC1078Iu.A01(c07364v.A0C());
        c07364v.A0g(4);
        long A0Q = c07364v.A0Q();
        if (A01 == 0) {
            A0R = c07364v.A0Q();
            A0R2 = j + c07364v.A0Q();
        } else {
            A0R = c07364v.A0R();
            A0R2 = j + c07364v.A0R();
        }
        long A0U = C5C.A0U(A0R, 1000000L, A0Q);
        c07364v.A0g(2);
        int A0M = c07364v.A0M();
        int[] iArr = new int[A0M];
        long[] jArr = new long[A0M];
        long[] jArr2 = new long[A0M];
        long[] jArr3 = new long[A0M];
        long j2 = A0U;
        for (int i = 0; i < A0M; i++) {
            int A0C = c07364v.A0C();
            if ((Integer.MIN_VALUE & A0C) != 0) {
                throw C3K.A01(A0A(756, 28, 79), null);
            }
            long A0Q2 = c07364v.A0Q();
            iArr[i] = Integer.MAX_VALUE & A0C;
            jArr[i] = A0R2;
            jArr3[i] = j2;
            A0R += A0Q2;
            j2 = C5C.A0U(A0R, 1000000L, A0Q);
            jArr2[i] = j2 - jArr3[i];
            c07364v.A0g(4);
            A0R2 += iArr[i];
        }
        return Pair.create(Long.valueOf(A0U), new C2285my(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static JA A09(C07364v c07364v, SparseArray<JA> sparseArray, boolean z) {
        c07364v.A0f(8);
        int A00 = AbstractC1078Iu.A00(c07364v.A0C());
        JA valueAt = z ? sparseArray.valueAt(0) : sparseArray.get(c07364v.A0C());
        if (valueAt == null) {
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[1] = "jDobgNhtM";
            return null;
        }
        if ((A00 & 1) != 0) {
            long A0R = c07364v.A0R();
            valueAt.A09.A04 = A0R;
            valueAt.A09.A03 = A0R;
        }
        J1 j1 = valueAt.A04;
        valueAt.A09.A06 = new J1((A00 & 2) != 0 ? c07364v.A0C() - 1 : j1.A02, (A00 & 8) != 0 ? c07364v.A0C() : j1.A00, (A00 & 16) != 0 ? c07364v.A0C() : j1.A03, (A00 & 32) != 0 ? c07364v.A0C() : j1.A01);
        return valueAt;
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0Z, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[5] = "p0M5dFs6dnHIC4r2oiX9lIp2";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 74);
            i4++;
        }
    }

    public static void A0D() {
        A0Z = new byte[]{8, 65, 91, 8, 76, 65, 78, 78, 77, 90, 77, 70, 92, 8, 78, 90, 71, 69, 8, 78, 90, 73, 79, 69, 77, 70, 92, 8, 91, 73, 69, 88, 68, 77, 8, 75, 71, 93, 70, 92, 109, 36, 62, 109, 42, 63, 40, 44, 57, 40, 63, 109, 57, 37, 44, 35, 109, 43, 63, 44, 42, 32, 40, 35, 57, 109, 62, 44, 32, Base64.padSymbol, 33, 40, 109, 46, 34, 56, 35, 57, 47, Ascii.SUB, 1, 3, 78, Ascii.GS, 7, Ascii.DC4, Ascii.VT, 78, 2, Ascii.VT, Ascii.GS, Ascii.GS, 78, Ascii.SUB, 6, Ascii.SI, 0, 78, 6, Ascii.VT, Ascii.SI, 10, Ascii.VT, Ascii.FS, 78, 2, Ascii.VT, 0, 9, Ascii.SUB, 6, 78, 70, Ascii.ESC, 0, Ascii.GS, Ascii.ESC, Ascii.RS, Ascii.RS, 1, Ascii.FS, Ascii.SUB, Ascii.VT, 10, 71, SignedBytes.MAX_POWER_OF_TWO, 70, 109, 119, 113, 122, 35, 96, 108, 118, 109, 119, 35, 106, 109, 35, 112, 97, 100, 115, 35, 34, 62, 35, 50, 35, 43, 118, 109, 112, 118, 115, 115, 108, 113, 119, 102, 103, 42, 45, Ascii.GS, 54, 44, 42, 33, 120, 59, 55, 45, 54, 44, 120, 49, 54, 120, 43, 63, 40, 60, 120, 121, 101, 120, 105, 120, 112, 45, 54, 43, 45, 40, 40, 55, 42, 44, Base64.padSymbol, 60, 113, 118, 71, 115, 96, 102, 108, 100, 111, 117, 100, 101, 76, 113, 53, 68, 121, 117, 115, 96, 98, 117, 110, 115, Ascii.SO, 32, 41, 40, 53, 46, 41, 32, 103, 41, 34, 32, 38, 51, 46, 49, 34, 103, 40, 33, 33, 52, 34, 51, 103, 51, 40, 103, 52, 38, 42, 55, 43, 34, 103, 35, 38, 51, 38, 105, 118, 81, 73, 94, 83, 86, 91, Ascii.US, 113, 126, 115, Ascii.US, 83, 90, 81, 88, 75, 87, 0, 41, 45, 42, 108, 45, 56, 35, 33, 108, 40, 41, 42, 37, 34, 41, 63, 108, 41, 52, 56, 41, 34, 40, 41, 40, 108, 45, 56, 35, 33, 108, 63, 37, 54, 41, 108, 100, 57, 34, 63, 57, 60, 60, 35, 62, 56, 41, 40, 101, 98, 75, 98, 102, 97, 39, 102, 115, 104, 106, 39, 112, 110, 115, 111, 39, 107, 98, 105, 96, 115, 111, 39, 57, 39, 53, 54, 51, 48, 51, 63, 52, 49, 51, 48, 39, 47, 114, 105, 116, 114, 119, 119, 104, 117, 115, 98, 99, 46, 41, 62, Ascii.ETB, Ascii.ETB, 2, Ascii.DC4, 5, 81, 5, Ascii.RS, 81, Ascii.DC4, Ascii.US, Ascii.DC2, 3, 8, 1, 5, Ascii.CAN, Ascii.RS, Ascii.US, 81, Ascii.NAK, Ascii.DLE, 5, Ascii.DLE, 81, 6, Ascii.DLE, 2, 81, Ascii.US, Ascii.DC4, Ascii.SYN, Ascii.DLE, 5, Ascii.CAN, 7, Ascii.DC4, 95, 120, 81, 81, 68, 82, 67, Ascii.ETB, 67, 88, Ascii.ETB, 82, 89, 83, Ascii.ETB, 88, 81, Ascii.ETB, 90, 83, 86, 67, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 86, 68, Ascii.ETB, 89, 82, 80, 86, 67, 94, 65, 82, Ascii.EM, Ascii.ESC, 34, 49, 38, 38, Base64.padSymbol, 48, Base64.padSymbol, 58, 51, 116, 0, 38, 53, 55, 63, 17, 58, 55, 38, 45, 36, 32, Base64.padSymbol, 59, 58, Ascii.SYN, 59, 44, 116, 36, 53, 38, 53, 57, 49, 32, 49, 38, 39, 116, Base64.padSymbol, 39, 116, 33, 58, 39, 33, 36, 36, 59, 38, 32, 49, 48, 122, 35, 17, Ascii.EM, 10, 80, 3, 17, Ascii.GS, 0, Ascii.FS, Ascii.NAK, 80, 19, Ascii.US, 5, Ascii.RS, 4, 80, 70, 112, 123, 118, 53, 102, 116, 120, 101, 121, 112, 53, 118, 122, 96, 123, 97, 53, 5, Base64.padSymbol, 63, 38, 38, 51, 50, 118, 38, 37, 37, 62, 118, 55, 34, 57, 59, 118, 126, 48, 55, 63, 58, 51, 50, 118, 34, 57, 118, 51, 46, 34, 36, 55, 53, 34, 118, 35, 35, 63, 50, Byte.MAX_VALUE, 78, 118, 116, 109, 109, 116, 115, 122, Base64.padSymbol, 124, 105, 114, 112, Base64.padSymbol, 106, 116, 105, 117, Base64.padSymbol, 113, 120, 115, 122, 105, 117, Base64.padSymbol, 35, Base64.padSymbol, 47, 44, 41, 42, 41, 37, 46, 43, 41, 42, Base64.padSymbol, 53, 104, 115, 110, 104, 109, 109, 114, 111, 105, 120, 121, 52, 51, 1, 57, 59, 34, 34, 59, 60, 53, 114, 39, 60, 33, 39, 34, 34, Base64.padSymbol, 32, 38, 55, 54, 114, 55, 63, 33, 53, 114, 36, 55, 32, 33, 59, Base64.padSymbol, 60, 104, 114, Ascii.ETB, 44, 39, 58, 50, 39, 33, 54, 39, 38, 98, 47, 45, 45, 52, 98, 32, 45, 58, 108, 92, 103, 108, 113, 121, 108, 106, 125, 108, 109, 41, 103, 108, 110, 104, 125, 96, Byte.MAX_VALUE, 108, 41, Byte.MAX_VALUE, 104, 101, 124, 108, 51, 41, 35, Ascii.CAN, 19, Ascii.SO, 6, 19, Ascii.NAK, 2, 19, Ascii.DC2, 86, 5, Ascii.ETB, Ascii.US, Ascii.EM, 86, 19, Ascii.CAN, 2, 4, Ascii.SI, 86, Ascii.NAK, Ascii.EM, 3, Ascii.CAN, 2, 76, 86, 80, 107, 109, 100, 107, 97, 105, 96, 97, 37, 108, 107, 97, 108, 119, 96, 102, 113, 37, 119, 96, 99, 96, 119, 96, 107, 102, 96, 114, 69, 86, 77, 69, 70, 72, 65, 4, 72, 65, 74, 67, 80, 76, 4, SignedBytes.MAX_POWER_OF_TWO, 65, 87, 71, 86, 77, 84, 80, 77, 75, 74, 4, 77, 74, 4, 87, 67, 84, SignedBytes.MAX_POWER_OF_TWO, 4, 66, 75, 81, 74, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.FF, 81, 74, 87, 81, 84, 84, 75, 86, 80, 65, SignedBytes.MAX_POWER_OF_TWO, Ascii.CR, 102, 119, 119, 107, 110, 100, 102, 115, 110, 104, 105, 40, Byte.MAX_VALUE, 42, 98, 106, 116, 96, 88, 73, 73, 85, 80, 90, 88, 77, 80, 86, 87, Ascii.SYN, 65, Ascii.DC4, 84, 73, Ascii.CR, Ascii.DC4, 79, 77, 77, 52, 32, 49, 60, 58, 122, 52, 54, 97, 72, 87, 90, 91, 81, 17, 86, 91, 72, 93, 126, 97, 108, 109, 103, 39, 101, 120, 60};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Adding Uri for eMsg")
    private void A0H(C07364v c07364v, Uri uri) {
        String str;
        String str2;
        long j;
        long A0U;
        long A0Q;
        if (this.A0J.length == 0) {
            return;
        }
        c07364v.A0f(8);
        if (A0a[3].charAt(19) != 'e') {
            throw new RuntimeException();
        }
        A0a[1] = "i2btDlVidn";
        int A01 = AbstractC1078Iu.A01(c07364v.A0C());
        long j2 = -9223372036854775807L;
        switch (A01) {
            case 0:
                str = (String) AbstractC07133y.A01(c07364v.A0U());
                str2 = (String) AbstractC07133y.A01(c07364v.A0U());
                long A0Q2 = c07364v.A0Q();
                j2 = C5C.A0U(c07364v.A0Q(), 1000000L, A0Q2);
                j = this.A0C != -9223372036854775807L ? this.A0C + j2 : -9223372036854775807L;
                A0U = C5C.A0U(c07364v.A0Q(), 1000L, A0Q2);
                A0Q = c07364v.A0Q();
                break;
            case 1:
                long A0Q3 = c07364v.A0Q();
                j = C5C.A0U(c07364v.A0R(), 1000000L, A0Q3);
                A0U = C5C.A0U(c07364v.A0Q(), 1000L, A0Q3);
                A0Q = c07364v.A0Q();
                str = (String) AbstractC07133y.A01(c07364v.A0U());
                str2 = (String) AbstractC07133y.A01(c07364v.A0U());
                break;
            default:
                AbstractC07214g.A07(A0A(204, 22, 75), A0A(645, 35, 24) + A01);
                return;
        }
        byte[] bArr = new byte[c07364v.A07()];
        c07364v.A0k(bArr, 0, c07364v.A07());
        int i = 0;
        C07364v c07364v2 = new C07364v(this.A0T.A01(new EventMessage(str, str2, A0U, A0Q, bArr)));
        int A07 = c07364v2.A07();
        InterfaceC1036Hd[] interfaceC1036HdArr = this.A0J;
        int length = interfaceC1036HdArr.length;
        int i2 = 0;
        while (i2 < length) {
            InterfaceC1036Hd interfaceC1036Hd = interfaceC1036HdArr[i2];
            c07364v2.A0f(i);
            interfaceC1036Hd.AKf(uri);
            interfaceC1036Hd.AIr(c07364v2, A07);
            i2++;
            i = 0;
        }
        if (j == -9223372036854775807L) {
            this.A0W.addLast(new J9(j2, true, A07));
            this.A03 += A07;
            return;
        }
        if (!this.A0W.isEmpty()) {
            this.A0W.addLast(new J9(j, false, A07));
            this.A03 += A07;
            return;
        }
        if (this.A0R != null) {
            AnonymousClass53 anonymousClass53 = this.A0R;
            if (A0a[1].length() != 3) {
                String[] strArr = A0a;
                strArr[4] = "dSij3ZZr7drragDO7KaW8OWZIZwByPGb";
                strArr[6] = "O4MuDOrrUt3KGtyHElmFzP2mmpN9Ut0I";
                j = anonymousClass53.A05(j);
            } else {
                j = anonymousClass53.A05(j);
            }
        }
        if (this.A0A != -9223372036854775807L && !MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A11)) {
            j = this.A0A;
        }
        InterfaceC1036Hd[] interfaceC1036HdArr2 = this.A0J;
        if (A0a[0].length() != 3) {
            throw new RuntimeException();
        }
        A0a[2] = "lJ55r5gDB38Ao7rNsYIhv4IUy3LH5Ini";
        for (InterfaceC1036Hd interfaceC1036Hd2 : interfaceC1036HdArr2) {
            interfaceC1036Hd2.AIu(j, 1, A07, 0, null);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0R(C2252mE c2252mE, SparseArray<JA> sparseArray, boolean z, int i, byte[] bArr) throws C3K {
        JA A09 = A09(((C2251mD) AbstractC07133y.A01(c2252mE.A07(1952868452))).A00, sparseArray, z);
        if (A09 == null) {
            return;
        }
        JQ jq = A09.A09;
        long j = jq.A05;
        boolean z2 = jq.A09;
        A09.A08();
        A09.A06 = true;
        C2251mD A07 = c2252mE.A07(1952867444);
        if (A07 == null || (i & 2) != 0) {
            jq.A05 = j;
            String[] strArr = A0a;
            if (strArr[4].charAt(20) == strArr[6].charAt(20)) {
                throw new RuntimeException();
            }
            A0a[7] = "mrSj0GzHTHwkPK2z0oCyoB4jTU17nK7M";
            jq.A09 = z2;
        } else {
            jq.A05 = A03(A07.A00);
            jq.A09 = true;
        }
        A0S(c2252mE, A09, i);
        JO jo = A09.A05.A03;
        Object A01 = AbstractC07133y.A01(jq.A06);
        String[] strArr2 = A0a;
        if (strArr2[4].charAt(20) == strArr2[6].charAt(20)) {
            throw new RuntimeException();
        }
        A0a[1] = "vW8YzoDO1k8YQphW8Ysx";
        JP A00 = jo.A00(((J1) A01).A02);
        C2251mD A072 = c2252mE.A07(1935763834);
        if (A072 != null) {
            A0V((JP) AbstractC07133y.A01(A00), A072.A00, jq);
        }
        C2251mD A073 = c2252mE.A07(1935763823);
        if (A073 != null) {
            A0I(A073.A00, jq);
        }
        C2251mD A074 = c2252mE.A07(1936027235);
        if (A074 != null) {
            A0J(A074.A00, jq);
        }
        A0T(c2252mE, A00 != null ? A00.A02 : null, jq);
        int size = c2252mE.A02.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2251mD c2251mD = c2252mE.A02.get(i2);
            if (((AbstractC1078Iu) c2251mD).A00 == 1970628964) {
                A0K(c2251mD.A00, jq, bArr);
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0T(C2252mE c2252mE, String str, JQ jq) throws C3K {
        C07364v c07364v = null;
        C07364v c07364v2 = null;
        for (int i = 0; i < c2252mE.A02.size(); i++) {
            C2251mD c2251mD = c2252mE.A02.get(i);
            C07364v c07364v3 = c2251mD.A00;
            if (((AbstractC1078Iu) c2251mD).A00 == 1935828848) {
                c07364v3.A0f(12);
                if (c07364v3.A0C() == 1936025959) {
                    c07364v = c07364v3;
                }
            } else if (((AbstractC1078Iu) c2251mD).A00 == 1936158820) {
                c07364v3.A0f(12);
                if (c07364v3.A0C() == 1936025959) {
                    c07364v2 = c07364v3;
                }
            }
        }
        if (c07364v == null || c07364v2 == null) {
            return;
        }
        c07364v.A0f(8);
        int A01 = AbstractC1078Iu.A01(c07364v.A0C());
        c07364v.A0g(4);
        if (A01 == 1) {
            c07364v.A0g(4);
        }
        if (c07364v.A0C() != 1) {
            throw C3K.A00(A0A(126, 39, 73));
        }
        c07364v2.A0f(8);
        int A012 = AbstractC1078Iu.A01(c07364v2.A0C());
        c07364v2.A0g(4);
        if (A012 == 1) {
            if (c07364v2.A0Q() == 0) {
                throw C3K.A00(A0A(784, 55, 110));
            }
        } else if (A012 >= 2) {
            c07364v2.A0g(4);
        }
        if (c07364v2.A0Q() != 1) {
            throw C3K.A00(A0A(165, 39, 18));
        }
        c07364v2.A0g(1);
        int A0I = c07364v2.A0I();
        int i2 = (A0I & 240) >> 4;
        int i3 = A0I & 15;
        boolean z = c07364v2.A0I() == 1;
        if (z) {
            int A0I2 = c07364v2.A0I();
            byte[] bArr = new byte[16];
            c07364v2.A0k(bArr, 0, bArr.length);
            byte[] bArr2 = null;
            if (A0I2 == 0) {
                int A0I3 = c07364v2.A0I();
                bArr2 = new byte[A0I3];
                c07364v2.A0k(bArr2, 0, A0I3);
            }
            jq.A08 = true;
            jq.A07 = new JP(z, str, A0I2, bArr, i2, i3, bArr2);
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0V(JP jp, C07364v c07364v, JQ jq) throws C3K {
        int i = jp.A00;
        c07364v.A0f(8);
        if ((AbstractC1078Iu.A00(c07364v.A0C()) & 1) == 1) {
            c07364v.A0g(8);
        }
        int A0I = c07364v.A0I();
        int A0L = c07364v.A0L();
        if (A0L > jq.A00) {
            throw C3K.A01(A0A(EventTypeExtended.EVENT_TYPE_EXTENDED_IMPRESSION_OPPORTUNITY_VALUE, 18, 58) + A0L + A0A(40, 38, 7) + jq.A00, null);
        }
        int i2 = 0;
        if (A0I == 0) {
            boolean[] zArr = jq.A0F;
            if (A0a[1].length() == 3) {
                throw new RuntimeException();
            }
            A0a[0] = "ACu";
            for (int i3 = 0; i3 < A0L; i3++) {
                int A0I2 = c07364v.A0I();
                i2 += A0I2;
                zArr[i3] = A0I2 > i;
            }
        } else {
            i2 = 0 + (A0I * A0L);
            Arrays.fill(jq.A0F, 0, A0L, A0I > i);
        }
        Arrays.fill(jq.A0F, A0L, jq.A00, false);
        if (i2 > 0) {
            jq.A02(i2);
        }
    }

    static {
        A0D();
        A0b = new HD() { // from class: com.facebook.ads.redexgen.X.m8
            @Override // com.instagram.common.viewpoint.core.HD
            public final H9[] A5N() {
                return C2245m7.A0b();
            }

            @Override // com.instagram.common.viewpoint.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
        A0d = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        A0c = new C06802p().A11(A0A(839, 18, 77)).A14();
    }

    public C2245m7() {
        this(0);
    }

    public C2245m7(int i) {
        this(i, null);
    }

    public C2245m7(int i, AnonymousClass53 anonymousClass53) {
        this(i, anonymousClass53, null, Collections.emptyList());
    }

    public C2245m7(int i, AnonymousClass53 anonymousClass53, JO jo, List<C2489qI> list) {
        this(i, anonymousClass53, jo, list, null);
    }

    @MetaExoPlayerCustomization("Additional fields for custom behaviors")
    public C2245m7(int i, AnonymousClass53 anonymousClass53, JO jo, List<C2489qI> list, InterfaceC1036Hd interfaceC1036Hd) {
        this.A0A = -9223372036854775807L;
        this.A0K = i;
        this.A0R = anonymousClass53;
        this.A0U = jo;
        this.A0X = Collections.unmodifiableList(list);
        this.A0S = interfaceC1036Hd;
        this.A0T = new I0();
        this.A0M = new C07364v(16);
        this.A0P = new C07364v(HS.A03);
        this.A0O = new C07364v(5);
        this.A0N = new C07364v();
        this.A0Y = new byte[16];
        this.A0Q = new C07364v(this.A0Y);
        this.A0V = new ArrayDeque<>();
        this.A0W = new ArrayDeque<>();
        this.A0L = new SparseArray<>();
        this.A08 = -9223372036854775807L;
        this.A0B = -9223372036854775807L;
        this.A0C = -9223372036854775807L;
        this.A0E = HA.A00;
        this.A0J = new InterfaceC1036Hd[0];
        this.A0I = new InterfaceC1036Hd[0];
    }

    public static int A00(int i) throws C3K {
        if (i >= 0) {
            return i;
        }
        throw C3K.A01(A0A(IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED, 27, 67) + i, null);
    }

    public static long A02(C07364v c07364v) {
        c07364v.A0f(8);
        int fullAtom = c07364v.A0C();
        return AbstractC1078Iu.A01(fullAtom) == 0 ? c07364v.A0Q() : c07364v.A0R();
    }

    public static long A03(C07364v c07364v) {
        c07364v.A0f(8);
        int fullAtom = c07364v.A0C();
        int version = AbstractC1078Iu.A01(fullAtom);
        return version == 1 ? c07364v.A0R() : c07364v.A0Q();
    }

    public static Pair<Integer, J1> A04(C07364v c07364v) {
        c07364v.A0f(12);
        int defaultSampleDescriptionIndex = c07364v.A0C();
        int trackId = c07364v.A0C();
        int defaultSampleFlags = c07364v.A0C();
        int defaultSampleSize = c07364v.A0C();
        int defaultSampleDuration = c07364v.A0C();
        return Pair.create(Integer.valueOf(defaultSampleDescriptionIndex), new J1(trackId - 1, defaultSampleFlags, defaultSampleSize, defaultSampleDuration));
    }

    public static DrmInitData A06(List<C2251mD> list) {
        ArrayList arrayList = null;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C2251mD c2251mD = list.get(i);
            int leafChildrenSize = ((AbstractC1078Iu) c2251mD).A00;
            if (leafChildrenSize == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] A0l = c2251mD.A00.A0l();
                UUID A02 = JH.A02(A0l);
                if (A02 == null) {
                    AbstractC07214g.A07(A0A(204, 22, 75), A0A(550, 42, 28));
                } else {
                    arrayList.add(new DrmInitData.SchemeData(A02, A0A(897, 9, 66), A0l));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private J1 A07(SparseArray<J1> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (J1) AbstractC07133y.A01(sparseArray.get(i));
    }

    public static JA A08(SparseArray<JA> sparseArray) {
        boolean z;
        boolean z2;
        JA ja = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            JA valueAt = sparseArray.valueAt(i);
            z = valueAt.A06;
            if (z || valueAt.A01 != valueAt.A05.A01) {
                z2 = valueAt.A06;
                if (A0a[7].charAt(28) == 'N') {
                    throw new RuntimeException();
                }
                A0a[2] = "bWFL5LbHycaN2QeAwKakifUxbxentXmn";
                if (!z2 || valueAt.A02 != valueAt.A09.A01) {
                    long nextSampleOffset = valueAt.A05();
                    if (nextSampleOffset < j) {
                        ja = valueAt;
                        j = nextSampleOffset;
                    }
                }
            }
        }
        return ja;
    }

    private void A0B() {
        this.A02 = 0;
        this.A00 = 0;
    }

    /* JADX WARN: Incorrect condition in loop: B:13:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0C() {
        int nextExtraTrackId = 100;
        this.A0J = new InterfaceC1036Hd[2];
        int i = 0;
        if (this.A0S != null) {
            int emsgTrackOutputCount = 0 + 1;
            this.A0J[0] = this.A0S;
            i = emsgTrackOutputCount;
        }
        int nextExtraTrackId2 = this.A0K;
        if ((nextExtraTrackId2 & 4) != 0) {
            int emsgTrackOutputCount2 = i + 1;
            this.A0J[i] = this.A0E.AKS(100, 5);
            i = emsgTrackOutputCount2;
            nextExtraTrackId = 100 + 1;
        }
        this.A0J = (InterfaceC1036Hd[]) C5C.A1I(this.A0J, i);
        for (InterfaceC1036Hd interfaceC1036Hd : this.A0J) {
            interfaceC1036Hd.A6e(A0c);
        }
        int nextExtraTrackId3 = this.A0X.size();
        this.A0I = new InterfaceC1036Hd[nextExtraTrackId3];
        int i2 = 0;
        while (i2 < nextExtraTrackId) {
            int i3 = nextExtraTrackId + 1;
            InterfaceC1036Hd AKS = this.A0E.AKS(nextExtraTrackId, 3);
            AKS.A6e(this.A0X.get(i2));
            this.A0I[i2] = AKS;
            i2++;
            nextExtraTrackId = i3;
        }
    }

    private void A0E(long j) {
        while (!this.A0W.isEmpty()) {
            J9 removeFirst = this.A0W.removeFirst();
            this.A03 -= removeFirst.A00;
            if (A0a[7].charAt(28) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A0a;
            strArr[4] = "VR2FeNKrGWLUx6XQMfWHox9ZNtks2zuu";
            strArr[6] = "s2y9CEVkGFcMGmJDsuNOnRFQ2pMNKAx2";
            long j2 = removeFirst.A01;
            if (removeFirst.A02) {
                j2 += j;
            }
            if (this.A0R != null) {
                j2 = this.A0R.A05(j2);
            }
            for (InterfaceC1036Hd interfaceC1036Hd : this.A0J) {
                interfaceC1036Hd.AIu(j2, 1, removeFirst.A00, this.A03, null);
            }
        }
    }

    private void A0F(long j) throws C3K {
        while (!this.A0V.isEmpty() && this.A0V.peek().A00 == j) {
            A0N(this.A0V.pop());
        }
        A0B();
    }

    public static void A0G(C07364v c07364v, int i, JQ jq) throws C3K {
        c07364v.A0f(i + 8);
        int fullAtom = c07364v.A0C();
        int flags = AbstractC1078Iu.A00(fullAtom);
        int fullAtom2 = flags & 1;
        if (fullAtom2 == 0) {
            int fullAtom3 = flags & 2;
            boolean z = fullAtom3 != 0;
            int sampleCount = c07364v.A0L();
            if (sampleCount == 0) {
                boolean[] zArr = jq.A0F;
                int fullAtom4 = jq.A00;
                Arrays.fill(zArr, 0, fullAtom4, false);
                return;
            }
            int fullAtom5 = jq.A00;
            if (sampleCount == fullAtom5) {
                Arrays.fill(jq.A0F, 0, sampleCount, z);
                int fullAtom6 = c07364v.A07();
                jq.A02(fullAtom6);
                jq.A04(c07364v);
                return;
            }
            StringBuilder append = new StringBuilder().append(A0A(532, 18, 95)).append(sampleCount).append(A0A(0, 40, 98));
            int fullAtom7 = jq.A00;
            throw C3K.A01(append.append(fullAtom7).toString(), null);
        }
        throw C3K.A00(A0A(458, 56, 30));
    }

    public static void A0I(C07364v c07364v, JQ jq) throws C3K {
        c07364v.A0f(8);
        int flags = c07364v.A0C();
        int fullAtom = AbstractC1078Iu.A00(flags) & 1;
        if (fullAtom == 1) {
            c07364v.A0g(8);
        }
        int A0L = c07364v.A0L();
        if (A0L == 1) {
            int entryCount = AbstractC1078Iu.A01(flags);
            jq.A03 += entryCount == 0 ? c07364v.A0Q() : c07364v.A0R();
            return;
        }
        throw C3K.A01(A0A(727, 29, 60) + A0L, null);
    }

    public static void A0J(C07364v c07364v, JQ jq) throws C3K {
        A0G(c07364v, 0, jq);
    }

    public static void A0K(C07364v c07364v, JQ jq, byte[] bArr) throws C3K {
        c07364v.A0f(8);
        c07364v.A0k(bArr, 0, 16);
        if (!Arrays.equals(bArr, A0d)) {
            return;
        }
        A0G(c07364v, 16, jq);
    }

    @MetaExoPlayerCustomization("New parameter for getUri()")
    private void A0L(InterfaceC2280ms interfaceC2280ms) throws IOException {
        int i = ((int) this.A07) - this.A00;
        C07364v c07364v = this.A0D;
        if (c07364v != null) {
            interfaceC2280ms.readFully(c07364v.A0l(), 8, i);
            A0U(new C2251mD(this.A01, c07364v), interfaceC2280ms.A8n(), interfaceC2280ms.A9P());
        } else {
            interfaceC2280ms.AK3(i);
        }
        A0F(interfaceC2280ms.A8n());
    }

    private void A0M(InterfaceC2280ms interfaceC2280ms) throws IOException {
        JA ja = null;
        long j = Long.MAX_VALUE;
        int size = this.A0L.size();
        for (int i = 0; i < size; i++) {
            JA nextTrackBundle = this.A0L.valueAt(i);
            JQ jq = nextTrackBundle.A09;
            if (jq.A0A && jq.A03 < j) {
                j = jq.A03;
                ja = this.A0L.valueAt(i);
            }
        }
        if (ja == null) {
            this.A02 = 3;
            return;
        }
        int A8n = (int) (j - interfaceC2280ms.A8n());
        if (A8n >= 0) {
            interfaceC2280ms.AK3(A8n);
            ja.A09.A05(interfaceC2280ms);
            return;
        }
        throw C3K.A01(A0A(384, 39, 59), null);
    }

    private void A0N(C2252mE c2252mE) throws C3K {
        if (((AbstractC1078Iu) c2252mE).A00 == 1836019574) {
            A0P(c2252mE);
            return;
        }
        if (((AbstractC1078Iu) c2252mE).A00 == 1836019558) {
            A0O(c2252mE);
            return;
        }
        if (this.A0V.isEmpty()) {
            return;
        }
        C2252mE peek = this.A0V.peek();
        if (A0a[1].length() == 3) {
            throw new RuntimeException();
        }
        A0a[5] = "pjYwVuiFyV8fJrHeJXv5AlOqs";
        peek.A08(c2252mE);
    }

    private void A0O(C2252mE c2252mE) throws C3K {
        A0Q(c2252mE, this.A0L, this.A0U != null, this.A0K, this.A0Y);
        DrmInitData A06 = A06(c2252mE.A02);
        if (A06 != null) {
            int i = this.A0L.size();
            for (int trackCount = 0; trackCount < i; trackCount++) {
                this.A0L.valueAt(trackCount).A0B(A06);
            }
        }
        long j = this.A0B;
        if (A0a[5].length() != 30) {
            String[] strArr = A0a;
            strArr[4] = "qdUBZHhFhQeTbxiPtlDH0srS7WoJbCtx";
            strArr[6] = "eg1L367OGrFS41anHFQFHM93YBMqVnGW";
            if (j != -9223372036854775807L) {
                int size = this.A0L.size();
                for (int i2 = 0; i2 < size; i2++) {
                    JA valueAt = this.A0L.valueAt(i2);
                    long j2 = this.A0B;
                    int trackCount2 = A0a[5].length();
                    if (trackCount2 != 30) {
                        A0a[3] = "ExaTttTG7QLu5ZnLvMbeVx0ab4jt6cU8";
                        valueAt.A0A(j2);
                    }
                }
                this.A0B = -9223372036854775807L;
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0P(C2252mE c2252mE) throws C3K {
        AbstractC07133y.A0A(this.A0U == null, A0A(680, 20, 8));
        DrmInitData A06 = A06(c2252mE.A02);
        C2252mE c2252mE2 = (C2252mE) AbstractC07133y.A01(c2252mE.A06(1836475768));
        SparseArray<J1> sparseArray = new SparseArray<>();
        long j = -9223372036854775807L;
        int size = c2252mE2.A02.size();
        for (int i = 0; i < size; i++) {
            C2251mD c2251mD = c2252mE2.A02.get(i);
            if (((AbstractC1078Iu) c2251mD).A00 == 1953654136) {
                Pair<Integer, J1> A04 = A04(c2251mD.A00);
                Object obj = A04.first;
                if (A0a[7].charAt(28) == 'N') {
                    throw new RuntimeException();
                }
                A0a[2] = "1hJqa9Igz9YM2Xn7uSuVVZMPlDpSi7YR";
                sparseArray.put(((Integer) obj).intValue(), (J1) A04.second);
            } else if (((AbstractC1078Iu) c2251mD).A00 == 1835362404) {
                j = A02(c2251mD.A00);
            }
        }
        List<JR> A0O = J0.A0O(c2252mE, new HK(), j, A06, (this.A0K & 16) != 0, false, new InterfaceC2140kO() { // from class: com.facebook.ads.redexgen.X.m9
            @Override // com.instagram.common.viewpoint.core.InterfaceC2140kO
            public final Object A4B(Object obj2) {
                return C2245m7.this.A0c((JO) obj2);
            }
        });
        int size2 = A0O.size();
        if (this.A0L.size() == 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                JR jr = A0O.get(i2);
                JO jo = jr.A03;
                this.A0L.put(jo.A00, new JA(this.A0E.AKS(i2, jo.A03), jr, A07(sparseArray, jo.A00)));
                this.A08 = Math.max(this.A08, jo.A04);
            }
            this.A0E.A6O();
            return;
        }
        AbstractC07133y.A08(this.A0L.size() == size2);
        for (int i3 = 0; i3 < size2; i3++) {
            JR jr2 = A0O.get(i3);
            JO jo2 = jr2.A03;
            this.A0L.get(jo2.A00).A0C(jr2, A07(sparseArray, jo2.A00));
        }
    }

    public static void A0Q(C2252mE c2252mE, SparseArray<JA> sparseArray, boolean z, int i, byte[] bArr) throws C3K {
        int size = c2252mE.A01.size();
        for (int i2 = 0; i2 < size; i2++) {
            C2252mE child = c2252mE.A01.get(i2);
            int i3 = ((AbstractC1078Iu) child).A00;
            if (i3 == 1953653094) {
                A0R(child, sparseArray, z, i, bArr);
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0S(C2252mE c2252mE, JA ja, int i) throws C3K {
        int i2 = 0;
        int leafChildrenSize = 0;
        List<C2251mD> list = c2252mE.A02;
        int i3 = list.size();
        int i4 = 0;
        while (totalSampleCount != 30) {
            A0a[1] = "g5KWW";
            if (i4 < i3) {
                C2251mD c2251mD = list.get(i4);
                int trunCount = ((AbstractC1078Iu) c2251mD).A00;
                if (trunCount == 1953658222) {
                    C07364v c07364v = c2251mD.A00;
                    c07364v.A0f(12);
                    int trunCount2 = c07364v.A0L();
                    if (trunCount2 > 0) {
                        leafChildrenSize += trunCount2;
                        i2++;
                    }
                }
                i4++;
            } else {
                ja.A02 = 0;
                ja.A00 = 0;
                ja.A01 = 0;
                ja.A09.A03(i2, leafChildrenSize);
                int i5 = 0;
                int trunCount3 = 0;
                for (int trunIndex = 0; trunIndex < i3; trunIndex++) {
                    C2251mD c2251mD2 = list.get(trunIndex);
                    int totalSampleCount = ((AbstractC1078Iu) c2251mD2).A00;
                    if (totalSampleCount == 1953658222) {
                        trunCount3 = A01(ja, i5, i, c2251mD2.A00, trunCount3);
                        i5++;
                    }
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    @MetaExoPlayerCustomization("Adding Uri for eMsg")
    private void A0U(C2251mD c2251mD, long j, Uri uri) throws C3K {
        if (!this.A0V.isEmpty()) {
            this.A0V.peek().A09(c2251mD);
            return;
        }
        if (((AbstractC1078Iu) c2251mD).A00 == 1936286840) {
            Pair<Long, C2285my> A05 = A05(c2251mD.A00, j);
            Long l = (Long) A05.first;
            if (A0a[2].charAt(14) == 'D') {
                throw new RuntimeException();
            }
            A0a[2] = "KqHjYmkkmLRftUSzBx7x8q1P7pbSwwaZ";
            this.A0C = l.longValue();
            this.A0E.AJ7((HY) A05.second);
            this.A0G = true;
            return;
        }
        if (((AbstractC1078Iu) c2251mD).A00 != 1701671783 || uri == null) {
            return;
        }
        A0H(c2251mD.A00, uri);
    }

    public static boolean A0W(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005e, code lost:
    
        if (r4 != 1937013298) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0063, code lost:
    
        if (r4 == 1937007471) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        if (r4 == 1668232756) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
    
        if (r4 == 1937011571) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0072, code lost:
    
        if (r4 == 1952867444) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        if (r4 == 1952868452) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        if (r4 == 1953196132) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        if (r4 == 1953654136) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0086, code lost:
    
        if (r4 == 1953658222) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:
    
        if (r4 == 1886614376) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0090, code lost:
    
        if (r4 == 1935763834) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0095, code lost:
    
        if (r4 == 1935763823) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009a, code lost:
    
        if (r4 == 1936027235) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009f, code lost:
    
        if (r4 == 1970628964) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
    
        if (r4 == 1935828848) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a9, code lost:
    
        if (r4 == 1936158820) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ae, code lost:
    
        if (r4 == 1701606260) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b3, code lost:
    
        if (r4 == 1835362404) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
    
        if (r4 != 1701671783) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c5, code lost:
    
        if (r4 != 1937013298) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0X(int i) {
        if (i != 1751411826 && i != 1835296868 && i != 1836476516 && i != 1936286840 && i != 1937011556 && i != 1937011827 && i != 1668576371 && i != 1937011555) {
            if (A0a[1].length() == 3) {
                throw new RuntimeException();
            }
            String[] strArr = A0a;
            strArr[4] = "BwdOpTtZC6qkHbBW6vzemIV3sewTUKel";
            strArr[6] = "oE5SsWuxWmjvJDoIWd7OBauEjDNEKBY0";
            if (i != 1937011578) {
                if (A0a[3].charAt(19) != 'e') {
                    A0a[7] = "alBOnYvVhDOHTU7zpsfhYzjhJlh1j5qj";
                } else {
                    A0a[0] = "AuC";
                }
            }
        }
        return true;
    }

    private boolean A0Y(InterfaceC2280ms interfaceC2280ms) throws IOException {
        int trackCount;
        int i;
        if (this.A00 == 0) {
            C07364v c07364v = this.A0M;
            if (A0a[2].charAt(14) != 'D') {
                A0a[5] = "Du9yMjOrUhZNFJE5GgCY";
                if (!interfaceC2280ms.AHR(c07364v.A0l(), 0, 8, true)) {
                    return false;
                }
                this.A00 = 8;
                this.A0M.A0f(0);
                this.A07 = this.A0M.A0Q();
                int A0C = this.A0M.A0C();
                if (A0a[5].length() != 30) {
                    A0a[0] = "Nk2";
                    this.A01 = A0C;
                }
            }
            throw new RuntimeException();
        }
        if (this.A07 == 1) {
            interfaceC2280ms.readFully(this.A0M.A0l(), 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A07 = this.A0M.A0R();
        } else if (this.A07 == 0) {
            long A8O = interfaceC2280ms.A8O();
            if (A8O == -1 && !this.A0V.isEmpty()) {
                A8O = this.A0V.peek().A00;
            }
            if (A8O != -1) {
                long A8n = A8O - interfaceC2280ms.A8n();
                int trackCount2 = this.A00;
                this.A07 = A8n + trackCount2;
            }
        }
        if (this.A07 >= this.A00) {
            long A8n2 = interfaceC2280ms.A8n() - this.A00;
            if ((this.A01 == 1836019558 || this.A01 == 1835295092) && !this.A0G) {
                this.A0E.AJ7(new C2275mn(this.A08, A8n2));
                this.A0G = true;
            }
            if (this.A01 == 1836019558) {
                SparseArray<JA> sparseArray = this.A0L;
                if (A0a[0].length() != 3) {
                    A0a[7] = "3NdiubR5fLBwA18U1YAUjfhOdAcmjZCx";
                    trackCount = sparseArray.size();
                    i = 0;
                } else {
                    A0a[0] = "3Yh";
                    trackCount = sparseArray.size();
                    i = 0;
                }
                while (i < trackCount) {
                    JQ jq = this.A0L.valueAt(i).A09;
                    jq.A02 = A8n2;
                    jq.A03 = A8n2;
                    jq.A04 = A8n2;
                    i++;
                }
            }
            int trackCount3 = this.A01;
            if (trackCount3 == 1835295092) {
                this.A0F = null;
                this.A09 = this.A07 + A8n2;
                this.A02 = 2;
                return true;
            }
            if (A0W(this.A01)) {
                long A8n3 = (interfaceC2280ms.A8n() + this.A07) - 8;
                this.A0V.push(new C2252mE(this.A01, A8n3));
                if (this.A07 == this.A00) {
                    A0F(A8n3);
                } else {
                    A0B();
                }
            } else if (A0X(this.A01)) {
                if (this.A00 != 8) {
                    throw C3K.A00(A0A(284, 51, 6));
                }
                if (this.A07 <= 2147483647L) {
                    C07364v c07364v2 = new C07364v((int) this.A07);
                    C07364v atomData = this.A0M;
                    System.arraycopy(atomData.A0l(), 0, c07364v2.A0l(), 0, 8);
                    this.A0D = c07364v2;
                    this.A02 = 1;
                } else {
                    throw C3K.A00(A0A(335, 49, 77));
                }
            } else if (this.A07 <= 2147483647L) {
                this.A0D = null;
                this.A02 = 1;
            } else {
                throw C3K.A00(A0A(592, 53, 87));
            }
            return true;
        }
        throw C3K.A00(A0A(78, 48, 36));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        if (r3 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        r19.AK3(r3);
        A0B();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0246, code lost:
    
        throw com.instagram.common.viewpoint.core.C3K.A01(A0A(423, 35, com.vungle.ads.internal.protos.Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (r3 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02b8, code lost:
    
        if (r9.equals(r10) != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02ba, code lost:
    
        r11 = r11 | 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0303, code lost:
    
        if (r9.equals(r10) != false) goto L91;
     */
    @MetaExoPlayerCustomization("Mark text samples as sync frames")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A0Z(InterfaceC2280ms interfaceC2280ms) throws IOException {
        int AIp;
        JA ja = this.A0F;
        Throwable th = null;
        if (ja == null) {
            SparseArray<JA> sparseArray = this.A0L;
            if (A0a[0].length() == 3) {
                A0a[0] = "dJt";
                ja = A08(sparseArray);
                if (ja == null) {
                    int A8n = (int) (this.A09 - interfaceC2280ms.A8n());
                    if (A0a[3].charAt(19) != 'e') {
                        A0a[5] = "OgjcUdmzkFJtvCkNjJUwSL6BC";
                    } else {
                        String[] strArr = A0a;
                        strArr[4] = "drajDSJT48ogOqJP7e4ZIkjylQBmqc38";
                        strArr[6] = "jG2fRwUYgKH0Z3F7iVLG52YSPeKVDlpp";
                    }
                } else {
                    int A05 = (int) (ja.A05() - interfaceC2280ms.A8n());
                    if (A05 < 0) {
                        AbstractC07214g.A07(A0A(204, 22, 75), A0A(Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 40, 13));
                        A05 = 0;
                    }
                    interfaceC2280ms.AK3(A05);
                    this.A0F = ja;
                }
            }
            throw new RuntimeException();
        }
        int i = 4;
        int i2 = 1;
        if (this.A02 == 3) {
            this.A06 = ja.A03();
            if (ja.A01 < ja.A03) {
                interfaceC2280ms.AK3(this.A06);
                ja.A09();
                if (!ja.A0D()) {
                    this.A0F = null;
                }
                this.A02 = 3;
                return true;
            }
            if (ja.A05.A03.A02 == 1) {
                this.A06 -= 8;
                interfaceC2280ms.AK3(8);
            }
            if (A0A(878, 9, 31).equals(ja.A05.A03.A07.A0W)) {
                this.A04 = ja.A04(this.A06, 7);
                AbstractC1027Gu.A07(this.A06, this.A0Q);
                ja.A08.AIr(this.A0Q, 7);
                this.A04 += 7;
            } else {
                this.A04 = ja.A04(this.A06, 0);
            }
            this.A06 += this.A04;
            this.A02 = 4;
            this.A05 = 0;
        }
        JO jo = ja.A05.A03;
        if (A0a[1].length() != 3) {
            A0a[7] = "UjEa6ysv1gVuBQ9NSSQbVZdjDRxN5dgX";
            InterfaceC1036Hd interfaceC1036Hd = ja.A08;
            long A06 = ja.A06();
            if (this.A0R != null) {
                AnonymousClass53 anonymousClass53 = this.A0R;
                if (A0a[7].charAt(28) != 'N') {
                    A0a[2] = "ZxJoJWsimIFBA6WXS2a50b6K01MwI4cU";
                    A06 = anonymousClass53.A05(A06);
                } else {
                    A06 = anonymousClass53.A05(A06);
                }
            }
            if (jo.A01 == 0) {
                while (this.A04 < this.A06) {
                    this.A04 += interfaceC1036Hd.AIp(interfaceC2280ms, this.A06 - this.A04, false);
                }
            } else {
                byte[] A0l = this.A0O.A0l();
                A0l[0] = 0;
                A0l[1] = 0;
                A0l[2] = 0;
                int i3 = jo.A01 + 1;
                int i4 = 4 - jo.A01;
                while (this.A04 < this.A06) {
                    if (this.A05 == 0) {
                        interfaceC2280ms.readFully(A0l, i4, i3);
                        this.A0O.A0f(0);
                        int A0C = this.A0O.A0C();
                        if (A0C >= i2) {
                            this.A05 = A0C - 1;
                            this.A0P.A0f(0);
                            interfaceC1036Hd.AIr(this.A0P, i);
                            interfaceC1036Hd.AIr(this.A0O, i2);
                            if (A0a[5].length() == 30) {
                                throw new RuntimeException();
                            }
                            A0a[7] = "3HbOupLLxbWrXLbfJiyKVwL3oOoB4yeP";
                            this.A0H = this.A0I.length > 0 && HS.A0I(jo.A07.A0W, A0l[i]);
                            this.A04 += 5;
                            this.A06 += i4;
                            i2 = 1;
                        } else {
                            throw C3K.A01(A0A(266, 18, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), th);
                        }
                    } else {
                        if (this.A0H) {
                            this.A0N.A0d(this.A05);
                            interfaceC2280ms.readFully(this.A0N.A0l(), 0, this.A05);
                            interfaceC1036Hd.AIr(this.A0N, this.A05);
                            AIp = this.A05;
                            int A02 = HS.A02(this.A0N.A0l(), this.A0N.A0A());
                            this.A0N.A0f(A0A(887, 10, 116).equals(jo.A07.A0W) ? 1 : 0);
                            this.A0N.A0e(A02);
                            H3.A03(A06, this.A0N, this.A0I);
                        } else {
                            AIp = interfaceC1036Hd.AIp(interfaceC2280ms, this.A05, false);
                        }
                        this.A04 += AIp;
                        this.A05 -= AIp;
                        th = null;
                        i = 4;
                        i2 = 1;
                    }
                }
            }
            int A022 = ja.A02();
            C1034Hb c1034Hb = null;
            JP A07 = ja.A07();
            if (A07 != null) {
                c1034Hb = A07.A01;
            }
            if (!MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A1L) && this.A0F != null) {
                String str = this.A0F.A05.A03.A07.A0W;
                String A0A = A0A(857, 21, 115);
                if (A0a[7].charAt(28) != 'N') {
                    A0a[2] = "aQkaLsEF9G127UYNPtKAhcOp5GPMu7GC";
                }
            }
            long j = A06;
            interfaceC1036Hd.AIu(A06, A022, this.A06, 0, c1034Hb);
            this.A0A = j;
            A0E(j);
            if (!ja.A0D()) {
                if (A0a[3].charAt(19) != 'e') {
                    A0a[2] = "Oznva4TpQIm3xwCXLn5zZ8MtjPilTYJm";
                    this.A0F = null;
                } else {
                    String[] strArr2 = A0a;
                    strArr2[4] = "tQydpv41IRe8SJWpvpJnsmPT1e9HbOAv";
                    strArr2[6] = "ocIdfF7b9GnVk3ZHQkLuHXJpp6hE4I0I";
                    this.A0F = null;
                }
            }
            this.A02 = 3;
            return true;
        }
        throw new RuntimeException();
    }

    public static boolean A0a(JO jo) {
        if (jo.A08 == null || jo.A08.length != 1 || jo.A09 == null) {
            return false;
        }
        if (jo.A08[0] == 0) {
            return true;
        }
        long editListEndMediaTimeUs = C5C.A0U(jo.A08[0] + jo.A09[0], 1000000L, jo.A05);
        if (A0a[2].charAt(14) == 'D') {
            throw new RuntimeException();
        }
        A0a[1] = "wHdUW";
        return editListEndMediaTimeUs >= jo.A04;
    }

    public static /* synthetic */ H9[] A0b() {
        return new H9[]{new C2244m6()};
    }

    public final JO A0c(JO jo) {
        return jo;
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AAC(HA ha) {
        this.A0E = ha;
        A0B();
        A0C();
        if (this.A0U != null) {
            this.A0L.put(0, new JA(ha.AKS(0, this.A0U.A03), new JR(this.A0U, new long[0], new int[0], 0, new long[0], new int[0], 0L), new J1(0, 0, 0, 0)));
            this.A0E.A6O();
        }
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final int AHL(InterfaceC2280ms interfaceC2280ms, HV hv) throws IOException {
        while (true) {
            switch (this.A02) {
                case 0:
                    if (!A0Y(interfaceC2280ms)) {
                        return -1;
                    }
                    break;
                case 1:
                    A0L(interfaceC2280ms);
                    break;
                case 2:
                    A0M(interfaceC2280ms);
                    break;
                default:
                    if (!A0Z(interfaceC2280ms)) {
                        break;
                    } else {
                        return 0;
                    }
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AHb() {
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final void AJ6(long j, long j2) {
        int size = this.A0L.size();
        for (int i = 0; i < size; i++) {
            this.A0L.valueAt(i).A08();
        }
        this.A0W.clear();
        this.A03 = 0;
        this.A0B = j2;
        this.A0V.clear();
        A0B();
    }

    @Override // com.instagram.common.viewpoint.core.H9
    public final boolean AK5(InterfaceC2280ms interfaceC2280ms) throws IOException {
        return JM.A01(interfaceC2280ms);
    }
}
