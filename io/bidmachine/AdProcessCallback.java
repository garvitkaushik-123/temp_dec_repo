package io.bidmachine;

import io.bidmachine.core.VisibilitySource;
import io.bidmachine.utils.BMError;
import java.util.Map;

/* loaded from: classes7.dex */
public interface AdProcessCallback {
    void onBrokenCreativeEvent(Map<String, Object> params);

    void processClicked();

    void processClosed();

    void processDestroy();

    void processExpired();

    void processFillAd();

    void processFinished();

    void processLoadFail(BMError error);

    void processLoadSuccess();

    void processShowFail(BMError error);

    void processShown();

    void processStartVisibilityTracker();

    void processVisibilityTrackerImpression();

    boolean processVisibilityTrackerShown();

    void setVisibilitySource(VisibilitySource visibilitySource);
}
