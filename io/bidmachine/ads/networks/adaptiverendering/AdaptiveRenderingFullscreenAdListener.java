package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import com.ironsource.C3061e8;
import com.ironsource.C3355vf;
import io.bidmachine.core.Utils;
import io.bidmachine.rendering.ad.fullscreen.FullScreenAd;
import io.bidmachine.rendering.ad.fullscreen.FullScreenAdListener;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.utils.BMError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingFullscreenAdListener.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/bidmachine/ads/networks/adaptiverendering/AdaptiveRenderingFullscreenAdListener;", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAdListener;", "context", "Landroid/content/Context;", "callback", "Lio/bidmachine/unified/UnifiedFullscreenAdCallback;", "(Landroid/content/Context;Lio/bidmachine/unified/UnifiedFullscreenAdCallback;)V", "applicationContext", C3061e8.m, "", "onAdAppeared", "", "fullScreenAd", "Lio/bidmachine/rendering/ad/fullscreen/FullScreenAd;", C3355vf.f, "onAdDisappeared", "onAdExpired", "onAdFailToLoad", "error", "Lio/bidmachine/rendering/model/Error;", "onAdFailToShow", "onAdFinished", C3355vf.j, "onAdShown", "onBrokenCreativeEvent", "brokenCreativeEvent", "Lio/bidmachine/rendering/model/BrokenCreativeEvent;", "onOpenPrivacySheet", "privacySheetParams", "Lio/bidmachine/rendering/model/PrivacySheetParams;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingFullscreenAdListener implements FullScreenAdListener {
    private final Context applicationContext;
    private final UnifiedFullscreenAdCallback callback;
    private volatile boolean isShown;

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdAppeared(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdDisappeared(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
    }

    public AdaptiveRenderingFullscreenAdListener(Context context, UnifiedFullscreenAdCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.applicationContext = applicationContext;
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdLoaded(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        this.callback.onAdLoaded();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToLoad(FullScreenAd fullScreenAd, Error error) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        Intrinsics.checkNotNullParameter(error, "error");
        UnifiedFullscreenAdCallback unifiedFullscreenAdCallback = this.callback;
        BMError NoFill = BMError.NoFill;
        Intrinsics.checkNotNullExpressionValue(NoFill, "NoFill");
        unifiedFullscreenAdCallback.onAdLoadFailed(AdaptiveRenderingAdapterKt.toBMError(error, NoFill));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdShown(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        this.isShown = true;
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFailToShow(FullScreenAd fullScreenAd, Error error) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        Intrinsics.checkNotNullParameter(error, "error");
        UnifiedFullscreenAdCallback unifiedFullscreenAdCallback = this.callback;
        BMError InternalUnknownError = BMError.InternalUnknownError;
        Intrinsics.checkNotNullExpressionValue(InternalUnknownError, "InternalUnknownError");
        unifiedFullscreenAdCallback.onAdShowFailed(AdaptiveRenderingAdapterKt.toBMError(error, InternalUnknownError));
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdClicked(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        this.callback.onAdClicked();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdFinished(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        if (this.isShown) {
            this.callback.onAdFinished();
        }
        this.callback.onAdClosed();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onAdExpired(FullScreenAd fullScreenAd) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        this.callback.onAdExpired();
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onOpenPrivacySheet(FullScreenAd fullScreenAd, PrivacySheetParams privacySheetParams) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        Intrinsics.checkNotNullParameter(privacySheetParams, "privacySheetParams");
        PrivacySheetDialog.Companion companion = PrivacySheetDialog.INSTANCE;
        Context findDialogContext = Utils.findDialogContext(this.applicationContext);
        Intrinsics.checkNotNullExpressionValue(findDialogContext, "findDialogContext(applicationContext)");
        companion.show(findDialogContext, privacySheetParams);
    }

    @Override // io.bidmachine.rendering.ad.AdListener
    public void onBrokenCreativeEvent(FullScreenAd fullScreenAd, BrokenCreativeEvent brokenCreativeEvent) {
        Intrinsics.checkNotNullParameter(fullScreenAd, "fullScreenAd");
        Intrinsics.checkNotNullParameter(brokenCreativeEvent, "brokenCreativeEvent");
        this.callback.onBrokenCreativeEvent(AdaptiveRenderingAdapterKt.toEventParams(brokenCreativeEvent));
    }
}
