package io.bidmachine.tracking;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class TrackEventInfo {
    private Map<String, Object> eventParameters;
    private long finishTimeMs;
    private final long startTimeMs;

    public TrackEventInfo() {
        long currentTimeMillis = System.currentTimeMillis();
        this.startTimeMs = currentTimeMillis;
        this.finishTimeMs = currentTimeMillis;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public long getFinishTimeMs() {
        return this.finishTimeMs;
    }

    public void setFinishTimeMs(long finishTimeMs) {
        this.finishTimeMs = Math.max(finishTimeMs, this.startTimeMs);
    }

    public TrackEventInfo withParameter(String key, Object value) {
        if (this.eventParameters == null) {
            this.eventParameters = new HashMap();
        }
        this.eventParameters.put(key, value);
        return this;
    }

    public Map<String, Object> getEventParameters() {
        return this.eventParameters;
    }
}
