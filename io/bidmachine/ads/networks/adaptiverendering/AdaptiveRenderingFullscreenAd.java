package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.ironsource.C3207n2;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.RendererConfiguration;
import io.bidmachine.rendering.ad.fullscreen.FullScreenAd;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.BMError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingFullscreenAd.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/bidmachine/ads/networks/adaptiverendering/AdaptiveRenderingFullscreenAd;", "Lio/bidmachine/unified/UnifiedFullscreenAd;", "()V", "fullScreenAd", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", "load", "", "contextProvider", "Lio/bidmachine/ContextProvider;", "callback", "Lio/bidmachine/unified/UnifiedFullscreenAdCallback;", "requestParams", "Lio/bidmachine/unified/UnifiedFullscreenAdRequestParams;", "unifiedMediationParams", "Lio/bidmachine/unified/UnifiedMediationParams;", "networkAdUnit", "Lio/bidmachine/NetworkAdUnit;", "onDestroy", C3207n2.v, "rendererConfiguration", "Lio/bidmachine/RendererConfiguration;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingFullscreenAd extends UnifiedFullscreenAd {
    private FullScreenAd fullScreenAd;

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedFullscreenAdCallback callback, UnifiedFullscreenAdRequestParams requestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(requestParams, "requestParams");
        Intrinsics.checkNotNullParameter(unifiedMediationParams, "unifiedMediationParams");
        Intrinsics.checkNotNullParameter(networkAdUnit, "networkAdUnit");
        Context applicationContext = contextProvider.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "contextProvider.getApplicationContext()");
        AdaptiveRenderingParams adaptiveRenderingParams = new AdaptiveRenderingParams(unifiedMediationParams);
        if (adaptiveRenderingParams.isValid(callback)) {
            if (adaptiveRenderingParams.getAdParams() == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            FullScreenAd fullScreenAd = new FullScreenAd(applicationContext, adaptiveRenderingParams.getAdParams());
            fullScreenAd.setFullScreenAdListener(new AdaptiveRenderingFullscreenAdListener(applicationContext, callback));
            this.fullScreenAd = fullScreenAd;
            fullScreenAd.load();
        }
    }

    @Override // io.bidmachine.unified.UnifiedFullscreenAd
    public void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback callback, RendererConfiguration rendererConfiguration) throws Throwable {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FullScreenAd fullScreenAd = this.fullScreenAd;
        if (fullScreenAd == null) {
            callback.onAdShowFailed(BMError.internal("AdaptiveRendering fullscreen object is null"));
            return;
        }
        if (!fullScreenAd.isLoaded()) {
            callback.onAdShowFailed(BMError.internal("AdaptiveRendering fullscreen object not loaded"));
            return;
        }
        if (fullScreenAd.isFinished()) {
            callback.onAdShowFailed(BMError.internal("AdaptiveRendering fullscreen object already is finished"));
            return;
        }
        if (rendererConfiguration != null) {
            Context applicationContext = contextProvider.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "contextProvider.applicationContext");
            Drawable watermarkDrawable = rendererConfiguration.getWatermarkDrawable(applicationContext);
            if (watermarkDrawable != null) {
                fullScreenAd.setWatermark(watermarkDrawable);
            }
        }
        Context applicationContext2 = contextProvider.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "contextProvider.getApplicationContext()");
        fullScreenAd.show(applicationContext2);
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        FullScreenAd fullScreenAd = this.fullScreenAd;
        if (fullScreenAd != null) {
            fullScreenAd.destroy();
        }
        this.fullScreenAd = null;
    }
}
