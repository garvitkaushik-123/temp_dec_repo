package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: com.facebook.ads.redexgen.X.e4, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1766e4 extends LinearLayout {
    public static final int A04 = (int) (XX.A02 * 32.0f);
    public static final int A05 = (int) (XX.A02 * 8.0f);
    public TextView A00;
    public TextView A01;
    public C1623bk A02;
    public final C1929gi A03;

    public C1766e4(C1929gi c1929gi) {
        super(c1929gi);
        this.A03 = c1929gi;
        A00(c1929gi);
    }

    private final void A00(C1929gi c1929gi) {
        setGravity(16);
        this.A02 = new C1623bk(c1929gi);
        this.A02.setFullCircleCorners(true);
        LinearLayout.LayoutParams pageImageViewParams = new LinearLayout.LayoutParams(A04, A04);
        pageImageViewParams.setMargins(0, 0, A05, 0);
        addView(this.A02, pageImageViewParams);
        LinearLayout pageInfoView = new LinearLayout(c1929gi);
        pageInfoView.setOrientation(1);
        this.A00 = new TextView(c1929gi);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        YB.A0a(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(c1929gi);
        YB.A0a(this.A01, false, 14);
        pageInfoView.addView(this.A00);
        pageInfoView.addView(this.A01);
        addView(pageInfoView, layoutParams);
    }

    public final void A01() {
        this.A02.setImageBitmap(null);
        this.A00.setText("");
        this.A01.setText("");
    }

    public final void A02(int i, int i2) {
        this.A00.setTextColor(i);
        this.A01.setTextColor(i2);
    }

    public void setPageDetails(C1199Nm c1199Nm) {
        LM lm = new LM(this.A02, this.A03);
        lm.A05(A04, A04);
        lm.A07(c1199Nm.A01());
        this.A00.setText(c1199Nm.A02());
        this.A01.setText(c1199Nm.A03());
    }
}
