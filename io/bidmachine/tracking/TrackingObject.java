package io.bidmachine.tracking;

import io.bidmachine.AdsType;
import io.bidmachine.TrackEventType;
import io.bidmachine.protobuf.AdExtension;
import io.bidmachine.utils.BMError;
import java.util.List;

/* loaded from: classes8.dex */
public interface TrackingObject {
    void clear();

    void clearEvent(TrackEventType trackEventType);

    void eventFinish(TrackEventType trackEventType, AdsType adsType, EventData eventData, BMError bmError);

    void eventStart(TrackEventType trackEventType, TrackEventInfo trackEventInfo);

    AdExtension.EventConfiguration getEventConfiguration();

    Object getTrackingKey();

    List<String> getTrackingUrls(TrackEventType eventType);

    default void eventStart(TrackEventType trackEventType) {
        eventStart(trackEventType, null);
    }
}
