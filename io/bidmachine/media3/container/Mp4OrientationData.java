package io.bidmachine.media3.container;

import com.ironsource.mediationsdk.logger.IronSourceError;
import io.bidmachine.media3.common.Metadata;
import io.bidmachine.media3.common.util.Assertions;

/* loaded from: classes7.dex */
public final class Mp4OrientationData implements Metadata.Entry {
    public final int orientation;

    public Mp4OrientationData(int i) {
        Assertions.checkArgument(i == 0 || i == 90 || i == 180 || i == 270, "Unsupported orientation");
        this.orientation = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mp4OrientationData) && this.orientation == ((Mp4OrientationData) obj).orientation;
    }

    public int hashCode() {
        return IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Integer.hashCode(this.orientation);
    }

    public String toString() {
        return "Orientation= " + this.orientation;
    }
}
