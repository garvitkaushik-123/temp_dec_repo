package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;

/* loaded from: classes8.dex */
public interface SessionTracker extends EventTracker {
    void clearTrackingEvent(TrackingObject trackingObject, TrackEventType trackEventType);

    void clearTrackingEvents(TrackingObject trackingObject);

    void trackEventFinish(TrackingObject trackingObject, TrackEventType trackEventType, AdsType adsType, BMError bmError, EventData eventData);

    void trackEventStart(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo);
}
