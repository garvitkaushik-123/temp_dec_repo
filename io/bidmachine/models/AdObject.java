package io.bidmachine.models;

import io.bidmachine.AdProcessCallback;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.models.AdObjectParams;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.unified.UnifiedAdRequestParams;
import java.util.Map;

/* loaded from: classes7.dex */
public interface AdObject<AdObjectParamsType extends AdObjectParams, UnifiedAdRequestParamsType extends UnifiedAdRequestParams, UnifiedAdCallbackType extends UnifiedAdCallback> {
    UnifiedAdCallbackType createUnifiedCallback(AdProcessCallback processCallback);

    Map<String, Object> getCustomParams();

    AdObjectParamsType getParams();

    void hide();

    void load(ContextProvider contextProvider, UnifiedAdRequestParamsType adRequestParams, NetworkAdUnit networkAdUnit) throws Throwable;

    void onClicked();

    void onClosed(boolean finished);

    void onDestroy();

    void onExpired();

    void onFinished();

    void onImpression();

    void onShowFailed();

    void onShown();
}
