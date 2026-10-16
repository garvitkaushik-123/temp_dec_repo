package io.bidmachine.internal.utils.visibility;

import android.view.View;
import io.bidmachine.core.VisibilityParams;

/* loaded from: classes7.dex */
public class VisibilityTrackerHolder {
    private final Object lock = new Object();
    VisibilityTracker visibilityTracker;

    public void startTracking(View view, VisibilityParams visibilityParams, VisibilityTrackerListener visibilityTrackerListener) {
        synchronized (this.lock) {
            stopTracking();
            VisibilityTracker createVisibilityTracker = createVisibilityTracker(view, visibilityParams, visibilityTrackerListener);
            this.visibilityTracker = createVisibilityTracker;
            createVisibilityTracker.start();
        }
    }

    public void stopTracking() {
        synchronized (this.lock) {
            VisibilityTracker visibilityTracker = this.visibilityTracker;
            if (visibilityTracker != null) {
                visibilityTracker.stop();
                this.visibilityTracker = null;
            }
        }
    }

    VisibilityTracker createVisibilityTracker(View view, VisibilityParams visibilityParams, VisibilityTrackerListener visibilityTrackerListener) {
        return new VisibilityTrackerImpl(view, visibilityParams, visibilityTrackerListener);
    }
}
