package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzll implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        PayloadTransferUpdate payloadTransferUpdate = null;
        zznv zznvVar = null;
        com.google.android.gms.nearby.connection.zzk zzkVar = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                payloadTransferUpdate = (PayloadTransferUpdate) SafeParcelReader.createParcelable(parcel, readHeader, PayloadTransferUpdate.CREATOR);
            } else if (fieldId == 3) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 4) {
                zznvVar = (zznv) SafeParcelReader.createParcelable(parcel, readHeader, zznv.CREATOR);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzkVar = (com.google.android.gms.nearby.connection.zzk) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.nearby.connection.zzk.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzlk(str, payloadTransferUpdate, i, zznvVar, zzkVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzlk[i];
    }
}
