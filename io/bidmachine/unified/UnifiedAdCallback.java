package io.bidmachine.unified;

import io.bidmachine.core.VisibilitySource;
import io.bidmachine.utils.BMError;
import java.util.Map;

/* loaded from: classes8.dex */
public interface UnifiedAdCallback {
    void onAdClicked();

    void onAdExpired();

    void onAdLoadFailed(BMError error);

    void onAdShowFailed(BMError error);

    void onAdShown();

    void onBrokenCreativeEvent(Map<String, Object> params);

    void setVisibilitySource(VisibilitySource visibilitySource);
}
