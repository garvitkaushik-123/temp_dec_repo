package io.bidmachine.unified;

import io.bidmachine.ContextProvider;
import io.bidmachine.RendererConfiguration;

/* loaded from: classes8.dex */
public abstract class UnifiedFullscreenAd extends UnifiedAd<UnifiedFullscreenAdCallback, UnifiedFullscreenAdRequestParams> {
    public void onClosed(boolean finished) {
    }

    public void onFinished() {
    }

    public abstract void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback callback, RendererConfiguration rendererConfiguration) throws Throwable;
}
