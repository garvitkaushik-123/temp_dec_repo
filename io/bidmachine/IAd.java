package io.bidmachine;

import io.bidmachine.AdRequest;
import io.bidmachine.IAd;
import io.bidmachine.models.AuctionResult;

/* loaded from: classes7.dex */
public interface IAd<SelfType extends IAd, AdRequestType extends AdRequest> {
    boolean canShow();

    void destroy();

    AuctionResult getAuctionResult();

    boolean isDestroyed();

    boolean isExpired();

    boolean isLoaded();

    boolean isLoading();

    SelfType load(AdRequestType request);

    SelfType setRendererConfiguration(RendererConfiguration rendererConfiguration);
}
