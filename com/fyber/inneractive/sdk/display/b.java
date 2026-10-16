package com.fyber.inneractive.sdk.display;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.n0;
import com.fyber.inneractive.sdk.interfaces.e;
import com.fyber.inneractive.sdk.interfaces.f;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class b extends a implements e {

    /* renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f1134a;
    public f b;

    @Override // com.fyber.inneractive.sdk.display.a
    public final void a(Activity activity, InneractiveAdSpot inneractiveAdSpot, String str) {
        InneractiveAdSpot inneractiveAdSpot2;
        if (TextUtils.isEmpty(str) || (inneractiveAdSpot2 = InneractiveAdSpotManager.get().getSpot(str)) == null || inneractiveAdSpot2.getAdContent() == null) {
            inneractiveAdSpot2 = null;
        }
        this.f1134a = inneractiveAdSpot2;
        if (inneractiveAdSpot2 != null) {
            InneractiveUnitController selectedUnitController = inneractiveAdSpot2.getSelectedUnitController();
            if (selectedUnitController instanceof InneractiveFullscreenAdActivity.FullScreenRendererProvider) {
                f fullscreenRenderer = ((InneractiveFullscreenAdActivity.FullScreenRendererProvider) selectedUnitController).getFullscreenRenderer();
                this.b = fullscreenRenderer;
                if (fullscreenRenderer != null) {
                    ((n0) fullscreenRenderer).initialize(this.f1134a);
                    try {
                        this.b.a(this, activity);
                    } catch (Resources.NotFoundException e) {
                        IAlog.f("Interstitial Activity: %s", e.getMessage());
                    } catch (InneractiveUnitController.AdDisplayError e2) {
                        IAlog.f("Interstitial Activity: %s", e2.getMessage());
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void destroy() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void disableCloseButton() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void dismissAd(boolean z) {
        f fVar = this.b;
        if (fVar != null) {
            fVar.destroy();
            this.b = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final View getCloseButton() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final ViewGroup getLayout() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final boolean isCloseButtonDisplay() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void secondEndCardWasDisplayed() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void setActivityOrientation(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void showCloseButton(boolean z, int i, int i2) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void showCloseCountdown() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final void updateCloseCountdown(int i) {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.e
    public final boolean wasDismissedByUser() {
        return false;
    }
}
