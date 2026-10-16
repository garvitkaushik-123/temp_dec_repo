package com.applovin.impl;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.b6;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class w1 extends v1 {
    private final x1 M;
    private g0 N;
    private long O;
    private final AtomicBoolean P;

    public w1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.M = new x1(this.f755a, this.d, this.b);
        this.P = new AtomicBoolean();
    }

    private long B() {
        com.applovin.impl.sdk.ad.b bVar = this.f755a;
        if (!(bVar instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float t1 = ((com.applovin.impl.sdk.ad.a) bVar).t1();
        if (t1 <= 0.0f) {
            t1 = this.f755a.s();
        }
        return (long) (k7.c(t1) * (this.f755a.I() / 100.0d));
    }

    private int C() {
        g0 g0Var;
        int i = 100;
        if (g()) {
            if (!D() && (g0Var = this.N) != null) {
                i = (int) Math.min(100.0d, ((this.O - g0Var.b()) / this.O) * 100.0d);
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Ad engaged at " + i + "%");
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.P.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.q = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.k;
        if (gVar != null) {
            arrayList.add(new e4(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.j;
            arrayList.add(new e4(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f755a.getAdEventTracker().b(this.i, arrayList);
    }

    protected boolean D() {
        if (!(this.J && this.f755a.n1()) && g()) {
            return this.P.get();
        }
        return true;
    }

    protected void H() {
        long Z;
        long j = 0;
        if (this.f755a.Y() >= 0 || this.f755a.Z() >= 0) {
            if (this.f755a.Y() >= 0) {
                Z = this.f755a.Y();
            } else {
                if (this.f755a.j1()) {
                    int t1 = (int) ((com.applovin.impl.sdk.ad.a) this.f755a).t1();
                    if (t1 > 0) {
                        j = TimeUnit.SECONDS.toMillis(t1);
                    } else {
                        int s = (int) this.f755a.s();
                        if (s > 0) {
                            j = TimeUnit.SECONDS.toMillis(s);
                        }
                    }
                }
                Z = (long) (j * (this.f755a.Z() / 100.0d));
            }
            c(Z);
        }
    }

    @Override // com.applovin.impl.v1
    public void a(ViewGroup viewGroup) {
        this.M.a(this.k, this.j, this.i, viewGroup);
        if (((Boolean) this.b.a(v4.L5)).booleanValue() || !a(false)) {
            com.applovin.impl.adview.k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
            this.i.renderAd(this.f755a);
            a("javascript:al_onPoststitialShow();", this.f755a.H());
            if (g()) {
                long B = B();
                this.O = B;
                if (B > 0) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.O + "ms...");
                    }
                    this.N = g0.a(this.O, this.b, new Runnable() { // from class: com.applovin.impl.w1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            w1.this.E();
                        }
                    });
                }
            }
            if (this.k != null) {
                if (this.f755a.s() >= 0) {
                    a(this.k, this.f755a.s(), new Runnable() { // from class: com.applovin.impl.w1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            w1.this.F();
                        }
                    });
                } else {
                    this.k.setVisibility(0);
                }
            }
            H();
            this.b.r0().a(new p6(this.b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.w1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    w1.this.G();
                }
            }), b6.b.OTHER, TimeUnit.SECONDS.toMillis(1L));
            o();
            super.c(k7.e(this.b));
        }
    }

    @Override // com.applovin.impl.v1
    public void b(long j) {
    }

    @Override // com.applovin.impl.v1
    public void d() {
        super.d();
        z();
    }

    @Override // com.applovin.impl.v1
    public void e() {
        super.e();
        z();
    }

    @Override // com.applovin.impl.v1
    protected void l() {
        super.a(C(), false, D(), -2L);
    }

    @Override // com.applovin.impl.v1
    public void u() {
    }

    @Override // com.applovin.impl.v1
    public void v() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.v1
    protected void w() {
        super.w();
        this.P.set(true);
    }

    @Override // com.applovin.impl.v1
    protected void z() {
        this.M.a(this.l);
        this.q = SystemClock.elapsedRealtime();
        this.P.set(true);
    }

    @Override // com.applovin.impl.v1
    public void a(String str) {
        if (!((Boolean) this.b.a(v4.D6)).booleanValue()) {
            com.applovin.impl.sdk.ad.b bVar = this.f755a;
            if (bVar != null) {
                bVar.a(str);
            }
            l();
        }
        g0 g0Var = this.N;
        if (g0Var != null) {
            g0Var.a();
            this.N = null;
        }
        super.a(str);
    }
}
