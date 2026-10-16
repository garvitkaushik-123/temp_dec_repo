package io.bidmachine.tracking;

import io.bidmachine.TrackEventType;
import io.bidmachine.protobuf.AdExtension;
import java.util.List;
import java.util.UUID;

/* loaded from: classes8.dex */
public abstract class TrackingObjectImpl implements TrackingObject {
    private final Object trackingKey;

    @Override // io.bidmachine.tracking.TrackingObject
    public AdExtension.EventConfiguration getEventConfiguration() {
        return null;
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public List<String> getTrackingUrls(TrackEventType eventType) {
        return null;
    }

    public TrackingObjectImpl() {
        this(UUID.randomUUID());
    }

    public TrackingObjectImpl(Object trackingKey) {
        this.trackingKey = trackingKey;
    }

    @Override // io.bidmachine.tracking.TrackingObject
    public Object getTrackingKey() {
        return this.trackingKey;
    }
}
