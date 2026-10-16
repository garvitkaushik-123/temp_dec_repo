package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class p extends l {
    public int J;
    public com.fyber.inneractive.sdk.player.ui.remote.f K;
    public final com.fyber.inneractive.sdk.player.ui.remote.d L;

    public p(Context context, a aVar, com.fyber.inneractive.sdk.player.ui.remote.d dVar, o oVar) {
        super(context, null, aVar, null, null);
        this.J = 0;
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = new com.fyber.inneractive.sdk.player.ui.remote.f(oVar);
        this.K = fVar;
        this.L = dVar;
        dVar.f1650a = fVar;
        attachViewToParent(dVar.b, getChildCount() - 1, new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, com.fyber.inneractive.sdk.player.ui.m
    public final boolean a() {
        return this.L.b.j;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void b(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.g = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showCountdownText(%s)", "FyberRemoteUiBridge.showCountdownText(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void c(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.h = z;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void d(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.i = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        String str = z ? "FyberRemoteUiBridge.showMuteButton()" : "FyberRemoteUiBridge.hideMuteButton()";
        dVar.d.a(str, str, dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s, com.fyber.inneractive.sdk.player.ui.m
    public final void destroy() {
        IAlog.a("%s: destroy() : destroying remote UI", "IAVideoViewRemote");
        removeView(this.L.b);
        this.L.a();
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.f1652a = null;
            this.K = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void e(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.c = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showPlayOverlay(%s)", "FyberRemoteUiBridge.showPlayOverlay(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.f = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showProgressBar(%s)", "FyberRemoteUiBridge.showProgressBar(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.b = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showSkipLayout(%s)", "FyberRemoteUiBridge.showSkipLayout(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public int getTickFractions() {
        return 15;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyView() {
        return new View[]{this.L.b};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[0];
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean i() {
        return this.L.n;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean l() {
        return this.L.m;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void m() {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void n() {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setAppInfoButtonRound(TextView textView) {
    }

    public void setIsSkipEnabled(boolean z) {
        this.L.n = z;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setListener(n nVar) {
        super.setListener(nVar);
        this.L.e = nVar;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setMuteButtonState(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        String str = z ? "FyberRemoteUiBridge.setMute()" : "FyberRemoteUiBridge.setUnmute()";
        com.fyber.inneractive.sdk.player.ui.remote.e eVar = dVar.d;
        eVar.c = z;
        com.fyber.inneractive.sdk.player.ui.remote.d dVar2 = eVar.f1651a;
        if (dVar2 != null) {
            dVar2.b.a(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setRemainingTime(String str) {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.setRemainingTime(\"%s\")", "FyberRemoteUiBridge.setRemainingTime(\"" + str + "\")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setSkipText(String str) {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.setSkipText(\"%s\")", "FyberRemoteUiBridge.setSkipText(\"" + str + "\")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        super.a(dVar, bVar);
        ViewGroup viewGroup = this.q;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return;
        }
        this.L.a();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.e = z;
            fVar.k = mVar;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f() {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.d.a("FyberRemoteUiBridge.enableSkip()", "FyberRemoteUiBridge.enableSkip()", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g() {
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.d.a("FyberRemoteUiBridge.hideOverlays()", "FyberRemoteUiBridge.hideOverlays()", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, String str) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.j = z;
            fVar.l = str;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z) {
        com.fyber.inneractive.sdk.player.ui.remote.f fVar = this.K;
        if (fVar != null) {
            fVar.d = z;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.showBufferingOverlay(%s)", "FyberRemoteUiBridge.showBufferingOverlay(" + z + ")", dVar.b.j);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.s
    public final void a(int i, int i2) {
        this.J = i;
        super.a(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void a(int i) {
        int i2 = this.J;
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = this.L;
        dVar.getClass();
        dVar.d.a("FyberRemoteUiBridge.updateProgressBar(%d, %.2f)", String.format(Locale.US, "FyberRemoteUiBridge.updateProgressBar(%d, %.2f)", Integer.valueOf(i2), Float.valueOf((i / i2) * 100.0f)), dVar.b.j);
    }
}
