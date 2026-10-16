package io.bidmachine.media3.extractor.metadata.id3;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class GeobFrame extends Id3Frame {
    public static final String ID = "GEOB";
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (Objects.equals(this.mimeType, geobFrame.mimeType) && Objects.equals(this.filename, geobFrame.filename) && Objects.equals(this.description, geobFrame.description) && Arrays.equals(this.data, geobFrame.data)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.mimeType;
        int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.data);
    }

    @Override // io.bidmachine.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.id + ": mimeType=" + this.mimeType + ", filename=" + this.filename + ", description=" + this.description;
    }
}
