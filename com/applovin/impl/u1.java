package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.impl.sdk.ad.b;

/* loaded from: classes2.dex */
abstract class u1 {

    /* renamed from: a, reason: collision with root package name */
    final com.applovin.impl.sdk.k f747a;
    final Activity b;
    final com.applovin.impl.sdk.ad.b c;
    final ViewGroup d;
    final FrameLayout.LayoutParams e;

    u1(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.k kVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.e = layoutParams;
        this.c = bVar;
        this.f747a = kVar;
        this.b = activity;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.setLayoutParams(layoutParams);
    }

    public void a(View view) {
        this.d.removeView(view);
    }

    public void a(com.applovin.impl.adview.g gVar) {
        if (gVar == null || gVar.getParent() != null) {
            return;
        }
        a(this.c.o(), (this.c.E0() ? 3 : 5) | 48, gVar);
    }

    void a(b.d dVar, int i, com.applovin.impl.adview.g gVar) {
        gVar.a(dVar.f678a, dVar.e, dVar.d, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(gVar.getLayoutParams());
        int i2 = dVar.c;
        layoutParams.setMargins(i2, dVar.b, i2, 0);
        layoutParams.gravity = i;
        this.d.addView(gVar, layoutParams);
    }
}
