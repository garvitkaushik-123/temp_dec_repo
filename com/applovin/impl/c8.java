package com.applovin.impl;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.sdk.AppLovinSdkUtils;

/* loaded from: classes2.dex */
public class c8 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f423a;
    private final com.applovin.impl.sdk.o b;
    private final View c;

    public c8(View view, com.applovin.impl.sdk.k kVar) {
        this.f423a = kVar;
        this.b = kVar.O();
        this.c = view;
    }

    public long a(e3 e3Var) {
        long j;
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("ViewabilityTracker", "Checking visibility...");
        }
        Point b = o0.b(this.c.getContext());
        if (this.c.isShown()) {
            j = 0;
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "View is hidden");
            }
            j = 2;
        }
        if (this.c.getAlpha() < e3Var.d0()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "View is transparent");
            }
            j |= 4;
        }
        Animation animation = this.c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "View is animating");
            }
            j |= 8;
        }
        if (this.c.getParent() == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "No parent view found");
            }
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getWidth());
        if (pxToDp < Math.min(e3Var.j0(), b.x)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            }
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.c.getContext(), this.c.getHeight());
        if (pxToDp2 < e3Var.f0()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            }
            j |= 64;
        }
        Rect rect = new Rect(0, 0, b.x, b.y);
        int[] iArr = {-1, -1};
        this.c.getLocationOnScreen(iArr);
        int i = iArr[0];
        Rect rect2 = new Rect(i, iArr[1], this.c.getWidth() + i, iArr[1] + this.c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j |= 128;
        }
        Activity b2 = this.f423a.e().b();
        if (b2 != null && !b8.a(this.c, b2)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j |= 256;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j));
        }
        return j;
    }
}
