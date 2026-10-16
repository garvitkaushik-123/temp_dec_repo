package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.9h, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08469h extends AbstractC2300nD {
    public static byte[] A07;
    public static String[] A08 = {"yr7s5jzv1addyUjDczkFmKgb3TbXTjPI", "k5bxDF12X7IfueMvpCyLhsS14secbcRr", "A1nn9z9SPvnfAziOnMuSk0GZzxZ0jVfY", "Bn8GSVMc2Ww3cTp6j1ZQIVGuo4fvIYJ3", "KOSGSA", "kbDMqlVGuQuF7sZpY9G1V32bVqx23m", "bfxskyCfRQ3e5JfVyMYK1TBq", "KPf5jweXKATwb3ocWNu711OjnnCWcsTU"};
    public static final AbstractC2491qK<Integer> A09;
    public static final AbstractC2491qK<Integer> A0A;
    public C2495qQ A00;
    public C08479i A01;
    public C0961Ef A02;
    public final Context A03;
    public final InterfaceC0968Em A04;
    public final Object A05;
    public final boolean A06;

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c7, code lost:
    
        if (r18.A01.A0A == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cd, code lost:
    
        if (r7.isEmpty() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d5, code lost:
    
        if (r7.size() != r10.A01) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d7, code lost:
    
        r6.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e7, code lost:
    
        if (com.instagram.common.viewpoint.core.C08469h.A08[1].charAt(16) == 'p') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e9, code lost:
    
        com.instagram.common.viewpoint.core.C08469h.A08[4] = "67hsDi";
        r6.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f3, code lost:
    
        r14.addAll(r6);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fa, code lost:
    
        com.instagram.common.viewpoint.core.C08469h.A08[4] = "yJ8LwG";
        r6.add(r7);
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("D25277746")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T extends AbstractC0963Eh<T>> Pair<C0967El, Integer> A0A(int i, C0970Eo c0970Eo, int[][][] iArr, InterfaceC0962Eg<T> interfaceC0962Eg, Comparator<List<T>> comparator) {
        List arrayList;
        ArrayList arrayList2 = new ArrayList();
        int A02 = c0970Eo.A02();
        for (int i2 = 0; i2 < A02; i2++) {
            if (i == c0970Eo.A03(i2)) {
                C2319nW A072 = c0970Eo.A07(i2);
                int i3 = 0;
                while (i3 < A072.A01) {
                    C2452pg A05 = A072.A05(i3);
                    List<T> A5F = interfaceC0962Eg.A5F(i2, A05, iArr[i2][i3]);
                    boolean[] zArr = new boolean[A05.A01];
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    int i4 = 0;
                    while (true) {
                        int i5 = A05.A01;
                        if (A08[4].length() != 6) {
                            throw new RuntimeException();
                        }
                        A08[7] = "GGTbcpljDMs4NAqJNauGpoXnSvHOQ6AN";
                        if (i4 >= i5) {
                            break;
                        }
                        T t = A5F.get(i4);
                        int A082 = t.A08();
                        if (!zArr[i4] && A082 != 0) {
                            if (A082 == 1) {
                                arrayList = BP.A04(t);
                                arrayList3.add(t);
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(t);
                                int i6 = i4 + 1;
                                while (i6 < A05.A01) {
                                    T t2 = A5F.get(i6);
                                    if (t2.A08() == 2 && t.A09(t2)) {
                                        arrayList.add(t2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    if (A08[1].charAt(16) == 'p') {
                                        A08[7] = "CPvHWQWYEszLaRsxiIiXKw3X1jOClslA";
                                    }
                                }
                            }
                            arrayList4.add(arrayList);
                        }
                        i4++;
                    }
                }
            }
        }
        boolean isEmpty = arrayList2.isEmpty();
        if (A08[1].charAt(16) != 'p') {
            throw new RuntimeException();
        }
        A08[4] = "ji0WxR";
        if (isEmpty) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr2[i7] = ((AbstractC0963Eh) list.get(i7)).A01;
        }
        AbstractC0963Eh abstractC0963Eh = (AbstractC0963Eh) list.get(0);
        return Pair.create(new C0967El(abstractC0963Eh.A03, iArr2), Integer.valueOf(abstractC0963Eh.A00));
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A08[5].length() == 27) {
                throw new RuntimeException();
            }
            A08[4] = "58VoVy";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 10);
            i4++;
        }
    }

    public static void A0M() {
        A07 = new byte[]{91, 92, -112, Byte.MAX_VALUE, -124, -118, 59, 126, -125, 124, -119, -119, Byte.MIN_VALUE, -121, 59, 126, -118, -112, -119, -113, 59, 126, -118, -119, -114, -113, -115, 124, -124, -119, -113, -114, 59, 126, 124, -119, -119, -118, -113, 59, 125, Byte.MIN_VALUE, 59, 124, -117, -117, -121, -124, Byte.MIN_VALUE, Byte.MAX_VALUE, 59, -110, -124, -113, -125, -118, -112, -113, 59, -115, Byte.MIN_VALUE, -127, Byte.MIN_VALUE, -115, Byte.MIN_VALUE, -119, 126, Byte.MIN_VALUE, 59, -113, -118, 59, 94, -118, -119, -113, Byte.MIN_VALUE, -109, -113, 73, 59, 93, -112, -124, -121, Byte.MAX_VALUE, 59, -113, -125, Byte.MIN_VALUE, 59, -113, -115, 124, 126, -122, 59, -114, Byte.MIN_VALUE, -121, Byte.MIN_VALUE, 126, -113, -118, -115, 59, -124, -119, -114, -113, 124, -119, 126, Byte.MIN_VALUE, 59, -110, -124, -113, -125, 59, -118, -119, Byte.MIN_VALUE, 59, -118, -127, 59, -113, -125, Byte.MIN_VALUE, 59, -119, -118, -119, 72, Byte.MAX_VALUE, Byte.MIN_VALUE, -117, -115, Byte.MIN_VALUE, 126, 124, -113, Byte.MIN_VALUE, Byte.MAX_VALUE, 59, 126, -118, -119, -114, -113, -115, -112, 126, -113, -118, -115, -114, 59, -113, -125, 124, -113, 59, -113, 124, -122, Byte.MIN_VALUE, 59, 124, 59, 94, -118, -119, -113, Byte.MIN_VALUE, -109, -113, 59, 124, -115, -126, -112, -120, Byte.MIN_VALUE, -119, -113, 73, -103, -70, -69, -74, -54, -63, -55, -87, -57, -74, -72, -64, -88, -70, -63, -70, -72, -55, -60, -57, -57, -37, -54, -49, -43, -107, -57, -55, -103, -83, -63, -80, -75, -69, 123, -83, -81, Byte.MIN_VALUE, -49, -29, -46, -41, -35, -99, -45, -49, -47, -95, -70, -50, -67, -62, -56, -120, -66, -70, -68, -116, -122, -61, -56, -68, -54, -61, -71, -119, 124, 119, 120, -126, 66, 116, -119, 67, 68, -98, -111, -116, -115, -105, 87, -119, -98, -117, -33, -46, -51, -50, -40, -104, -51, -40, -43, -53, -30, -106, -33, -46, -36, -46, -40, -41, -92, -105, -110, -109, -99, 93, -106, -109, -92, -111, -11, -24, -29, -28, -18, -82, -9, -84, -11, -19, -29, -83, -18, -19, -79, -83, -11, -17, -72};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0N(C2319nW c2319nW, C2448pc c2448pc, Map<Integer, C2450pe> map) {
        C2450pe c2450pe;
        for (int i = 0; i < c2319nW.A01; i++) {
            C2450pe c2450pe2 = c2448pc.A0G.get(c2319nW.A05(i));
            if (c2450pe2 != null && ((c2450pe = map.get(Integer.valueOf(c2450pe2.A01()))) == null || (c2450pe.A01.isEmpty() && !c2450pe2.A01.isEmpty()))) {
                map.put(Integer.valueOf(c2450pe2.A01()), c2450pe2);
            }
        }
    }

    static {
        A0M();
        A09 = AbstractC2491qK.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.EZ
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C08469h.A05((Integer) obj, (Integer) obj2);
            }
        });
        A0A = AbstractC2491qK.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.Ea
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C08469h.A06((Integer) obj, (Integer) obj2);
            }
        });
    }

    @Deprecated
    public C08469h() {
        this(C08479i.A0J, new C2314nR());
    }

    @MetaExoPlayerCustomization(type = {"NEW_CONSTRUCTOR"}, value = "Backward Compatible Constructor")
    public C08469h(InterfaceC0968Em interfaceC0968Em) {
        this(C08479i.A0J, interfaceC0968Em);
    }

    @Deprecated
    public C08469h(C2448pc c2448pc, InterfaceC0968Em interfaceC0968Em) {
        this(c2448pc, interfaceC0968Em, null);
    }

    public C08469h(C2448pc c2448pc, InterfaceC0968Em interfaceC0968Em, Context context) {
        this.A05 = new Object();
        this.A03 = context != null ? context.getApplicationContext() : null;
        this.A04 = interfaceC0968Em;
        if (c2448pc instanceof C08479i) {
            this.A01 = (C08479i) c2448pc;
        } else {
            C08479i defaultParameters = context == null ? C08479i.A0J : C08479i.A02(context);
            this.A01 = defaultParameters.A0P().A0u(c2448pc).A0p();
        }
        this.A00 = C2495qQ.A07;
        this.A06 = context != null && C5C.A18(context);
        if (!this.A06 && context != null && C5C.A02 >= 32) {
            this.A02 = C0961Ef.A00(context);
        }
        if (this.A01.A08 && context == null) {
            AbstractC07214g.A07(A0J(188, 20, 75), A0J(1, 187, 17));
        }
    }

    public static int A00(int i, int i2) {
        if (i != 0 && i == i2) {
            return Integer.MAX_VALUE;
        }
        return Integer.bitCount(i & i2);
    }

    public static int A02(C2489qI c2489qI, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = c2489qI.A0V;
            String[] strArr = A08;
            if (strArr[6].length() != strArr[3].length()) {
                A08[7] = "utaRfuDCbQDIc6IM3a2tNPgwwhECnGgZ";
                if (str.equals(str2)) {
                    if (A08[4].length() != 6) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A08;
                    strArr2[6] = "bdPum8qTTDlHeCQDHcvgSGFt";
                    strArr2[3] = "zx28NE7Z14W3AzzAuoWnzSjL1M2eUdTs";
                    return 4;
                }
            }
            throw new RuntimeException();
        }
        String A0K = A0K(str);
        String A0K2 = A0K(c2489qI.A0V);
        if (A0K2 == null || A0K == null) {
            return (z && A0K2 == null) ? 1 : 0;
        }
        if (A0K2.startsWith(A0K) || A0K.startsWith(A0K2)) {
            return 3;
        }
        String A0J = A0J(0, 1, 36);
        String str3 = C5C.A1P(A0K2, A0J)[0];
        String formatMainLanguage = C5C.A1P(A0K, A0J)[0];
        String[] strArr3 = A08;
        String str4 = strArr3[6];
        String formatLanguage = strArr3[3];
        if (str4.length() != formatLanguage.length()) {
            A08[4] = "rXSrCW";
            if (!str3.equals(formatMainLanguage)) {
                return 0;
            }
            return 2;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x000e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(C2452pg c2452pg, int i, int i2, boolean z) {
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        int i3 = Integer.MAX_VALUE;
        for (int videoPixels = 0; videoPixels < maxVideoPixelsToRetain; videoPixels++) {
            C2489qI A082 = c2452pg.A08(videoPixels);
            int maxVideoPixelsToRetain = A082.A0L;
            if (maxVideoPixelsToRetain > 0) {
                int maxVideoPixelsToRetain2 = A082.A0A;
                if (maxVideoPixelsToRetain2 > 0) {
                    int i4 = A082.A0L;
                    int maxVideoPixelsToRetain3 = A082.A0A;
                    Point A092 = A09(z, i, i2, i4, maxVideoPixelsToRetain3);
                    int i5 = A082.A0L;
                    int maxVideoPixelsToRetain4 = A082.A0A;
                    int i6 = i5 * maxVideoPixelsToRetain4;
                    int i7 = A082.A0L;
                    int maxVideoPixelsToRetain5 = A092.x;
                    if (i7 >= ((int) (maxVideoPixelsToRetain5 * 0.98f))) {
                        int i8 = A082.A0A;
                        int maxVideoPixelsToRetain6 = A092.y;
                        if (i8 >= ((int) (maxVideoPixelsToRetain6 * 0.98f)) && i6 < i3) {
                            i3 = i6;
                        }
                    }
                }
            }
        }
        return i3;
    }

    public static /* synthetic */ int A05(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        int intValue = num.intValue();
        int intValue2 = num2.intValue();
        if (A08[4].length() != 6) {
            throw new RuntimeException();
        }
        A08[1] = "gB7bm57sTKDjvfC8pNahT9wGVNX6TDKL";
        return intValue - intValue2;
    }

    public static /* synthetic */ int A06(Integer num, Integer num2) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A07(String str) {
        char c;
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals(A0J(272, 18, 95))) {
                    c = 0;
                    switch (c) {
                        case 0:
                            return 5;
                        case 1:
                            return 4;
                        case 2:
                            return 3;
                        case 3:
                            return 2;
                        case 4:
                            return 1;
                        default:
                            return 0;
                    }
                }
                c = 65535;
                switch (c) {
                }
            case -1662735862:
                String[] strArr = A08;
                if (strArr[6].length() == strArr[3].length()) {
                    throw new RuntimeException();
                }
                A08[1] = "cKYBOGEqW486lDdcpu93NQ9TicEen6vk";
                if (str.equals(A0J(253, 10, 9))) {
                    c = 1;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case -1662541442:
                if (str.equals(A0J(290, 10, 36))) {
                    c = 2;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 1331836730:
                if (str.equals(A0J(263, 9, 30))) {
                    c = 4;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 1599127257:
                if (str.equals(A0J(300, 19, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                    c = 3;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            default:
                c = 65535;
                switch (c) {
                }
        }
    }

    @MetaExoPlayerCustomization("Made public in D13395849")
    public static Point A09(boolean z, int tempViewportWidth, int i, int i2, int i3) {
        if (z) {
            if ((i2 > i3) != (tempViewportWidth > i)) {
                tempViewportWidth = i;
                i = tempViewportWidth;
            }
        }
        if (i2 * i >= i3 * tempViewportWidth) {
            return new Point(tempViewportWidth, C5C.A05(tempViewportWidth * i3, i2));
        }
        return new Point(C5C.A05(i * i2, i3), i);
    }

    private final Pair<C0967El, Integer> A0B(C0970Eo c0970Eo, int[][][] iArr, final C08479i c08479i, final String str) throws AD {
        return A0A(3, c0970Eo, iArr, new InterfaceC0962Eg() { // from class: com.facebook.ads.redexgen.X.nN
            @Override // com.instagram.common.viewpoint.core.InterfaceC0962Eg
            public final List A5F(int i, C2452pg c2452pg, int[] iArr2) {
                BP A02;
                A02 = C2303nG.A02(i, c2452pg, C08479i.this, iArr2, str);
                return A02;
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EY
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2303nG.A01((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<C0967El, Integer> A0C(C0970Eo c0970Eo, int[][][] iArr, int[] iArr2, final C08479i c08479i) throws AD {
        final boolean z = false;
        int i = 0;
        while (true) {
            if (i < c0970Eo.A02()) {
                if (2 == c0970Eo.A03(i) && c0970Eo.A07(i).A01 > 0) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return A0A(1, c0970Eo, iArr, new InterfaceC0962Eg() { // from class: com.facebook.ads.redexgen.X.nO
            @Override // com.instagram.common.viewpoint.core.InterfaceC0962Eg
            public final List A5F(int i2, C2452pg c2452pg, int[] iArr3) {
                return C08469h.this.A0e(c08479i, z, i2, c2452pg, iArr3);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EX
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2309nM.A02((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<C0967El, Integer> A0D(C0970Eo c0970Eo, int[][][] iArr, final int[] iArr2, final C08479i c08479i, final String str) throws AD {
        return A0A(2, c0970Eo, iArr, new InterfaceC0962Eg() { // from class: com.facebook.ads.redexgen.X.nQ
            @Override // com.instagram.common.viewpoint.core.InterfaceC0962Eg
            public final List A5F(int i, C2452pg c2452pg, int[] iArr3) {
                BP A06;
                A06 = C2302nF.A06(i, c2452pg, C08479i.this, iArr3, str, iArr2[i]);
                return A06;
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.EW
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C2302nF.A05((List) obj, (List) obj2);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
    
        r5 = r5 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final C0967El A0E(int i, C2319nW c2319nW, int[][] iArr, C08479i c08479i) throws AD {
        C2452pg c2452pg = null;
        int i2 = 0;
        C0958Ec c0958Ec = null;
        int i3 = 0;
        loop0: while (i3 < c2319nW.A01) {
            C2452pg trackGroup = c2319nW.A05(i3);
            int[] iArr2 = iArr[i3];
            int groupIndex = 0;
            while (true) {
                int i4 = trackGroup.A01;
                int selectedTrackIndex = A08[7].charAt(4);
                if (selectedTrackIndex == 114) {
                    break loop0;
                }
                A08[7] = "eXe48tlcaaFOVphj3tBJsJZ33XViaUIe";
                if (groupIndex < i4) {
                    int i5 = iArr2[groupIndex];
                    int selectedTrackIndex2 = A08[7].charAt(4);
                    if (selectedTrackIndex2 == 114) {
                        throw new RuntimeException();
                    }
                    A08[7] = "FFBXZuvHsKfXoft1igGzNsuMgLJqlaBK";
                    if (A0S(i5, c08479i.A0B)) {
                        C0958Ec trackScore = new C0958Ec(trackGroup.A08(groupIndex), iArr2[groupIndex]);
                        if (c0958Ec != null) {
                            int compareTo = trackScore.compareTo(c0958Ec);
                            String[] strArr = A08;
                            String str = strArr[0];
                            String str2 = strArr[2];
                            int selectedTrackIndex3 = str.charAt(9);
                            if (selectedTrackIndex3 == str2.charAt(9)) {
                                break loop0;
                            }
                            A08[1] = "us6BKPnONaHSk6j2pgBHNNPTLKUclzqr";
                            if (compareTo <= 0) {
                            }
                        }
                        c2452pg = trackGroup;
                        i2 = groupIndex;
                        c0958Ec = trackScore;
                    }
                    groupIndex++;
                }
            }
            throw new RuntimeException();
        }
        if (c2452pg == null) {
            return null;
        }
        return new C0967El(c2452pg, i2);
    }

    public static String A0K(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, A0J(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 3, 75))) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        boolean z;
        synchronized (this.A05) {
            z = this.A01.A08 && !this.A06 && C5C.A02 >= 32 && this.A02 != null && this.A02.A06();
        }
        if (z) {
            A01();
        }
    }

    public static void A0P(C0970Eo c0970Eo, C2448pc c2448pc, C0967El[] c0967ElArr) {
        C0967El c0967El;
        int A02 = c0970Eo.A02();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < A02; i++) {
            A0N(c0970Eo.A07(i), c2448pc, hashMap);
        }
        A0N(c0970Eo.A06(), c2448pc, hashMap);
        for (int i2 = 0; i2 < A02; i2++) {
            int rendererCount = c0970Eo.A03(i2);
            C2450pe c2450pe = (C2450pe) hashMap.get(Integer.valueOf(rendererCount));
            if (c2450pe != null) {
                boolean isEmpty = c2450pe.A01.isEmpty();
                if (A08[7].charAt(4) == 'r') {
                    throw new RuntimeException();
                }
                A08[4] = "YbaSeo";
                if (!isEmpty && c0970Eo.A07(i2).A04(c2450pe.A00) != -1) {
                    c0967El = new C0967El(c2450pe.A00, AbstractC0873As.A0B(c2450pe.A01));
                } else {
                    c0967El = null;
                }
                c0967ElArr[i2] = c0967El;
            }
        }
    }

    public static void A0Q(C0970Eo c0970Eo, C08479i c08479i, C0967El[] c0967ElArr) {
        C0967El c0967El;
        int A02 = c0970Eo.A02();
        for (int i = 0; i < A02; i++) {
            C2319nW A072 = c0970Eo.A07(i);
            if (c08479i.A0S(i, A072)) {
                C2304nH A0Q = c08479i.A0Q(i, A072);
                String[] strArr = A08;
                String str = strArr[6];
                String str2 = strArr[3];
                int rendererIndex = str.length();
                int rendererCount = str2.length();
                if (rendererIndex == rendererCount) {
                    throw new RuntimeException();
                }
                A08[5] = "K8f1XF422sl3cXXm";
                if (A0Q != null) {
                    int length = A0Q.A03.length;
                    String[] strArr2 = A08;
                    String str3 = strArr2[6];
                    String str4 = strArr2[3];
                    int rendererIndex2 = str3.length();
                    int rendererCount2 = str4.length();
                    if (rendererIndex2 == rendererCount2) {
                        throw new RuntimeException();
                    }
                    A08[4] = "KnBpd5";
                    if (length != 0) {
                        int rendererCount3 = A0Q.A00;
                        C2452pg A05 = A072.A05(rendererCount3);
                        int[] iArr = A0Q.A03;
                        int rendererIndex3 = A0Q.A02;
                        c0967El = new C0967El(A05, iArr, rendererIndex3);
                        c0967ElArr[i] = c0967El;
                    }
                }
                c0967El = null;
                c0967ElArr[i] = c0967El;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0049, code lost:
    
        if (r4 != 2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r3 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
    
        if (A0W(r12[r7], r11.A07(r7), r3) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r4 != 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (r9 == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
    
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0072, code lost:
    
        if (r8 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0074, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0088, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0082, code lost:
    
        if (r4 != 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
    
        if (r4 != 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0R(C0970Eo c0970Eo, int[][][] iArr, C08117s[] c08117sArr, InterfaceC2301nE[] interfaceC2301nEArr) {
        int i = -1;
        int i2 = -1;
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = c0970Eo.A02();
            int tunnelingVideoRendererIndex = A08[4].length();
            if (tunnelingVideoRendererIndex == 6) {
                A08[1] = "NZY9D9dgjYLNZ0XYpF4W2GrX5uVEwVhV";
                if (i4 >= i5) {
                    break;
                }
                int rendererType = c0970Eo.A03(i4);
                InterfaceC2301nE interfaceC2301nE = interfaceC2301nEArr[i4];
                String[] strArr = A08;
                String str = strArr[0];
                String str2 = strArr[2];
                int tunnelingVideoRendererIndex2 = str.charAt(9);
                int tunnelingAudioRendererIndex = str2.charAt(9);
                if (tunnelingVideoRendererIndex2 != tunnelingAudioRendererIndex) {
                    A08[4] = "nPMicF";
                } else {
                    String[] strArr2 = A08;
                    strArr2[6] = "5F5ko3NIDU1YMXmZZUDVXdSE";
                    strArr2[3] = "1c60xx4jFCOb1nSxKeVAoj10cRAS07b7";
                }
            } else {
                throw new RuntimeException();
            }
            i4++;
        }
        int tunnelingAudioRendererIndex2 = (i == -1 || i2 == -1) ? 0 : 1;
        if ((i3 & tunnelingAudioRendererIndex2) != 0) {
            C08117s c08117s = new C08117s(true);
            c08117sArr[i] = c08117s;
            c08117sArr[i2] = c08117s;
        }
    }

    @MetaExoPlayerCustomization("Made public for customization on DashManifestHelper")
    public static boolean A0S(int i, boolean z) {
        int A03 = AbstractC08017i.A03(i);
        return A03 == 4 || (z && A03 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0T(C2489qI c2489qI) {
        boolean z;
        synchronized (this.A05) {
            z = !this.A01.A08 || this.A06 || c2489qI.A06 <= 2 || (A0U(c2489qI) && (C5C.A02 < 32 || this.A02 == null || !this.A02.A06())) || (C5C.A02 >= 32 && this.A02 != null && this.A02.A06() && this.A02.A04() && this.A02.A05() && this.A02.A07(this.A00, c2489qI));
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean A0U(C2489qI c2489qI) {
        char c;
        if (c2489qI.A0W == null) {
            return false;
        }
        String str = c2489qI.A0W;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(A0J(236, 14, 79))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals(A0J(208, 9, 92))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (str.equals(A0J(Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE, 9, 66))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals(A0J(Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, 10, 100))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
        }
        return false;
    }

    public static boolean A0W(int[][] iArr, C2319nW c2319nW, InterfaceC2301nE interfaceC2301nE) {
        if (interfaceC2301nE == null) {
            return false;
        }
        int A04 = c2319nW.A04(interfaceC2301nE.A9L());
        for (int i = 0; i < interfaceC2301nE.length(); i++) {
            int trackGroupIndex = AbstractC08017i.A05(iArr[A04][interfaceC2301nE.A8H(i)]);
            if (trackGroupIndex != 32) {
                return false;
            }
        }
        return true;
    }

    private final C0967El[] A0X(C0970Eo c0970Eo, int[][][] iArr, int[] iArr2, C08479i c08479i) throws AD {
        String str;
        int A02 = c0970Eo.A02();
        C0967El[] c0967ElArr = new C0967El[A02];
        Pair<C0967El, Integer> A0C = A0C(c0970Eo, iArr, iArr2, c08479i);
        if (A0C != null) {
            Object obj = A0C.second;
            String[] strArr = A08;
            String str2 = strArr[0];
            String str3 = strArr[2];
            int charAt = str2.charAt(9);
            int rendererCount = str3.charAt(9);
            if (charAt == rendererCount) {
                throw new RuntimeException();
            }
            A08[7] = "yBKbxgl1qoYBYNtasAVV61g1RQWhRN9O";
            c0967ElArr[((Integer) obj).intValue()] = (C0967El) A0C.first;
        }
        if (A0C == null) {
            str = null;
        } else {
            C2452pg c2452pg = ((C0967El) A0C.first).A01;
            int rendererCount2 = ((C0967El) A0C.first).A02[0];
            str = c2452pg.A08(rendererCount2).A0V;
        }
        Pair<C0967El, Integer> A0D = A0D(c0970Eo, iArr, iArr2, c08479i, str);
        if (A0D != null) {
            c0967ElArr[((Integer) A0D.second).intValue()] = (C0967El) A0D.first;
        }
        Pair<C0967El, Integer> A0B = A0B(c0970Eo, iArr, c08479i, str);
        if (A0B != null) {
            c0967ElArr[((Integer) A0B.second).intValue()] = (C0967El) A0B.first;
        }
        for (int i = 0; i < A02; i++) {
            int i2 = c0970Eo.A03(i);
            if (i2 != 2 && i2 != 1) {
                String[] strArr2 = A08;
                String str4 = strArr2[0];
                String str5 = strArr2[2];
                int charAt2 = str4.charAt(9);
                int rendererCount3 = str5.charAt(9);
                if (charAt2 == rendererCount3) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A08;
                strArr3[6] = "1xsmyE1OdjkvrsbXr4cEFZBV";
                strArr3[3] = "D4xPicyrc2caIP01Cw6NBhV2pRXBVsmG";
                if (i2 != 3) {
                    c0967ElArr[i] = A0E(i2, c0970Eo.A07(i), iArr[i], c08479i);
                }
            }
        }
        return c0967ElArr;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0978Ew
    public final boolean A0Y() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2300nD
    @MetaExoPlayerCustomization(type = {"MERGED"}, value = "final removed in D35162315")
    public final Pair<C08117s[], InterfaceC2301nE[]> A0d(C0970Eo c0970Eo, int[][][] iArr, int[] iArr2, C2337no c2337no, Timeline timeline) throws AD {
        C08479i c08479i;
        synchronized (this.A05) {
            try {
                c08479i = this.A01;
                if (c08479i.A08 && C5C.A02 >= 32 && this.A02 != null) {
                    this.A02.A03(this, (Looper) AbstractC07133y.A02(Looper.myLooper()));
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        int A02 = c0970Eo.A02();
        C0967El[] A0X = A0X(c0970Eo, iArr, iArr2, c08479i);
        A0P(c0970Eo, c08479i, A0X);
        A0Q(c0970Eo, c08479i, A0X);
        for (int rendererCount = 0; rendererCount < A02; rendererCount++) {
            int A03 = c0970Eo.A03(rendererCount);
            if (c08479i.A0R(rendererCount) || c08479i.A0H.contains(Integer.valueOf(A03))) {
                A0X[rendererCount] = null;
            }
        }
        InterfaceC2301nE[] A5b = this.A04.A5b(A0X, A00(), c2337no, timeline);
        C08117s[] c08117sArr = new C08117s[A02];
        for (int i = 0; i < A02; i++) {
            c08117sArr[i] = !(c08479i.A0R(i) || c08479i.A0H.contains(Integer.valueOf(c0970Eo.A03(i)))) && (c0970Eo.A03(i) == -2 || A5b[i] != null) ? C08117s.A01 : null;
        }
        if (c08479i.A0D) {
            A0R(c0970Eo, iArr, c08117sArr, A5b);
        }
        return Pair.create(c08117sArr, A5b);
    }

    public final /* synthetic */ BP A0e(C08479i c08479i, boolean z, int i, C2452pg c2452pg, int[] iArr) {
        return C2309nM.A03(i, c2452pg, c08479i, iArr, z, new InterfaceC2160kj() { // from class: com.facebook.ads.redexgen.X.nP
            @Override // com.instagram.common.viewpoint.core.InterfaceC2160kj
            public final boolean A4C(Object obj) {
                boolean A0T;
                A0T = C08469h.this.A0T((C2489qI) obj);
                return A0T;
            }
        });
    }
}
