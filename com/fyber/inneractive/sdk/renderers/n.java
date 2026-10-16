package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.b0;
import com.fyber.inneractive.sdk.player.controller.a0;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;

/* loaded from: classes4.dex */
public final class n implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1721a;

    public n(o oVar) {
        this.f1721a = oVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void c() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void e() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void f() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void h() {
        this.f1721a.a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void i() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void j() {
        o oVar = this.f1721a;
        r0 r0Var = (r0) oVar.b;
        if (r0Var.j) {
            return;
        }
        r0Var.j = true;
        oVar.C();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final com.fyber.inneractive.sdk.ignite.m o() {
        return com.fyber.inneractive.sdk.ignite.m.NONE;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onCompleted() {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        o oVar = this.f1721a;
        VideoContentListener videoContentListener = oVar.n;
        if (videoContentListener == null || (mVar = oVar.l) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onCompleted();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onPlayerError() {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        o oVar = this.f1721a;
        VideoContentListener videoContentListener = oVar.n;
        if (videoContentListener == null || (mVar = oVar.l) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onPlayerError();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onProgress(int i, int i2) {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        o oVar = this.f1721a;
        VideoContentListener videoContentListener = oVar.n;
        if (videoContentListener == null || (mVar = oVar.l) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onProgress(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(String str, String str2) {
        o oVar = this.f1721a;
        oVar.getClass();
        IAlog.a("%s ad view video ad renderer callback: onSuspiciousNoUserWebActionDetected", IAlog.a(oVar));
        ViewGroup viewGroup = this.f1721a.p;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return;
        }
        o oVar2 = this.f1721a;
        if (!oVar2.u) {
            b0.a(oVar2.p.getContext(), str, str2, this.f1721a.b);
            o oVar3 = this.f1721a;
            oVar3.u = true;
            oVar3.getClass();
            IAlog.a("%s reporting auto redirect", IAlog.a(oVar3));
            return;
        }
        oVar2.getClass();
        IAlog.a("%s redirect already reported for this ad", IAlog.a(oVar2));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(View view, String str) {
        if (view != null) {
            Context c = this.f1721a.c(view);
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(c, str);
            this.f1721a.a(c, Float.NaN, Float.NaN);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final com.fyber.inneractive.sdk.util.b0 a(e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        Context context;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        o oVar = this.f1721a;
        if (oVar.l.getContext() == null) {
            context = com.fyber.inneractive.sdk.util.o.f1770a;
        } else {
            context = this.f1721a.l.getContext();
        }
        x xVar = this.f1721a.b;
        return oVar.a(context, (xVar == null || (eVar = ((r0) xVar).b) == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.b, e1Var, gVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final com.fyber.inneractive.sdk.util.b0 a(String str, e1 e1Var, boolean z) {
        v vVar;
        x xVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        if (TextUtils.isEmpty(str) && (xVar = this.f1721a.b) != null) {
            com.fyber.inneractive.sdk.response.e eVar = ((r0) xVar).b;
            str = (eVar == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.b;
        }
        o oVar = this.f1721a;
        z zVar = oVar.m;
        if (zVar == null && (vVar = oVar.q) != null) {
            zVar = vVar.f1725a;
        }
        com.fyber.inneractive.sdk.flow.endcard.k i = zVar != null ? zVar.i() : null;
        com.fyber.inneractive.sdk.flow.endcard.b a2 = i != null ? i.b.a() : null;
        if (a2 instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
            String str2 = ((com.fyber.inneractive.sdk.flow.endcard.c) a2).g.g;
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        o oVar2 = this.f1721a;
        return oVar2.a(oVar2.c(oVar2.p), str, e1Var, z ? com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD : com.fyber.inneractive.sdk.util.g.VAST_ENDCARD);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(View view) {
        o oVar = this.f1721a;
        if (oVar.c != null) {
            oVar.a(oVar.c(view), Float.NaN, Float.NaN);
        }
    }
}
