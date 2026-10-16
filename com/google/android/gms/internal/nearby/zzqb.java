package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzqb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = -128;
        long j = 0;
        zzpu zzpuVar = null;
        zzpu zzpuVar2 = null;
        zzpu zzpuVar3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                zzpuVar = (zzpu) SafeParcelReader.createParcelable(parcel, readHeader, zzpu.CREATOR);
            } else if (fieldId == 2) {
                zzpuVar2 = (zzpu) SafeParcelReader.createParcelable(parcel, readHeader, zzpu.CREATOR);
            } else if (fieldId == 3) {
                zzpuVar3 = (zzpu) SafeParcelReader.createParcelable(parcel, readHeader, zzpu.CREATOR);
            } else if (fieldId == 4) {
                j = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzqa(zzpuVar, zzpuVar2, zzpuVar3, j, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzqa[i];
    }
}
