package com.ironsource;

import android.app.Activity;
import com.ironsource.AbstractC3225o3;
import com.ironsource.AbstractC3242p3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.ironsource.n3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3208n3<Smash extends AbstractC3225o3<?>, Listener extends AdapterAdInteractionListener> extends AbstractC3242p3<Smash, Listener> implements I0 {

    /* renamed from: com.ironsource.n3$a */
    class a extends Pd {
        final /* synthetic */ Activity b;
        final /* synthetic */ Placement c;

        a(Activity activity, Placement placement) {
            this.b = activity;
            this.c = placement;
        }

        @Override // com.ironsource.Pd
        public void a() {
            AbstractC3208n3.this.b(this.b, this.c);
        }
    }

    protected AbstractC3208n3(U u, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(u, z9, ironSourceSegment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(Activity activity, Placement placement) {
        AbstractC3225o3 abstractC3225o3;
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose(b("state = " + this.p));
        synchronized (this.x) {
            this.i = placement;
            this.s.i.a(activity, n());
            AbstractC3242p3.f fVar = this.p;
            AbstractC3242p3.f fVar2 = AbstractC3242p3.f.SHOWING;
            abstractC3225o3 = null;
            if (fVar == fVar2) {
                ironSourceError = new IronSourceError(C3408z0.g(this.o.b()), "can't show ad while an ad is already showing");
            } else if (fVar != AbstractC3242p3.f.READY_TO_SHOW) {
                ironSourceError = new IronSourceError(509, "show called while no ads are available");
            } else if (placement == null) {
                ironSourceError = new IronSourceError(C3408z0.b(this.o.b()), "empty default placement");
            } else if (this.E.c(ContextProvider.getInstance().getApplicationContext(), placement, this.o.b())) {
                ironSourceError = new IronSourceError(C3408z0.f(this.o.b()), "placement " + placement.getPlacementName() + " is capped");
            } else {
                ironSourceError = null;
            }
            if (ironSourceError != null) {
                IronLog.API.error(b(ironSourceError.getErrorMessage()));
                a(ironSourceError, "");
            } else {
                List b = this.f3628a.b();
                qg qgVar = new qg(this.o);
                abstractC3225o3 = (AbstractC3225o3) qgVar.c(b);
                a((AbstractC3208n3<Smash, Listener>) abstractC3225o3, (List<AbstractC3208n3<Smash, Listener>>) qgVar.b(b));
                if (abstractC3225o3 != null) {
                    a(fVar2);
                    i(abstractC3225o3);
                } else {
                    a(ErrorBuilder.buildNoAdsToShowError(this.o.b().toString()), a(b));
                }
            }
        }
        if (abstractC3225o3 != null) {
            a(activity, (AbstractC3225o3<?>) abstractC3225o3, this.i);
        }
    }

    public void a(Activity activity, Placement placement) {
        if (e()) {
            a(new a(activity, placement));
        } else {
            b(activity, placement);
        }
    }

    @Override // com.ironsource.I0
    public void c(AbstractC3225o3<?> abstractC3225o3) {
        IronLog.INTERNAL.verbose(b(abstractC3225o3.k()));
        this.t.a();
    }

    @Override // com.ironsource.I0
    public void d(AbstractC3225o3<?> abstractC3225o3) {
        IronLog.INTERNAL.verbose(b(abstractC3225o3.k()));
        this.t.b();
    }

    @Override // com.ironsource.I0
    public String f() {
        StringBuilder sb = new StringBuilder();
        if (this.p == AbstractC3242p3.f.READY_TO_SHOW) {
            for (AbstractC3225o3 abstractC3225o3 : this.f3628a.b()) {
                if (abstractC3225o3.y()) {
                    sb.append(abstractC3225o3.c()).append(";");
                }
            }
        }
        return sb.toString();
    }

    @Override // com.ironsource.AbstractC3242p3
    public boolean u() {
        if (!x()) {
            return false;
        }
        if (this.j && !IronSourceUtils.isNetworkConnected(ContextProvider.getInstance().getApplicationContext())) {
            return false;
        }
        Iterator it = this.f3628a.b().iterator();
        while (it.hasNext()) {
            if (((AbstractC3225o3) it.next()).B()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.AbstractC3242p3
    protected boolean v() {
        return false;
    }

    AbstractC3208n3(H7 h7, G7 g7, U u, Z9 z9, IronSourceSegment ironSourceSegment) {
        super(h7, g7, u, z9, ironSourceSegment);
    }

    private void a(Smash smash, List<Smash> list) {
        for (Smash smash2 : list) {
            if (smash != null && smash2 == smash) {
                smash.b(true);
                return;
            } else {
                smash2.b(false);
                IronLog.INTERNAL.verbose(b(smash2.k() + " - not ready to show"));
            }
        }
    }

    private String a(List<Smash> list) {
        StringBuilder sb = new StringBuilder();
        for (Smash smash : list) {
            if (smash.e() != null) {
                sb.append(smash.c()).append(":").append(smash.e()).append(",");
            }
        }
        return sb.toString();
    }

    private void a(Activity activity, AbstractC3225o3<?> abstractC3225o3, Placement placement) {
        if (this.o.h().e()) {
            this.r.a();
        }
        abstractC3225o3.a(activity, placement);
    }

    private void a(IronSourceError ironSourceError, String str) {
        a(ironSourceError, (AbstractC3225o3<?>) null, str);
    }

    private void a(IronSourceError ironSourceError, AbstractC3225o3<?> abstractC3225o3, String str) {
        this.s.i.a(n(), ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), str);
        this.q.g();
        this.t.a(ironSourceError, abstractC3225o3 != null ? abstractC3225o3.f() : null);
        if (this.o.h().e()) {
            b(false);
        }
    }

    @Override // com.ironsource.I0
    public void a(IronSourceError ironSourceError, AbstractC3225o3<?> abstractC3225o3) {
        IronLog.INTERNAL.verbose(b(abstractC3225o3.k() + " - error = " + ironSourceError));
        this.b.put(abstractC3225o3.c(), h.a.ISAuctionPerformanceFailedToShow);
        a(AbstractC3242p3.f.READY_TO_LOAD);
        a(ironSourceError, abstractC3225o3, "");
    }

    @Override // com.ironsource.I0
    public void a(AbstractC3225o3<?> abstractC3225o3) {
        IronLog.INTERNAL.verbose(b(abstractC3225o3.k()));
        if (this.p == AbstractC3242p3.f.SHOWING) {
            a(AbstractC3242p3.f.READY_TO_LOAD);
        }
        this.q.f();
        this.t.a(abstractC3225o3.f());
    }

    @Override // com.ironsource.I0
    public void b(AbstractC3225o3<?> abstractC3225o3) {
        IronLog.INTERNAL.verbose(b(abstractC3225o3.k()));
        this.t.g(abstractC3225o3.f());
    }
}
