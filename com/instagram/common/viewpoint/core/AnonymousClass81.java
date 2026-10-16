package com.instagram.common.viewpoint.core;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import android.widget.LinearLayout;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.common.PlaybackException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.81, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass81<NativeViewabilityLogger> implements InterfaceC2125k8 {
    public static byte[] A0J;
    public static String[] A0K = {"NhwOmA8H17maQr2Thm3XPPVG1xwEsLhZ", "rranxCubAcBFDRhPr2LDrxoK3htxcyeL", "LmhV8", "ZLGOK7uKxyyp5W3sNEqoBEODv8zXcPE1", "dNK0bBZMrDk2YJmjrhSzlk1RMTFmUAsD", "q33l17MPfjO0fzYSahPh7EE95Ux5x03H", "4VfBn9Mh4W5rafl7A4va0uDeREUgOp63", "NLrbv196ww605txiYhOndsfSQjY"};
    public static final String A0L;
    public N9 A00;
    public NA A01;
    public C2102jl A02;
    public C08077o A03;
    public AnonymousClass76 A04;
    public VA A05;
    public EnumC1403Vp A06;
    public InterfaceC1578b1 A07;
    public LV A08;
    public AnonymousClass62 A09;
    public AbstractC1873fo A0A;
    public C1874fp A0B;
    public String A0D;
    public final String A0I = UUID.randomUUID().toString();
    public boolean A0E = false;
    public boolean A0F = false;
    public boolean A0G = false;
    public final Y2 A0H = new Y2();
    public Boolean A0C = false;

    public static String A08(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_NOT_AVAILABLE_IN_REGION);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A0J = new byte[]{Ascii.FS, 40, 38, -25, Ascii.US, Ascii.SUB, Ascii.FS, Ascii.RS, Ascii.ESC, 40, 40, 36, -25, Ascii.SUB, Ascii.GS, 44, -25, Ascii.ESC, Ascii.SUB, 39, 39, Ascii.RS, 43, -25, Ascii.FS, 37, 34, Ascii.FS, 36, Ascii.RS, Ascii.GS, -15, -30, -11, -15, -84, -27, -15, -22, -23, -21, -22, -36, -93, -82};
    }

    static {
        A0B();
        A0L = AnonymousClass81.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0A() {
        if (this.A00 != null && this.A09 != null && this.A03 != null && this.A03.A1g()) {
            this.A00.ADD(this, this.A09);
        }
        if (this.A00 != null) {
            boolean z = this.A0E;
            if (A0K[1].charAt(21) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[6] = "pcQhCrMOoUvf1wSUiS8eXhj7G6bioSrh";
            strArr[4] = "JWZBC7ZhFf7k7YrTz5pa22tV9NT1Mc4w";
            if (z && (this.A0F || !this.A0G)) {
                N9 n9 = this.A00;
                if (A0K[3].charAt(25) != 'G') {
                    A0K[3] = "irPj8aYnTZH6GsdLYSbTyVfXBLXHQnPh";
                    n9.ADD(this, this.A08);
                } else {
                    A0K[3] = "5PA9hoTjlgD01Tr6eTkR8jxCvDfXc2RO";
                    n9.ADD(this, this.A08);
                }
            }
        }
        this.A04.A0F().A4O(this.A00 != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    public void A0C(int i, C1361Tx c1361Tx) {
        C2119k2 c2119k2 = new C2119k2(this);
        this.A09 = new AnonymousClass62(this.A04, this.A05, c2119k2, this.A03, A08(0, 31, 79), 2, this.A0H);
        this.A0A = new C2118k1(this);
        this.A0B = new C1874fp(this.A09, c1361Tx.A04(), c1361Tx.A09(), true, new WeakReference(this.A0A), this.A04);
        this.A0B.A0W(this.A03.A0m());
        this.A0B.A0X(this.A03.A0n());
        this.A09.setVisibility(0);
        this.A04.getResources();
        this.A09.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
        this.A09.AKD();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    private void A0F(C1361Tx c1361Tx, JSONObject jSONObject, EnumC1403Vp enumC1403Vp) {
        this.A0F = false;
        final C2104jn A00 = C2104jn.A00(this.A04, jSONObject);
        this.A0D = A00.A7O();
        if (AbstractC1185Mx.A06(this.A04, A00, this.A05)) {
            this.A04.A0F().A52();
            this.A00.AEN(this, C1401Vm.A00(AdErrorType.NO_FILL));
            return;
        }
        this.A07 = new AbstractC1151Lp() { // from class: com.facebook.ads.redexgen.X.82
            public static byte[] A02;
            public static String[] A03 = {"dvnbyrX9L5Wlup6c2JnWkpTYBAz3QIun", "ITj", "KqeTcLSx6Zay5vtxcnHqZ", "bGeXa7nDz1byFpBCq22utpLnb", "UYph9iPsD3jee8BOLuPQ6r57rjKJpmVb", "DfaYbRSw6X21pxGApii0qweOJ64z1eNB", "52vckdype7aS5lLwU46sLHF0XTMQAze7", "uuBWL9In1wjj"};

            public static String A00(int i, int i2, int i3) {
                byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                    copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 105);
                }
                return new String(copyOfRange);
            }

            public static void A01() {
                A02 = new byte[]{67, 116, 116, 105, 116, 38, 99, 126, 99, 101, 115, 114, 111, 104, 97, 38, 103, 101, 114, 111, 105, 104, 119, 117, 120, 120, 113, 102, SignedBytes.MAX_POWER_OF_TWO, 109, 100, 113, 116, 112, 115, 118, 81, 74, 77, 85, 81, 65, 109, SignedBytes.MAX_POWER_OF_TWO};
            }

            static {
                A01();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC1578b1
            public final void ACz() {
                boolean z;
                AnonymousClass81.this.A0F = true;
                z = AnonymousClass81.this.A0G;
                if (z) {
                    AnonymousClass81.this.A0A();
                }
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC1151Lp, com.instagram.common.viewpoint.core.InterfaceC1578b1
            public final void ADN(String str, Map<String, String> map) {
                AnonymousClass76 anonymousClass76;
                String str2;
                AnonymousClass76 anonymousClass762;
                VA va;
                C08077o c08077o;
                C08077o c08077o2;
                C1193Ng A2A;
                String str3;
                AnonymousClass76 anonymousClass763;
                N9 n9;
                N9 n92;
                anonymousClass76 = AnonymousClass81.this.A04;
                anonymousClass76.A0F().A4P();
                Uri A002 = XB.A00(str);
                map.put(A00(22, 10, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), AdPlacementType.BANNER.name());
                str2 = AnonymousClass81.this.A0I;
                map.put(A00(36, 8, 77), str2);
                anonymousClass762 = AnonymousClass81.this.A04;
                va = AnonymousClass81.this.A05;
                String A7O = A00.A7O();
                c08077o = AnonymousClass81.this.A03;
                if (c08077o == null) {
                    A2A = null;
                } else {
                    AnonymousClass81 anonymousClass81 = AnonymousClass81.this;
                    if (A03[7].length() == 4) {
                        throw new RuntimeException();
                    }
                    A03[2] = "7FoTEC4l3Pv3ceMVIqf";
                    c08077o2 = anonymousClass81.A03;
                    A2A = c08077o2.A2A();
                }
                AbstractC1181Mt adAction = C1182Mu.A00(anonymousClass762, va, A7O, A002, map, A2A);
                EnumC1178Mq enumC1178Mq = EnumC1178Mq.A09;
                if (adAction != null) {
                    try {
                        anonymousClass763 = AnonymousClass81.this.A04;
                        anonymousClass763.A0F().A4M();
                        enumC1178Mq = adAction.A0G(null);
                    } catch (Exception e) {
                        str3 = AnonymousClass81.A0L;
                        Log.e(str3, A00(0, 22, 111), e);
                    }
                }
                if (A00(32, 4, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE).equals(A002.getScheme()) && C1182Mu.A04(A002.getAuthority())) {
                    n9 = AnonymousClass81.this.A00;
                    if (n9 != null && enumC1178Mq != EnumC1178Mq.A06) {
                        n92 = AnonymousClass81.this.A00;
                        n92.ADC(AnonymousClass81.this);
                    }
                }
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC1578b1
            public final void AEA() {
                AnonymousClass76 anonymousClass76;
                C2102jl c2102jl;
                C2102jl c2102jl2;
                C2102jl c2102jl3;
                anonymousClass76 = AnonymousClass81.this.A04;
                InterfaceC2156kf A0F = anonymousClass76.A0F();
                c2102jl = AnonymousClass81.this.A02;
                A0F.A4Q(c2102jl != null);
                c2102jl2 = AnonymousClass81.this.A02;
                if (c2102jl2 != null) {
                    c2102jl3 = AnonymousClass81.this.A02;
                    c2102jl3.A03();
                }
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC1578b1
            public final void AF8() {
                AnonymousClass76 anonymousClass76;
                C2102jl c2102jl;
                anonymousClass76 = AnonymousClass81.this.A04;
                anonymousClass76.A0F().A4S();
                c2102jl = AnonymousClass81.this.A02;
                c2102jl.A09();
            }

            @Override // com.instagram.common.viewpoint.core.InterfaceC1578b1
            public final void AGg() {
            }
        };
        this.A08 = new LV(this.A04, (WeakReference<InterfaceC1578b1>) new WeakReference(this.A07), c1361Tx.A04(), A7O());
        this.A08.A0L(c1361Tx.A07(), c1361Tx.A08());
        N4 impressionHelper = new C2117k0(this);
        this.A02 = new C2102jl(this.A04, this.A05, this.A08, this.A08.getViewabilityChecker(), impressionHelper, enumC1403Vp);
        this.A02.A0A(A00);
        this.A08.loadDataWithBaseURL(AbstractC1581b4.A01(AdInternalSettings.getUrlPrefix()), A00.A04(), A08(31, 9, 19), A08(40, 5, 12), null);
        this.A0E = true;
        A0A();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0051, code lost:
    
        if (com.instagram.common.viewpoint.core.C1379Up.A2H(r10.A04) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005d, code lost:
    
        if (com.instagram.common.viewpoint.core.SN.A0A(r10.A03.A1H()) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005f, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (com.instagram.common.viewpoint.core.C1379Up.A2H(r10.A04) != false) goto L13;
     */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0G(EnumC1403Vp enumC1403Vp, C1361Tx c1361Tx) {
        int i;
        int bannerHeight;
        if (this.A03 != null) {
            VA va = this.A05;
            if (A0K[1].charAt(21) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0K;
            strArr[6] = "0asQ5nS3mEJJFXqECkaJp8czAINd5ojj";
            strArr[4] = "wkfCN0fAVUFan65EWCqz3ffd3K2ZXjjS";
            if (va == null) {
                return;
            }
            int A03 = enumC1403Vp.A03();
            if (A0K[3].charAt(25) != 'G') {
                A0K[5] = "7AAzPingpmVfFCqSXKHauNoNKo9Xv93Z";
                i = (int) (A03 * Resources.getSystem().getDisplayMetrics().density);
            } else {
                i = (int) (A03 * Resources.getSystem().getDisplayMetrics().density);
            }
            if (bannerHeight == 0) {
                A0C(i, c1361Tx);
            } else {
                new SN(new C1335Sx(this.A04), this.A03.A1H(), this.A03.A10(), this.A03.A1D(), true, new C2121k4(this, i, c1361Tx, this)).A0B();
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.instagram.common.viewpoint.core.N1
    public final String A7O() {
        return this.A0D;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.instagram.common.viewpoint.core.N1
    public final AdPlacementType A8k() {
        if (C1379Up.A1A(this.A04)) {
            EnumC1403Vp enumC1403Vp = this.A06;
            String[] strArr = A0K;
            if (strArr[2].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            A0K[0] = "gRyzGCsQg6apk2eHBZ3N290V4KDgGwY2";
            if (enumC1403Vp != null && this.A06 == EnumC1403Vp.A09) {
                return AdPlacementType.MEDIUM_RECTANGLE;
            }
        }
        return AdPlacementType.BANNER;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2125k8
    public final void AAt(AnonymousClass76 anonymousClass76, VA va, EnumC1403Vp enumC1403Vp, N9 n9, JSONObject jSONObject, C1361Tx c1361Tx) {
        anonymousClass76.A0F().A4N();
        this.A04 = anonymousClass76;
        this.A05 = va;
        this.A00 = n9;
        this.A06 = enumC1403Vp;
        this.A0G = C1379Up.A1o(this.A04.getApplicationContext());
        this.A03 = C08077o.A00(jSONObject, this.A04);
        if (this.A03.A1g()) {
            A0G(enumC1403Vp, c1361Tx);
        } else {
            A0F(c1361Tx, jSONObject, enumC1403Vp);
        }
        this.A01 = new NA(this.A04, this.A0I, this, n9);
        this.A01.A02();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.instagram.common.viewpoint.core.N1
    public final boolean AKL() {
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.81 != com.facebook.ads.internal.adapters.FacebookBannerAdapter<NativeViewabilityLogger> */
    @Override // com.instagram.common.viewpoint.core.N1
    public final void onDestroy() {
        this.A04.A0F().A4L(this.A08 != null);
        if (this.A08 != null) {
            this.A08.destroy();
            this.A08 = null;
            this.A07 = null;
        }
        if (this.A01 != null) {
            this.A01.A03();
        }
    }
}
