package com.fyber.inneractive.sdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.mraid.e0;
import com.fyber.inneractive.sdk.mraid.f0;
import com.fyber.inneractive.sdk.mraid.k;
import com.fyber.inneractive.sdk.mraid.l;
import com.fyber.inneractive.sdk.mraid.n;
import com.fyber.inneractive.sdk.mraid.o;
import com.fyber.inneractive.sdk.mraid.p;
import com.fyber.inneractive.sdk.mraid.q;
import com.fyber.inneractive.sdk.mraid.s;
import com.fyber.inneractive.sdk.mraid.t;
import com.fyber.inneractive.sdk.mraid.u;
import com.fyber.inneractive.sdk.mraid.v;
import com.fyber.inneractive.sdk.mraid.w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import com.fyber.inneractive.sdk.web.b0;
import com.fyber.inneractive.sdk.web.c0;
import com.fyber.inneractive.sdk.web.d0;
import com.fyber.inneractive.sdk.web.g0;
import com.fyber.inneractive.sdk.web.i0;
import com.fyber.inneractive.sdk.web.j1;
import com.fyber.inneractive.sdk.web.m;
import com.fyber.inneractive.sdk.web.z;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class IAmraidWebViewController extends i0 {
    public final f p0;

    public static class MraidVideoFailedToDisplayError extends InneractiveUnitController.AdDisplayError {
        public MraidVideoFailedToDisplayError() {
            super("an MRAID video has not started playing in a timely fashion");
        }
    }

    public IAmraidWebViewController(boolean z, c0 c0Var, z zVar, d0 d0Var, boolean z2, com.fyber.inneractive.sdk.measurement.e eVar, r rVar) {
        super(z, c0Var, zVar, d0Var, eVar, rVar);
        this.p0 = new f(this);
        this.F = z2;
        this.b.setId(R.id.ia_inneractive_webview_mraid);
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final boolean a(String str, e1 e1Var) {
        com.fyber.inneractive.sdk.mraid.f gVar;
        m mVar;
        Uri parse = Uri.parse(str);
        String uri = parse.toString();
        parse.getScheme();
        if (uri.startsWith("iaadfinishedloading")) {
            if (uri.endsWith("success")) {
                IAlog.e("received iaadfinishedloading success", new Object[0]);
                if (!this.f1804a && this.f != null && (mVar = this.b) != null) {
                    mVar.a();
                    this.f1804a = true;
                    q();
                }
            }
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        m mVar2 = this.b;
        if (mVar2 != null && mVar2.isShown() && this.N != f0.HIDDEN) {
            if (!"mraid".equals(scheme)) {
                return false;
            }
            URI create = URI.create(str);
            String host = create.getHost();
            try {
                LinkedHashMap a2 = i0.a(create);
                switch (com.fyber.inneractive.sdk.mraid.j.f1307a[k.a(host).ordinal()]) {
                    case 1:
                        gVar = new com.fyber.inneractive.sdk.mraid.g(a2, this, e1Var);
                        break;
                    case 2:
                        gVar = new com.fyber.inneractive.sdk.mraid.i(a2, this, e1Var);
                        break;
                    case 3:
                        gVar = new w(a2, this, e1Var);
                        break;
                    case 4:
                        gVar = new q(a2, this, e1Var);
                        break;
                    case 5:
                        gVar = new s(a2, this, e1Var);
                        break;
                    case 6:
                        gVar = new o(a2, this, e1Var);
                        break;
                    case 7:
                        gVar = new u(a2, this, e1Var);
                        break;
                    case 8:
                        gVar = new t(a2, this, e1Var);
                        break;
                    case 9:
                        gVar = new com.fyber.inneractive.sdk.mraid.r(a2, this, e1Var);
                        break;
                    case 10:
                        gVar = new v(a2, this, e1Var);
                        break;
                    case 11:
                        gVar = new l(a2, this, e1Var);
                        break;
                    case 12:
                        gVar = new com.fyber.inneractive.sdk.mraid.m(a2, this, e1Var);
                        break;
                    case 13:
                        gVar = new n(a2, this, e1Var);
                        break;
                    case 14:
                        gVar = new p(a2, this, e1Var);
                        break;
                    case 15:
                        gVar = new com.fyber.inneractive.sdk.mraid.h(a2, this, e1Var);
                        break;
                    default:
                        gVar = null;
                        break;
                }
                if (gVar == null || ((gVar instanceof com.fyber.inneractive.sdk.mraid.i) && this.Q == c0.INTERSTITIAL)) {
                    m mVar3 = this.b;
                    if (mVar3 != null) {
                        mVar3.a("window.mraidbridge.nativeCallComplete('" + host + "');");
                    }
                } else {
                    gVar.f1305a = host;
                    IAlog.e("Processing MRaid command: %s", host);
                    if (gVar instanceof com.fyber.inneractive.sdk.mraid.e) {
                        a(new com.fyber.inneractive.sdk.web.f0(this, (com.fyber.inneractive.sdk.mraid.e) gVar));
                    } else {
                        if (gVar.b()) {
                            i();
                        }
                        gVar.a();
                    }
                    m mVar4 = this.b;
                    if (mVar4 != null) {
                        mVar4.a("window.mraidbridge.nativeCallComplete('" + host + "');");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final void e() {
        b(false);
        Handler handler = com.fyber.inneractive.sdk.util.r.b;
        handler.removeCallbacks(this.p0);
        handler.removeCallbacks(this.J);
    }

    @Override // com.fyber.inneractive.sdk.web.i
    public final com.fyber.inneractive.sdk.measurement.tracker.e f() {
        return this.I;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(4:5|6|7|(8:9|10|11|12|13|(1:20)|17|18))|25|10|11|12|13|(1:15)|20|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        r0 = "";
     */
    @Override // com.fyber.inneractive.sdk.web.i0, com.fyber.inneractive.sdk.web.i1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k() {
        boolean z;
        int i;
        super.k();
        m mVar = this.b;
        if (mVar != null && mVar.getContext() != null) {
            try {
                i = com.fyber.inneractive.sdk.util.o.f1770a.getPackageManager().queryIntentActivities(new Intent(this.b.getContext(), (Class<?>) InneractiveRichMediaVideoPlayerActivityCore.class), 0).size();
            } catch (Throwable unused) {
                i = 0;
            }
            if (i > 0) {
                z = true;
                e0 e0Var = new e0();
                e0Var.b = com.fyber.inneractive.sdk.util.k.n();
                e0Var.f1304a = com.fyber.inneractive.sdk.util.k.n();
                e0Var.c = true;
                e0Var.e = z;
                String str = Environment.getExternalStorageState();
                e0Var.d = !"mounted".equals(str) && com.fyber.inneractive.sdk.util.o.f1770a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
                a(e0Var);
            }
        }
        z = false;
        e0 e0Var2 = new e0();
        e0Var2.b = com.fyber.inneractive.sdk.util.k.n();
        e0Var2.f1304a = com.fyber.inneractive.sdk.util.k.n();
        e0Var2.c = true;
        e0Var2.e = z;
        String str2 = Environment.getExternalStorageState();
        e0Var2.d = !"mounted".equals(str2) && com.fyber.inneractive.sdk.util.o.f1770a.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        a(e0Var2);
    }

    @Override // com.fyber.inneractive.sdk.web.i1
    public final void n() {
        m mVar;
        if (this.C && this.D && this.A && (mVar = this.b) != null) {
            mVar.a("FyberMraidVideoController.play()");
            f fVar = this.p0;
            if (fVar != null) {
                com.fyber.inneractive.sdk.util.r.b.postDelayed(fVar, 5000L);
            }
            if (this.E) {
                this.b.a("FyberMraidVideoController.mute(true)");
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.web.i0, com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.j
    public final boolean a(WebView webView, String str) {
        r rVar;
        IAlog.a("IAmraidWebViewController: handleUrl = %s", str);
        if (this.b == null) {
            IAlog.a("handleUrl: web view already destroyed. Cannot handle url", new Object[0]);
            return false;
        }
        String lowerCase = str != null ? str.toLowerCase(Locale.US) : null;
        if (lowerCase != null) {
            Locale locale = Locale.US;
            if (lowerCase.startsWith("FyMraidVideo".toLowerCase(locale))) {
                if (lowerCase.endsWith("fyMraidVideoAd".toLowerCase(locale))) {
                    IAlog.e("Dispatching MRAID Video detection event", new Object[0]);
                    com.fyber.inneractive.sdk.response.e eVar = this.t;
                    if (eVar == null) {
                        x xVar = this.s;
                        eVar = xVar == null ? null : xVar.c();
                    }
                    com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.MRAID_VIDEO_DETECTED;
                    InneractiveAdRequest inneractiveAdRequest = this.r;
                    x xVar2 = this.s;
                    JSONArray b = (xVar2 == null || (rVar = xVar2.c) == null) ? null : rVar.b();
                    com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar);
                    wVar.c = uVar;
                    wVar.f1340a = inneractiveAdRequest;
                    wVar.d = b;
                    wVar.a((String) null);
                    this.D = true;
                    n();
                } else if (lowerCase.endsWith("fyMraidVideoAdPlaybackFailure".toLowerCase(locale))) {
                    IAlog.b("MRAID Video has not started in a timely fashion, showing close button", new Object[0]);
                    j1 j1Var = this.g;
                    if (j1Var != null) {
                        this.X = false;
                        if (j1Var != null) {
                            ((b0) j1Var).b(false);
                        }
                        com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.MRAID_VIDEO_HAS_NOT_STARTED_PLAYING_IN_A_TIMELY_FASHION;
                        InneractiveAdRequest inneractiveAdRequest2 = this.r;
                        x xVar3 = this.s;
                        com.fyber.inneractive.sdk.response.e c = xVar3 == null ? null : xVar3.c();
                        x xVar4 = this.s;
                        JSONArray b2 = xVar4 == null ? null : xVar4.c.b();
                        com.fyber.inneractive.sdk.network.w wVar2 = new com.fyber.inneractive.sdk.network.w(c);
                        wVar2.b = tVar;
                        wVar2.f1340a = inneractiveAdRequest2;
                        wVar2.d = b2;
                        wVar2.a("video_timeout_in_msecs", String.valueOf(5000)).a((String) null);
                    }
                    j1 j1Var2 = this.g;
                    if (j1Var2 != null) {
                        ((b0) j1Var2).a(new MraidVideoFailedToDisplayError());
                    }
                } else if (str.toLowerCase(locale).endsWith("fyMraidVideoAdCompleted".toLowerCase(locale))) {
                    j1 j1Var3 = this.g;
                    if (j1Var3 instanceof g0) {
                        ((com.fyber.inneractive.sdk.renderers.r) ((g0) j1Var3)).f1723a.F();
                    }
                }
                return true;
            }
        }
        return super.a(webView, str);
    }

    @Override // com.fyber.inneractive.sdk.web.i0, com.fyber.inneractive.sdk.web.i, com.fyber.inneractive.sdk.web.l
    public final void a(boolean z) {
        m mVar;
        super.a(z);
        if (this.D && this.C && this.A && (mVar = this.b) != null) {
            mVar.a("FyberMraidVideoController." + (z ? "play" : CampaignEx.JSON_NATIVE_VIDEO_PAUSE) + "();");
        }
        if (this.b == null || !z) {
            return;
        }
        Handler handler = com.fyber.inneractive.sdk.util.r.b;
        handler.postDelayed(new g(this), 1L);
        handler.postDelayed(new g(this), 100L);
        handler.postDelayed(new g(this), 250L);
        handler.postDelayed(new g(this), 1000L);
    }
}
