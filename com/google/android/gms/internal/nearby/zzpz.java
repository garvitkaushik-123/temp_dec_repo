package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzpz implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        zzqv zzqvVar = null;
        zzrv[] zzrvVarArr = null;
        byte[] bArr2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 4:
                    zzqvVar = (zzqv) SafeParcelReader.createParcelable(parcel, readHeader, zzqv.CREATOR);
                    break;
                case 5:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    zzrvVarArr = (zzrv[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzrv.CREATOR);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzpy(i, i2, bArr, zzqvVar, i3, zzrvVarArr, i4, bArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzpy[i];
    }
}
