package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.utils.BMError;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes8.dex */
public class SessionTrackerImpl implements SessionTracker {
    private final EventTracker eventTracker;
    final Map<Object, Map<TrackEventType, TrackEventInfo>> trackEventInfoHolders = new ConcurrentHashMap();

    public SessionTrackerImpl(EventTracker eventTracker) {
        this.eventTracker = eventTracker;
    }

    @Override // io.bidmachine.tracking.SessionTracker
    public void trackEventStart(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo) {
        Object trackingKey = trackingObject.getTrackingKey();
        Map<TrackEventType, TrackEventInfo> map = this.trackEventInfoHolders.get(trackingKey);
        if (map == null) {
            map = new EnumMap<>(TrackEventType.class);
            this.trackEventInfoHolders.put(trackingKey, map);
        }
        if (map.containsKey(trackEventType)) {
            return;
        }
        if (trackEventInfo == null) {
            trackEventInfo = new TrackEventInfo();
        }
        map.put(trackEventType, trackEventInfo);
    }

    @Override // io.bidmachine.tracking.SessionTracker
    public void trackEventFinish(TrackingObject trackingObject, TrackEventType trackEventType, AdsType adsType, BMError bmError, EventData eventData) {
        TrackEventInfo trackEventInfo;
        Map<TrackEventType, TrackEventInfo> map = this.trackEventInfoHolders.get(trackingObject.getTrackingKey());
        if (map == null || !map.containsKey(trackEventType)) {
            trackEventInfo = null;
        } else {
            trackEventInfo = map.get(trackEventType);
            if (trackEventInfo != null) {
                trackEventInfo.setFinishTimeMs(System.currentTimeMillis());
            }
            map.remove(trackEventType);
            if (map.isEmpty()) {
                clearTrackingEvents(trackingObject);
            }
        }
        trackEvent(trackingObject, trackEventType, trackEventInfo, adsType, bmError, eventData);
    }

    @Override // io.bidmachine.tracking.EventTracker
    public void trackEvent(TrackingObject trackingObject, TrackEventType trackEventType, TrackEventInfo trackEventInfo, AdsType adsType, BMError bmError, EventData eventData) {
        this.eventTracker.trackEvent(trackingObject, trackEventType, trackEventInfo, adsType, bmError, eventData);
    }

    @Override // io.bidmachine.tracking.SessionTracker
    public void clearTrackingEvent(TrackingObject trackingObject, TrackEventType trackEventType) {
        Map<TrackEventType, TrackEventInfo> map = this.trackEventInfoHolders.get(trackingObject.getTrackingKey());
        if (map != null) {
            map.remove(trackEventType);
        }
    }

    @Override // io.bidmachine.tracking.SessionTracker
    public void clearTrackingEvents(TrackingObject trackingObject) {
        this.trackEventInfoHolders.remove(trackingObject.getTrackingKey());
    }
}
