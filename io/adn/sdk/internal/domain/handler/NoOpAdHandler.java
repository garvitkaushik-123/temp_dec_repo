package io.adn.sdk.internal.domain.handler;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3207n2;
import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.publisher.AdnAdError;
import io.adn.sdk.publisher.AdnAdRequest;
import io.adn.sdk.publisher.AdnFullscreenAd;
import io.adn.sdk.publisher.AdnFullscreenAdListener;
import io.adn.sdk.publisher.AdnNativeAd;
import io.adn.sdk.publisher.AdnNativeAdListener;
import io.adn.sdk.publisher.AdnNativeAdRenderer;
import io.adn.sdk.publisher.AdnNativeInteractionHandler;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoOpAdHandler.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lio/adn/sdk/internal/domain/handler/NoOpAdHandler;", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "Lio/adn/sdk/publisher/AdnNativeAd;", "<init>", "()V", "uuid", "", "getUuid", "()Ljava/lang/String;", "fullscreenListener", "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "nativeListener", "Lio/adn/sdk/publisher/AdnNativeAdListener;", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInAppBrowserLauncher", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "renderingInfo", "Lio/adn/sdk/publisher/AdnNativeAdRenderer;", "prepareForInteraction", "interactionHandler", "Lio/adn/sdk/publisher/AdnNativeInteractionHandler;", "load", AdActivity.REQUEST_KEY_EXTRA, "Lio/adn/sdk/publisher/AdnAdRequest;", "isReady", "", C3207n2.v, "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NoOpAdHandler implements AdnFullscreenAd, AdnNativeAd {
    public static final int $stable = 8;
    private AdnFullscreenAdListener fullscreenListener;
    private AdnNativeAdListener nativeListener;
    private final String uuid = ConversionsKt.randomUUID();

    @Override // io.adn.sdk.publisher.AdnAd
    public void destroy() {
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public boolean isReady() {
        return false;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAd
    public void prepareForInteraction(AdnNativeInteractionHandler interactionHandler) {
        Intrinsics.checkNotNullParameter(interactionHandler, "interactionHandler");
    }

    @Override // io.adn.sdk.publisher.AdnNativeAd
    public AdnNativeAdRenderer renderingInfo() {
        return null;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAd
    public void setInAppBrowserLauncher(AdnInAppBrowserLauncher inAppBrowserLauncher) {
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAd
    public void show() {
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public String getUuid() {
        return this.uuid;
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAd
    public void setListener(AdnFullscreenAdListener listener) {
        this.fullscreenListener = listener;
    }

    @Override // io.adn.sdk.publisher.AdnNativeAd
    public void setListener(AdnNativeAdListener listener) {
        this.nativeListener = listener;
    }

    @Override // io.adn.sdk.publisher.AdnAd
    public void load(AdnAdRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        AdnNativeAdListener adnNativeAdListener = this.nativeListener;
        if (adnNativeAdListener != null) {
            adnNativeAdListener.onAdLoadFailed(AdnAdError.SdkNotInitialized.INSTANCE);
        }
        AdnFullscreenAdListener adnFullscreenAdListener = this.fullscreenListener;
        if (adnFullscreenAdListener != null) {
            adnFullscreenAdListener.onAdLoadFailed(AdnAdError.SdkNotInitialized.INSTANCE);
        }
    }
}
