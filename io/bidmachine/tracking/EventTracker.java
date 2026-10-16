package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;

/* loaded from: classes8.dex */
public interface EventTracker {
    void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bmError, EventData eventData);
}
