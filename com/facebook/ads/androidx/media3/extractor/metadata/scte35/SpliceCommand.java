package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.google.common.base.Ascii;
import com.instagram.common.viewpoint.core.C2489qI;
import com.instagram.common.viewpoint.core.C3E;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 88);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{54, 38, 49, 32, 72, 86, 80, 69, Ascii.SYN, Ascii.NAK, 9, Ascii.FF, 6, 0, 69, 6, 10, 8, 8, 4, Ascii.VT, 1, 95, 69, 17, Ascii.FS, Ascii.NAK, 0, 88};
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ byte[] A9a() {
        return C3E.A01(this);
    }

    @Override // com.facebook.ads.androidx.media3.common.Metadata.Entry
    public final /* synthetic */ C2489qI A9b() {
        return C3E.A00(this);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return A02(0, 29, 61) + getClass().getSimpleName();
    }
}
