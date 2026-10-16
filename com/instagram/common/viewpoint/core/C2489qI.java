package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.qI, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2489qI implements AnonymousClass24 {
    public static byte[] A0Z;
    public static String[] A0a = {"V6MXy8T8VWr2uYzGQHXNST8x6mkuL2zq", "NPPhtSRrwFXlj8s5Lf5pJApSSy7nWvZn", "Zwnng2X5IOM1TKGeykh69gCIqoxpb9rN", "EKOvtoarjvrGIuXcg3PsyJc7", "ZiMxAAQ9qCUD5Rc2p4Bdqy2u", "SqcuONG3eBJEqSGEKSqUXXYdrjOnl4qF", "9lDPTqOcDpJIt3QmxvZawHsHRg6Gfk5X", "1hwbvE9Xb2ACzfbNO0itJVr"};
    public static final AnonymousClass23<C2489qI> A0b;
    public static final C2489qI A0c;
    public static final String A0d;
    public static final String A0e;
    public static final String A0f;
    public static final String A0g;
    public static final String A0h;
    public static final String A0i;
    public static final String A0j;
    public static final String A0k;
    public static final String A0l;
    public static final String A0m;
    public static final String A0n;
    public static final String A0o;
    public static final String A0p;
    public static final String A0q;
    public static final String A0r;
    public static final String A0s;
    public static final String A0t;
    public static final String A0u;
    public static final String A0v;
    public static final String A0w;
    public static final String A0x;
    public static final String A0y;
    public static final String A0z;
    public static final String A10;
    public static final String A11;
    public static final String A12;
    public static final String A13;
    public static final String A14;
    public static final String A15;
    public static final String A16;
    public static final String A17;
    public static final String A18;
    public int A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final int A0D;
    public final int A0E;
    public final int A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final int A0L;
    public final long A0M;
    public final ColorInfo A0N;
    public final DrmInitData A0O;
    public final Metadata A0P;
    public final Object A0Q;
    public final String A0R;
    public final String A0S;
    public final String A0T;
    public final String A0U;
    public final String A0V;
    public final String A0W;
    public final List<byte[]> A0X;
    public final byte[] A0Y;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> T A02(T t, T t2) {
        return t != null ? t : t2;
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0Z, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 122);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A0Z = new byte[]{-38, -50, 0, -12, 47, 32, 73, 76, 71, 59, 78, 2, 81, Ascii.GS, 37, -12, -24, 35, Ascii.US};
    }

    static {
        A05();
        A0c = new C06802p().A14();
        A0p = C5C.A0h(0);
        A0r = C5C.A0h(1);
        A0s = C5C.A0h(2);
        A13 = C5C.A0h(3);
        A0z = C5C.A0h(4);
        A0e = C5C.A0h(5);
        A0w = C5C.A0h(6);
        A0g = C5C.A0h(7);
        A0u = C5C.A0h(8);
        A0i = C5C.A0h(9);
        A11 = C5C.A0h(10);
        A0t = C5C.A0h(11);
        A0q = C5C.A0h(12);
        A0k = C5C.A0h(13);
        A15 = C5C.A0h(14);
        A18 = C5C.A0h(15);
        A0o = C5C.A0h(16);
        A0n = C5C.A0h(17);
        A10 = C5C.A0h(18);
        A0x = C5C.A0h(19);
        A0y = C5C.A0h(20);
        A14 = C5C.A0h(21);
        A0h = C5C.A0h(22);
        A0f = C5C.A0h(23);
        A12 = C5C.A0h(24);
        A0v = C5C.A0h(25);
        A0l = C5C.A0h(26);
        A0m = C5C.A0h(27);
        A0d = C5C.A0h(28);
        A0j = C5C.A0h(29);
        A16 = C5C.A0h(30);
        A17 = C5C.A0h(31);
        A0b = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qJ
            @Override // com.instagram.common.viewpoint.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                C2489qI A00;
                A00 = C2489qI.A00(bundle);
                return A00;
            }
        };
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Language is not normalized")
    public C2489qI(C06802p c06802p) {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        int i4;
        String str4;
        Metadata metadata;
        Object obj;
        String str5;
        String str6;
        int i5;
        List list;
        DrmInitData drmInitData;
        long j;
        int i6;
        int i7;
        float f;
        int i8;
        float f2;
        byte[] bArr;
        int i9;
        ColorInfo colorInfo;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        String str7;
        str = c06802p.A0R;
        this.A0T = str;
        str2 = c06802p.A0S;
        this.A0U = str2;
        if (MetaExoPlayerUpgradeConfig.A03(EnumC2089jX.A0k)) {
            str7 = c06802p.A0T;
            this.A0V = C5C.A0k(str7);
        } else {
            str3 = c06802p.A0T;
            this.A0V = str3;
        }
        i = c06802p.A0F;
        this.A0H = i;
        i2 = c06802p.A0C;
        this.A0E = i2;
        i3 = c06802p.A03;
        this.A04 = i3;
        i4 = c06802p.A0B;
        this.A0D = i4;
        this.A05 = this.A0D != -1 ? this.A0D : this.A04;
        str4 = c06802p.A0P;
        this.A0R = str4;
        metadata = c06802p.A0N;
        this.A0P = metadata;
        obj = c06802p.A0O;
        this.A0Q = obj;
        str5 = c06802p.A0Q;
        this.A0S = str5;
        str6 = c06802p.A0U;
        this.A0W = str6;
        i5 = c06802p.A09;
        this.A0B = i5;
        list = c06802p.A0V;
        this.A0X = list == null ? Collections.emptyList() : c06802p.A0V;
        drmInitData = c06802p.A0M;
        this.A0O = drmInitData;
        j = c06802p.A0K;
        this.A0M = j;
        i6 = c06802p.A0J;
        this.A0L = i6;
        i7 = c06802p.A08;
        this.A0A = i7;
        f = c06802p.A00;
        this.A01 = f;
        i8 = c06802p.A0D;
        this.A0F = i8 == -1 ? 0 : c06802p.A0D;
        f2 = c06802p.A01;
        this.A02 = f2 == -1.0f ? 1.0f : c06802p.A01;
        bArr = c06802p.A0W;
        this.A0Y = bArr;
        i9 = c06802p.A0G;
        this.A0I = i9;
        colorInfo = c06802p.A0L;
        this.A0N = colorInfo;
        i10 = c06802p.A04;
        this.A06 = i10;
        i11 = c06802p.A0E;
        this.A0G = i11;
        i12 = c06802p.A0A;
        this.A0C = i12;
        i13 = c06802p.A06;
        this.A08 = i13 == -1 ? 0 : c06802p.A06;
        i14 = c06802p.A07;
        this.A09 = i14 != -1 ? c06802p.A07 : 0;
        i15 = c06802p.A02;
        this.A03 = i15;
        i16 = c06802p.A0H;
        this.A0J = i16;
        i17 = c06802p.A0I;
        this.A0K = i17;
        i18 = c06802p.A05;
        if (i18 != 0 || this.A0O == null) {
            i19 = c06802p.A05;
            this.A07 = i19;
        } else {
            this.A07 = 1;
        }
    }

    public static C2489qI A00(Bundle bundle) {
        C06802p c06802p = new C06802p();
        AnonymousClass44.A02(bundle);
        c06802p.A0y((String) A02(bundle.getString(A0p), A0c.A0T)).A0z((String) A02(bundle.getString(A0r), A0c.A0U)).A10((String) A02(bundle.getString(A0s), A0c.A0V)).A0n(bundle.getInt(A13, A0c.A0H)).A0k(bundle.getInt(A0z, A0c.A0E)).A0a(bundle.getInt(A0e, A0c.A04)).A0j(bundle.getInt(A0w, A0c.A0D)).A0w((String) A02(bundle.getString(A0g), A0c.A0R)).A0v((Metadata) A02((Metadata) bundle.getParcelable(A0u), A0c.A0P)).A0x((String) A02(bundle.getString(A0i), A0c.A0S)).A11((String) A02(bundle.getString(A11), A0c.A0W)).A0h(bundle.getInt(A0t, A0c.A0B));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(A03(i));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i++;
        }
        c06802p.A12(arrayList).A0u((DrmInitData) bundle.getParcelable(A0k)).A0s(bundle.getLong(A15, A0c.A0M)).A0r(bundle.getInt(A18, A0c.A0L)).A0f(bundle.getInt(A0o, A0c.A0A)).A0X(bundle.getFloat(A0n, A0c.A01)).A0l(bundle.getInt(A10, A0c.A0F)).A0Y(bundle.getFloat(A0x, A0c.A02)).A13(bundle.getByteArray(A0y)).A0o(bundle.getInt(A14, A0c.A0I));
        Bundle bundle2 = bundle.getBundle(A0h);
        if (bundle2 != null) {
            ColorInfo A6f = ColorInfo.A08.A6f(bundle2);
            String[] strArr = A0a;
            if (strArr[0].charAt(2) == strArr[2].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0a;
            strArr2[0] = "Hj6q80mEs2TaNtyFDcR9WAdUhRzKpc2R";
            strArr2[2] = "QNxytj5q4fkMiXjNnIzm1WM2l3yCLldD";
            c06802p.A0t(A6f);
        }
        c06802p.A0b(bundle.getInt(A0f, A0c.A06)).A0m(bundle.getInt(A12, A0c.A0G)).A0i(bundle.getInt(A0v, A0c.A0C)).A0d(bundle.getInt(A0l, A0c.A08)).A0e(bundle.getInt(A0m, A0c.A09)).A0Z(bundle.getInt(A0d, A0c.A03)).A0p(bundle.getInt(A16, A0c.A0J)).A0q(bundle.getInt(A17, A0c.A0K)).A0c(bundle.getInt(A0j, A0c.A07));
        return c06802p.A14();
    }

    public static String A03(int i) {
        return A0q + A04(18, 1, 70) + Integer.toString(i, 36);
    }

    public final int A06() {
        if (this.A0L == -1) {
            return -1;
        }
        int i = this.A0A;
        if (A0a[6].charAt(1) != 'l') {
            throw new RuntimeException();
        }
        A0a[7] = "26nMyN52vPpNzMdMA433IJJ";
        if (i == -1) {
            return -1;
        }
        return this.A0A * this.A0L;
    }

    public final C06802p A07() {
        return new C06802p(this);
    }

    public final C2489qI A08(int i) {
        return A07().A0c(i).A14();
    }

    @Deprecated
    public final C2489qI A09(DrmInitData drmInitData) {
        return A07().A0u(drmInitData).A14();
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0017 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A0A(C2489qI c2489qI) {
        if (this.A0X.size() != c2489qI.A0X.size()) {
            return false;
        }
        for (int i = 0; i < i; i++) {
            if (!Arrays.equals(this.A0X.get(i), c2489qI.A0X.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00fe, code lost:
    
        if (r3 != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0100, code lost:
    
        r3 = com.instagram.common.viewpoint.core.C5C.A1E(r6.A0W, r7.A0W);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0113, code lost:
    
        if (com.instagram.common.viewpoint.core.C2489qI.A0a[7].length() == 23) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0115, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C2489qI.A0a;
        r2[5] = "7ZwCaC2vMYJJrC5vSvijmVTemVnn4Sby";
        r2[1] = "7UklpW8WsZGkqbUQfANf7z94bQwnEZcP";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0121, code lost:
    
        if (r3 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012b, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r6.A0V, r7.A0V) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0135, code lost:
    
        if (java.util.Arrays.equals(r6.A0Y, r7.A0Y) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x013f, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r6.A0P, r7.A0P) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0141, code lost:
    
        r3 = r6.A0N;
        r2 = com.instagram.common.viewpoint.core.C2489qI.A0a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0155, code lost:
    
        if (r2[5].charAt(27) == r2[1].charAt(27)) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0179, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C2489qI.A0a;
        r2[0] = "urAfMcmX6a9OGM37lXvKAx1rZiPgX6ke";
        r2[2] = "a4vLaNQZdGnZx0xGeF61X6h0zX5Eit9g";
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018b, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r3, r7.A0N) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0195, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r6.A0O, r7.A0O) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x019b, code lost:
    
        if (A0A(r7) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a5, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r6.A0Q, r7.A0Q) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0159, code lost:
    
        r2 = com.instagram.common.viewpoint.core.C2489qI.A0a;
        r2[3] = "vKf0Bvu4u38h4hfjS2f6FEBD";
        r2[4] = "OdKyjmg05VE7Ony73IF4GzhY";
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0165, code lost:
    
        if (r3 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0174, code lost:
    
        if (r3 != false) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2489qI c2489qI = (C2489qI) obj;
        if ((this.A00 == 0 || c2489qI.A00 == 0 || this.A00 == c2489qI.A00) && this.A0H == c2489qI.A0H && this.A0E == c2489qI.A0E && this.A04 == c2489qI.A04) {
            int i = this.A0D;
            int i2 = c2489qI.A0D;
            String[] strArr = A0a;
            if (strArr[3].length() == strArr[4].length()) {
                A0a[6] = "jlfxIixvC9PiZTWMdSrmDOSa0xGb4nh5";
                if (i == i2 && this.A0B == c2489qI.A0B && this.A0M == c2489qI.A0M && this.A0L == c2489qI.A0L && this.A0A == c2489qI.A0A && this.A0F == c2489qI.A0F && this.A0I == c2489qI.A0I && this.A06 == c2489qI.A06 && this.A0G == c2489qI.A0G && this.A0C == c2489qI.A0C && this.A08 == c2489qI.A08 && this.A09 == c2489qI.A09 && this.A03 == c2489qI.A03 && this.A0J == c2489qI.A0J && this.A0K == c2489qI.A0K && this.A07 == c2489qI.A07 && Float.compare(this.A01, c2489qI.A01) == 0 && Float.compare(this.A02, c2489qI.A02) == 0 && C5C.A1E(this.A0T, c2489qI.A0T) && C5C.A1E(this.A0U, c2489qI.A0U) && C5C.A1E(this.A0R, c2489qI.A0R)) {
                    boolean A1E = C5C.A1E(this.A0S, c2489qI.A0S);
                    if (A0a[6].charAt(1) == 'l') {
                        String[] strArr2 = A0a;
                        strArr2[3] = "KdcHRf6dcCFTttKMl2Gj0X4Z";
                        strArr2[4] = "JmF49wuzlqjC0ZeQQsbCJHl9";
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        if (this.A00 == 0) {
            int i = 17 * 31;
            int result = this.A0T == null ? 0 : this.A0T.hashCode();
            int result2 = (((i + result) * 31) + (this.A0U != null ? this.A0U.hashCode() : 0)) * 31;
            int result3 = this.A0V == null ? 0 : this.A0V.hashCode();
            int result4 = (((result2 + result3) * 31) + this.A0H) * 31;
            int result5 = this.A0E;
            int result6 = (((result4 + result5) * 31) + this.A04) * 31;
            int result7 = this.A0D;
            int i2 = (result6 + result7) * 31;
            if (this.A0R == null) {
                hashCode = 0;
            } else {
                String str = this.A0R;
                String[] strArr = A0a;
                if (strArr[0].charAt(2) == strArr[2].charAt(2)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0a;
                strArr2[3] = "TXy1YAbF7Qkyl7ROldsNtIji";
                strArr2[4] = "lt4q3TmvSSK0Q54eRVJBBfw2";
                hashCode = str.hashCode();
            }
            int result8 = (i2 + hashCode) * 31;
            int result9 = this.A0P == null ? 0 : this.A0P.hashCode();
            int result10 = (((result8 + result9) * 31) + (this.A0Q == null ? 0 : this.A0Q.hashCode())) * 31;
            int result11 = this.A0S == null ? 0 : this.A0S.hashCode();
            int result12 = (result10 + result11) * 31;
            int hashCode2 = this.A0W != null ? this.A0W.hashCode() : 0;
            int result13 = this.A0B;
            int result14 = (((((result12 + hashCode2) * 31) + result13) * 31) + ((int) this.A0M)) * 31;
            int result15 = this.A0L;
            int result16 = (((result14 + result15) * 31) + this.A0A) * 31;
            int result17 = Float.floatToIntBits(this.A01);
            int result18 = (((result16 + result17) * 31) + this.A0F) * 31;
            int result19 = Float.floatToIntBits(this.A02);
            int result20 = (((result18 + result19) * 31) + this.A0I) * 31;
            int result21 = this.A06;
            int result22 = (((result20 + result21) * 31) + this.A0G) * 31;
            int result23 = this.A0C;
            int result24 = (((result22 + result23) * 31) + this.A08) * 31;
            int result25 = this.A09;
            int result26 = (((result24 + result25) * 31) + this.A03) * 31;
            int result27 = this.A0J;
            int result28 = (((result26 + result27) * 31) + this.A0K) * 31;
            int result29 = this.A07;
            this.A00 = result28 + result29;
        }
        return this.A00;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder().append(A04(5, 7, 96)).append(this.A0T);
        String A04 = A04(0, 2, 52);
        return append.append(A04).append(this.A0U).append(A04).append(this.A0S).append(A04).append(this.A0W).append(A04).append(this.A0R).append(A04).append(this.A05).append(A04).append(this.A0V).append(A04(2, 3, 90)).append(this.A0L).append(A04).append(this.A0A).append(A04).append(this.A01).append(A04(14, 4, 78)).append(this.A06).append(A04).append(this.A0G).append(A04(12, 2, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE)).toString();
    }
}
