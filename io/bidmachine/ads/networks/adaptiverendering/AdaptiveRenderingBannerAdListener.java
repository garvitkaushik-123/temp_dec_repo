package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import com.ironsource.C3355vf;
import io.bidmachine.core.Utils;
import io.bidmachine.rendering.ad.view.AdView;
import io.bidmachine.rendering.ad.view.AdViewListener;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.utils.BMError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingBannerAdListener.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/bidmachine/ads/networks/adaptiverendering/AdaptiveRenderingBannerAdListener;", "Lio/bidmachine/rendering/ad/view/AdViewListener;", "callback", "Lio/bidmachine/unified/UnifiedBannerAdCallback;", "(Lio/bidmachine/unified/UnifiedBannerAdCallback;)V", "onAdAppeared", "", "adView", "Lio/bidmachine/rendering/ad/view/AdView;", C3355vf.f, "onAdDisappeared", "onAdExpired", "onAdFailToLoad", "error", "Lio/bidmachine/rendering/model/Error;", "onAdFailToShow", "onAdFinished", C3355vf.j, "onAdShown", "onBrokenCreativeEvent", "brokenCreativeEvent", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "onOpenPrivacySheet", "privacySheetParams", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingBannerAdListener implements AdViewListener {
    private final UnifiedBannerAdCallback callback;

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdAppeared(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdDisappeared(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFinished(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
    }

    public AdaptiveRenderingBannerAdListener(UnifiedBannerAdCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdLoaded(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.callback.onAdLoaded(adView);
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToLoad(AdView adView, Error error) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(error, "error");
        UnifiedBannerAdCallback unifiedBannerAdCallback = this.callback;
        BMError NoFill = BMError.NoFill;
        Intrinsics.checkNotNullExpressionValue(NoFill, "NoFill");
        unifiedBannerAdCallback.onAdLoadFailed(AdaptiveRenderingAdapterKt.toBMError(error, NoFill));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdShown(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToShow(AdView adView, Error error) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(error, "error");
        UnifiedBannerAdCallback unifiedBannerAdCallback = this.callback;
        BMError InternalUnknownError = BMError.InternalUnknownError;
        Intrinsics.checkNotNullExpressionValue(InternalUnknownError, "InternalUnknownError");
        unifiedBannerAdCallback.onAdShowFailed(AdaptiveRenderingAdapterKt.toBMError(error, InternalUnknownError));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdClicked(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.callback.onAdClicked();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdExpired(AdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        this.callback.onAdExpired();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onOpenPrivacySheet(AdView adView, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
        PrivacySheetDialog.Companion companion = PrivacySheetDialog.INSTANCE;
        Context findDialogContext = Utils.findDialogContext(adView.getContext(), adView);
        Intrinsics.checkNotNullExpressionValue(findDialogContext, "findDialogContext(adView.context, adView)");
        companion.show(findDialogContext, privacySheetParams);
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onBrokenCreativeEvent(AdView adView, BrokenCreativeEvent brokenCreativeEvent) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(brokenCreativeEvent, "brokenCreativeEvent");
        this.callback.onBrokenCreativeEvent(AdaptiveRenderingAdapterKt.toEventParams(brokenCreativeEvent));
    }
}
