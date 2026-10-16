package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.CreativeType;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.flow.n0;
import com.fyber.inneractive.sdk.flow.o0;
import com.fyber.inneractive.sdk.flow.q0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.y0;
import com.iab.omid.library.fyber.adsession.AdSession;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class s extends n0 {
    public t1 E;
    public com.fyber.inneractive.sdk.external.g I;
    public y0 J;
    public r w;
    public IAmraidWebViewController y;
    public boolean x = false;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public UnitDisplayType F = UnitDisplayType.INTERSTITIAL;
    public boolean G = false;
    public boolean H = false;

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean G() {
        return !this.B && this.y.X;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final int I() {
        Integer a2;
        x xVar = this.b;
        if (xVar != null) {
            o0 o0Var = (o0) xVar;
            if (o0Var.c != null && o0Var.c.a(com.fyber.inneractive.sdk.config.global.features.e.class) != null && (a2 = ((com.fyber.inneractive.sdk.config.global.features.e) ((o0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.e.class)).a("close_clickable_area_dp")) != null) {
                return a2.intValue();
            }
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final int J() {
        Integer a2;
        x xVar = this.b;
        if (xVar != null) {
            o0 o0Var = (o0) xVar;
            if (o0Var.c != null && o0Var.c.a(com.fyber.inneractive.sdk.config.global.features.e.class) != null && (a2 = ((com.fyber.inneractive.sdk.config.global.features.e) ((o0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.e.class)).a("close_visible_size_dp")) != null) {
                return a2.intValue();
            }
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final long K() {
        int i;
        com.fyber.inneractive.sdk.response.e eVar;
        int i2 = 5;
        if (this.F == UnitDisplayType.REWARDED) {
            i = IAConfigManager.O.u.b.a("rewarded_mraid_delay", 31, 30);
            IAlog.a("%sGetting rewarded total delay of %d seconds", IAlog.a(this), Integer.valueOf(i));
        } else {
            com.fyber.inneractive.sdk.config.s sVar = IAConfigManager.O.u;
            if (sVar == null) {
                i = 5;
            } else {
                com.fyber.inneractive.sdk.config.o oVar = sVar.b;
                int b = oVar.b("mraid_x_delay_v2", 5, 0);
                com.fyber.inneractive.sdk.config.l a2 = oVar.a("int_configuration");
                if (a2 == null || !a2.f1104a.containsKey("close_d")) {
                    if (this.F == UnitDisplayType.INTERSTITIAL) {
                        CreativeType creativeType = CreativeType.PLAYABLE;
                        x xVar = this.b;
                        if (creativeType.equals((xVar == null || (eVar = ((o0) xVar).b) == null) ? null : ((com.fyber.inneractive.sdk.response.f) eVar).M)) {
                            i = oVar.b("d_ad_int_pl", b, 5);
                        }
                    }
                    i = b;
                } else {
                    if (a2.f1104a.containsKey("close_d")) {
                        i = Integer.parseInt((String) a2.f1104a.get("close_d"));
                        if (i >= 0 || i > 30) {
                            i = 5;
                        }
                        this.t = true;
                    }
                    i = 5;
                    if (i >= 0) {
                    }
                    i = 5;
                    this.t = true;
                }
            }
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (A()) {
                Integer a3 = ((com.fyber.inneractive.sdk.config.global.features.c) ((o0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.c.class)).a("skip_time_sec");
                int intValue = a3 != null ? a3.intValue() : 5;
                if (intValue >= 0 && intValue <= 8) {
                    i2 = intValue;
                }
            } else {
                i2 = Math.min(i, 5);
            }
            i = Math.min(i2, i);
        }
        return i * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean L() {
        return false;
    }

    public final void N() {
        IAmraidWebViewController iAmraidWebViewController;
        if (this.b == null || (iAmraidWebViewController = this.y) == null) {
            IAlog.a("updateWebViewLayoutParams called, but web view is invalid", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.web.m mVar = iAmraidWebViewController.b;
        if (mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            mVar.setLayoutParams(layoutParams);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) {
        s0 s0Var;
        super.a(eVar, activity);
        x xVar = this.b;
        l0 l0Var = (xVar == null || (s0Var = ((o0) xVar).d) == null) ? null : ((r0) s0Var).c;
        if (l0Var == null) {
            IAlog.f("%sNo display config for full screen mraid ad renderer! Cannot render", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("No display config for full screen mraid");
        }
        IAmraidWebViewController iAmraidWebViewController = xVar != null ? ((o0) xVar).i : null;
        this.y = iAmraidWebViewController;
        if (iAmraidWebViewController == null || iAmraidWebViewController.b == null) {
            IAlog.f("%sWeb view controller content is not valid. Web view might have crashed", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Web view could not be loaded");
        }
        ((o0) xVar).g();
        this.F = l0Var.b;
        this.z = false;
        this.A = false;
        this.J = new y0(this.f1175a);
        this.k = eVar;
        IAmraidWebViewController iAmraidWebViewController2 = this.y;
        if (iAmraidWebViewController2 == null) {
            IAlog.f("InneractiveFullscreenMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", this.b);
            return;
        }
        iAmraidWebViewController2.a(eVar.getCloseButton(), com.fyber.inneractive.sdk.measurement.tracker.d.CloseButton);
        com.fyber.inneractive.sdk.response.f fVar = (com.fyber.inneractive.sdk.response.f) ((o0) this.b).b;
        int i = fVar.e;
        int i2 = fVar.f;
        boolean z = (i == 300 && i2 == 250) || (i == 600 && i2 == 500);
        this.B = z;
        if (z) {
            this.y.setAdDefaultSize(com.fyber.inneractive.sdk.util.o.a(i), com.fyber.inneractive.sdk.util.o.a(i2));
        }
        if (this.w == null) {
            this.w = new r(this);
        }
        this.y.setListener(this.w);
        InneractiveAdSpot inneractiveAdSpot = this.f1175a;
        if (inneractiveAdSpot != null && inneractiveAdSpot.getAdContent() != null && activity != null) {
            x adContent = this.f1175a.getAdContent();
            com.fyber.inneractive.sdk.flow.g gVar = new com.fyber.inneractive.sdk.flow.g(activity, false, adContent.f1249a, adContent.c(), adContent.c);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.ia_identifier_overlay);
            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
            IFyberAdIdentifier iFyberAdIdentifier = gVar.d;
            iFyberAdIdentifier.k = corner;
            iFyberAdIdentifier.a(viewGroup);
            viewGroup.setVisibility(0);
            this.y.a(viewGroup, com.fyber.inneractive.sdk.measurement.tracker.d.IdentifierView);
        }
        N();
        IAmraidWebViewController iAmraidWebViewController3 = this.y;
        ViewGroup layout = this.k.getLayout();
        InneractiveAdRequest inneractiveAdRequest = ((o0) this.b).f1249a;
        iAmraidWebViewController3.a(layout, (ViewGroup.LayoutParams) null);
        this.z = true;
        if (this.F == UnitDisplayType.REWARDED) {
            t1 t1Var = new t1(TimeUnit.SECONDS, IAConfigManager.O.u.b.a("rewarded_mraid_delay", 31, 30));
            this.E = t1Var;
            t1Var.e = new q(this);
            r1 r1Var = new r1(t1Var);
            t1Var.c = r1Var;
            t1Var.d = false;
            r1Var.sendEmptyMessage(1932593528);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final /* bridge */ /* synthetic */ boolean b(x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final void d(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, com.fyber.inneractive.sdk.measurement.tracker.d.ProgressOverlay);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        InneractiveUnitController.EventsListener eventsListener;
        if (this.z && !this.A && (eventsListener = this.c) != null) {
            this.A = true;
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1175a);
        }
        this.w = null;
        t1 t1Var = this.E;
        if (t1Var != null) {
            t1Var.e = null;
            this.E = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final void e(View view) {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController == null || (eVar = iAmraidWebViewController.I) == null) {
            return;
        }
        try {
            AdSession adSession = eVar.f1273a;
            if (adSession == null || view == null) {
                return;
            }
            adSession.removeFriendlyObstruction(view);
        } catch (Throwable unused) {
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
        com.fyber.inneractive.sdk.config.global.r rVar;
        InneractiveUnitController.EventsListener eventsListener;
        if (this.F == UnitDisplayType.REWARDED && this.G) {
            M();
        }
        if (!this.A && (eventsListener = this.c) != null) {
            this.A = true;
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1175a);
        }
        y0 y0Var = this.J;
        if (y0Var != null && y0Var.b != 0) {
            long currentTimeMillis = (System.currentTimeMillis() - y0Var.b) - y0Var.d;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long seconds = timeUnit.toSeconds(currentTimeMillis);
            long millis = timeUnit.toMillis(currentTimeMillis - TimeUnit.SECONDS.toMillis(seconds));
            Locale locale = Locale.US;
            String str = seconds + "." + millis;
            y0Var.b = 0L;
            y0Var.c = 0L;
            y0Var.d = 0L;
            InneractiveAdSpot inneractiveAdSpot = y0Var.f1786a;
            x adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.INTERSTITIAL_VIEW_TIME;
            InneractiveAdRequest inneractiveAdRequest = adContent != null ? adContent.f1249a : null;
            com.fyber.inneractive.sdk.response.e c = adContent != null ? adContent.c() : null;
            JSONArray b = (adContent == null || (rVar = adContent.c) == null) ? null : rVar.b();
            w wVar = new w(c);
            wVar.c = uVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            wVar.a("time", str);
            wVar.a((String) null);
        }
        InneractiveAdSpot inneractiveAdSpot2 = this.f1175a;
        if (inneractiveAdSpot2 == null || !(inneractiveAdSpot2 instanceof g0)) {
            return;
        }
        ((g0) inneractiveAdSpot2).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void m() {
        t1 t1Var;
        super.m();
        if (this.F == UnitDisplayType.REWARDED && (t1Var = this.E) != null) {
            t1Var.d = false;
            t1Var.a(SystemClock.uptimeMillis());
        }
        y0 y0Var = this.J;
        if (y0Var != null) {
            if (y0Var.b == 0) {
                y0Var.b = System.currentTimeMillis();
            }
            if (y0Var.c > 0) {
                y0Var.d += System.currentTimeMillis() - y0Var.c;
                y0Var.c = 0L;
            }
        }
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (!aVar.b || aVar.e <= 0) {
            return;
        }
        aVar.f += System.currentTimeMillis() - aVar.e;
        aVar.e = 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void r() {
        t1 t1Var;
        super.r();
        if (this.F == UnitDisplayType.REWARDED && (t1Var = this.E) != null) {
            t1Var.d = true;
            r1 r1Var = t1Var.c;
            if (r1Var != null) {
                r1Var.removeMessages(1932593528);
            }
        }
        y0 y0Var = this.J;
        if (y0Var != null) {
            y0Var.c = System.currentTimeMillis();
        }
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (aVar.b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        boolean z;
        if (this.k == null) {
            z = true;
        } else if (this.F == UnitDisplayType.REWARDED) {
            if (this.G) {
                M();
            }
            z = this.G;
        } else {
            z = this.p;
        }
        if (!z) {
            return true;
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null) {
            return false;
        }
        eVar.dismissAd(true);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final Context w() {
        IAmraidWebViewController iAmraidWebViewController = this.y;
        return c(iAmraidWebViewController != null ? iAmraidWebViewController.b : null);
    }

    public final void M() {
        WeakReference weakReference;
        IAlog.a("%sprovide reward called", IAlog.a(this));
        if (this.H) {
            IAlog.a("%sreward was already provided", IAlog.a(this));
            return;
        }
        IAlog.a("%sreward sent", IAlog.a(this));
        if (this.I != null) {
            a0.a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY);
            com.fyber.inneractive.sdk.external.g gVar = this.I;
            weakReference = ((q0) gVar.f1168a).mAdSpot;
            g0 g0Var = (g0) com.fyber.inneractive.sdk.util.t.a(weakReference);
            InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1168a.b;
            if (inneractiveFullScreenAdRewardedListener != null && g0Var != null) {
                inneractiveFullScreenAdRewardedListener.onAdRewarded(g0Var);
            }
        }
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController == null || !iAmraidWebViewController.D) {
            F();
        }
        this.H = true;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void b(boolean z) {
        if (!G()) {
            if (z) {
                this.u.a((String) null);
            } else {
                com.fyber.inneractive.sdk.util.a aVar = this.u;
                aVar.d = 0L;
                aVar.e = 0L;
                aVar.f = 0L;
                aVar.b = false;
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.destroy();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
        N();
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final long a(long j) {
        if (this.F == UnitDisplayType.REWARDED) {
            return 0L;
        }
        if (this.t) {
            return j;
        }
        long j2 = 13;
        try {
            j2 = Long.parseLong(IAConfigManager.O.u.b.a("mraid_x_fallback_delay", Long.toString(13L)));
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.I = gVar;
    }
}
