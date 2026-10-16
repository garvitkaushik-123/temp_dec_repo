package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        Strategy strategy = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr = null;
        int[] iArr = null;
        long j = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, readHeader, Strategy.CREATOR);
                    break;
                case 2:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                    break;
                case 7:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 8:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 15:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 16:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 17:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DiscoveryOptions(strategy, z7, z, z2, z8, parcelUuid, z3, z4, z5, z9, i, i2, bArr, j, iArr, z6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DiscoveryOptions[i];
    }
}
