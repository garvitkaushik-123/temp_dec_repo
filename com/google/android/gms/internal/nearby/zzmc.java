package com.google.android.gms.internal.nearby;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.5.0 */
/* loaded from: classes5.dex */
public final class zzmc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        Uri uri = null;
        zzlx zzlxVar = null;
        String str2 = null;
        String str3 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        boolean z = false;
        long j4 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    j = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 2:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, readHeader, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) SafeParcelReader.createParcelable(parcel, readHeader, ParcelFileDescriptor.CREATOR);
                    break;
                case 8:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                case 9:
                    j2 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    zzlxVar = (zzlx) SafeParcelReader.createParcelable(parcel, readHeader, zzlx.CREATOR);
                    break;
                case 12:
                    j3 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 13:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 14:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzmb(j, i, bArr, parcelFileDescriptor, str, j4, parcelFileDescriptor2, uri, j2, z, zzlxVar, j3, str2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmb[i];
    }
}
