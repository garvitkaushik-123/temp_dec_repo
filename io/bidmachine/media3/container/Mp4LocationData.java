package io.bidmachine.media3.container;

import com.google.common.primitives.Floats;
import com.ironsource.mediationsdk.logger.IronSourceError;
import io.bidmachine.media3.common.Metadata;
import io.bidmachine.media3.common.util.Assertions;

/* loaded from: classes7.dex */
public final class Mp4LocationData implements Metadata.Entry {
    public final float latitude;
    public final float longitude;

    public Mp4LocationData(float f, float f2) {
        Assertions.checkArgument(f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f, "Invalid latitude or longitude");
        this.latitude = f;
        this.longitude = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
            if (this.latitude == mp4LocationData.latitude && this.longitude == mp4LocationData.longitude) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Floats.hashCode(this.latitude)) * 31) + Floats.hashCode(this.longitude);
    }

    public String toString() {
        return "xyz: latitude=" + this.latitude + ", longitude=" + this.longitude;
    }
}
