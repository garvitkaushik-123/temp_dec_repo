package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* renamed from: com.facebook.ads.redexgen.X.eM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1784eM {
    public ViewOnClickListenerC1127Kr A00;
    public final NN A01;
    public final NY A02;
    public final C1190Nd A03;
    public final C1199Nm A04;
    public final C1929gi A05;
    public final VI A06;
    public static final int A09 = (int) (XX.A02 * 4.0f);
    public static final int A07 = (int) (XX.A02 * 72.0f);
    public static final int A08 = (int) (XX.A02 * 8.0f);

    public C1784eM(C1929gi c1929gi, VA va, AbstractC2094jd abstractC2094jd) {
        this.A05 = c1929gi;
        this.A06 = new VI(abstractC2094jd.A2E(), va);
        this.A01 = abstractC2094jd.A28();
        this.A02 = abstractC2094jd.A29().A0I();
        this.A04 = abstractC2094jd.A2C();
        this.A03 = abstractC2094jd.A29().A0K();
    }

    private View A00(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        C1629bq c1629bq = new C1629bq(this.A05, this.A01.A01(), true, false, false);
        c1629bq.A04(this.A02.A0G(), this.A02.A04(), null, false, true);
        c1629bq.setAlignment(17);
        C1623bk c1623bk = new C1623bk(this.A05);
        YB.A0N(c1623bk, 0);
        c1623bk.setRadius(50);
        new LM(c1623bk, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1623bk, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c1629bq, layoutParams);
        if (viewOnClickListenerC1127Kr != null) {
            YB.A0J(viewOnClickListenerC1127Kr);
            linearLayout.addView(viewOnClickListenerC1127Kr, layoutParams);
            viewOnClickListenerC1127Kr.setPadding(XV.A0Z, 0, XV.A0Z, 0);
            if (TextUtils.isEmpty(viewOnClickListenerC1127Kr.getText())) {
                YB.A0H(viewOnClickListenerC1127Kr);
            }
        }
        return linearLayout;
    }

    private C7M A01() {
        C7M c7m = new C7M(this.A05);
        c7m.setLayoutManager(new C1999hr(this.A05, 0, false));
        c7m.setAdapter(new FH(this.A05, this.A03.A02(), A09, this.A00));
        return c7m;
    }

    private final EnumC1783eL A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC1783eL.A03;
        }
        return EnumC1783eL.A02;
    }

    public final Pair<EnumC1783eL, View> A03(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        View A01;
        this.A00 = viewOnClickListenerC1127Kr;
        EnumC1783eL A02 = A02();
        switch (A02) {
            case A03:
                A01 = A01();
                break;
            default:
                A01 = A00(this.A00);
                break;
        }
        VK.A04(A01, this.A06, VH.A0S);
        return new Pair<>(A02, A01);
    }
}
