package com.instagram.common.viewpoint.core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.text.NumberFormat;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.6H, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C6H extends AbstractC1110Ka {
    public static byte[] A0K;
    public static String[] A0L = {"zra6hnpaifP7bxfZB5bQOHnqie2tQjg", "wy9og3M9LeWlDzkU0RS7zgtaq3xQKlMR", "jyAiwm88v9hsYzrfl9gFIABQTfRULZfl", "Wwy1p0nUO1H5ggrsb6VvEsAvpBZyxSvp", "wjN7zQjrZyyYli8cgu97rk5B2y3BycTh", "DSxnyYt0igg0K0GbJ5jSMl2rvJzineXI", "irrLwQMNjn2DglpbBC8hfvG7oGwbzPRC", "9jAewdJckPVrzkqluL1z0QkIRDh51Ovv"};
    public static final int A0M;
    public static final int A0N;
    public static final int A0O;
    public static final int A0P;
    public static final int A0Q;
    public static final int A0R;
    public static final int A0S;
    public static final int A0T;
    public static final int A0U;
    public static final int A0V;
    public static final int A0W;
    public static final int A0X;
    public static final int A0Y;
    public View A00;
    public View A01;
    public ImageView A02;
    public C1929gi A03;
    public XO A04;
    public AbstractC1464Yb A05;
    public AbstractC1642c3 A06;
    public C1658cJ A07;
    public C1784eM A08;
    public C1790eS A09;
    public DA A0A;
    public boolean A0B;
    public boolean A0C;
    public final Handler A0D;
    public final InterfaceC1470Yh A0E;
    public final InterfaceC1620bh A0F;
    public final C1621bi A0G;
    public final C1646c7 A0H;
    public final C0966Ek A0I;
    public final DZ A0J;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 85);
        }
        return new String(copyOfRange);
    }

    public static void A0D() {
        A0K = new byte[]{-23, -117, 1, -6, Ascii.SI, -2, Ascii.CAN, Ascii.FF, Ascii.CR, -6, Ascii.VT, Ascii.CR, 2, 7, 0, Ascii.CAN, -6, 7, 2, 6, -6, Ascii.CR, 2, 8, 7, Ascii.FF, Ascii.CAN, 9, 5, -6, Ascii.DC2, -2, -3, Ascii.SUB, Ascii.GS, 33, 19, 45, 32, 19, 37, Ascii.SI, 32, Ascii.DC2, 45, 33, 17, 32, 19, 19, Ascii.FS, 45, 33, Ascii.SYN, Ascii.GS, 37, Ascii.FS, -7, -29, -11, 1, -25, -16, -26, 1, -27, -29, -12, -26, 1, -11, -22, -15, -7, -16, -17, -19, -33, -20, -35, -26, -29, -35, -27};
    }

    static {
        A0D();
        A0P = XV.A0b;
        A0X = XV.A0Z;
        A0M = (int) (XX.A02 * 8.0f);
        A0N = (int) (XX.A02 * 10.0f);
        A0S = (int) (XX.A02 * 20.0f);
        A0T = (int) (XX.A02 * 13.0f);
        A0Q = (int) (XX.A02 * 48.0f);
        A0W = (int) (XX.A02 * 14.0f);
        A0U = (int) (XX.A02 * 12.0f);
        A0O = XV.A0v;
        A0V = P3.A02(-1, 77);
        A0R = (int) (XX.A02 * 16.0f);
        A0Y = (int) (XX.A02 * 12.0f);
    }

    public C6H(C1646c7 c1646c7) {
        super(c1646c7, false);
        this.A0D = new Handler(Looper.getMainLooper());
        this.A0C = false;
        this.A0B = false;
        this.A03 = c1646c7.A06();
        this.A05 = c1646c7.A0B();
        this.A0H = c1646c7;
        this.A01 = new View(this.A03);
        YB.A0K(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.A01, layoutParams);
        A0A();
        this.A0E = c1646c7.A0C();
        AbstractC1630br.A00(c1646c7.A06(), this, getAdInfo().A0H().A08());
        this.A0I = A02(c1646c7);
        YB.A0K(this.A0I);
        getAdDetailsView().bringToFront();
        if (!A04()) {
            this.A0J = A03(c1646c7);
        } else {
            this.A0J = null;
        }
        if (getAdDataBundle().A1u()) {
            if (this.A0J != null) {
                this.A0J.setVisibility(8);
            }
            getAdDetailsView().setVisibility(8);
            A09();
        }
        A1S();
        this.A08 = new C1784eM(this.A03, c1646c7.A07(), getAdDataBundle());
        this.A0F = new KW(this);
        this.A0G = A01(c1646c7);
        XR A02 = super.A08.A02(getAdDataBundle());
        this.A03.A0H().A00(A02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(super.A08);
        if (A02.A00) {
            this.A0I.getVideoImplView().setOnClickListener(new ViewOnClickListenerC1649cA(this));
        } else if (C1379Up.A1L(getAdContextWrapper())) {
            AbstractC1589bC.A00(this.A0I.getVideoImplView(), C1379Up.A1M(getAdContextWrapper()), new ViewOnClickListenerC1650cB(this));
        }
        if (c1646c7.A05().A1o()) {
            if (this.A0H.A05().A1r()) {
                this.A06 = new KB(c1646c7);
            } else {
                this.A06 = new KD(c1646c7);
            }
            View view = this.A06;
            ViewGroup.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            addView(view, layoutParams2);
            getAdDetailsView().setVisibility(8);
        }
    }

    private C1621bi A01(C1646c7 c1646c7) {
        if (this.A0J != null) {
            return new C1621bi(c1646c7, getAdDataBundle(), this.A0I, this.A0J, getAdDetailsView(), this.A0E, this.A0F);
        }
        return new C1621bi(c1646c7, getAdDataBundle(), this.A0I, this.A0E, this.A0F, getAdDetailsView());
    }

    private C0966Ek A02(C1646c7 c1646c7) {
        RelativeLayout.LayoutParams layoutParams;
        C0966Ek c0966Ek = (C0966Ek) c1646c7.A02();
        if (c0966Ek == null) {
            c0966Ek = new C0966Ek(this.A03);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (getAdDataBundle().A1u()) {
            c0966Ek.getVideoView().setPadding(c0966Ek.getVideoView().getPaddingLeft(), c0966Ek.getVideoView().getPaddingTop(), c0966Ek.getVideoView().getPaddingRight(), c0966Ek.getVideoView().getPaddingBottom() + A0Y);
        }
        layoutParams2.addRule(13);
        addView(c0966Ek, layoutParams2);
        int A1Q = A1Q(c1646c7.A0B());
        this.A02 = (ImageView) c1646c7.A03();
        if (this.A02 != null) {
            if (!A04()) {
                ImageView imageView = this.A02;
                int i = AbstractC1110Ka.A0J;
                int toolbarHeight = AbstractC1110Ka.A0J;
                imageView.setPadding(i, toolbarHeight, AbstractC1110Ka.A0J, AbstractC1110Ka.A0J);
                layoutParams = new RelativeLayout.LayoutParams(AbstractC1110Ka.A0K, AbstractC1110Ka.A0K);
                layoutParams.setMargins(0, A1Q, AbstractC1110Ka.A0I, 0);
                layoutParams.addRule(11);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(AbstractC1642c3.A0A, AbstractC1642c3.A0A);
                int i2 = XV.A0b;
                int toolbarHeight2 = XV.A0r;
                layoutParams.setMargins(i2, toolbarHeight2, XV.A0b, XV.A0Z);
                layoutParams.addRule(9);
            }
            layoutParams.addRule(10);
            c0966Ek.addView(this.A02, layoutParams);
        }
        return c0966Ek;
    }

    private DZ A03(C1646c7 c1646c7) {
        DZ A0E = c1646c7.A0E();
        if (A0E == null) {
            return null;
        }
        A0E.A08(-1, AbstractC1110Ka.A0C, false);
        A0E.setPadding(AbstractC1110Ka.A0N, AbstractC1110Ka.A0N, AbstractC1110Ka.A0N, AbstractC1110Ka.A0N);
        RelativeLayout.LayoutParams progressBarLayoutParams = new RelativeLayout.LayoutParams(-1, AbstractC1110Ka.A0M);
        progressBarLayoutParams.addRule(12);
        addView(A0E, progressBarLayoutParams);
        return A0E;
    }

    private void A05() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (this.A09 != null) {
            addView(this.A09.A0W(), layoutParams);
        }
    }

    private void A06() {
        this.A07 = new C1658cJ(this.A0H.A06(), getAdDataBundle(), this.A0H.A08(), this.A0D, this.A0H.A0C());
        addView(this.A07.A0C(getCtaButton()));
    }

    private void A07() {
        YB.A0d(this.A02, getCtaButton(), getAdDetailsView(), this.A01, this.A0G, this.A0H.A0B());
        for (InterfaceC1817eu interfaceC1817eu : this.A0I.getPlugins()) {
            if (interfaceC1817eu instanceof AnonymousClass34) {
                this.A0I.A0g(interfaceC1817eu);
                return;
            }
        }
    }

    private void A08() {
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A0H();
            this.A0I.A0g(getAnimationPlugin());
        }
    }

    private void A09() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        A0E(relativeLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A0P, 0);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams appMetadataLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        appMetadataLayoutParams.setMargins(A0P, A0X, A0P, A0X);
        appMetadataLayoutParams.addRule(12);
        relativeLayout2.addView(relativeLayout, layoutParams2);
        ViewOnClickListenerC1127Kr ctaButton = getCtaButton();
        ctaButton.setTextSize(14.0f);
        ctaButton.setIncludeFontPadding(false);
        ctaButton.setTextColor(-1);
        layoutParams2.addRule(0, ctaButton.getId());
        if (!getAdDataBundle().A1s()) {
            ctaButton.setPadding(A0N, A0N, A0N, A0N);
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(6, relativeLayout.getId());
            layoutParams.addRule(8, relativeLayout.getId());
            ctaButton.setBackgroundColor(-12549889);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            YB.A0V(ctaButton, YB.A06(-16738826, A0M));
            ctaButton.setPadding(A0S, A0T, A0S, A0T);
            ctaButton.setStateListAnimator(null);
            YB.A0Z(ctaButton);
        }
        layoutParams.addRule(11);
        if (ctaButton.getParent() != null) {
            YB.A0d(ctaButton);
        }
        relativeLayout2.addView(ctaButton, layoutParams);
        addView(relativeLayout2, appMetadataLayoutParams);
        relativeLayout2.bringToFront();
    }

    private void A0A() {
        if (this.A05 != null && !getAdDataBundle().A1W()) {
            this.A0A = new DA(this.A05, 400, -this.A05.getToolbarHeight(), 0);
        }
    }

    private void A0B() {
        new VI(getAdDataBundle().A2E(), getAdEventManager()).A04(VH.A0z, null);
        if (!getAdInfo().A0V()) {
            return;
        }
        super.A09.set(true);
        YB.A0W(this);
        YB.A0d(this.A0J, this.A0G, this.A00);
        YB.A0L(this.A05);
        Pair<EnumC1783eL, View> A03 = this.A08.A03(getCtaButton());
        this.A00 = (View) A03.second;
        A0F((EnumC1783eL) A03.first);
        if (getAdInfo().A0K().A00() >= 0) {
            this.A0B = true;
            if (this.A05 != null) {
                this.A05.setToolbarActionMode(getAdDataBundle().A2P() ? 8 : 2);
                this.A05.setProgressImmediate(0.0f);
            }
            this.A04 = new XO((int) getAdInfo().A0K().A00(), 20.0f, 20L, new Handler(Looper.getMainLooper()), new KV(this));
            this.A04.A07();
        }
    }

    private void A0C() {
        if (this.A0A != null) {
            this.A0A.A4A(true, false);
        }
        if (!A04() && !getAdDataBundle().A1u() && getAdDetailsAnimation() != null) {
            DA adDetailsAnimation = getAdDetailsAnimation();
            String[] strArr = A0L;
            if (strArr[3].charAt(21) == strArr[6].charAt(21)) {
                throw new RuntimeException();
            }
            A0L[1] = "NNplzEPPEJhw482VYN3vhqCWu3reteuX";
            adDetailsAnimation.A4A(true, false);
        }
    }

    private void A0E(RelativeLayout relativeLayout) {
        int i;
        String formattingRatingCount;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0Q, A0Q);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        C1623bk c1623bk = new C1623bk(this.A03);
        YB.A0N(c1623bk, 0);
        YB.A0K(c1623bk);
        new LM(c1623bk, this.A03).A05(A0Q, A0Q).A07(getAdDataBundle().A2C().A01());
        TextView textView = new TextView(this.A03);
        YB.A0K(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(getAdDataBundle().A28().A01().A07(true));
        textView.setText(getAdDataBundle().A29().A0I().A0G());
        textView.setTextSize(!getAdDataBundle().A1s() ? 16.0f : 17.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        C1929gi c1929gi = this.A03;
        if (!getAdDataBundle().A1s()) {
            i = A0W;
        } else {
            i = A0U;
        }
        C1625bm c1625bm = new C1625bm(c1929gi, i, 5, A0V, -1);
        c1625bm.setGravity(16);
        LinearLayout.LayoutParams ratingCountParams = new LinearLayout.LayoutParams(-2, -1);
        TextView textView2 = new TextView(this.A03);
        textView2.setTextColor(getAdDataBundle().A28().A01().A07(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        if (!getAdDataBundle().A1s()) {
            textView2.setTextSize(13.0f);
        }
        LinearLayout.LayoutParams starRatingContainerParams = new LinearLayout.LayoutParams(-2, -1);
        starRatingContainerParams.leftMargin = A0O;
        LinearLayout linearLayout = new LinearLayout(this.A03);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams ratingInfoContainerParams = new RelativeLayout.LayoutParams(-2, A0R);
        ratingInfoContainerParams.topMargin = A0O / 2;
        ratingInfoContainerParams.addRule(3, textView.getId());
        linearLayout.addView(c1625bm, ratingCountParams);
        linearLayout.addView(textView2, starRatingContainerParams);
        RelativeLayout.LayoutParams iconParams = new RelativeLayout.LayoutParams(-2, -2);
        iconParams.leftMargin = A0O;
        iconParams.addRule(1, c1623bk.getId());
        iconParams.addRule(15);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        relativeLayout2.addView(linearLayout, ratingInfoContainerParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2, iconParams);
        relativeLayout.addView(c1623bk, layoutParams);
        if (TextUtils.isEmpty(getAdDataBundle().A29().A0I().A0C())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        c1625bm.setRating(Float.parseFloat(getAdDataBundle().A29().A0I().A0C()));
        if (getAdDataBundle().A29().A0I().A09() == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A04(0, 1, 108));
        if (!getAdDataBundle().A1s()) {
            formattingRatingCount = NumberFormat.getNumberInstance().format(Integer.parseInt(getAdDataBundle().A29().A0I().A09()));
        } else {
            formattingRatingCount = AbstractC1443Xg.A01(Integer.parseInt(getAdDataBundle().A29().A0I().A09()));
        }
        sb.append(formattingRatingCount);
        String formattingRatingCount2 = A04(1, 1, 13);
        sb.append(formattingRatingCount2);
        String formattingRatingCount3 = sb.toString();
        textView2.setText(formattingRatingCount3);
    }

    private void A0F(EnumC1783eL enumC1783eL) {
        if (!getAdDataBundle().A29().A0K().A02().isEmpty()) {
            if (getAdDataBundle().A29().A0K().A03()) {
                this.A09 = new C1790eS(this.A03, getAdDataBundle(), this.A0E, getCtaButton(), this.A0D, this.A0H.A08());
                YB.A0d(this.A05, getAdDetailsView(), this.A02);
                A05();
                return;
            }
        } else if (getAdDataBundle().A29().A0K().A03() || getAdDataBundle().A29().A0K().A04()) {
            A07();
            A06();
            return;
        }
        A0G(enumC1783eL);
    }

    private void A0G(EnumC1783eL enumC1783eL) {
        if (this.A00 == null) {
        }
        this.A0I.A0h(false);
        this.A0I.setVisibility(8);
        switch (enumC1783eL) {
            case A03:
                getAdDetailsView().setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, A1Q(this.A05), 0, 0);
                layoutParams.addRule(2, getAdDetailsView().getId());
                addView(this.A00, layoutParams);
                break;
            case A02:
                YB.A0d(getAdDetailsView());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.setMargins(AbstractC1110Ka.A0L, AbstractC1110Ka.A0L, AbstractC1110Ka.A0L, AbstractC1110Ka.A0L);
                addView(this.A00, layoutParams2);
                break;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1110Ka, com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1C() {
        super.A1C();
        A08();
        getAdDetailsView().A0j();
        if (this.A09 != null) {
            this.A09.A0Y();
        }
        if (this.A07 != null) {
            this.A07.A0F();
        }
        this.A0D.removeCallbacksAndMessages(null);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1110Ka, com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1H(NR nr, String str, double d, Bundle bundle) {
        super.A1H(nr, str, d, bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.getBoolean(A04(2, 31, 100), false)) {
            A0C();
        }
        if (bundle.getBoolean(A04(57, 18, 77), false)) {
            A0B();
        }
        if (bundle.getBoolean(A04(33, 24, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), false)) {
            this.A0G.A07(this);
        }
        if (A04()) {
            boolean z = getAdDetailsView() instanceof LK;
            if (A0L[2].charAt(18) == 'X') {
                throw new RuntimeException();
            }
            String[] strArr = A0L;
            strArr[3] = "TYF9Gze5okVE8nAMFw0kZuTKWJAG4GPN";
            strArr[6] = "e5C8lQxoH1vEX5uTYGqpe7vBIorNDTyW";
            if (z) {
                ((LK) getAdDetailsView()).A0q();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1I(C4K c4k) {
        super.A1I(c4k);
        if (A04()) {
            AbstractC2094jd adDataBundle = getAdDataBundle();
            if (A0L[4].charAt(31) == 'A') {
                throw new RuntimeException();
            }
            A0L[0] = "gTgOd0";
            if (!adDataBundle.A1W()) {
                removeView(getAdDetailsView());
            }
        }
        A0B();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1J(E1 e1) {
        super.A1J(e1);
        if (this.A06 != null && this.A06.getVisibility() == 0) {
            return;
        }
        if (A04()) {
            this.A03.A0F().AKh(XL.A00((float) this.A0H.A05().A0k()), getResources().getConfiguration().orientation, true, false, AbstractC1181Mt.A0C(this.A0H.A04()));
        }
        A1a(getResources().getConfiguration().orientation);
        if (getAdDataBundle().A1e()) {
            this.A0I.setOnClickListener(getCtaButton());
        }
        if (A04()) {
            getAdDetailsView().setVisibility(0);
            if (getAdDetailsView() instanceof LK) {
                ((LK) getAdDetailsView()).A0u(getResources().getConfiguration().orientation);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1K(C4A c4a, int i) {
        super.A1K(c4a, i);
        int videoLengthMs = c4a.A00();
        int remainingVideoTimeInMillis = this.A0I.getDuration();
        int videoLengthMs2 = remainingVideoTimeInMillis - videoLengthMs;
        if (getAnimationPlugin() != null && videoLengthMs2 < 3000 && getAnimationPlugin().A0M()) {
            getAnimationPlugin().A0I();
        }
        if ((getAdDetailsView() instanceof LK) && !this.A0H.A05().A1r()) {
            int currentPosMs = c4a.A00();
            ((LK) getAdDetailsView()).A0s(((remainingVideoTimeInMillis * i) + currentPosMs) / 1000);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final void A1L(boolean z) {
        super.A1L(z);
        getAdDetailsView().A0m(z);
        if (this.A06 != null) {
            this.A06.A1L(z);
        }
        if (this.A09 != null) {
            this.A09.A0e(z);
        }
        C1658cJ c1658cJ = this.A07;
        if (A0L[2].charAt(18) == 'X') {
            throw new RuntimeException();
        }
        A0L[0] = "DykuMGFkjhCaLudJ";
        if (c1658cJ != null) {
            this.A07.A0H(z);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final boolean A1M() {
        return getAdInfo().A0V();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final boolean A1O() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public final boolean A1P(boolean z) {
        if (z && !this.A0C && !super.A09.get()) {
            this.A0G.A07(this);
            return true;
        }
        if (!getAdInfo().A0V()) {
            return false;
        }
        boolean z2 = super.A09.get();
        if (A0L[4].charAt(31) == 'A') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[3] = "EPxoCM5ZHywZjaL2iUUSFMk3WFd5m6XL";
        strArr[6] = "lTBjgNJWw5Z4CB7iubQhWZLtOmC1X7yD";
        if (!z2) {
            this.A0I.A0d(EnumC1808el.A08);
            return true;
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1110Ka
    public final AbstractC1592bF A1R(C1646c7 c1646c7, NR nr, String str) {
        double A0k = c1646c7.A05().A0k();
        if (A04()) {
            return new C1631bs((float) A0k, str, c1646c7.A06(), getColors(), c1646c7.A05(), c1646c7.A0C(), getCtaButton(), AbstractC1110Ka.A0G, false, c1646c7.A07(), c1646c7.A0F(), c1646c7.A0A(), c1646c7.A0E(), c1646c7.A08(), false).A03();
        }
        return new C1113Kd(c1646c7.A06(), getCtaButton(), AbstractC1110Ka.A0H, nr.A0I().A00() == NW.A05, getColors(), nr.A0J().A06(), str, c1646c7.A07(), c1646c7.A0C(), c1646c7.A0F(), c1646c7.A0A(), c1646c7.A05());
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1110Ka
    public final void A1S() {
        super.A1S();
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().AAv(this.A0I);
        }
    }

    public final void A1X() {
        getCtaButton().A0E(A04(75, 9, 37));
    }

    public final void A1Y() {
        if (getAdDetailsView() instanceof LK) {
            ((LK) getAdDetailsView()).setPlaceHolderTextForRewardsConversion(getAdDataBundle().A1A());
        }
    }

    public final void A1Z() {
        new VI(this.A0H.A05().A2E(), getAdEventManager()).A04(VH.A0h, null);
        if (this.A0H.A0B() != null) {
            AbstractC1464Yb A0B = this.A0H.A0B();
            if (A0L[4].charAt(31) == 'A') {
                throw new RuntimeException();
            }
            A0L[2] = "qVUXWES3bTCAG5k5pbCpCu4g17099rEp";
            A0B.setVisibility(8);
            removeView(this.A0H.A0B());
        }
        removeView(this.A06);
        removeView(this.A0I);
        A08();
        removeView(getAdDetailsView());
        removeView(this.A0J);
        removeView(this.A00);
        if (this.A09 != null) {
            removeView(this.A09.A0X());
        }
        if (this.A0H.A05().A1r()) {
            A1U();
        } else {
            A1T();
        }
    }

    public final void A1a(int i) {
        if (!A04()) {
            return;
        }
        this.A03.A0F().AKj(i);
        this.A0I.A0Z(i);
        A1V(i, this.A0I, (RelativeLayout) this.A0I.getVideoView());
    }

    public final void A1b(C4L c4l) {
        if (this.A06 != null) {
            if (this.A06 instanceof KB) {
                ((KB) this.A06).A1Q(c4l);
            }
            if (this.A06 instanceof KD) {
                ((KD) this.A06).A1Q(c4l);
            }
            this.A06.A1C();
            AbstractC1642c3 abstractC1642c3 = this.A06;
            String[] strArr = A0L;
            if (strArr[3].charAt(21) == strArr[6].charAt(21)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[3] = "wl3lZ2t8QgZzPvgxh0a22wDB24cvqHL6";
            strArr2[6] = "goKzKnMqtJl7yehw7GAGrdNRW8UKCTH6";
            removeView(abstractC1642c3);
            this.A06 = null;
        }
        getAdDetailsView().setVisibility(0);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1642c3
    public int getCloseButtonStyle() {
        if (getAdDataBundle().A1v() && this.A05 != null) {
            return this.A05.getToolbarActionMode();
        }
        if (this.A0B) {
            if (getAdDataBundle().A2P()) {
                return 8;
            }
            return 2;
        }
        if (A1M() && !super.A09.get()) {
            return 1;
        }
        return super.getCloseButtonStyle();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1110Ka, com.instagram.common.viewpoint.core.AbstractC1642c3, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.A06 != null) {
            AbstractC1642c3 abstractC1642c3 = this.A06;
            if (A0L[0].length() == 5) {
                throw new RuntimeException();
            }
            A0L[4] = "EpyE2nRNkziEqwhglEeRfTluajKoT9IB";
            if (abstractC1642c3.getVisibility() == 0) {
                getAdDetailsView().setVisibility(8);
                return;
            }
        }
        if (getAdDataBundle().A29().A0K().A03() && this.A09 != null && super.A09.get()) {
            this.A09.A0a(configuration.orientation);
        } else {
            A1a(configuration.orientation);
        }
    }

    public void setVideoAdViewListener(InterfaceC1759dx interfaceC1759dx) {
        if (this.A06 instanceof KB) {
            ((KB) this.A06).setVideoAdViewListener(interfaceC1759dx);
        }
        if (this.A06 instanceof KD) {
            ((KD) this.A06).setVideoAdViewListener(interfaceC1759dx);
        }
    }
}
