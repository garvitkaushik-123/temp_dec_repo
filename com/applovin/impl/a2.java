package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.ad.b;
import com.applovin.sdk.AppLovinSdkUtils;

/* loaded from: classes2.dex */
public class a2 extends u1 {
    public a2(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.k kVar) {
        super(bVar, activity, kVar);
    }

    @Override // com.applovin.impl.u1
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    @Override // com.applovin.impl.u1
    public /* bridge */ /* synthetic */ void a(View view) {
        super.a(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ImageView imageView, com.applovin.impl.adview.g gVar, final com.applovin.impl.adview.l lVar, a aVar, ProgressBar progressBar, i0 i0Var, View view, View view2, AppLovinAdView appLovinAdView, com.applovin.impl.adview.k kVar, ImageView imageView2, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        if (this.c.s0() == b.e.TOP) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
        } else if (this.c.s0() == b.e.BOTTOM) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        } else if (this.c.s0() == b.e.LEFT) {
            layoutParams = new FrameLayout.LayoutParams(-2, -1, 3);
        } else {
            if (this.c.s0() == b.e.RIGHT) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1, 5);
            } else {
                layoutParams = this.e;
            }
            appLovinAdView.setLayoutParams(this.e);
            this.d.addView(appLovinAdView);
            view2.setLayoutParams(this.e);
            this.d.addView(view2);
            view.setLayoutParams(layoutParams);
            this.d.addView(view);
            if (lVar != null) {
                a8 l0 = this.c.l0();
                LinearLayout linearLayout = new LinearLayout(this.b);
                linearLayout.setOrientation(1);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setGravity(l0.e());
                ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                LinearLayout linearLayout2 = new LinearLayout(this.b);
                linearLayout2.setOrientation(0);
                linearLayout2.setWeightSum(100.0f);
                linearLayout2.setGravity(l0.e());
                ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, 0, l0.f());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1, l0.i());
                int dpToPx = AppLovinSdkUtils.dpToPx(this.b, l0.g());
                layoutParams4.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
                linearLayout2.addView(lVar, layoutParams4);
                linearLayout.addView(linearLayout2, layoutParams3);
                this.d.addView(linearLayout, layoutParams2);
                if (l0.a() > 0.0f) {
                    lVar.setVisibility(4);
                    long c = k7.c(l0.a());
                    final long b = l0.b();
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            b8.a(com.applovin.impl.adview.l.this, b, (Runnable) null);
                        }
                    }, c);
                }
                if (l0.c() > 0.0f) {
                    long c2 = k7.c(l0.c());
                    final long d = l0.d();
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.a2$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b8.b(com.applovin.impl.adview.l.this, d, null);
                        }
                    }, c2);
                }
            }
            if (gVar != null) {
                a(this.c.o(), (this.c.M0() ? 3 : 5) | 48, gVar);
            }
            if (imageView != null) {
                int dpToPx2 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f747a.a(v4.c2)).intValue());
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(dpToPx2, dpToPx2, ((Integer) this.f747a.a(v4.e2)).intValue());
                int dpToPx3 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f747a.a(v4.d2)).intValue());
                layoutParams5.setMargins(dpToPx3, dpToPx3, dpToPx3, dpToPx3);
                this.d.addView(imageView, layoutParams5);
            }
            if (aVar != null) {
                this.d.addView(aVar, this.e);
            }
            if (i0Var != null) {
                int dpToPx4 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f747a.a(v4.P1)).intValue());
                FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(dpToPx4, dpToPx4, ((Integer) this.f747a.a(v4.O1)).intValue());
                int dpToPx5 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f747a.a(v4.N1)).intValue());
                layoutParams6.setMargins(dpToPx5, dpToPx5, dpToPx5, dpToPx5);
                this.d.addView(i0Var, layoutParams6);
            }
            if (progressBar != null) {
                FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, 20, 80);
                layoutParams7.setMargins(0, 0, 0, ((Integer) this.f747a.a(v4.h2)).intValue());
                this.d.addView(progressBar, layoutParams7);
            }
            if (imageView2 != null) {
                l7 l7Var = (l7) this.c;
                if (l7Var.D1()) {
                    int dpToPx6 = AppLovinSdkUtils.dpToPx(this.b, l7Var.x1().g());
                    int dpToPx7 = AppLovinSdkUtils.dpToPx(this.b, l7Var.x1().d());
                    int dpToPx8 = AppLovinSdkUtils.dpToPx(this.b, ((Integer) this.f747a.a(v4.N4)).intValue());
                    FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(dpToPx6, dpToPx7, 83);
                    layoutParams8.setMargins(dpToPx8, dpToPx8, dpToPx8, dpToPx8);
                    this.d.addView(imageView2, layoutParams8);
                }
            }
            if (kVar != null) {
                this.d.addView(kVar, this.e);
            }
            if (viewGroup == null) {
                viewGroup.addView(this.d);
                return;
            } else {
                this.b.setContentView(this.d);
                return;
            }
        }
        appLovinAdView.setLayoutParams(this.e);
        this.d.addView(appLovinAdView);
        view2.setLayoutParams(this.e);
        this.d.addView(view2);
        view.setLayoutParams(layoutParams);
        this.d.addView(view);
        if (lVar != null) {
        }
        if (gVar != null) {
        }
        if (imageView != null) {
        }
        if (aVar != null) {
        }
        if (i0Var != null) {
        }
        if (progressBar != null) {
        }
        if (imageView2 != null) {
        }
        if (kVar != null) {
        }
        if (viewGroup == null) {
        }
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        s.a(this.d, view);
        if (gVar != null) {
            a(this.c.o(), (this.c.E0() ? 3 : 5) | 48, gVar);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, ((Boolean) this.f747a.a(v4.o2)).booleanValue() ? 80 : 48);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.f747a.a(v4.p2)).intValue());
            this.d.addView(progressBar, layoutParams);
        }
        if (kVar != null) {
            this.d.addView(kVar, this.e);
        }
    }
}
