package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.nearby.zzne;
import com.google.android.gms.internal.nearby.zznj;
import com.google.android.gms.nearby.messages.internal.zzac;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        int i2 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, zzac.CREATOR);
            } else if (fieldId == 2) {
                arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, zznj.CREATOR);
            } else if (fieldId == 3) {
                z = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                arrayList3 = SafeParcelReader.createTypedList(parcel, readHeader, zzne.CREATOR);
            } else if (fieldId == 5) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MessageFilter(i, arrayList, arrayList2, z, arrayList3, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new MessageFilter[i];
    }
}
