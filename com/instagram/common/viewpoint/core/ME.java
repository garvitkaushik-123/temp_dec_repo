package com.instagram.common.viewpoint.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* loaded from: assets/audience_network/classes2.dex */
public final class ME extends AbstractC1492Zd {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (XX.A02 * 8.0f);
    public final RelativeLayout A00;
    public final C1219Og A01;
    public final C1929gi A02;

    public ME(C1929gi c1929gi, VA va, String str, C1199Nm c1199Nm, InterfaceC1471Yi interfaceC1471Yi, InterfaceC1470Yh interfaceC1470Yh) {
        super(c1929gi, va, str, c1199Nm, interfaceC1471Yi, interfaceC1470Yh);
        this.A02 = c1929gi;
        this.A01 = AbstractC1220Oh.A00(c1929gi.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        YB.A0N(this.A00, -1728053248);
        if (C1379Up.A2b(c1929gi)) {
            this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Zi
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ME.this.A0T(view);
                }
            });
        }
    }

    public static RelativeLayout.LayoutParams A00(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A01() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1492Zd
    public final void A0O() {
        C1223Ok A0A = this.A01.A0A();
        C1507Zs c1507Zs = new C1507Zs(this.A02);
        c1507Zs.setInfo(YM.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        c1507Zs.setOnClickListener(new ViewOnClickListenerC1498Zj(this));
        C1223Ok A0B = this.A01.A0B();
        C1507Zs c1507Zs2 = new C1507Zs(this.A02);
        c1507Zs2.setInfo(YM.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        c1507Zs2.setOnClickListener(new ViewOnClickListenerC1499Zk(this));
        C1507Zs c1507Zs3 = new C1507Zs(this.A02);
        c1507Zs3.setInfo(YM.AD_CHOICES_ICON, this.A01.A0M(), "");
        c1507Zs3.setOnClickListener(new ViewOnClickListenerC1500Zl(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        YB.A0N(linearLayout, -1);
        if (!A0A.A05().isEmpty()) {
            linearLayout.addView(c1507Zs, itemParams);
        }
        if (!A0B.A05().isEmpty()) {
            linearLayout.addView(c1507Zs2, itemParams);
        }
        linearLayout.addView(c1507Zs3, itemParams);
        A01();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A00(false));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1492Zd
    public final void A0P() {
        this.A00.removeAllViews();
        YB.A0J(this);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1492Zd
    public final void A0Q(C1223Ok c1223Ok, EnumC1221Oi enumC1221Oi) {
        String A0E;
        int i;
        String str;
        if (enumC1221Oi == EnumC1221Oi.A05) {
            return;
        }
        boolean z = enumC1221Oi == EnumC1221Oi.A06;
        C1489Za c1489Za = new C1489Za(this.A02, this.A0D);
        if (z) {
            C1219Og c1219Og = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            A0E = c1219Og.A0F();
        } else {
            A0E = this.A01.A0E();
        }
        C1489Za A0D = c1489Za.A0H(A0E).A0G(this.A01.A0D()).A0E(c1223Ok.A04()).A0D(z ? YM.REPORT_AD : YM.HIDE_AD);
        if (z) {
            i = -552389;
        } else {
            i = -13272859;
        }
        C1489Za A0C = A0D.A0C(i);
        if (this.A0C != null) {
            C1199Nm c1199Nm = this.A0C;
            if (A03[1].charAt(11) != 'X') {
                str = c1199Nm.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                str = c1199Nm.A01();
            }
        } else {
            str = "";
        }
        C1490Zb adHiddenView = A0C.A0F(str).A0L();
        YB.A0N(adHiddenView, -1);
        YB.A0W(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A00(true));
        super.A0Q(c1223Ok, enumC1221Oi);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1492Zd
    public final void A0R(C1223Ok c1223Ok, EnumC1221Oi enumC1221Oi) {
        String A0H;
        boolean z = enumC1221Oi == EnumC1221Oi.A06;
        C1929gi c1929gi = this.A02;
        InterfaceC1494Zf interfaceC1494Zf = this.A0D;
        if (z) {
            A0H = this.A01.A0L();
        } else {
            A0H = this.A01.A0H();
        }
        C1510Zv c1510Zv = new C1510Zv(c1929gi, c1223Ok, interfaceC1494Zf, A0H, z ? YM.REPORT_AD : YM.HIDE_AD);
        c1510Zv.setClickable(true);
        YB.A0N(c1510Zv, -1);
        c1510Zv.setPadding(A04 * 2, A04, A04 * 2, A04);
        A01();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(c1510Zv, A00(false));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1492Zd
    public final boolean A0S() {
        return false;
    }

    public final /* synthetic */ void A0T(View view) {
        this.A0D.A54();
    }
}
