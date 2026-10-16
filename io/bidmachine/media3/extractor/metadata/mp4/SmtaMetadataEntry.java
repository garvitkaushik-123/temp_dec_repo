package io.bidmachine.media3.extractor.metadata.mp4;

import com.google.common.primitives.Floats;
import com.ironsource.mediationsdk.logger.IronSourceError;
import io.bidmachine.media3.common.Metadata;

/* loaded from: classes7.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public final float captureFrameRate;
    public final int svcTemporalLayerCount;

    public SmtaMetadataEntry(float f, int i) {
        this.captureFrameRate = f;
        this.svcTemporalLayerCount = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
            if (this.captureFrameRate == smtaMetadataEntry.captureFrameRate && this.svcTemporalLayerCount == smtaMetadataEntry.svcTemporalLayerCount) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Floats.hashCode(this.captureFrameRate)) * 31) + this.svcTemporalLayerCount;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.captureFrameRate + ", svcTemporalLayerCount=" + this.svcTemporalLayerCount;
    }
}
