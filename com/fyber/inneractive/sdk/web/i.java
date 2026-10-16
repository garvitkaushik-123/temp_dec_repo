package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdSession;

/* loaded from: classes4.dex */
public abstract class i implements j, com.fyber.inneractive.sdk.util.k0, l, x0 {
    public m b;
    public j0 c;
    public k0 d;
    public g f;
    public j1 g;
    public boolean j;
    public final boolean k;
    public f l;
    public final d m;
    public final c n;
    public e o;
    public String p;
    public String q;
    public InneractiveAdRequest r;
    public com.fyber.inneractive.sdk.flow.x s;
    public com.fyber.inneractive.sdk.response.e t;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1804a = false;
    public float h = 0.0f;
    public final Rect i = new Rect();
    public final boolean e = false;

    public i(boolean z, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.k = z;
        this.b = a(rVar);
        i1 i1Var = (i1) this;
        this.n = new c(i1Var);
        this.m = new d(i1Var);
    }

    @Override // com.fyber.inneractive.sdk.web.j
    public void a(WebView webView) {
    }

    public abstract boolean a(String str, com.fyber.inneractive.sdk.util.e1 e1Var);

    public void b(boolean z) {
        IAlog.a("%s destroy is fatal: %b", IAlog.a(this), Boolean.valueOf(z));
        e eVar = this.o;
        if (eVar != null && !eVar.f1796a.isTerminated() && !eVar.f1796a.isShutdown()) {
            e eVar2 = this.o;
            eVar2.f = true;
            eVar2.f1796a.shutdownNow();
            Handler handler = eVar2.b;
            if (handler != null) {
                com.fyber.inneractive.sdk.util.d dVar = eVar2.d;
                if (dVar != null) {
                    handler.removeCallbacks(dVar);
                }
                com.fyber.inneractive.sdk.util.e eVar3 = eVar2.c;
                if (eVar3 != null) {
                    eVar2.b.removeCallbacks(eVar3);
                }
                eVar2.b = null;
            }
            this.o = null;
        }
        m mVar = this.b;
        if (mVar != null) {
            com.fyber.inneractive.sdk.util.j0.f1762a.a(mVar);
            com.fyber.inneractive.sdk.util.t.a(this.b);
            this.b.setWebChromeClient(null);
            if (f() == null) {
                this.b.destroy();
            } else {
                com.fyber.inneractive.sdk.measurement.tracker.e f = f();
                AdSession adSession = f.f1273a;
                if (adSession != null) {
                    try {
                        adSession.finish();
                    } catch (Throwable unused) {
                    }
                    com.fyber.inneractive.sdk.util.r.b.postDelayed(new com.fyber.inneractive.sdk.measurement.tracker.c(f), z ? 0 : 1000);
                    f.f1273a = null;
                    f.b = null;
                }
            }
        }
        k0 k0Var = this.d;
        if (k0Var != null) {
            k0Var.e = null;
        }
        c cVar = this.n;
        if (cVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(cVar);
        }
        d dVar2 = this.m;
        if (dVar2 != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar2);
        }
        this.g = null;
        if (!z) {
            this.f = null;
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.s = null;
        this.r = null;
    }

    @Override // com.fyber.inneractive.sdk.web.j
    public void d() {
    }

    public void e() {
        b(false);
    }

    public abstract com.fyber.inneractive.sdk.measurement.tracker.e f();

    public com.fyber.inneractive.sdk.util.e1 g() {
        m mVar = this.b;
        return mVar != null ? mVar.getLastClickedLocation() : new com.fyber.inneractive.sdk.util.e1();
    }

    public void h() {
        WebSettings settings = this.b.getSettings();
        boolean z = true;
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (!IAConfigManager.O.q && com.fyber.inneractive.sdk.util.s.a()) {
            settings.setMixedContentMode(2);
        }
        if (this.e) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        m mVar = this.b;
        mVar.setHorizontalScrollBarEnabled(false);
        mVar.setHorizontalScrollbarOverlay(false);
        mVar.setVerticalScrollBarEnabled(false);
        mVar.setVerticalScrollbarOverlay(false);
        mVar.getSettings().setSupportZoom(false);
        this.b.setFocusable(true);
        this.b.setBackgroundColor(0);
        j0 j0Var = new j0();
        this.c = j0Var;
        this.b.setWebChromeClient(j0Var);
        try {
            Context context = this.b.getContext();
            ApplicationInfo applicationInfo = context != null ? context.getApplicationInfo() : null;
            if (applicationInfo == null || (applicationInfo.flags & 2) == 0) {
                z = false;
            }
            WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception unused) {
            IAlog.a("Could not set web contents debugging flag", new Object[0]);
        }
        this.b.setListener(this);
    }

