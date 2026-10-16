package com.instagram.common.viewpoint.core;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.4x, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C07384x extends AbstractC1016Gj {
    public static byte[] A07;
    public static String[] A08 = {"opNTFb7MfNeLnBf1OFt8H8u3IMVbRu1d", "IWQCWQwp5ID5RPcOdaIzYqbwlbVDrClG", "KvkPuVSJhScWrt17epNc", "F0ODCmRg5uMMagWpVfR8fmvJ1OUGt5pq", "F5r", "wG3QjEZJL94bFBL8PiZK", "A8E1xGSXICDDUeWE8x490gS0hcqgXwJC", "2T9PYA9x4VF1QbksNYikemvLXt0jGXOu"};
    public AbstractC1642c3 A00;
    public DZ A01;
    public final ImageView A02;
    public final InterfaceC1297Rk A03;
    public final AtomicBoolean A04;
    public final AtomicBoolean A05;
    public final AtomicBoolean A06;

    public static String A03(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 61);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{-17, -25, -27, -20};
    }

    static {
        A07();
    }

    public C07384x(C1929gi c1929gi, ZU zu, VA va, AbstractC2094jd abstractC2094jd, C1335Sx c1335Sx, InterfaceC1470Yh interfaceC1470Yh) {
        super(c1929gi, zu, va, abstractC2094jd, c1335Sx, interfaceC1470Yh);
        this.A03 = new C1009Gc(this);
        this.A05 = new AtomicBoolean(false);
        this.A04 = new AtomicBoolean(false);
        this.A06 = new AtomicBoolean(false);
        this.A02 = new ImageView(getContext());
        if (abstractC2094jd.A29().A0H().A04() > 0) {
            this.A01 = new DZ(c1929gi, abstractC2094jd.A29().A0H().A04() * 1000);
        }
        this.A02.setScaleType(ImageView.ScaleType.CENTER);
        this.A02.setAdjustViewBounds(true);
        new LM(this.A02, super.A05).A05(super.A03.A29().A0H().A00(), super.A03.A29().A0H().A01()).A06(new C1008Gb(this)).A07(super.A03.A29().A0H().A08());
    }

    private AbstractC1642c3 A01(int i) {
        if (this.A02.getParent() != null) {
            YB.A0J(this.A02);
        }
        C1645c6 A0M = new C1645c6(super.A05, super.A06, this.A0A, super.A03, this.A02, this.A0C, this.A08).A0J(this.A09.getToolbarHeight()).A0P(this.A09).A0I(i).A0M(this.A07);
        if (this.A01 != null) {
            A0M.A0R(this.A01);
        }
        A0M.A0L(C1182Mu.A00(super.A05, super.A06, A03(0, 0, 52), XB.A00(super.A03.A29().A0J().A05()), new HashMap(), super.A03.A2A()));
        C1646c7 params = A0M.A0U();
        return AbstractC1643c4.A00(params, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A05.get() && this.A04.get()) {
            A0e();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if ((r6 instanceof com.instagram.common.viewpoint.core.AbstractC1110Ka) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A08(int i) {
        boolean z;
        YB.A0J(this.A00);
        this.A00 = A01(i);
        this.A00.setAccidentalClickCappingListener(new InterfaceC1179Mr() { // from class: com.facebook.ads.redexgen.X.Gd
            @Override // com.instagram.common.viewpoint.core.InterfaceC1179Mr
            public final void ACk() {
                C07384x.this.A0n();
            }
        });
        C1187Na colors = this.A00.getColors();
        Integer backgroundColorForToolbar = getBackgroundColorForToolbar();
        boolean z2 = true;
        if (backgroundColorForToolbar == null) {
            if (this.A00 != null) {
                if (!this.A00.A1O()) {
                    AbstractC1642c3 abstractC1642c3 = this.A00;
                    if (A08[4].length() == 3) {
                        String[] strArr = A08;
                        strArr[2] = "fKHhGKaWmtnLqlWg01lC";
                        strArr[5] = "lG6mBbCbmu9ZuvMubYOS";
                    }
                    throw new RuntimeException();
                }
                z = true;
                YB.A0N(this, colors.A08(z));
            }
            z = false;
            YB.A0N(this, colors.A08(z));
        } else {
            int intValue = backgroundColorForToolbar.intValue();
            String[] strArr2 = A08;
            if (strArr2[2].length() != strArr2[5].length()) {
                YB.A0N(this, intValue);
            } else {
                A08[0] = "OBMiQo8I4Ts7yjqshk6bkpwsmCqa0sTm";
                YB.A0N(this, intValue);
            }
        }
        AbstractC1464Yb abstractC1464Yb = this.A09;
        String[] strArr3 = A08;
        if (strArr3[2].length() == strArr3[5].length()) {
            String[] strArr4 = A08;
            strArr4[2] = "a7i0pPPxGgijq0ih0stJ";
            strArr4[5] = "yYRdNfPwhLNXT50Mgldr";
            abstractC1464Yb.setFullscreen(this.A00.A1O());
            this.A09.A0D(colors, ViewOnClickListenerC1127Kr.A05(super.A03));
            A0j(this.A00);
            if (super.A01 != null) {
                addView(super.A01, 0, AbstractC1016Gj.A0H);
            }
            if (this.A00 == null || !this.A00.A1O()) {
                z2 = false;
            }
            setUpFullscreenMode(z2);
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj
    public final AbstractC1464Yb A0c() {
        AbstractC1464Yb A0c = super.A0c();
        if (super.A03.A2T()) {
            A0c.setOnClickListener(new ViewOnClickListenerC1750dn(this));
        }
        return A0c;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj
    public final void A0g() {
        if (this.A00 != null) {
            this.A07.A04(VH.A0Y, null);
            EnumC1178Mq A1B = this.A00.A1B(A03(0, 4, 63));
            if (super.A03.A2N()) {
                return;
            }
            EnumC1178Mq actionOutcome = EnumC1178Mq.A09;
            if (A1B != actionOutcome) {
                EnumC1178Mq actionOutcome2 = EnumC1178Mq.A06;
                if (A1B != actionOutcome2) {
                    A0f();
                }
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj
    public final void A0h() {
        YB.A0L(this.A00);
        YB.A0L(this.A09);
        this.A04.set(true);
        A06();
        int A04 = super.A03.A29().A0H().A04();
        int secondsForNextCta = super.A03.A29().A0H().A02();
        if (A04 > 0) {
            if (this.A00 != null) {
                this.A00.A1G();
            }
            A0i(A04, new C1007Ga(this), this.A01);
            if (secondsForNextCta == 0 || secondsForNextCta >= A04) {
                super.A02 = true;
                this.A09.setToolbarActionMode(8);
                return;
            } else {
                if (secondsForNextCta <= 0) {
                    return;
                }
                this.A09.setProgressSpinnerInvisible(true);
                A0i(secondsForNextCta, new GZ(this), null);
                return;
            }
        }
        this.A06.set(true);
        AbstractC1464Yb abstractC1464Yb = this.A09;
        int unskippableSeconds = getCloseButtonStyle();
        abstractC1464Yb.setToolbarActionMode(unskippableSeconds);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj
    public final void A0k(C1291Re c1291Re) {
        FrameLayout.LayoutParams layoutParams;
        c1291Re.A0A(this.A03);
        int orientation = c1291Re.A05().getResources().getConfiguration().orientation;
        A08(orientation);
        if (A0m()) {
            YB.A0J(this.A09);
        }
        if (A0m()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            Rect requestedMargins = this.A09.getRequestedMargins();
            if (requestedMargins == null) {
                layoutParams.setMargins(0, XV.A0r, 0, 0);
            } else {
                int i = requestedMargins.left;
                int i2 = requestedMargins.top;
                int i3 = requestedMargins.right;
                int i4 = requestedMargins.bottom;
                if (A08[4].length() != 3) {
                    throw new RuntimeException();
                }
                A08[0] = "j24x2xTHwZJixq019qlFmxSWfXtsmamW";
                layoutParams.setMargins(i, i2, i3, i4);
            }
        } else {
            int orientation2 = this.A09.getToolbarHeight();
            layoutParams = new FrameLayout.LayoutParams(-1, orientation2);
        }
        addView(this.A09, layoutParams);
        YB.A0H(this.A00);
        YB.A0H(this.A09);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj
    public final boolean A0l() {
        if (this.A00 == null) {
            return false;
        }
        AbstractC1642c3 abstractC1642c3 = this.A00;
        if (A08[4].length() != 3) {
            throw new RuntimeException();
        }
        A08[4] = "kMg";
        return abstractC1642c3.A1P(false);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj
    public final boolean A0m() {
        return super.A03.A1j() || super.A03.A1y();
    }

    public final /* synthetic */ void A0n() {
        A0f();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFA(boolean z) {
        if (this.A00 != null) {
            this.A00.A1L(z);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void AFi(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCloseButtonStyle() {
        if (this.A00 != null) {
            return this.A00.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!super.A03.A29().A0T() && !A0m()) {
            A08(configuration.orientation);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1016Gj, com.instagram.common.viewpoint.core.InterfaceC1471Yi
    public final void onDestroy() {
        if (C1379Up.A1z(super.A05)) {
            super.A05.A0B().AKU(this.A02);
        }
        if (this.A00 != null) {
            AbstractC1642c3 abstractC1642c3 = this.A00;
            String[] strArr = A08;
            if (strArr[6].charAt(10) != strArr[1].charAt(10)) {
                throw new RuntimeException();
            }
            A08[4] = "hIQ";
            abstractC1642c3.A1C();
        }
        super.onDestroy();
    }
}
