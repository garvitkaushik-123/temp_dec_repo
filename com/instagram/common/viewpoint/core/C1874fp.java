package com.instagram.common.viewpoint.core;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.explorestack.protobuf.openrtb.LossReason;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.fp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1874fp {
    public static byte[] A0G;
    public static String[] A0H = {"YuGvtiviQVR", "ZhJp0z4dUN", "YWv4zGcwogafSGFsXYmLIXL4tbjSTGT", "UM7SABu2ufM", "2gPy2hJr9M", "yZRmnvTn4zHntgpYIACfXRb3ExDVKnv", "qUSRIBeTtwG", "WSvVNugGHbUgKJE0aBRLXmETVgvdQ"};
    public static final String A0I;
    public int A00;
    public int A01;
    public int A02;
    public long A03;

    @Nullable
    public AbstractRunnableC1416Wc A04;
    public C1875fq A05;
    public Map<String, Integer> A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final Handler A0B;
    public final View A0C;
    public final C1929gi A0D;
    public final WeakReference<AbstractC1873fo> A0E;
    public final boolean A0F;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static int A08(Vector<Rect> vector) {
        int size = vector.size();
        int[] iArr = new int[size * 2];
        int[] iArr2 = new int[size * 2];
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, size * 2, size * 2);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Rect elementAt = vector.elementAt(i3);
            int i4 = i + 1;
            iArr[i] = elementAt.left;
            int i5 = i2 + 1;
            iArr2[i2] = elementAt.bottom;
            i = i4 + 1;
            iArr[i4] = elementAt.right;
            i2 = i5 + 1;
            iArr2[i5] = elementAt.top;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        for (int i6 = 0; i6 < size; i6++) {
            Rect elementAt2 = vector.elementAt(i6);
            int A09 = A09(iArr, elementAt2.left);
            int A092 = A09(iArr, elementAt2.right);
            int A093 = A09(iArr2, elementAt2.top);
            int A094 = A09(iArr2, elementAt2.bottom);
            for (int i7 = A09 + 1; i7 <= A092; i7++) {
                for (int i8 = A093 + 1; i8 <= A094; i8++) {
                    zArr[i7][i8] = true;
                }
            }
        }
        int i9 = 0;
        for (int i10 = 0; i10 < size * 2; i10++) {
            for (int i11 = 0; i11 < size * 2; i11++) {
                i9 += zArr[i10][i11] ? (iArr[i10] - iArr[i10 - 1]) * (iArr2[i11] - iArr2[i11 - 1]) : 0;
            }
        }
        return i9;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0097, code lost:
    
        if (r5 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0099, code lost:
    
        A0N(r7, false, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00a3, code lost:
    
        return new com.instagram.common.viewpoint.core.C1875fq(com.instagram.common.viewpoint.core.EnumC1153Lr.A0G);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b0, code lost:
    
        if (r5 == false) goto L26;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1875fq A0E(View view, int i, C1929gi c1929gi) {
        if (view == null) {
            A0N(null, false, A0H(353, 16, 29));
            return new C1875fq(EnumC1153Lr.A07);
        }
        boolean A2p = C1379Up.A2p(c1929gi);
        String A0H2 = A0H(TTAdConstant.VIDEO_COVER_URL_CODE, 37, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        String A0H3 = A0H(331, 22, 75);
        if (A2p) {
            if (view.getParent() == null) {
                A0N(view, false, A0H3);
                return new C1875fq(EnumC1153Lr.A0J);
            }
            boolean isShown = view.isShown();
            if (A0H[0].length() != 13) {
                A0H[7] = "NobRvy4BnU";
                if (!isShown) {
                    A0N(view, false, A0H2);
                    return new C1875fq(EnumC1153Lr.A0M);
                }
            }
            throw new RuntimeException();
        }
        if (view.getParent() == null) {
            A0N(view, false, A0H3);
            return new C1875fq(EnumC1153Lr.A0G);
        }
        boolean isShown2 = view.isShown();
        if (A0H[7].length() != 13) {
            String[] strArr = A0H;
            strArr[5] = "nxs5ab5SCgIt1bjehrDOKVWzL3WZqz6";
            strArr[2] = "N9sY316uyLP0an2AsgJKvtC5gTj4eyT";
        } else {
            String[] strArr2 = A0H;
            strArr2[4] = "ovG54rbub0";
            strArr2[1] = "3miU82oxKB";
        }
        throw new RuntimeException();
        if (view.getWindowVisibility() != 0) {
            A0N(view, false, A0H(528, 37, 21));
            return new C1875fq(EnumC1153Lr.A0H);
        }
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            A0N(view, false, A0H(295, 36, 112) + view.getMeasuredWidth() + A0H(27, 4, 111) + view.getMeasuredHeight());
            return new C1875fq(EnumC1153Lr.A0F);
        }
        if (A00(view) < 0.9f) {
            A0N(view, false, A0H(369, 27, 28));
            return new C1875fq(EnumC1153Lr.A0A);
        }
        view.getWidth();
        if (A0H[7].length() == 13) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0H;
        strArr3[4] = "P7geMBqOxp";
        strArr3[1] = "ZGWxjrEaaX";
        view.getHeight();
        try {
            view.getLocationOnScreen(new int[2]);
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                return new C1875fq(EnumC1153Lr.A06);
            }
            ((WindowManager) c1929gi.getSystemService(A0H(594, 6, 49))).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
            Vector<Rect> A0K = A0K(view);
            int A08 = A08(A0K);
            A0K.add(rect);
            float A082 = ((A08(A0K) - A08) * 1.0f) / (view.getMeasuredHeight() * view.getMeasuredWidth());
            float A01 = A01(i, view) / 100.0f;
            if (A082 < A01) {
                A0N(view, false, String.format(Locale.US, A0H(452, 76, 31), Float.valueOf(A082), Float.valueOf(A01)));
                return new C1875fq(EnumC1153Lr.A03, A082);
            }
            if (!YV.A03(c1929gi)) {
                A0N(view, false, A0H(185, 26, 71));
                return new C1875fq(EnumC1153Lr.A0K, A082);
            }
            Map<String, String> A012 = YW.A01(c1929gi);
            if (A0H[7].length() != 13) {
                String[] strArr4 = A0H;
                strArr4[5] = "sQwWKNIdgBJp7INTLhe6QLI2apd14ri";
                strArr4[2] = "vGnZQNYUuNvmxvdOgK7IRlYHvBLdShR";
                if (YC.A04(A012)) {
                    A0N(view, false, A0H(156, 29, 89));
                    return new C1875fq(EnumC1153Lr.A09, A082);
                }
                if (C1379Up.A26(c1929gi) && YC.A03(A012)) {
                    A0N(view, false, A0H(31, 31, 29));
                    return new C1875fq(EnumC1153Lr.A04, A082, A012);
                }
                A0N(view, true, A0H(396, 19, 48));
                return new C1875fq(EnumC1153Lr.A0I, A082, A012);
            }
            throw new RuntimeException();
        } catch (NullPointerException unused) {
            A0N(view, false, A0H(62, 30, 103));
            return new C1875fq(EnumC1153Lr.A0F);
        }
    }

    public static String A0H(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 32);
        }
        return new String(copyOfRange);
    }

    public static void A0M() {
        A0G = new byte[]{110, 118, 115, 124, Byte.MAX_VALUE, -76, 115, 115, 119, 110, -73, -63, 110, -121, -34, -48, -37, -49, -121, -39, -52, -56, -38, -42, -43, -95, -121, -69, -81, -9, -52, 126, -95, 93, -90, -80, 93, -84, -85, 93, -79, -84, -83, 93, -84, -93, 93, -79, -91, -94, 93, -119, -84, -96, -88, -80, -96, -81, -94, -94, -85, 107, -54, -24, -11, -11, -10, -5, -89, -18, -20, -5, -89, -13, -10, -22, -24, -5, -16, -10, -11, -89, -10, -11, -89, -6, -22, -7, -20, -20, -11, -75, -46, -3, -13, 1, -4, -75, 2, -82, -5, -17, -7, -13, -82, 1, -13, -4, 1, -13, -82, 2, -3, -82, 1, -13, 2, -82, -15, -10, -13, -15, -7, -82, -9, -4, 2, -13, 0, 4, -17, -6, -82, -12, -3, 0, -82, -4, -3, -4, -69, 0, -13, -2, -13, -17, 2, -82, -15, -10, -13, -15, -7, -13, 0, -68, -60, -34, -14, -32, -18, -38, -21, -35, -103, -30, -20, -103, -24, -37, -20, -19, -21, -18, -36, -19, -30, -25, -32, -103, -17, -30, -34, -16, -89, -70, -54, -39, -52, -52, -43, -121, -48, -38, -121, -43, -42, -37, -121, -48, -43, -37, -52, -39, -56, -54, -37, -48, -35, -52, -107, -120, -100, -103, 84, -88, -99, -105, -97, -103, -90, 84, -105, -107, -94, -94, -93, -88, 84, -106, -103, 84, -94, -103, -101, -107, -88, -99, -86, -103, -103, -84, -88, -70, 99, -16, -4, -6, -69, -13, -18, -16, -14, -17, -4, -4, -8, -69, -18, -15, 0, -69, -10, -5, 1, -14, -1, -5, -18, -7, -69, 3, -10, -14, 4, -69, -45, 2, -7, -7, -32, -16, -1, -14, -14, -5, -50, -15, -31, -4, -4, -7, -17, -18, -1, -3, -47, -12, -26, -7, -11, 7, -80, -8, -15, 3, -80, -7, -2, 6, -7, 3, -7, -14, -4, -11, -80, -12, -7, -3, -11, -2, 3, -7, -1, -2, 3, -80, -72, 7, -51, -40, -84, -49, -63, -44, -48, -30, -117, -45, -52, -34, -117, -39, -38, -117, -37, -52, -35, -48, -39, -33, -103, -86, 126, -95, -109, -90, -94, -76, 93, -90, -80, 93, -85, -78, -87, -87, 107, -87, 125, -96, -110, -91, -95, -77, 92, -91, -81, 92, -80, -85, -85, 92, -80, -82, -99, -86, -81, -84, -99, -82, -95, -86, -80, 106, -67, -111, -76, -90, -71, -75, -57, 112, -71, -61, 112, -58, -71, -61, -71, -78, -68, -75, 126, 10, -34, 1, -13, 6, 2, Ascii.DC4, -67, Ascii.CR, -2, Ascii.SI, 2, Ascii.VT, 17, -67, 6, Ascii.DLE, -67, Ascii.VT, Ascii.FF, 17, -67, Ascii.DLE, 2, 17, -67, 17, Ascii.FF, -67, -13, -26, -16, -26, -33, -23, -30, -53, -84, Byte.MIN_VALUE, -93, -107, -88, -92, -74, 95, -75, -88, -78, -88, -95, -85, -92, 95, -96, -79, -92, -96, 95, -88, -78, 95, -77, -82, -82, 95, -78, -84, -96, -85, -85, 95, -102, 100, 109, 113, -91, 100, 100, 95, -75, -88, -78, -88, -95, -85, -92, 107, 95, -94, -76, -79, -79, -92, -83, -77, 95, -77, -89, -79, -92, -78, -89, -82, -85, -93, 95, 100, 109, 113, -91, 100, 100, -100, -94, 118, -103, -117, -98, -102, -84, 85, -84, -98, -93, -103, -92, -84, 85, -98, -88, 85, -93, -92, -87, 85, -88, -102, -87, 85, -87, -92, 85, -117, 126, -120, 126, 119, -127, 122, 99, -110, -109, -104, 68, -102, -115, -119, -101, -123, -122, -112, -119, -32, -46, -96, -109, -113, -95, -117, -116, -106, -113, -13, -19, Ascii.NAK, 17, 2, -93, -95, -56, -70, -65, -75, -64, -56};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final synchronized String A0R() {
        return EnumC1153Lr.values()[this.A05.A01()].toString() + String.format(Locale.US, A0H(0, 9, 46), Float.valueOf(this.A05.A00() * 100.0f));
    }

    static {
        A0M();
        A0I = C1874fp.class.getSimpleName();
    }

    public C1874fp(View view, int i, int i2, boolean z, WeakReference<AbstractC1873fo> weakReference, C1929gi c1929gi) {
        this.A0B = new Handler();
        this.A01 = 0;
        this.A02 = 1000;
        this.A08 = true;
        this.A05 = new C1875fq(EnumC1153Lr.A0L);
        this.A06 = new HashMap();
        this.A03 = 0L;
        this.A00 = 0;
        this.A07 = true;
        this.A0D = c1929gi;
        this.A0C = view;
        if (this.A0C.getId() == -1) {
            YB.A0K(this.A0C);
        }
        this.A0A = i;
        this.A0E = weakReference;
        this.A0F = z;
        if (i2 < 0) {
            if (BuildConfigApi.isDebug()) {
                Log.w(A0I, A0H(LossReason.LOSS_REASON_CREATIVE_FILTERED_ANIMATION_TOO_LONG_VALUE, 29, 20));
            }
            i2 = 0;
        }
        this.A09 = i2;
    }

    public C1874fp(View view, int i, WeakReference<AbstractC1873fo> weakReference, C1929gi c1929gi) {
        this(view, i, 0, false, weakReference, c1929gi);
    }

    public C1874fp(View view, int i, boolean z, WeakReference<AbstractC1873fo> weakReference, C1929gi c1929gi) {
        this(view, i, 0, z, weakReference, c1929gi);
    }

    public static float A00(View view) {
        float alpha = view.getAlpha();
        while (view.getParent() instanceof ViewGroup) {
            view = (View) view.getParent();
            float alpha2 = view.getAlpha();
            if (alpha2 < 0.0f) {
                alpha2 = 0.0f;
            }
            if (alpha2 > 1.0f) {
                alpha2 = 1.0f;
            }
            alpha *= alpha2;
        }
        return alpha;
    }

    public static int A01(int i, View view) {
        int width = view.getWidth() * view.getHeight();
        float onePixelPercentage = width > 0 ? 100.0f / width : 100.0f;
        int viewArea = (int) Math.max(i, Math.ceil(onePixelPercentage));
        return viewArea;
    }

    public static /* synthetic */ int A05(C1874fp c1874fp) {
        int i = c1874fp.A00;
        c1874fp.A00 = i + 1;
        return i;
    }

    public static int A09(int[] iArr, int i) {
        int i2 = 0;
        int mid = iArr.length;
        while (i2 < mid) {
            int low = mid - i2;
            int high = (low / 2) + i2;
            int low2 = iArr[high];
            if (low2 == i) {
                return high;
            }
            int low3 = iArr[high];
            if (low3 > i) {
                mid = high;
            } else {
                i2 = high + 1;
            }
        }
        return -1;
    }

    public static Vector<Rect> A0K(View view) {
        Vector<Rect> vector = new Vector<>();
        if (!(view.getParent() instanceof ViewGroup)) {
            return vector;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        for (int indexOfChild = viewGroup.indexOfChild(view) + 1; indexOfChild < viewGroup.getChildCount(); indexOfChild++) {
            View childAt = viewGroup.getChildAt(indexOfChild);
            if (A0H[0].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A0H;
            strArr[5] = "k1JcZ1wpbQO9ikEolBidSsMChjYk4Sl";
            strArr[2] = "tjbQFFO1F8PkdaxFL56rw4qlI30x63G";
            int childIndex = 1;
            boolean z = !(childAt instanceof C1777eF);
            if ((childAt instanceof C1077It) && AbstractC1876fr.A00(childAt)) {
                childIndex = 0;
            }
            if (z && childIndex != 0) {
                Vector<Rect> rectVector = A0L(childAt);
                vector.addAll(rectVector);
            }
        }
        Vector<Rect> rectVector2 = A0K(viewGroup);
        vector.addAll(rectVector2);
        return vector;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Vector<Rect> A0L(View view) {
        boolean isTransparentToolbar;
        Rect rect;
        Vector<Rect> vector = new Vector<>();
        if (!view.isShown() || view.getAlpha() <= 0.0f) {
            return vector;
        }
        if (view.getClass().getName().equals(A0H(245, 50, 109))) {
            Drawable background = view.getBackground();
            if (A0H[0].length() == 13) {
                throw new RuntimeException();
            }
            A0H[7] = "wSIkE0lymuYwIsZPrnhj";
            if (background != null && (view.getBackground() instanceof GradientDrawable)) {
                isTransparentToolbar = true;
                if (!(view instanceof ViewGroup) && (AbstractC1876fr.A00(view) || isTransparentToolbar)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        Vector<Rect> visibleRectInView = A0L(viewGroup.getChildAt(i));
                        vector.addAll(visibleRectInView);
                    }
                    return vector;
                }
                rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    vector.add(rect);
                }
                return vector;
            }
        }
        isTransparentToolbar = false;
        if (!(view instanceof ViewGroup)) {
        }
        rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
        }
        return vector;
    }

    public static void A0N(View view, boolean z, String str) {
        if (BuildConfigApi.isDebug()) {
            String str2 = A0H(240, 5, 35) + view + A0H(9, 4, 46) + (z ? A0H(579, 8, 10) : A0H(565, 12, 4)) + A0H(13, 14, 71) + str;
        }
    }

    public final synchronized Map<String, String> A0S() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put(A0H(589, 3, 127), String.valueOf(this.A05.A01()));
        hashMap.put(A0H(587, 2, 93), String.valueOf(this.A05.A00()));
        hashMap.put(A0H(577, 2, 74), new JSONObject(this.A06).toString());
        hashMap.put(A0H(592, 2, 13), Y1.A06(this.A03));
        Map<String, String> viewabilityData = this.A05.A03();
        hashMap.putAll(viewabilityData);
        return hashMap;
    }

    public final synchronized void A0T() {
        this.A05 = new C1875fq(EnumC1153Lr.A0L);
    }

    public final synchronized void A0U() {
        if (this.A04 != null) {
            A0V();
        }
        if (this.A07) {
            this.A0D.A0F().A3s();
        }
        this.A04 = new C06742j(this, this.A0D);
        this.A0B.postDelayed(this.A04, this.A01);
        this.A08 = false;
        this.A00 = 0;
        this.A05 = new C1875fq(EnumC1153Lr.A0L);
        this.A06 = new HashMap();
    }

    public final synchronized void A0V() {
        if (this.A07) {
            this.A0D.A0F().A3t();
        }
        this.A0B.removeCallbacks(this.A04);
        this.A04 = null;
        this.A08 = true;
        this.A00 = 0;
    }

    public final void A0W(int i) {
        this.A01 = i;
    }

    public final void A0X(int i) {
        if (BuildConfigApi.isDebug() && !this.A0F) {
            Log.w(A0I, A0H(92, 64, 110));
        }
        this.A02 = i;
    }

    public final void A0Y(boolean z) {
        this.A07 = z;
    }

    public final synchronized boolean A0Z() {
        return this.A08;
    }
}
