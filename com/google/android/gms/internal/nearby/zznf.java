package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zznf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                switch (fieldId) {
                    case 4:
                        parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                        break;
                    case 5:
                        parcelUuid2 = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                        break;
                    case 6:
                        parcelUuid3 = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                        break;
                    case 7:
                        bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                        break;
                    case 8:
                        bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                        break;
                    case 9:
                        i2 = SafeParcelReader.readInt(parcel, readHeader);
                        break;
                    case 10:
                        bArr3 = SafeParcelReader.createByteArray(parcel, readHeader);
                        break;
                    case 11:
                        bArr4 = SafeParcelReader.createByteArray(parcel, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        break;
                }
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzne(i, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i2, bArr3, bArr4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzne[i];
    }
}
