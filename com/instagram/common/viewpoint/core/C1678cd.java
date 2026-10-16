package com.instagram.common.viewpoint.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.facebook.ads.redexgen.X.cd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1678cd extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final ViewOnClickListenerC1127Kr A02;
    public static final int A05 = (int) (XX.A02 * 36.0f);
    public static final int A06 = (int) (XX.A02 * 36.0f);
    public static final int A03 = (int) (XX.A02 * 23.0f);
    public static final int A04 = (int) (XX.A02 * 3.0f);
    public static final int A07 = (int) (XX.A02 * 4.0f);

    public C1678cd(C1929gi c1929gi, ViewOnClickListenerC1127Kr viewOnClickListenerC1127Kr, AbstractC2094jd abstractC2094jd, VA va, InterfaceC1470Yh interfaceC1470Yh, C1874fp c1874fp, Y2 y2, C1187Na c1187Na, InterfaceC1607bU interfaceC1607bU) {
        super(c1929gi);
        this.A00 = c1187Na.A09(true);
        this.A01 = new RelativeLayout(c1929gi);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c1929gi, abstractC2094jd.A29().A0J().A04());
        if (viewOnClickListenerC1127Kr == null) {
            this.A02 = new ViewOnClickListenerC1127Kr(c1929gi, abstractC2094jd.A0w(), (C1187Na) null, va, interfaceC1470Yh, c1874fp, y2, abstractC2094jd.A2A());
        } else {
            this.A02 = viewOnClickListenerC1127Kr;
        }
        A03();
        this.A02.setCta(abstractC2094jd.A29().A0J(), abstractC2094jd.A2E(), new HashMap(), interfaceC1607bU);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C1929gi c1929gi, View view) {
        ImageView imageView = new ImageView(c1929gi);
        imageView.setImageBitmap(YN.A01(YM.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C1929gi c1929gi, String str) {
        Button button = new Button(c1929gi);
        YB.A0K(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        YB.A0Q(button, this.A00, A07);
        button.setTextColor(-16777216);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c1929gi, button);
    }

    public final EnumC1178Mq A02(String str) {
        return this.A02.A0E(str);
    }

    public final void A03() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC2094jd abstractC2094jd, AbstractC1464Yb abstractC1464Yb) {
        this.A02.A0F(abstractC2094jd, abstractC1464Yb);
    }

    public void setCta(C1189Nc c1189Nc, String str, HashMap<String, String> extras, InterfaceC1607bU interfaceC1607bU) {
        this.A02.setCta(c1189Nc, str, extras, interfaceC1607bU);
    }
}
