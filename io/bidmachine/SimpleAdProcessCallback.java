package io.bidmachine;

import io.bidmachine.core.VisibilitySource;
import io.bidmachine.utils.BMError;
import java.util.Map;

/* loaded from: classes7.dex */
class SimpleAdProcessCallback implements AdProcessCallback {
    @Override // io.bidmachine.AdProcessCallback
    public void onBrokenCreativeEvent(Map<String, Object> params) {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processClicked() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processClosed() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processDestroy() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processExpired() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processFillAd() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processFinished() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processLoadFail(BMError error) {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processLoadSuccess() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processShowFail(BMError error) {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processShown() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processStartVisibilityTracker() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public void processVisibilityTrackerImpression() {
    }

    @Override // io.bidmachine.AdProcessCallback
    public boolean processVisibilityTrackerShown() {
        return false;
    }

    @Override // io.bidmachine.AdProcessCallback
    public void setVisibilitySource(VisibilitySource visibilitySource) {
    }

    SimpleAdProcessCallback() {
    }
}
