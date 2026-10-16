package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdClosedListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class UK implements Ad, NativeAdBaseApi, Repairable, InterfaceC1398Vi {
    public static C1335Sx A0o;
    public static byte[] A0p;
    public static String[] A0q = {"0QrYY16WpsBKaBkyPEA33iBIoR05UhVT", "YnnsFrkLVth43aFbA8XanJ7Af1ELV", "Oxqa2FUUnPLQ7GUfsty3Y0efzjvyqNtk", "SIKP4BEcnF1kam64buW5uj4ZKlEjFxDR", "vEVPI6RQ4lovzpZyrpWOxFDddvUHwWNp", "NGWOmnzpb", "djSS0JJWnZq1rlBsvyeXY9GnDKzed", "NhvbMWoFDj5W6o0bWnGe4dztWB8buZER"};
    public static final String A0r;
    public static final WeakHashMap<View, WeakReference<UK>> A0s;
    public long A00;
    public Drawable A01;
    public View.OnTouchListener A02;
    public View A03;
    public View A04;
    public View A05;
    public View A06;
    public AdClosedListener A07;
    public NativeAdLayout A08;
    public NE A09;
    public C2100jj A0A;
    public C07997g A0B;
    public C2058iu A0C;
    public T3 A0D;
    public C1361Tx A0E;
    public VI A0F;
    public VW A0G;
    public ViewOnClickListenerC1367Ud A0H;
    public InterfaceC1359Tv A0I;
    public C1393Vd A0J;
    public EnumC1394Ve A0K;
    public EnumC1404Vq A0L;
    public ZT A0M;
    public InterfaceC1491Zc A0N;
    public C1583b6 A0O;
    public C1713dC A0P;
    public C1777eF A0Q;
    public AbstractC1873fo A0R;
    public AbstractC1873fo A0S;
    public C1874fp A0T;
    public C1874fp A0U;
    public String A0V;
    public String A0W;
    public WeakReference<C1976hT> A0X;
    public WeakReference<AbstractC1873fo> A0Y;
    public boolean A0Z;
    public boolean A0a;
    public boolean A0b;
    public boolean A0c;
    public boolean A0d;
    public C2111ju A0e;
    public final C1335Sx A0f;
    public final C1929gi A0g;
    public final InterfaceC1390Va A0h;
    public final C1400Vk A0i;
    public final Y2 A0j;
    public final String A0k;
    public final String A0l;
    public final List<View> A0m;
    public volatile boolean A0n;

    public static String A0W(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0p, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 112);
        }
        return new String(copyOfRange);
    }

    public static void A0e() {
        A0p = new byte[]{-32, Ascii.SUB, 38, Ascii.US, Ascii.RS, -19, -14, -13, -16, Ascii.RS, -18, -15, -16, -24, -27, Ascii.SYN, -24, -26, -19, Ascii.ETB, -27, -74, -74, -71, -76, -70, -72, -29, -29, 38, 73, 5, 83, 84, 89, 5, 81, 84, 70, 73, 74, 73, -25, 10, -6, Ascii.VT, 19, Ascii.SYN, Ascii.DC2, 7, Ascii.SUB, Ascii.VT, -58, -51, -53, Ascii.EM, -51, -58, Ascii.SI, Ascii.EM, -58, Ascii.DC4, Ascii.NAK, Ascii.SUB, -58, 7, -58, Ascii.DC4, 7, Ascii.SUB, Ascii.SI, Ascii.FS, Ascii.VT, -58, 7, 10, -33, -37, -38, Ascii.SO, -3, 2, -2, 7, -4, -2, -25, -2, Ascii.CR, Ascii.DLE, 8, Ascii.VT, 4, -27, 0, 8, Ascii.VT, 4, 3, -65, 19, Ascii.SO, -65, Ascii.VT, Ascii.SO, 0, 3, -65, -20, 4, 3, 8, 0, -51, -16, Ascii.VT, 19, Ascii.SYN, Ascii.SI, Ascii.SO, -54, Ascii.RS, Ascii.EM, -54, Ascii.EM, Ascii.FF, Ascii.RS, Ascii.VT, 19, Ascii.CAN, -54, Ascii.RS, Ascii.SI, Ascii.ETB, Ascii.SUB, Ascii.SYN, Ascii.VT, Ascii.RS, Ascii.SI, -54, -13, -18, -54, Ascii.DLE, Ascii.FS, Ascii.EM, Ascii.ETB, -54, Ascii.FF, 19, Ascii.SO, -54, Ascii.SUB, Ascii.VT, 35, Ascii.SYN, Ascii.EM, Ascii.VT, Ascii.SO, -54, -47, -49, Ascii.GS, -47, -23, Ascii.SO, Ascii.DC4, 5, Ascii.DC2, Ascii.SO, 1, Ascii.FF, -64, 5, Ascii.DC2, Ascii.DC2, Ascii.SI, Ascii.DC2, -50, -86, Ascii.RS, 67, 75, 54, 65, 62, 57, -11, 72, 58, 73, -11, 68, 59, -11, 56, 65, 62, 56, SignedBytes.MAX_POWER_OF_TWO, 54, 55, 65, 58, -11, 75, 62, 58, 76, 72, 0, Ascii.CAN, Ascii.ETB, Ascii.FS, Ascii.DC4, 9, Ascii.FS, Ascii.CAN, 42, -45, Ascii.EM, 34, 37, -45, Ascii.FS, Ascii.SYN, 34, 33, -45, Ascii.FS, 38, -45, Ascii.FS, 38, -45, 32, Ascii.FS, 38, 38, Ascii.FS, 33, Ascii.SUB, -31, Ascii.GS, 53, 52, 57, 49, 38, 57, 53, 71, -16, 57, 67, -16, Base64.padSymbol, 57, 67, 67, 57, 62, 55, -2, 51, 91, 89, 90, 6, 86, 88, 85, 92, 79, 74, 75, 6, 71, 6, 60, 79, 75, 93, 35, 54, 73, 62, 75, 58, -11, Ascii.SYN, 57, -11, 76, 54, 72, -11, 54, 65, 71, 58, 54, 57, 78, -11, 71, 58, 60, 62, 72, 73, 58, 71, 58, 57, -11, 76, 62, 73, Base64.padSymbol, -11, 54, -11, 43, 62, 58, 76, 3, -11, Ascii.SYN, 74, 73, 68, -11, 74, 67, 71, 58, 60, 62, 72, 73, 58, 71, 62, 67, 60, -11, 54, 67, 57, -11, 69, 71, 68, 56, 58, 58, 57, 62, 67, 60, 3, -55, -36, -17, -28, -15, -32, -101, -36, -33, -101, -33, -32, -18, -17, -19, -22, -12, -32, -33, -39, -20, -1, -12, 1, -16, -85, -20, -17, -85, -9, -6, -20, -17, -85, -3, -16, -4, 0, -16, -2, -1, -16, -17, -22, -3, -7, Ascii.VT, -76, -11, 0, 6, -7, -11, -8, Ascii.CR, -76, 6, -7, -5, -3, 7, 8, -7, 6, -7, -8, -76, Ascii.VT, -3, 8, -4, -76, -11, -76, -30, -11, 8, -3, 10, -7, -43, -8, -62, -76, -43, 9, 8, 3, -76, 9, 2, 6, -7, -5, -3, 7, 8, -7, 6, -3, 2, -5, -76, -11, 2, -8, -76, 4, 6, 3, -9, -7, -7, -8, -3, 2, -5, -62, -1, Ascii.DC2, Ascii.SO, 32, -55, Ascii.ETB, Ascii.CAN, Ascii.GS, -55, Ascii.ESC, Ascii.SO, Ascii.DLE, Ascii.DC2, Ascii.FS, Ascii.GS, Ascii.SO, Ascii.ESC, Ascii.SO, Ascii.CR, -55, 32, Ascii.DC2, Ascii.GS, 17, -55, Ascii.GS, 17, Ascii.DC2, Ascii.FS, -55, -9, 10, Ascii.GS, Ascii.DC2, Ascii.US, Ascii.SO, -22, Ascii.CR, 46, 49, -19, 58, 50, 49, 54, 46, -19, 65, 70, Base64.padSymbol, 50, -19, 54, SignedBytes.MAX_POWER_OF_TWO, -19, 59, 60, 65, -19, SignedBytes.MAX_POWER_OF_TWO, 66, Base64.padSymbol, Base64.padSymbol, 60, 63, 65, 50, 49, -5, 54, 69, 62, 51, 52, 66, 67, 65, 62, 72, 81, 84, 70, 73, 38, 73, 69, 72, 58, Base64.padSymbol, Ascii.SUB, Base64.padSymbol, 1, 2, -7, 60, 58, 69, 69, 62, Base64.padSymbol, -7, 70, 72, 75, 62, -7, 77, 65, 58, 71, -7, 72, 71, 60, 62, -27, -40, -21, -32, -19, -36};
        String[] strArr = A0q;
        if (strArr[6].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        A0q[3] = "WbNUBB1XQVUYjPuN5kyqwH0pcEyoS9gz";
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x02c9, code lost:
    
        if (r6.A0S() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02cb, code lost:
    
        r12.A0R = new com.instagram.common.viewpoint.core.VE(r12);
        r12.A0T = new com.instagram.common.viewpoint.core.C1874fp(r13, 1, new java.lang.ref.WeakReference(r12.A0R), r12.A0g);
        r12.A0T.A0Y(false);
        r12.A0T.A0X(r6.A09());
        r12.A0T.A0U();
        r12.A0g.A0F().ACY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02fe, code lost:
    
        r1 = new java.util.ArrayList(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0305, code lost:
    
        if (r12.A05 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0307, code lost:
    
        r7 = r12.A05;
        r4 = com.instagram.common.viewpoint.core.UK.A0q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x031a, code lost:
    
        if (r4[2].charAt(3) == r4[7].charAt(3)) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x031c, code lost:
    
        r4 = com.instagram.common.viewpoint.core.UK.A0q;
        r4[0] = "7BxfhPTBtrovnc2SNqJYjum2f5qDPcpL";
        r4[4] = "Q5pxYg7VFdMmLRDnYTITcnTwa1eIsVWj";
        r1.add(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x032b, code lost:
    
        r2 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0333, code lost:
    
        if (r2.hasNext() == false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0335, code lost:
    
        A1Q((android.view.View) r2.next());
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x033f, code lost:
    
        r0 = A13();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0343, code lost:
    
        if (r16 == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0345, code lost:
    
        if (r0 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x034b, code lost:
    
        if (r0.A1f() == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x034d, code lost:
    
        A1Q(r13);
        r1.add(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0353, code lost:
    
        r7 = A00();
        r12.A0S = new com.instagram.common.viewpoint.core.C1385Uv(r12, r14, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0360, code lost:
    
        if ((r14 instanceof com.facebook.ads.internal.api.AdNativeComponentView) == false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0362, code lost:
    
        r12.A03 = ((com.facebook.ads.internal.api.AdNativeComponentView) r14).getAdContentsView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0370, code lost:
    
        if (com.instagram.common.viewpoint.core.C1379Up.A1z(r12.A0g) == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0372, code lost:
    
        r4 = A1H();
        r6 = A16().A0B();
        r5 = r12.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0380, code lost:
    
        if (r4 != null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0382, code lost:
    
        r4 = A0W(0, 0, com.vungle.ads.internal.protos.Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x038a, code lost:
    
        r6.AKo(r5, r4, r12.A03 instanceof com.instagram.common.viewpoint.core.C1813eq, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0392, code lost:
    
        r12.A0U = new com.instagram.common.viewpoint.core.C1874fp(r12.A03, r7, A03(), true, new java.lang.ref.WeakReference(r12.A0S), r12.A0g);
        r12.A0U.A0Y(!A0r());
        r12.A0U.A0W(A01());
        r12.A0U.A0X(A02());
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03ca, code lost:
    
        if ((r12.A03 instanceof com.instagram.common.viewpoint.core.C1573aw) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03cc, code lost:
    
        r5 = (com.instagram.common.viewpoint.core.C1573aw) r12.A03;
        r4 = com.instagram.common.viewpoint.core.UK.A0q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03e2, code lost:
    
        if (r4[0].charAt(21) == r4[4].charAt(21)) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03e4, code lost:
    
        com.instagram.common.viewpoint.core.UK.A0q[3] = "9jWMkBrIWAaQq3BshIoiK9kOFApm7Mnb";
        r5.A06(r12.A0U);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03f0, code lost:
    
        r12.A0A = new com.instagram.common.viewpoint.core.C2100jj(r12.A0g, new com.instagram.common.viewpoint.core.UY(r12, null), r12.A0U, r12.A0e);
        r12.A0A.A0H(r1);
        com.instagram.common.viewpoint.core.UK.A0s.put(r13, new java.lang.ref.WeakReference<>(r12));
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0418, code lost:
    
        if (com.instagram.common.viewpoint.core.C1379Up.A1C(r12.A0g) == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x041a, code lost:
    
        r12.A0O = new com.instagram.common.viewpoint.core.C1583b6();
        r12.A0O.A0C(r12.A0k);
        r12.A0O.A0B(r12.A0g.getPackageName());
        r12.A0O.A0A(r12.A0U);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x043c, code lost:
    
        if (r12.A0e == null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0448, code lost:
    
        if (r12.A0e.A0E().A03() <= 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x044a, code lost:
    
        r0 = r12.A0e.A0E();
        r12.A0O.A08(r0.A03(), r0.A04());
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x045d, code lost:
    
        r4 = r12.A0E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x046b, code lost:
    
        if (com.instagram.common.viewpoint.core.UK.A0q[3].charAt(5) == 'B') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x046d, code lost:
    
        if (r4 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x046f, code lost:
    
        r12.A0O.A09(r12.A0E.A0C());
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x047a, code lost:
    
        r12.A04.getOverlay().add(r12.A0O);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0485, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0497, code lost:
    
        if (r12.A0B == null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x049f, code lost:
    
        if (r12.A0B.A0J() == null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x04a1, code lost:
    
        r12.A0O.A09(r12.A0B.A0J().A0C());
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0486, code lost:
    
        r2 = com.instagram.common.viewpoint.core.UK.A0q;
        r2[6] = "iJInlaPqSCsodlo1snRpIwz9DPt1A";
        r2[1] = "DYzZZFtfMBLderHMiZZFXfgJZWHC0";
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0492, code lost:
    
        if (r4 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04b1, code lost:
    
        r12.A03 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x025e, code lost:
    
        if (r8 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0225, code lost:
    
        if (r8 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0227, code lost:
    
        android.util.Log.w(com.instagram.common.viewpoint.core.UK.A0r, A0W(283, 80, 101));
        unregisterView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0239, code lost:
    
        r8 = com.instagram.common.viewpoint.core.UK.A0s.containsKey(r13);
        r2 = com.instagram.common.viewpoint.core.UK.A0q;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x024f, code lost:
    
        if (r2[6].length() == r2[1].length()) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0256, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0261, code lost:
    
        r2 = com.instagram.common.viewpoint.core.UK.A0q;
        r2[0] = "r1dCEV0W05obqeylsxysUOCLLtyqbDkO";
        r2[4] = "jsU6g8E1kSPqSuKqGJQzSRDrUMjHNr5E";
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x026d, code lost:
    
        if (r8 == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x027b, code lost:
    
        if (com.instagram.common.viewpoint.core.UK.A0s.get(r13).get() == null) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x027d, code lost:
    
        android.util.Log.w(com.instagram.common.viewpoint.core.UK.A0r, A0W(406, 75, 36));
        com.instagram.common.viewpoint.core.UK.A0s.get(r13).get().unregisterView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x029d, code lost:
    
        r12.A0H = new com.instagram.common.viewpoint.core.ViewOnClickListenerC1367Ud(r12, r12.A0g, null);
        r12.A04 = r13;
        r12.A06 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02ad, code lost:
    
        if ((r13 instanceof android.view.ViewGroup) == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02af, code lost:
    
        r12.A0M = new com.instagram.common.viewpoint.core.ZT(r12.A0g, new com.instagram.common.viewpoint.core.VG(r12));
        ((android.view.ViewGroup) r13).addView(r12.A0M);
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 24 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0g(View view, View view2, List<View> list, boolean z) {
        if (!A0r()) {
            this.A0g.A0F().AHa();
        }
        if (view == null) {
            String A0W = A0W(264, 19, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
            if (!A0r()) {
                this.A0g.A0F().AHZ(A0W);
            }
            throw new IllegalArgumentException(A0W);
        }
        if (list == null || list.size() == 0) {
            String A0W2 = A0W(180, 30, 101);
            if (!A0r()) {
                this.A0g.A0F().AHZ(A0W2);
            }
            throw new IllegalArgumentException(A0W2);
        }
        C2111ju A0C = A0C();
        if (A0C == null) {
            String A0W3 = A0W(29, 13, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE);
            if (!A0r()) {
                this.A0g.A0F().AHZ(A0W3);
            }
            Log.e(A0r, A0W3);
            C1401Vm c1401Vm = new C1401Vm(AdErrorType.NATIVE_AD_IS_NOT_LOADED, A0W3);
            A16().A0F().A3N(Y1.A01(this.A00), c1401Vm.A03().getErrorCode(), c1401Vm.A04());
            if (!C1379Up.A2n(this.A0g) || this.A0I == null) {
                return;
            }
            this.A0I.ADp(c1401Vm);
            return;
        }
        String str = this.A0W;
        if ((view instanceof FrameLayout) && str != null) {
            A0h((FrameLayout) view, str);
        }
        if (this.A08 != null) {
            C1958hB c1958hB = (C1958hB) this.A08.getNativeAdLayoutApi();
            c1958hB.A03();
            c1958hB.A02();
        }
        C1976hT c1976hT = this.A0X.get();
        if (c1976hT != null && A0C.A08() == 1) {
            c1976hT.A0E(YM.AN_INFO_ICON);
        }
        if (view2 != null) {
            boolean z2 = (view2 instanceof AdNativeComponentView) && ((AdNativeComponentView) view2).getAdContentsView() != null;
            boolean z3 = z && (view2 instanceof ImageView);
            if (!z2 && !z3) {
                if (this.A0I != null) {
                    C1401Vm c1401Vm2 = new C1401Vm(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0W(519, 31, 93));
                    A16().A0F().A3N(Y1.A01(this.A00), c1401Vm2.A03().getErrorCode(), c1401Vm2.A04());
                    this.A0I.ADp(c1401Vm2);
                    return;
                }
                return;
            }
            View view3 = this.A04;
            if (A0q[3].charAt(5) != 'B') {
                String[] strArr = A0q;
                strArr[6] = "BCYbWK19bS9ET6nCyqUucyCTxntwC";
                strArr[1] = "hUEQWKvNS0BeeCCeuSbrKV1BB6cqb";
            } else {
                A0q[3] = "VFOGhBJepBYKNQ0g15YaI4y2lFqguygQ";
            }
        } else {
            if (this.A0L != EnumC1404Vq.A06) {
                AdErrorType adErrorType = AdErrorType.NO_MEDIAVIEW_IN_NATIVEBANNERAD;
                String A0W4 = A0W(210, 33, 67);
                C1401Vm c1401Vm3 = new C1401Vm(adErrorType, A0W4);
                A16().A0F().A3N(Y1.A01(this.A00), c1401Vm3.A03().getErrorCode(), c1401Vm3.A04());
                if (this.A0I != null) {
                    this.A0I.ADp(c1401Vm3);
                }
                if (AdInternalSettings.isDebugBuild()) {
                    String str2 = A0r;
                    if (A0q[3].charAt(5) == 'B') {
                        A0q[3] = "KISMvB3VNIc1t4pH9OUWIwxPU7abTBQu";
                        Log.e(str2, A0W4);
                        return;
                    } else {
                        String[] strArr2 = A0q;
                        strArr2[2] = "I0o2CociGt9PfWtihtc1uzdPzn26Oc3b";
                        strArr2[7] = "DL9r7FwT46CQ5uSYOng5HfHjynm8xWWf";
                        Log.e(str2, A0W4);
                        return;
                    }
                }
                return;
            }
            AdErrorType adErrorType2 = AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD;
            String A0W5 = A0W(243, 21, 96);
            C1401Vm c1401Vm4 = new C1401Vm(adErrorType2, A0W5);
            A16().A0F().A3N(Y1.A01(this.A00), c1401Vm4.A03().getErrorCode(), c1401Vm4.A04());
            if (this.A0I != null) {
                this.A0I.ADp(c1401Vm4);
            }
            if (!AdInternalSettings.isDebugBuild()) {
                return;
            }
            String str3 = A0r;
            if (A0q[5].length() != 3) {
                String[] strArr3 = A0q;
                strArr3[0] = "ymh7ZtbYw7oyMwS2HukMuI2t1Xj3fY7y";
                strArr3[4] = "GGURsKjIWyfUU1Vu9BOr0pf9u6pcVKo4";
                Log.e(str3, A0W5);
                return;
            }
        }
        throw new RuntimeException();
    }

    static {
        A0e();
        A0r = UK.class.getSimpleName();
        A0s = new WeakHashMap<>();
    }

    public UK(Context context, String str, InterfaceC1390Va interfaceC1390Va, boolean z) {
        this.A0l = UUID.randomUUID().toString();
        this.A0L = EnumC1404Vq.A06;
        this.A0G = VW.A04;
        this.A09 = NE.A03;
        this.A0X = new WeakReference<>(null);
        this.A0m = new ArrayList();
        this.A0j = new Y2();
        this.A0d = false;
        this.A0c = false;
        this.A00 = -1L;
        this.A0Z = false;
        if (context instanceof C1929gi) {
            this.A0g = (C1929gi) context;
        } else if (!z) {
            this.A0g = C1302Rp.A04(context);
        } else {
            this.A0g = C1302Rp.A03(context);
        }
        this.A0g.A0O(this);
        this.A0k = str;
        this.A0h = interfaceC1390Va;
        if (A0o != null) {
            this.A0f = A0o;
        } else {
            this.A0f = new C1335Sx(this.A0g);
        }
        this.A05 = new View(context);
        this.A0i = new C1400Vk(this.A0g, this);
    }

    public UK(UK uk) {
        this((Context) uk.A0g, (String) null, uk.A0h, true);
        this.A0E = uk.A0E;
        this.A0e = uk.A0e;
        this.A0C = uk.A0C;
        this.A0n = true;
        this.A05 = new View(this.A0g);
    }

    public UK(C1929gi c1929gi, C2111ju c2111ju, C1361Tx c1361Tx, InterfaceC1390Va interfaceC1390Va) {
        this((Context) c1929gi, (String) null, interfaceC1390Va, true);
        this.A0e = c2111ju;
        this.A0E = c1361Tx;
        this.A0n = true;
        this.A05 = new View(c1929gi);
    }

    public UK(C1929gi c1929gi, C2111ju c2111ju, C1361Tx c1361Tx, InterfaceC1390Va interfaceC1390Va, C2058iu c2058iu) {
        this(c1929gi, c2111ju, c1361Tx, interfaceC1390Va);
        this.A0C = c2058iu;
    }

    private int A00() {
        if (this.A0E != null) {
            return this.A0E.A04();
        }
        if (this.A0B == null || this.A0B.A0J() == null) {
            return 1;
        }
        C1361Tx A0J = this.A0B.A0J();
        String[] strArr = A0q;
        String str = strArr[6];
        String str2 = strArr[1];
        int length = str.length();
        int viewabilityThreshold = str2.length();
        if (length != viewabilityThreshold) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0q;
        strArr2[2] = "P5kYLn6xwAUrjDfDuw88TuaVt88D3vtD";
        strArr2[7] = "ZJzVQNISDO4cH7XUZ38T2d7bCdM1k8uN";
        return A0J.A04();
    }

    private int A01() {
        if (this.A0E != null) {
            return this.A0E.A07();
        }
        if (this.A0e != null) {
            return this.A0e.A0C();
        }
        if (this.A0B != null && this.A0B.A0J() != null) {
            return this.A0B.A0J().A07();
        }
        return 0;
    }

    private int A02() {
        if (this.A0E != null) {
            return this.A0E.A08();
        }
        if (this.A0e != null) {
            return this.A0e.A0D();
        }
        if (this.A0B != null && this.A0B.A0J() != null) {
            return this.A0B.A0J().A08();
        }
        return 1000;
    }

    private int A03() {
        if (this.A0E != null) {
            return this.A0E.A09();
        }
        C07997g c07997g = this.A0B;
        if (A0q[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        A0q[5] = "Xt";
        if (c07997g == null || this.A0B.A0J() == null) {
            return 0;
        }
        return this.A0B.A0J().A09();
    }

    public static Drawable A05(C1929gi c1929gi, Bitmap bitmap, boolean z, String str) {
        BitmapDrawable A00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c1929gi.getResources(), bitmap);
        if (z && (A00 = AbstractC1776eE.A00(c1929gi, str)) != null) {
            Drawable iconViewDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, A00});
            return iconViewDrawable;
        }
        return bitmapDrawable;
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws C1402Vn {
        EnumC1404Vq A00 = C1408Vu.A00(str2);
        if (A00 != null) {
            EnumC1404Vq template = EnumC1404Vq.A05;
            if (A00 == template) {
                return new NativeBannerAd(context, str);
            }
            EnumC1404Vq template2 = EnumC1404Vq.A06;
            if (A00 == template2) {
                return new NativeAd(context, str);
            }
            throw new C1402Vn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(42, 34, 54), A00));
        }
        throw new C1402Vn(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0W(114, 50, 58), str2));
    }

    private final C2111ju A0C() {
        C2111ju c2111ju = this.A0e;
        if (c2111ju != null && c2111ju.A0R()) {
            return c2111ju;
        }
        return null;
    }

    private C2099ji A0F() {
        return A0G(false);
    }

    private C2099ji A0G(boolean z) {
        if (this.A0e != null) {
            C2111ju c2111ju = this.A0e;
            if (A0q[3].charAt(5) == 'B') {
                String[] strArr = A0q;
                strArr[0] = "rkQiEYXoMEhriwkmxTS9YqbekXjRctvV";
                strArr[4] = "aQIgqL6bCxVEsMgFZvYj1f08oAvgjHgO";
                if (c2111ju.A0R()) {
                    if (z) {
                        C2111ju c2111ju2 = this.A0e;
                        if (A0q[3].charAt(5) == 'B') {
                            A0q[3] = "EWl26Bqfon8mX0lHHC6z05409Pwx5AXq";
                            c2111ju2.A0I();
                        }
                    }
                    return this.A0e.A0E();
                }
            }
            throw new RuntimeException();
        }
        return new C2099ji();
    }

    public static C1374Uk A0K() {
        return new C1374Uk();
    }

    public static UK A0L(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (UK) ((RZ) Proxy.getInvocationHandler(nativeAdBaseApi)).A04();
        }
        return (UK) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public final C1391Vb getAdChoicesIcon() {
        return A0F().A0G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* renamed from: A0O, reason: merged with bridge method [inline-methods] */
    public final C1392Vc getAdStarRating() {
        return A0F().A0J();
    }

    private AdPlacementType A0R() {
        if (this.A0L == EnumC1404Vq.A06) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0a() {
        for (View view : this.A0m) {
            view.setOnClickListener(null);
            if (A0q[3].charAt(5) != 'B') {
                throw new RuntimeException();
            }
            A0q[3] = "reBfvBMaH6BqwlxZ2WqAQZq3knZpIvyz";
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0m.clear();
    }

    private void A0b() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            X6.A0O(new X6(), this.A0g, XB.A00(getAdChoicesLinkUrl()), A1H());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0c() {
        this.A0j.A05();
        this.A0i.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0d() {
        if (this.A0T != null) {
            this.A0T.A0V();
            this.A0g.A0F().ACZ();
            this.A0T = null;
        }
    }

    public static void A0f(Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (A0q[3].charAt(5) != 'B') {
            throw new RuntimeException();
        }
        String[] strArr = A0q;
        strArr[6] = "LXDT52DRzEPuIKBbeK5QN38hLQjcy";
        strArr[1] = "Z1aNossC2MxjaxQyIIrn4vHalGw3J";
        imageView.setBackground(null);
    }

    private void A0h(FrameLayout frameLayout, String str) {
        if (this.A0Q != null) {
            frameLayout.removeView(this.A0Q);
        }
        this.A0Q = AbstractC1776eE.A01(C1302Rp.A03(this.A0g), str);
        if (this.A0Q != null) {
            frameLayout.addView(this.A0Q, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0Q);
        }
    }

    private void A0i(C2111ju c2111ju, boolean z) {
        Iterator<UK> it;
        if (c2111ju == null) {
            return;
        }
        boolean equals = this.A0G.equals(VW.A04);
        String A0W = A0W(596, 6, 7);
        if (equals) {
            C2099ji A0E = c2111ju.A0E();
            AbstractC2094jd A0F = A0E.A0F();
            if (A0F != null) {
                O0.A00(A0F, this.A0f, A0W);
            }
            String A7O = c2111ju.A7O();
            if (A0q[3].charAt(5) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A0q;
            strArr[6] = "lK6BgrMvSH2F6L4J2jXYHYWLLMocG";
            strArr[1] = "r7RKa3WPMM0ePgLxUrWU6ktCTFHYt";
            if (!TextUtils.isEmpty(A7O)) {
                this.A0F = new VI(A7O, this.A0g.A0A());
                this.A0f.A0e(this.A0F);
            }
            if (A0E.A0I() != null) {
                C1333Sv c1333Sv = new C1333Sv(A0E.A0I().getUrl(), A0E.A0I().getHeight(), A0E.A0I().getWidth(), c2111ju.A0G(), A0W(596, 6, 7));
                c1333Sv.A01 = this.A0D;
                this.A0f.A0W();
                this.A0f.A0c(c1333Sv);
            }
            if (!this.A0L.equals(EnumC1404Vq.A05)) {
                if (A0E.A0H() != null) {
                    this.A0f.A0c(new C1333Sv(A0E.A0H().getUrl(), A0E.A0H().getHeight(), A0E.A0H().getWidth(), c2111ju.A0G(), A0W(596, 6, 7)));
                }
                if (c2111ju.A0H() != null) {
                    List<UK> A0H = c2111ju.A0H();
                    String[] strArr2 = A0q;
                    String clientToken = strArr2[2];
                    if (clientToken.charAt(3) != strArr2[7].charAt(3)) {
                        String[] strArr3 = A0q;
                        strArr3[6] = "77gx94UEEewpboaJzdp5NkxYfy9yz";
                        strArr3[1] = "VW3IQGZLEm7XJQdY3dbeWOHCgy17v";
                        it = A0H.iterator();
                    } else {
                        String[] strArr4 = A0q;
                        strArr4[0] = "SnanODICAbTvQWDZLrONkEMoieoDOxdU";
                        strArr4[4] = "rm0yXzoJreTTXaU8PcTY1VhnZxiHPX84";
                        it = A0H.iterator();
                    }
                    while (it.hasNext()) {
                        UK next = it.next();
                        if (next.getAdCoverImage() != null) {
                            this.A0f.A0c(new C1333Sv(next.getAdCoverImage().getUrl(), next.getAdCoverImage().getHeight(), next.getAdCoverImage().getWidth(), c2111ju.A0G(), A0W(596, 6, 7)));
                        }
                    }
                }
                String A0e = A0E.A0e();
                if (!TextUtils.isEmpty(A0e)) {
                    this.A0f.A0b(new C1331St(A0e, c2111ju.A0G(), A0W(596, 6, 7), A0E.A0D()));
                }
            }
            if (A0F != null && A0F.A1g()) {
                C1331St cacheFileData = new C1331St(A0F.A0x(), A0F.A1D(), A0W);
                cacheFileData.A04 = true;
                cacheFileData.A03 = A0W(0, 5, 66);
                this.A0f.A0Y(cacheFileData);
            }
        }
        this.A0f.A0X(new VZ(this, c2111ju, z), new C1328Sq(c2111ju.A0G(), A0W));
    }

    private void A0j(NG ng) {
        if (this.A0e == null) {
            return;
        }
        this.A0e.A0K(ng);
    }

    public static void A0k(NativeAdImageApi nativeAdImageApi, ImageView imageView, C1929gi c1929gi) {
        if (nativeAdImageApi != null && imageView != null) {
            new LM(imageView, c1929gi).A05(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A07(nativeAdImageApi.getUrl());
        }
    }

    private final void A0n(InterfaceC1359Tv interfaceC1359Tv) {
        this.A0I = interfaceC1359Tv;
    }

    private final void A0o(String str) {
        this.A0V = str;
    }

    private void A0p(List<View> list, View view) {
        if (this.A0h != null && this.A0h.AJx(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                A0p(list, viewGroup.getChildAt(i));
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0q() {
        return A1D() == EnumC1395Vf.A05 || A1D() == EnumC1395Vf.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0r() {
        return A0F().A0j();
    }

    public final int A0y() {
        return A0F().A06();
    }

    public final int A0z() {
        return A0F().A07();
    }

    public final int A10() {
        if (this.A0e != null && !TextUtils.isEmpty(this.A0e.A0E().A0e())) {
            return this.A0e.A0E().A0A();
        }
        return -1;
    }

    public final long A11() {
        return this.A00;
    }

    public final C2111ju A12() {
        return this.A0e;
    }

    public final AbstractC2094jd A13() {
        return A0F().A0F();
    }

    public final C1335Sx A14() {
        return this.A0f;
    }

    public final C1929gi A15() {
        return this.A0g;
    }

    public final C1929gi A16() {
        return this.A0g;
    }

    public final ViewOnClickListenerC1367Ud A17() {
        return this.A0H;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* renamed from: A18, reason: merged with bridge method [inline-methods] */
    public final C1391Vb getAdCoverImage() {
        return A0F().A0H();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /* renamed from: A19, reason: merged with bridge method [inline-methods] */
    public final C1391Vb getAdIcon() {
        return A0F().A0I();
    }

    public final InterfaceC1359Tv A1A() {
        return this.A0I;
    }

    public final C1393Vd A1B() {
        return this.A0J;
    }

    public final EnumC1394Ve A1C() {
        return this.A0K;
    }

    public final EnumC1395Vf A1D() {
        return A0F().A0K();
    }

    public final Y2 A1E() {
        return this.A0j;
    }

    public final C1520a5 A1F() {
        if (A13() == null || !A13().A2U()) {
            return null;
        }
        C1520a5 c1520a5 = new C1520a5(this.A0g, EnumC1537aM.A05);
        c1520a5.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.VY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UK.this.A1R(view);
            }
        });
        return c1520a5;
    }

    public final C1874fp A1G() {
        return this.A0U;
    }

    public final String A1H() {
        if (this.A0e == null || !isAdLoaded()) {
            return null;
        }
        return this.A0e.A7O();
    }

    public final String A1I() {
        return this.A0W;
    }

    public final String A1J() {
        return A0G(true).A0Q();
    }

    public final String A1K() {
        return A0G(true).A0R();
    }

    public final String A1L() {
        return A0F().A0d();
    }

    public final String A1M() {
        if (this.A0e == null || TextUtils.isEmpty(this.A0e.A0E().A0e())) {
            return null;
        }
        return this.A0f.A0T(this.A0e.A0E().A0e());
    }

    public final List<UK> A1N() {
        if (this.A0e == null || !isAdLoaded()) {
            return null;
        }
        return this.A0e.A0H();
    }

    public final void A1O() {
        if (!AbstractC1220Oh.A00(this.A0g.A02()).A0O(this.A0g, false)) {
            A0b();
            if (A0q[5].length() == 3) {
                throw new RuntimeException();
            }
            A0q[3] = "yREZ0BSYt8CSunaR9f1myx0zIAs3a5bO";
            return;
        }
        AbstractC1492Zd A01 = AbstractC1493Ze.A01(this.A0g, this.A0g.A0A(), A1H(), this.A08);
        if (A01 == null) {
            A0b();
            return;
        }
        ((C1958hB) this.A08.getNativeAdLayoutApi()).A05(A01);
        if (!C1379Up.A22(this.A0g)) {
            C1929gi A15 = A15();
            String[] strArr = A0q;
            if (strArr[6].length() != strArr[1].length()) {
                A15.A0F().ABW();
                A01.setOnAdClosedListener(this.A07);
            } else {
                A0q[5] = "wIzlh5hd";
                A15.A0F().ABW();
                A01.setOnAdClosedListener(this.A07);
            }
        }
        A01.setAdReportingCallbackListener(this.A0N);
        A01.A0N();
    }

    public final void A1P(Drawable drawable) {
        this.A01 = drawable;
        A1o(drawable != null, true);
    }

    public final void A1Q(View view) {
        this.A0m.add(view);
        view.setOnClickListener(this.A0H);
        view.setOnTouchListener(this.A0H);
        if (C1379Up.A1C(view.getContext())) {
            view.setOnLongClickListener(this.A0H);
        }
    }

    public final /* synthetic */ void A1R(View view) {
        this.A0g.A0F().AAy(EnumC1537aM.A05.name().toLowerCase(Locale.US));
        A1O();
    }

    public final void A1S(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, imageView, arrayList, true);
    }

    public final void A1T(View view, ImageView imageView, List<View> clickableViews) {
        A0g(view, imageView, clickableViews, true);
    }

    public final void A1U(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0p(arrayList, view);
        A0g(view, adNativeComponentView, arrayList, false);
    }

    public final void A1V(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews) {
        A0g(view, adNativeComponentView, clickableViews, false);
    }

    public final void A1W(View view, AdNativeComponentView adNativeComponentView, List<View> clickableViews, boolean z) {
        A0g(view, adNativeComponentView, clickableViews, z);
    }

    public final void A1X(View view, AdNativeComponentView adNativeComponentView, boolean z) {
        List<View> clickableViews = new ArrayList<>();
        A0p(clickableViews, view);
        A0g(view, adNativeComponentView, clickableViews, z);
    }

    public final void A1Y(AdClosedListener adClosedListener) {
        A15().A0F().ABX();
        this.A07 = adClosedListener;
    }

    public final void A1Z(MediaView mediaView) {
        if (mediaView != null) {
            this.A0c = true;
        }
    }

    public final void A1a(MediaView mediaView) {
        if (mediaView != null) {
            this.A0d = true;
        }
    }

    public final void A1b(NativeAdBase nativeAdBase, NativeAdListener nativeAdListener) {
        if (nativeAdListener == null) {
            return;
        }
        A0n(new C07916y(nativeAdListener, nativeAdBase));
    }

    public final void A1c(NativeAdLayout nativeAdLayout) {
        this.A08 = nativeAdLayout;
    }

    public final void A1d(C2111ju c2111ju) {
        A0i(c2111ju, true);
        if (this.A0I != null && c2111ju.A0H() != null) {
            C1409Vv c1409Vv = new C1409Vv(this);
            for (UK uk : c2111ju.A0H()) {
                if (A0q[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0q;
                strArr[0] = "7JUEXy8BV6wMe69mvRG8Hisl1h58kfsH";
                strArr[4] = "Ag7M0cktqfZPxcWhbEyn8XCMGlxm5ALn";
                uk.A0j(c1409Vv);
            }
        }
    }

    public final void A1e(C1976hT c1976hT) {
        this.A0X = new WeakReference<>(c1976hT);
    }

    public final void A1f(VW vw, String str, T3 t3) {
        if (str == null) {
            this.A0g.A0F().A3Q();
        } else {
            this.A0g.A0F().A3P();
        }
        this.A00 = System.currentTimeMillis();
        boolean z = this.A0n;
        String[] strArr = A0q;
        if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
            String[] strArr2 = A0q;
            strArr2[0] = "knecuAJjZigTf7VsFCGhTGCW7dxKplKn";
            strArr2[4] = "uRrNlLGUJL1gxvEKewtOLFu1Ztix0dl1";
            if (z) {
                AdSettings.IntegrationErrorMode A00 = OA.A00(this.A0g);
                String A0W = A0W(566, 30, 105);
                AdSettings.IntegrationErrorMode integrationErrorMode = AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE;
                if (!integrationErrorMode.equals(A00)) {
                    C1401Vm c1401Vm = new C1401Vm(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0W(566, 30, 105));
                    A16().A0F().A3N(Y1.A01(this.A00), c1401Vm.A03().getErrorCode(), c1401Vm.A04());
                    if (this.A0I != null) {
                        this.A0I.ADp(c1401Vm);
                    } else {
                        Log.e(A0W(76, 17, 41), A0W);
                    }
                    C1342Te c1342Te = new C1342Te(A0W);
                    A16().A08().ABC(A0W(550, 3, 101), AbstractC1341Td.A0c, c1342Te);
                } else {
                    throw new OF(A0W);
                }
            }
            this.A0n = true;
            this.A0G = vw;
            if (vw.equals(VW.A05)) {
                NE ne = NE.A05;
                if (A0q[3].charAt(5) == 'B') {
                    A0q[3] = "N11XMBa1eBkGGouoRChlRsXEwEtHvHDZ";
                    this.A09 = ne;
                }
            }
            this.A0D = t3;
            O7 o7 = new O7(this.A0k, this.A0L, A0R(), null, 1, new C2048ij());
            o7.A05(vw);
            o7.A06(this.A0V);
            o7.A07(this.A0W);
            this.A0B = new C07997g(this.A0g, o7);
            this.A0B.A0S(new C1410Vw(this));
            this.A0B.A0W(str);
            return;
        }
        throw new RuntimeException();
    }

    public final void A1g(C1393Vd c1393Vd) {
        this.A0J = c1393Vd;
    }

    public final void A1h(EnumC1394Ve enumC1394Ve) {
        this.A0K = enumC1394Ve;
    }

    public final void A1i(EnumC1404Vq enumC1404Vq) {
        if (!A0r()) {
            if (EnumC1404Vq.A05.equals(enumC1404Vq)) {
                this.A0g.A0F().A3T(AdPlacementType.NATIVE_BANNER.toString(), this.A0k);
            } else {
                this.A0g.A0F().A3T(AdPlacementType.NATIVE.toString(), this.A0k);
            }
        }
        this.A0L = enumC1404Vq;
    }

    public final void A1j(InterfaceC1491Zc interfaceC1491Zc) {
        this.A0N = interfaceC1491Zc;
    }

    public final void A1k(AbstractC1873fo abstractC1873fo) {
        this.A0Y = new WeakReference<>(abstractC1873fo);
    }

    public final void A1l(boolean z) {
        this.A0a = z;
    }

    public final void A1m(boolean z) {
        this.A0Z = z;
    }

    public final void A1n(boolean z) {
        this.A0b = z;
    }

    public final void A1o(boolean z, boolean z2) {
        String A0W;
        if (z) {
            if (this.A0G.equals(VW.A05)) {
                boolean A0r2 = A0r();
                if (A0q[3].charAt(5) != 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A0q;
                strArr[6] = "maLBxQjysuwmJ75m3YPaJDHU5JlBu";
                strArr[1] = "hXXEi4DazsshJWFEyRiAh7tUxgC1d";
                if (!A0r2 && this.A0I != null) {
                    this.A0I.AEq();
                }
            }
            if (this.A0U != null) {
                this.A0U.A0U();
                this.A0i.A09();
                return;
            }
            return;
        }
        if (this.A0U != null) {
            C2111ju adapter = A12();
            if (adapter != null) {
                A0W = adapter.A0G();
            } else if (A0q[5].length() != 3) {
                String[] strArr2 = A0q;
                strArr2[2] = "2ETmOz1YodPf8MKRGGB9YcIoy7FDTpAq";
                strArr2[7] = "k5VZ8yDbY0Zqj8FxkeEerY08JJe7M6tR";
                A0W = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            } else {
                String[] strArr3 = A0q;
                strArr3[0] = "JjUCnZOckAfeDcKZajvIf0dyi7sruRRg";
                strArr3[4] = "GlO3j5qd4HFQ8L5mPWBpkp3onxgG8Q98";
                A0W = A0W(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
            }
            this.A0i.A0C(this.A0g, A0W);
            this.A0U.A0V();
        }
        if (this.A0I != null && z2) {
            C1401Vm A01 = C1401Vm.A01(AdErrorType.BROKEN_MEDIA_ERROR, A0W(93, 21, 47));
            A16().A0F().A3N(Y1.A01(this.A00), A01.A03().getErrorCode(), A01.A04());
            this.A0I.ADp(A01);
        }
    }

    public final boolean A1p() {
        return this.A0Z;
    }

    public final boolean A1q() {
        return A0F().A0h();
    }

    public final boolean A1r() {
        return A0F().A0g();
    }

    public final boolean A1s() {
        return this.A0L == EnumC1404Vq.A05;
    }

    public final boolean A1t() {
        return this.A08 == null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1398Vi
    public final int A7d() {
        View view = this.A06;
        if (view instanceof AdNativeComponentView) {
            View videoView = ((AdNativeComponentView) view).getAdContentsView();
            if (videoView instanceof C1813eq) {
                return ((C1813eq) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new C1396Vg(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        AbstractC1412Vy.A05(A0W(553, 7, 95), A0W(363, 19, 11), A0W(21, 8, 17));
        if (C1379Up.A1z(this.A0g)) {
            A16().A0B().AKU(this.A03);
        }
        if (!A0r()) {
            this.A0g.A0F().A3U();
        }
        if (this.A0B != null) {
            this.A0B.A0Y(true);
            this.A0B.A0K();
            this.A0B = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0G.equals(VW.A05)) {
            this.A09 = NE.A04;
        }
        this.A0G = VW.A04;
        A0i(this.A0e, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdBodyText() {
        return A0G(true).A0L();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdCallToAction() {
        return A0G(true).A0Z();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        return getAdChoicesIcon().getUrl();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesLinkUrl() {
        return A0F().A0M();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdChoicesText() {
        return A0F().A0N();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdHeadline() {
        return A0G(true).A0O();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdLinkDescription() {
        return A0G(true).A0P();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdSocialContext() {
        return A0G(true).A0T();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdTranslation() {
        return A0G(true).A0W();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdUntrimmedBodyText() {
        return A0G(true).A0X();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getAdvertiserName() {
        return A0G(true).A0Y();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        C1391Vb nativeAdImage;
        if (this.A0e == null || (nativeAdImage = this.A0e.A0E().A0H()) == null) {
            return 0.0f;
        }
        int width = nativeAdImage.getWidth();
        int height = nativeAdImage.getHeight();
        if (height <= 0) {
            return 0.0f;
        }
        float f = width;
        float f2 = height;
        String[] strArr = A0q;
        if (strArr[0].charAt(21) == strArr[4].charAt(21)) {
            throw new RuntimeException();
        }
        A0q[3] = "OUTl4BjdLTzCi4kmpI6eA9pKBM08eKMp";
        return f / f2;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0l;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0k;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final Drawable getPreloadedIconViewDrawable() {
        C1391Vb A0I;
        Bitmap A0N;
        C2111ju adapter = this.A0e;
        if (adapter != null && (A0I = A0F().A0I()) != null && (A0N = this.A0f.A0N(A0I.getUrl())) != null) {
            return A05(A16(), A0N, A1t(), A1I());
        }
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getPromotedTranslation() {
        return A0G(true).A0S();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final String getSponsoredTranslation() {
        return A0G(true).A0U();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        return this.A0e != null && this.A0e.A0Q();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean z = true;
        if (this.A0B != null) {
            C07997g c07997g = this.A0B;
            String[] strArr = A0q;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0q;
            strArr2[2] = "gqyuy6F7WThaJUOfAsIyr4sziGGBhw0f";
            strArr2[7] = "L6lbko7Rv34huPFym8TvMBezY1vQkdWf";
            z = c07997g.A0Z();
        } else if (this.A0C != null) {
            z = this.A0C.A0A();
        }
        this.A0g.A0F().A5f(z);
        return z;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        return this.A0e != null && this.A0e.A0R();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        AbstractC1412Vy.A05(A0W(560, 6, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), A0W(382, 24, 27), A0W(13, 8, 68));
        A1f(VW.A00(NativeAdBase.MediaCacheFlag.ALL), null, new T3(false, -1, -1));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        AbstractC1412Vy.A05(A0W(560, 6, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), A0W(382, 24, 27), A0W(5, 8, 76));
        ((C1396Vg) nativeLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        if (this.A05 != null) {
            this.A05.performClick();
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        if (this.A04 != null) {
            this.A04.post(new C1411Vx(this));
        }
        String str = A0W(164, 16, 48) + AbstractC1456Xt.A03(this.A0g, th);
        A16().A0F().A3N(Y1.A01(this.A00), 2001, str);
        if (this.A0I != null) {
            this.A0I.ADp(new C1401Vm(2001, str));
        }
    }

    @Override // com.facebook.ads.Ad
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0o(extraHints.getHints());
        this.A0W = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void unregisterView() {
        C1777eF c1777eF = this.A0Q;
        if (c1777eF != null) {
            ViewParent parent = c1777eF.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(c1777eF);
            }
            this.A0Q = null;
        }
        if (this.A04 == null || this.A06 == null) {
            return;
        }
        if (!A0r()) {
            InterfaceC1155Lt A0F = this.A0g.A0F();
            String[] strArr = A0q;
            if (strArr[0].charAt(21) != strArr[4].charAt(21)) {
                A0q[3] = "w9n8TBisrss8zAM8EiwpgeUnlq2PaQ6F";
                A0F.unregisterView();
            }
            throw new RuntimeException();
        }
        if (C1379Up.A1z(this.A0g)) {
            A16().A0B().AKU(this.A03);
        }
        if (A0s.containsKey(this.A04) && A0s.get(this.A04).get() == this) {
            View view = this.A04;
            String[] strArr2 = A0q;
            if (strArr2[2].charAt(3) != strArr2[7].charAt(3)) {
                String[] strArr3 = A0q;
                strArr3[6] = "1kkuB6xtwDeF3EtU3aavEsH64nQcK";
                strArr3[1] = "rb6NM7K87kMKFcLdVL5rugEXgDuZd";
                if ((view instanceof ViewGroup) && this.A0M != null) {
                    ((ViewGroup) this.A04).removeView(this.A0M);
                    this.A0M = null;
                }
                if (this.A0e != null) {
                    this.A0e.A0J();
                }
                if (this.A0O != null && C1379Up.A1C(this.A0g)) {
                    this.A0O.A07();
                    View view2 = this.A04;
                    String[] strArr4 = A0q;
                    if (strArr4[2].charAt(3) == strArr4[7].charAt(3)) {
                        throw new RuntimeException();
                    }
                    String[] strArr5 = A0q;
                    strArr5[0] = "4gE9LeNlQroHqEeWf1EzJsbNX9PRfDme";
                    strArr5[4] = "TBDkrxJbHtSaZ13hkNs0RNY8SzE0jpKy";
                    view2.getOverlay().remove(this.A0O);
                }
                A0s.remove(this.A04);
                A0a();
                this.A04 = null;
                this.A06 = null;
                if (this.A0U != null) {
                    this.A0U.A0V();
                    this.A0U = null;
                }
                A0d();
                this.A0A = null;
                this.A0Z = false;
                return;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException(A0W(481, 38, 57));
    }
}
