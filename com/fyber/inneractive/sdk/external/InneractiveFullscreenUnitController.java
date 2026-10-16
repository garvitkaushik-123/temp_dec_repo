package com.fyber.inneractive.sdk.external;

import android.app.Activity;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.factories.h;
import com.fyber.inneractive.sdk.factories.i;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.flow.q0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class InneractiveFullscreenUnitController extends q0 implements InneractiveFullscreenAdActivity.FullScreenRendererProvider, InneractiveFullscreenAdActivity.OnInneractiveFullscreenAdDestroyListener {
    public InneractiveFullScreenAdRewardedListener b;
    protected com.fyber.inneractive.sdk.interfaces.f mRenderer;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1158a = false;
    public final g c = new g(this);

    public static class AdExpiredError extends InneractiveUnitController.AdDisplayError {
        public AdExpiredError() {
            super("Ad Expired");
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.q0, com.fyber.inneractive.sdk.external.InneractiveUnitController
    public void destroy() {
        com.fyber.inneractive.sdk.interfaces.f fVar = this.mRenderer;
        if (fVar != null) {
            fVar.destroy();
            this.mRenderer = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.FullScreenRendererProvider
    public com.fyber.inneractive.sdk.interfaces.f getFullscreenRenderer() {
        return this.mRenderer;
    }

    public InneractiveFullScreenAdRewardedListener getRewardedListener() {
        return this.b;
    }

    public boolean isAvailable() {
        g0 g0Var = (g0) t.a(this.mAdSpot);
        return g0Var != null && g0Var.isReady();
    }

    @Override // com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity.OnInneractiveFullscreenAdDestroyListener
    public void onActivityDestroyed(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f1158a = false;
    }

    public void setRewardedListener(InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener) {
        this.b = inneractiveFullScreenAdRewardedListener;
    }

    public void show(Activity activity) {
        if (activity == null) {
            IAlog.f("show() called with a null activity", new Object[0]);
            return;
        }
        if (this.f1158a) {
            IAlog.f("InneractiveFullscreenUnitController->show(android.content.Context) called while an ad is already showing", new Object[0]);
            return;
        }
        InneractiveAdSpot adSpot = getAdSpot();
        if (adSpot == null) {
            IAlog.f("InneractiveFullscreenUnitController was not attached to an ad spot", new Object[0]);
            return;
        }
        x adContent = adSpot.getAdContent();
        com.fyber.inneractive.sdk.interfaces.f fVar = null;
        if (adContent != null) {
            u uVar = u.IA_PUBLISHER_REQUESTED_SHOW;
            InneractiveAdRequest inneractiveAdRequest = adContent.f1249a;
            com.fyber.inneractive.sdk.response.e c = adContent.c();
            JSONArray b = adContent.c.b();
            w wVar = new w(c);
            wVar.c = uVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            wVar.a((String) null);
        }
        if (!adSpot.isReady()) {
            InneractiveUnitController.EventsListener eventsListener = this.mEventsListener;
            if (eventsListener != null) {
                ((InneractiveFullscreenAdEventsListener) eventsListener).onAdEnteredErrorState(adSpot, new AdExpiredError());
                return;
            }
            return;
        }
        if (this.mRenderer == null) {
            i iVar = h.f1173a;
            InneractiveAdSpot adSpot2 = getAdSpot();
            Iterator it = iVar.f1174a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.fyber.inneractive.sdk.factories.g gVar = (com.fyber.inneractive.sdk.factories.g) it.next();
                if (gVar.a(adSpot2)) {
                    fVar = gVar.b(adSpot2);
                    break;
                }
            }
            this.mRenderer = fVar;
        }
        selectContentController();
        (adContent instanceof com.fyber.inneractive.sdk.dv.a ? new com.fyber.inneractive.sdk.display.b() : new com.fyber.inneractive.sdk.display.c()).a(activity, adSpot, adSpot.getLocalUniqueId());
        this.f1158a = true;
        com.fyber.inneractive.sdk.interfaces.f fVar2 = this.mRenderer;
        if (fVar2 != null) {
            fVar2.a(this.c);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.q0
    public boolean supports(InneractiveAdSpot inneractiveAdSpot) {
        r0 r0Var = (r0) inneractiveAdSpot.getAdContent().d;
        if (r0Var.e != null) {
            return false;
        }
        l0 l0Var = r0Var.c;
        if (l0Var != null && UnitDisplayType.INTERSTITIAL.equals(l0Var.b)) {
            return true;
        }
        t0 t0Var = r0Var.f;
        return t0Var != null && (UnitDisplayType.REWARDED.equals(t0Var.j) || UnitDisplayType.INTERSTITIAL.equals(t0Var.j) || UnitDisplayType.VERTICAL.equals(t0Var.j));
    }

    @Override // com.fyber.inneractive.sdk.flow.q0
    public boolean supportsRefresh() {
        return false;
    }
}
