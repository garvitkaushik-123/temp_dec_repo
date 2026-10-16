package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Ascii;
import com.instagram.common.viewpoint.core.C5C;
import com.instagram.common.viewpoint.core.ID;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class GeobFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05 = {"ORThrcUDJ8oSWKnVQcP1uIGpcR", "uxmFmJC1LwPq1ifvsUVY6A58XUxn", "tgzXw0", "3YcwGpAqsC36LlJyS", "bWi6NBg7EuEHzXqjFfskJtL267SBWFe", "P49DRZyRWhn5lVJGsfOn1rO7sNGr7nlu", "aaseJjWnl2zrNSL329JSGdGKj2FyDGUc", "EYKDzopnaqy6"};
    public static final Parcelable.Creator<GeobFrame> CREATOR;
    public final String A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A05[4].length() == 15) {
                throw new RuntimeException();
            }
            A05[1] = "xm9FRjRm82kK4gS3u270gaYNqume";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 80);
            i4++;
        }
    }

    public static void A01() {
        A04 = new byte[]{92, 80, Ascii.DC4, Ascii.NAK, 3, 19, 2, Ascii.EM, 0, 4, Ascii.EM, Ascii.US, Ascii.RS, 77, 117, 121, 63, 48, 53, 60, 55, 56, 52, 60, 100, 78, 84, Ascii.EM, Ascii.GS, Ascii.EM, 17, 32, Ascii.CR, 4, 17, 73, 60, 62, 52, 57};
    }

    static {
        A01();
        CREATOR = new ID();
    }

    public GeobFrame(Parcel parcel) {
        super(A00(36, 4, 43));
        this.A02 = (String) C5C.A0f(parcel.readString());
        this.A01 = (String) C5C.A0f(parcel.readString());
        this.A00 = (String) C5C.A0f(parcel.readString());
        this.A03 = (byte[]) C5C.A0f(parcel.createByteArray());
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(A00(36, 4, 43));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A03 = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        if (C5C.A1E(this.A02, geobFrame.A02) && C5C.A1E(this.A01, geobFrame.A01)) {
            String str = this.A00;
            String str2 = geobFrame.A00;
            if (A05[4].length() == 15) {
                throw new RuntimeException();
            }
            A05[1] = "HEIn71RMT8F4EhFByQAG1BwlOeNZ";
            if (C5C.A1E(str, str2) && Arrays.equals(this.A03, geobFrame.A03)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
    
        if (r6.A00 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
    
        r3 = r6.A00;
        r2 = com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05;
        r1 = r2[2];
        r0 = r2[0];
        r1 = r1.length();
        r0 = r0.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
    
        if (r1 == r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0066, code lost:
    
        com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05[3] = "kmHBQ6UCcTgjP77v2ijZb3Aa";
        r5 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
    
        com.facebook.ads.androidx.media3.extractor.metadata.id3.GeobFrame.A05[7] = "wEfpGayZOaM";
        r5 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        r1 = (r4 + r5) * 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        return r1 + java.util.Arrays.hashCode(r6.A03);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
    
        if (r6.A00 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int hashCode() {
        int result;
        int i = 17 * 31;
        int i2 = 0;
        if (this.A02 != null) {
            String str = this.A02;
            if (A05[1].length() != 28) {
                throw new RuntimeException();
            }
            A05[7] = "jAIu8v1143XL";
            result = str.hashCode();
        } else {
            result = 0;
        }
        int result2 = (i + result) * 31;
        int result3 = this.A01 != null ? this.A01.hashCode() : 0;
        int i3 = (result2 + result3) * 31;
        if (A05[3].length() != 7) {
            A05[3] = "5ETNk8FDhPWD3cLm";
        }
    }

    @Override // com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(25, 11, 36) + this.A02 + A00(14, 11, 9) + this.A01 + A00(0, 14, 32) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A03);
    }
}
