package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.s0;
import com.fyber.inneractive.sdk.util.t;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class InneractiveNativeVideoContentController extends s0 {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f1160a;

    public interface Renderer {
        void pauseVideo();

        void playVideo();
    }

    @Override // com.fyber.inneractive.sdk.flow.h0
    public boolean canControl(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent().isVideoAd();
    }

    public void pauseVideo() {
        if (((Renderer) t.a(this.f1160a)) != null) {
            ((Renderer) this.f1160a.get()).pauseVideo();
        }
    }

    public void playVideo() {
        Renderer renderer = (Renderer) t.a(this.f1160a);
        if (renderer != null) {
            renderer.playVideo();
        }
    }

    public void setControlledRenderer(Renderer renderer) {
        this.f1160a = new WeakReference(renderer);
    }
}
