package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        byte[] bArr = null;
        int[] iArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        Strategy strategy = null;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = true;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 2:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 10:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 16:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 17:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 18:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, readHeader, Strategy.CREATOR);
                    break;
                case 19:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionOptions(z, z3, z4, z5, z6, z7, z8, z9, bArr, z2, z10, z11, i, i2, iArr, iArr2, bArr2, strategy, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionOptions[i];
    }
}
