package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;
import java.util.UUID;

/* loaded from: classes8.dex */
public class SessionTrackingObject extends TrackingObjectImpl {
    private final SessionTracker sessionTracker;

    public SessionTrackingObject(SessionTracker sessionTracker) {
        this(UUID.randomUUID(), sessionTracker);
    }

    public SessionTrackingObject(Object trackingKey, SessionTracker sessionTracker) {
        super(trackingKey);
        this.sessionTracker = sessionTracker;
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void eventStart(TrackEventType trackEventType, TrackEventInfo trackEventInfo) {
        this.sessionTracker.trackEventStart(this, trackEventType, trackEventInfo);
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void eventFinish(TrackEventType trackEventType, AdsType adsType, EventData eventData, BMError bmError) {
        this.sessionTracker.trackEventFinish(this, trackEventType, adsType, bmError, eventData);
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void clearEvent(TrackEventType trackEventType) {
        this.sessionTracker.clearTrackingEvent(this, trackEventType);
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void clear() {
        this.sessionTracker.clearTrackingEvents(this);
    }
}
