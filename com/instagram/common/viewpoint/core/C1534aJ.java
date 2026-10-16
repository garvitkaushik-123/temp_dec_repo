package com.instagram.common.viewpoint.core;

import android.animation.LayoutTransition;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* renamed from: com.facebook.ads.redexgen.X.aJ, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1534aJ extends LinearLayout {
    public static String[] A0I = {"Jjhv1QqAIW86EmEZitDWSXUy5KAygWmD", "Knznf5NxnzMSGuCyCavmDPpLrbg6IGSX", "ILZruYKannRuDYsFiZYXNynBpyms", "eZKheB7115JCtr5xxUXw9oXkLPe4M5DC", "o2TLnhgUMatQJZ63WkSJRDhfBnbI", "vZrVQG4SvGUnBHUUGdfxrKmAlJmFc80m", "RT8BtEaKHOdmDtB2bzxk3zMCIxucDNYE", "yGiX4fEKWzcCLDIcRuEbwAcVWGPLZUB"};
    public ImageView A00;
    public ImageView A01;
    public InterfaceC1535aK A02;
    public Runnable A03;
    public boolean A04;
    public final int A05;
    public final Bitmap A06;
    public final Bitmap A07;
    public final Bitmap A08;
    public final Bitmap A09;
    public final Bitmap A0A;
    public final Bitmap A0B;
    public final AbstractC2094jd A0C;
    public final C1929gi A0D;
    public final VI A0E;
    public final InterfaceC1470Yh A0F;
    public final EnumC1537aM A0G;
    public final EnumC1540aP A0H;

    public C1534aJ(C1929gi c1929gi, boolean z, AbstractC2094jd abstractC2094jd, VI vi, InterfaceC1470Yh interfaceC1470Yh, EnumC1537aM enumC1537aM, InterfaceC1535aK interfaceC1535aK, EnumC1540aP enumC1540aP) {
        this(c1929gi, z, abstractC2094jd, vi, interfaceC1470Yh, enumC1537aM, enumC1540aP);
        this.A02 = interfaceC1535aK;
    }

    public C1534aJ(C1929gi c1929gi, boolean z, AbstractC2094jd abstractC2094jd, VI vi, InterfaceC1470Yh interfaceC1470Yh, EnumC1537aM enumC1537aM, EnumC1540aP enumC1540aP) {
        super(c1929gi);
        this.A07 = YN.A01(YM.CREDIT_LINE_INFO_ICON);
        this.A06 = YN.A01(YM.CREDIT_LINE_DETAIL_ICON);
        this.A04 = false;
        this.A08 = YN.A01(YM.AD_CHOICE_ICON);
        this.A09 = YN.A01(YM.AD_CHOICE_TEXT);
        this.A0A = YN.A01(YM.AD_CREDIT_LINE_COLLAPSE_TEXT);
        this.A0B = YN.A01(YM.CREDIT_LINE_TEXT);
        this.A05 = abstractC2094jd.A27();
        this.A0E = vi;
        this.A0F = interfaceC1470Yh;
        this.A0G = enumC1537aM;
        this.A0D = c1929gi;
        this.A0C = abstractC2094jd;
        this.A0H = enumC1540aP;
        A05();
        A0K(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        YB.A0M(this.A00, 1.0f, 0.0f, 100);
        A0E(3, 300, new InterfaceC1521a6() { // from class: com.facebook.ads.redexgen.X.MA
            @Override // com.instagram.common.viewpoint.core.InterfaceC1521a6
            public final void AK7(Object obj, long j) {
                C1534aJ.this.A0U(obj, j);
            }
        }, new C1530aF(this));
        postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.aA
            @Override // java.lang.Runnable
            public final void run() {
                C1534aJ.this.A0R();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        A0E(2, 300, new InterfaceC1521a6() { // from class: com.facebook.ads.redexgen.X.MB
            @Override // com.instagram.common.viewpoint.core.InterfaceC1521a6
            public final void AK7(Object obj, long j) {
                C1534aJ.this.A0V(obj, j);
            }
        }, new C1528aD(this));
        YB.A0M(this.A00, 0.0f, 1.0f, 0);
        YB.A0O(this.A00, 0);
    }

    private void A04() {
        if (this.A04 && this.A03 != null) {
            A06();
            A02();
        }
    }

    private void A05() {
        switch (this.A0H) {
            case A03:
                AbstractC1536aL.A02(this.A0D, this.A0G);
                break;
            case A02:
                AbstractC1536aL.A01(this.A0D, this.A0G);
                break;
        }
    }

    private void A06() {
        if (this.A04 && this.A03 != null) {
            removeCallbacks(this.A03);
            this.A03 = null;
        }
        String[] strArr = A0I;
        if (strArr[4].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        A0I[6] = "PZwK6paCNaN1NNUi7D9zVsXgJs4CpRYo";
        this.A04 = false;
    }

    private void A07() {
        switch (this.A0H) {
            case A02:
                YB.A0N(this, -859190839);
                return;
            default:
                if (A0I[7].length() == 20) {
                    throw new RuntimeException();
                }
                A0I[6] = "J4Bl2paDruPebaLnqzXafrD0wXfUXyp3";
                YB.A0N(this, -870569165);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08() {
        switch (this.A0H) {
            case A02:
                ImageView imageView = this.A01;
                int i = XV.A0S;
                if (A0I[7].length() != 20) {
                    String[] strArr = A0I;
                    strArr[4] = "IwvL04OrKqzmIeLShS8Q4SIdnVqi";
                    strArr[2] = "Ml3LYYHXQPQgDXepFoLqaPfqy73Y";
                    imageView.setPadding(i, XV.A00, XV.A0A, XV.A00);
                    return;
                }
                throw new RuntimeException();
            case A04:
                this.A01.setPadding(XV.A0S, XV.A00, XV.A0S, XV.A00);
                this.A01.setVisibility(8);
                return;
            default:
                this.A01.setPadding(XV.A0I, XV.A00, XV.A0A, XV.A00);
                return;
        }
    }

    private void A09() {
        switch (this.A0H) {
            case A02:
                A0F(this.A00, this.A09, XV.A00, XV.A01, XV.A0S, XV.A01, XV.A0U);
                break;
            case A04:
                A0F(this.A00, this.A0B, XV.A02, XV.A00, XV.A02, XV.A00, -2);
                break;
            default:
                A0F(this.A00, this.A06, XV.A00, XV.A0A, XV.A0S, XV.A0A, -2);
                break;
        }
    }

    private void A0A() {
        switch (this.A0H) {
            case A02:
                A0F(this.A01, this.A08, XV.A0I, XV.A00, XV.A0I, XV.A00, XV.A0U);
                return;
            case A04:
                ImageView imageView = this.A01;
                Bitmap bitmap = this.A0A;
                int i = XV.A0S;
                int i2 = XV.A00;
                int i3 = XV.A0S;
                int i4 = XV.A00;
                String[] strArr = A0I;
                if (strArr[4].length() != strArr[2].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[0] = "BqxrFQJIBIExT1rCMndHo1bmHb8U1dtr";
                strArr2[3] = "4mbJeCFNsEoBSiTcA819Z9qBG38wKlHe";
                A0F(imageView, bitmap, i, i2, i3, i4, -2);
                return;
            default:
                A0F(this.A01, this.A07, XV.A0I, XV.A00, XV.A0I, XV.A00, -2);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        this.A03 = new Runnable() { // from class: com.facebook.ads.redexgen.X.a9
            @Override // java.lang.Runnable
            public final void run() {
                C1534aJ.this.A02();
            }
        };
        postDelayed(this.A03, this.A05);
    }

    private void A0C() {
        this.A04 = true;
        YB.A0O(this.A00, 0);
        A0B();
    }

    private final void A0D() {
        YB.A0O(this.A00, 8);
        YB.A0O(this.A01, 0);
        if (this.A0H == EnumC1540aP.A04) {
            this.A01.setPadding(XV.A0S, XV.A00, XV.A0S, XV.A00);
        } else {
            this.A01.setPadding(XV.A0I, XV.A00, XV.A0I, XV.A00);
        }
    }

    private void A0E(int i, int i2, InterfaceC1521a6 interfaceC1521a6, LayoutTransition.TransitionListener transitionListener) {
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setAnimator(i, new C1532aH(this, i2, interfaceC1521a6));
        layoutTransition.addTransitionListener(transitionListener);
        setLayoutTransition(layoutTransition);
    }

    private void A0F(ImageView imageView, Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        YB.A0K(imageView);
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAdjustViewBounds(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, i5);
        imageView.setPadding(i, i2, i3, i4);
        imageView.setLayoutParams(layoutParams);
    }

    private void A0K(boolean z) {
        setOrientation(0);
        setPadding(XV.A00, XV.A0I, XV.A00, XV.A0I);
        setClipToPadding(false);
        setGravity(17);
        A07();
        setCornerRadius(XV.A0C);
        this.A01 = new ImageView(getContext());
        A0A();
        addView(this.A01);
        if (this.A0H == EnumC1540aP.A04) {
            this.A01.setVisibility(8);
        }
        this.A00 = new ImageView(getContext());
        A09();
        addView(this.A00);
        A0L(z);
        setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C1534aJ.this.A0T(view);
            }
        });
    }

    private void A0L(boolean z) {
        if (z && (this.A0H == EnumC1540aP.A03 || this.A0H == EnumC1540aP.A04)) {
            A0C();
        } else {
            YB.A0O(this.A00, 8);
            YB.A0O(this.A01, 0);
        }
    }

    public final void A0O() {
        A06();
    }

    public final void A0P() {
        A06();
        A0D();
    }

    public final void A0Q() {
        this.A04 = true;
        post(new Runnable() { // from class: com.facebook.ads.redexgen.X.aB
            @Override // java.lang.Runnable
            public final void run() {
                C1534aJ.this.A0S();
            }
        });
    }

    public final /* synthetic */ void A0R() {
        YB.A0O(this.A00, 8);
    }

    public final /* synthetic */ void A0S() {
        postDelayed(new Runnable() { // from class: com.facebook.ads.redexgen.X.a7
            @Override // java.lang.Runnable
            public final void run() {
                C1534aJ.this.A03();
            }
        }, 300L);
    }

    public final /* synthetic */ void A0T(View view) {
        if (this.A04) {
            if (this.A0H == EnumC1540aP.A04) {
                return;
            }
            A04();
            if (this.A02 != null) {
                this.A02.ADW(view);
                return;
            } else {
                AbstractC1536aL.A07(this.A0E, this.A0D, this.A0F, this.A0C, this.A0G);
                return;
            }
        }
        A0Q();
    }

    public final /* synthetic */ void A0U(Object obj, long j) {
        ((View) obj).animate().translationX(getWidth()).setDuration(j).setInterpolator(new X7(1.5f)).setListener(new C1531aG(this)).start();
    }

    public final /* synthetic */ void A0V(Object obj, long j) {
        View view = (View) obj;
        view.setTranslationX(getWidth());
        view.animate().translationX(0.0f).setDuration(j).setListener(new C1529aE(this)).setInterpolator(new X8(1.5f)).start();
    }

    private void setCornerRadius(float f) {
        setOutlineProvider(new C1527aC(this, f));
        setClipToOutline(true);
    }
}
