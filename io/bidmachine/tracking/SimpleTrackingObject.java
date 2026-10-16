package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;

/* loaded from: classes8.dex */
public class SimpleTrackingObject extends TrackingObjectImpl {
    @Override // io.bidmachine.tracking.TrackingObject
    public void clear() {
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void clearEvent(TrackEventType trackEventType) {
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void eventFinish(TrackEventType trackEventType, AdsType adsType, EventData eventData, BMError bmError) {
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public void eventStart(TrackEventType trackEventType, TrackEventInfo trackEventInfo) {
    }

    public SimpleTrackingObject() {
    }

    public SimpleTrackingObject(Object trackingKey) {
        super(trackingKey);
    }
}
