package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.o0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.mraid.f0;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f1;
import com.fyber.inneractive.sdk.util.y;
import com.fyber.inneractive.sdk.util.z;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.ironsource.D5;

/* loaded from: classes4.dex */
public final class k extends a0 implements com.fyber.inneractive.sdk.interfaces.d, y {
    public InneractiveAdViewUnitController l;
    public IAmraidWebViewController m;
    public g n;
    public ViewGroup p;
    public i q;
    public h s;
    public d y;
    public long k = 0;
    public boolean o = false;
    public long r = 0;
    public int t = 0;
    public long u = 0;
    public boolean v = false;
    public boolean w = true;
    public boolean x = false;

    public final void G() {
        if (this.s != null) {
            IAlog.a("%scancelling refreen runnable", IAlog.a(this));
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.s);
            this.s = null;
        }
    }

    public final void H() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.j);
        }
        if (this.m != null) {
            G();
            x xVar = this.b;
            if (xVar != null) {
                ((o0) xVar).a();
            }
            this.m = null;
            this.b = null;
            ViewGroup viewGroup = this.p;
            if (viewGroup != null) {
                viewGroup.removeView(this.q);
            }
            i iVar = this.q;
            if (iVar != null) {
                iVar.removeAllViews();
                this.q = null;
            }
        }
        this.v = false;
    }

    public final int I() {
        l0 l0Var;
        int intValue;
        int i = this.t;
        if (i == -1) {
            IAlog.a("%sreturning disable value for banner refresh", IAlog.a(this));
            return 0;
        }
        if (i <= 0) {
            s0 s0Var = this.f1175a.getAdContent().d;
            if (s0Var != null && (l0Var = ((r0) s0Var).c) != null) {
                Integer num = l0Var.f1105a;
                IAlog.a("%sreturning refreshConfig = %d", IAlog.a(this), num);
                if (num != null) {
                    intValue = num.intValue();
                }
            }
            IAlog.a("%sgetRefreshInterval: returning 0. Refresh is disabled", IAlog.a(this));
            return 0;
        }
        IAlog.a("%sreturning overriden refresh interval = %d", IAlog.a(this), Integer.valueOf(this.t));
        intValue = this.t;
        return intValue * 1000;
    }

    public final void J() {
        InneractiveAdViewUnitController inneractiveAdViewUnitController;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || iAmraidWebViewController.b == null) {
            return;
        }
        IAlog.a("%srefreshing ad", IAlog.a(this));
        if ((!this.m.p() || this.m.N == f0.RESIZED) && (inneractiveAdViewUnitController = this.l) != null) {
            this.r = 0L;
            inneractiveAdViewUnitController.refreshAd();
        }
    }

    public final void K() {
        com.fyber.inneractive.sdk.web.m mVar;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (mVar = iAmraidWebViewController.b) == null || !mVar.getIsVisible() || this.r == 0 || this.m.p() || this.m.N == f0.RESIZED) {
            return;
        }
        if (!this.w) {
            if (this.k < System.currentTimeMillis() - this.r) {
                this.u = 1L;
            } else {
                this.u = this.k - (System.currentTimeMillis() - this.r);
            }
        }
        IAlog.a("%sresuming refresh runnable mRefreshTimeStamp %d", IAlog.a(this), Long.valueOf(this.u));
        a(false, this.u);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean a(x xVar) {
        return xVar instanceof o0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean b(View view) {
        return view.equals(this.p);
    }

    public final void c(boolean z) {
        if (this.s != null) {
            this.w = z;
            G();
            this.u = this.k - (System.currentTimeMillis() - this.r);
            IAlog.a("%sPause refresh time : time remaning:%d ,refreshInterval: %d", IAlog.a(this), Long.valueOf(this.u), Long.valueOf(this.k));
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final boolean canRefreshAd() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.p() || this.m.N == f0.RESIZED) ? false : true;
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int d() {
        return this.m.d0;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        G();
        H();
        this.n = null;
        com.fyber.inneractive.sdk.util.x.f1785a.f1787a.remove(this);
        h hVar = this.s;
        if (hVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(hVar);
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final void e(View view) {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        IAmraidWebViewController iAmraidWebViewController = this.m;
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

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void l() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int n() {
        return this.m.e0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void q() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void s() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.j);
        }
        i iVar = this.q;
        if (iVar != null) {
            iVar.removeAllViews();
            this.q = null;
        }
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.p = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final View x() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return iAmraidWebViewController.b;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final int y() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.b == null || !iAmraidWebViewController.p()) ? com.fyber.inneractive.sdk.util.o.c(this.m.e0) : com.fyber.inneractive.sdk.util.o.c(this.m.b.getHeight());
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final int z() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.b == null || !iAmraidWebViewController.p()) ? com.fyber.inneractive.sdk.util.o.c(this.m.d0) : com.fyber.inneractive.sdk.util.o.c(this.m.b.getWidth());
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0259  */
    @Override // com.fyber.inneractive.sdk.interfaces.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        com.fyber.inneractive.sdk.response.f fVar;
        i iVar;
        d dVar;
        int i;
        float f;
        InneractiveAdSpot inneractiveAdSpot = this.f1175a;
        if (inneractiveAdSpot == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        this.o = false;
        this.e = false;
        if (viewGroup != null) {
            this.p = viewGroup;
            this.l = (InneractiveAdViewUnitController) inneractiveAdSpot.getSelectedUnitController();
        } else if (!this.x) {
            H();
            if (!(this.f1175a.getAdContent() instanceof o0)) {
                IAlog.f("InneractiveAdViewMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", this.f1175a.getAdContent());
                return;
            }
            this.b = (o0) this.f1175a.getAdContent();
        }
        x xVar = this.b;
        IAmraidWebViewController iAmraidWebViewController = xVar != null ? ((o0) xVar).i : null;
        this.m = iAmraidWebViewController;
        if (iAmraidWebViewController != null) {
            if (this.n == null) {
                this.n = new g(this);
            }
            iAmraidWebViewController.setListener(this.n);
            o0 o0Var = (o0) this.b;
            InneractiveAdRequest inneractiveAdRequest = o0Var.f1249a;
            s0 s0Var = o0Var.d;
            if (s0Var != null) {
                r0 r0Var = (r0) s0Var;
                if (r0Var.c != null && r0Var.c.b != null && r0Var.c.b.isFullscreenUnit()) {
                    i iVar2 = new i(this.p.getContext(), 1.5f);
                    this.q = iVar2;
                    this.m.a(iVar2, new ViewGroup.LayoutParams(-1, -1));
                    this.p.addView(this.q, new ViewGroup.LayoutParams(-2, -2));
                    x xVar2 = this.b;
                    fVar = xVar2 != null ? (com.fyber.inneractive.sdk.response.f) ((o0) xVar2).b : null;
                    if (fVar != null && (iVar = this.q) != null) {
                        dVar = new d(fVar, iVar, new f(this));
                        this.y = dVar;
                        dVar.h = false;
                        dVar.d = 1;
                        dVar.e = 0.0f;
                        i = fVar.v;
                        if (i >= 1) {
                            dVar.d = Math.min(i, 100);
                        }
                        f = fVar.w;
                        if (f >= -1.0f) {
                            dVar.e = f;
                        }
                        if (dVar.e >= 0.0f) {
                            IAlog.a("IAVisibilityTracker: startTrackingVisibility", new Object[0]);
                            dVar.c = 0.0f;
                            dVar.f = System.currentTimeMillis();
                            dVar.g = true;
                            dVar.a();
                        }
                    }
                }
            }
            this.q = new i(this.p.getContext(), 0.0f);
            o0 o0Var2 = (o0) this.b;
            com.fyber.inneractive.sdk.response.f fVar2 = (com.fyber.inneractive.sdk.response.f) o0Var2.b;
            f1 a2 = a(fVar2.e, fVar2.f, o0Var2.d);
            this.m.setAdDefaultSize(a2.f1758a, a2.b);
            IAmraidWebViewController iAmraidWebViewController2 = this.m;
            com.fyber.inneractive.sdk.web.m mVar = iAmraidWebViewController2.b;
            if (mVar != null || com.fyber.inneractive.sdk.util.o.f1770a == null) {
                ViewParent parent = mVar != null ? mVar.getParent() : null;
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(mVar);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2.f1758a, a2.b);
                layoutParams.addRule(new int[]{13}[0]);
                this.m.a(this.q, layoutParams);
                this.p.addView(this.q);
                i iVar3 = this.q;
                ViewGroup.LayoutParams layoutParams2 = iVar3.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -2;
                iVar3.setLayoutParams(layoutParams2);
                InneractiveAdSpot inneractiveAdSpot2 = this.f1175a;
                if (inneractiveAdSpot2 != null && inneractiveAdSpot2.getAdContent() != null && (viewGroup2 = this.p) != null) {
                    Context context = viewGroup2.getContext();
                    com.fyber.inneractive.sdk.flow.g gVar = new com.fyber.inneractive.sdk.flow.g(context, false, this.f1175a.getAdContent().f1249a, this.f1175a.getAdContent().c(), this.f1175a.getAdContent().c);
                    ViewGroup viewGroup4 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ia_layout_fyber_ad_identifier_relative, this.p, false);
                    IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
                    IFyberAdIdentifier iFyberAdIdentifier = gVar.d;
                    iFyberAdIdentifier.k = corner;
                    iFyberAdIdentifier.a(viewGroup4);
                    viewGroup4.setVisibility(0);
                    IAmraidWebViewController iAmraidWebViewController3 = this.m;
                    if (iAmraidWebViewController3 == null) {
                        viewGroup3 = null;
                    } else {
                        viewGroup3 = iAmraidWebViewController3.b;
                        if (viewGroup3 != null && viewGroup3.getParent() != null) {
                            viewGroup3 = (ViewGroup) viewGroup3.getParent();
                        }
                    }
                    if (viewGroup3 != null && x() != null) {
                        ViewGroup.LayoutParams layoutParams3 = x().getLayoutParams();
                        IAmraidWebViewController iAmraidWebViewController4 = this.m;
                        viewGroup3.addView(viewGroup4, layoutParams3);
                        iAmraidWebViewController4.a(viewGroup4, com.fyber.inneractive.sdk.measurement.tracker.d.IdentifierView);
                    }
                }
            } else if (this.x) {
                FrameLayout frameLayout = new FrameLayout(this.p.getContext());
                frameLayout.setBackgroundResource(R.color.ia_blank_background);
                this.p.removeAllViews();
                this.p.addView(frameLayout, new FrameLayout.LayoutParams(a2.f1758a, a2.b, 17));
            } else {
                this.x = true;
                iAmraidWebViewController2.b = iAmraidWebViewController2.a(((o0) this.b).c);
                try {
                    iAmraidWebViewController2.h();
                    iAmraidWebViewController2.b.loadDataWithBaseURL(iAmraidWebViewController2.p, iAmraidWebViewController2.q, "text/html", D5.N, null);
                } catch (Throwable unused) {
                    FrameLayout frameLayout2 = new FrameLayout(this.p.getContext());
                    frameLayout2.setBackgroundResource(R.color.ia_blank_background);
                    this.p.removeAllViews();
                    this.p.addView(frameLayout2, new FrameLayout.LayoutParams(a2.f1758a, a2.b, 17));
                }
            }
            x xVar22 = this.b;
            if (xVar22 != null) {
            }
            if (fVar != null) {
                dVar = new d(fVar, iVar, new f(this));
                this.y = dVar;
                dVar.h = false;
                dVar.d = 1;
                dVar.e = 0.0f;
                i = fVar.v;
                if (i >= 1) {
                }
                f = fVar.w;
                if (f >= -1.0f) {
                }
                if (dVar.e >= 0.0f) {
                }
            }
        } else {
            IAlog.f("InneractiveAdViewMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", xVar);
        }
        z zVar = com.fyber.inneractive.sdk.util.x.f1785a;
        if (zVar.f1787a.contains(this)) {
            return;
        }
        zVar.f1787a.add(this);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void p() {
        com.fyber.inneractive.sdk.web.m mVar;
        IAlog.a("%sgot onAdRefreshFailed", IAlog.a(this));
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (mVar = iAmraidWebViewController.b) == null) {
            return;
        }
        if (!mVar.getIsVisible() || com.fyber.inneractive.sdk.util.x.f1785a.b || this.m.p() || this.m.N == f0.RESIZED) {
            IAlog.a("%sview is not visible or screen is locked or webView is Expanded or web is Resised. Waiting for visibility change", IAlog.a(this));
            this.u = 1L;
            return;
        }
        IAlog.a("%sview is visible and screen is unlocked: refreshing ad and webView is not expanded", IAlog.a(this));
        long I = I();
        this.k = I;
        if (I != 0) {
            a(false, 10000L);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final void d(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, com.fyber.inneractive.sdk.measurement.tracker.d.ProgressOverlay);
        }
    }

    public final void a(boolean z, long j) {
        IAmraidWebViewController iAmraidWebViewController;
        com.fyber.inneractive.sdk.web.m mVar;
        if (!TextUtils.isEmpty(this.f1175a.getMediationNameString()) || j == 0 || (this.f1175a.getSelectedUnitController() instanceof InneractiveFullscreenUnitController) || this.t == -1 || (iAmraidWebViewController = this.m) == null || (mVar = iAmraidWebViewController.b) == null) {
            return;
        }
        if (!mVar.getIsVisible()) {
            IAlog.a("%sstartRefreshTimer called but ad is not visible", IAlog.a(this));
            return;
        }
        this.r = System.currentTimeMillis();
        this.k = z ? this.k : j;
        IAlog.a("%sstartRefreshTimer in %d msec, mRefreshInterval = %d", IAlog.a(this), Long.valueOf(j), Long.valueOf(this.k));
        if (j > 1) {
            h hVar = this.s;
            if (hVar != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(hVar);
            }
            G();
            h hVar2 = new h(this);
            this.s = hVar2;
            com.fyber.inneractive.sdk.util.r.b.postDelayed(hVar2, j);
            return;
        }
        J();
    }

    public static f1 a(int i, int i2, s0 s0Var) {
        int a2;
        int a3;
        l0 l0Var;
        IAlog.a("View layout params: response width and height: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i > 0 && i2 > 0) {
            a2 = com.fyber.inneractive.sdk.util.o.a(i);
            a3 = com.fyber.inneractive.sdk.util.o.a(i2);
        } else {
            UnitDisplayType unitDisplayType = UnitDisplayType.BANNER;
            if (s0Var != null && (l0Var = ((r0) s0Var).c) != null) {
                unitDisplayType = l0Var.b;
            }
            if (unitDisplayType.equals(UnitDisplayType.MRECT)) {
                a2 = com.fyber.inneractive.sdk.util.o.a(j.RECTANGLE_WIDTH.value);
                a3 = com.fyber.inneractive.sdk.util.o.a(j.RECTANGLE_HEIGHT.value);
            } else if (com.fyber.inneractive.sdk.util.k.m()) {
                a2 = com.fyber.inneractive.sdk.util.o.a(j.BANNER_TABLET_WIDTH.value);
                a3 = com.fyber.inneractive.sdk.util.o.a(j.BANNER_TABLET_HEIGHT.value);
            } else {
                a2 = com.fyber.inneractive.sdk.util.o.a(j.BANNER_WIDTH.value);
                a3 = com.fyber.inneractive.sdk.util.o.a(j.BANNER_HEIGHT.value);
            }
        }
        IAlog.e("View layout params: final scaled width and height: %d, %d", Integer.valueOf(a2), Integer.valueOf(a3));
        return new f1(a2, a3);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(int i) {
        this.t = i;
    }
}
