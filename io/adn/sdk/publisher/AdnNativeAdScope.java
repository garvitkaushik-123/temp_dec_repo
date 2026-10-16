package io.adn.sdk.publisher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnNativeAdScope.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/publisher/AdnNativeAdScope;", "", "renderingInfo", "Lio/adn/sdk/publisher/AdnNativeAdRenderer;", "interactionHandler", "Lio/adn/sdk/publisher/AdnNativeInteractionHandler;", "<init>", "(Lio/adn/sdk/publisher/AdnNativeAdRenderer;Lio/adn/sdk/publisher/AdnNativeInteractionHandler;)V", "getRenderingInfo", "()Lio/adn/sdk/publisher/AdnNativeAdRenderer;", "notifyAdElementClicked", "", "clickedElement", "Lio/adn/sdk/publisher/AdnClickElement;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnNativeAdScope {
    public static final int $stable = 8;
    private final AdnNativeInteractionHandler interactionHandler;
    private final AdnNativeAdRenderer renderingInfo;

    public AdnNativeAdScope(AdnNativeAdRenderer renderingInfo, AdnNativeInteractionHandler interactionHandler) {
        Intrinsics.checkNotNullParameter(renderingInfo, "renderingInfo");
        Intrinsics.checkNotNullParameter(interactionHandler, "interactionHandler");
        this.renderingInfo = renderingInfo;
        this.interactionHandler = interactionHandler;
    }

    public final AdnNativeAdRenderer getRenderingInfo() {
        return this.renderingInfo;
    }

    public final void notifyAdElementClicked(AdnClickElement clickedElement) {
        Intrinsics.checkNotNullParameter(clickedElement, "clickedElement");
        this.interactionHandler.notifyClick$adn_sdk_release(clickedElement);
    }
}
