package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i = 0;
        int i2 = 0;
        boolean z5 = false;
        boolean z6 = false;
        int i3 = 0;
        int i4 = 0;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        boolean z12 = true;
        boolean z13 = true;
        boolean z14 = true;
        boolean z15 = true;
        boolean z16 = true;
        boolean z17 = true;
        Strategy strategy = null;
        byte[] bArr = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr2 = null;
        zzw[] zzwVarArr = null;
        int[] iArr = null;
        int[] iArr2 = null;
        byte[] bArr3 = null;
        long j = 0;
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
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 7:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                    break;
                case 9:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 14:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 18:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 19:
                    zzwVarArr = (zzw[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzw.CREATOR);
                    break;
                case 20:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 21:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 22:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 23:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 24:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 25:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 26:
                    z16 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 27:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 28:
                    bArr3 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 29:
                    z17 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 30:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AdvertisingOptions(strategy, z7, z8, z9, z10, bArr, z, parcelUuid, z11, z12, z13, z2, z3, z4, i, i2, bArr2, j, zzwVarArr, z5, z14, z6, z15, iArr, iArr2, z16, i3, bArr3, z17, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new AdvertisingOptions[i];
    }
}
