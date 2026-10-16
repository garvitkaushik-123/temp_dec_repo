package com.fyber.inneractive.sdk.renderers;

import android.view.View;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.n0;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.player.controller.f0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.e0;
import com.fyber.inneractive.sdk.util.e1;

/* loaded from: classes4.dex */
public final class p extends n0 implements f0 {
    public boolean w = false;

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean G() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final int I() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final int J() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final long K() {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final boolean L() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final long a(long j) {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.flow.n0
    public final /* bridge */ /* synthetic */ boolean b(x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void c() {
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        if (!this.w) {
            k();
        }
        this.b = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void e() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void h() {
        a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void i() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void j() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void k() {
        this.w = true;
        x xVar = this.b;
        if (xVar != null) {
        }
        IAlog.a("%sunit controller is null!", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void m() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onCompleted() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onPlayerError() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void onProgress(int i, int i2) {
    }

    @Override // com.fyber.inneractive.sdk.flow.n0, com.fyber.inneractive.sdk.interfaces.f
    public final void r() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean t() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void f() {
        IAlog.a("%snShownCloseButton", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final b0 a(String str, e1 e1Var, boolean z) {
        return new b0(e0.FAILED, new Exception("No Companion clicked"));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final b0 a(e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        s0 s0Var;
        l0 l0Var;
        x xVar = this.b;
        if (xVar != null && (s0Var = ((r0) xVar).d) != null && (l0Var = ((com.fyber.inneractive.sdk.config.r0) s0Var).c) != null) {
            UnitDisplayType unitDisplayType = l0Var.b;
            x0 x0Var = IAConfigManager.O.x;
            com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
            com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f1132a;
            if (eVar != null) {
                com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
            }
        }
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(View view, String str) {
        if (view == null || view.getContext() == null) {
            return;
        }
        InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
        a(c(view), Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.f0
    public final void a(View view) {
        a(c(view), Float.NaN, Float.NaN);
    }
}
