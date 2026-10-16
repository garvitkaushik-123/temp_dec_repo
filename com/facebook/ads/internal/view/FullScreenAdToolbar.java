package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.instagram.common.viewpoint.core.AbstractC1464Yb;
import com.instagram.common.viewpoint.core.AbstractC1633bu;
import com.instagram.common.viewpoint.core.C1187Na;
import com.instagram.common.viewpoint.core.C1199Nm;
import com.instagram.common.viewpoint.core.C1205Ns;
import com.instagram.common.viewpoint.core.C1766e4;
import com.instagram.common.viewpoint.core.C1929gi;
import com.instagram.common.viewpoint.core.InterfaceC1463Ya;
import com.instagram.common.viewpoint.core.InterfaceC1470Yh;
import com.instagram.common.viewpoint.core.VI;
import com.instagram.common.viewpoint.core.ViewOnClickListenerC1127Kr;
import com.instagram.common.viewpoint.core.ViewOnClickListenerC1479Yq;
import com.instagram.common.viewpoint.core.XX;
import com.instagram.common.viewpoint.core.YB;
import com.instagram.common.viewpoint.core.YM;
import com.instagram.common.viewpoint.core.YZ;
import com.instagram.common.viewpoint.core.ZC;
import com.instagram.common.viewpoint.core.ZK;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class FullScreenAdToolbar extends AbstractC1464Yb {
    public static byte[] A0B;
    public static String[] A0C = {"bFTGQZCDUsZohbmTeIVqSIHEteTzH9ln", "yXw5A2C", "1AgOSkHO0Pb00RrFT9UOiqy", "TxDFqDHdXRoHKl2DTNxbpTLqI26RISWJ", "CWbWmw8OaNX6ff1fhEYiHQW6wjCjGro9", "znIzyGoGhCcdAsXYdQkLlPNG9alZ5sNL", "lf2qO9K", "XEgUxEHpppw1PxIgjlcxmDWHelwWu1Ow"};
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public YZ A00;
    public InterfaceC1463Ya A01;
    public InterfaceC1463Ya A02;
    public ZC A03;
    public boolean A04;
    public boolean A05;
    public final RelativeLayout A06;
    public final VI A07;
    public final InterfaceC1470Yh A08;
    public final ZK A09;
    public final C1766e4 A0A;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 22);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        byte[] bArr = {113, -102, -99, -95, -109, 78, 111, -110, -100, -81, -70, -71, -68, -66, 106, -117, -82, -71, -76, -76, -79, -89, -90, -73};
        if (A0C[5].charAt(20) != 'l') {
            throw new RuntimeException();
        }
        A0C[2] = "ATFpsL3dKIxr1CEZIKZeGPZ";
        A0B = bArr;
    }

    static {
        A03();
        A0D = (int) (XX.A02 * 10.0f);
        A0H = (int) (XX.A02 * 16.0f);
        A0F = A0H - A0D;
        A0G = (A0H * 2) - A0D;
        A0E = (int) (XX.A02 * 4.0f);
    }

    public FullScreenAdToolbar(C1929gi c1929gi, InterfaceC1470Yh interfaceC1470Yh, VI vi, int i, int i2, boolean z) {
        super(c1929gi);
        this.A01 = null;
        this.A04 = true;
        this.A05 = z;
        this.A08 = interfaceC1470Yh;
        this.A07 = vi;
        setGravity(16);
        this.A09 = new ZK(c1929gi, i, z);
        this.A09.setContentDescription(A02(0, 8, 24));
        this.A09.setActionClickListener(new ViewOnClickListenerC1479Yq(this));
        if (!this.A05) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A09, layoutParams);
            this.A06 = new RelativeLayout(c1929gi);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            this.A0A = new C1766e4(c1929gi);
            YB.A0G(1006, this.A0A);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            this.A0A.setLayoutParams(layoutParams3);
            this.A06.addView(this.A0A);
            addView(this.A06, layoutParams2);
            if (i2 != -1) {
                A0G(c1929gi, i2);
                return;
            }
            return;
        }
        if (i2 != -1) {
            A0G(c1929gi, i2);
        }
        this.A06 = new RelativeLayout(c1929gi);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.A0A = new C1766e4(c1929gi);
        YB.A0G(1006, this.A0A);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        this.A0A.setLayoutParams(layoutParams5);
        this.A06.addView(this.A0A);
        addView(this.A06, layoutParams4);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
        addView(this.A09, layoutParams6);
    }

    private void A04(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final void A08() {
        super.A08();
        if (this.A00 != null) {
            this.A00.setVisibility(8);
        }
        if (this.A03 != null) {
            this.A03.setVisibility(8);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final void A09() {
        this.A09.A02();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final void A0A() {
        if (this.A01 != null) {
            this.A02 = this.A01;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final void A0B() {
        this.A01 = getToolbarListener();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final void A0C(float f, int i) {
        this.A09.A03(f, i);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final void A0D(C1187Na c1187Na, boolean z) {
        boolean z2 = this.A04;
        int A05 = c1187Na.A05(z2);
        this.A0A.A02(c1187Na.A0B(z2), A05);
        boolean z3 = this.A05;
        String A02 = A02(8, 9, 52);
        if (!z3) {
            if (this.A00 != null) {
                this.A00.setIconColors(A05);
                this.A00.setContentDescription(A02);
            }
        } else if (this.A03 != null) {
            this.A03.setIconColors(A05);
            this.A03.setContentDescription(A02);
        }
        this.A09.A04(c1187Na, z2, z);
        if (z2) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            YB.A0V(this, gradientDrawable);
            boolean fullScreenEnabled = this.A05;
            setReportingViewColor(!fullScreenEnabled ? this.A00 : this.A03);
            return;
        }
        YB.A0N(this, 0);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public final boolean A0E() {
        return this.A09.A05();
    }

    public final void A0F(C1199Nm c1199Nm, String str, int i) {
        this.A09.setInitialUnskippableSeconds(i);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(c1199Nm, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(c1199Nm, str, this.A07, this.A08);
        }
    }

    public final void A0G(C1929gi c1929gi, int i) {
        if (this.A00 != null) {
            YB.A0J(this.A00);
            this.A00.removeAllViews();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (!this.A05) {
            this.A00 = new YZ(c1929gi, i);
            layoutParams.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
            addView(this.A00, layoutParams);
        } else {
            this.A03 = new ZC(c1929gi);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A03, layoutParams);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public int getToolbarActionMode() {
        return this.A09.getToolbarActionMode();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public int getToolbarHeight() {
        return AbstractC1464Yb.A00;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public InterfaceC1463Ya getToolbarListener() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setAdReportingVisible(boolean z) {
        A04(!this.A05 ? this.A00 : this.A03, z);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setCTAClickListener(View.OnClickListener onClickListener) {
        this.A0A.setOnClickListener(onClickListener);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setCTAClickListener(ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr) {
        this.A0A.setOnClickListener(AbstractC1633bu.A03(viewOnClickListenerC1127Kr, A02(17, 7, 47)));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setFullscreen(boolean z) {
        this.A04 = z;
    }

    public void setOnlyPageDetails(C1199Nm c1199Nm) {
        if (c1199Nm != null) {
            this.A0A.setPageDetails(c1199Nm);
        } else {
            this.A0A.A01();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setPageDetails(C1199Nm c1199Nm, String str, int i, C1205Ns c1205Ns) {
        this.A09.setInitialUnskippableSeconds(i);
        this.A0A.setPageDetails(c1199Nm);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(c1199Nm, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(c1199Nm, str, this.A07, this.A08);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setPageDetailsVisible(boolean z) {
        this.A06.removeAllViews();
        if (z) {
            this.A06.addView(this.A0A);
        }
        this.A09.setToolbarMessageEnabled(!z);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setProgress(float f) {
        this.A09.setProgress(f);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A09.setProgressClickListener(onClickListener);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setProgressImage(YM ym) {
        this.A09.setProgressImage(ym);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setProgressImmediate(float f) {
        this.A09.setProgressImmediate(f);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setProgressSpinnerInvisible(boolean z) {
        this.A09.setProgressSpinnerInvisible(z);
    }

    private void setReportingViewColor(View view) {
        if (view != null) {
            YB.A0S(view, 0, -16777216, A0E);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setToolbarActionMessage(String str) {
        this.A09.setToolbarMessage(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setToolbarActionMode(int i) {
        this.A09.setToolbarActionMode(i);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1464Yb
    public void setToolbarListener(InterfaceC1463Ya interfaceC1463Ya) {
        this.A02 = interfaceC1463Ya;
    }
}