    public final void i() {
        IAlog.a("IAWebViewController resetClick()", new Object[0]);
        c cVar = this.n;
        if (cVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(cVar);
        }
        d dVar = this.m;
        if (dVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar);
        }
        this.j = false;
    }

    public void setAdContent(com.fyber.inneractive.sdk.flow.x xVar) {
        this.s = xVar;
    }

    public void setAdRequest(InneractiveAdRequest inneractiveAdRequest) {
        this.r = inneractiveAdRequest;
    }

    public void setAdResponse(com.fyber.inneractive.sdk.response.e eVar) {
        this.t = eVar;
    }

    public void setListener(j1 j1Var) {
        this.g = j1Var;
    }

    public final void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        m mVar = this.b;
        if (mVar != null) {
            if (layoutParams != null) {
                viewGroup.addView(mVar, layoutParams);
            } else {
                viewGroup.addView(mVar);
            }
            com.fyber.inneractive.sdk.util.j0.f1762a.a(viewGroup.getContext(), this.b, this);
            this.b.setTapListener(this);
        }
    }

    public final m a(com.fyber.inneractive.sdk.config.global.r rVar) {
        int i;
        int i2;
        m mVar = new m();
        if (rVar != null) {
            com.fyber.inneractive.sdk.config.global.features.f fVar = (com.fyber.inneractive.sdk.config.global.features.f) rVar.a(com.fyber.inneractive.sdk.config.global.features.f.class);
            Boolean c = fVar.c("agg_res");
            r1 = c != null ? c.booleanValue() : false;
            Integer a2 = fVar.a("agg_res_ct");
            int max = Math.max(a2 != null ? a2.intValue() : 500, 50);
            Integer a3 = fVar.a("agg_res_rt");
            int max2 = Math.max(a3 != null ? a3.intValue() : 500, 50);
            Integer a4 = fVar.a("agg_res_retries");
            r3 = Math.max(a4 != null ? a4.intValue() : 2, 1);
            i2 = max2;
            i = max;
        } else {
            i = 500;
            i2 = 500;
        }
        k0 k0Var = new k0(this, r1, i, i2, r3);
        this.d = k0Var;
        mVar.setWebViewClient(k0Var);
        return mVar;
    }

    @Override // com.fyber.inneractive.sdk.util.k0
    public final void a(float f, Rect rect) {
        if (f == this.h && rect.equals(this.i)) {
            return;
        }
        this.h = f;
        this.i.set(rect);
        m mVar = this.b;
        if (mVar != null) {
            mVar.a();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.j
    public boolean a(WebView webView, String str) {
        IAlog.a("%shandleUrl called with: %s", IAlog.a(this), str);
        if (this.b == null) {
            IAlog.a("handleUrl: web view already destroyed. Cannot handle url", new Object[0]);
            return false;
        }
        if (com.fyber.inneractive.sdk.util.h1.a(str)) {
            this.b.loadUrl("chrome://crash");
            return true;
        }
        if (str != null && str.startsWith("data:")) {
            return false;
        }
        com.fyber.inneractive.sdk.util.e1 g = g();
        if (a(str, g)) {
            return true;
        }
        a(new h(this, str, g));
        return true;
    }

    public void a(boolean z) {
        IAlog.a("%sonWebViewVisibilityChanged called with: %s", IAlog.a(this), Boolean.valueOf(z));
        j1 j1Var = this.g;
        if (j1Var != null) {
            j1Var.a(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.j
    public void a() {
        j1 j1Var = this.g;
        if (j1Var != null) {
            j1Var.a();
        }
        b(true);
    }

    public final void a(f fVar) {
        IAlog.e("IAWebViewController Web view click detected", new Object[0]);
        if (this.j) {
            IAlog.e("IAWebViewController Native click detected before web view request. Processing click", new Object[0]);
            fVar.d();
            i();
            return;
        }
        if (this.k) {
            IAlog.e("IAWebViewController Native click was not detected yet. Caching click request and waiting", new Object[0]);
            d dVar = this.m;
            if (dVar != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar);
            }
            this.l = fVar;
            if (this.m != null) {
                com.fyber.inneractive.sdk.util.r.b.postDelayed(this.m, IAConfigManager.O.u.b.a("click_timeout", 1000, 1000));
                return;
            }
            return;
        }
        d dVar2 = this.m;
        if (dVar2 != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar2);
        }
        this.l = null;
        fVar.d();
    }
}
