package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int[] iArr = null;
        int[] iArr2 = null;
        int[] iArr3 = null;
        int[] iArr4 = null;
        int[] iArr5 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    iArr3 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    iArr4 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    iArr5 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ExposureConfiguration(i, iArr, i2, iArr2, i3, iArr3, i4, iArr4, i5, iArr5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ExposureConfiguration[i];
    }
}
