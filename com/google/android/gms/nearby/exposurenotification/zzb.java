package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d = 0.0d;
        int i = 0;
        ArrayList<Double> arrayList = null;
        ArrayList<Double> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        ArrayList<Double> arrayList4 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    arrayList = SafeParcelReader.createDoubleList(parcel, readHeader);
                    break;
                case 2:
                    arrayList2 = SafeParcelReader.createDoubleList(parcel, readHeader);
                    break;
                case 3:
                    arrayList3 = SafeParcelReader.createIntegerList(parcel, readHeader);
                    break;
                case 4:
                    arrayList4 = SafeParcelReader.createDoubleList(parcel, readHeader);
                    break;
                case 5:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    d = SafeParcelReader.readDouble(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DailySummariesConfig(arrayList, arrayList2, arrayList3, arrayList4, i, d);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new DailySummariesConfig[i];
    }
}
