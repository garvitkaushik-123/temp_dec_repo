package com.facebook.ads.androidx.media3.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.instagram.common.viewpoint.core.AnonymousClass23;
import com.instagram.common.viewpoint.core.AnonymousClass24;
import com.instagram.common.viewpoint.core.C06672a;
import com.instagram.common.viewpoint.core.C5C;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.checkerframework.dataflow.qual.Pure;

/* loaded from: assets/audience_network/classes2.dex */
public final class ColorInfo implements AnonymousClass24, Parcelable {
    public static byte[] A05;
    public static String[] A06 = {"fwssHt7wmjS4irtBHVgHRy1kfHVI1fy3", "Eontljbnef3w1ZNyXpqY7w", "WqOEcdnYiI", "OC7aOsM7dG7kZGpbfVwzqO", "jKxxMaD7lr6ZikoqJ8VvarFUhz7fi6dh", "IxIxrmcLCYn92mmubnPuZ", "k8ZHYUrndjPkyYjbitUMWCOJyy2ruKg", "BYcVzsGm3P4KW5EWFDHzj0wXk7JiqRGv"};
    public static final Parcelable.Creator<ColorInfo> A07;
    public static final AnonymousClass23<ColorInfo> A08;
    public static final ColorInfo A09;
    public static final ColorInfo A0A;
    public int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final byte[] A04;

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A06[7].charAt(5) != 's') {
                throw new RuntimeException();
            }
            A06[2] = "3J0fS2w4pJ";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            byte b = (byte) ((copyOfRange[i4] ^ i3) ^ 90);
            if (A06[2].length() != 10) {
                A06[4] = "NZQ27YGgzUvTQnYJbnO7KrKPnOKajcu0";
                copyOfRange[i4] = b;
                i4 += 0;
            } else {
                String[] strArr = A06;
                strArr[3] = "apS4Da1AN2CX9NcLFevAWz";
                strArr[1] = "J8xda0JkxA2JO9OskXZrhx";
                copyOfRange[i4] = b;
                i4++;
            }
        }
    }

    public static void A08() {
        A05 = new byte[]{49, 97, 109, 59, 45, 75, 73, 75, 73, 59, 45, 79, 73, 72, 62, 40, 75, 76, 69, 32, Ascii.FF, Ascii.SI, Ascii.FF, 17, 42, Ascii.CR, 5, Ascii.FF, 75, Ascii.CR, 62, 39, 39, 107, 57, 42, 37, 44, 46, 71, 97, 109, 109, 97, 32, 50, 46, 50, 42, 46, 37, 122, 95, 91, 95, 66, 83, 82, Ascii.SYN, 68, 87, 88, 81, 83, 92, 121, 126, 117, 113, 98, 83, 68, 82, 32, 83, 77, 80, 84, 69, 32, 49, 55, 48, 77, 39, 32, 70, 68, 76, SignedBytes.MAX_POWER_OF_TWO, 84, 36, 37, 74, 113, 123, 122, 121, 118, 113, 122, 123, 63, 124, 112, 115, 112, 109, 63, 109, 126, 113, 120, 122, 121, 66, 72, 73, 74, 69, 66, 73, 72, Ascii.FF, 79, 67, SignedBytes.MAX_POWER_OF_TWO, 67, 94, Ascii.FF, 95, 92, 77, 79, 73, 47, Ascii.DC4, Ascii.RS, Ascii.US, Ascii.FS, 19, Ascii.DC4, Ascii.US, Ascii.RS, 90, Ascii.EM, Ascii.NAK, Ascii.SYN, Ascii.NAK, 8, 90, Ascii.SO, 8, Ascii.ESC, Ascii.DC4, 9, Ascii.FS, Ascii.US, 8, 9, 50, 47, 57, 40, 124, 63, 51, 48, 51, 46, 124, 46, Base64.padSymbol, 50, 59, 57, 90, 97, 124, 106, 123, 47, 108, 96, 99, 96, 125, 47, 124, Byte.MAX_VALUE, 110, 108, 106, 58, 1, Ascii.FS, 10, Ascii.ESC, 79, Ascii.FF, 0, 3, 0, Ascii.GS, 79, Ascii.ESC, Ascii.GS, Ascii.SO, 1, Ascii.FS, 9, 10, Ascii.GS, 1, 32, 53, 48};
    }

    static {
        A08();
        A09 = new ColorInfo(1, 2, 3, null);
        A0A = new C06672a().A01(1).A00(1).A02(2).A03();
        A07 = new Parcelable.Creator<ColorInfo>() { // from class: com.facebook.ads.redexgen.X.2Z
            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final ColorInfo createFromParcel(Parcel parcel) {
                return new ColorInfo(parcel);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final ColorInfo[] newArray(int i) {
                return new ColorInfo[i];
            }
        };
        A08 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qO
            @Override // com.instagram.common.viewpoint.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                return ColorInfo.A02(bundle);
            }
        };
    }

    public ColorInfo(int i, int i2, int i3, byte[] bArr) {
        this.A02 = i;
        this.A01 = i2;
        this.A03 = i3;
        this.A04 = bArr;
    }

    public ColorInfo(Parcel parcel) {
        this.A02 = parcel.readInt();
        this.A01 = parcel.readInt();
        this.A03 = parcel.readInt();
        boolean hasHdrStaticInfo = C5C.A1C(parcel);
        this.A04 = hasHdrStaticInfo ? parcel.createByteArray() : null;
    }

    @Pure
    public static int A00(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
            case 3:
            case 8:
            default:
                return -1;
            case 4:
            case 5:
            case 6:
            case 7:
                return 2;
            case 9:
                return 6;
        }
    }

    @Pure
    public static int A01(int i) {
        switch (i) {
            case 1:
            case 6:
            case 7:
                return 3;
            case 4:
                return 10;
            case 13:
                String[] strArr = A06;
                if (strArr[3].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                A06[4] = "iITQwSOY6G69yL4zBCgmbr9Ezk0yNeSE";
                return 2;
            case 16:
                return 6;
            case 18:
                return 7;
            default:
                return -1;
        }
    }

    public static /* synthetic */ ColorInfo A02(Bundle bundle) {
        return new ColorInfo(bundle.getInt(A06(0), -1), bundle.getInt(A06(1), -1), bundle.getInt(A06(2), -1), bundle.getByteArray(A06(3)));
    }

    public static String A03(int i) {
        switch (i) {
            case -1:
                return A07(159, 17, 6);
            case 0:
            default:
                if (A06[7].charAt(5) != 's') {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[6] = "vjIO54OW5kLbXJOIktKSO2lZwe9uVoS";
                strArr[5] = "lPZMw6sIoJTf8tamb5XBd";
                return A07(93, 21, 69);
            case 1:
                return A07(29, 10, 17);
            case 2:
                return A07(51, 13, 108);
        }
    }

    public static String A04(int i) {
        switch (i) {
            case -1:
                return A07(176, 17, 85);
            case 0:
            case 3:
            case 4:
            case 5:
            default:
                return A07(114, 21, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
            case 1:
                return A07(14, 5, 38);
            case 2:
                return A07(9, 5, 35);
            case 6:
                return A07(3, 6, 35);
        }
    }

    public static String A05(int i) {
        switch (i) {
            case -1:
                return A07(193, 20, 53);
            case 0:
            case 4:
            case 5:
            case 8:
            case 9:
            default:
                return A07(135, 24, 32);
            case 1:
                return A07(64, 6, 74);
            case 2:
                if (A06[4].charAt(21) != 'r') {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[6] = "Bpd0ZivgAzgpSLL99gZnlOGn3AZ7ySo";
                strArr[5] = "Ie1ERw9CGiz8VQ2Le8mIF";
                return A07(Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 4, 40);
            case 3:
                return A07(70, 14, 90);
            case 6:
                return A07(84, 9, 46);
            case 7:
                return A07(48, 3, 56);
            case 10:
                return A07(39, 9, 90);
        }
    }

    public static String A06(int i) {
        return Integer.toString(i, 36);
    }

    public static boolean A09(ColorInfo colorInfo) {
        return colorInfo != null && (colorInfo.A03 == 7 || colorInfo.A03 == 6);
    }

    public final C06672a A0A() {
        return new C06672a(this);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.A02 == colorInfo.A02 && this.A01 == colorInfo.A01 && this.A03 == colorInfo.A03 && Arrays.equals(this.A04, colorInfo.A04)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int result = this.A02;
            int result2 = ((((17 * 31) + result) * 31) + this.A01) * 31;
            int result3 = this.A03;
            this.A00 = ((result2 + result3) * 31) + Arrays.hashCode(this.A04);
        }
        int result4 = this.A00;
        return result4;
    }

    public final String toString() {
        StringBuilder append = new StringBuilder().append(A07(19, 10, 57)).append(A04(this.A02));
        String A072 = A07(1, 2, 23);
        return append.append(A072).append(A03(this.A01)).append(A072).append(A05(this.A03)).append(A072).append(this.A04 != null).append(A07(0, 1, 66)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A01);
        parcel.writeInt(this.A03);
        C5C.A0w(parcel, this.A04 != null);
        if (this.A04 != null) {
            parcel.writeByteArray(this.A04);
        }
    }
}
