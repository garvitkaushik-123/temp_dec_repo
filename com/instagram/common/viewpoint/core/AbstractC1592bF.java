package com.instagram.common.viewpoint.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: com.facebook.ads.redexgen.X.bF, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1592bF extends LinearLayout {
    public static byte[] A0A;
    public static final LinearLayout.LayoutParams A0B;
    public LinearLayout A00;
    public TextView A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final View.OnClickListener A05;
    public final RelativeLayout A06;
    public final C1929gi A07;
    public final ViewOnClickListenerC1127Kr A08;
    public final C1623bk A09;

    public static String A0h(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 11);
        }
        return new String(copyOfRange);
    }

    public static void A0i() {
        A0A = new byte[]{-96, -93, -93, -92, -77, -96, -88, -85, -78};
    }

    public abstract void A0l(int i);

    static {
        A0i();
        A0B = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC1592bF(C1929gi c1929gi, ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr, int i, C1187Na c1187Na, boolean z, String str, VA va, InterfaceC1470Yh interfaceC1470Yh, C1874fp c1874fp, Y2 y2, C1193Ng c1193Ng, boolean z2, String str2) {
        super(c1929gi);
        this.A02 = A0h(0, 0, 37);
        YB.A0K(this);
        this.A07 = c1929gi;
        this.A04 = i;
        this.A03 = z2;
        this.A02 = str2;
        this.A09 = new C1623bk(c1929gi);
        YB.A0N(this.A09, 0);
        YB.A0K(this.A09);
        if (z2) {
            this.A00 = new LinearLayout(c1929gi);
            this.A01 = new TextView(c1929gi);
            YB.A0K(this.A01);
        }
        if (viewOnClickListenerC1127Kr == null) {
            this.A08 = new ViewOnClickListenerC1127Kr(c1929gi, str, c1187Na, z, va, interfaceC1470Yh, c1874fp, y2, c1193Ng);
        } else {
            this.A08 = viewOnClickListenerC1127Kr;
        }
        YB.A0G(1001, this.A08);
        this.A05 = AbstractC1633bu.A03(this.A08, A0h(0, 9, 52));
        this.A06 = new RelativeLayout(c1929gi);
        this.A06.setLayoutParams(A0B);
        YB.A0K(this.A06);
    }

    public void A0j() {
    }

    public void A0k() {
        this.A09.setOnClickListener(this.A05);
    }

    public void A0m(boolean z) {
    }

    public final ViewOnClickListenerC1127Kr getCTAButton() {
        return this.A08;
    }

    public View getExpandableLayout() {
        return null;
    }

    public final ImageView getIconView() {
        return this.A09;
    }

    public void setInfo(NY ny, C1189Nc c1189Nc, String str, String str2, InterfaceC1444Xh interfaceC1444Xh, InterfaceC1607bU interfaceC1607bU) {
        this.A08.setCta(c1189Nc, str, new HashMap(), interfaceC1444Xh, interfaceC1607bU);
        new LM(this.A09, this.A07).A05(this.A04, this.A04).A07(str2);
    }

    public void setTitleMaxLines(int i) {
    }
}
