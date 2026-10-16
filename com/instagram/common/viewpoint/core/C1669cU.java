package com.instagram.common.viewpoint.core;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* renamed from: com.facebook.ads.redexgen.X.cU, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1669cU extends RelativeLayout {
    public final View A00;
    public final C1624bl A01;

    public C1669cU(C1929gi c1929gi, View view) {
        super(c1929gi);
        this.A00 = view;
        this.A01 = new C1624bl(c1929gi);
        YB.A0K(this.A01);
    }

    public final void A00(int i) {
        this.A00.setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
    }

    public final void A01(C1629bq c1629bq, boolean z) {
        this.A01.addView(this.A00, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, this.A00.getId());
        if (c1629bq != null) {
            if (z) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                c1629bq.setAlignment(3);
                layoutParams2.setMargins(AbstractC1642c3.A08 / 2, AbstractC1642c3.A08 / 2, AbstractC1642c3.A08 / 2, AbstractC1642c3.A08 / 2);
                linearLayout.addView(c1629bq, layoutParams2);
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{-1778384896, 0});
                gradientDrawable.setCornerRadius(0.0f);
                gradientDrawable.setGradientType(0);
                YB.A0V(linearLayout, gradientDrawable);
            } else {
                RelativeLayout.LayoutParams insideLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
                insideLayoutParams.addRule(3, this.A01.getId());
                insideLayoutParams.setMargins(0, AbstractC1642c3.A08, 0, 0);
                c1629bq.setAlignment(17);
                addView(c1629bq, insideLayoutParams);
            }
        }
        this.A01.addView(linearLayout, layoutParams);
        addView(this.A01, new RelativeLayout.LayoutParams(-1, -2));
    }
}
