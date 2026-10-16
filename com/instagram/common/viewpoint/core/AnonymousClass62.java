package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.62, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass62 extends FrameLayout implements InterfaceC1076Is {
    public static byte[] A0A;
    public static String[] A0B = {"cNW8ZlUzhquZSz6XSi", "gKIjGDOIeaOzZR9qeyStr8duZ", "mQKfIuNnQZgt5ES8sx19fjwTYxycx0Lp", "WvoZHe7VElSdYX15O8PPMcOC5YskUK4l", "BfRVnLJiFu3hDnD", "WxgvJAZOXh", "crPtNK55mSnLeOXFeJGYeBq3ABMrpYK", "K6RBlZSEjGoukPcRXJY4znE0whNpCjIj"};
    public C1874fp A00;
    public final int A01;
    public final AbstractC2094jd A02;
    public final C1929gi A03;
    public final VA A04;
    public final Y2 A05;
    public final InterfaceC1702d1 A06;
    public final C1713dC A07;
    public final String A08;
    public final boolean A09;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 14);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{100, 70, 73, 0, 83, 7, 84, 83, 70, 85, 83, 7, 102, 82, 67, 78, 66, 73, 68, 66, 105, 66, 83, 80, 72, 85, 76, 102, 68, 83, 78, 81, 78, 83, 94, 9, 7, 106, 70, 76, 66, 7, 84, 82, 85, 66, 7, 83, 79, 70, 83, 7, 78, 83, 0, 84, 7, 78, 73, 7, 94, 72, 82, 85, 7, 102, 73, 67, 85, 72, 78, 67, 106, 70, 73, 78, 65, 66, 84, 83, 9, 95, 74, 75, 7, 65, 78, 75, 66, 9, Ascii.CAN, Ascii.FS, Ascii.US, 43, 58, 55, 59, 48, Base64.padSymbol, 59, Ascii.DLE, 59, 42, 41, 49, 44, 53, 69, 74, 123, 69, 71, 80, 77, 82, 77, 80, 93, 4, Ascii.VT, Ascii.SO, 4, Ascii.FF, 56, Ascii.DC4, 8, Ascii.DC2, Ascii.NAK, 4, 2, 90, 85, SignedBytes.MAX_POWER_OF_TWO, 93, 66, 81, 117, 80, 112, 85, SignedBytes.MAX_POWER_OF_TWO, 85, 118, 65, 90, 80, 88, 81, Ascii.ESC, Ascii.GS, Ascii.VT, Ascii.FS, Ascii.CR, 2, 7, Ascii.CR, 5, Ascii.SYN, 9, 5, Ascii.ETB, 52, Ascii.EM, Ascii.DLE, 5};
    }

    static {
        A02();
    }

    public AnonymousClass62(C1929gi c1929gi, VA va, InterfaceC1702d1 interfaceC1702d1, AbstractC2094jd abstractC2094jd, String str, int i, Y2 y2) {
        super(c1929gi);
        this.A03 = c1929gi;
        this.A04 = va;
        this.A02 = abstractC2094jd;
        this.A08 = str;
        this.A06 = interfaceC1702d1;
        this.A01 = i;
        C1713dC preloadedDynamicWebViewController = AbstractC1714dD.A02(abstractC2094jd.A1D());
        if (preloadedDynamicWebViewController != null) {
            this.A07 = preloadedDynamicWebViewController;
            this.A09 = true;
        } else {
            this.A07 = new C1713dC(this.A03, abstractC2094jd, va, i);
            AbstractC1714dD.A03(abstractC2094jd, this.A07);
            this.A09 = false;
        }
        if (y2 != null) {
            this.A05 = y2;
            this.A07.A0Z(y2);
        } else {
            this.A05 = this.A07.A0L();
        }
        this.A07.A0c(new JJ(this));
        this.A07.A0a(interfaceC1702d1);
        EnumC1439Xc.A04(this, EnumC1439Xc.A0B);
        if (C1379Up.A1z(c1929gi)) {
            c1929gi.A0B().AKp(this.A07.A0O(), abstractC2094jd.A2E(), false, false, true);
        }
        A04();
    }

    private final void A03() {
        this.A07.A0d(this);
        if (!this.A09) {
            this.A03.A0F().A66();
            this.A07.A0X();
        } else {
            this.A03.A0F().A67();
            if (this.A07.A0k()) {
                if (this.A01 == 4) {
                    if (this.A06 != null) {
                        this.A06.ADm(this);
                    }
                    if (C1379Up.A1z(this.A03)) {
                        VM A0B2 = this.A03.A0B();
                        if (A0B[1].length() != 25) {
                            throw new RuntimeException();
                        }
                        A0B[5] = "";
                        A0B2.ADb();
                    }
                } else {
                    AKD();
                }
            }
        }
        A08();
    }

    private final void A04() {
        C1713dC.A0B().incrementAndGet();
        A03();
        this.A07.A0W();
    }

    private void A05(Intent intent, AbstractC2094jd abstractC2094jd) {
        intent.putExtra(A01(157, 8, 110), WK.A07);
        intent.putExtra(A01(130, 18, 58), abstractC2094jd);
        intent.addFlags(268435456);
    }

    private final void A06(AbstractC2094jd abstractC2094jd) {
        AdActivityIntent A05 = C1433Wu.A05(this.A03);
        A05(A05, abstractC2094jd);
        try {
            C1433Wu.A0B(this.A03, A05);
        } catch (Exception e) {
            this.A03.A08().ABC(A01(107, 11, 42), AbstractC1341Td.A0D, new C1342Te(e));
            Log.e(A01(90, 17, 80), A01(0, 90, 41), e);
        }
    }

    private void A07(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C1608bV c1608bV = new C1608bV(this.A03, this.A08, this.A00, this.A05, this.A04, this.A02.A2A());
        HashMap hashMap = new HashMap();
        hashMap.put(A01(Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 12, 105), A01(148, 9, 96));
        c1608bV.A05(this.A02.A2E(), str, hashMap);
    }

    public final void A08() {
        YB.A0J(this.A07.A0O());
        addView(this.A07.A0O(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void A9f() {
        A07(this.A02.A29().A0J().A05());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void A9g(String str) {
        A07(str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void A9k() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AAm() {
        new Handler(Looper.getMainLooper()).post(new JF(this));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AE0() {
        A06(this.A02);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AE4() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AEu(boolean z) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AFz() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AGX(boolean z) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AGZ(boolean z) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AGo(String str) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void AKD() {
        if (this.A06 != null) {
            this.A06.ADm(this);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1076Is
    public final void close() {
    }

    public VA getAdEventManager() {
        return this.A04;
    }

    public C1713dC getDynamicWebViewController() {
        return this.A07;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }

    public void setAdViewabilityChecker(C1874fp c1874fp) {
        this.A00 = c1874fp;
        this.A07.A0e(c1874fp);
    }
}
