package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class q0 implements InneractiveUnitController {
    protected WeakReference<g0> mAdSpot;
    protected Set<InneractiveContentController> mContentControllers = new HashSet();
    protected InneractiveUnitController.EventsListener mEventsListener;
    protected InneractiveContentController mSelectedContentController;

    @Override // com.fyber.inneractive.sdk.external.InneractiveUnitController
    public void addContentController(InneractiveContentController inneractiveContentController) {
        this.mContentControllers.add(inneractiveContentController);
    }

    public boolean canRefreshAd() {
        return supportsRefresh();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveUnitController
    public void destroy() {
        Iterator<InneractiveContentController> it = this.mContentControllers.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mContentControllers.clear();
        this.mSelectedContentController = null;
        this.mAdSpot = null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveUnitController
    public InneractiveAdSpot getAdSpot() {
        return (g0) com.fyber.inneractive.sdk.util.t.a(this.mAdSpot);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveUnitController
    public InneractiveUnitController.EventsListener getEventsListener() {
        return this.mEventsListener;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveUnitController
    public InneractiveContentController getSelectedContentController() {
        return this.mSelectedContentController;
    }

    public String logPrefix() {
        return IAlog.a(this);
    }

    public void selectContentController() {
        InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) com.fyber.inneractive.sdk.util.t.a(this.mAdSpot);
        if (inneractiveAdSpot == null) {
            IAlog.f("selectContentController called, but ad spot is null", new Object[0]);
            return;
        }
        for (InneractiveContentController inneractiveContentController : this.mContentControllers) {
            h0 h0Var = (h0) inneractiveContentController;
            if (h0Var.canControl(inneractiveAdSpot)) {
                this.mSelectedContentController = inneractiveContentController;
                h0Var.setAdSpot(inneractiveAdSpot);
            }
        }
    }

    public void setAdSpot(g0 g0Var) {
        this.mAdSpot = new WeakReference<>(g0Var);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveUnitController
    public void setEventsListener(InneractiveUnitController.EventsListener eventsListener) {
        this.mEventsListener = eventsListener;
    }

    public abstract boolean supports(InneractiveAdSpot inneractiveAdSpot);

    public abstract boolean supportsRefresh();
}
