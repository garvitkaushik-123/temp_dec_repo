package io.bidmachine.media3.container;

import io.bidmachine.media3.common.Metadata;
import io.bidmachine.media3.common.util.Util;
import java.util.Arrays;

/* loaded from: classes7.dex */
public final class XmpData implements Metadata.Entry {
    public final byte[] data;

    public XmpData(byte[] bArr) {
        this.data = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.data, ((XmpData) obj).data);
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public String toString() {
        return "XMP: " + Util.toHexString(this.data);
    }
}
