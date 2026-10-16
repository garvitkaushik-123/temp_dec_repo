package com.facebook.ads.androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.instagram.common.viewpoint.core.C5C;
import com.instagram.common.viewpoint.core.IA;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public final class ChapterFrame extends Id3Frame {
    public static byte[] A06;
    public static String[] A07 = {"fLRqmQpZ4kY0i8vTWEGOnpMV91ymSlfn", "8zOo15ITF94z8ATPK9WKDS", "U2m4A5dMOqyxzJZNInAoZQNrCqvEIF5h", "0utQ64kMrCSPNyzTtjtqMzChb3", "CvOd0LhZgWbGMd6rhkG6LB2Ont", "e86XCnP3M0yNUM5RfG9bdJbB6V7ObyMi", "fMKUD6KL8xgqbKtIywVViKyqmpaHvM6m", "cPxhgBJDfYBGNL1SVStSmk4ZWA"};
    public static final Parcelable.Creator<ChapterFrame> CREATOR;
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final String A04;
    public final Id3Frame[] A05;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{Base64.padSymbol, 54, 63, 46};
        String[] strArr = A07;
        if (strArr[0].charAt(9) == strArr[6].charAt(9)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[4] = "THHQSJFvR7rYAiXI8hhxNOhOsk";
        strArr2[7] = "DYa1Z8H6Y5FjGQTiVzX1rEZp9S";
    }

    static {
        A01();
        CREATOR = new IA();
    }

    public ChapterFrame(Parcel parcel) {
        super(A00(0, 4, 29));
        this.A04 = (String) C5C.A0f(parcel.readString());
        this.A01 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A03 = parcel.readLong();
        this.A02 = parcel.readLong();
        int readInt = parcel.readInt();
        this.A05 = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.A05[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super(A00(0, 4, 29));
        this.A04 = str;
        this.A01 = i;
        this.A00 = i2;
        this.A03 = j;
        this.A02 = j2;
        this.A05 = id3FrameArr;
    }

    @Override // com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (r3 == r8.A03) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        if (r7.A02 != r8.A02) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0076, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r7.A04, r8.A04) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        if (java.util.Arrays.equals(r7.A05, r8.A05) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        if (r3 == r8.A03) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class<?> cls = getClass();
            Class<?> cls2 = obj.getClass();
            String[] strArr = A07;
            if (strArr[0].charAt(9) == strArr[6].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[0] = "s8Y6al5xLmwNCTuxrrlilvhunCZyPKQu";
            strArr2[6] = "F4gClNwWGLEb8yuG5kUUO5qerkap3WyM";
            if (cls == cls2) {
                ChapterFrame chapterFrame = (ChapterFrame) obj;
                if (this.A01 == chapterFrame.A01 && this.A00 == chapterFrame.A00) {
                    long j = this.A03;
                    String[] strArr3 = A07;
                    if (strArr3[3].length() != strArr3[1].length()) {
                        String[] strArr4 = A07;
                        strArr4[0] = "YA00N3sF1UOtj77WS52yNrONrVf9FOsb";
                        strArr4[6] = "phjHurmqkrzRpPO24UEXTTCj8ILagfx7";
                    } else {
                        String[] strArr5 = A07;
                        strArr5[0] = "1cJSCMaKjmRDGa6IqnZMgyepuwbb5Zyk";
                        strArr5[6] = "77QMpsyCXr9jCYPeO8IlygJc3WcEupIe";
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        int i = ((((17 * 31) + result) * 31) + this.A00) * 31;
        int result2 = (int) this.A03;
        int result3 = (((i + result2) * 31) + ((int) this.A02)) * 31;
        int result4 = this.A04 != null ? this.A04.hashCode() : 0;
        return result3 + result4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.A04);
        parcel.writeInt(this.A01);
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A03);
        parcel.writeLong(this.A02);
        parcel.writeInt(this.A05.length);
        for (Id3Frame id3Frame : this.A05) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
