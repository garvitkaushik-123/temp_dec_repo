package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import android.graphics.drawable.Drawable;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.RendererConfiguration;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.rendering.ad.view.AdView;
import io.bidmachine.rendering.model.CacheType;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingBannerAd.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/bidmachine/ads/networks/adaptiverendering/AdaptiveRenderingBannerAd;", "Lio/bidmachine/unified/UnifiedBannerAd;", "()V", "adView", "Lio/bidmachine/rendering/ad/view/AdView;", "load", "", "contextProvider", "Lio/bidmachine/ContextProvider;", "callback", "Lio/bidmachine/unified/UnifiedBannerAdCallback;", "requestParams", "Lio/bidmachine/unified/UnifiedBannerAdRequestParams;", "unifiedMediationParams", "Lio/bidmachine/unified/UnifiedMediationParams;", "networkAdUnit", "Lio/bidmachine/NetworkAdUnit;", "onDestroy", "prepareToShow", "rendererConfiguration", "Lio/bidmachine/RendererConfiguration;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingBannerAd extends UnifiedBannerAd {
    private AdView adView;

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedBannerAdCallback callback, UnifiedBannerAdRequestParams requestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        VisibilitySource visibilitySource;
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
            if (adaptiveRenderingParams.getAdParams().getCacheType() == CacheType.FullLoad) {
                visibilitySource = VisibilitySource.BidMachine;
            } else {
                visibilitySource = VisibilitySource.All;
            }
            callback.setVisibilitySource(visibilitySource);
            AdView adView = new AdView(applicationContext, adaptiveRenderingParams.getAdParams());
            adView.setAdViewListener(new AdaptiveRenderingBannerAdListener(callback));
            this.adView = adView;
            adView.load();
        }
    }

    @Override // io.bidmachine.unified.UnifiedViewAd
    public void prepareToShow(RendererConfiguration rendererConfiguration) {
        super.prepareToShow(rendererConfiguration);
        AdView adView = this.adView;
        if (adView == null || rendererConfiguration == null) {
            return;
        }
        Context context = adView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "adView.context");
        Drawable watermarkDrawable = rendererConfiguration.getWatermarkDrawable(context);
        if (watermarkDrawable != null) {
            adView.setWatermark(watermarkDrawable);
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        AdView adView = this.adView;
        if (adView != null) {
            adView.destroy();
        }
        this.adView = null;
    }
}
