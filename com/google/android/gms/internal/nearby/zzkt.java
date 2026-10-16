package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzkt implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        zznv zznvVar = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 6:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 7:
                    bArr3 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    zznvVar = (zznv) SafeParcelReader.createParcelable(parcel, readHeader, zznv.CREATOR);
                    break;
                case 11:
                    zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.nearby.connection.zzk.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzks(str, str2, str3, z, bArr, bArr2, bArr3, z2, i, zznvVar, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzks[i];
    }
}
