package com.fyber.inneractive.sdk.dv.banner;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.interfaces.d;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import com.google.android.gms.ads.AdView;

/* loaded from: classes4.dex */
public final class c extends a0 implements d {
    public ViewGroup k;

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(int i) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean b(View view) {
        ViewGroup viewGroup = this.k;
        return viewGroup != null && viewGroup.equals(view);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int d() {
        x xVar = this.b;
        if (xVar == null) {
            return 0;
        }
        b bVar = (b) xVar;
        if (bVar.i == null || ((AdView) bVar.i).getAdSize() == null) {
            return 0;
        }
        return o.b(((AdView) ((b) this.b).i).getAdSize().getWidth());
    }

    @Override // com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        x xVar = this.b;
        if (xVar != null) {
            b bVar = (b) xVar;
            if (bVar.i != null) {
                ((AdView) bVar.i).destroy();
            }
            b bVar2 = (b) this.b;
            bVar2.g = null;
            bVar2.i = null;
        }
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.k = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void l() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int n() {
        x xVar = this.b;
        if (xVar == null) {
            return 0;
        }
        b bVar = (b) xVar;
        if (bVar.i == null || ((AdView) bVar.i).getAdSize() == null) {
            return 0;
        }
        return o.b(((AdView) ((b) this.b).i).getAdSize().getHeight());
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void p() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void q() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void s() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.k = null;
        }
    }

    public final void u() {
        i iVar;
        C();
        x xVar = this.b;
        if (xVar == null || (iVar = (i) ((b) xVar).b) == null) {
            return;
        }
        b(iVar);
        s0 s0Var = ((b) this.b).d;
        if (s0Var != null) {
            r0 r0Var = (r0) s0Var;
            if (r0Var.c != null) {
                a0.a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, r0Var.c.b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final View x() {
        return this.k;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(ViewGroup viewGroup) {
        x xVar;
        if (this.f1175a == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        if (viewGroup == null || (xVar = this.b) == null) {
            return;
        }
        b bVar = (b) xVar;
        if (bVar.i != null) {
            bVar.h = this;
            if (bVar.j) {
                u();
                bVar.j = false;
            }
            this.k = viewGroup;
            viewGroup.addView((View) ((b) this.b).i);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean a(x xVar) {
        return xVar instanceof com.fyber.inneractive.sdk.dv.a;
    }
}
