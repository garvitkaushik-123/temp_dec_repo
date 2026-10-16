package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.network.f1;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.util.w0;
import com.fyber.inneractive.sdk.web.v0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class a0 implements InneractiveAdRenderer, InneractiveInternalBrowserActivity.InternalBrowserListener, com.fyber.inneractive.sdk.click.f, com.fyber.inneractive.sdk.web.t0 {

    /* renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f1175a;
    public x b;
    public InneractiveUnitController.EventsListener c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = true;
    public Runnable g;
    public com.fyber.inneractive.sdk.click.r h;
    public y i;
    public View j;

    public final boolean A() {
        com.fyber.inneractive.sdk.config.global.r rVar;
        x xVar = this.b;
        if (xVar == null || (rVar = xVar.c) == null || rVar.a(com.fyber.inneractive.sdk.config.global.features.c.class) == null) {
            return false;
        }
        com.fyber.inneractive.sdk.config.global.features.c cVar = (com.fyber.inneractive.sdk.config.global.features.c) this.b.c.a(com.fyber.inneractive.sdk.config.global.features.c.class);
        cVar.getClass();
        return new ArrayList(cVar.c.values()).size() > 0;
    }

    public boolean B() {
        return false;
    }

    public final void C() {
        com.fyber.inneractive.sdk.response.e c;
        Context w = w();
        if (this.e || this.c == null) {
            return;
        }
        IAlog.a("%sCalling external interface onAdImpression", IAlog.a(this));
        this.c.onAdImpression(this.f1175a);
        x xVar = this.b;
        if (xVar != null && (c = xVar.c()) != null) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            x0 x0Var = iAConfigManager.x;
            if (x0Var != null) {
                UnitDisplayType unitDisplayType = c.p;
                ImpressionData impressionData = c.t;
                x0Var.a(unitDisplayType, "LAST_DOMAIN_SHOWED", impressionData != null ? impressionData.getAdvertiserDomain() : null);
                x0Var.a(unitDisplayType, "LAST_APP_BUNDLE_ID", c.A);
                if (this.b.isVideoAd()) {
                    String[] strArr = new String[1];
                    x0Var.a(unitDisplayType, "LAST_VAST_SKIPED", "0");
                    String[] strArr2 = new String[1];
                    x0Var.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE", "0");
                }
                String[] strArr3 = new String[1];
                x0Var.a(unitDisplayType, "LAST_CLICKED", "0");
            }
            w0 w0Var = iAConfigManager.A;
            com.fyber.inneractive.sdk.config.s0 s0Var = this.b.d;
            ImpressionData impressionData2 = c.t;
            if (s0Var != null) {
                OnGlobalImpressionDataListener onGlobalImpressionDataListener = w0Var.f1784a;
                if (onGlobalImpressionDataListener != null) {
                    com.fyber.inneractive.sdk.config.r0 r0Var = (com.fyber.inneractive.sdk.config.r0) s0Var;
                    onGlobalImpressionDataListener.onImpression(r0Var.b, r0Var.f1114a, impressionData2);
                }
            } else {
                w0Var.getClass();
            }
            InneractiveUnitController.EventsListener eventsListener = this.c;
            if (eventsListener instanceof InneractiveFullscreenAdEventsListenerWithImpressionData) {
                ((InneractiveFullscreenAdEventsListenerWithImpressionData) eventsListener).onAdImpression(this.f1175a, c.t);
            } else if (eventsListener instanceof InneractiveAdViewEventsListenerWithImpressionData) {
                ((InneractiveAdViewEventsListenerWithImpressionData) eventsListener).onAdImpression(this.f1175a, c.t);
            }
            com.fyber.inneractive.sdk.privacysandbox.b a2 = com.fyber.inneractive.sdk.privacysandbox.b.a(w);
            if (a2 == null) {
                a2 = null;
            }
            String str = c.m;
            if (!TextUtils.isEmpty(str) && a2 != null) {
                a2.a(str, null);
            }
        }
        this.e = true;
    }

    public final void D() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillOpenExternalApp", IAlog.a(this));
            this.c.onAdWillOpenExternalApp(this.f1175a);
        }
    }

    public void E() {
        View x = x();
        if (x == null || this.j == null || x.getParent() == null || !(x.getParent() instanceof ViewGroup)) {
            return;
        }
        x.getLayoutParams();
        ((ViewGroup) x.getParent()).removeView(this.j);
        e(this.j);
        this.j = null;
    }

    public final void F() {
        x xVar = this.b;
        if (xVar == null || xVar.c() == null) {
            return;
        }
        String str = this.b.c().q;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IAlog.e("%sfiring rewarded completion!", IAlog.a(this));
        IAlog.d("AD_REWARDED_COMPLETION", new Object[0]);
        com.fyber.inneractive.sdk.network.x0.b(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.fyber.inneractive.sdk.util.b0 a(Context context, String str, e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        String str2;
        String str3;
        boolean z;
        com.fyber.inneractive.sdk.click.r rVar;
        v0 b;
        x xVar;
        com.fyber.inneractive.sdk.click.r rVar2;
        com.fyber.inneractive.sdk.ignite.m mVar;
        String str4;
        String str5;
        if (!this.f || this.d) {
            String str6 = this.d ? "external/browser is already open" : "click is in grace period";
            IAlog.a("InneractiveAdRendererImpl: openClickThroughUrl - %s", str6);
            return new com.fyber.inneractive.sdk.util.b0(com.fyber.inneractive.sdk.util.e0.FAILED, new Exception(str6));
        }
        if (context != null) {
            IAlog.a("%sBlocking clicks until grace has ended", IAlog.a(this));
            this.f = false;
            Runnable runnable = this.g;
            if (runnable != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            }
            z zVar = new z(this);
            this.g = zVar;
            com.fyber.inneractive.sdk.util.r.b.postDelayed(zVar, 1000L);
        }
        a(context, e1Var.f1756a, e1Var.b);
        if (TextUtils.isEmpty(str)) {
            IAlog.a("InneractiveAdRendererImpl: openClickThroughUrl - is empty", new Object[0]);
            return new com.fyber.inneractive.sdk.util.b0(com.fyber.inneractive.sdk.util.e0.FAILED, new Exception("empty url"));
        }
        x xVar2 = this.b;
        if (xVar2 != null && xVar2.c() != null && this.b.c().a()) {
            com.fyber.inneractive.sdk.ignite.h hVar = IAConfigManager.O.E;
            if (hVar.f) {
                hVar.a((com.digitalturbine.ignite.authenticator.listeners.internal.a) null);
            }
        }
        this.i = new y(this, e1Var, gVar);
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (scheme != null && scheme.equals("fybernativebrowser") && host != null && host.equals("navigate")) {
                str2 = parse.getQueryParameter("url");
                String scheme2 = TextUtils.isEmpty(str) ? Uri.parse(str).getScheme() : null;
                if (TextUtils.isEmpty(str2)) {
                    str3 = str2;
                } else {
                    str3 = str;
                    if (!str3.contains("FYBER_OPEN_BROWSER")) {
                        z = true;
                        if (str3.contains("[IS_CTA_CLICK]")) {
                            str3 = str3.replace("[IS_CTA_CLICK]", String.valueOf(B() && gVar == com.fyber.inneractive.sdk.util.g.VIDEO_CTA));
                        }
                        if (x() != null) {
                            v();
                        }
                        rVar = this.h;
                        if (rVar != null) {
                            rVar.e = true;
                            Iterator it = rVar.i.iterator();
                            while (it.hasNext()) {
                                ((com.fyber.inneractive.sdk.click.a) it.next()).cancel();
                            }
                            rVar.i.clear();
                            f1 f1Var = rVar.h;
                            if (f1Var != null) {
                                f1Var.f1337a = true;
                            }
                            rVar.d = null;
                            this.h = null;
                        }
                        com.fyber.inneractive.sdk.click.r rVar3 = new com.fyber.inneractive.sdk.click.r(z);
                        rVar3.i.addAll(Arrays.asList(new com.fyber.inneractive.sdk.click.i(!z, scheme2), new com.fyber.inneractive.sdk.click.g(this, e1Var, gVar), new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.h(), new com.fyber.inneractive.sdk.click.l()));
                        this.h = rVar3;
                        x xVar3 = this.b;
                        b = xVar3 != null ? xVar3.b() : null;
                        if (b != null) {
                            b.i = this;
                        }
                        x xVar4 = this.b;
                        boolean z2 = xVar4 == null && xVar4.a(e1Var.c, gVar);
                        xVar = this.b;
                        if (xVar != null && xVar.c() != null) {
                            this.b.g();
                        }
                        rVar2 = this.h;
                        if (rVar2 != null) {
                            y yVar = this.i;
                            x xVar5 = this.b;
                            com.fyber.inneractive.sdk.ignite.m mVar2 = (xVar5 == null || xVar5.c() == null) ? com.fyber.inneractive.sdk.ignite.m.NONE : this.b.c().H;
                            InneractiveAdSpot inneractiveAdSpot = this.f1175a;
                            if (inneractiveAdSpot != null) {
                                str5 = inneractiveAdSpot.getLocalUniqueId();
                                String str7 = str3;
                                mVar = mVar2;
                                str4 = str7;
                            } else {
                                String str8 = str3;
                                mVar = mVar2;
                                str4 = str8;
                                str5 = null;
                            }
                            rVar2.a(context, str4, yVar, b, z2, mVar, str5);
                        }
                        com.fyber.inneractive.sdk.util.e0 e0Var = com.fyber.inneractive.sdk.util.e0.OPEN_IN_EXTERNAL_APPLICATION;
                        context.getClass();
                        return new com.fyber.inneractive.sdk.util.b0(e0Var, null);
                    }
                }
                z = false;
                if (str3.contains("[IS_CTA_CLICK]")) {
                }
                if (x() != null) {
                }
                rVar = this.h;
                if (rVar != null) {
                }
                com.fyber.inneractive.sdk.click.r rVar32 = new com.fyber.inneractive.sdk.click.r(z);
                rVar32.i.addAll(Arrays.asList(new com.fyber.inneractive.sdk.click.i(!z, scheme2), new com.fyber.inneractive.sdk.click.g(this, e1Var, gVar), new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.h(), new com.fyber.inneractive.sdk.click.l()));
                this.h = rVar32;
                x xVar32 = this.b;
                if (xVar32 != null) {
                }
                if (b != null) {
                }
                x xVar42 = this.b;
                if (xVar42 == null) {
                }
                xVar = this.b;
                if (xVar != null) {
                    this.b.g();
                }
                rVar2 = this.h;
                if (rVar2 != null) {
                }
                com.fyber.inneractive.sdk.util.e0 e0Var2 = com.fyber.inneractive.sdk.util.e0.OPEN_IN_EXTERNAL_APPLICATION;
                context.getClass();
                return new com.fyber.inneractive.sdk.util.b0(e0Var2, null);
            }
        }
        str2 = null;
        if (TextUtils.isEmpty(str)) {
        }
        if (TextUtils.isEmpty(str2)) {
        }
        z = false;
        if (str3.contains("[IS_CTA_CLICK]")) {
        }
        if (x() != null) {
        }
        rVar = this.h;
        if (rVar != null) {
        }
        com.fyber.inneractive.sdk.click.r rVar322 = new com.fyber.inneractive.sdk.click.r(z);
        rVar322.i.addAll(Arrays.asList(new com.fyber.inneractive.sdk.click.i(!z, scheme2), new com.fyber.inneractive.sdk.click.g(this, e1Var, gVar), new com.fyber.inneractive.sdk.click.d(), new com.fyber.inneractive.sdk.click.h(), new com.fyber.inneractive.sdk.click.l()));
        this.h = rVar322;
        x xVar322 = this.b;
        if (xVar322 != null) {
        }
        if (b != null) {
        }
        x xVar422 = this.b;
        if (xVar422 == null) {
        }
        xVar = this.b;
        if (xVar != null) {
        }
        rVar2 = this.h;
        if (rVar2 != null) {
        }
        com.fyber.inneractive.sdk.util.e0 e0Var22 = com.fyber.inneractive.sdk.util.e0.OPEN_IN_EXTERNAL_APPLICATION;
        context.getClass();
        return new com.fyber.inneractive.sdk.util.b0(e0Var22, null);
    }

    public final void b(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.k;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.e("%sfiring impression!", IAlog.a(this));
        IAlog.d("AD_IMPRESSION", new Object[0]);
        com.fyber.inneractive.sdk.network.x0.b(str);
    }

    public final Context c(View view) {
        View view2;
        int i = 0;
        View[] viewArr = {view, x()};
        while (true) {
            if (i >= 2) {
                view2 = null;
                break;
            }
            view2 = viewArr[i];
            if (view2 != null) {
                break;
            }
            i++;
        }
        return com.fyber.inneractive.sdk.util.o.a(view2);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public boolean canRefreshAd() {
        return true;
    }

    public void d(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        if (this.d) {
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
            this.d = false;
        }
        Runnable runnable = this.g;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.g = null;
        }
        this.b = null;
        this.c = null;
        this.f1175a = null;
        if (this.h != null) {
            E();
            com.fyber.inneractive.sdk.click.r rVar = this.h;
            rVar.e = true;
            Iterator it = rVar.i.iterator();
            while (it.hasNext()) {
                ((com.fyber.inneractive.sdk.click.a) it.next()).cancel();
            }
            rVar.i.clear();
            f1 f1Var = rVar.h;
            if (f1Var != null) {
                f1Var.f1337a = true;
            }
            rVar.d = null;
            this.h = null;
            this.i = null;
        }
    }

    public void e(View view) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.f1175a = inneractiveAdSpot;
        this.b = inneractiveAdSpot.getAdContent();
        this.c = inneractiveAdSpot.getSelectedUnitController().getEventsListener();
    }

    public final com.fyber.inneractive.sdk.ignite.m o() {
        x xVar = this.b;
        return (xVar == null || !xVar.e() || this.b.c() == null) ? com.fyber.inneractive.sdk.ignite.m.NONE : this.b.c().H;
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public final void onApplicationInBackground() {
        D();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.InternalBrowserListener
    public final void onInternalBrowserDismissed() {
        IAlog.a("onInternalBrowserDismissed callback called", new Object[0]);
        if (this.d) {
            this.d = false;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(null);
        }
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillCloseInternalBrowser", IAlog.a(this));
            this.c.onAdWillCloseInternalBrowser(this.f1175a);
        }
    }

    public void v() {
        View x = x();
        if (x == null || x.getParent() == null || !(x.getParent() instanceof ViewGroup) || this.j != null) {
            return;
        }
        View inflate = View.inflate(x.getContext(), R.layout.ia_layout_click_overlay, null);
        this.j = inflate;
        if (inflate != null) {
            ((ViewGroup) x.getParent()).addView(this.j, x.getLayoutParams());
            d(this.j);
        }
    }

    public Context w() {
        return com.fyber.inneractive.sdk.util.o.a(x());
    }

    public abstract View x();

    public int y() {
        return -1;
    }

    public int z() {
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01cc, code lost:
    
        if (r10 == false) goto L115;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(com.fyber.inneractive.sdk.click.b bVar, e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        boolean z;
        boolean z2;
        com.fyber.inneractive.sdk.config.global.r rVar;
        com.fyber.inneractive.sdk.config.global.r rVar2;
        Object obj;
        com.fyber.inneractive.sdk.config.global.r rVar3;
        x xVar = this.b;
        InneractiveAdRequest inneractiveAdRequest = xVar != null ? xVar.f1249a : null;
        com.fyber.inneractive.sdk.response.e c = xVar != null ? xVar.c() : null;
        x xVar2 = this.b;
        JSONArray b = (xVar2 == null || (rVar3 = xVar2.c) == null) ? null : rVar3.b();
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.FYBER_SUCCESS_CLICK;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(c);
        wVar.c = uVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = b;
        com.fyber.inneractive.sdk.network.x xVar3 = new com.fyber.inneractive.sdk.network.x();
        long j = bVar.e;
        if (j != 0) {
            xVar3.a(Long.valueOf(j), "time_passed");
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = bVar.f.iterator();
        while (it.hasNext()) {
            com.fyber.inneractive.sdk.click.j jVar = (com.fyber.inneractive.sdk.click.j) it.next();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", jVar.f1063a);
                jSONObject.put("success", jVar.b);
                jSONObject.put("opened_by", jVar.c);
                jSONObject.put("reason", jVar.d);
            } catch (Exception unused) {
            }
            jSONArray.put(jSONObject);
        }
        xVar3.a(jSONArray, "urls");
        xVar3.a(gVar, "origin");
        if (gVar == com.fyber.inneractive.sdk.util.g.FMP_ENDCARD) {
            xVar3.a(gVar.a(), "version");
        }
        if (e1Var != null && e1Var.c) {
            xVar3.a(Boolean.TRUE, "is_auto_click");
        }
        boolean z3 = true;
        if (e1Var != null) {
            if (e1Var.f1756a > 0.0f && e1Var.b > 0.0f) {
                x xVar4 = this.b;
                boolean d = xVar4 != null ? xVar4.d() : true;
                int z4 = z();
                if (!d) {
                    z4 = com.fyber.inneractive.sdk.util.o.b(z4);
                }
                float f = z4 == 0 ? 0.0f : e1Var.f1756a / z4;
                x xVar5 = this.b;
                boolean d2 = xVar5 != null ? xVar5.d() : true;
                int y = y();
                if (!d2) {
                    y = com.fyber.inneractive.sdk.util.o.b(y);
                }
                float f2 = y != 0 ? e1Var.b / y : 0.0f;
                IAlog.a("Point location -  x - %.2f , y- %.2f", Float.valueOf(f), Float.valueOf(f2));
                x xVar6 = this.b;
                if (xVar6 != null) {
                    xVar6.d();
                }
                Locale locale = Locale.ENGLISH;
                com.fyber.inneractive.sdk.network.x a2 = xVar3.a(String.format(locale, "%.2f", Float.valueOf(f)), "td_x");
                x xVar7 = this.b;
                if (xVar7 != null) {
                    xVar7.d();
                }
                a2.a(String.format(locale, "%.2f", Float.valueOf(f2)), "td_y");
            }
        }
        x xVar8 = this.b;
        if (xVar8 != null ? xVar8.d() : true) {
            if (com.fyber.inneractive.sdk.util.o.c() == 1) {
                obj = "p";
            } else {
                obj = "l";
            }
            xVar3.a(obj, "o");
        } else {
            xVar3.a(Integer.valueOf(z()), "b_w");
            xVar3.a(Integer.valueOf(y()), "b_h");
        }
        x xVar9 = this.b;
        com.fyber.inneractive.sdk.config.global.features.d dVar = (xVar9 == null || (rVar2 = xVar9.c) == null) ? null : (com.fyber.inneractive.sdk.config.global.features.d) rVar2.a(com.fyber.inneractive.sdk.config.global.features.d.class);
        if (dVar != null) {
            com.fyber.inneractive.sdk.model.vast.a aVar = dVar.e;
            if (aVar != null ? aVar.d : false) {
                z = true;
                if (z) {
                    if (!com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD.equals(gVar) && !com.fyber.inneractive.sdk.util.g.VIDEO_CTA.equals(gVar)) {
                        if (com.fyber.inneractive.sdk.util.g.VIDEO_CLICK.equals(gVar)) {
                            x xVar10 = this.b;
                            com.fyber.inneractive.sdk.config.global.features.u uVar2 = (xVar10 == null || (rVar = xVar10.c) == null) ? null : (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class);
                            if (uVar2 != null) {
                                Boolean c2 = uVar2.c("show_cta");
                                if (c2 != null ? c2.booleanValue() : true) {
                                    z2 = true;
                                }
                            }
                            z2 = false;
                        }
                    }
                    if (z3) {
                        xVar3.a(IAConfigManager.O.o, "cta_lng");
                    }
                    wVar.f.put(xVar3.f1342a);
                    wVar.a((String) null);
                }
                z3 = false;
                if (z3) {
                }
                wVar.f.put(xVar3.f1342a);
                wVar.a((String) null);
            }
        }
        z = false;
        if (z) {
        }
        z3 = false;
        if (z3) {
        }
        wVar.f.put(xVar3.f1342a);
        wVar.a((String) null);
    }

    public static void a(com.fyber.inneractive.sdk.response.e eVar) {
        String str = eVar.l;
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        IAlog.d("AD_CLICKED", new Object[0]);
        com.fyber.inneractive.sdk.network.x0.b(str);
    }

    @Override // com.fyber.inneractive.sdk.click.f
    public final void a(com.fyber.inneractive.sdk.click.b bVar, e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        b(bVar, e1Var, gVar);
    }

    public final void a(String str, com.fyber.inneractive.sdk.click.q qVar) {
        com.fyber.inneractive.sdk.response.e eVar;
        JSONArray jSONArray;
        InneractiveAdRequest inneractiveAdRequest;
        x xVar = this.b;
        if (xVar != null) {
            eVar = xVar.c();
            x xVar2 = this.b;
            inneractiveAdRequest = xVar2.f1249a;
            com.fyber.inneractive.sdk.config.global.r rVar = xVar2.c;
            jSONArray = rVar != null ? rVar.b() : null;
        } else {
            eVar = null;
            jSONArray = null;
            inneractiveAdRequest = null;
        }
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.EXTERNAL_BROWSER_OPENED;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar.c = uVar;
        wVar.f1340a = inneractiveAdRequest;
        wVar.d = jSONArray;
        wVar.a("url", str).a("fallback", (qVar == com.fyber.inneractive.sdk.click.q.OPENED_USING_CHROME_NAVIGATE || qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) ? "chrome" : "na").a((String) null);
    }

    public final void a(Context context, float f, float f2) {
        com.fyber.inneractive.sdk.response.e c;
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdClicked", IAlog.a(this));
            this.c.onAdClicked(this.f1175a);
        }
        x xVar = this.b;
        if (xVar == null || (c = xVar.c()) == null) {
            return;
        }
        IAConfigManager.O.x.a(c.p, "LAST_CLICKED", "1");
        com.fyber.inneractive.sdk.privacysandbox.b a2 = com.fyber.inneractive.sdk.privacysandbox.b.a(context);
        if (a2 == null) {
            a2 = null;
        }
        String str = c.n;
        Float valueOf = Float.valueOf(f);
        Float valueOf2 = Float.valueOf(f2);
        if (!valueOf.isNaN() && !valueOf2.isNaN() && f >= 0.0f && f2 >= 0.0f) {
            MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, f, f2, 0);
            if (TextUtils.isEmpty(str) || a2 == null) {
                return;
            }
            a2.a(str, obtain);
            return;
        }
        if (TextUtils.isEmpty(str) || a2 == null) {
            return;
        }
        a2.a(str, null);
    }

    public final void a(WebViewRendererProcessHasGoneError webViewRendererProcessHasGoneError) {
        String simpleName = webViewRendererProcessHasGoneError.getClass().getSimpleName();
        String message = webViewRendererProcessHasGoneError.getMessage();
        x xVar = this.b;
        com.fyber.inneractive.sdk.network.z.a(simpleName, message, xVar != null ? xVar.f1249a : null, xVar != null ? xVar.c() : null);
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdEnteredErrorState: %s", IAlog.a(this), webViewRendererProcessHasGoneError.getMessage());
            this.c.onAdEnteredErrorState(this.f1175a, webViewRendererProcessHasGoneError);
        }
    }

    public static void a(com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.c cVar) {
        com.fyber.inneractive.sdk.cache.session.e eVar = IAConfigManager.O.x.f1132a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
    }
}
