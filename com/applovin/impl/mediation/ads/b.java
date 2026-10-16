package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.a3;
import com.applovin.impl.c8;
import com.applovin.impl.d8;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;

/* loaded from: classes2.dex */
public class b implements d8.a {

    /* renamed from: a, reason: collision with root package name */
    private final k f573a;
    private final a3 b;
    private final d8 c;
    private final c8 d;
    private final a.InterfaceC0097a e;

    public b(a3 a3Var, ViewGroup viewGroup, a.InterfaceC0097a interfaceC0097a, k kVar) {
        this.f573a = kVar;
        this.b = a3Var;
        this.e = interfaceC0097a;
        this.d = new c8(viewGroup, kVar);
        d8 d8Var = new d8(viewGroup, kVar, this);
        this.c = d8Var;
        d8Var.a(a3Var);
        kVar.O();
        if (o.a()) {
            kVar.O().a("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void a() {
        this.c.b();
    }

    public a3 b() {
        return this.b;
    }

    public void c() {
        this.f573a.O();
        if (o.a()) {
            this.f573a.O().a("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.b.o0().compareAndSet(false, true)) {
            this.f573a.O();
            if (o.a()) {
                this.f573a.O().a("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.b.getNativeAd().isExpired()) {
                o.h("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.f573a.f().a(this.b);
            }
            this.f573a.X().processRawAdImpression(this.b, this.e);
        }
    }

    @Override // com.applovin.impl.d8.a
    public void onLogVisibilityImpression() {
        a(this.d.a(this.b));
    }

    private void a(long j) {
        if (this.b.p0().compareAndSet(false, true)) {
            this.f573a.O();
            if (o.a()) {
                this.f573a.O().a("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f573a.X().processViewabilityAdImpressionPostback(this.b, j, this.e);
        }
    }
}
